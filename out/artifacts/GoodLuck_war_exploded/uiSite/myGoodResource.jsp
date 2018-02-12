<%@ page import="java.util.ArrayList" %>
<%@ page import="com.logistics.bean.Goods" %>
<%--我的运单页--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  request.setCharacterEncoding("utf-8");
  ArrayList<Goods> gd = new ArrayList<Goods>();
  String name = (String)request.getAttribute("register");
  if(null==name){
    response.sendRedirect("login.jsp");
  }else{
    gd=(ArrayList<Goods>) request.getAttribute("goods");
  }

%>
<html>
<head>
  <title></title>
  <!-- Bootstrap -->
  <link rel="stylesheet" type="text/css" href="css/history.css">

  <!-- Bootstrap -->
  <link href="css/bootstrap.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">
  <link href="css/response.css" rel="stylesheet">
  <link href="css/silde.css" rel="stylesheet">
  <link type="text/css" href="css/lrtk.css" rel="stylesheet"/>
  <link href="ext/css/bootstrap.css" rel="stylesheet">
  <link href="ext/css/style.css" rel="stylesheet" type="text/css" media="all"/>
  <link rel="stylesheet" href="ext/css/swipebox.css">
  <%--<!-- 主页 -->--%>
  <%--city--%>
  <link href="css/city.css" rel="stylesheet">
  <%--回到顶部--%>
  <link href="css/sucaijiayuan.css" rel="stylesheet" type="text/css" />
  <%--city--%>
  <link rel="stylesheet" href="css/dateSelect.css">
  <link href="css/boxPlugin.css" rel="stylesheet" type="text/css">
  <link href="css/lessload.css" rel="stylesheet" type="text/css">
  <link href="css/g.css" rel="stylesheet" type="text/css">
  <link href="css/fulltruckorderlist.css" rel="stylesheet" type="text/css">
  <link href="css/city.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="inc/header.jsp"%>
<div class="width1003" style="min-height: 500px">
  <div class="k_filter statusList">
    <div class="fl">
      <a href="javascript:void (0);" class="active">历史记录</a>

    </div>
    <div class="fr mt5">
      <a href="basicInfo.html"><button  class="btn  btn-orange">返回</button></a>
    </div>
  </div>
  <div class="k_filter timeAddQuery" style="overflow: inherit">
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
    <button id="J_reset_btn" class="btn btn-small" onclick="reset_btn()">重置</button><button id="J_fullTruck_btn" class="btn btn-small btn-orange">查询</button>
  </div>
  <!-- 条件筛选 end -->
  <!-- 筛选结果 start -->
  <div class="table_content" id="fullTruckItems">
    <table id="tab" class="table_gray J_transPopBtn">
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
        <th>操作</th>
      </tr>
      </thead>
      <tbody>
      <%--页面加载时显示该用户的所有的订单信息。点击条件筛选时清空tbody，加载条件筛选的内容--%>
      <%

        for(Goods goods:gd){
      %>
      <tr>
        <td ><%=goods.getName()%></td>
        <td ><%=goods.getWeight()%></td>
        <td ><%=goods.getCarLong()%>&nbsp;</td>
        <td ><%=goods.getCarType()%>&nbsp; </td>
        <td ><%=goods.getCoachType()%></td>
        <td><%=goods.getStartProvince()%>—<%=goods.getStartCity()%></td>
        <td><%=goods.getToProvince()%>—<%=goods.getToCity()%></td>
        <td><%=goods.getShipmentTime()%></td>
        <td data-id="<%=goods.getId()%>" onclick="delUploadTr(this)">删除</td>

      </tr>
      <%
        }
      %>

      </tbody>
    </table>
  </div>
  <!-- 筛选结果 end -->
</div>
<%@include file="inc/footer.jsp"%>
<script src="js/jquery.js"></script>
<script type="text/javascript" src="js/dateSelect.js"></script>
<script src="js/Popt.js"></script>
<script src="js/cityJson.js"></script>
<script src="js/citySet.js"></script>
<script src="js/global.js"></script>
<script type="text/javascript">
  //点击日期和地区文本框出现关联查询
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
              {"id":id},
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
    var fromRegion=document.querySelector("#city").value;
    var toRegion=document.querySelector("#city1").value;
    $.post(
            "queryMyGoods.do",
            {"fromRegion":fromRegion,"toRegion":toRegion},
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
      $td.text(obj.name);
      $tr.append($td);

      var $td=$("<td></td>");
      $td.text(obj.weight);
      $tr.append($td);

      var $td=$("<td></td>");
      $td.text(obj.carLong);
      $tr.append($td);

      var $td=$("<td></td>");
      $td.text(obj.carType);
      $tr.append($td);

      var $td=$("<td></td>");
      $td.text(obj.coachType);
      $tr.append($td);

      var $td=$("<td></td>");
      $td.text(obj.startProvince+"-"+obj.startCity);
      $tr.append($td);

      var $td=$("<td></td>");
      $td.text(obj.toProvince+"-"+obj.toCity);
      $tr.append($td);

      var $td=$("<td></td>");
      $td.text(obj.shipmentTime);
      $tr.append($td);


      var $td=$("<td></td>");
      var $span = $("<span></span>");
      $span.text("删除");
      $span[0].onclick=function(){
        var isDel=confirm("确定要删除该条记录吗？");
        if(isDel){
          $.get(
                  "delete.do",
                  {"id":obj.id},
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
  function reset_btn(){
    $('#city').val('');
    $('#city1').val("");
  }
</script>
</body>
</html>


