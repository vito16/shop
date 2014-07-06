$(function () {
    //删除用户地址
    $(".deAddresslBtn").click(function () {
        var addressId = $(this).attr("addressId");
        $.ajax({
            url: ctx + "/user/userAddress/delete/" + addressId,
            success: function (result) {
                if (result == "success") {
                    $("tr[addressId="+addressId+"]").remove();
                    $('#delAddressSuccess').show();
                    setTimeout(function () {
                        $('#delAddressSuccess').hide('slow');
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

})