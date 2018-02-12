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
  News news = (News)request.getAttribute("news");
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
        <li><a href="#">发布新闻信息</a></li>
      </ul>
      <div class="container">

        <div class="row-fluid sortable">
          <div class="box span12">
            <div class="box-header" data-original-title>
              <h2><i class="halflings-icon edit"></i><span class="break"></span>发布新闻</h2>
            </div>
            <div class="box-content">
              <form class="form-horizontal" method="post" action="modifyNews.do" >
                <fieldset>
                  <div class="control-group">
                    <label class="control-label" for="time">时间</label>
                    <div class="controls">
                      <input type="hidden" name="hideId" value="<%=news.getId()%>"/>
                      <input type="date" class="span6 typeahead" id="time" name="time" value="<%=news.getDate()%>"  >
                      <p class="help-block"></p>
                    </div>
                  </div>
                  <div class="control-group">
                    <label class="control-label" for="title">标题</label>
                    <div class="controls">
                      <input type="text" class="span6 typeahead" id="title"  name="title"  value="<%=news.getTitle()%>"  >
                      <p class="help-block"></p>
                    </div>
                  </div>
                  <div class="control-group hidden-phone">
                    <label class="control-label" for="myText">正文</label>
                    <div class="controls">
                      <textarea class="cleditor" id="myText" name="myText" rows="3" ><%=news.getContent()%></textarea>
                    </div>
                  </div>
                  <div class="form-actions">
                    <button type="submit" class="btn btn-primary">提交</button>
                    <button type="reset" class="btn"  onclick="window.location.href='showNews.html'">取消</button>
                  </div>
                </fieldset>
              </form>

            </div>
          </div><!--/span-->

        </div><!--/row-->

        <!-- 原来 -->

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
<script src="js/jquery.validate.js"></script>
<script>
  $(function(){
    $('form').validate({
      rules:{
        time:{
          required:true
        },
        title:{
          required:true
        },
        myText:{
          required:true
        }

      },
      messages:{
        time:{
          required:'日期不能为空.'
        },
        title:{
          required:'标题不能为空.'
        },
        myText:{
          required:'正文不能为空.'
        }
      },
      submitHandler :function(form){
        form.submit();
      }
    })

  });
</script>



</body>
</html>
