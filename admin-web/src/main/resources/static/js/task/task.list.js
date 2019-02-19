$(function () {
    var tableData = {};
    //列表
    var taskTable = $("#task_list").dataTable({
        "deferRender": true,
        "processing" : true,
        "serverSide": true,
        "ajax": {
            url: "/tasklist/pagelist",
            type:"post",
            data : function ( d ) {
                var obj = {};
                obj.start = d.start;
                obj.length = d.length;
                return obj;
            }
        },
        "searching": false,
        "ordering": false,
        //"scrollX": true,	// X轴滚动条，取消自适应
        "columns": [
            { "data": 'taskId', "bSortable": false, "visible" : true},
            {
                "data": 'taskName',
                "visible" : true,
                "render": function ( data, type, row ) {
                    return data;
                }
            },
            {
                "data": 'taskCron',
                "visible" : true,
                "render": function ( data, type, row ) {
                    return data;
                }
            },
            {
                "data": 'createAt',
                "visible" : true,
                "render": function ( data, type, row ) {
                    return data?moment(new Date(data)).format("YYYY-MM-DD HH:mm:ss"):"";
                }
            },
            {
                "data": 'status' ,
                "render": function ( data, type, row ) {
                    return function(){
                        // status
                        var html = '';
                        if ('1' == data) {
                            html = '<small class=\"label label-success\" ><i class=\"fa fa-clock-o\"></i>运行中</small>';
                        } else if ('2' == data) {
                            html = '<small class=\"label label-default\" ><i class=\"fa fa-clock-o\"></i>暂停</small>';
                        }else if ('3' == data) {
                            html = '<small class=\"label label-default\" ><i class=\"fa fa-clock-o\"></i>关闭</small>';
                        }
                        return html;
                    };
                }
            },
            {
                "data": '操作' ,
                "render": function ( data, type, row ) {

                    return function(){
                        tableData['key'+row.taskId] = row;
                        // 操作按钮
                        var pause_resume = "";
                        if ('1' == row.status) {
                            pause_resume = '<button class="btn btn-primary btn-xs task_operate" _type="pause" type="button">暂停</button>  ';
                        } else if ('2' == row.status){
                            pause_resume = '<button class="btn btn-primary btn-xs task_operate" _type="resume" type="button">恢复</button>  ';
                        }

                        // html
                        var html = '<p id="'+ row.taskId +'" >'+
                            '<button class="btn btn-primary btn-xs task_operate" _type="trigger" type="button">执行一次</button>  '+
                            pause_resume +
                            '<button class="btn btn-warning btn-xs update"  _type="modify" type="button">编辑</button>  '+

                            '<button class="btn btn-danger btn-xs task_operate"  _type="delete" type="button">删除</button>  '+
                            '</p>';

                        return html;
                    };
                }
            }
        ],
        "language" : {
            "sProcessing" : "处理中...",
            "sLengthMenu" : "每页 _MENU_ 条记录",
            "sZeroRecords" : "没有匹配结果",
            "sInfo" : "第 _PAGE_ 页 ( 总共 _PAGES_ 页，_TOTAL_ 条记录 )",
            "sInfoEmpty" : "无记录",
            "sInfoFiltered" : "(由 _MAX_ 项结果过滤)",
            "sInfoPostFix" : "",
            "sSearch" : "搜索:",
            "sUrl" : "",
            "sEmptyTable" : "任务数据为空",
            "sLoadingRecords" : "载入中...",
            "sInfoThousands" : ",",
            "oPaginate" : {
                "sFirst" : "首页",
                "sPrevious" : "上页",
                "sNext" : "下页",
                "sLast" : "末页"
            },
            "oAria" : {
                "sSortAscending" : ": 以升序排列此列",
                "sSortDescending" : ": 以降序排列此列"
            }
        }
    });


    // update
    $("#task_list").on('click', '.update',function() {
        var id = $(this).parent('p').attr("id");
        var row = tableData['key'+id];

        // base data
        $("#updateModal .form input[name='taskId']").val( row.taskId );
        $('#updateModal .form select[name=taskRunnerId] option[value='+ row.taskRunnerId +']').prop('selected', true);
        $("#updateModal .form input[name='taskName']").val( row.taskName );
        $("#updateModal .form input[name='taskCron']").val( row.taskCron );
        // show
        $('#updateModal').modal({backdrop: false, keyboard: false}).modal('show');
    });

    var updateModalValidate = $("#updateModal .form").validate({
        errorElement : 'span',
        errorClass : 'help-block',
        focusInvalid : true,

        rules : {
            taskName : {
                required : true,
                maxlength: 50
            },
            taskCron : {
                required : true,
                maxlength: 20
            },
            taskRunnerId : {
                required : true
            }
        },
        messages : {
            taskName : {
                required :"请输入任务的名称"
            },
            taskCron : {
                required :"请输入表达式“Cron”."
            },
            taskRunnerId : {
                required :"taskRunnerId不能为空"
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
            $.post("/task/modify",  $("#updateModal .form").serialize(), function(data, status) {
                if (data.code == "200") {
                    $('#updateModal').modal('hide');
                    layer.open({
                        title: '系统提示',
                        content: '编辑任务成功',
                        icon: '1',
                        end: function(layer, index){
                            taskTable.fnDraw();
                        }
                    });
                } else {
                    layer.open({
                        title: '系统提示',
                        content: (data.msg || "编辑任务失败"),
                        icon: '2'
                    });
                }
            });
        }

    });


    //操作事件
    $("#task_list").on('click', '.task_operate',function() {
        var typeName;
        var url;
        var needFresh = false;

        var type = $(this).attr("_type");
        if('trigger' == type) {
            typeName = "执行一次";
            url = "/task/trigger";
        } else if ("delete" == type) {
            typeName = "删除";
            url = "/task/delete";
            needFresh = true;
        } else if ("modify" == type) {
            typeName = "编辑";
            url = "/task/modify";
            needFresh = true;
        } else if ("pause" == type) {
            typeName = "暂停";
            url = "/task/pause";
            needFresh = true;
        } else if ("resume" == type) {
            typeName = "恢复";
            url = "/task/resume";
            needFresh = true;
        } else {
            return;
        }

        var id = $(this).parent('p').attr("id");

        layer.confirm('确认' + typeName + '?', {icon: 3, title:'系统提示'}, function(index){
            layer.close(index);
            $.ajax({
                type : 'POST',
                url : url,
                data : {
                    "id" : id
                },
                dataType : "json",
                success : function(data){
                    if (data.code == 200) {
                        layer.open({
                            title: '系统提示',
                            content: typeName + "成功",
                            icon: '1',
                            end: function(layer, index){
                                if (needFresh) {
                                    taskTable.fnDraw();
                                }
                            }
                        });
                    } else {
                        layer.open({
                            title: '系统提示',
                            content: (data.msg || typeName + "失败"),
                            icon: '2'
                        });
                    }
                },
            });
        });
    });


    // 点击新增任务按钮
    $(".add").click(function(){
        $('#addTaskModal').modal({backdrop: false, keyboard: false}).modal('show');
    });
    //提交新增 保存
    var addModalValidate = $("#addTaskModal .form").validate({
        errorElement : 'span',
        errorClass : 'help-block',
        focusInvalid : true,
        rules : {
            taskName : {
                required : true,
                maxlength: 50
            },
            taskCron : {
                required : true,
                maxlength: 20
            },
            taskRunnerId : {
                required : true
            }
        },
        messages : {
            taskName : {
                required :"请输入任务的名称"
            },
            taskCron : {
                required :"请输入表达式“Cron”."
            },
            taskRunnerId : {
                required :"taskRunnerId不能为空"
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
            $.post("/task/add",  $("#addTaskModal .form").serialize(), function(data, status) {
                if (data.code == "200") {
                    $('#addTaskModal').modal('hide');
                    layer.open({
                        title: '系统提示',
                        content: '新增任务成功',
                        icon: '1',
                        end: function(layer, index){
                            taskTable.fnDraw();
                            window.location.reload();
                        }
                    });
                } else {
                    layer.open({
                        title: '系统提示',
                        content: (data.msg || "新增任务失败"),
                        icon: '2'
                    });
                }
            });
        }
    });

})