$(function() {
    $("#sub-nav-product").attr("class","active");
    $(".addCart").click(function () {
        $.ajax({
            url:ctx+"/cart/add/"+$(this).attr("productid")+"/1",
            success:function(result){
                if(result=="success"){
                    toastr.info("添加购物车成功.");
                }else{
                    toastr.warn("发生错误,稍后重试.");
                }
            },
            error:function(){
                toastr.warn("发生错误,稍后重试.");
            }
        })
    })
})