$('#loginForm,#regForm').bootstrapValidator({
    fields: {
        username: {
            validators: {
                notEmpty: {
                    message: '用户名不能为空.'
                },
                stringLength: {
                    min: 3,
                    max: 15,
                    message: '用户名长度应该在4 - 15之间.'
                }
            }
        },
        password: {
            validators: {
                notEmpty: {
                    message: '密码不能为空.'
                },
                stringLength: {
                    min: 6,
                    max: 15,
                    message: '密码长度应该在6 - 15之间.'
                }
            }
        }
    }
});