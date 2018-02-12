/*首页JS*/

function getMesOfGoodsAndCarByRegion(){
    var cityinfo = sessionStorage.cityName;
    $.get(
        'showByRegion',
        {startCity:cityinfo,opt:'goods'},
        function(data){
            if(0!=data.length){
                $('#goodsMes').empty();
                for(var i = 0 ; i<data.length;i++){
                    goodsMes(data[i] , '登陆后显示');
                }

            }else{
                $('#goodsMes').empty();
                $('#goodsMes').append('<div class="containerGoods">' +
                '<img src="images/none.png"/>' +
                '</div>');
            }
        },
        'json'
    );
    $.get(
        'showByRegion',
        {startCity:cityinfo,opt:'car'},
        function(data){
            if(0!=data.length){
                $('#CarsMes').empty();
                for(var i =0;i<data.length;i++){
                    carMes(data[i],'<img src="images/telephone.png" width="22" height="22" >')
                }

            }else{
                $('#CarsMes').empty();
                $('#CarsMes').append('<tr >' +
                '<td colspan="5"><img src="images/nonecar.png"/>' +
                '</td></tr>');
            }
        },
        'json'
    )
}
function viewPhone(){
    var myCity = sessionStorage.cityName;
    $.get(
        'showPhone',
        {region:myCity,opt:'goods'},
        function(data){
            if(data!=null) {
                $('#goodsMes').empty();
                for(var i = 0;i<data.length;i++){
                    goodsMes(data[i] , data[i].phone)
                }

            }
        },
        'json'
    );
    $.get(
        'showPhone',
        {region:myCity,opt:'car'},
        function(data){
            if(data!=null) {
                //登录
                $('#CarsMes').empty();
                for(var i =0;i<data.length;i++){
                    carMes(data[i] , data[i].phone);
                }

            }
        },
        'json'
    );
}



function goodsMes(data , phone){
    $('#goodsMes').append('<div class="view view-ninth" style="display: none">' +
    '<a href="javascript:void(0)" class="b-link-stripe b-animate-go swipebox" onclick="checkIsLogin()"'  +
    'title="Image Title"><img src="../upload/goodsPath/'+data.pic+'" alt="" class="img-responsive" > ' +
    '<div class="mask mask-1"></div> ' +
    '<div class="mask mask-2"></div> ' +
    '<div class="content1"> ' +
    '<h2>货物：'+data.name+
    '</h2> ' +
    '<p>车长：'+data.carLong+'/车厢：'+data.coachType+'/车：'+data.carType +
    '</p> ' +
    '<p>当前位置:'+data.startProvince+'-'+data.startCity +
    '</p> ' +
    '<P>期望去向城市：'+ data.toProvince+'-'+data.toCity +
    '</P> ' +
    '<P>货主手机号：'+phone+
    '</P> '+
    '</div> '+
    '</a> ' +
    '</div>');
}
function carMes(data , phone){
    $('#CarsMes').append('<tr style="opacity: 0" class="ttr" onclick="checkIsLogin()"> ' +
    '<td> ' +
    '<img src="images/indentity.png" width="22" height="22"/> ' +
    data.owner +
    '</td> ' +
    '<td>' +data.carLong+'/'+data.carType+'/'+data.coachType+
    '</td> ' +
    '<td>'+data.startProvince+'-' +data.startCity+
    '</td> ' +
    '<td> '+data.toProvince+'-' +data.toCity+
    '</td> ' +
    '<td> '+phone+
    '</td>'+
    '</tr>');
}



/*showCityInfo();*/
$(function(){
    $('.width1003>li>a').removeClass('navCur');
    $('.width1003>li:eq(0)>a').addClass('clickNav');
    $(window).scroll(function() {
        var sTop = $(window).scrollTop();
        $('.view').fadeIn('1000');
       /* print(sTop);*/
       if (sTop>=20) {
           $('.contentTitle').eq(0).animate({
               'opacity':'1'
           });
       }
        if (sTop>=750) {
            $('.contentTitle').eq(1).animate({
                'top':'0px',
                'opacity':'1'
            },1000,function(){
                $('.ttr').animate({
                    'opacity':'1'
                },100);
            });
        }
        if (sTop>=1200) {
            $('.contentTitle').eq(2).animate({
                'top':'0px',
                'opacity':'1'
            },800,function(){
                /*$('.view').fadeIn('slow');*/
                $('.destination-1').fadeIn('4000');
            });
        }
        if (sTop>=2000) {
            $('.contentTitle').eq(3).animate({
                'top':'0px',
                'opacity':'1'
            },500,function(){
                $('#picshow_img li').animate({
                    'left':'0px'
                },500,function(){
                    $('#select_btn').animate({
                        'right':'8%'
                    },500);
                });
            });
        }
        if (sTop>=3000) {
            $('.contentTitle').eq(4).animate({
                'top':'0px',
                'opacity':'1'
            },500,function(){
                /*$('.view').fadeIn('slow');*/
            });
        }
    });
  /*  $('.toggleBtn>div:nth-child(2)').click(function(){
        $('.chooseCity').hide();
    });*/
    $('#register').click(function(){
        window.open("register.jsp");
    });
    $('#login').click(function(){
        window.open("login.jsp");
    });



    /*$("[data-toggle='popover']").popover();*/
    var name = $('#login').text();
    if(name!='登录'){
        if(sessionStorage.cityName==undefined){
            showCityInfo(viewPhone)
        }else{
            viewPhone();
        }

    }else{
        if(sessionStorage.cityName==undefined){
            showCityInfo(getMesOfGoodsAndCarByRegion);
        }else{
            getMesOfGoodsAndCarByRegion();
        }

    }
});

function checkIsLogin(){
    var name = $('#login').text();
    if(name=='登录'){
        open("login.jsp","_self");
    }
    return false;
}

/*返回顶部*/

jQuery(document).ready(function($){
    // browser window scroll (in pixels) after which the "back to top" link is shown
    var offset = 300,
    //browser window scroll (in pixels) after which the "back to top" link opacity is reduced
        offset_opacity = 1200,
    //duration of the top scrolling animation (in ms)
        scroll_top_duration = 1700,
    //grab the "back to top" link
        $back_to_top = $('.cd-top');

    //hide or show the "back to top" link
    $(window).scroll(function(){
        ( $(this).scrollTop() > offset ) ? $back_to_top.addClass('cd-is-visible') : $back_to_top.removeClass('cd-is-visible cd-fade-out');
        if( $(this).scrollTop() > offset_opacity ) {
            $back_to_top.addClass('cd-fade-out');
        }
    });
    //www.sucaijiayuan.com
    //smooth scroll to top
    $back_to_top.on('click', function(event){
        event.preventDefault();
        $('body,html').animate({
                scrollTop: 0 ,
            }, scroll_top_duration
        );
    });


});





