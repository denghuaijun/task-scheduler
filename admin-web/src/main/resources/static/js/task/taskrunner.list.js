$(function () {

    var tableData = {};

    var taskrunnerTable = $("#taskrunner_list").dataTable({
        "deferRender": true,
        "processing" : true,
        "serverSide": true,
        "ajax": {
            url: "/taskrunnerlist/pagelist",
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
                "data": 'taskRunnerName',
                "visible" : true,
                "render": function ( data, type, row ) {
                    return data;
                }
            },
            {
                "data": 'taskRunnerAppkey',
                "visible" : true,
                "render": function ( data, type, row ) {
                    return data;
                }
            },
            {
                "data": 'taskRunnerAppname',
                "visible" : true,
                "render": function ( data, type, row ) {
                    return data;
                }
            },
            {
                "data": 'taskRunnerAddress',
                "visible" : true,
                "render": function ( data, type, row ) {
                    return data;
                }
            },
            {
                "data": 'createAt',
                "visible" : true,
                "render": function ( data, type, row ) {
                    return data;
                }
            },
            {
                "data": 'status' ,
                "render": function ( data, type, row ) {
                    return function(){
                        // status
                        if ('1' == data) {
                            return '<small class="label label-success" ><i class="fa fa-clock-o"></i>正常</small>';
                        } else if ('2' == data){
                            return '<small class="label label-default" ><i class="fa fa-clock-o"></i>'+ data +'</small>';
                        } else if ('3' == data){
                            return '<small class="label label-default" ><i class="fa fa-clock-o"></i>'+ data +'</small>';
                        }
                        return data;
                    };
                }
            },
            {
                "data": '操作' ,
                "render": function ( data, type, row ) {

                    return function(){
                        tableData['key'+row.id] = row;
                        // html
                        var html = '<p id="'+ row.id +'" >'+
                            '<button class="btn btn-warning btn-xs update"  _type="modify" type="button">编辑</button>  '+
                            '<button class="btn btn-danger btn-xs taskrunner_operate"  _type="delete" type="button">删除</button>  '+
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
            "sEmptyTable" : "表中数据为空",
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


    $("#taskrunner_list").on('click', '.taskrunner_operate',function() {
        var typeName;
        var url;
        var needFresh = false;

        var type = $(this).attr("_type");
        if ("delete" == type) {
            typeName = "删除";
            url = "/taskrunner/delete";
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
                            end: function(layero, index){
                                if (needFresh) {
                                    taskrunnerTable.fnDraw();
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
        $('#addTaskrunnerModal').modal({backdrop: false, keyboard: false}).modal('show');
    });
    //提交新增 保存
    var addModalValidate = $("#addTaskrunnerModal .form").validate({
        errorElement : 'span',
        errorClass : 'help-block',
        focusInvalid : true,
        rules : {
            taskRunnerName : {
                required : true,
                maxlength: 64
            },
            taskRunnerAppkey : {
                required : true,
                maxlength: 64
            },
            taskRunnerAppname : {
                required : true,
                maxlength: 64
            },
            taskRunnerAddress : {
                required : false,
                maxlength: 24
            }
        },
        messages : {
            taskRunnerName : {
                required :"请输入运行器名称"
            },
            taskRunnerAppkey : {
                required :"请输入运行器appkey"
            },
            taskRunnerAppname : {
                required :"请输入运行器appname"
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
            $.post("/taskrunner/add",  $("#addTaskrunnerModal .form").serialize(), function(data, status) {
                if (data.code == "200") {
                    $('#addTaskrunnerModal').modal('hide');
                    layer.open({
                        title: '系统提示',
                        content: '添加运行器成功',
                        icon: '1',
                        end: function(layero, index){
                            taskrunnerTable.fnDraw();
                        }
                    });
                } else {
                    layer.open({
                        title: '系统提示',
                        content: (data.msg || "新增失败"),
                        icon: '2'
                    });
                }
            });
        }
    });


    // update
    $("#taskrunner_list").on('click', '.update',function() {

        var id = $(this).parent('p').attr("id");
        var row = tableData['key'+id];

        var runneraddress = '';
        if (row.discoveryServices == 0) {
            runneraddress = row.taskRunnerAddress;
        }
        // base data
        $("#updateModal .form input[name='id']").val( row.id );
        $("#updateModal .form input[name='taskRunnerName']").val( row.taskRunnerName );
        $("#updateModal .form input[name='taskRunnerAppkey']").val( row.taskRunnerAppkey );
        $("#updateModal .form input[name='taskRunnerAppname']").val( row.taskRunnerAppname );
        $("#updateModal .form textarea[name='taskRunnerAddress']").val( runneraddress );
        // show
        $('#updateModal').modal({backdrop: false, keyboard: false}).modal('show');
    });

    var updateModalValidate = $("#updateModal .form").validate({
        errorElement : 'span',
        errorClass : 'help-block',
        focusInvalid : true,
        rules : {
            taskRunnerName : {
                required : true,
                maxlength: 64
            },
            taskRunnerAppkey : {
                required : true,
                maxlength: 64
            },
            taskRunnerAppname : {
                required : true,
                maxlength: 64
            },
            taskRunnerAddress : {
                required : false,
                maxlength: 24
            }
        },
        messages : {
            taskRunnerName : {
                required :"请输入运行器名称"
            },
            taskRunnerAppkey : {
                required :"请输入运行器appkey"
            },
            taskRunnerAppname : {
                required :"请输入运行器appname"
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
            $.post("/taskrunner/modify",  $("#updateModal .form").serialize(), function(data, status) {
                if (data.code == "200") {
                    $('#updateModal').modal('hide');
                    layer.open({
                        title: '系统提示',
                        content: '编辑运行器成功',
                        icon: '1',
                        end: function(layero, index){
                            taskrunnerTable.fnDraw();
                        }
                    });
                } else {
                    layer.open({
                        title: '系统提示',
                        content: (data.msg || "编辑失败"),
                        icon: '2'
                    });
                }

            });
        }
    });


})