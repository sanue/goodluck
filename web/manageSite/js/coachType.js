/**
 * Created by Administrator on 2016/10/28.
 */
/**
 * Created by Administrator on 2016/10/27.
 */
/**
 * 动态创建数据行方法
 * @return
 */
function createDataRow(coachType){
    //数据行
    var $tr=$("<tr></tr>");
    //编号
    var $tdId=$("<td></td>").text(coachType.id);
    $tr.append($tdId);
    //名称
    var $tdName=$("<td ></td>");
    $tdName.attr("class","center");
    $tdName.text(coachType.type);
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
        $("#modifHide").val(coachType.id);
        $("#disabledInput").val(coachType.type);
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
function addCoachType(){
    document.getElementById('dialog').style.display = "block";
}

//添加新的车型
function addNewCoachType_btn(){

    //获取新的车型
    var newCoachType=document.querySelector("#newCoachType").value;
    if(newCoachType!=""){
    $.post(
        "addNewCoachType.do",
        {"newCoachType":newCoachType},
        function(data){
            console.log(data);
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
        $("#checkCoachType").css({'display':'block','color':'red'});
    }
}
/**
 * 修改车厢类型
 */

//打开模式窗口并传id
function modifyCoachType(id,type){
    //显示模式对话框
    document.getElementById('modifyDialog').style.display = "block";
    //$("#hide").val(id);
    document.getElementById('modifHide').value=id;
    document.getElementById('disabledInput').value=type;
}
//向服务器端发出请求
function modifyCoachType_btn(){
    var afterCoachType= document.getElementById('modifyCoachType').value;
    var id=document.getElementById('modifHide').value;
    //alert(afterSection+":"+id);
    //发送请求
    if(afterCoachType!=""){
    $.post(
        "modifyCoachType.do",
        {"id":id,"afterCoachType":afterCoachType},
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
        $("#checkNewCoachType").css({'display':'block','color':'red'});
    }
}