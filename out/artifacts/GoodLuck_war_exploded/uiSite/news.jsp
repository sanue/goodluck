<%@ page import="com.logistics.bean.News" %>
<%@ page import="com.logistics.bean.RecordSet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>新闻信息</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="Author" contect="http://www.webqin.net">
  <!-- Bootstrap -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">
  <link href="css/response.css" rel="stylesheet">
  <link href="css/silde.css" rel="stylesheet">
  <link href="ext/css/bootstrap.css" rel="stylesheet">
  <link href="ext/css/style.css" rel="stylesheet" type="text/css" media="all" />
  <link rel="stylesheet" href="ext/css/swipebox.css">
  <!--Truck-->
  <link rel="stylesheet" href="css/News.css">
  <%--city--%>
  <link href="css/city.css" rel="stylesheet">
  <!--Truck-->

  <!-- //for-mobile-apps -->
  <!-- js -->
  <script type="text/javascript" src="js/jquery.js"></script>
  <!-- js -->
  <script src="ext/js/modernizr.custom.js"></script>
  <!-- start-smoth-scrolling -->
  <script type="text/javascript" src="ext/js/move-top.js"></script>
  <script type="text/javascript" src="ext/js/easing.js"></script>

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>
<%RecordSet<News> recordSet = (RecordSet<News>)request.getAttribute("BookList");%>
<%  ArrayList<News> news = (ArrayList<News>)request.getAttribute("NewsList"); %>
<% ArrayList<News> newses = (ArrayList<News>)request.getAttribute("NewsesList");%>
<%
  String ID = (String)request.getAttribute("id");
  int id= 0;
  if(ID!=null){
    id=Integer.parseInt(ID);
  }%>
<%@include file="inc/header.jsp"%>
<!--body-->
<div class="content">
  <div class="width1003">
    <div class="content-left">
      <h2 class="left-title">新闻公告</h2>
      <ul class="leftNav">
        <li class="leftNavCur"><a href="JavaScript:void(0)">实时物流公告</a></li>
        <li class="leftNavCur2"><a href="JavaScript:void(0)">最新物流动态</a></li>

      </ul>
      <div class="lefticon">
        <a href="javascript:void(0);"><img src="images/icon1.jpg"><br>联系</a>
        <a href="javascript:void(0);"><img src="images/icon2.jpg"><br>投诉</a>
        <a href="javascript:void(0);"><img src="images/icon3.jpg"><br>下载</a>
        <a href="javascript:void(0);"><img src="images/icon4.jpg"><br>招聘</a>
      </div>
    </div><!--content-left/-->
    <div class="content-right">
      <h2 class="right-title">好运多最新新闻动态</h2>

      <div class="old12" id="word1"  style="display: none;">
        <br>
        <div class="old12" id="word"  style="display: none;">
          <%for(News N:newses){%>
          <%=N.getContent()%>
          <%}%>

      </div>
         <span id="history"  style="float: right;display: block;">
          <a  style="color: #ed6c2c;" href="/uiSite/news.html">返回新闻标题</a></span>

      </div>

      <ul class="new" style="display: <%=id==0?"block":"none"%>;min-height: 450px;" id="news">
        <%for(News n:recordSet.getRecordSet()){%>
        <li>
          <a href="javascript:void(0)"><%=n.getTitle()%>
            <input type="hidden" value="<%=n.getId()%>">
          </a>
          <span><%=n.getDate()%></span>
        </li>
        <%}%>
      </ul>
      <%--//分页--%>
      <div class="dataTables_paginate paging_bootstrap pagination">
        <ul id="pageNum">
          <%
            for(int i = 0 ; i < recordSet.getPageCode() ;i++){
          %>
          <li><a href="javascript:void(0)" onclick="btn_page(<%=i + 1%>)"><%=i + 1%></a></li>
          <%
            }
          %>
        </ul>
      </div>

    </div><!--content-right/-->
    <div class="clearfix"></div>
  </div><!--width1003/-->
</div>
<!--/body-->
<%@include file="inc/footer.jsp"%>
<script src="js/jquery.js" type="javascript"></script>
<script src="js/news.js"></script>
<script src="js/Popt.js"></script>
<script src="js/cityJson.js"></script>
<script src="js/citySet.js"></script>
<script src="js/global.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/style.js"></script>
</body>
</html>
