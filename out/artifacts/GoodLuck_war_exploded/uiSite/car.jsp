
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.logistics.bean.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>车源信息</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Bootstrap -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">
  <link href="css/response.css" rel="stylesheet">
  <link href="css/silde.css" rel="stylesheet">
  <link href="css/city.css" rel="stylesheet">
  <link href="ext/css/bootstrap.css" rel="stylesheet">
  <link href="ext/css/style.css" rel="stylesheet" type="text/css" media="all" />
  <link rel="stylesheet" href="ext/css/swipebox.css">
  <!--Truck-->
  <link rel="stylesheet" href="css/Truck.css">
  <!--Truck-->
<!--table-->
  <link href="assets/Bootstrap.min.css" rel="stylesheet" media="screen">
  <link href="css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
  <!--table-->
  <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
  <script src="ext/js/modernizr.custom.js"></script>
  <![endif]-->
  <!--分页-->


</head>
<body>
<%RecordSet<CarInfoAndPhone> recordSet  = (RecordSet<CarInfoAndPhone>)request.getAttribute("BookList");%>
<%ArrayList<CarLong> carLong  = (ArrayList<CarLong>)request.getAttribute("CarLongList");%>
<%ArrayList<CarType> carType  = (ArrayList<CarType>)request.getAttribute("CarTypeList");%>
<%ArrayList<CarInfo> carLimit = (ArrayList<CarInfo> )request.getAttribute("CarLimitList");%>
<%ArrayList<CoachType> coachType =(ArrayList<CoachType>)request.getAttribute("CoachTypeList");%>
<%
  Register register = (Register)request.getSession().getAttribute("register");
%>
<% int count = (Integer)(request.getAttribute("PageCount"));%>
<%--<% int i =(Integer)request.getAttribute("Page")); %>--%>
<%@include file="inc/header.jsp"%>
  <!--body-->
  <div class="Tr_main">
    <!--/************左边部分*************/-->
    <div class="Tr_main_left">
      <!--左边头部分-->
      <div class="Tr_main_left_top">
       <!--搜索部分-->
        <div style="float: left;">
          <%--<form id="" action="">--%>
            <!-- 区分点击的是搜索按钮（初始化从第一条开始查）还是分页链接 -->
            <input type="hidden" id="flagId" value="" name="flag">
            <div id="con_two_1" class="Tr_mian_sach_sect">
              <ul>
                <li>出发地&nbsp;&nbsp;&nbsp;</li>
                <li>
                  <input type="text" id="startPcc" name="startPcc" value="" class="city_input  inputFocus proCityQueryAll proCitySelAll" placeholder="请选择/输入城市名称">
                </li>
                <li>目的地&nbsp;&nbsp;&nbsp;</li>
                <li>
                  <input type="text" id="endPcc" name="endPcc" value="" class="city_input  inputFocus proCityQueryAll proCitySelAll" placeholder="请选择/输入城市名称">
                </li>
              </ul>
              <dl>
                <dt>车长(米)</dt>
                <input type="hidden" id="returnCarLength" name="carLength" value="">
                <dd>
                  <div id="CarLengthDictId">
                    <a href="javascript:void('0');" onclick="btn_CarLong('')"  class="out">全部</a>
                    <%for(CarLong cl:carLong){%>
                    <a href="javascript:void(0);" onclick="btn_CarLong('<%=cl.getCarsLong()%>')"><%=cl.getCarsLong()%></a>
                    <%}%>
                  </div>
                </dd>
              </dl>
              <dl>
                <dt>车辆类型</dt>
                <input type="hidden" id="returnCarPlateType" name="vehicleType" value="">
                <dd>
                  <div>
                    <span id="CarPlateTypeDictId">
                      <a href="javascript:void(0);" onclick="btn_CarType('')" class="out">全部</a>

                      <%for(CarType ct:carType){%>
                       <a href="javascript:void(0);" onclick="btn_CarType('<%=ct.getType()%>')"><%=ct.getType()%></a>
                      <%}%>
                    </span>
                  </div>
                </dd>
              </dl>
              <dl>
                <dt>车厢类型</dt>
                <input type="hidden" id="returnCarBarType" name="carriageType" value="">
                <dd>
                  <div>
                    <span id="CarBarTypeDictId">
                      <a href="javascript:void(0);" onclick="btn_CoachType('')" class="out">全部</a>
                      <%for(CoachType Co:coachType){%>
                      <a href="javascript:void(0);" onclick="btn_CoachType('<%=Co.getType()%>')"><%=Co.getType()%></a>
                        <%}%>
                  </div>
                </dd>
              </dl>

            </div>

            <input type="hidden" id="curPage" name="curPage" value="0"><!-- 需要显示页面 -->

            <div class="firs">
              <button class="btn btn-warning" onclick="btn_warning(this)" data-state="<%=register==null?0:1%>">搜索</button>

            </div>
          <%--</form>--%>
        </div>
        <!--搜索部分结束-->
      </div>
      <!--/左边头部分-->
      <div class="Tr_shadow"></div>
      <!--left_body-->
      <div class="block" style="margin-bottom: 50px;">
        <div class="block-content collapse in">
          <%--<div class="span12">--%>

            <table cellpadding="0" cellspacing="0" border="1" class="table table-striped">
              <thead>
              <tr>
                <th></th>
                <th>车牌号</th>
                <th>车长</th>
                <th>车型</th>
                <th>车厢类型</th>
                <th>起始地</th>
                <th>终点地</th>
                <th></th>
              </tr>
              </thead>
              <tbody id="Tab" >
              <%for(CarInfoAndPhone c:recordSet.getRecordSet()){%>
              <tr class="odd gradeX">
                <td><img src="images/indentity.png" width="22" height="22"> </td>
                <td><%=c.getCarNum()%></td>
                <td><%=c.getCarLong()%></td>
                <td><%=c.getCarType()%>&nbsp;</td>
                <td><%=c.getCoachType()%>&nbsp; &nbsp; </td>
                <td><%=c.getStartProvince()%>-<%=c.getStartCity()%></td>
                <td><%=c.getToProvince()%>-<%=c.getToCity()%></td>
                <td>
                <%
                if(null==register){
                %>
                  <a href="login.jsp"><img src="images/telephone.png" width="22" height="22" ></a></td>
                <%
                   }else{
                %>
                  <%=c.getPhone()%>
                <%
                }
                %>
              </tr>
              <%}%>
              </tbody>
            </table>

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
          <%--</div>--%>
        </div>
      </div>
      <!--left_/body-->
    </div>
      <!--/*********右边部分*********/-->
      <div class="Tr_main_right">
        <!--right_top-->
        <div class="Tr_main_right_top dues" id="cart" style="height: 218px;">
         <div class="cart">
          <a class="at">搜索车源</a>
          <a class="at1">选择车辆</a>
          <a class="at2">确定车辆</a>
          <a class="at3">联系车主</a>
          </div>
         </div>
        <!--right_body-->
        <div class="Tr_main_right_body" style="height: 742px;" id="driverCarId">

          <%for (CarInfo L:carLimit){%>
          <ul>
            <li><span>姓名：</span><%=L.getOwner()%><i class="iconf  ml20">&nbsp;</i></li>
            <li><span>车牌：</span><%=L.getCarNum()%></li>
            <li><span>常跑城市：</span>
              <div class="Tr_city"><%=L.getStartProvince()%><%=L.getStartCity()%><br>
              <%=L.getToProvince()%><%=L.getToCity()%>
              </div></li>
            <%--<li class="Tr_seef"><a href="javascript:void(0);">查看详情(<span style="color: #ED6c2c;">请先认证</span>)</a>--%>
          </ul>
          <%}%>



        </div>
      </div>

  </div>
  <!--/body-->
  <%@include file="inc/footer.jsp"%>
<!--/**************省市区*****************/-->
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/global.js"></script>
<script src="assets/scripts.js"></script>
<script src="js/car.js"></script>
<script src="js/Popt.js"></script>
<script src="js/cityJson.js"></script>
<script src="js/citySet.js"></script>
<script src="js/style.js"></script>

</body>
</html>
