
<%@ page import="com.logistics.bean.RecordSet" %>
<%@ page import="com.logistics.bean.GoodsAndPhone" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <%--<meta name="Author" contect="http://www.webqin.net">--%>
  <title>货源信息</title>
  <%--<link rel="shortcut icon" href="images/favicon.ico" />--%>

  <!-- Bootstrap -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">
  <link href="css/response.css" rel="stylesheet">
  <link href="css/silde.css" rel="stylesheet">
  <link href="ext/css/bootstrap.css" rel="stylesheet">
  <link href="ext/css/style.css" rel="stylesheet" type="text/css" media="all" />
  <link rel="stylesheet" href="ext/css/swipebox.css">
  <%--city--%>
  <link href="css/city.css" rel="stylesheet">
  <!--Truck-->
  <link rel="stylesheet" href="css/Goods.css">
  <!--Truck-->
  <link href="assets/Bootstrap.min.css" rel="stylesheet" media="screen">
  <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
  <!-- js -->
  <script src="ext/js/modernizr.custom.js"></script>
  <!--[if lt IE 9]>
  <![endif]-->
  <style>
    #example>tbody>tr>td,#example>thead>tr>th{
      padding: auto 0px;!important
    }
  </style>
</head>
<body>
<%
  RecordSet<GoodsAndPhone> goods = (RecordSet<GoodsAndPhone>)request.getAttribute("goodsAndPhone");
  Register register = (Register)request.getSession().getAttribute("register");

%>

<%@include file="inc/header.jsp"%>
<!--body-->
<div class="Tr_main">
  <!--/************左边部分*************/-->
  <div class="Tr_main_left">
    <!--左边头部分-->
    <div class="Tr_main_left_top">
      <!--搜索部分-->
      <div style="float: left;">

        <!-- 区分点击的是搜索按钮（初始化从第一条开始查）还是分页链接 -->
        <input type="hidden" id="flagId" value="" name="flag">
        <div class="Gd_main_top">
          <div class="Gd_shng Gd_firof">
            <ul>
              <li>
                <label>装货时间:<span style="color: #FF0000">*</span></label>
                <input id="requestStartTime" name="requestStartTime"  type="date" class="int" style="margin-top: -2px; width: 140px;" >
                <div class="mpt" id="divRequestStartTimeZhu" style="display: none;">
                  <div class="wn_a"></div>
                  <div class="wn_s" id="divRequestStartTimeNull">装货时间不能为空！</div>
                  <div class="wn_c"></div>
                </div>
              </li>
              <li>
                <label>&nbsp;装货地:<span style="color: #FF0000">*</span></label>
                <input id="startPcc" name="startPcc"  value="" type="text" class="city_input  inputFocus proCityQueryAll proCitySelAll" style="margin-top: -2px; width: 140px;">
                <div class="mpt" id="divStartPccZhu" style="display: none;">
                  <div class="wn_a"></div>
                  <div class="wn_s" id="divStartPccNull">装货地不能为空！</div>
                  <div class="wn_c"></div>
                </div>
              </li>
              <li>
                <label>&nbsp;卸货地:<span style="color: #FF0000">*</span></label>
                <input id="endPcc" name="endPcc" value="" type="text" class="city_input  inputFocus proCityQueryAll proCitySelAll" style="margin-top: -2px;width: 140px;">
              </li>
            </ul>
          </div>
        </div>
        <div class="firs">
          <button id="btn_search" class="btn btn-warning" style="margin-right: -15px; margin-bottom: 15px;" onclick="searchBySel(1)">搜索</button>
        </div>
        <input type="hidden" id="curPage" name="curPage" value="0"><!-- 需要显示页面 -->
      </div>
      <!--搜索部分结束-->
    </div>
    <!--/左边头部分-->
    <div class="Tr_shadow"></div>
    <!--left_body-->


    <div class="block">

      <div class="block-content collapse in">
        <%--<div class="span12">--%>

        <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-hover"  style="font-size: 12px;">
          <thead>
          <tr>
            <th>货物</th>
            <th>重量</th>
            <th>长</th>
            <th>车型</th>
            <th>类型</th>
            <th>起始地</th>
            <th>终点地</th>
            <th>发货时间</th>
            <th>手机号</th>
          </tr>
          </thead>
          <tbody id="mydata">
          <%for(GoodsAndPhone G:goods.getRecordSet()){%>
          <tr><td><%=G.getName()%></td><td ><%=G.getWeight()%></td><td ><%=G.getCarLong()%>&nbsp;</td><td ><%=G.getCarType()%>&nbsp; </td><td ><%=G.getCoachType()%></td><td><%=G.getStartProvince()%>—<%=G.getStartCity()%></td><td><%=G.getToProvince()%>—<%=G.getToCity()%></td><td><%=G.getShipmentTime()%></td><td>
              <%
                if(null==register){
              %>
              <a href="login.jsp"><img src="images/telephone.png"width="22" height="22" ></a>
              <%
                }else{
              %>
              <%=G.getPhone()%>
              <%
                }
              %>
            </td>
          </tr>
          <%
            }
          %>

          </tbody>
        </table>
          <div class="row">
            <div class="span6">
              <div class="dataTables_paginate paging_bootstrap pagination" >
                <ul id="pageCode">
                  <%
                  for(int i = 0;i<goods.getPageCode();i++){
                  %>
                  <li class=""><a href="javascript:void(0)" onclick="searchBySel(<%=i+1%>)"><%=i+1%></a></li>
                  <%
                    }
                  %>

                  <%--<li class=""><a href="#">2</a></li>
                  <li class=""><a href="#">3</a></li>--%>
                </ul>
              </div>
            </div>
          </div>
        <%--</div>--%>
      </div>
    </div>



    <!--left_/body-->
  </div>
  <!--/*********右边部分*********/-->
  <div class="Tr_main_right">
    <!--right_top-->
    <div class="Tr_main_right_top dues" style="height: 218px;">
      <a class="at">搜索车源</a>
      <a class="at1">选择车辆</a>
      <a class="at2">确定车辆</a>
      <a class="at3">联系车主</a>
    </div>
    <!--right_body-->
    <div class="Tr_main_right_body" style="height: 742px;" id="driverCarId">
      <ul>
        <li class="Tr_seef"><a href="javascript:void(0);" style="text-decoration:none;">明星司机:潘嘉诚</a></li>
        <li><span>车牌：</span>桂A79105</li>
        <li><span>常跑城市：</span>
          <div class="Tr_city">广西壮族自治区南宁市&nbsp;&nbsp;&nbsp;&nbsp;广西壮族自治区崇左市<br>广西壮族自治区来宾市&nbsp;&nbsp;&nbsp;&nbsp;广西壮族自治区柳州市<br>广西壮族自治区百色市</div>
        </li>

      </ul>
      <ul>
        <li class="Tr_seef"><a href="javascript:void(0);" style="text-decoration:none;">明星司机:黄成</a></li>
        <li><span>车牌：</span>桂AE6159</li>
        <li><span>常跑城市：</span><div class="Tr_city">江苏省苏州市<br>浙江省杭州市</div></li>

        </li>
      </ul>
      <ul>
        <li class="Tr_seef"><a href="javascript:void(0);" style="text-decoration:none;">明星司机:李海旺</a></li>
        <li><span>车牌：</span>浙A5F768</li>
        <li><span>常跑城市：</span><div class="Tr_city">湖北省武汉市<br>山东省济南市</div></li>

      </ul>
      <ul>
        <li class="Tr_seef"><a href="javascript:void(0);" style="text-decoration:none;">明星司机:卢明雷</a></li>
        <li><span>车牌：</span>豫P6C021</li>
        <li><span>常跑城市：</span><div class="Tr_city">河南省郑州市<br>浙江省衢州市<br>广东省广州市</div></li>

      </ul>
    </div>
  </div>

</div>
<!--/body-->
<%@include file="inc/footer.jsp"%>

<script src="js/jquery.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="assets/scripts.js"></script>
<script src="js/Popt.js"></script>
<script src="js/cityJson.js"></script>
<script src="js/citySet.js"></script>
<script src="js/global.js"></script>
<script src="js/style.js"></script>
<script>
  $('.width1003>li>a').removeClass('navCur');
  $('.width1003>li:eq(2)>a').addClass('clickNav');
  $("#startPcc").click(function (e) {
    SelCity(this,e);
    console.log("inout",$(this).val(),new Date())
  });
  $("#endPcc").click(function (e) {
    SelCity(this,e);
    console.log("inout",$(this).val(),new Date())
  });
  //搜索按钮点击事件
  $("#btn_search").click(function(){
    $("tbody").empty();
    var loadingTime=document.querySelector("#requestStartTime").value;
    var startRegion=document.querySelector("#startPcc").value;
    var toRegion=document.querySelector("#endPcc").value;
    $.post(
            "queryGoods.do",
            {"loadingTime":loadingTime,"startRegion":startRegion,"toRegion":toRegion},
            function(data){
              if(data!=null){
                var $container=$("#example");
                for(var i=0;i< data.length;i++){
                  $container.append(createTr(data[i]));
                }
              }
            },
            "json"
    );


  });

  //动态创建行的方法
  function createTr(obj , phone){
    var $tr=$("<tr></tr>");

    var $td=$("<td></td>");
    $td.text(obj.name);
    $tr.append($td);

    var $td=$("<td></td>");
    $td.text(obj.weight);
    $tr.append($td);

    var $td=$("<td></td>");
    $td.append(obj.carLong);
    $tr.append($td);

    var $td=$("<td></td>");
    $td.append(obj.carType);
    $tr.append($td);

    var $td=$("<td></td>");
    $td.append(obj.coachType);
    $tr.append($td);

    var $td=$("<td></td>");
    $td.append(obj.startProvince+"-"+obj.startCity);
    $tr.append($td);

    var $td=$("<td></td>");
    $td.append(obj.toProvince+"-"+obj.toCity);
    $tr.append($td);

    var $td=$("<td></td>");
    $td.append(obj.shipmentTime);
    $tr.append($td);
    var $td=$("<td>"+phone+"</td>");
    /*<img src='images/telephone.png' width='32' height='32'>*/
    $tr.append($td);
    return $tr;

  }


  function searchBySel(count){
    var name = $('#login').text();
    var time = $('#requestStartTime').val();
    var startCity = $('#startPcc').val()==""?"":$('#startPcc').val().split('-')[1];
    var toCity = $('#endPcc').val()==''?'':$('#endPcc').val().split('-')[1];
    $.get(
            'searchBySel.do',
            {time:time,startCity:startCity,toCity:toCity,count:count},
            function(data){
              $('#mydata').empty();
              var obj = data.recordSet;
              var pageCoge = data.rowCount/data.pageSize==0?data.rowCount/data.pageSize:Math.ceil(data.rowCount/data.pageSize);
              if(obj!=null){
                for(var i = 0 ;i<obj.length;i++){
                  if(name=='登录'){
                    $('#mydata').append(createTr(obj[i] , "<a href='login.jsp'><img src='images/telephone.png'  width='22' height='22'></a>"))

                  }else{
                    $('#mydata').append(createTr(obj[i],obj[i].phone));
                  }
                }
              }
              $('#pageCode').empty();
              for(var i = 0;i<pageCoge;i++){
                $('#pageCode').append('<li><a href="javascript:void(0)" onclick="searchBySel('+(i+1)+')">'+(i+1)+'</a></li>')
              }
            },
            'json'
    )
  }
</script>
</body>
</html>