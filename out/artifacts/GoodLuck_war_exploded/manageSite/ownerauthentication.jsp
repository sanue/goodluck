<%@ page import="com.logistics.bean.BaseInfo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.logistics.bean.OwnerAuthentication" %>
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
  <link href="css/larger.css" rel="stylesheet">
  <!-- end: CSS -->
<style>

</style>


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

</head>

<body>
<%
  request.setCharacterEncoding("utf-8");
  ArrayList<OwnerAuthentication> ownerAuthentications = (ArrayList<OwnerAuthentication>)request.getAttribute("ownerAuthentications");
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
            <h2><i class="halflings-icon user"></i><span class="break"></span>车主信息审核</h2>
            <div class="box-icon">
            </div>
          </div>
          <div class="box-content">

            <table class="table table-striped bootstrap-datatable datatable">
              <thead>

              <tr>
                <th>身份证照</th>
                <th>驾驶证照</th>
                <th>头像</th>
                <th>姓名</th>
                <th>车牌号</th>
                <th>操作(√表示通过)</th>
              </tr>
              </thead>
              <tbody>
              <%
                for(OwnerAuthentication o:ownerAuthentications){
              %>
              <tr>
                <td class="center"><img alt="" src="../upload/identityPath/<%=o.getIdentityPic()%>" width="90" height="90" onclick='showLarge(this )'/></td>
                <td class="center"><img alt="" src="../upload/driverLiPath/<%=o.getDrivesLicensePic()%>" width="90" height="90" onclick='showLarge(this)'/></td>
                <td class="center"><img src='../upload/headPath/<%=o.getHeadPic()%>' width='90' height='90' onclick='showLarge(this)'/></td>
                <td class="center"><%=o.getTrueName()%></td>
                <td class="center"><%=o.getCarNum()%></td>
                <td class="center">
                  认证<input type="checkbox" value="<%=o.getOwnerName()%>" onclick="confirmOwnerAuthentication(this)" <%=o.getStatus()==1?"checked":""%> />
                  <button class="btn-danger"onclick="deleteOwnerInfo('<%=o.getOwnerName()%>',this)">删除</button>
                </td>
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
<div class="applyAd" id="ownerAuthentication">认证通过.</div>
<div class="cancelAd" id="isAuthentication">已经认证.</div>
<div class="clearfix"></div>
<%@  include file="inc/footer.jsp" %>

<!-- start: JavaScript-->

<script src="js/jquery-1.9.1.min.js"></script>
<script src="js/jquery-migrate-1.0.0.min.js"></script>
<script src="js/jquery-ui-1.10.0.custom.min.js"></script>
<script src='js/jquery.dataTables.min.js'></script>
<script src="js/jquery.ui.touch-punch.js"></script>

<script src="js/modernizr.js"></script>

<script src="js/bootstrap.min.js"></script>

<script src="js/jquery.cookie.js"></script>

<script src='js/fullcalendar.min.js'></script>
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
  function confirmOwnerAuthentication(ele){
    var sel = false;
    if(ele.checked){
      sel = confirm("是否要确定认证？");
      if(sel){
        var name = $(ele).val();
//        ele.checked=true;
        //ajax请求修改状态
        $.get(
                'ChangeOwnerAuthentication.do',
                {status:"1",name:name},
                function(data){
                  if(data==1) {
                    ele.checked=true;
                    $('#ownerAuthentication').fadeIn(500);
                    setTimeout(function(){
                      $('#ownerAuthentication').fadeOut(1000);
                    },1500)
                  }
                },
                'text'
        )
      }else{
        ele.checked=false;
      }
    }else{
      ele.checked=true;
      $('#isAuthentication').fadeIn(500);
      setTimeout(function(){
        $('#isAuthentication').fadeOut(1000);
      },1500)
    }

  }
  //显示大图
  function showLarge(ele){
    //10% , 80% , 0.8 , 400/1600
    var $Wrap = $('<div class="imgWrap1"></div>');
    $Wrap.click(function(){
      $(this).remove();
    });
    var $div = $('<div class="largeImg"></div>');
    var $img = $('<img src="'+ele.src+'" />');
    $img.css('width' , '100%').css('height','100%');
   // console.log(0.8*$('body')[0].offsetWidth);
    $div.css('left','25%').css('width','50%').css('height',0.3*$('body')[0].offsetWidth+'px' ).css('top','calc(50% - '+0.3*$('body')[0].offsetWidth/2+'px)');
    $div.append($img);
    $Wrap.append($div);
    $('body').append($Wrap);
  }
  window.onresize=function(){
    $('.largeImg').css('height',0.3*$('body')[0].offsetWidth+'px' ).css('top','calc(50% - '+0.3*$('body')[0].offsetWidth/2+'px)')
  };

  //删除审核失败的车审核信息

  function deleteOwnerInfo(name,ele){
    var isConfirm = confirm('确定删除？');
    if(isConfirm){
      $.get(
              'deleteOwnerInfo.do',
              {"ownerName":name},
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

<!-- end: JavaScript-->

</body>
</html>
