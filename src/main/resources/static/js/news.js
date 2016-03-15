$(function () {
    $("#sub-nav-news").attr("class", "active");
    //保存公告
    $("#addNewsBtn").click(function () {
        //var addressId = $(this).attr("addressId");
        $.ajax({
            url: ctx + "/news/add/",
            method:"post",
            data:{
                "content":$("#content").val(),
                "title":$("#title").val()
            },
            success: function (result) {
                if (result == "success") {
                    $('#addNewsSuccess').show();
                    setTimeout(function () {
                        $('#addNewsSuccess').hide('slow');
                        window.location.reload();
                    }, 3000);
                } else {
                    alert("发生错误");
                }
            },
            error: function () {
                alert("发生错误");
            }
        })
    });

})