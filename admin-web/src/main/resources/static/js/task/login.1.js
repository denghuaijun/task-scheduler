$(function(){

	// input iCheck
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
    
	// login Form Valid
	var loginFormValid = $("#loginForm").validate({
		errorElement : 'span',  
        errorClass : 'help-block',
        focusInvalid : true,  
        rules : {
            loginUserName : {
        		required : true ,
                minlength: 5,
                maxlength: 18
            },
            loginPassWord : {
            	required : true ,
                minlength: 5,
                maxlength: 18
            } 
        }, 
        messages : {
            loginUserName : {
                required  : "请输入登录用户名",
                minlength : "登录账号不应低于5位"
            },
            loginPassWord : {
            	required  : "请输入登录密码"  ,
                minlength : "登录密码不小于5位"
                /*,maxlength:"登录密码不应超过18位"*/
            }
        }, 
		highlight : function(element) {  
            $(element).closest('.form-group').addClass('has-error');  
        },
        success : function(label) {  
            label.closest('.form-group').removeClass('has-error');  
            label.remove();  
        },
        errorPlacement : function(error, element) {  
            element.parent('div').append(error);  
        },
        submitHandler : function(form) {
            $.post("/task/login", $("#loginForm").serialize(), function(data, status) {
				if (data.code == "200") {
                    layer.msg( "登陆成功");
                    setTimeout(function(){
                        window.location.href = "/tasklist";
                    }, 500);
				} else {
                    layer.open({
                        title: '系统提示',
                        content: (data.msg || "登陆失败"),
                        icon: '2'
                    });
				}
			});
		}
	});
});