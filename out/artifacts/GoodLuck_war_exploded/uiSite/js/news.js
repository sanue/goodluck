/**
 * Created by Administrator on 2016/10/27.
 */

$('.leftNav li a').bind('click',function(){
    $('.leftNav li a').css({'background':'white','color':'#337ab7'});
    $(this).css({'background':'#ec6c2c','color':'white'});
});
$('.leftNavCur2').click(function(){
    $('.new').hide();
    $(".pageNum").hide();
    $('.old12').show();

});
$('.leftNavCur').click(function(){
    $('.old12').hide();
    $('.new').show();
    $(".pageNum").show();
});

$(".new li a").click(function(){
    var newsTitle = $(this).children().val();

    ShowMessages(newsTitle);
    $("#history").css('display','block');
    $("#history1").css('display','block');
    $('.leftNav li a:eq(0)').css({'background':'white','color':'#337ab7'});
    $(".leftNav li a:eq(1)").css({'background':'#ec6c2c','color':'white'});
    $("#pageNum").hide();
});

$(".old12>span>a").click(function(){
    $("#history").css('display','none');
    $("#history1").css('display','none');

});
    function ShowMessages(id){
        //$(".pageNum").hide();
        $.get(
            'ChangeMessages.html',
        {
            'Id':id
        },
            function (news){
                if(news!=null){
                    $('.new').hide();
                    $(".pageNum").hide();
                    $('.old12').show();
                    $('#word').html("");

                    $('#word').html(news.content);

                }
                else{
                    alert("该标题暂无文章！");
                }
            },
            'json'
        )
    }
$(function(){
    var newsTitle = $('#word1').data("id");
    if(newsTitle!=0){
        ShowMessages(newsTitle);
    }
    $('.width1003>li>a').removeClass('navCur');
    $('.width1003>li:eq(4)>a').addClass('clickNav');
});

function btn_page(i) {
    // $(this).parent().addClass("active");
    var page;
    $("#news").empty();
    page = i;
    $.get(
        'news.do',
        {
            "page": page

        }, function (news) {
            if (news != null) {
                for (var i = 0; i < news.length; i++) {
                    var newes = news[i];
                    //	生成数据行
                    var $dataRow = createDataRow(newes);
                    //	添加ul
                    $('#news').append($dataRow);
                }
            }

        },
        'json'
    );
}
    function createDataRow(n){
        //alert("news"+news);

        var $li = $("<li></li>");
        var $input = $("<input >").attr("type","hidden").val(n.id);
        var $a = $("<a ></a>").text(n.title);
        $a.append($input);
        var $span = $("<span></span>").text(n.date);
        $li.append($a);
        $li.append($span);
        /*点击标题加载文章*/
        $(".new li a").click(function(){
            var newsTitle = $(this).children().val();

            ShowMessages(newsTitle);
            $("#history").css('display','block');
            $("#history1").css('display','block');
            $('.leftNav li a:eq(0)').css({'background':'white','color':'#337ab7'});
            $(".leftNav li a:eq(1)").css({'background':'#ec6c2c','color':'white'});
            $("#pageNum").hide();
        });
        /*点击样式显示标题和文章*/
        $('.leftNav li a').bind('click',function(){
            $('.leftNav li a').css({'background':'white','color':'#337ab7'});
            $(this).css({'background':'#ec6c2c','color':'white'});
        });

        $('.leftNavCur2').click(function(){
            $('.new').hide();
            $(".pageNum").hide();
            $('.old12').show();

        });
        $('.leftNavCur').click(function(){
            $('.old12').hide();
            $('.new').show();
            $(".pageNum").show();
        });
        return $li;

    }
