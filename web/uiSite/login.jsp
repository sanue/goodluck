<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
  <title>好运网-用户-登录</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <link href="css/public.css" rel="stylesheet" type="text/css"/>
  <link href="css/index.css" rel="stylesheet" type="text/css"/>
  <link href="css/WdatePicker.css" rel="stylesheet" type="text/css"/>
  <link rel="stylesheet" href="css/my.css"/>
</head>
<body>
<!-- 头部开始 -->
<div class="header">
  <div class="hea_top"></div>
  <div class="hea_cent">
    <div class="fl hea_logo">
      <a href="index.html"><img src="images/hydLogo.png"/></a>
      <div class="slet_dta"><a>会员登录</a></div>
    </div>
  </div>
</div>
<!-- 头部结束 -->
<div class="mian">
  <div class="fl flant">
    <div class="laing">
      <%--添加表单提交--%>
      <form >
      <ul>
        <li>
          <label class="fl" style="margin-right: 15px;">用户名：</label>
          <div class="empty_of">
            <input id="code" name="code" tipMsg="用户名" required placeholder="用户名" <%--required="" pattern="^([0-9A-z])(\w){2,16}([0-9A-z])$"--%> type="text" class="int" />
            <i>&nbsp;</i>
          </div>
        </li>
        <li>
          <label class="fl" style="margin-right: 15px;">密码：</label>
          <div class="empty_of">
            <input id="password" name="password" type="password" placeholder="密码"  class="int" />
            <i class="nth">&nbsp;</i>
          </div>
        </li>
        <li style="padding-left:15px ">
          <label></label>
          <input id="bearPassword" name="bearPassword" type="checkbox" value="" />
          &nbsp;&nbsp;&nbsp;记住密码<span class="mpt1"></span>
        </li>
        <li class="lanot">
          <label></label>
          <button  type="submit" class="hoa mr10" style="margin:0 20px 0 11px;">登录</button><a href="register.jsp">注册</a>
        </li>
      </ul>
      </form>
    </div>
  </div>
  <div class="fr frland"></div>
  <div class="both"></div>
  <br/>
  <br/>
</div>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script>

//  使用validate进行表单验证
$(function(){
  $('form').validate({
    rules:{
      code:{
        required:true
      },
      password:{
        required:true
      }
    },
    messages:{//message表示错误信息提示，默认的为英文，可以自定义
      code:{
        required:'账户不能为空'
      },
      password:{
        required:'密码不能为空'
      }
    },
    submitHandler: function (form) {//回调函数，当上面的验证都通过的时候执行此函数 ,form表示此表单
//      这里写AJAX异步提交
      var name=document.querySelector("#code").value;
      var pwd=document.querySelector("#password").value;
      $.post(
              "login.do",
              {"username":name,"password":pwd},
              //成功时的回调函数
              function(data){
                if(data!=null){
                  location.href="index.html";
                }else{
                  alert("用户信息不正确");
                }
              },
              "json"
      );
    }

  });
})
</script>
<!-- 底部结束 -->
</body>
</html>
