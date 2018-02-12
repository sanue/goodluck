/**
 * Created by Administrator on 2016/10/26.
 */
//初始化Input的灰色提示信息
function inputTipText(){
    $("input[tipMsg]").each(function(){
        if($(this).val() == ""){
            var oldVal=$(this).attr("tipMsg");
            if($(this).val()==""){$(this).attr("value",oldVal).css({"color":"#888"});}
            $(this)
                .css({"color":"#888"})     //灰色
                .focus(function(){
                    if($(this).val()!=oldVal){$(this).css({"color":"#000"})}else{$(this).val("").css({"color":"#888"})}
                })
                .blur(function(){
                    if($(this).val()==""){$(this).val(oldVal).css({"color":"#888"})}
                })
                .keydown(function(){$(this).css({"color":"#000"})});
        }
    });
}