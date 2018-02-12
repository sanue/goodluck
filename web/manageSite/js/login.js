//登录
function btn_onclick(){

    //获取用户名
    var user=$("#userName").val();
    var password=document.querySelector("#pwd").value;
    //发送请求，检查用户名是否存在
    var url="login.do";
    var parameters='username='+user+'&password='+password;
    var xhr=new XMLHttpRequest();
    xhr.open("POST",url,true);
    xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xhr.onreadystatechange=function(){
        if(this.status==200&&this.readyState==4){
            var result=this.responseText;
            if(result==1){
            	window.location.href="index.html";
            }else{
            	document.getElementById('checkuser').style.display = "block";
            	document.getElementById('checkuser').style.color = "red";
            }
        }
    };
   xhr.send(parameters);
   return false;
}


