<%@ page import="com.logistics.bean.Goods" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.logistics.bean.CarInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- start: Meta -->
  <meta charset="utf-8">
  <title>Bootstrap Metro Dashboard by Dennis Ji for ARM demo</title>
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
  <link id="base-style" href="css/style.css" rel="stylesheet">
  <link id="base-style-responsive" href="css/style-responsive.css" rel="stylesheet">
  <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>
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
  ArrayList<CarInfo> carInfos = (ArrayList<CarInfo>)request.getAttribute("carInfos");
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
        <li><a href="#">车主信息管理</a></li>
      </ul>


      <div class="row-fluid sortable">
        <div class="box span12">
          <div class="box-header" data-original-title>
            <h2><i class="halflings-icon user"></i><span class="break"></span>车源信息</h2>
            <div class="box-icon">
            </div>
          </div>
          <div class="box-content">

            <table class="table table-striped bootstrap-datatable datatable">
              <thead>

              <tr>
                <th>实景照</th>
                <th>车牌号</th>
                <th>车主</th>
                <th>车长</th>
                <th>车类型</th>
                <th>车厢类型</th>
                <th>起始省份</th>
                <th>起始城市</th>
                <th>目的省份</th>
                <th>目的城市</th>
              </tr>
              </thead>
              <tbody>
              <%for(CarInfo c:carInfos){%>
              <tr>
                <td class="center"><img alt="" src="../upload/carPicPath/<%=c.getCarPic()%>" width="90" height="90"></td>
                <td class="center"><%=c.getCarNum()%></td>
                <td class="center"><%=c.getOwner()%></td>
                <td class="center"><%=c.getCarLong()%></td>
                <td class="center"><%=c.getCarType()%></td>
                <td class="center"><%=c.getCoachType()%></td>
                <td class="center"><%=c.getStartProvince()%></td>
                <td class="center"><%=c.getStartCity()%></td>
                <td class="center"><%=c.getToProvince()%></td>
                <td class="center"><%=c.getToCity()%></td>
              </tr>
              <%}%>
              </tbody>

            </table>
          </div>
        </div><!--/span-->

      </div><!--/row-->

    </div><!--/span-->
  </div><!--/row-->
</div><!--/.fluid-container-->

<!-- end: Content -->
</div><!--/span-->
</div><!--/row-->

</div><!--/.fluid-container-->

<!-- end: Content -->

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
<script src="js/jquery-1.9.1.min.js"></script>
<script src="js/jquery-migrate-1.0.0.min.js"></script>
<script src="js/jquery-ui-1.10.0.custom.min.js"></script>
<script src="js/jquery.ui.touch-punch.js"></script>
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

