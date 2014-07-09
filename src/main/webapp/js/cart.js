$(function () {

    $(".addressItem").click(function () {
        var $kids = $(this).children();

        $kids.each(function( index ) {
            if(index==0){
                $("#address").val($(this).text());
            }
            if(index==1){
                $("#consignee").val($(this).text());
            }
            if(index==2){
                $("#id").val($(this).val());
            }
            if(index==3){
                $("#zipcode").val($(this).val());
            }
            if(index==4){
                $("#phone").val($(this).val());
            }
        });
    });

    $(".delBtn").click(function () {
        var pid = $(this).attr("productid");
        $.ajax({
            url: ctx + "/cart/delete/" + pid,
            success: function (result) {
                if (result == "success") {
                    $("tr[pid="+pid+"]").remove();
                    $('#delSuccess').show();
                    setTimeout(function () {
                        $('#delSuccess').hide('slow');
                    }, 3000);
                } else {
                    alert("发生错误..");
                }
            },
            error: function () {
                alert("发生错误..");
            }
        })
    });
    $("#cleanCart").click(function(){
        $.ajax({
            url: ctx + "/cart/deleteAll",
            success: function (result) {
                if (result == "success") {
                    $("tbody tr").remove();
                    $('#delAllSuccess').show();
                    setTimeout(function () {
                        $('#delAllSuccess').hide('slow');
                    }, 3000);
                } else {
                    alert("发生错误..");
                }
            },
            error: function () {
                alert("发生错误..");
            }
        })
    });
    $(".delTotal").click(function(){
        var dom = $(this).next();
        var currentTotal = parseInt(dom.html());
        if(currentTotal>1){
            $.ajax({
                url:ctx+"/cart/add/"+dom.attr("productid")+"/-1",
                success:function(result){
                    if(result=="success"){
                        dom.html(currentTotal-1);
                    }else{
                        alert("发生错误..");
                    }
                },
                error:function(){
                    alert("发生错误..");
                }
            })
        }
    });
    $(".addTotal").click(function(){
        var dom = $(this).prev();
        var currentTotal = parseInt(dom.html());
        if(currentTotal<999){
            $.ajax({
                url:ctx+"/cart/add/"+dom.attr("productid")+"/1",
                success:function(result){
                    if(result=="success"){
                        dom.html(currentTotal+1);
                    }else{
                        alert("发生错误..");
                    }
                },
                error:function(){
                    alert("发生错误..");
                }
            })
        }
    });
})