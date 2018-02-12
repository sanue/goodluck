<%@ page import="com.logistics.bean.Register" %>
<%@ page import="com.logistics.bean.ShipperAuthentication" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
  <link href="css/reset.css" rel="stylesheet">
  <link href="css/authInfo.css" rel="stylesheet">
  <meta name="viewport" content="width=device-width; initial-scale=1.0">

</head>
<body>
<%
  Register currentRe = (Register)request.getAttribute("currentRe");
  ShipperAuthentication shipperAuthentication = (ShipperAuthentication)request.getAttribute("shipperAuthentication");
%>
<header>
  <div class="headerRight headerTitle">你好，<%=currentRe.getName() %> |
    <div class="headerTitle"><a href="index.html">首页</a> </div> |
    <div class="headerTitle"><a href="basicInfo.html">退出</a></div> |
    <div class="headerTitle">热线电话:18837045678</div>
  </div>
</header>
<section class="seOne">
  <div class="headerContent width1003">
    <div class="sectionTitle"><a href="index.html"><img src="images/logo.png" width="200" height="60"></a></div>
  </div>
</section>
<section class="seTwo">
  <div class="currentUserContent width1003">
    <div class="UserInContent">

      <%
        if(shipperAuthentication.getPic()==null){

      %>
      <img src="images/headc.jpg" width="150" height="150"/>
      <%
      }else{
      %>
      <img src="../upload/headPath/<%=shipperAuthentication.getPic()%>"/>
      <%
        }
      %>

      <div class="basicInfo">
        <div><%=currentRe.getName() %></div><img src="images/indentity.png" width="20" height="18">
        <div>身份类型：货主</div>
       <%-- <div>证件号码：<%=shipperAuthentication.getIdentityCard()%></div>--%>
      </div>
    </div>

  </div>
  <div class="Infos width1003">
    <div class="table">
      <div class="tb">车主真实姓名</div><div class="tb"><%=shipperAuthentication.getTrueName()%></div>
    </div>
    <div class="table">
      <div class="tb">身份证照片</div><div class="tb"><img src="../upload/identityPath/<%=shipperAuthentication.getIdentityCard()%>" /></div>
    </div>

  </div>
</section>
<footer>
  Copyright &copy; 2016
</footer>
</body>
</html>
