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
          <a href="#">主页</a>
          <i class="icon-angle-right"></i>
        </li>
        <li><a href="#">添加广告图片</a></li>
      </ul>
      <div class="container">

        <div class="row-fluid sortable">
          <div class="box span12">
            <div class="box-header" data-original-title>
              <h2><i class="halflings-icon edit"></i><span class="break"></span>添加广告</h2>
            </div>
            <div class="box-content">
              <form class="form-horizontal" method="post" enctype="multipart/form-data" action="adUpload.do">
                <fieldset>
                  <%--预览--%>
                  <div class="control-group">
                    <label class="control-label" >预览</label>
                    <div class="controls">
                      <%--用于图片的预览--%>
                      <div style="width: 480px;height: 125px;border:1px solid #bcbcbc;" id="imgContainer"></div>
                      <%--<input type="text" class="span6 typeahead"  id="title" name="title" >--%>
                      <p class="help-block" style="color: red;" id="message">*图片大小在2M以下，尺寸1920*500</p>
                    </div>
                  </div>
                  <%--图片上传--%>
                  <div class="control-group">
                    <label class="control-label" for="imgFileInput">广告图片</label>
                    <div class="controls">
                      <input class="input-file uniform_on" name="adv" id="imgFileInput" type="file" onchange="file_onclick(this)">
                    </div>
                  </div>
                  <%--是否应用--%>
                  <div class="control-group">
                    <label class="control-label" for="sex">立即应用</label>
                    <div class="controls">
                      <select id="sex" name="state" class="chzn-select">
                        <option value="1">是</option>
                        <option value="0">否</option>
                      </select>
                    </div>
                  </div>
                  <div class="form-actions">
                    <button type="button" class="btn btn-primary" onclick="btn_onclick();" >提交</button>
                    <button type="reset" class="btn"  onclick="window.location.href='ad.html'">取消</button>
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
<script src=js/coachType.js></script>
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
  function btn_onclick(){
    var img = $("#imgContainer").html();
    if(null==img||''==img){
      $('#message').text('未选择图片');
      return;
    }else{
      $('form').submit();
    }
  }
  function file_onclick(sender){
      if(sender.files.length > 0){
        var file = sender.files[0];
        //console.log(sender.value);
        var fileReader = new FileReader();
        if(file.type == 'image/jpeg' || file.type == 'image/png'){
          if(file.size<1024*1024*2){
            fileReader.readAsDataURL(file);
            fileReader.onload = function(e){
              $("#imgContainer").empty();
              var img = new Image();
              img.src = this.result;
              if(img.width!=1920||img.height!=500){
                sender.value=null;
                $('#message').text('图片大小必须为1920*500');
                $('#imgFileInput').next().text("No file selected");
                return;
              }else{
                $('#message').text('');
                $('<img src="'+this.result+'" width="480" height="125"/>').appendTo("#imgContainer");
              }
              //console.log(this.result)
            };
            /*fileReader.load();*/
          }else{
            $("#imgContainer").empty();
            sender.value=null;
            $('#message').text('大小必须在2M以下');
            $('#imgFileInput').next().text("No file selected");
            return;
          }
        }
        else{
          $("#imgContainer").empty();
          sender.value=null;
          $('#message').text('图片格式为.jpeg和.png');
          $('#imgFileInput').next().text("No file selected");
          return;
        }
      }
      else{
        $('#message').text('你已取消图片');
        $("#imgContainer").empty();
        return;
      }

  }
</script>

</body>
</html>
