<%@ page import="com.logistics.bean.Register" %>
<%@ page import="com.logistics.bean.OwnerAuthentication" %>
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
        Register currentRe =new Register();
        if (request.getAttribute("currentRe")!=null){
            currentRe = (Register)request.getAttribute("currentRe");
        }else{
            response.sendRedirect("index.html");
        }
        OwnerAuthentication ownerAuthentication = (OwnerAuthentication)request.getAttribute("ownerInfo");
    %>
    <header>
      <div class="headerRight headerTitle">你好，<%=currentRe.getName() %> |
        <div class="headerTitle"><a href="index.html">首页</a> </div> |
        <div class="headerTitle"><a href="basicInfo.html">退出</a></div> |
        <div class="headerTitle">热线电话:8005555454</div>
      </div>
    </header>
    <section class="seOne">
        <div class="headerContent width1003">
          <div class="sectionTitle"><img src="images/logo.png" width="200" height="60"></div>
        </div>
    </section>
    <section class="seTwo">
      <div class="currentUserContent width1003">
        <div class="UserInContent">
            <%
                if(ownerAuthentication.getHeadPic()==null){

             %>
                 <img src="images/headc.jpg" width="150" height="150"/>
            <%
                }else{
            %>
                <img src="../upload/headPath/<%=ownerAuthentication.getHeadPic()%>"/>
            <%
                }
            %>

          <div class="basicInfo">
            <div><%=currentRe.getName() %></div><img src="images/indentity.png" width="20" height="18">
            <div>身份类型：车主</div>
           <%-- <div>证件号码：<%=ownerInfo.getIdentity()%></div>--%>
          </div>
        </div>



      </div>
      <div class="Infos width1003">
        <div class="table">
          <div class="tb">车主真实姓名</div><div class="tb"><%=ownerAuthentication.getTrueName()%></div>
        </div>
        <div class="table">
          <div class="tb">车牌号</div><div class="tb"><%=ownerAuthentication.getCarNum()%></div>
        </div>

        <div class="table">
          <div class="tb">身份证照片</div><div class="tb"><img src="../upload/identityPath/<%=ownerAuthentication.getIdentityPic()%>" width="278" height="148" /></div>
        </div>
        <div class="table">
          <div class="tb">驾驶证照片</div><div class="tb"><img src="../upload/driverLiPath/<%=ownerAuthentication.getDrivesLicensePic()%>" width="278" height="148" /></div>
        </div>
      </div>
    </section>


<footer>
  Copyright &copy; 2016
</footer>
</body>
</html>
