/**
 * Created by Administrator on 2016/10/26.
 */
function open(){
    $("#tndow").css("display","block");
}
function close(){
    $('input[type=checkbox]').attr('checked','checked');
    $("#tndow").css("display","none");
    $("#saveBtn").removeAttr("disabled");
}
$(document).ready(function(){

        //点击下一页时触发的事件
        //$("#btn_nextMoveOne").bind("click",function(){
        //
        //    //alert("a");
        //    if($("#mobilephone").val().length==0||$("#mobilephone").val()==""||$("#mobilephone").val()=="请输入用户名"||$("#userPwd").val().length==0||$("#userPwd").val()==""||$("#userPwd").val()=="请输入密码"){
        //        $("#userNameTest").css({"color":"darkred"});
        //        $("#userNameTest").html("用户名不能为空");
        //        $("#userPwdTest").css({"color":"darkred"});
        //        $("#userPwdTest").html("密码不能为空");
        //
        //    }else{
        //        $("#section1").hide();//页签1隐藏
        //        $("#section3").hide();//页签3隐藏
        //        $("#section2").show();//页签2显示
        //    }
        //
        //})
        //点击确认时触发的事件
        $("#saveBtn").bind("click",function(){
            /*新密码长度为6到20位英文、数字、字符*/
            //进行AJAX修改密码的操作，修改成功跳转到section3
            var userName=document.querySelector("#mobilephone").value;
            var password=document.querySelector("#userPwd").value;
            var newPassword=document.querySelector("#newUserPwd").value;
            var confirmUserPwd=document.querySelector("#confirmUserPwd").value;
            var pattern = /^\w{6,20}$/;
            if(newPassword.match(pattern)&&newPassword==confirmUserPwd){
                $.post(
                    "modifyPwd.do",
                    {"userName":userName,"password":password,"newPassword":newPassword},
                    function(data){
                        if(data==1){
                            $("#section1").hide();//页签1隐藏
                            $("#section2").hide();//页签2隐藏
                            $("#section3").show();//页签3显示
                        }
                    },
                    "text"
                );
            }
            if(!newPassword.match(pattern)){
                $('#newUserPwdTest').text('新密码格式不正确').css('color','red');
            }
            if(newPassword!=confirmUserPwd){
                $('#confirmUserPwdTest').text('两次密码不一致').css('color','red');
            }



        })
    }

)