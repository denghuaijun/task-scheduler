<!DOCTYPE html>
<html>
<head>
  	<#import "/common/page.common.ftl" as pagecommon>
	<@pagecommon.commonStyle />
    <link rel="stylesheet" href="/static/iCheck/square/blue.css">
	<title>分布式调度系统</title>
</head>
<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<a><b>分布式调度框架<br>task-scheduler</br></b></a>
		</div>
		<form id="loginForm" method="post" >
			<div class="login-box-body">
				<p class="login-box-msg">分布式调度中心</p>
				<div class="form-group has-feedback">
	            	<input type="text" name="loginUserName" class="form-control" placeholder="请输入账号"  maxlength="18" >
	            	<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>
	          	<div class="form-group has-feedback">
	            	<input type="password" name="loginPassWord" class="form-control" placeholder="请输入密码"  maxlength="18" >
	            	<span class="glyphicon glyphicon-lock form-control-feedback"></span>
	          	</div>
				<div class="row">
					<div class="col-xs-8">
		              	<div class="checkbox icheck">
		                	<label>
		                  		<input type="checkbox" name="ifRemember" >记住密码
		                	</label>
						</div>
		            </div><!-- /.col -->
		            <div class="col-xs-4">
						<button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
					</div>
				</div>
			</div>
		</form>
	</div>

<script src="/static/js/jquery-3.3.1.js"></script>
<script src="/static/js/jquery.validate.min.js"></script>
<script src="/static/js/bootstrap.js"></script>
<script src="/static/js/adminlte.min.js"></script>
<script src="/static/js/fastclick.js"></script>
<script src="/static/plugin/layer/layer.js"></script>
<script src="/static/js/jquery.slimscroll.min.js"></script>
<script src="/static/js/pace.min.js"></script>
<script src="/static/js/jquery.cookie.js"></script>
<script src="/static/iCheck/icheck.min.js"></script>
<script src="/static/js/task/login.1.js"></script>

</body>
</html>
