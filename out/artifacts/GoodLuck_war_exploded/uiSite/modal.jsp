<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="Author" contect="http://www.webqin.net">
  <title></title>
  <link rel="shortcut icon" href="images/favicon.ico" />
  <!-- Bootstrap -->
  <link href="css/bootstrap.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">
  <link href="css/response.css" rel="stylesheet">
  <link href="css/silde.css" rel="stylesheet">
  <link href="ext/css/bootstrap.css" rel="stylesheet">
  <link href="ext/css/style.css" rel="stylesheet" type="text/css" media="all" />
  <link rel="stylesheet" href="ext/css/swipebox.css">


  <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
  <!-- //for-mobile-apps -->
  <!-- js -->
  <script type="text/javascript" src="ext/js/jquery.min.js"></script>
  <!-- js -->
  <script src="ext/js/modernizr.custom.js"></script>
  <!-- start-smoth-scrolling -->
  <script type="text/javascript" src="ext/js/move-top.js"></script>
  <script type="text/javascript" src="ext/js/easing.js"></script>
  <script type="text/javascript">
    jQuery(document).ready(function($) {
      $(".scroll").click(function(event){
        event.preventDefault();
        $('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
      });
    });
  </script>
  <!--[if lt IE 9]>
  <!--<script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>-->
  <!--<script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>-->
  <![endif]-->
</head>
<body>
<%--顶部导航栏--%>
<%@include file="inc/header.jsp"%>
<%--内容主体--%>
<div class="content">
  <div class="width1003">
    <div class="content-left">
      <h2 class="left-title">自助查询</h2>
      <ul class="leftNav">
        <li class="leftNavCur"><a href="search.html">运单查询</a></li>
        <li><a href="search2.html">网点查询</a></li>
        <li><a href="search3.html">货物追踪</a></li>
        <li><a href="search4.html">订单查询</a></li>
      </ul>
      <div class="lefticon">
        <a href="javascript:;"><img src="images/icon1.jpg"><br>联系</a>
        <a href="javascript:;"><img src="images/icon2.jpg"><br>投诉</a>
        <a href="javascript:;"><img src="images/icon3.jpg"><br>下载</a>
        <a href="javascript:;"><img src="images/icon4.jpg"><br>招聘</a>
      </div>
    </div><!--content-left/-->
    <div class="content-right">
      <h2 class="right-title">运单查询</h2>
      <form action="#" method="get" class="searchs">
        <div class="textareas"><textarea></textarea></div>
        <div class="yam"><input type="text"> <img src="images/yzm.gif"> <a href="javascript:;">换一换</a></div>
        <div class="tousub"><input type="submit" value="立即查询"></div>
      </form><!--searchs/-->
      <br>
      <h2 class="right-title">查询结果</h2>
      <div class="Article">
        <span class="hui">暂无查询信息.....</span>

      </div>
    </div><!--content-right/-->
    <div class="clearfix"></div>
  </div><!--width1003/-->
</div><!--content/-->
<%--页脚部分--%>
<%@include file="inc/footer.jsp"%>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.js"></script>
<script src="js/style.js"></script>
<!--焦点轮换-->
<script src="js/jquery.excoloSlider.js"></script>
<script>
  var swiper = new Swiper('.swiper-container', {
    pagination: '.swiper-pagination',
    paginationClickable: true
  });
</script>
<script type="text/javascript">
  $(function(){
    //导航定位
    $(".nav li:eq(0) a:first").addClass("navCur");
  })
</script>

</body>
</html>

