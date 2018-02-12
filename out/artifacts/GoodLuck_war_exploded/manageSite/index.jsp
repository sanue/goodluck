<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.logistics.bean.Statistics" %>
<!DOCTYPE html>
<html lang="en">
<head>	
	<!-- start: Meta -->
	<meta charset="utf-8">
	<title>好运多物流平台管理系统</title>
	<meta name="description" content="Bootstrap Metro Dashboard">
	<meta name="author" content="Dennis Ji">
	<meta name="keyword" content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	<!-- end: Meta -->
	<!-- start: Mobile Specific -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- end: Mobile Specific -->
	<!-- start: CSS -->
	<link id="bootstrap-style" href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
    <link id="base-style-responsive" href="css/style-responsive.css" rel="stylesheet">
	<link id="base-style" href="css/style.css" rel="stylesheet">
	<link  href="css/window.css" rel="stylesheet">
	<!-- end: CSS -->
	<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	  	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<link id="ie-style" href="css/ie.css" rel="stylesheet">
	<![endif]-->
	
	<!--[if IE 9]>
		<link id="ie9style" href="css/ie9.css" rel="stylesheet">
	<![endif]-->
		
	<!-- start: Favicon -->
	<link rel="shortcut icon" href="img/favicon.ico">
	<!-- end: Favicon -->
</head>

<body>
<%
    request.setCharacterEncoding("utf-8");
    //车主信息
    Statistics statistics1=(Statistics)request.getAttribute("statistics1");
    //车源信息
    Statistics statistics2=(Statistics)request.getAttribute("statistics2");
    //货主信息
    Statistics statistics3=(Statistics)request.getAttribute("statistics3");
    //货源信息
    Statistics statistics4=(Statistics)request.getAttribute("statistics4");
    //车主信息审核数量
    Statistics statistics5=(Statistics)request.getAttribute("statistics5");
    //货主信息审核数量
    Statistics statistics6=(Statistics)request.getAttribute("statistics6");
    //车型类型数量
    Statistics statistics7=(Statistics)request.getAttribute("statistics7");
    //车长类型数量
    Statistics statistics8=(Statistics)request.getAttribute("statistics8");
    //车厢类型数量
    Statistics statistics9=(Statistics)request.getAttribute("statistics9");
    //新闻数量
    Statistics statistics10=(Statistics)request.getAttribute("statistics10");
%>
		<%@ include file="inc/header.jsp"  %>
		<div class="container-fluid-full">
		<div class="row-fluid">
		
		<%@ include file="inc/left.jsp"  %>		
			<!-- start: Content -->
			<div id="content" class="span10">	 		
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i>
					<a href="index.html">主页</a> 
					<i class="icon-angle-right"></i>
				</li>
				<li><a href="#">控制面板</a></li>
			</ul>
        
        
        <div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header" data-original-title>
						<h2><i class="halflings-icon user"></i><span class="break"></span>板块管理</h2>
					
					</div>
					 <div class="row-fluid" >
                        <div class="span6">
                            <!-- block -->
                            <div class="block" style="margin:20px;border:1px solid #f2f2f2;">
                                <div class="navbar navbar-inner block-header" style="background:#EEEEEE;">
                                    <div class=" pull-left" style="margin-top:10px;color:#000000;">栏目管理</div>
                                    <div class="pull-right" style="margin-top:10px;"><span class="badge badge-info">共6项</span>

                                    </div>
                                </div>
                                <div class="block-content collapse in" >
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th></th>
                                                <th>栏目</th>
                                                <th>项数</th>
                                               
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td></td>
                                                <td>货主信息管理</td>
                                                <td>3</td>
                      
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>车主信息管理</td>
                                                <td>3</td>
                                             
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>车辆管理</td>
                                                <td>3</td>

                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>新闻管理</td>
                                                <td>2</td>

                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>信息统计</td>
                                                <td>4</td>
                                             
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>广告管理</td>
                                                <td>1</td>
                                             
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!-- /block -->
                        </div>
                        <div class="span6">
                            <!-- block -->
                            <div class="block" style="margin:20px;border:1px solid #f2f2f2;">
                                <div class="navbar navbar-inner block-header" style="background:#EEEEEE;">
                                    <div class="pull-left" style="margin-top:10px;color:#000000;">统计管理</div>
                                    <div class="pull-right" style="margin-top:10px;"><span class="badge badge-info">共4项</span>

                                    </div>
                                </div>
                                <div class="block-content collapse in">
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th></th>
                                                <th>统计类型</th>
                                                <th>项数</th>
                                
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td></td>
                                                <td>车主车源/货主货源</td>
                                                <td>1</td>
                                               
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>车源地</td>
                                                <td>1</td>
                                                
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>货源地</td>
                                                <td>1</td>
                                               
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>成交量</td>
                                                <td>1</td>

                                            </tr>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!-- /block -->
                        </div>
                    </div>
                    <!-- 二 -->
                     <div class="row-fluid">
                        <div class="span6">
                            <!-- block -->
                            <div class="block" style="margin:20px;border:1px solid #f2f2f2;">
                                <div class="navbar navbar-inner block-header" style="background:#EEEEEE;">
                                    <div class="pull-left" style="margin-top:10px;color:#000000;">货主信息管理</div>
                                    <div class="pull-right" style="margin-top:10px;"><span class="badge badge-info">共3项</span>

                                    </div>
                                </div>
                                <div class="block-content collapse in">
                                    <table class="table ">
                            
                                            <tr>

                                                <td></td>
                                                <td >当前<%=statistics3.getName()%>信息</td>
                                                <td><%=statistics3.getCount()%>条</td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                            <tr>

                                                <td></td>
                                                <td >当前<%=statistics6.getName()%></td>
                                                <td><%=statistics6.getCount()%>条</td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>


                                           </tr>
                                        <tr>

                                            <td></td>
                                            <td >当前<%=statistics4.getName()%>信息</td>
                                            <td><%=statistics4.getCount()%>条</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                            <!-- /block -->
                        </div>
                        <div class="span6">
                            <!-- block -->
                            <div class="block" style="margin:20px;border:1px solid #f2f2f2;">
                                <div class="navbar navbar-inner block-header" style="background:#EEEEEE;">
                                    <div class=" pull-left" style="margin-top:10px;color:#000000;">车主信息管理</div>
                                    <div class="pull-right" style="margin-top:10px;"><span class="badge badge-info">共3项</span>

                                    </div>
                                </div>
                                <div class="block-content collapse in">
                                    <table class="table ">

                                        <tr>

                                            <td></td>
                                            <td >当前<%=statistics1.getName()%>信息</td>
                                            <td><%=statistics1.getCount()%>条</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>

                                        </tr>
                                        <tr>

                                            <td></td>
                                            <td >当前<%=statistics5.getName()%></td>
                                            <td><%=statistics5.getCount()%>条</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>

                                            <td></td>
                                            <td >当前<%=statistics2.getName()%>信息</td>
                                            <td><%=statistics2.getCount()%>条</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                            <!-- /block -->
                        </div>

                    </div>
                    <!-- 三 -->
                    <div class="row-fluid">
                        <div class="span6">
                            <!-- block -->
                            <div class="block" style="margin:20px;border:1px solid #f2f2f2;">
                                <div class="navbar navbar-inner block-header" style="background:#EEEEEE;">
                                    <div class="pull-left" style="margin-top:10px;color:#000000;">车辆管理</div>
                                    <div class="pull-right" style="margin-top:10px;"><span class="badge badge-info">共3项</span>

                                    </div>
                                </div>
                                <div class="block-content collapse in">
                                    <table class="table ">

                                        <tr>

                                            <td></td>
                                            <td colspan="2" >当前<%=statistics7.getName()%></td>
                                            <td><%=statistics7.getCount()%>条</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>

                                        </tr>
                                        <tr>

                                            <td></td>
                                            <td colspan="2">当前<%=statistics8.getName()%></td>
                                            <td><%=statistics8.getCount()%>条</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>

                                            <td></td>
                                            <td colspan="2">当前<%=statistics9.getName()%></td>
                                            <td><%=statistics9.getCount()%>条</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                            <!-- /block -->
                        </div>
                        <div class="span6">
                            <!-- block -->
                            <div class="block" style="margin:20px;border:1px solid #f2f2f2;">
                                <div class="navbar navbar-inner block-header" style="background:#EEEEEE;">
                                    <div class="pull-left" style="margin-top:10px;color:#000000;">新闻管理</div>
                                    <div class="pull-right" style="margin-top:10px;"><span class="badge badge-info">共1项</span>

                                    </div>
                                </div>
                                <div class="block-content collapse in">
                                    <table class="table ">

                                        <tr>

                                            <td></td>
                                            <td>当前<%=statistics10.getName()%></td>
                                            <td><%=statistics10.getCount()%>条</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>

                                    </table>
                                </div>
                            </div>
                            <!-- /block -->
                        </div>

                    </div>
				</div><!--/span-->
			
			</div><!--/row-->
		
				</div><!--/span-->
			</div><!--/row-->
        
        
        
	</div><!--/.fluid-container-->
	
			<!-- end: Content -->
		</div><!--/#content.span10-->
		</div><!--/fluid-row-->
		
	<div class="modal hide fade" id="myModal">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">×</button>
			<h3>Settings</h3>
		</div>
		<div class="modal-body">
			<p>Here settings can be configured...</p>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn" data-dismiss="modal">Close</a>
			<a href="#" class="btn btn-primary">Save changes</a>
		</div>
	</div>
	
	<div class="clearfix"></div>
	<%@  include file="inc/footer.jsp" %>

	<!-- start: JavaScript-->
        <!-- start: JavaScript-->
        <script src="js/jquery-1.9.1.min.js"></script>
        <script src="js/jquery-migrate-1.0.0.min.js"></script>
        <script src="js/jquery-ui-1.10.0.custom.min.js"></script>
        <script src="js/jquery.ui.touch-punch.js"></script>
        <script src="js/login.js"></script>
        <script src="js/modernizr.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.cookie.js"></script>
        <script src='js/fullcalendar.min.js'></script>
        <script src='js/jquery.dataTables.min.js'></script>
        <script src="js/excanvas.js"></script>
        <script src="js/jquery.flot.js"></script>
        <script src="js/jquery.flot.pie.js"></script>
        <script src="js/jquery.flot.stack.js"></script>
        <script src="js/jquery.flot.resize.min.js"></script>
        <script src="js/jquery.chosen.min.js"></script>
        <script src="js/jquery.uniform.min.js"></script>
        <script src="js/jquery.cleditor.min.js"></script>
        <script src="js/jquery.noty.js"></script>
        <script src="js/jquery.elfinder.min.js"></script>
        <script src="js/jquery.raty.min.js"></script>
        <script src="js/jquery.iphone.toggle.js"></script>
        <script src="js/jquery.uploadify-3.1.min.js"></script>
        <script src="js/jquery.gritter.min.js"></script>
        <script src="js/jquery.imagesloaded.js"></script>
        <script src="js/jquery.masonry.min.js"></script>
        <script src="js/jquery.knob.modified.js"></script>
        <script src="js/jquery.sparkline.min.js"></script>
        <script src="js/counter.js"></script>
        <script src="js/retina.js"></script>
        <script src="js/custom.js"></script>
        <!-- end: JavaScript-->
</body>
</html>
