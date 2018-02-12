<%@ page import="com.logistics.bean.Register" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--logo-->
<link href="css/global.css" rel="stylesheet"/>
<div class="header">
    <div class="headerLeft">
        <div class="logo">
            <a href="index.html">
                <img src="images/logo.png" width="290" height="83">
            </a>
        </div>
        <div class="citys">
            <div id="myCity">&nbsp;</div>&nbsp;|&nbsp;
            <div class="toggleCity">切换城市</div>

        </div>


    </div>
    <!--登录注册-->
    <div class="relo">
        <%
            if (request.getSession().getAttribute("register")!=null){
                Register currentRe = (Register)request.getSession().getAttribute("register");
        %>
        <div id="registerName"><img src="images/user.png" width="22" height="22" class="reloimg"/>&nbsp;<%=currentRe.getName()%></div>
        <div id="signOut"><a href="signOut.do" style="text-decoration: none;" ><img src="images/signout.png" width="22" height="22" class="reloimg"/>&nbsp;注销</a></div>
        <%
        }else{
        %>
        <div id="login"><img src="images/login.png" width="22" height="22" class="reloimg"/><a href="login.jsp" style="text-decoration: none;color: #777">登录</a></div>
        <div id="register"><img src="images/register.png" width="22" height="22" class="reloimg"/><a href="register.jsp"style="text-decoration: none;color: #777">注册</a></div>
        <%
            }
        %>
        <div id="call"><span class="glyphicon glyphicon-earphone"></span>
            热线电话:18837045678</div>
    </div>
    <%--</div>--%>
</div>


<div class="nav-toggle">
    <div class="nav-open"><span class="glyphicon glyphicon-th-list"></span></div>
    <div class="nav-close"><span class="glyphicon glyphicon-remove"></span></div>
</div>
<div class="clearfix"></div>
<div class="nav">
    <ul class="width1003">
        <li><a href="index.html">首页</a></li>
        <li><a href="car.html">车源信息</a>
            <!--<div class="chilNav">
             <a href="service.html">十七常识</a>
             <a href="service.html">新手入门</a>
             <a href="tousu.html">投诉建议</a>
             <a href="download.html">下载中心</a>
            </div>-->
        </li>
        <li><a href="goods.html">货源信息</a>
            <!--<div class="chilNav">
             <a href="search.html">运单查询</a>
             <a href="search2.html">网点查询</a>
             <a href="search3.html">货物追踪</a>
             <a href="search4.html">订单查询</a>
            </div>-->
        </li>
        <li><a href="basicInfo.html">个人中心</a>
            <!--<div class="chilNav">
             <a href="product.html">快运产品</a>
             <a href="product.html">定制产品</a>
             <a href="product.html">增值服务</a>
             <a href="product.html">整车转运</a>
             <a href="product.html">仓储物流</a>
            </div>-->
        </li>
        <li><a href="news.html">新闻</a>
            <!--<div class="chilNav">
             <a href="join.html">加盟指南</a>
             <a href="join.html">在线加盟</a>
             <a href="join.html">人才服务</a>
             <a href="job.html">人才招聘</a>
             <a href="job.html">在线招聘</a>
            </div>-->
        </li>
        <li><a href="ours.jsp">关于我们</a>
            <!--<div class="chilNav">
             <a href="news.html">十七新闻</a>
             <a href="news.html">十七公告</a>
             <a href="news.html">行业动态</a>
             <a href="news.html">企业视频</a>
             <a href="news.html">企业微博</a>
            </div>-->
        </li>
        <li><a href="basicInfo.html">信息发布</a>
            <!--<div class="chilNav">
             <a href="about.html">十七简介</a>
             <a href="about.html">十七历程</a>
             <a href="about.html">十七文化</a>
             <a href="about.html">十七品牌</a>
             <a href="contact.html">联系我们</a>
             <a href="javascript:;">企业邮箱登陆</a>
             <a href="javascript:;">十七快运系统登陆</a>
            </div>-->
        </li>
        <div class="clears"></div>
    </ul>
</div><!--nav/-->
<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=565bc57c9b9b46d5abfaca42cf684812&plugin=AMap.CitySearch"></script>
<script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>

<%--<script src="js/jquery.js"></script>--%>

<%--<script>--%>
<%--//实例化城市查询类--%>
<%--var citysearch = new AMap.CitySearch();--%>
<%--//自动获取用户IP，返回当前城市--%>
<%--citysearch.getLocalCity(function(status, result) {--%>
<%--if (status === 'complete' && result.info === 'OK') {--%>
<%--if (result && result.city && result.bounds) {--%>
<%--var cityinfo = result.city;--%>
<%--var citybounds = result.bounds;--%>
<%--document.getElementById('myCity').innerHTML = cityinfo;--%>
<%--//地图显示当前城市--%>
<%--/* map.setBounds(citybounds);*/--%>
<%--}--%>
<%--} else {--%>
<%--document.getElementById('tip').innerHTML = result.info;--%>
<%--}--%>
<%--});--%>
<%--</script>--%>
