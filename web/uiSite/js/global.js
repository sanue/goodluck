/**
 * Created by Administrator on 2016/10/29.
 */
$(function(){
    if(undefined==sessionStorage.cityName||sessionStorage.cityName.length==0){
        showCityInfo(addSession);
    }else{
        addSession();
    }
    /*当前城市*/
    loginCss();
});
function addSession(){
    $('#myCity').text(sessionStorage.cityName);
}
function loginCss(){
    $('#register').hover(function(){
        $('#register>img').attr('src','images/registerhover.png');
    },function(){
        $('#register>img').attr('src','images/register.png');
    });
    $('#login').hover(function(){
        $('#login>img').attr('src','images/loginhover.png');
    },function(){
        $('#login>img').attr('src','images/login.png');
    });

    $('.toggleCity').click(function(e){
        homeSelCity(this,e);
    });
}
var map = new AMap.Map("container", {
    resizeEnable: true,
    center: [116.397428, 39.90923],
    zoom: 13
});
//获取用户所在城市信息
function showCityInfo(callback) {
    //实例化城市查询类
    var citysearch = new AMap.CitySearch();
    //自动获取用户IP，返回当前城市
    citysearch.getLocalCity(function(status, result) {
        if (status === 'complete' && result.info === 'OK') {
            if (result && result.city && result.bounds) {
                var cityinfo = result.city;
                /*var citybounds = result.bounds;*/
                //document.getElementById('myCity').innerHTML = cityinfo;
                /*if(undefined==sessionStorage.cityName||sessionStorage.cityName.length==0) {*/
                    sessionStorage.cityName = cityinfo;
                /*}*/
                /*console.log($('#myCity').text());*/
                callback();
                //地图显示当前城市
                /* map.setBounds(citybounds);*/
            }
        } else {
            document.getElementById('myCity').innerHTML = result.info;
        }
    });
}

/*city*/

/**/

