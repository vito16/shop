$(function () {
    $("#sub-nav-order").attr("class","active");
    $(".btn-pay").click(function(){
        var orderId = $(this).attr("orderId");
        $.ajax({
            url:ctx+"/order/pay/"+orderId,
            success:function(result){
                if(result=="success"){
                    alert("付款成功...我们会尽快为您安排发货...");
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