/**
 * Created by Administrator on 2016/10/27.
 */
/**
 * 动态创建数据行方法
 * @return
 */
function createDataRow(carType){
    //数据行
    var $tr=$("<tr></tr>");
    //编号
    var $tdId=$("<td></td>").text(carType.id);
    $tr.append($tdId);
    //名称
    var $tdName=$("<td ></td>");
    $tdName.attr("class","center");
    $tdName.text(carType.type);
    $tr.append($tdName);
    //操作
    var $modify=$("<td></td>");
    $modify.attr("class","center");
    var $aDel=$("<a></a>");
    $aDel.attr("class","btn btn-info");
    $i=$("<i ></i>");
    $i.attr("class","halflings-icon white edit");
    $i.appendTo($aDel);
    $aDel.bind("click",function(e){
        //打开模式对话框
        $("#modifyDialog").show();
        $("#modifHide").val(carType.id);
        $("#disabledInput").val(carType.type);
    });
    $aDel.css("cursor","pointer");
    $aDel.css("color","blue");
    $aDel.appendTo($modify);
    $modify.appendTo($tr);
    return $tr;
}
/**
 * 添加车长
 * @return
 */

//打开模式对话框
function addCarType(){
    document.getElementById('dialog').style.display = "block";
}

//添加新的车型
function addNewCarType_btn(){

    //获取新的车型
    var newCarType=document.querySelector("#newCarType").value;
    if(newCarType!=""){
    $.post(
        "addNewCarType.do",
        {"newCarType":newCarType},
        function(data){
            //console.log(data);
            var $tabBody=$("tbody");
            //创建数据行
            var dataRow=createDataRow(data);
            //添加到表格中
            $tabBody.append(dataRow);
        },
        "json"
    );

    $('#dialog').hide();
    }else{
        $("#checkCarType").css({'display':'block','color':'red'});
    }
}
/**
 * 修改车类型
 */

//打开模式窗口并传id
function modifyCarType(id,type){
    //显示模式对话框
    document.getElementById('modifyDialog').style.display = "block";
    //$("#hide").val(id);
    document.getElementById('modifHide').value=id;
    document.getElementById('disabledInput').value=type;
}
//向服务器端发出请求
function modifyCarType_btn(){
    var afterCarType= document.getElementById('modifyCarType').value;
    var id=document.getElementById('modifHide').value;
    //alert(afterSection+":"+id);
    if(afterCarType!=""){
    //发送请求
    $.post(
        "modifyCarType.do",
        {"id":id,"afterCarType":afterCarType},
        function(data){
            console.log(data);
            var $tabBody=$("tbody");
            //创建数据行
            var dataRow=createDataRow(data);
            //替换老数据行
            $tabBody.children().eq(id-1).replaceWith(dataRow);
        },
        "json"
    );

    $('#modifyDialog').hide();
    }else{
        $("#checkNewCarType").css({'display':'block','color':'red'});
    }
}