<%@ page import="java.util.ArrayList" %>
<%@ page import="com.logistics.bean.ShipperAuthentication" %>
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
  <link href="css/larger.css" rel="stylesheet">
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



</head>

<body>
<%
  request.setCharacterEncoding("utf-8");
  ArrayList<ShipperAuthentication> authentications = (ArrayList<ShipperAuthentication>)request.getAttribute("authentications");
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
        <li><a href="#">显示审核信息</a></li>
      </ul>
      <div class="row-fluid sortable">
        <div class="box span12">
          <div class="box-header" data-original-title>
            <h2><i class="halflings-icon user"></i><span class="break"></span>审核列表</h2>
            <div class="box-icon">
            </div>
          </div>

          <div class="box-content">

            <table class="table table-striped bootstrap-datatable datatable">
              <thead>
              <%--<tr>
                <td>
                  <button type="button" class="btn btn-primary"  onclick="window.location.href='addNewSinger.html'" >添加新歌手</button>
                </td>
              </tr>--%>
              <tr>
                <th>用户名</th>
                <th>真实名</th>
                <th>身份证</th>
                <th>头像</th>
                <th>操作(√表示通过)</th>
              </tr>
              </thead>
              <tbody>
              <%
              for(ShipperAuthentication s : authentications){
              %>
              <tr>
                <td class="center"><%=s.getShipperName()%></td>
                <td class="center"><%=s.getTrueName()%></td>
                <td class="center"><img src="../upload/identityPath/<%=s.getIdentityCard()%>" width="90" height="90" onclick='showLarge(this)'/></td>
                <td class="center"><img src="../upload/headPath/<%=s.getPic()%>" width="90" height="90" onclick='showLarge(this)'/></td>
                <td class="center">
                  认证<input type="checkbox" value="<%=s.getShipperName()%>" onclick="confirmAuthentication(this)" <%=s.getStatus()==1?"checked":""%> />
                  <button class="btn-danger"onclick="deleteInfo('<%=s.getShipperName()%>',this)">删除</button>
                </td>
              </tr>
              <%
                }
              %>
              <%--<tr>
                <td class="center">小明</td>
                <td class="center">赵雪雪</td>
                <td class="center">234215415634534523545432543</td>
                <td class="center"><img src="img/dd.jpg" alt=""/></td>
                <td class="center">认证<input type="checkbox" value="authentication" /></td>
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
<div class="applyAd" id="authentication">认证通过.</div>
<div class="cancelAd" id="hasAuthentication">已经认证.</div>
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
  function confirmAuthentication(ele){
    var sel = false;
    if(ele.checked){
      sel = confirm("是否要确定认证？");
      if(sel){
        var name = $(ele).val();
        //ajax请求修改状态
        $.get(
                'changeStatus.do',
                {status:"1",name:name},
                function(data){
                  if(data==1) {
                    ele.checked=true;
                    $('#authentication').fadeIn(500);
                    setTimeout(function(){
                      $('#authentication').fadeOut(1000);
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
      $('#hasAuthentication').fadeIn(500);
      setTimeout(function(){
        $('#hasAuthentication').fadeOut(1000);
      },1500)
    }

  }
  //显示大图片
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
//删除审核失败的货主信息

  function deleteInfo(name,ele){
    var isConfirm = confirm('确定删除？');
    if(isConfirm){
      $.get(
              'deleteShipperInfo.do',
              {"shipperName":name},
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