$(function () {
    $("#sub-nav-news").attr("class", "active");

    $(".del-news-btn").click(function () {
        var newsId = $(this).parent().parent().attr("pid");
        $.ajax({
            url: ctx + "/admin/news/delete/" + newsId,
            success: function (result) {
                if (result == "success") {
                    toastr.info("公告删除成功...");
                    window.location.reload();
                } else {
                    alert("发生错误..");
                }
            },
            error: function () {
                alert("发生错误..");
            }
        })
    });
})