<!DOCTYPE html>
  	<#import "/common/page.common.ftl" as pagecommon>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  	<title>调度任务日志查看</title>
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

    <@pagecommon.commonMenu "tasklogList"/>


    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>任务日志管理<small>日志列表</small></h1>
        </section>

        <!-- Main content -->
        <section class="content">

            <#--<div class="row">
                <div class="col-xs-2 pull-right">
                    <button class="btn btn-block btn-success add" type="button">+新增任务</button>
                </div>
            </div>-->

            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header hide">
                            <h3 class="box-title">日志列表</h3>
                        </div>
                        <div class="box-body" >
                            <table id="task_log_list" class="table table-bordered table-striped table-hover">
                                <thead>
                                <tr>
                                    <th name="taskLogId" >id</th>
                                    <th name="taskId" >任务id</th>
                                    <th name="taskRunnerId" >运行器id</th>
                                    <th name="runnerAppKey" >运行器key</th>
                                    <th name="runnerAppName" >运行器方法名称</th>
                                    <th name="runnerAddress" >运行器地址</th>
                                    <th name="message" >返回信息</th>
                                    <th name="createTime" >创建时间</th>
                                    <th name="code" >code码</th>
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


<!-- 新增模态框 -->
<#--<div class="modal fade" id="addTaskModal" tabindex="-1" role="dialog"  aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <form class="form-horizontal form" role="form" >
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" >新增任务</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                        <label for="taskName" class="col-sm-2 control-label">任务名称<font color="red">*</font></label>
                        <div class="col-sm-4"><input type="text" class="form-control" name="taskName" placeholder="请输入任务名称" maxlength="50" ></div>
                        <label for="taskCron" class="col-sm-2 control-label">Cron<font color="red">*</font></label>
                        <div class="col-sm-4"><input type="text" class="form-control" name="taskCron" placeholder="请输入“Cron” */5 * * * * ? *" maxlength="20" ></div>
                </div>
                <div class="form-group">
                    <label for="taskRunId" class="col-sm-2 control-label">关联任务运行器<font color="red">*</font></label>
                    <div class="col-sm-4">
                        <select class="form-control" name="taskRunnerId" >
                            <#list taskrunnerList as taskrunner>
                                <option value="${taskrunner.id}"  >${taskrunner.taskRunnerName}</option>
                            </#list>
                        </select>
                    </div>
                </div>

                <div class="modal-footer">
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-6">
                            <button type="submit" class="btn btn-primary"  >保存</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        </div>
                    </div>
                </div>
            </div>
            </form>
        </div>
    </div>
</div>
<!-- 结束 &ndash;&gt;

<!-- 编辑 模块框 &ndash;&gt;
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog"  aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" >编辑任务</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal form" role="form" >
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="taskName" class="col-sm-2 control-label">任务名称<font color="red">*</font></label>
                            <div class="col-sm-4"><input type="text" class="form-control" name="taskName" placeholder="请输入任务名称" maxlength="50" ></div>
                            <label for="taskCron" class="col-sm-2 control-label">Cron<font color="red">*</font></label>
                            <div class="col-sm-4"><input type="text" class="form-control" name="taskCron" placeholder="请输入“Cron” */5 * * * * ? *" maxlength="20" ></div>
                        </div>
                        <div class="form-group">
                            <label for="taskRunId" class="col-sm-2 control-label">关联任务运行器<font color="red">*</font></label>
                            <div class="col-sm-4">
                                <select class="form-control" name="taskRunnerId" >
                            <#list taskrunnerList as taskrunner>
                                <option value="${taskrunner.id}"  >${taskrunner.taskRunnerName}</option>
                            </#list>
                                </select>
                            </div>
                        </div>

                        <div class="modal-footer">
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-6">
                                    <button type="submit" class="btn btn-primary"  >保存</button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                    <input type="hidden" name="taskId" >
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>-->
<!-- 结束 -->


<script src="/static/js/jquery-3.3.1.js"></script>
<script src="/static/js/jquery.validate.min.js"></script>
<script src="/static/js/bootstrap.js"></script>
<script src="/static/js/adminlte.min.js"></script>
<script src="/static/js/jquery.dataTables.min.js"></script>
<script src="/static/js/dataTables.bootstrap.min.js"></script>
<script src="/static/js/common.1.js"></script>

<script src="/static/js/task/tasklog.list.js"></script>
<script src="/static/js/moment.js"></script>
<script src="/static/plugin/layer/layer.js"></script>

</body>
</html>
