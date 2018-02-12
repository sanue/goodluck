<%@ page import="com.logistics.bean.FormOrder" %>
<%@ page import="java.util.ArrayList" %>
<%--我的运单页--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  request.setCharacterEncoding("utf-8");
  ArrayList<FormOrder> fo=(ArrayList<FormOrder>) request.getAttribute("formorder");
%>
<html>
<head>
  <title></title>
  <link rel="stylesheet" href="css/dateSelect.css">
  <link href="css/boxPlugin.css" rel="stylesheet" type="text/css">
  <link href="css/lessload.css" rel="stylesheet" type="text/css">
  <link href="css/g.css" rel="stylesheet" type="text/css">
  <link href="css/fulltruckorderlist.css" rel="stylesheet" type="text/css">
  <link href="css/city.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="w1200">
  <!-- 条件筛选 start -->
  <div class="k_filter statusList">
    <div class="fl">
      <a href="?" class="active">全部订单</a>
    </div>
    <div class="fr mt5">
      <label for="orderId">订单号：</label>
      <div class="orderIdInp">
        <input type="text" name="orderId" placeholder="请输入订单号" value="">
      </div>
      <button id="J_fullTruckOrder_btn" class="btn btn-small btn-orange">搜索</button>
    </div>
  </div>
  <div class="k_filter timeAddQuery" style="overflow: inherit">
    <div class="fl">
      <label>装车时间：</label>
      <div class="dateInputCon">
        <input type="text" id="date" name="startTime" value="" class="text inSmall-L dateInput" placeholder="选择日期" style="height: 32px;padding: 0 5px;">
      </div>
      <span class="split">-</span>
      <div class="dateInputCon">
        <input type="text" id="date1" name="endTime" value="" class="text inSmall-L dateInput" placeholder="选择日期" style="height: 32px;padding: 0 5px;">
      </div>
    </div>
    <ul class="fl">
      <li class="sch">
        <span class="tit">起始地</span>
        <div class="lj_select" id="areaSelectFrom" data-pid="1120000000" data-cid="1120300000" data-tid="1120303000">
          <div class="area_name">
            <input id="city" type="text" class="area_title" placeholder="城市名（中文/拼音）" value="">
          </div>
        </div>
      </li>
      <li class="sch">
        <span class="tit">目的地</span>
        <div class="lj_select" id="areaSelectTo" data-pid="" data-cid="" data-tid="">
          <div class="area_name">
            <input id="city1" type="text" class="area_title" placeholder="城市名（中文/拼音）" style="width: 70%;" value="">
          </div>
        </div>
      </li>
    </ul>
    <input type="hidden" name="status" value="">
    <button id="J_reset_btn" class="btn btn-small">重置</button><button id="J_fullTruck_btn" class="btn btn-small btn-orange">查询</button>
    <a href="javascript:;" id="excel" target="_blank">导出当前报表</a>
  </div>
  <!-- 条件筛选 end -->
  <!-- 筛选结果 start -->
  <div class="table_content" id="fullTruckItems">
    <table id="tab" class="table_gray J_transPopBtn">
      <thead>
      <tr>
        <td width="180">订单号</td>
        <td width="180">起止地</td>
        <td>货物信息</td>
        <td width="130">装车日期</td>
        <td width="160">运输车辆</td>
        <td width="90">订单状态</td>
        <td width="150">操作</td>
      </tr>
      </thead>
      <tbody>
      <%--页面加载时显示该用户的所有的订单信息。点击条件筛选时清空tbody，加载条件筛选的内容--%>
      <%
        for(FormOrder fOrder:fo){
      %>
      <tr>
        <td><%=fOrder.getOrderNum()%></td>
        <td><%=fOrder.getStartCity()+"-"+fOrder.getToCity()%></td>
        <td><%=fOrder.getGoodsName()%></td>
        <td><%=fOrder.getTime()%></td>
        <td><%=fOrder.getCarNum()%></td>
        <td><%=fOrder.getState()%></td>
        <td data-id="<%=fOrder.getOrderNum()%>" onclick="delUploadTr(this)">删除</td>
      </tr>
      <%
        }
      %>

      </tbody>
    </table>
  </div>
  <!-- 筛选结果 end -->
</div>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="js/dateSelect.js"></script>
<script src="js/Popt.js"></script>
<script src="js/cityJson.js"></script>
<script src="js/citySet.js"></script>
<script type="text/javascript">
  //点击日期和地区文本框出现关联查询
  $("#date").dateSelect();
  $("#date1").dateSelect();
  $("#city").click(function (e) {
    SelCity(this,e);
  });
  $("#city1").click(function (e) {
    SelCity(this,e);
  });
  //默认加载页面的删除事件
  function delUploadTr(obj){
    var id=$(obj).data("id");
    var isDel=confirm("确定要删除该条记录吗?");
    if(isDel){
      $.get(
              "delete.do",
              {"orderNum":id},
              function(e){
                if(e==1){
                  alert("删除成功");
                  $(obj).parent().remove();
                }else{
                  alert("删除失败")
                }
              },
              "text"
      );
    }
  }

  //点击查询按钮触发的事件
  $("#J_fullTruck_btn").click(function(){
    $("tbody").empty();
    var fromDate=document.querySelector("#date").value;
    var toDate=document.querySelector("#date1").value;
    var fromRegion=document.querySelector("#city").value;
    var toRegion=document.querySelector("#city1").value;
    $.post(
            "queryGoodsOrder.do",
            {"fromDate":fromDate,"toDate":toDate,"fromRegion":fromRegion,"toRegion":toRegion},
            function(data){
              if(data!=null){
                var $container=$("#tab");
                for(var i=0;i<data.length;i++){
                  $container.append(createTr(data[i]));
                }

              }

            },
            "json"
    );
    function createTr(obj){
      var $tr=$("<tr></tr>");

      var $td=$("<td></td>");
      $td.text(obj.orderNum);
      $tr.append($td);

      var $td=$("<td></td>");
      $td.text(obj.startCity+"-"+obj.toCity);
      $tr.append($td);

      var $td=$("<td></td>");
      $td.text(obj.goodsName);
      $tr.append($td);

      var $td=$("<td></td>");
      $td.text(obj.time);
      $tr.append($td);

      var $td=$("<td></td>");
      $td.text(obj.carNum);
      $tr.append($td);

      var $td=$("<td></td>");
      $td.text(obj.state==1?"已完成":"已接单");
      $tr.append($td);

      var $td=$("<td></td>");
      var $span = $("<span></span>");
      $span.text("删除");
      $span[0].onclick=function(){
        var isDel=confirm("确定要删除该条记录吗？");
        if(isDel){
          $.get(
                  "delete.do",
                  {"orderNum":obj.orderNum},
                  function(e){
                    if(e==1){
                      alert("删除成功");
                      $tr.remove();
                    }else{
                      alert("删除失败")
                    }
                  },
                  "text"
          );
        }
      }
      $td.append($span);
      $tr.append($td);

      return $tr;
    }
  })
</script>
</body>
</html>

