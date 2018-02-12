/**
 * Created by Administrator on 2016/10/27.
 */
$(function(){
    /*js验证*/
    $.validator.addMethod('carNum',function(value){
        var reg = /^[\u4e00-\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}$/;
        return reg.test(value);
    },'手机号格式不正确');

    /*车主表单验证*/
    $('#carAuthForm').validate({
        rules:{
            trueName:{required:true,rangelength:[2,10]},
            carNumm:{required:true,carNum:true}
            /*confirmPassword:{required:true,minlength:6,maxlength:12,equalTo:'#password'},*/

        },
        messages:{
            trueName:{required:'请输入真实姓名',rangelength:'真实姓名2-10'},
            carNumm:{required:'请输入车牌号码',carNum:'车牌号码格式不正确'}
           /* confirmPassword:{required:'请输入确认密码',minlength:'密码长度不能低于6',maxlength:'密码长度不能高于20',equalTo:'两次输入密码不一致'}*/
        },
        errorClass:'my-error',
        submitHandler:function(){
            /*document.querySelector("").src="";*/

            if($('#identityImg').attr('src')=="images/headc.jpg"){
                alert("请上传你的身份证照片");
                return;
            }
            if($('#driversLicensePic').attr('src')=="images/headc.jpg"){
                alert("请上传你的驾驶证照片");
                return;
            }
            $('#carAuthForm').submit();


        }
    });
    /*货主表单认证*/
    $('#shipperAuthForm').validate({
        rules:{
            shipperTrueName:{required:true,rangelength:[2,10]}
        },
        messages:{
            shipperTrueName:{required:'请输入真实姓名',rangelength:'真实姓名2-10'}
        },
        errorClass:'my-error',
        submitHandler:function(){
            if($('#shipperIdentityPic').attr('src')=="images/headc.jpg"){
                alert("请上传你的身份证照片");
                return;
            }
            $('#shipperAuthForm').submit();
        }
    });
   /*发布货源表单验证*/
    $('#publishGoodsForm').validate({
        rules:{
            startCityS:{required:true},
            toCityS:{required:true},
            shopName:{required:true},
            shopWeight:{required:true}
        },
        messages:{
            startCityS:{required:'请选择初始城市'},
            toCityS:{required:'请选择目的城市'},
            shopName:{required:'请选择货品名称'},
            shopWeight:{required:'请选择货品重量'}
        },
        errorClass:'my-error',
        submitHandler:function(){
            if($('#shopPicture').attr('src')=="images/goodsExample.jpg"){
                alert("请上传你的货品照片");
                return;
            }
            $('#publishGoodsForm').submit();
        }
    });
    /*发布车源表单验证*/
    $('#publishCarForm').validate({
        rules:{
            startCity:{required:true},
            toCity:{required:true},
            carNum:{required:true,carNum:true}
        },
        messages:{
            startCity:{required:'请选择初始城市'},
            toCity:{required:'请选择目的城市'},
            carNum:{required:'请输入车牌号',carNum:'请输入正确的车牌号'}
        },
        errorClass:'my-error',
        submitHandler:function(){
            if($('#carPicture').attr('src')=="images/carExample.jpg"){
                alert("请上传你的车辆照片");
                return;
            }
            $('#publishCarForm').submit();
        }
    });


    $('.width1003>li>a').removeClass('navCur');
    $('.width1003>li:eq(3)>a').addClass('clickNav');
    $('.first_level').removeClass('first_level_title').removeClass('clickLevel');
    $('.menuList>li:eq(0)').addClass('clickLevel');

    $('#myIndentity').click(function(){
        $('.second_level').toggle();
    });

    $('.fileOpen').click(function(){
        $(this).parent().children().eq(2).children().eq(0).click();
    });
    $('.first_level').click(function(){
        $('.first_level').removeClass('first_level_title').removeClass('clickLevel');
        $(this).addClass('clickLevel');
    });
    $('.first_level>a').click(function(){
        $('.first_level').removeClass('first_level_title').removeClass('clickLevel');
        $(this).parent().addClass('clickLevel');
    });
    /*列表切换*/
    $('.carOwnerTitle').click(function(){
        $('.content-right').hide();
        $('.content-right').eq(1).show();
    });
    $('.btnAuth').eq(0).click(function(){
        $('.content-right').hide();
        $('.content-right').eq(1).show();
    });
    $('.ShipperAuth').click(function(){
        $('.content-right').hide();
        $('.content-right').eq(2).show();
    });

    $('.shipperTitle').click(function(){
        $('.content-right').hide();
        $('.content-right').eq(2).show();
    });

    $('.first_level').eq(0).click(
        function(){
            $('.content-right').hide();
            $('.content-right').eq($(this).index()).show();
        }

    );
    $('.publishGoodsTitle').click(
        function(){
            $('.content-right').hide();
            $('.content-right').eq(4).show();
        }
    );
    $('.publishCarsTitle').click(
        function(){
            $('.content-right').hide();
            $('.content-right').eq(3).show();
        }

    );
    /*城市文本框*/
    $("#startCity").click(function (e) {
        SelCity(this,e);
        //console.log("inout",$(this).val(),new Date())
    });
    $("#toCity").click(function (e) {
        SelCity(this,e);
        //console.log("inout",$(this).val(),new Date())
    });
    $("#startCityS").click(function (e) {
        SelCity(this,e);
        //console.log("inout",$(this).val(),new Date())
    });
    $("#toCityS").click(function (e) {
        SelCity(this,e);
        //console.log("inout",$(this).val(),new Date())
    });

});
//显示歌手头像图片
function showFilePic(fileName,picName){
    var pic = document.getElementById(picName),
        file = document.getElementById(fileName);

    var ext=file.value.substring(file.value.lastIndexOf(".")+1).toLowerCase();

    // gif在IE浏览器暂时无法显示
    if(ext!='png'&&ext!='jpg'&&ext!='jpeg'){
        alert("图片的格式必须为png或者jpg或者jpeg格式！");
        return;
    }

    var isIE = navigator.userAgent.match(/MSIE/)!= null,
        isIE6 = navigator.userAgent.match(/MSIE 6.0/)!= null;

    if(isIE) {
        file.select();
        var reallocalpath = document.selection.createRange().text;

        // IE6浏览器设置img的src为本地路径可以直接显示图片
        if (isIE6) {
            pic.src = reallocalpath;
        }else {
            // 非IE6版本的IE由于安全问题直接设置img的src无法显示本地图片，但是可以通过滤镜来实现
            pic.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='image',src=\"" + reallocalpath + "\")";
            // 设置img的src为base64编码的透明图片 取消显示浏览器默认图片
            pic.src = 'data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==';
        }
    }else {
        html5Reader(file,picName);
    }
}

function html5Reader(file,picName){
    var file = file.files[0];
    var reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = function(e){
        var pic = document.getElementById(picName);
        pic.src=this.result;
       /* if(pic.width==0&&pic.height==0){
        }*/
    }
}
