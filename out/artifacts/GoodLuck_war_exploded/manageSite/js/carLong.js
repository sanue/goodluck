/**
 * Created by Administrator on 2016/10/27.
 */
/**
 * 动态创建数据行方法
 * @return
 */
function createDataRow(carLong){
    //数据行
    var $tr=$("<tr></tr>");
    //编号
    var $tdId=$("<td></td>").text(carLong.id);
    $tr.append($tdId);
    //名称
    var $tdName=$("<td ></td>");
    $tdName.attr("class","center");
    $tdName.text(carLong.carsLong);
    //alert(carLong.carsLong);
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
        $("#modifHide").val(carLong.id);
        $("#disabledInput").val(carLong.carsLong);
    });
    $aDel.css("cursor","pointer");
    $aDel.css("color","blue");
    $aDel.appendTo($modify)
    $modify.appendTo($tr);
    return $tr;
}
/**
 * 添加车长
 * @return
 */

//打开模式对话框
function addCarLong(){
    document.getElementById('dialog').style.display = "block";
}

//添加新的车长
function addNewCarLong_btn(){

    //获取新的车长
    var newCarLong=document.querySelector("#newCarLong").value;
    if(newCarLong != ""){
    $.post(
        "addNewCarLong.do",
        {"newCarLong":newCarLong},
        function(data){
           // console.log(data);

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
        $("#checkCarLong").css({'display':'block','color':'red'});
    }
}
/**
 * 修改车长
 */

//打开模式窗口并传id
function modifyCarLong(id,carLong){
    //显示模式对话框
    document.getElementById('modifyDialog').style.display = "block";
    //$("#hide").val(id);
    document.getElementById('modifHide').value=id;
    document.getElementById('disabledInput').value=carLong;
}
//向服务器端发出请求
function modifyCarLong_btn(){
    var afterCarLong= document.getElementById('modifyCarLong').value;
    var id=document.getElementById('modifHide').value;
    //alert(afterSection+":"+id);
    if(afterCarLong!=""){
    //发送请求
    $.post(
        "modifyCarLong.do",
        {"id":id,"afterCarLong":afterCarLong},
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
        $("#checkNewCarLong").css({'display':'block','color':'red'});

    }
}