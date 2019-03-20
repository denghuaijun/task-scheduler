<#macro commonStyle>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/bootstrap-theme.css">
    <link rel="stylesheet" href="/static/css/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/static/css/adminlte/AdminLTE.min.css?version=2.4">
    <link rel="stylesheet" href="/static/css/adminlte/_all-skins.min.css?version=2.4">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

    <![endif]-->
    <link rel="stylesheet" href="/static/css/PACE/themes/blue/pace-theme-flash.css">

</#macro>

<#macro commonScript>
    <script src="/static/js/common.1.js"></script>
</#macro>


<#macro commonHeader>
<header class="main-header">

    <!-- Logo -->
    <span class="logo"><b>任务管理</b></span>

    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
            <span class="sr-only">Toggle navigation</span>
        </a>
        <!-- Navbar Right Menu -->
        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <li class="dropdown user user-menu">
                    <a href=";" id="logoutBtn" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                        <span class="hidden-xs">注销</span>
                    </a>
                </li>
            </ul>
        </div>
    </nav>
</header>
</#macro>

<#macro commonMenu pageName>
<!-- Left side column. contains the logo and sidebar -->
	<aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu">
                <li class="header">功能目录</li>
                <li class="nav-click <#if pageName == "taskList">active</#if>" ><a href="/tasklist"><i class="fa fa-circle-o text-aqua"></i><span>任务管理</span></a></li>
                <li class="nav-click <#if pageName == "taskrunnerList">active</#if>" ><a href="/taskrunnerlist"><i class="fa fa-circle-o text-green"></i><span>任务运行器管理</span></a></li>
                <li class="nav-click <#if pageName == "tasklogList">active</#if>" ><a href="/taskloglist"><i class="fa fa-circle-o text-yellow"></i><span>任务日志查看</span></a></li>
                <li class="nav-click <#if pageName == "taskwarningList">active</#if>" ><a href="/taskwarninglist"><i class="fa fa-circle-o text-red"></i><span>告警信息管理</span></a></li>
                <li class="nav-click <#if pageName == "taskrunhelper">active</#if>" ><a href="/taskrunhelper"><i class="fa fa-circle-o text-gray"></i><span>帮助</span></a></li>
            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>
</#macro>


<#macro commonFooter >
	<footer class="main-footer">
        调度任务器
        <div class="pull-right hidden-xs">
        </div>
    </footer>
</#macro>
