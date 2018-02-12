<%@ page import="java.util.ArrayList" %>
<%@ page import="com.logistics.bean.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>好运多</title>
    <link rel="stylesheet" type="text/css" href="css/history.css">
    <!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/response.css" rel="stylesheet">
    <link href="css/silde.css" rel="stylesheet">
    <link type="text/css" href="css/lrtk.css" rel="stylesheet"/>
    <link href="ext/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link rel="stylesheet" href="ext/css/swipebox.css">
    <!-- 主页 -->
    <link rel="stylesheet" href="css/home.css">
    <%--city--%>
    <link href="css/city.css" rel="stylesheet">
    <%--回到顶部--%>
    <link href="css/sucaijiayuan.css" rel="stylesheet" type="text/css" />
</head>
<body>

<%
    ArrayList<OwnerInfo> ownerInfos = (ArrayList<OwnerInfo>) request.getAttribute("ownerInfos");
    ArrayList<Goods> goods = (ArrayList<Goods>) request.getAttribute("goods");
    ArrayList<News> news = (ArrayList<News>) request.getAttribute("news");
    ArrayList<Advertisement> ads = (ArrayList<Advertisement>)request.getAttribute("ads");
%>
<%@include file="inc/header.jsp"%><!--nav/-->
<!-- Swiper -->
<!--轮播图-->
<div class="swiper-container">
    <%@include file="inc/banner2.jsp"%>
</div>
<!-- Swiper JS -->
<div class="content">
    <!--车主-->
    <!--<div class="index-search">-->
    <div class="contentTitle">
        <h2 class="title">货源信息
            <span>/ Driver Infomation</span></h2>
    </div>
    <div class="carInfoContent">
        <div class="width1003">
            <div class="container">
                <div class="gallery-bottom" id="goodsMes">

                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
    </div>
    <!--index-search/-->
</div>

<!-- </div>--><!--index-search/-->
<!--车辆-->
<div class="content">
    <div class="contentTitle">
        <h2 class="title">车源信息 <span>/ cars Infomation</span></h2>
    </div>
    <div class="carOwnerInfo">
        <div class="width1003">

            <table class="table table-hover table-condensed myTbH">
                <thead>
                <tr>
                    <td>车主姓名</td>
                    <td>车辆信息</td>
                    <td>当前位置</td>
                    <td>期望去向</td>
                    <td>手机号</td>
                </tr>
                </thead>
                <tbody  id="CarsMes">

                </tbody>
            </table>
        </div>
    </div>
    <%--</marquee>--%>
</div>

<!--平台优势-->
<div class="content">
    <div class="contentTitle">
        <h2 class="title">平台优势 <span>/ Advantage</span></h2>
    </div>
    <div class="width1003">
        <div class="container" style="margin: 65px 0;">
            <div class="destination-1" style="display: none;">
                <div class="col-md-3 destination-left">
                    <img src="images/car1.jpg" alt="">

                    <div class="tool">
                        <img src="ext/images/arrow.png" alt=""/>
                    </div>
                </div>
                <div class="col-md-3 destination-left destination-middle">
                    <h4>降低成本</h4>

                    <div class="strip one"></div>
                    <p>货主车主通过我们相互协作，信息共享，更节省成本。</p>
                </div>
                <div class="col-md-3 destination-left destination-right">
                    <img src="images/car2.jpg" alt="">

                    <div class="tool">
                        <img src="ext/images/arrow.png" alt=""/>
                    </div>
                </div>
                <div class="col-md-3 destination-left destination-middle">
                    <h4>资金透明</h4>

                    <div class="strip one"></div>
                    <p>交易环节清晰，资金数据透明，杜绝中间差价现象的发生</p>
                </div>
                <div class="col-md-3 destination-left destination-middle">
                    <h4>安全可靠</h4>

                    <div class="strip one"></div>
                    <p>承运商、司机严格审核备案，货物全程定位跟踪.</p>
                </div>
                <div class="col-md-3 destination-left">
                    <img src="images/car3.jpg" alt="">

                    <div class="tool two">
                        <img src="ext/images/arrow.png" alt=""/>
                    </div>
                </div>
                <div class="col-md-3 destination-left destination-middle">
                    <h4>资源共享</h4>

                    <div class="strip one"></div>
                    <p>集中了50%的返程车辆，价格更便宜，货主省钱、司机赚钱</p>
                </div>
                <div class="col-md-3 destination-left">
                    <img src="images/car4.jpg" alt="">

                    <div class="tool two">
                        <img src="ext/images/arrow.png" alt=""/>
                    </div>
                </div>

                <div class="clearfix"></div>
            </div>
        </div>

    </div>
    <!--width1003/-->
</div>

<!--width1003/-->
<!--新闻资讯-->
<div class="content">
    <div class="contentTitle">
        <h2 class="title">新闻快讯 <span>/ News</span></h2>
    </div>
    <div class="width1003">
    <%-- 新闻主体--%>
    <div id="zSlider">
        <div id="picshow">
            <div id="picshow_img">
                <ul>
                    <li><a href="javascript:void(0);" target="_blank"><img src="images/1.jpg"></a></li>
                    <li><a href="javascript:void(0);" target="_blank"><img src="images/2.jpg"></a></li>
                    <li><a href="javascript:void(0);" target="_blank"><img src="images/3.jpg"></a></li>
                    <li><a href="javascript:void(0);" target="_blank"><img src="images/4.jpg"></a></li>
                    <li><a href="javascript:void(0);" target="_blank"><img src="images/5.jpg"></a></li>
                    <li><a href="javascript:void(0);" target="_blank"><img src="images/6.jpg"></a></li>
                </ul>
            </div>
            <div id="picshow_tx">
                <ul>
                    <%
                        for (News n : news) {
                    %>
                    <li>
                        <nobr><h3><a href="news.html?id=<%=n.getId()%>" target="_blank"><%=n.getTitle()%>
                        </a></h3></nobr>
                        <p class="newsContent"><%=n.getDate()%></p>
                    </li>
                    <%
                        }
                    %>

                </ul>
            </div>
        </div>
        <div id="select_btn">
            <ul>
                <%
                    int i = 0;
                    for (News n : news) {
                        i++;
                %>
                <li><a href="news.html?id=<%=n.getId()%>" target="_blank"><img src="images/<%=i%>.jpg"><span
                        class="select_text"><%=n.getTitle()%></span><span
                        class="select_date"><%=n.getDate()%></span></a></li>
                <%
                    }
                %>
            </ul>
        </div>
    </div>
        </div>
</div>
<div class="content">
    <div class="contentTitle">
        <h2 class="title">时光轴 <span>/ News</span></h2>
    </div>
    <div class="width1003">
        <div id="arrow" style="display: none">
            <ul>
                <li class="arrowup"></li>
                <li class="arrowdown"></li>
            </ul>
        </div>
        <%@include file="inc/newsTimeline.jsp" %>
    </div>
    <!--合作伙伴-->
    <div class="links">
        <div class="width1003">

            <h2 class="title">合作伙伴 <span>/ Partners</span></h2>

            <ul>
                <li><a href="javascript:;"><img src="images/link1.jpg"/></a></li>
                <li><a href="javascript:;"><img src="images/link2.jpg"/></a></li>
                <li><a href="javascript:;"><img src="images/link3.jpg"/></a></li>
                <li><a href="javascript:;"><img src="images/link4.jpg"/></a></li>
                <li><a href="javascript:;"><img src="images/link5.jpg"/></a></li>
                <li><a href="javascript:;"><img src="images/link6.jpg"/></a></li>
                <li><a href="javascript:;"><img src="images/link7.jpg"/></a></li>
                <li><a href="javascript:;"><img src="images/link8.jpg"/></a></li>
                <li><a href="javascript:;"><img src="images/link9.jpg"/></a></li>
                <li><a href="javascript:;"><img src="images/link1.jpg"/></a></li>
                <div class="clearfix"></div>
            </ul>
        </div>
        <!--width1003/-->
    </div>
    <!--links/-->
</div>
<!--content/-->
<%@include file="inc/footer.jsp" %>
<script src="js/jquery.js"></script>
<script type="text/javascript" src="js/mousewheel.js"></script>
<script type="text/javascript" src="js/jquery.easing.js"></script>
<script type="text/javascript" src="js/history.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/style.js"></script>
<!--焦点轮换-->
<script src="js/jquery.excoloSlider.js"></script>
<%--新闻--%>
<script type="text/javascript" src="js/lrtk.js"></script>
<%--主页JS--%>
<script src="js/home.js"></script>
<script src="js/global.js"></script>
<%--city--%>
<script src="js/Popt.js"></script>
<script src="js/cityJson.js"></script>
<script src="js/homeCitySet.js"></script>

</body>
</html>
