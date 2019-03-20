$(function(){

	// logout
	$("#logoutBtn").click(function(){
		layer.confirm("确认注销登录？" , {
			icon: 3,
			title: "系统提示" ,
            btn: [ "确定", "取消" ]
		}, function(index){
			layer.close(index);

			$.post("/logout", function(data, status) {
				if (data.code == "200") {
                    layer.msg( "注销成功！" );
                    setTimeout(function(){
                        window.location.href =  "/";
                    }, 500);
				} else {
					layer.open({
						title: "系统提示",
                        btn: [ "确定" ],
						content: (data.msg || "注销失败！"),
						icon: '2'
					});
				}
			});
		});

	});


	
});
