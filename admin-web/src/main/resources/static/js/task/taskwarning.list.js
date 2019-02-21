$(function () {
    var tableData = {};
    //列表
    var taskTable = $("#taskwarning_list").dataTable({
        "deferRender": true,
        "processing" : true,
        "serverSide": true,
        "ajax": {
            url: "/taskwarninglist/pagelist",
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
            { "data": 'id', "bSortable": false, "visible" : true},
            {
                "data": 'taskWarningCount',
                "visible" : true,
                "render": function ( data, type, row ) {
                    return data;
                }
            },

            {
                "data": 'createTime',
                "visible" : true,
                "render": function ( data, type, row ) {
                    return data?moment(new Date(data)).format("YYYY-MM-DD HH:mm:ss"):"";
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


/*    // update
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

    });*/




    // 点击新增任务按钮
    $(".add").click(function(){
        $('#addTaskrunnerModal').modal({backdrop: false, keyboard: false}).modal('show');
    });
    //提交新增 保存
    var addModalValidate = $("#addTaskrunnerModal .form").validate({
        errorElement : 'span',
        errorClass : 'help-block',
        focusInvalid : true,
        rules : {
            taskWarningCount : {
                required : true,
                maxlength: 50
            }
        },
        messages : {
            taskWarningCount : {
                required :"请输入OA账号"
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
            $.post("/taskwarning/add",  $("#addTaskrunnerModal .form").serialize(), function(data, status) {
                if (data.code == "200") {
                    $('#addTaskrunnerModal').modal('hide');
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