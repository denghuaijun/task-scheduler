<!DOCTYPE html>
  	<#import "/common/page.common.ftl" as pagecommon>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  	<title>告警组管理</title>
    <link rel="stylesheet" href="/static/css/bootstrap.css">
    <link rel="stylesheet" href="/static/css/bootstrap-theme.css">
    <link rel="stylesheet" href="/static/css/adminlte/AdminLTE.min.css?version=2.4">
    <link rel="stylesheet" href="/static/css/adminlte/_all-skins.min.css?version=2.4">
    <link rel="stylesheet" href="/static/css/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/static/css/datatables.min.css">
<#--
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
-->

</head>
<body class="skin-green">
<div class="wrapper">
	<@pagecommon.commonHeader />

    <@pagecommon.commonMenu "taskwarningList"/>


    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>告警器管理<small>告警器列表</small></h1>
        </section>

        <!-- Main content -->
        <section class="content">

           <div class="row">
                <div class="col-xs-2 pull-right">
                    <button class="btn btn-block btn-success add" type="button">+新增告警账户</button>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header hide">
                            <h3 class="box-title">告警账户列表</h3>
                        </div>
                        <div class="box-body" >
                            <table id="taskwarning_list" class="table table-bordered table-striped table-hover">
                                <thead>
                                <tr>
                                    <th name="id" >id</th>
                                    <th name="taskWarningCount" >OA账号</th>
                                    <th name="createTime" >创建时间</th>
                                    <th name="status">账号状态</th>
                                    <th name="操作" >操作</th>
                                </tr>
                                </thead>
                                <tbody></tbody>
                                <tfoot></tfoot>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>

    <!-- footer -->
<@pagecommon.commonFooter/>
</div>


<!-- 新增.模态框 -->
<div class="modal fade" id="addTaskwarningModal" tabindex="-1" role="dialog"  aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" >添加告警账户</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal form" role="form" >
                <div class="form-group">
                        <label for="taskWarningCount" class="col-sm-2 control-label">告警OA账号<font color="red">*</font></label>
                        <div class="col-sm-4"><input type="text" class="form-control" name="taskWarningCount" placeholder="请输入OA账号" maxlength="32" ></div>
                    <label for="taskWarningStatus" class="col-sm-2 control-label">账号状态<font color="red">*</font></label>
                    <div class="col-sm-4">
                        <select class="form-control" name="status" maxlength="10">
                            <option value="1">有效</option>
                            <option value="0">无效</option>
                        </select>
                    </div>
                    </div>

                    <hr>
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-6">
                            <button type="submit" class="btn btn-primary"  >保存</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- 更新.模态框 -->
<div class="modal fade" id="updateTaskwarningModal" tabindex="-1" role="dialog"  aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" >编辑告警信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal form" role="form" >
                    <div class="form-group">
                        <label for="taskWarningCount" class="col-sm-2 control-label">告警OA账号<font color="red">*</font></label>
                        <div class="col-sm-4"><input type="text" class="form-control" name="taskWarningCount" placeholder="请输入OA账号" maxlength="32" ></div>
                        <label for="taskWarningStatus" class="col-sm-2 control-label">账号状态<font color="red">*</font></label>
                        <div class="col-sm-4">
                            <select class="form-control" name="status" maxlength="10">
                                <option value="1">有效</option>
                                <option value="0">无效</option>
                            </select>
                        </div>
                    </div>

                    <hr>
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-6">
                            <button type="submit" class="btn btn-primary"  >保存</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            <input type="hidden" name="id" >
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="/static/js/jquery-3.3.1.js"></script>
<script src="/static/js/jquery.validate.min.js"></script>
<script src="/static/js/bootstrap.js"></script>
<script src="/static/js/adminlte.min.js"></script>
<script src="/static/js/jquery.dataTables.min.js"></script>
<script src="/static/js/dataTables.bootstrap.min.js"></script>

<script src="/static/js/task/taskwarning.list.js"></script>
<script src="/static/js/moment.js"></script>
<script src="/static/plugin/layer/layer.js"></script>

</body>
</html>
