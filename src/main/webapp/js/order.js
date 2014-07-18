$(function () {
    $("#sub-nav-order").attr("class","active");
    $(".btn-pay").click(function(){
        var orderId = $(this).parent().parent().attr("pid");
        $.ajax({
            url:ctx+"/order/pay/"+orderId,
            success:function(result){
                if(result=="success"){
                    alert("付款成功...我们会尽快为您安排发货...");
                    window.location.reload();
                }else{
                    alert("发生错误..");
                }
            },
            error:function(){
                alert("发生错误..");
            }
        })
    })
    $(".btn-confirm").click(function(){
        var orderId = $(this).parent().parent().attr("pid");
        $.ajax({
            url:ctx+"/order/confirm/"+orderId,
            success:function(result){
                if(result=="success"){
                    alert("交易已完成...");
                    window.location.reload();
                }else{
                    alert("发生错误..");
                }
            },
            error:function(){
                alert("发生错误..");
            }
        })
    })
})