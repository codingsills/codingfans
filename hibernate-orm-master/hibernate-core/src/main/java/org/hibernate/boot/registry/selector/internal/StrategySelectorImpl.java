/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.boot.registry.selector.internal;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.hibernate.boot.registry.classloading.spi.ClassLoadingException;
import org.hibernate.boot.registry.selector.spi.StrategySelectionException;
import org.hibernate.boot.registry.selector.spi.StrategySelector;

import org.jboss.logging.Logger;

/**
 * Standard implementation of the StrategySelector contract.
 *
 * @author Steve Ebersole
 */
public class StrategySelectorImpl implements StrategySelector {
	private static final Logger log = Logger.getLogger( StrategySelectorImpl.class );

	private final Map<Class,Map<String,Class>> namedStrategyImplementorByStrategyMap
			= new ConcurrentHashMap<Class, Map<String, Class>>();

	private final ClassLoaderService classLoaderService;

	/**
	 * Constructs a StrategySelectorImpl using the given class loader service.
	 *
	 * @param classLoaderService The class loader service usable by this StrategySelectorImpl instance.
	 */
	public StrategySelectorImpl(ClassLoaderService classLoaderService) {
		this.classLoaderService = classLoaderService;
	}

	@Override
	public <T> void registerStrategyImplementor(Class<T> strategy, String name, Class<? extends T> implementation) {
		Map<String,Class> namedStrategyImplementorMap = namedStrategyImplementorByStrategyMap.get( strategy );
		if ( namedStrategyImplementorMap == null ) {
			namedStrategyImplementorMap = new ConcurrentHashMap<String, Class>();
			namedStrategyImplementorByStrategyMap.put( strategy, namedStrategyImplementorMap );
		}

		final Class old = namedStrategyImplementorMap.put( name, implementation );
		if ( old == null ) {
			log.trace(
					String.format(
							"Registering named strategy selector [%s] : [%s] -> [%s]",
							strategy.getName(),
							name,
							implementation.getName()
					)
			);
		}
		else {
			log.debug(
					String.format(
							"Registering named strategy selector [%s] : [%s] -> [%s] (replacing [%s])",
							strategy.getName(),
							name,
							implementation.getName(),
							old.getName()
					)
			);
		}
	}

	@Override
	public <T> void unRegisterStrategyImplementor(Class<T> strategy, Class<? extends T> implementation) {
		final Map<String,Class> namedStrategyImplementorMap = namedStrategyImplementorByStrategyMap.get( strategy );
		if ( namedStrategyImplementorMap == null ) {
			log.debug( "Named strategy map did not exist on call to un-register" );
			return;
		}

		final Iterator itr = namedStrategyImplementorMap.values().iterator();
		while ( itr.hasNext() ) {
			final Class registered = (Class) itr.next();
			if ( registered.equals( implementation ) ) {
				itr.remove();
			}
		}

		// try tp clean up after ourselves...
		if ( namedStrategyImplementorMap.isEmpty() ) {
			namedStrategyImplementorByStrategyMap.remove( strategy );
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> Class<? extends T> selectStrategyImplementor(Class<T> strategy, String name) {
		final Map<String,Class> namedStrategyImplementorMap = namedStrategyImplementorByStrategyMap.get( strategy );
		if ( namedStrategyImplementorMap != null ) {
			final Class registered = namedStrategyImplementorMap.get( name );
			if ( registered != null ) {
				return (Class<T>) registered;
			}
		}

		try {
			return classLoaderService.classForName( name );
		}
		catch (ClassLoadingException e) {
			throw new StrategySelectionException(
					"Unable to resolve name [" + name + "] as strategy [" + strategy.getName() + "]"
			);
		}
	}

	@Override
	public <T> T resolveStrategy(Class<T> strategy, Object strategyReference) {
		return resolveDefaultableStrategy( strategy, strategyReference, null );
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T resolveDefaultableStrategy(Class<T> strategy, Object strategyReference, T defaultValue) {
		if ( strategyReference == null ) {
			return defaultValue;
		}

		if ( strategy.isInstance( strategyReference ) ) {
			return strategy.cast( strategyReference );
		}

		final Class<? extends T> implementationClass;
		if ( Class.class.isInstance( strategyReference ) ) {
			implementationClass = (Class<T>) strategyReference;
		}
		else {
			implementationClass = selectStrategyImplementor( strategy, strategyReference.toString() );
		}

		try {
			return implementationClass.newInstance();
		}
		catch (Exception e) {
			throw new StrategySelectionException(
					String.format( "Could not instantiate named strategy class [%s]", implementationClass.getName() ),
					e
			);
		}
	}
}
