$(function () {
    $("#sub-nav-order").attr("class", "active");

    $(".cancel-order-btn").click(function () {
        var orderId = $(this).parent().parent().parent().attr("pid");
        $.ajax({
            url: "/order/cancel/" + orderId,
            success: function (result) {
                if(result.status=="SUCCESS"){
                    toastr.info("订单已取消成功...");
                    window.location.reload();
                } else {
                    toastr.error(result.message);
                }
            },
            error: function () {
                toastr.error("发生错误..");
            }
        })
    });
    $(".pay-order-btn").click(function () {
        var orderId = $(this).parent().parent().parent().attr("pid");
        $.ajax({
            url: "/user/order/pay/" + orderId,
            success: function (result) {
                if(result.status=="SUCCESS"){
                    toastr.info("付款成功...我们会尽快为您安排发货...");
                    window.location.reload();
                } else {
                    toastr.error(result.message);
                }
            },
            error: function () {
                toastr.error("发生错误..");
            }
        })
    });

    $(".confirm-order-btn").click(function () {
        var orderId = $(this).parent().parent().parent().attr("pid");
        $.ajax({
            url: "/order/confirm/" + orderId,
            success: function (result) {
                if(result.status=="SUCCESS"){
                    toastr.info("交易已完成...");
                    window.location.reload();
                } else {
                    toastr.error(result.message);
                }
            },
            error: function () {
                toastr.error("发生错误..");
            }
        });
    });
    $(".del-order-btn").click(function () {
        var orderId = $(this).parent().parent().parent().attr("pid");
        $.ajax({
            url: "/admin/order/delete/" + orderId,
            success: function (result) {
                if(result.status=="SUCCESS"){
                    toastr.info("订单删除成功...");
                    window.location.reload();
                } else {
                    toastr.error(result.message);
                }
            },
            error: function () {
                toastr.error("发生错误..");
            }
        })
    });
    $(".ship-order-btn").click(function () {
        var orderId = $(this).parent().parent().parent().attr("pid");
        $.ajax({
            url: "/admin/order/ship/" + orderId,
            success: function (result) {
                if(result.status=="SUCCESS"){
                    toastr.info("发货成功...");
                    // $("tr[pid="+orderId+"] td:eq(3)").val("已发货");
                    window.location.reload();
                } else {
                    toastr.error(result.message);
                }
            },
            error: function () {
                toastr.error("发生错误..");
            }
        })
    });
})