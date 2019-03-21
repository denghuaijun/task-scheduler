<!DOCTYPE html>
<#import "/common/page.common.ftl" as pagecommon>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>帮助</title>
    <#-- <link rel="stylesheet" href="/static/css/md/markdown.css">-->
    <link rel="stylesheet" href="/static/css/bootstrap.css">
    <link rel="stylesheet" href="/static/css/bootstrap-theme.css">
    <link rel="stylesheet" href="/static/css/adminlte/AdminLTE.min.css?version=2.4">
    <link rel="stylesheet" href="/static/css/adminlte/_all-skins.min.css?version=2.4">
    <link rel="stylesheet" href="/static/css/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/static/css/datatables.min.css">
</head>
<body class="skin-green">
<div class="wrapper">
    <@pagecommon.commonHeader />

    <@pagecommon.commonMenu "taskrunhelper"/>

    <div class="content-wrapper">
        <section class="content">
            ${html}
        </section>
    </div>
</div>

<script src="/static/js/jquery-3.3.1.js"></script>
<script src="/static/js/jquery.validate.min.js"></script>
<script src="/static/js/bootstrap.js"></script>
<script src="/static/js/adminlte.min.js"></script>
<script src="/static/js/jquery.dataTables.min.js"></script>
<script src="/static/js/dataTables.bootstrap.min.js"></script>
<script src="/static/js/common.1.js"></script>

<script src="/static/js/moment.js"></script>
<script src="/static/plugin/layer/layer.js"></script>

</body>

</html>
