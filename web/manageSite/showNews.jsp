<%@ page import="java.util.ArrayList" %>
<%@ page import="com.logistics.bean.News" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- start: Meta -->
  <meta charset="utf-8">
  <title></title>
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
  <link rel="stylesheet" href="css/my.css"/>
  <style>
    #myNews a{
      text-decoration: underline;
    }
    #myNews {
      width: 200px;
      overflow: hidden;
      text-overflow: ellipsis;

    }
  </style>




</head>

<body>
<%
  request.setCharacterEncoding("utf-8");
  ArrayList<News> newses = (ArrayList<News>)request.getAttribute("allNews");
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
          <a href="#">主页</a>
          <i class="icon-angle-right"></i>
        </li>
        <li><a href="#">查看新闻信息</a></li>
      </ul>
      <div class="row-fluid sortable">
        <div class="box span12">
          <div class="box-header" data-original-title>
            <h2><i class="halflings-icon user"></i><span class="break"></span>新闻列表</h2>
            <div class="box-icon">
            </div>
          </div>

          <div class="box-content">

            <table class="table table-striped bootstrap-datatable datatable" id="newsTable">
              <thead>

              <tr>
                <td>
                  <a href="releaseNews.jsp"><button type="button" class="btn btn-primary" >发布新闻</button></a>
                </td>
              </tr>
              <tr>
                <th width="20%">序号</th>
                <th width="30%">时间</th>
                <th width="30%">标题(点击标题查看全部)</th>
                <th width="20%">操作</th>
              </tr>
              </thead>
              <tbody>
              <%
                int i = 0;
              for(News n :newses){
                i++;
              %>
              <tr>
                <td class="center"><%=i%></td>
                <td class="center"><%=n.getDate()%></td>
                <td class="center" ><div id="myNews"><a href="showDetail.html?id=<%=n.getId()%>" ><nobr><%=n.getTitle()%></nobr></a></div></td>
                <td class="center"><a href="modifyNews.html?id=<%=n.getId()%>"><button class="btn-info" data-id="<%=n.getId()%>" >编辑</button></a><button class="btn-danger" data-id="<%=n.getId()%>" onclick="deleteNews(this)">删除</button></td>
              </tr>
              <%
                }
              %>
              <%--<tr>
                <td class="center">2</td>
                <td class="center">3</td>
                <td class="center">3</td>
                <td class="center"><button class="btn-info">修改</button><button class="btn-danger">删除</button></td>
              </tr>--%>
              </tbody>
            </table>
          </div>
        </div><!--/span-->

      </div><!--/row-->
    </div><!--/span-->
  </div><!--/row-->
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
<script>
  function deleteNews(ele){
    var isConfirm = confirm('确定删除？');
    if(isConfirm){
      var id = $(ele).data('id');
      $.get(
              'deleteNews.do',
              {id:id},
              function(data){
                if(data==1){
                  $(ele).addClass('delete-success');
                  $(ele).parents('tr').remove();
                  setTimeout(function(){
                    $(ele).removeClass('delete-success');
                  },1500);
                }else{
                  $(ele).addClass('delete-failed');
                  setTimeout(function(){
                    $(ele).removeClass('delete-failed');
                  },1500);
                }
              },
              'text'
      )
    }

  }
</script>



</body>
</html>
