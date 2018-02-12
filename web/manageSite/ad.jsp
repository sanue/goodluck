<%@ page import="java.util.ArrayList" %>
<%@ page import="com.logistics.bean.Advertisement" %>
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
  <![end if]-->
  <!--[if IE 9]>
  <link id="ie9style" href="css/ie9.css" rel="stylesheet">
  <![end if]-->
  <!-- start: Favicon -->
  <link rel="shortcut icon" href="img/favicon.ico">
  <!-- end: Favicon -->
  <link rel="stylesheet" href="css/my.css"/>
  <link rel="stylesheet" href="css/larger.css"/>

</head>

<body>
<%
  request.setCharacterEncoding("utf-8");
  ArrayList<Advertisement> ads = (ArrayList<Advertisement>)request.getAttribute("allAd");
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
        <li><a href="#">显示广告图片信息</a></li>
      </ul>
      <div class="row-fluid sortable">
        <div class="box span12">
          <div class="box-header" data-original-title>
            <h2><i class="halflings-icon user"></i><span class="break"></span>广告列表</h2>
            <div class="box-icon">
            </div>
          </div>

          <div class="box-content">

            <table class="table table-striped bootstrap-datatable datatable">
              <thead>
              <tr>
                <td>
                  <a href="addAdv.jsp"><button type="button" class="btn btn-primary" >添加广告图</button></a>
                </td>
              </tr>
              <tr>
                <th>序号</th>
                <th>新闻图片(点击查看大图)</th>
                <th>应用(√表示已应用)</th>
                <th>删除</th>
              </tr>
              </thead>
              <tbody>
              <%
                int i =0;
              for(Advertisement a : ads){
                i++;
              %>
              <tr >
                <td class="center" style="vertical-align: middle"><%=i%></td>
                <td class="center" style="vertical-align: middle"><img src="../upload/adv/<%=a.getImage()%>" alt="" width="384" height="100" data-action="zoom" onclick="showLarge(this)"/></td>
                <td class="center" style="vertical-align: middle"><label >应用<input type="checkbox" value="<%=a.getId()%>" onclick="applyAdv(this)" <%=a.getState()==1?"checked":""%>/></label></td>
                <td class="center" style="vertical-align: middle"><button class="btn-danger" data-id="<%=a.getId()%>" onclick="deleteAdv(this)">删除</button></td>
              </tr>
              <%
                }
              %>
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
<div class="applyAd" id="apply">应用成功.</div>
<div class="cancelAd" id="cancel">应用取消.</div>
<div class="applyAd" id="delete_success">删除成功.</div>
<div class="applyAd" id="delete_fail">删除失败.</div>
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
<%--<script src="js/larger.js"></script>--%>
<script>
  /*用于广告的应用*/
  function applyAdv(ele){
    var id = $(ele).val();
    var sel = false;
    if(ele.checked){
      sel = confirm("是否要应用？");
      if(sel){
        //ajax请求修改状态
        $.get(
                'applyAdv.do',
                {id:id,state:1},
                function(data){
                  if(data==1) {
                    $('#apply').fadeIn(500);
                    ele.checked=true;
                    setTimeout(function(){
                      $('#apply').fadeOut(1000);
                    },1500)
                  }
                },
                'text'
        )
      }else{
        ele.checked=false;
      }
    }else{
      sel = confirm("是否要取消应用？")
      if(sel){
        $.get(
                'applyAdv.do',
                {id:id,state:0},
                function(data){
                  if(data==1) {
                    $('#cancel').fadeIn(500);
                    ele.checked=false;
                    setTimeout(function(){
                      $('#cancel').fadeOut(1000);
                    },1500)

                  }
                },
                'text'
        );
      }else{
        ele.checked=true;
      }
    }

  }
  /*删除广告*/
  function deleteAdv(ele){
    var id = $(ele).data('id');
    if(confirm("是否确定删除？")){
      $.get(
              'deleteAdv.do',
              {id:id},
              function(data){
                if(data==1){
                  /*删除成功*/
                  $(ele).parents('tr').remove();
                  $('#delete_success').fadeIn(500);
                  setTimeout(function(){
                    $('#delete_success').fadeOut(1000);
                  },1500)

                }else{
                  /*删除失败*/
                  $('#delete_fail').fadeIn(500);
                  setTimeout(function(){
                    $('#delete_fail').fadeOut(1000);
                  },1500)
                }

              },
              'text'
      )
    }


  }
  function showLarge(ele){
    //10% , 80% , 0.8 , 400/1600
    var $Wrap = $('<div class="imgWrap1"></div>');
    $Wrap.click(function(){
      $(this).remove();
    });
    var $div = $('<div class="largeImg"></div>');
    var $img = $('<img src="'+ele.src+'" />');
    $img.css('width' , '100%').css('height','100%');
    /*console.log(0.8*$('body')[0].offsetWidth);*/
    $div.css('left','10%').css('width','80%').css('height',400/1600*0.8*$('body')[0].offsetWidth+'px' ).css('top','calc(50% - '+400/1600*0.8*$('body')[0].offsetWidth/2+'px)');
    $div.append($img);
    $Wrap.append($div);
    $('body').append($Wrap);
  }
  window.onresize=function(){
    $('.largeImg').css('height',400/1600*0.8*$('body')[0].offsetWidth+'px' ).css('top','calc(50% - '+400/1600*0.8*$('body')[0].offsetWidth/2+'px)')
  };
</script>

</body>
</html>