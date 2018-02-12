
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
</head>
<script language="javascript">
  var jcontextPath="";
</script>
<head>
  <title>好运多-用户-修改密码</title>

  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <script type="text/javascript" src="js/jquery.js"></script>
  <script type="text/javascript" src="js/textPrompt.js"></script>
  <%--自己写的JS--%>
  <script type="text/javascript" src="js/index.js"></script>
  <link href="css/public.css" rel="stylesheet" type="text/css"/>
  <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
  <link href="css/header.css" rel="stylesheet" type="text/css">
  <script type="text/javascript">
    $(function () {
      //初始化Input的灰色提示信息
      inputTipText();
    })
  </script>

</head>
<body>
<%
  String name=request.getParameter("name");
%>
<%--<%@include file="inc/header.jsp"%>--%>
<form id="mainForm" action="/" method="post">

  <!--------------------------------------------------主体1开始-------------------------------------------------->
  <section class="container section" id="section1" style="display:block;">
    <article class="row">
      <div class="container"style="width: 613px;"><div class="row div_img"><img src="images/num1_3.0.png" width="613px" height="48px" alt="" /></div></div>
      <div class="container" style="width:645px;">
        <div class="div_font_style row">
          <div class="div_color1 div_float">身份验证</div>
          <div class="div_color2 div_float">信息修改</div>
          <div class="div_color2">修改成功</div>
        </div>
      </div>
      <article class="container" style="width: 650px; border:none;margin-top:100px;">
        <div class="row">
          <ul style="list-style-type: none;">
            <li class="li1"><label><span class="span_red">*</span>用户名：</label>
              <input id="mobilephone" name="mobilephone" value="<%=name==null?"":name%>" readonly tipmsg="请输入用户名" type="text" class="int" onblur="on_blur('mobilephone');" onfocus="on_focus('mobilephone');" style="margin: 0 13px 0px 16px;" maxlength="11" >
            </li>
            <li class="li1">
              <div>
                <div style="float: left;">
                  <label style="line-height: 100px; height: 42px;"><span class="span_red">*</span>密&nbsp&nbsp&nbsp码：</label>
                  <input id="userPwd" name="userPwd" value="" tipmsg="请输入密码" type="password" class="int" onblur="on_blur('mobilephone');" onfocus="on_focus('mobilephone');" style="margin: 0 13px 0px 16px;" maxlength="11" >
                  <p id="userPwdTest"></p>
                </div>
                <div style="clear:both;"></div>
              </div>
            </li>
            <%--<li class="emt">--%>
            <%--<label style="display:block; padding-top: 8px;"></label>--%>
            <%--<input id="checkboxes" type="checkbox">&nbsp;我已经认真阅读并同意<a href="javascript:open();" id="btn">《好运多用户服务协议》</a></li>--%>
            <%--<li>--%>
            <label></label>
            <input type="button" id="btn_nextMoveOne" value="下一步"  class="ternow1" >
            </li>
          </ul>
          <div style="clear:both;"></div>
        </div>
        </div>
        <!--------------------------------------------------注册协议结束-------------------------------------------------->
        </div>
      </article>
    </article>
  </section>
  <!--------------------------------------------------主体1结束-------------------------------------------------->
  <!--------------------------------------------------主体2开始-------------------------------------------------->
  <section class="container section" id="section2" style="display: none;">
    <article class="row">
      <div class="container"style="width: 613px;">
        <div class="row div_img"><img src="images/num2_3.0.png" width="613px" height="48px" alt="" /></div>
      </div>
      <div class="container" style="width:645px;">
        <div class="div_font_style row">
          <div class="div_color1 div_float">身份验证</div>
          <div class="div_color1 div_float">信息修改</div>
          <div class="div_color2">修改成功</div>
        </div>
      </div>
      <article class="container" style="width: 630px; border:none;margin-top:100px;">
        <div class="row">
          <ul style="list-style-type: none;">
            <li class="li1">
              <div>
                <div style="float: left;">
                  <label style="line-height: 100px; height: 42px;"><span class="span_red">*</span>输入新密码：</label>
                  <input id="newUserPwd" name="userPwd" value=""  tipmsg="请输入密码" type="password" class="int"  style="margin: 0 13px 0px 16px;" maxlength="11" >
                  <p id="newUserPwdTest">新密码为6到20位英文、数字、字符</p>
                </div>
                <div style="clear:both;"></div>
              </div>
            </li>
            <li class="li1">
              <div>
                <div style="float: left;">
                  <label style="line-height: 100px; height: 42px;"><span class="span_red">*</span>确认新密码：</label>
                  <input id="confirmUserPwd" name="userPwd" value="" tipmsg="请输入密码" type="text" class="int"  style="margin: 0 13px 0px 16px;" maxlength="11" >
                  <p id="confirmUserPwdTest">必须与之前输入一致</p>
                </div>
                <div style="clear:both;"></div>
              </div>
            </li>
            <li style="padding-top: 5px;">
              <tt style="color:red;margin-left:63px;" id="errorPromptId"></tt>
            </li>
            <li>
              <label></label>
              <input class="ternow1" id="saveBtn" type="button" value="确认">
            </li>
          </ul>
          <div style="clear:both;"></div>
        </div>
      </article>
    </article>
  </section>
  <!--------------------------------------------------主体2结束-------------------------------------------------->
  <!--------------------------------------------------主体3开始-------------------------------------------------->
  <section class="container section" id="section3" style="display: none;">
    <article class="row">
      <div class="container"style="width: 613px;"><div class="row div_img"><img src="images/num3_3.0.png" width="613px" height="48px" alt="" /></div></div>
      <div class="container" style="width:645px;">
        <div class="div_font_style row">
          <div class="div_color1 div_float">身份验证</div>
          <div class="div_color1 div_float">信息修改</div>
          <div class="div_color2">修改成功</div>
        </div>
      </div>
      <article class="container" style="width: 630px; border:none;margin-top:100px;">
        <div class="row">
          <div style="width: 600px;height: 80px">
            <div class="div_sz">恭喜您，修改成功！</div>
            <div class="div_sz1">为了保护您的账户安全，并能够使用更多服务，请及时进行在线认证。</div>
          </div>
          <form id="mainForm3" action="#" method="post">
            <label></label>
            <input class="ternow3" style="float: left;" name="" id="saveBtn3" onclick="window.location.href='/'" type="button" value="返回首页">
            <input class="ternow3" style="margin-left: 30px;" id="saveBtn4" onclick="window.location.href='/uiSite/login.jsp'" type="button" value="在线认证">
            <div style="clear:both;"></div>
          </form>
        </div>
      </article>
    </article>
  </section>
  <!--------------------------------------------------主体3结束-------------------------------------------------->
  <div class="div_hr"></div>
  <!--------------------------------------------------底部开始-------------------------------------------------->

  <!--------------------------------------------------底部结束-------------------------------------------------->
</form>
<script type="text/javascript">
  $("#userPwd").keyup(function(){
            var userName=document.querySelector("#mobilephone").value;
            var userPwd=document.querySelector("#userPwd").value;

            $.post(
                    "checkUserPwd.do",
                    {"userName":userName,"userPwd":userPwd},
                    function(data){
                      if(data==0){
                        //alert("用户密码不正确");
                        $("#userPwdTest").text("用户密码不正确").css("color","red");
                      }else{
                        $("#userPwdTest").text("用户密码正确").css("color","green");
                        $("#btn_nextMoveOne").bind("click",function() {
                          $("#section1").hide();//页签1隐藏
                          $("#section3").hide();//页签3隐藏
                          $("#section2").show();//页签2显示
                        })
                      }
                    },
                    "text"
            );
          }
  )
</script>
</body>
</html>