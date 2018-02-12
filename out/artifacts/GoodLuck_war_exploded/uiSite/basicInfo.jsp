<%@ page import="java.util.ArrayList" %>
<%@ page import="com.logistics.dao.OwnerAuthenticationDao" %>
<%@ page import="com.logistics.dao.ShipperAuthenticationDao" %>
<%@ page import="com.logistics.dao.RegisterDao" %>
<%@ page import="com.logistics.bean.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="Author" contect="http://www.webqin.net">
  <title>会员基本信息</title>
  <link rel="shortcut icon" href="images/favicon.ico" />

  <!-- Bootstrap -->
  <link href="css/bootstrap.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">
  <link href="css/response.css" rel="stylesheet">
  <link href="css/silde.css" rel="stylesheet">
  <%--city--%>
  <link href="css/city.css" rel="stylesheet">
 <link href="ext/css/bootstrap.css" rel="stylesheet">
  <link href="ext/css/style.css" rel="stylesheet" type="text/css" media="all" />
  <link rel="stylesheet" href="ext/css/swipebox.css">
<%--/*basicInfo.css*/--%>
  <link rel="stylesheet" href="css/basicInfo.css">

  <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
  <!-- //for-mobile-apps -->
  <!-- js -->
  <script src="js/jquery.js"></script>
  <!-- js -->
  <script src="ext/js/modernizr.custom.js"></script>
  <!-- start-smoth-scrolling -->
  <script type="text/javascript" src="ext/js/move-top.js"></script>
  <script type="text/javascript" src="ext/js/easing.js"></script>
  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <!--<script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>-->
  <!--<script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>-->
  <![endif]-->
</head>
<body>
<%
  ArrayList<CarLong> carLongs = (ArrayList<CarLong>)request.getAttribute("carLongs");
  ArrayList<CarType> carTypes = (ArrayList<CarType>)request.getAttribute("carTypes");
  ArrayList<CoachType> coachTypes = (ArrayList<CoachType>)request.getAttribute("coachTypes");
  OwnerAuthenticationDao ownerAuthenticationDao = new OwnerAuthenticationDao();
  ShipperAuthenticationDao shipperAuthenticationDao = new ShipperAuthenticationDao();
  RegisterDao registerDao = new RegisterDao();
//默认车主审核否存在
  int val=0;
//默认货主审核否存在
  int val2=0;
  int isOwner = 2;
  int AuthSuccess=0;
  int AuthFalse=0;
  //电话号码和名字
  String num = null;
  String name = null;
  String headPic=null;

  if (request.getSession().getAttribute("register")!=null){
      Register currentRe = (Register)request.getSession().getAttribute("register");
      String ownerName = currentRe.getName();
      num = currentRe.getTelephoeNum();
      name = currentRe.getName();
    //isOwner=1:车主  、 isOwner=0:货主
    isOwner = registerDao.checkOwnerORShipper(ownerName);

    if (isOwner==1){
          //检查车主审核是否存在
          val = ownerAuthenticationDao.checkExistOwner(ownerName);

    }else if (isOwner==0){
          //检查货主审核是否存在
          val2 = shipperAuthenticationDao.checkExistShipperAnth(ownerName);
    }

     //检查审核是否通过（为1），0是未上传或者有数据没有通过
    AuthSuccess = ownerAuthenticationDao.checkOwnerAuthSuccess(ownerName);
    //检查审核是否失败（为2）,AuthFalse=1为失败
    AuthFalse =ownerAuthenticationDao.checkOwnerAuthFalse(ownerName);

    //找出验证信息头像
    if (AuthSuccess==1&&isOwner==1){
      //车主通过审核
      OwnerAuthentication ownerAuthentication = ownerAuthenticationDao.getCurrentOwnerAuth(ownerName);
      headPic = ownerAuthentication.getHeadPic();
    }else if (AuthSuccess==1&&isOwner==0){
      //货主通过审核
      ShipperAuthentication shipperAuthentication = shipperAuthenticationDao.getCurrentShipperAuth(ownerName);
      headPic = shipperAuthentication.getPic();
    }


  }else{
    response.sendRedirect("login.jsp");
  }




%>
<%--顶部导航栏--%>
<%@include file="inc/header.jsp"%>
<%--内容主体--%>
<div class="content">
  <div class="width1003">
    <div class="content-left">
      <div id="menu">
        <ul class="menuList">
          <li class="first_level" id="myHome" >
            <a href="javascript:void(0);" class="first_level_title"><span class="glyphicon glyphicon-home"></span>
              &nbsp;&nbsp;我的首页</a>
          </li>
          <li class="first_level"id="myIndentity">
            <a href="javascript:void(0);" class="first_level_title has_sec" ><span class="glyphicon glyphicon-user"></span>
              &nbsp;&nbsp;我的认证</a>
          </li>
            <ul class="second_level" style="display: none">
             <%
               if(isOwner==1){
             %>
              <li class="second_level_title carOwnerTitle">
                车主认证
              </li>
              <%
                }else if(isOwner==0){
              %>
              <li class="shipperTitle">
                货主认证
              </li>
              <%
                }
              %>
            </ul>

          <%
            if(isOwner==1){
          %>
          <li class="first_level publishCarsTitle">
            <a href="javascript:void(0);" class="first_level_title "><span class="glyphicon glyphicon-send"></span>
              &nbsp;&nbsp;发布车辆</a>
          </li>
          <%--根据登录用户身份不同，点击“我的发布”之后，跳转到不同的页面--%>
          <li class="first_level" onclick="window.open('myCarResource.html')">
              <%
          }else if(isOwner==0){
          %>
          <li class="first_level publishGoodsTitle">
            <a href="javascript:void(0);" class="first_level_title "><span class="glyphicon glyphicon-globe"></span>
              &nbsp;&nbsp;发布货源</a>
          </li>
          <li class="first_level" onclick="window.open('myGoodResource.html')">
            <%
              }
            %>
            <a href="javascript:void(0)" class="first_level_title "><span class="glyphicon glyphicon-usd"></span>
              &nbsp;&nbsp;我的发布</a>
          </li>
        </ul></div>
    </div><!--content-left/-->
    <div class="content-right">
      <!--content-right1个人首页-->
      <div class="myHead">
          <div id="headPic">
            <%
              if (headPic!=null){
            %>
            <img src="../upload/headPath/<%=headPic%>" width="120" height="120">
            <%
              }else{
            %>
            <img src="images/head.jpg" width="120" height="120">
            <%
              }
            %>
          </div>
          <div class="headInfo">
            <div id="headName">
              <%=name==null?"":name %>
            </div>
            <div id="changePsd" onclick="window.open('modifyPwd.jsp')">修改密码</div>
            <div id="telephoneNum">
              手机号码：<%=num==null?"":num%>
            </div>
          </div>
      </div>
      <div class="authentication">
       <%--<%***********************车主认证**************************%>--%>
        <%
          if(isOwner==1){
        %>

        <div class="autho">
          <div id="ownerAuth">
            <img src="images/ownerA.png" width="59" height="50">
            <div class="authss">
              <div class="fontA">车主认证</div>
              <%
                if(val==0){
              %>
              <div class="tipA">您的账号尚未车主认证</div>
              <%
                if(AuthFalse==1){
              %>
              <div class="tipAuth">您上次的账号车主认证失败了，重新认证吧~
              <img src="images/cry.jpg" width="300" height="300">
              </div>
              <%
                }
              %>

              <%
              }else if(val==1){
                if(AuthSuccess==0){
                  %>
                     <div class="tipA">您的认证待审核...</div>
                  <%
                }else if(AuthSuccess==1){
              %>
              <div class="tipA">您已车主认证</div>
              <%
                }
                }
              %>
            </div>


            <%
                if(val==0){
            %>
            <div class="btnAuth">立即认证</div>
            <%
                }else if(val==1){
                  if(AuthSuccess==0){
            %>
            <div class="authing">认证中...</div>
            <%
                }else if(AuthSuccess==1){
            %>
              <div class="AuthInfo" onclick="window.open('AuthInfo.html')">查看认证信息</div>
            <%
                 }
              }
            %>


          </div>
        </div>
        <%
        }else if(isOwner==0){
        %>
       <%-- /*******************货主认证********************/--%>
        <div class="auths">
          <div id="shipperAuth">
              <img src="images/shipperA.png" width="59" height="50">
            <div class="authss">
              <div class="fontA">货主认证</div>
              <%
                if(val2==0){
              %>
              <div class="tipA">您的账号尚未货主认证</div>
                  <%
                    if(AuthFalse==1){
                  %>
                  <div class="tipAuth">您上次的账号车主认证失败了，重新认证吧~
                    <img src="images/cry.jpg" width="300" height="300">
                  </div>

                  <%
                    }
                  %>
              <%
              }else if(val2==1){
                if(AuthSuccess==0){
              %>
              <div class="tipA">您的认证待审核...</div>
              <%
              }else if(AuthSuccess==1){
              %>
              <div class="tipA">您已认证货主</div>
              <%
                }
                }
              %>
            </div>
            <%
            if(val2==0){
            %>
                <div class="ShipperAuth">立即认证</div>
            <%
            }else if(val2==1){
              if(AuthSuccess==0){
            %>
            <div class="authing">认证中...</div>
            <%
            }else if(AuthSuccess==1){
            %>
                <div class="AuthInfo" onclick="window.open('shipperAuthInfo.html')">查看认证信息</div>
            <%
              }
              }
            %>

            </div>
        </div>
        <%
          }else{
        %>
        请先登录
        <%
          }
        %>
      </div>
    </div>
      <!--content-right1-->

      <!--content-right2车主验证-->
    <div class="exist">
      <div class="OwnerAuthExist">
        您的认证信息审核已经存在了~
      </div>
    </div>
    <div class="content-right" style="display: none">
      <div class="carTip">车主认证 <span>（请完善您的信息 * 为必填项）</span></div>
      <div class="ownerInfo">
        <form class="form-horizontal" action="ownerAuth.do" id="carAuthForm" role="form" method="post" enctype="multipart/form-data">
          <div class="form-group">
            <label for="trueName" class="col-sm-2 control-label">*真实姓名</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="trueName" name="trueName" onblur="checkOwnerExist(this)" placeholder="请输入你的真实姓名">
            </div>
          </div>
          <div class="form-group">
            <label for="carNumm" class="col-sm-2 control-label">*车牌号</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="carNumm" name="carNumm" required placeholder="请输入车牌号">
            </div>
          </div>
          <div class="form-group">
            <label for="identity" class="col-sm-2 control-label">*身份证照</label>
            <button type="button" class="btn btn-warning fileOpen">上传照片</button>
            <div class="col-sm-10">
              <input type="file" class="form-control" id="identity" name="identity" required onchange="showFilePic('identity','identityImg')" style="display: none">
            </div>
            <div class="identityPicss">
            <div class="identityPics col-sm-10">
              <img src="images/headc.jpg" id="identityImg" width="278" height="148">
            </div>
           <%-- 案例照片--%>

            <div class="identityExample">
              <img src="images/cardPositive.jpg" width="278" height="148"/>
              *上传图片格式为JPG、JPEG、BMP、PNG，单张大小不超过3M。
            </div>
            </div>
          </div>
          <div class="form-group">
            <label for="driversLicense" class="col-sm-2 control-label">*驾驶证照</label>
            <button type="button" class="btn btn-warning fileOpen">上传照片</button>

            <div class="col-sm-10">
                <input type="file" class="form-control" id="driversLicense" name="driversLicensePic" onchange="showFilePic('driversLicense','driversLicensePic')" style="display: none">
              </div>

            <div class="identityPicss">
                <div class="identityPics col-sm-10">
                  <img src="images/headc.jpg" width="278" id="driversLicensePic" height="148">
                </div>
                <%-- 案例照片--%>
                <div class="identityExample">
                  <img src="images/cardPositive.jpg" width="278" height="148"/>
                  *上传图片格式为JPG、JPEG、BMP、PNG，单张大小不超过3M。
                </div>
            </div>

          </div>
          <div class="form-group">
            <label for="headPicture" class="col-sm-2 control-label">个人头像</label>
            <button type="button" class="btn btn-warning fileOpen">上传照片</button>
            <div class="col-sm-10">
              <input type="file" class="form-control" id="headPicture" name="headPicture" onchange="showFilePic('headPicture','headPics')" style="display: none">
            </div>
            <div class="identityPics col-sm-10">
              <img src="images/headc.jpg" width="278" id="headPics" height="148">
            </div>
          </div>


          <div class="form-group">
            <div class="col-sm-offset-2 col-sm-12">
              <button type="reset" class="btn subBtn col-sm-5">取消</button>
              <button type="submit" class="btn subBtn col-sm-5">提交</button>
            </div>
          </div>
        </form>
      </div>
    </div>
      <!--content-right2-->

      <!--content-right3货主认证-->
    <div class="content-right" style="display: none">
      <div class="shopTip">货主认证 <span>（请完善您的信息 * 为必填项）</span></div>
      <div class="ownerInfo">
        <form class="form-horizontal" action="shipperAuth.do" id="shipperAuthForm" role="form" method="post" enctype="multipart/form-data">
          <div class="form-group">
            <label for="shipperTrueName" class="col-sm-2 control-label">*真实姓名</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="shipperTrueName" name="shipperTrueName" placeholder="请输入你的真实姓名">
            </div>
          </div>
          <div class="form-group">
            <label for="shipperIdentity" class="col-sm-2 control-label">*身份证照</label>
            <button type="button" class="btn btn-warning fileOpen">上传照片</button>
            <div class="col-sm-10">
              <input type="file" class="form-control" id="shipperIdentity" name="shipperIdentity" onchange="showFilePic('shipperIdentity','shipperIdentityPic')" style="display: none">
            </div>
            <div class="identityPicss">
              <div class="identityPics col-sm-10">
                <img src="images/headc.jpg" id="shipperIdentityPic" width="278" height="148">
              </div>
              <%--案例照片--%>
              <div class="identityExample">
                <img src="images/cardPositive.jpg" width="278" height="148"/>
                *上传图片格式为JPG、JPEG、BMP、PNG，单张大小不超过3M。
              </div>
            </div>
          </div>
          <div class="form-group">
            <label for="shipperHead" class="col-sm-2 control-label">*头像</label>
            <button type="button" class="btn btn-warning fileOpen">上传照片</button>
            <div class="col-sm-10">
              <input type="file" class="form-control" id="shipperHead" name="shipperHead" onchange="showFilePic('shipperHead','shipperHeadPicture')" style="display: none">
            </div>
            <div class="identityPics col-sm-10">
              <img src="images/headc.jpg" id="shipperHeadPicture" width="278" height="148">
            </div>
          </div>


          <div class="form-group">
            <div class="col-sm-offset-2 col-sm-12">
              <button type="reset" lass="btn subBtn col-sm-5">取消</button>
              <button type="submit" class="btn subBtn col-sm-5">提交</button>
            </div>
          </div>
        </form>
      </div>
    </div>
      <!--content-right3-->

    <!--content-right4发布车辆-->
    <div class="content-right" style="display: none">
      <div class="publishCarTip">发布车辆 <span>（请完善您的信息 * 为必填项）</span></div>
      <div class="carInfo">
        <form class="form-horizontal" action="publishCar.do" role="form" id="publishCarForm" method="post" enctype="multipart/form-data">
          <div class="form-group">
            <label for="startCity" class="col-sm-2 control-label">*出发地</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="startCity" name="startCity">
            </div>
          </div>

          <div class="form-group">
            <label for="toCity" class="col-sm-2 control-label">*目的地</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="toCity" name="toCity">
            </div>
          </div>

          <div class="form-group">
            <label for="carNum" class="col-sm-2 control-label">*车牌号</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="carNum" name="carNum" placeholder="请输入你的车牌号">
            </div>
          </div>
          <div class="form-group">
            <label for="carLong" class="col-sm-2 control-label">*车长</label>
            <div class="col-sm-10">
              <!--自动加载-->
              <select id="carLong" name="carLong">
                <%
                  for (CarLong carLong :carLongs){
                %>
                <option value="<%=carLong.getId()%>"><%=carLong.getCarsLong()%></option>
                <%
                  }
                %>
              </select>
            </div>
          </div>
          <div class="form-group">
            <label for="carType" class="col-sm-2 control-label">*车辆类型</label>
            <div class="col-sm-10">
              <!--自动加载-->
              <select id="carType" name="carType">
                <%
                  for (CarType ct:carTypes){
                %>
                <option value="<%=ct.getId()%>"><%=ct.getType()%></option>
                <%
                  }
                %>
              </select>
            </div>
          </div>
          <div class="form-group">
            <label for="carLong" class="col-sm-2 control-label">*车厢类型</label>
            <div class="col-sm-10">
              <!--自动加载-->
              <select id="coachType" name="coachType">
                <%
                  for (CoachType cot: coachTypes){
                %>
                <option value="<%=cot.getId()%>"><%=cot.getType()%></option>
                <%
                  }
                %>
              </select>
            </div>
          </div>

          <div class="form-group">
            <label for="carPic" class="col-sm-2 control-label">*车辆照</label>
            <button type="button" class="btn btn-warning fileOpen">上传照片</button>
            <div class="col-sm-10">
              <input type="file" class="form-control" id="carPic" name="carPic" onchange="showFilePic('carPic','carPicture')" style="display: none">
            </div>
            <div class="identityPicss">
                <div class="cgPics col-sm-10">
                  <img src="images/carExample.jpg" id="carPicture" width="278" height="148">
                </div>

            </div>
          </div>

          <div class="form-group">
            <div class="col-sm-offset-2 col-sm-12">
              <button type="reset" class="btn subBtn col-sm-3">取消</button>
              <button type="submit" class="btn subBtn col-sm-3">提交</button>
            </div>
          </div>
        </form>
      </div>


    </div>
    <!--content-right4-->


    <!--content-right5发布货源-->
      <div class="content-right" style="display: none">
        <div class="publishShopTip">发布货源 <span>（请完善您的信息 * 为必填项）</span></div>
        <div class="shopInfo">
          <form class="form-horizontal" action="publishGoods.do" role="form" id="publishGoodsForm" method="post" enctype="multipart/form-data">
            <div class="form-group">
              <label for="startCityS" class="col-sm-2 control-label">*出发地</label>
              <div class="col-sm-10">
                <input type="text" class="form-control" id="startCityS" name="startCityS">
              </div>
            </div>
            <div class="form-group">
              <label for="toCityS" class="col-sm-2 control-label">*目的地</label>
              <div class="col-sm-10">
                <input type="text" class="form-control" id="toCityS" name="toCityS">
              </div>
            </div>
           <%-- <div class="form-group">
              <label for="shipperName" class="col-sm-2 control-label">*货主姓名</label>
              <div class="col-sm-10">
                <input type="text" class="form-control" id="shipperName" name="shipperName" placeholder="请输入你的姓名">
              </div>
            </div>--%>
            <div class="form-group">
              <label for="shopName" class="col-sm-2 control-label">*货品名称</label>
              <div class="col-sm-10">
                <div class="col-sm-10">
                  <input type="text" class="form-control" id="shopName" name="shopName" placeholder="请输入货品名称">
                </div>
              </div>
            </div>
           <%-- <div class="form-group">
              <label for="shopType" class="col-sm-2 control-label">*货品类型</label>
              <div class="col-sm-10">
                <!--自动加载-->
                <select id="shopType">
                  <option value="1">类型</option>
                  <option value="2">类型</option>
                  <option value="3">类型</option>
                </select>
              </div>
            </div>--%>
            <div class="form-group">
              <label for="shopWeight" class="col-sm-2 control-label">*货品重量</label>
              <div class="col-sm-10">
                <input type="text" class="form-control" id="shopWeight" name="shopWeight" placeholder="请输入货品重量（吨/方）">
              </div>
            </div>

            <div class="form-group">
              <label for="shopCarLong" class="col-sm-2 control-label">*车长</label>
              <div class="col-sm-10">
                <!--自动加载-->
                <select id="shopCarLong" name="shopCarLong">
                  <%
                    for (CarLong carLong :carLongs){
                  %>
                  <option value="<%=carLong.getId()%>"><%=carLong.getCarsLong()%></option>
                  <%
                    }
                  %>
                </select>
              </div>
            </div>
            <div class="form-group">
              <label for="shopCarType" class="col-sm-2 control-label">*车辆类型</label>
              <div class="col-sm-10">
                <!--自动加载-->
                <select id="shopCarType" name="shopCarType">
                  <%
                    for (CarType ct:carTypes){
                  %>
                  <option value="<%=ct.getId()%>"><%=ct.getType()%></option>
                  <%
                    }
                  %>
                </select>
              </div>
            </div>
            <div class="form-group">
              <label for="shopCoachType" class="col-sm-2 control-label">*车厢类型</label>
              <div class="col-sm-10">
                <!--自动加载-->
                <select id="shopCoachType" name="shopCoachType">
                  <%
                    for (CoachType cot: coachTypes){
                  %>
                  <option value="<%=cot.getId()%>"><%=cot.getType()%></option>
                  <%
                    }
                  %>
                </select>
              </div>
            </div>

            <div class="form-group">
              <label for="shopPic" class="col-sm-2 control-label">*货品照片</label>
              <button type="button" class="btn btn-warning fileOpen">上传照片</button>
              <div class="col-sm-10">
                <input type="file" class="form-control" id="shopPic" name="shopPic" onchange="showFilePic('shopPic','shopPicture')" style="display: none">
              </div>

              <div class="identityPicss">
              <div class="cgPics col-sm-10">
                <img src="images/goodsExample.jpg" id="shopPicture" name="shopPicture" width="278" height="148">
              </div>
                <%-- 案例照片
                <div class="identityExample">
                  <img src="images/goodsExample.jpg" width="500" height="500"/>
                  上传图片格式为JPG、JPEG、BMP、PNG，单张大小不超过3M。
                </div>--%>
              </div>

            </div>




            <div class="form-group">
              <div class="col-sm-offset-2 col-sm-12">
                <button type="reset" class="btn subBtn col-sm-3">取消</button>
                <button type="submit" class="btn subBtn col-sm-3">提交</button>
              </div>
            </div>
          </form>
        </div>





    </div>
    <!--content-right5-->

    <!--content-right6我的订单-->
    <div class="content-right" style="display: none">



    </div>
    <!--content-right6-->

    <!--content-right7消息盒子-->
    <div class="content-right" style="display: none">



    </div>
    <!--content-right7-->


   <!--content-right/-->
    <div class="clearfix"></div>
  </div><!--width1003/-->
</div><!--content/-->
<%--页脚部分--%>
<%@include file="inc/footer.jsp"%>
<script src="js/jquery.validate.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/style.js"></script>
<!--焦点轮换-->
<script src="js/jquery.excoloSlider.js"></script>
<script src="js/Popt.js"></script>
<script src="js/cityJson.js"></script>
<script src="js/citySet.js"></script>
<script src="js/basicInfo.js"></script>
<script src="js/global.js"></script>
<%
  if (request.getParameter("page")!=null){
  String thispage = request.getParameter("page");
  if (thispage.equals("publishGoods")){
%>
<script>
$(function(){
  $('.first_level').eq(2).click();
});
</script>
<%
    }
  }
  %>
</body>
</html>

