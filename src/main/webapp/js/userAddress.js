$(function () {
    $("#sub-nav-address").attr("class","active");
    //删除用户地址
    $(".delAddresslBtn").click(function () {
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

    //保存用户地址
    $("#addAddressBtn").click(function () {
        var addressId = $(this).attr("addressId");
        $.ajax({
            url: ctx + "/user/userAddress/add/",
            method:"post",
            data:{
                "address":$("#address").val(),
                "phone":$("#phone").val(),
                "zipcode":$("#zipcode").val(),
                "consignee":$("#consignee").val()
            },
            success: function (result) {
                if (result == "success") {
                    $('#addAddressSuccess').show();
                    setTimeout(function () {
                        $('#addAddressSuccess').hide('slow');
                    }, 3000);
                } else {
                    $('#errorTip').show();
                    setTimeout(function () {
                        $('#errorTip').hide('slow');
                    }, 3000);
                }
            },
            error: function () {
                $('#errorTip').show();
                setTimeout(function () {
                    $('#errorTip').hide('slow');
                }, 3000);
            }
        })
    });

    //修改用户地址
    $(".editAddresslBtn").click(function () {
        var addressId = $(this).attr("addressId");
        $.ajax({
            url: ctx + "/user/userAddress/" + addressId,
            method:"get",
            //url: ctx + "/user/userAddress/edit/" + addressId,
            success: function (result) {
                alert(result);
            },
            error: function () {
                alert("发生错误..");
            }
        })
    });
})