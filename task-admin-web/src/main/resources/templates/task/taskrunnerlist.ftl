<!DOCTYPE html>
  	<#import "/common/page.common.ftl" as pagecommon>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  	<title>任务运行器管理</title>
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

    <@pagecommon.commonMenu "taskrunnerList"/>


    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>任务运行器管理<small>运行器列表</small></h1>
        </section>

        <!-- Main content -->
        <section class="content">

           <div class="row">
                <div class="col-xs-2 pull-right">
                    <button class="btn btn-block btn-success add" type="button">+新增任务运行器</button>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header hide">
                            <h3 class="box-title">调度列表</h3>
                        </div>
                        <div class="box-body" >
                            <table id="taskrunner_list" class="table table-bordered table-striped table-hover">
                                <thead>
                                <tr>
                                    <th name="id" >id</th>
                                    <th name="taskRunnerName" >名称</th>
                                    <th name="taskRunnerAppkey" >运行器key</th>
                                    <th name="taskRunnerAppname" >运行器方法名称</th>
                                    <th name="taskRunnerAddress" >运行器地址</th>
                                    <th name="createAt" >创建时间</th>
                                    <th name="status" >状态</th>
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
<div class="modal fade" id="addTaskrunnerModal" tabindex="-1" role="dialog"  aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" >添加运行器</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal form" role="form" >
                <div class="form-group">
                        <label for="taskRunnerName" class="col-sm-3 control-label">运行器名称<font color="red">*</font></label>
                        <div class="col-sm-9"><input type="text" class="form-control" name="taskRunnerName" placeholder="运行器名称" maxlength="64" ></div>
                    </div>
                    <div class="form-group">
                        <label for="taskRunnerAppkey" class="col-sm-3 control-label">运行器key<font color="red">*</font></label>
                        <div class="col-sm-9"><input type="text" class="form-control" name="taskRunnerAppkey" placeholder="运行器key" maxlength="64" ></div>
                    </div>
                    <div class="form-group">
                        <label for="taskRunnerAppname" class="col-sm-3 control-label">运行器执行方法名<font color="red">*</font></label>
                        <div class="col-sm-9"><input type="text" class="form-control" name="taskRunnerAppname" placeholder="运行器执行方法名" maxlength="64" ></div>
                    </div>
                    <div class="form-group">
                        <label for="taskRunnerAddress" class="col-sm-3 control-label">运行器地址<font color="red">*</font></label>
                        <div class="col-sm-9">
                            <textarea class="textarea" name="taskRunnerAddress" maxlength="512" placeholder="运行器ip" style="width: 100%; height: 100px; font-size: 14px; line-height: 10px; border: 1px solid #dddddd; padding: 10px;"></textarea>
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
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog"  aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" >编辑运行器</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal form" role="form" >
                    <div class="form-group">
                        <label for="taskRunnerName" class="col-sm-3 control-label">运行器名称<font color="red">*</font></label>
                        <div class="col-sm-9"><input type="text" class="form-control" name="taskRunnerName" placeholder="运行器名称" maxlength="64" ></div>
                    </div>
                    <div class="form-group">
                        <label for="taskRunnerAppkey" class="col-sm-3 control-label">运行器key<font color="red">*</font></label>
                        <div class="col-sm-9"><input type="text" class="form-control" name="taskRunnerAppkey" placeholder="运行器key" maxlength="64" ></div>
                    </div>
                    <div class="form-group">
                        <label for="taskRunnerAppname" class="col-sm-3 control-label">运行器执行方法名<font color="red">*</font></label>
                        <div class="col-sm-9"><input type="text" class="form-control" name="taskRunnerAppname" placeholder="运行器执行方法名" maxlength="64" ></div>
                    </div>
                    <div class="form-group">
                        <label for="taskRunnerAddress" class="col-sm-3 control-label">运行器地址<font color="red">*</font></label>
                        <div class="col-sm-9">
                            <textarea class="textarea" name="taskRunnerAddress" maxlength="512" placeholder="运行器ip" style="width: 100%; height: 100px; font-size: 14px; line-height: 10px; border: 1px solid #dddddd; padding: 10px;"></textarea>
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

<script src="/static/js/task/taskrunner.list.js"></script>
<script src="/static/js/moment.js"></script>
<script src="/static/plugin/layer/layer.js"></script>

</body>
</html>
