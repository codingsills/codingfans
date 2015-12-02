<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp"%>
<html>
<head>
<%@ include file="common.jsp" %>
<script src="${ctx}/static/bootstrap/metisMenu/metisMenu.min.js" type="text/javascript" ></script>
<script src="${ctx}/static/common/js/jquery.slimscroll.min.js" type="text/javascript" ></script>
<script src="${ctx}/static/common/js/pace.min.js" type="text/javascript" ></script>
<script src="${ctx}/static/common/js/inspinia.js" type="text/javascript" ></script>
<title>M+主页</title>
</head>

<body>
    <div id="wrapper">
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav metismenu" id="side-menu">
                    <li class="nav-header">
                        <div class="dropdown profile-element"> <span>
                            <img alt="image" class="img-circle" src="${ctx}/static/images/profile_small.jpg" />
                             </span>
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">二十四桥</strong>
                             </span> <span class="text-muted text-xs block">超级管理员 <b class="caret"></b></span> </span> </a>
                            <ul class="dropdown-menu animated fadeInRight m-t-xs">
                            	<li><a href="#">修改头像</a></li>
                                <li><a href="#">个人资料</a></li>
                                <li><a href="#">联系我们</a></li>
                                <li><a href="#">信箱</a></li>
                                <li class="divider"></li>
                                <li><a href="#">安全退出</a></li>
                            </ul>
                        </div>
                        <div class="logo-element">
                            M+
                        </div>
                    </li>
                    <c:forEach var="menu" items="${menus[0].nodes}">
                    	<li <c:if test="${menu.selectable == 'T'}">class="active"</c:if>>
                    		<a href="#"><i class="${menu.icon}"></i> <span class="nav-label">${menu.text}</span> <span class="fa arrow"></span></a>
                    		<c:if test="${menu.nodes != null}" >
                    			<ul class="nav nav-second-level collapse">
                    				<c:forEach var="child" items="${menu.nodes}">
                    					<li <c:if test="${child.selectable == 'T'}">class="active"</c:if>><a href="${ctx}${child.href}" target="iframe0"><i class="${child.icon}"></i>&nbsp;${child.text}</a></li>
                    				</c:forEach>
                    			</ul>
                    		</c:if>
                    	
                    </c:forEach>
                </ul>
            </div>
        </nav>

        <div id="page-wrapper" class="gray-bg">
	        <div class="row border-bottom">
		        <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
			        <div class="navbar-header">
			            <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
			        </div>
		            <ul class="nav navbar-top-links navbar-right">
		                <li>
		                    <a href="login.html">
		                        <i class="fa fa-sign-out"></i>退出
		                    </a>
		                </li>
		                <li>
		                    <a class="right-sidebar-toggle">
		                        <i class="fa fa-tasks"></i>主题
		                    </a>
		                </li>
		            </ul>
		        </nav>
	        </div>
	        <div class="row border-bottom white-bg dashboard-header">
	        	<iframe id="main_frame" name="iframe0" width="100%" src="${ctx}/user/list.action" frameborder="0" seamless></iframe>
	        </div>
           <div class="footer">
               <div class="pull-right">
                   <strong>Copyright</strong> MPLUS Company &copy; 2014-2015
               </div>
           </div>
        </div>
        <!-- 右侧边栏开始 -->
		<div id="right-sidebar">
            <div class="sidebar-container">

                <ul class="nav nav-tabs navs-3">

                    <li class="active">
                        <a data-toggle="tab" href="#tab-1">
                            <i class="fa fa-gear"></i> 主题
                        </a>
                    </li>
                </ul>

                <div class="tab-content">
                    <div id="tab-1" class="tab-pane active">
                        <div class="sidebar-title">
                            <h3> <i class="fa fa-comments-o"></i> 主题设置</h3>
                            <small><i class="fa fa-tim"></i> 你可以从这里选择和预览主题的布局和样式，这些设置会被保存在本地，下次打开的时候会直接应用这些设置。</small>
                        </div>
                        <div class="skin-setttings">
                            <div class="title">主题设置</div>
                            <div class="setings-item">
                                <span>收起左侧菜单</span>
                                <div class="switch">
                                    <div class="onoffswitch">
                                        <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="collapsemenu">
                                        <label class="onoffswitch-label" for="collapsemenu">
                                            <span class="onoffswitch-inner"></span>
                                            <span class="onoffswitch-switch"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="setings-item">
                                <span>固定顶部</span>

                                <div class="switch">
                                    <div class="onoffswitch">
                                        <input type="checkbox" name="fixednavbar" class="onoffswitch-checkbox" id="fixednavbar">
                                        <label class="onoffswitch-label" for="fixednavbar">
                                            <span class="onoffswitch-inner"></span>
                                            <span class="onoffswitch-switch"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="setings-item">
                                <span>固定宽度</span>

                                <div class="switch">
                                    <div class="onoffswitch">
                                        <input type="checkbox" name="boxedlayout" class="onoffswitch-checkbox" id="boxedlayout">
                                        <label class="onoffswitch-label" for="boxedlayout">
                                            <span class="onoffswitch-inner"></span>
                                            <span class="onoffswitch-switch"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="setings-item">
				                <span>固定侧边栏</span>
				
				                <div class="switch">
				                    <div class="onoffswitch">
				                        <input type="checkbox" name="fixedsidebar" class="onoffswitch-checkbox" id="fixedsidebar">
				                        <label class="onoffswitch-label" for="fixedsidebar">
				                            <span class="onoffswitch-inner"></span>
				                            <span class="onoffswitch-switch"></span>
				                        </label>
				                    </div>
				                </div>
				            </div>
				            <div class="setings-item">
				                <span>固定底部</span>
				
				                <div class="switch">
				                    <div class="onoffswitch">
				                        <input type="checkbox" name="fixedfooter" class="onoffswitch-checkbox" id="fixedfooter">
				                        <label class="onoffswitch-label" for="fixedfooter">
				                            <span class="onoffswitch-inner"></span>
				                            <span class="onoffswitch-switch"></span>
				                        </label>
				                    </div>
				                </div>
				            </div>
                            <div class="title">皮肤选择</div>
                            <div class="setings-item default-skin nb">
                                <span class="skin-name ">
                         <a href="#" class="s-skin-0">
                             	默认皮肤
                         </a>
                    </span>
                            </div>
                            <div class="setings-item blue-skin nb">
                            <span class="skin-name ">
		                        <a href="#" class="s-skin-1">
		                            	蓝色主题
		                        </a>
		                    </span>
                            </div>
                            <div class="setings-item yellow-skin nb">
                                <span class="skin-name ">
		                        <a href="#" class="s-skin-3">
		                           	 黄色/紫色主题
		                        </a>
		                    </span>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <!--右侧边栏结束-->
<script>
    // Config box

    // Enable/disable fixed top navbar
    $('#fixednavbar').click(function () {
        if ($('#fixednavbar').is(':checked')) {
            $(".navbar-static-top").removeClass('navbar-static-top').addClass('navbar-fixed-top');
            $("body").removeClass('boxed-layout');
            $("body").addClass('fixed-nav');
            $('#boxedlayout').prop('checked', false);

            if (localStorageSupport) {
                localStorage.setItem("boxedlayout",'off');
            }

            if (localStorageSupport) {
                localStorage.setItem("fixednavbar",'on');
            }
        } else {
            $(".navbar-fixed-top").removeClass('navbar-fixed-top').addClass('navbar-static-top');
            $("body").removeClass('fixed-nav');

            if (localStorageSupport) {
                localStorage.setItem("fixednavbar",'off');
            }
        }
    });

    // Enable/disable fixed sidebar
    $('#fixedsidebar').click(function () {
        if ($('#fixedsidebar').is(':checked')) {
            $("body").addClass('fixed-sidebar');
            $('.sidebar-collapse').slimScroll({
                height: '100%',
                railOpacity: 0.9
            });

            if (localStorageSupport) {
                localStorage.setItem("fixedsidebar",'on');
            }
        } else {
            $('.sidebar-collapse').slimscroll({destroy: true});
            $('.sidebar-collapse').attr('style', '');
            $("body").removeClass('fixed-sidebar');

            if (localStorageSupport) {
                localStorage.setItem("fixedsidebar",'off');
            }
        }
    });

    // Enable/disable collapse menu
    $('#collapsemenu').click(function () {
        if ($('#collapsemenu').is(':checked')) {
            $("body").addClass('mini-navbar');
            SmoothlyMenu();

            if (localStorageSupport) {
                localStorage.setItem("collapse_menu",'on');
            }

        } else {
            $("body").removeClass('mini-navbar');
            SmoothlyMenu();

            if (localStorageSupport) {
                localStorage.setItem("collapse_menu",'off');
            }
        }
    });

    // Enable/disable boxed layout
    $('#boxedlayout').click(function () {
        if ($('#boxedlayout').is(':checked')) {
            $("body").addClass('boxed-layout');
            $('#fixednavbar').prop('checked', false);
            $(".navbar-fixed-top").removeClass('navbar-fixed-top').addClass('navbar-static-top');
            $("body").removeClass('fixed-nav');
            $(".footer").removeClass('fixed');
            $('#fixedfooter').prop('checked', false);

            if (localStorageSupport) {
                localStorage.setItem("fixednavbar",'off');
            }

            if (localStorageSupport) {
                localStorage.setItem("fixedfooter",'off');
            }


            if (localStorageSupport) {
                localStorage.setItem("boxedlayout",'on');
            }
        } else {
            $("body").removeClass('boxed-layout');

            if (localStorageSupport) {
                localStorage.setItem("boxedlayout",'off');
            }
        }
    });

    // Enable/disable fixed footer
    $('#fixedfooter').click(function () {
        if ($('#fixedfooter').is(':checked')) {
            $('#boxedlayout').prop('checked', false);
            $("body").removeClass('boxed-layout');
            $(".footer").addClass('fixed');

            if (localStorageSupport) {
                localStorage.setItem("boxedlayout",'off');
            }

            if (localStorageSupport) {
                localStorage.setItem("fixedfooter",'on');
            }
        } else {
            $(".footer").removeClass('fixed');

            if (localStorageSupport) {
                localStorage.setItem("fixedfooter",'off');
            }
        }
    });

    // Default skin
    $('.s-skin-0').click(function () {
        $("body").removeClass("skin-1");
        $("body").removeClass("skin-2");
        $("body").removeClass("skin-3");
    });

    // Blue skin
    $('.s-skin-1').click(function () {
        $("body").removeClass("skin-2");
        $("body").removeClass("skin-3");
        $("body").addClass("skin-1");
    });

    // Inspinia ultra skin
    $('.s-skin-2').click(function () {
        $("body").removeClass("skin-1");
        $("body").removeClass("skin-3");
        $("body").addClass("skin-2");
    });

    // Yellow skin
    $('.s-skin-3').click(function () {
        $("body").removeClass("skin-1");
        $("body").removeClass("skin-2");
        $("body").addClass("skin-3");
    });

    if (localStorageSupport) {
        var collapse = localStorage.getItem("collapse_menu");
        var fixedsidebar = localStorage.getItem("fixedsidebar");
        var fixednavbar = localStorage.getItem("fixednavbar");
        var boxedlayout = localStorage.getItem("boxedlayout");
        var fixedfooter = localStorage.getItem("fixedfooter");

        if (collapse == 'on') {
            $('#collapsemenu').prop('checked','checked')
        }
        if (fixedsidebar == 'on') {
            $('#fixedsidebar').prop('checked','checked')
        }
        if (fixednavbar == 'on') {
            $('#fixednavbar').prop('checked','checked')
        }
        if (boxedlayout == 'on') {
            $('#boxedlayout').prop('checked','checked')
        }
        if (fixedfooter == 'on') {
            $('#fixedfooter').prop('checked','checked')
        }
    }
</script>
</body>
</html>
