$(function() {
    $("#sub-nav-product").attr("class","active");
    var productId = $(this).attr("productid");
    $(".addCart").click(function () {
        $.ajax({
            url:"/cart/add/"+productId+"/1",
            success:function(result){
                if(result.status=="SUCCESS"){
                    toastr.info("添加购物车成功.");
                }else{
                    toastr.warn(result.message);
                }
            },
            error:function(){
                toastr.warn("发生错误,稍后重试.");
            }
        })
    })
})