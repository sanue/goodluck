<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>

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
  <link id="base-style" href="css/style.css" rel="stylesheet">
  <link id="base-style-responsive" href="css/style-responsive.css" rel="stylesheet">
  <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>
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
        <li><a href="#">所有信息统计</a></li>
      </ul>


      <div class="row-fluid sortable">
        <div class="box span12">
          <div class="box-header" data-original-title>
            <h2><i class="halflings-icon user"></i><span class="break"></span>信息统计</h2>

          </div>
          <div class="row-fluid" >
            <div class="span6">
              <!-- block -->
              <div class="block" style="margin:20px;border:1px solid #f2f2f2;">
                <div class="navbar navbar-inner block-header" style="background:#EEEEEE;">
                  <div class=" pull-left" style="margin-top:10px;color: #000000;">车主车源货主货源信息统计</div>
                  <%--<div class="pull-right" style="margin-top:10px;"><span class="badge badge-info">共4项</span>
                  </div>--%>
                </div>
                <div class="block-content collapse in"  >
                  <%--统计图表--%>
                    <canvas id="canvas1" height="200" width="400"></canvas>
                </div>
              </div>
              <!-- /block -->
            </div>

            <div class="span6">
              <!-- block -->
              <div class="block" style="margin:20px;border:1px solid #f2f2f2;">
                <div class="navbar navbar-inner block-header" style="background:#EEEEEE;">
                  <div class=" pull-left" style="margin-top:10px;color: #000000;">车源地信息统计</div>
                  <%--<div class="pull-right" style="margin-top:10px;"><span class="badge badge-info">共4项</span>

                  </div>--%>
                </div>
                <div class="block-content collapse in" style="text-align: center;padding-top: 10px">
                  <%--图表二--%>
                  <canvas id="chart-area" width="200" height="200" />
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
                  <div class=" pull-left" style="margin-top:10px;color: #000000;">货源地信息统计</div>
                  <%--<div class="pull-right" style="margin-top:10px;"><span class="badge badge-info">共2项</span>
                  </div>--%>
                </div>
                <div class="block-content collapse in" style="text-align: center;padding-top: 10px">
                  <canvas id="chart-area1" width="200" height="200"/>
                </div>
              </div>
              <!-- /block -->
            </div>
            <div class="span6">
              <!-- block -->
              <div class="block" style="margin:20px;border:1px solid #f2f2f2;">
                <div class="navbar navbar-inner block-header" style="background:#EEEEEE;">
                  <div class="pull-left" style="margin-top:10px;color: #000000;">成交量信息统计</div>
                  <%--<div class="pull-right" style="margin-top:10px;"><span class="badge badge-info">共2项</span>
                  </div>--%>
                </div>
                <div class="block-content collapse in" style="text-align: center;padding-top: 10px">
                  <canvas id="chart-area2" width="200" height="200" />
                </div>
              </div>
              <!-- /block -->
            </div>
          </div>

        </div><!--/span-->

      </div><!--/row-->

    </div><!--/span-->
    <!-- end: Content -->
  </div><!--/row-->
</div><!--/.fluid-container-->


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
<script src=js/my.js>
  //<script src="js/modernizr.js"></script>
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

<script src="js/Chart.min.js"></script>

<script>
  $(function(){
    $.get(
            'Statistics1.show',
            function(result){
              var labels =new Array();
              var data =new Array();
              for(var i = 0 ; i<result.length;i++){
                labels.push(result[i].name);
                data.push(result[i].count);
              }
              var barChartData = {
                labels : labels,
                datasets : [

                  {
                    fillColor : "rgba(151,187,205,0.5)",
                    strokeColor : "rgba(151,187,205,0.8)",
                    highlightFill : "rgba(151,187,205,0.75)",
                    highlightStroke : "rgba(151,187,205,1)",
                    data : data
                  }
                ]
              };
              /*window.onload = function(){*/
              var ctx = document.getElementById("canvas1").getContext("2d");
              window.myBar = new Chart(ctx).Bar(barChartData, {
                responsive : true
              });
              /*}*/
            },
            'json'
    );
    $.get(
            'Statistics2.show',
            function(result){
              /*var value1 = result[0].count;
              var label1 = result[0].name;

              var value2 = result[1].count;
              var label2 = result[1].name;*/

              var pieData = [
                {
                  value: 0,
                  color:"#F7464A",
                  highlight: "#FF5A5E",
                  label: '' //red
                },
                {
                  value: 0,
                  color: "#46BFBD",
                  highlight: "#5AD3D1",
                  label: '' //blue
                },
                {
                  value: 0,
                  color: "#FDB45C",
                  highlight: "#FFC870",
                  label: "Yellow"
                }
                ,
                {
                  value: 0,
                  color: "yellowgreen",
                  highlight: "greenyellow",
                  label: "4"
                },
                {
                  value: 0,
                  color: "dodgerblue",
                  highlight: "deepskyblue",
                  label: "5"
                },
                {
                  value: 0,
                  color: "chocolate",
                  highlight: "coral",
                  label: "6"
                },
                {
                  value: 0,
                  color: "darkgreen",
                  highlight: "green",
                  label: "7"
                },
                {
                  value: 0,
                  color: "#c4c4c4",
                  highlight: "#c4e3f3",
                  label: "其他"
                }
              ];
              var sum=0 ;
              var num=0;
              for(var i = 0;i<result.length;i++){
                sum+=result[i].count;
              }
              if(result.length>7){
                for(var i =0;i<pieData.length-1;i++){
                  pieData[i].value=result[i].count;
                  pieData[i].label=result[i].name;
                  num +=result[i].count;
                }
                pieData[pieData.length-1].value=sum-num;
              }else{
                for(var i =0;i<result.length;i++){
                  pieData[i].value=result[i].count;
                  pieData[i].label=result[i].name;
                }
              }
                var ctx = document.getElementById("chart-area").getContext("2d");
                window.myPie = new Chart(ctx).Pie(pieData);
            },
            'json'
    );
    $.get(
            'Statistics3.show',
            function(result){

              var pieData = [
                {
                  value: 0,
                  color:"#F7464A",
                  highlight: "#FF5A5E",
                  label: ''
                },
                {
                  value: 0,
                  color: "#46BFBD",
                  highlight: "#5AD3D1",
                  label: ''
                },
                {
                  value: 0,
                  color: "#FDB45C",
                  highlight: "#FFC870",
                  label: "Yellow"
                }
                ,
                {
                  value: 0,
                  color: "yellowgreen",
                  highlight: "greenyellow",
                  label: "4"
                },
                {
                  value: 0,
                  color: "dodgerblue",
                  highlight: "deepskyblue",
                  label: "5"
                },
                {
                  value: 0,
                  color: "chocolate",
                  highlight: "coral",
                  label: "6"
                },
                {
                  value:0,
                  color: "darkgreen",
                  highlight: "green",
                  label: "7"
                },
                {
                  value: 0,
                  color: "#c4c4c4",
                  highlight: "#c4e3f3",
                  label: "其他"
                }
              ];
              var sum=0 ;
              var num=0;
              for(var i = 0;i<result.length;i++){
                sum+=result[i].count;
              }
              if(result.length>7){
                for(var i =0;i<pieData.length-1;i++){
                  pieData[i].value=result[i].count;
                  pieData[i].label=result[i].name;
                  num +=result[i].count;
                }
                pieData[pieData.length-1].value=sum-num;
              }else{
                for(var i =0;i<result.length;i++){
                  pieData[i].value=result[i].count;
                  pieData[i].label=result[i].name;
                }
              }

              var ctx = document.getElementById("chart-area1").getContext("2d");
              window.myPie = new Chart(ctx).Pie(pieData);
            },
            'json'
    );
    $.get(
            'Statistics4.show',
            function(result){
              var value1 = result[1].count;
              var value2 = result[0].count-value1;
              var pieData = [
                {
                  value: value1,
                  color:"#F7464A",
                  highlight: "#FF5A5E",
                  label: '成交货源'
                },
                {
                  value: value2,
                  color: "#c4c4c4",
                  highlight: "#c4e3f3",
                  label: "未成交货源"
                }
              ];
              var ctx = document.getElementById("chart-area2").getContext("2d");
              window.myPie = new Chart(ctx).Pie(pieData);
            },
            'json'
    );
  })
</script>
</body>
</html>
