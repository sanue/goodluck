/**
 * Created by Administrator on 2016/10/28.
 */
$(function(){
    $('.width1003>li>a').removeClass('navCur');
    $('.width1003>li:eq(1)>a').addClass('clickNav');
});
$("#CarLengthDictId a").click(function(){
    $("#CarLengthDictId a").removeClass("out");
    $(this).addClass("out");
});
$("#CarPlateTypeDictId a").click(function(){
    $("#CarPlateTypeDictId a").removeClass("out");
    $(this).addClass("out");
});
$("#CarBarTypeDictId a").click(function(){
    $("#CarBarTypeDictId a").removeClass("out");
    $(this).addClass("out");
});
$(".css").click(function(){
    $(".test").css('display','block');
});
//$("table>tbody>tr>td>img").click(function(){
//    $(".cart").css('display','none');
//    Id = $("#IMG").val();
//    ShowCart()
//});
function getId(id){
    $("#cart").removeClass("Tr_main_right_top dues");
    $("#cart").addClass("Tr_main_right_body");
    $("#cart").html("");
    Id=id;
    ShowCart(Id);
}
function ShowCart(Id){

    $.get(
        'ShowCart.html',
        {
            'Id':Id
        },function(carInfo){
            //console.log(carInfo);
            if(carInfo!=null){

                var $Date= CreateDateRow(carInfo);
                $("#cart").append($Date);

            }
            else{
                alert("暂无相关信息");
            }
        },
        'json'
    )
}
function CreateDateRow(carInfo){
    var $ul=$("<ul></ul>");
    var $liName = $("<li><span>姓名：</span></li>");
    var $Owner = $("<span></span>").text(carInfo.owner);
    $liName.append($Owner);
    $ul.append($liName);
    var $liNum = $("<li><span>车牌：</span></li>");
    var $CarNum = $("<span></span>").text(carInfo.carNum);
    $liNum.append($CarNum);
    $ul.append($liNum);
    var $liLong = $("<li><span>车长：</span></li>");
    var $carLong = $("<span></span>").text(carInfo.carLong);
    $liLong.append($carLong);
    $ul.append($liLong);
    var $litype = $("<li><span>车类型：</span></li>");
    var $carType = $("<span></span>").text(carInfo.carType);
    $litype.append($carType);
    $ul.append($litype);
    var $licoachType = $("<li><span>车厢类型：</span></li>");
    var $coachType = $("<span></span>").text(carInfo.coachType);
    $licoachType.append($coachType);
    $ul.append($licoachType);
    var $liCity = $("<li><span>常跑城市：</span></li>");
    var $city1 = $("<span></span>").text(carInfo.startProvince);
    var $city2 = $("<span></span>").text(carInfo.toCity);
    $liCity.append($city1);
    $liCity.append($city2);
    $ul.append($liCity);
    var $liSeef = $("<li><a>查看</a></li>");
    $ul.append($liSeef);
    return $ul;
}
$("#startPcc").click(function (e) {
    SelCity(this,e);
    console.log("inout",$(this).val(),new Date())
});
$("#endPcc").click(function (e) {
    SelCity(this,e);
    console.log("inout",$(this).val(),new Date())
});
var carLong='';
function btn_CarLong(long){
    carLong= long;

}
var carType='';
function btn_CarType(carT){
    carType = carT;
}
var coachType='';
function btn_CoachType(coachT){
    coachType = coachT;
}
function btn_warning(ele){
    $("table").attr("id",'');
    $("#Tab").html("");
    var state = $(ele).data('state');
    //获取数据
    var startProvince = $("#startPcc").val()==''?"":$("#startPcc").val().split('-')[0];
    var startCity = $("#startPcc").val()==''?"":$("#startPcc").val().split('-')[1];
    var toProvince = $("#endPcc").val()==''?"":$("#endPcc").val().split('-')[0];
    var toCity = $("#endPcc").val()==''?"":$("#endPcc").val().split('-')[1];



    $.get(
        'searchCarts.html',
    {
       'startProvince': startProvince,
        'startCity':startCity,
        'toProvince':toProvince,
        'toCity':toCity,
        'carLong':carLong,
        'carType':carType,
        'coachType':coachType
    },
        function(carInfo){
            $('#Tab').empty();
            var obj=carInfo.recordSet;
            var pageSize=carInfo.pageSize;
            var rowCount=carInfo.rowCount;
            var pageNum = Math.ceil(rowCount/pageSize);
            console.log(pageNum);
            $('#pageNum').empty();
            for(var i =0;i<pageNum;i++){
                //sel_btn_page
                //
                $('#pageNum').append('<li id="active" class="bgColor"><a href="javascript:void(0)" onclick="sel_btn_page('+(i+1)+')">'+(i+1)+'</a></li>');
            }
            for(var i = 0 ; i < obj.length ; i++){
                console.log(obj[i].carNum);
                var carInfo = obj[i];
                //	生成数据行
                if(state==1){
                    var $dataRow = createDataRow(carInfo,carInfo.phone);
                    console.log(carInfo.phone)

                    //	添加tbody
                    $('#Tab').append($dataRow);
                }else{
                    var $dataRow = createDataRow(carInfo,"<a href='login.jsp'><img  src='images/telephone.png' width='22' height='22'></a>");

                    //	添加tbody
                    $('#Tab').append($dataRow);
                }


            }
        },
        'json'
    );

}
function createDataRow(carInfo , phone){
   var  $tr =$("<tr></tr>").addClass("odd gradeX");
    //认证图
    var $tdImg = $("<td></td>");
    var $Img = $("<img src='images/indentity.png' width='22' height='22'/>");
    $tdImg.append($Img);
    $tr.append($tdImg);
    //车牌号
    var $tdNum = $("<td></td>").text(carInfo.carNum);
   $tr.append($tdNum);
    //车长
    var $tdLong = $("<td></td>").text(carInfo.carLong);
    $tr.append($tdLong);

    //车的类型
    var $tdcarType = $("<td>"+carInfo.carType+"&nbsp;</td>");
    $tr.append($tdcarType);
    //车厢类型
    var $tdcoachType = $("<td>"+carInfo.coachType+"&nbsp;&nbsp;</td>");
    $tr.append($tdcoachType);
    //起始地
    var $start = $("<td>"+carInfo.startProvince+"-"+carInfo.startCity+"</td>");

    $tr.append($start);
    //终点地
    var $to = $("<td>"+carInfo.toProvince+"-"+carInfo.toCity+"</td>");
    $tr.append($to);

    //手机图
    var $phone = $("<td>"+phone+"</td>");
/*<img src='images/telephone.png' width='22' height='22'>*/
    $tr.append($phone);

    return $tr;
}

function btn_page(i){
    $(this).parent().addClass("active");
    var name = $('#login').text();
    var page;
    $("#Tab").empty();
    page=i;
    $.get(
        'car.do',
    {
        "page":page

    },function(carInfos) {
            if (carInfos != null) {
                for (var i = 0; i < carInfos.length; i++) {
                    console.log(carInfos.length);
                    var carInfo = carInfos[i];
                    if(name=='登录'){
                        //	生成数据行
                        var $dataRow = createDataRow(carInfo,"<img onclick='location.href('"+"login.jsp"+"')' src='images/telephone.png' width='22' height='22' />");
                        //	添加tbody
                        $('#Tab').append($dataRow);
                    }else{
                        //	生成数据行
                        var $dataRow = createDataRow(carInfo,carInfo.phone);
                        //	添加tbody
                        $('#Tab').append($dataRow);
                    }

                }
            }

        },
             'json'
        );
}
function sel_btn_page(i){
    //获取数据
    var startProvince = $("#startPcc").val()==''?"":$("#startPcc").val().split('-')[0];
    var startCity = $("#startPcc").val()==''?"":$("#startPcc").val().split('-')[1];
    var toProvince = $("#endPcc").val()==''?"":$("#endPcc").val().split('-')[0];
    var toCity = $("#endPcc").val()==''?"":$("#endPcc").val().split('-')[1];
    var name = $('#login').text();
    var page;
    $("#Tab").empty();
    page=i;
    $.get(
        'SearchCartsPage.do',
        {
            "page":page,
            'startProvince': startProvince,
            'startCity':startCity,
            'toProvince':toProvince,
            'toCity':toCity,
            'carLong':carLong,
            'carType':carType,
            'coachType':coachType
        },function(carInfos) {
            if (carInfos != null) {
                for (var i = 0; i < carInfos.length; i++) {
                    console.log(carInfos.length);
                    var carInfo = carInfos[i];
                    if(name=='登录'){
                        //	生成数据行
                        var $dataRow = createDataRow(carInfo,"<img onclick='location.href('"+"login.jsp"+"')' src='images/telephone.png' width='22' height='22' />");
                        //	添加tbody
                        $('#Tab').append($dataRow);
                    }else{
                        //	生成数据行
                        var $dataRow = createDataRow(carInfo,carInfo.phone);
                        //	添加tbody
                        $('#Tab').append($dataRow);
                    }
                }
            }

        },
        'json'
    );
}
//分页的当前页显示背景
$("#active").bind('click',function(e){
    var $self=$(this);
    $('#active:not(this)').removeClass('bgColor');
});