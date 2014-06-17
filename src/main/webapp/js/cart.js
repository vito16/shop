$(function () {
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
    })
})