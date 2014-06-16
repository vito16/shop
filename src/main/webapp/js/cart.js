$(function () {
    $('#delSuccess').hide();
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
    })
})