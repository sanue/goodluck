
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
  <link href="css/bootstrap.css" rel="stylesheet">
  <link href="css/gloab.css" rel="stylesheet">
  <link href="css/index1.css" rel="stylesheet">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/home.css">
  <script src="js/jquery.js"></script>
  <script src="js/register.js"></script>
  <script src="js/cityJson.js"></script>
  <script src="js/citySet.js"></script>
  <script src="js/global.js"></script>
</head>
<body class="bgf4">
<%@include file="inc/header.jsp"%>
<div class="login-box f-mt10 f-pb50">
  <div class="main bgf">
    <div class="reg-box-pan display-inline">
      <div class="step">
        <ul>
          <li class="col-xs-4 on">
            <span class="num"><em class="f-r5"></em><i>1</i></span>
            <span class="line_bg lbg-r"></span>
            <p class="lbg-txt">设置登录信息</p>
          </li>
          <li class="col-xs-4">
            <span class="num"><em class="f-r5"></em><i>2</i></span>
            <span class="line_bg lbg-l"></span>
            <span class="line_bg lbg-r"></span>
            <p class="lbg-txt">填写账户信息</p>
          </li>
          <li class="col-xs-4">
            <span class="num"><em class="f-r5"></em><i>3</i></span>
            <span class="line_bg lbg-l"></span>
            <p class="lbg-txt">注册成功</p>
          </li>
        </ul>
      </div>
      <div class="reg-box" id="verifyCheck" style="margin-top:20px;">
        <div class="part1">
          <div class="item col-xs-12">
            <span class="intelligent-label f-fl"><b class="ftx04">*</b>用户名：</span>
            <div class="f-fl item-ifo">
              <input type="text" maxlength="20" class="txt03 f-r3 required" tabindex="1" data-valid="isNonEmpty||between:3-20||isUname" data-error="用户名不能为空||用户名长度3-20位||只能输入中文、字母、数字、下划线，且以中文或字母开头" id="adminNo" />                            <span class="ie8 icon-close close hide"></span>
              <label class="icon-sucessfill blank hide"></label>
              <label class="focus"><span id="checkUserName">3-20位，中文、字母、数字、下划线的组合，以中文或字母开头</span></label>
              <label class="focus valid"></label>
            </div>
          </div>
          <div class="item col-xs-12">
            <span class="intelligent-label f-fl"><b class="ftx04">*</b>密码：</span>
            <div class="f-fl item-ifo">
              <input type="password" id="password" maxlength="20" class="txt03 f-r3 required" tabindex="3" style="ime-mode:disabled;" onpaste="return  false" autocomplete="off" data-valid="isNonEmpty||between:6-20||level:2" data-error="密码不能为空||密码长度6-20位||该密码太简单，有被盗风险，建议字母+数字的组合" />
              <span class="ie8 icon-close close hide" style="right:55px"></span>
              <span class="showpwd" data-eye="password"></span>
              <label class="icon-sucessfill blank hide"></label>
              <label class="focus">6-20位英文（区分大小写）、数字、字符的组合</label>
              <label class="focus valid"></label>
              <span class="clearfix"></span>
              <label class="strength">
                <span class="f-fl f-size12">安全程度：</span>
                <b><i>弱</i><i>中</i><i>强</i></b>
              </label>
            </div>
          </div>
          <div class="item col-xs-12">
            <span class="intelligent-label f-fl"><b class="ftx04">*</b>确认密码：</span>
            <div class="f-fl item-ifo">
              <input type="password" maxlength="20" class="txt03 f-r3 required" tabindex="4" style="ime-mode:disabled;" onpaste="return  false" autocomplete="off" data-valid="isNonEmpty||between:6-16||isRepeat:password" data-error="密码不能为空||密码长度6-16位||两次密码输入不一致" id="rePassword" />
              <span class="ie8 icon-close close hide" style="right:55px"></span>
              <span class="showpwd" data-eye="rePassword"></span>
              <label class="icon-sucessfill blank hide"></label>
              <label class="focus">请再输入一遍上面的密码</label>
              <label class="focus valid"></label>
            </div>
          </div>
          <div class="item col-xs-12" style="height:auto">
            <span class="intelligent-label f-fl">&nbsp;</span>
            <p class="f-size14 required"  data-valid="isChecked" data-error="请先同意条款">
              <input type="checkbox" checked /><a href="javascript:showoutc();" class="f-ml5">我已阅读并同意条款</a>
            </p>
            <label class="focus valid"></label>
          </div>
          <div class="item col-xs-12">
            <span class="intelligent-label f-fl">&nbsp;</span>
            <div class="f-fl item-ifo">
              <a href="javascript:;" class="btn btn-blue f-r3" id="btn_part1">下一步</a>
            </div>
          </div>
        </div>
        <!--------------------------------------------第二部分-------------------------------------------------------------->
        <div class="part2" style="display:none">
          <div class="item col-xs-12">
            <span class="intelligent-label f-fl"><b class="ftx04">*</b>性别：</span>
            <div class="f-fl item-ifo">
              <label><input type="radio" name="sex" value="男" checked="checked">男</label><label><input type="radio" value="女" name="sex">女</label>
              <label class="icon-sucessfill blank hide"></label>
              <label class="focus valid"></label>
            </div>
          </div>
          <div class="item col-xs-12">
            <span class="intelligent-label f-fl"><b class="ftx04">*</b>手机号码：</span>
            <div class="f-fl item-ifo">
              <input id="phoneNum" type="text" maxlength="20" class="txt03 f-r3 required" tabindex="1"  />                            <span class="ie8 icon-close close hide"></span>
              <label class="icon-sucessfill blank hide"></label>
              <label class="focus"><span>移动，联通，电信号段</span></label>
              <label class="focus valid"></label>
            </div>
          </div>
          <div class="item col-xs-12">
            <span class="intelligent-label f-fl"><b class="ftx04">*</b>身份：</span>
            <div class="f-fl item-ifo">
              <select>
                <option value="-1">--请选择--</option>
                <option value="0">--车主--</option>
                <option value="1">--货主--</option>
              </select>                           <span class="ie8 icon-close close hide"></span>
              <label class="icon-sucessfill blank hide"></label>
              <label class="focus valid"></label>
            </div>
          </div>
          <div class="item col-xs-12">
            <span class="intelligent-label f-fl">&nbsp;</span>
            <div class="f-fl item-ifo">
              <a href="javascript:;" class="btn btn-blue f-r3" id="btn_part2">注册</a>
            </div>
          </div>
        </div>


        <!---------------------------------------------------------第三部分--------------------------------------------------->

        <div class="part4 text-center" style="display:none">
          <h3>恭喜，您已注册成功，现在开始您的好运之旅吧！</h3>
          <%--这里加上了跳转按钮--%>
          <input class="ternow3" style="float: left;" name="" id="saveBtn3" onclick="window.location.href='/'" type="button" value="返回首页">
          <input class="ternow3" style="margin-left: 30px;" id="saveBtn4" onclick="window.location.href='/uiSite/login.jsp'" type="button" value="现在登录">
          <!--<p class="c-666 f-mt30 f-mb50">页面将在 <strong id="times" class="f-size18">10</strong> 秒钟后，跳转到 <a href="my.html" class="c-blue">用户中心</a></p>-->
        </div>
      </div>
    </div>
  </div>
</div>
<div class="m-sPopBg" style="z-index:998;"></div>
<div class="m-sPopCon regcon">
  <div class="m-sPopTitle"><strong>服务协议条款</strong><b id="sPopClose" class="m-sPopClose" onClick="closeClause()">×</b></div>
  <div class="apply_up_content">
    	<pre class="f-r0">
		<strong>同意好运多服务条款，提交注册信息</strong>
        </pre>
  </div>
  <center><a class="btn btn-blue btn-lg f-size12 b-b0 b-l0 b-t0 b-r0 f-pl50 f-pr50 f-r3" href="javascript:closeClause();">已阅读并同意此条款</a></center>
</div>
<script>
  //验证用户名是否已存在的事件
  $("#adminNo").keyup(function(){
    var inputUserName=document.querySelector("#adminNo").value;
    $.post(
            "checkUserName.do",
            {"inputUserName":inputUserName},
            function(data){
              if(data==1){
//                alert("该用户名已存在！")
                $("#checkUserName").text("该用户名已存在").css('color','red');
              }else{
                $("#checkUserName").text("3-20位，中文、字母、数字、下划线的组合，以中文或字母开头").css('color','grey')
              }
            },
            "text"
    );
  })
  $(function(){
    //第一页的确定按钮
    $("#btn_part1").click(function(){
      if(!verifyCheck._click()) return;
      $(".part1").hide();
      $(".part2").show();
      $(".step li").eq(1).addClass("on");
    });
    //第二页的确定按钮
    $("#btn_part2").click(function(){
      //---------------------AJAX进行注册操作开始--------------------------------------------------------------------------
      var userName=document.querySelector("#adminNo").value;
      var userPwd=document.querySelector("#password").value;
      var phoneNum=document.querySelector("#phoneNum").value;
      var sex=$(":radio:checked").val();
      var identity=$("option:selected").val();
      $.post(
              "register.do",
              {"userName":userName,"userPwd":userPwd,"phoneNum":phoneNum,"sex":sex,"identity":identity},
              function(data){
                if(data==1){
                  $(".part2").hide();
                  $(".part4").show();
                  $(".step li").eq(2).addClass("on");
                }
              },
              "text"
      );
    });
    //---------------------AJAX进行注册操作结束--------------------------------------------------------------------------
  });
  function showoutc(){$(".m-sPopBg,.m-sPopCon").show();}
  function closeClause(){
    $(".m-sPopBg,.m-sPopCon").hide();
  }
</script>
<%@include file="inc/footer.jsp"%>
</body>
</html>
