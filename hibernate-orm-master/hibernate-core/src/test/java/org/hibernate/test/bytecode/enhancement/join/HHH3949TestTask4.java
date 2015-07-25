package org.hibernate.test.bytecode.enhancement.join;

import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.Session;

import org.junit.Assert;

public class HHH3949TestTask4 extends AbstractHHH3949TestTask {

	@SuppressWarnings("unchecked")
	public void execute() {
		Session session = getFactory().openSession();
		List<Vehicle> vehicles = (List<Vehicle>) session.createCriteria( Vehicle.class )
				.setFetchMode( "driver", FetchMode.JOIN )
				.list();
		session.close();

		for ( Vehicle vehicle : vehicles ) {
			if ( vehicle.getId() < 3 ) {
				Assert.assertNotNull( vehicle.getDriver() );
				Assert.assertNotNull( vehicle.getDriver().getVehicle() );
			}
		}
	}

}
