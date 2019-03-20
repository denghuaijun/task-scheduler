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
            },
            {
                "data": 'status',
                "visible" : true,
                "render": function ( data, type, row ) {
                    if ("1"== data){
                        return "有效";
                    } else{
                        return "无效";
                    }
                }
            },
            {
                "data": '操作' ,
                "render": function ( data, type, row ) {

                    return function(){
                        tableData['key'+row.id] = row;
                        // 操作按钮
                        var html = '<p id="'+ row.id +'" >'+
                            '<button class="btn btn-warning btn-xs update"  _type="modify" type="button">编辑</button>  '+
                            '<button class="btn btn-danger btn-xs taskWarning_operate"  _type="delete" type="button">删除</button>  '+
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
    $("#taskwarning_list").on('click', '.update',function() {
        var id = $(this).parent('p').attr("id");
        var row = tableData['key'+id];

        // base data
        $("#updateTaskwarningModal .form input[name='id']").val( row.id );
        $('#updateTaskwarningModal .form select[name=status] option[value='+ row.status +']').prop('selected', true);
        $("#updateTaskwarningModal .form input[name='taskWarningCount']").val( row.taskWarningCount );
        // show
        $('#updateTaskwarningModal').modal({backdrop: false, keyboard: false}).modal('show');
    });

    var updateModalValidate = $("#updateTaskwarningModal .form").validate({
        errorElement : 'span',
        errorClass : 'help-block',
        focusInvalid : true,

        rules : {
            taskWarningCount : {
                required : true,
                maxlength: 50
            },
            status : {
                required : true,
                maxlength: 20
            }
        },
        messages : {
            taskWarningCount : {
                required :"请输入告警账号"
            },
            status : {
                required :"请选择告警账号状态"
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
            $.post("/taskwarning/modify",  $("#updateTaskwarningModal .form").serialize(), function(data, status) {
                if (data.code == "200") {
                    $('#updateTaskwarningModal').modal('hide');
                    layer.open({
                        title: '系统提示',
                        content: '编辑告警信息成功',
                        icon: '1',
                        end: function(layer, index){
                            taskTable.fnDraw();
                        }
                    });
                } else {
                    layer.open({
                        title: '系统提示',
                        content: (data.msg || "编辑告警信息失败"),
                        icon: '2'
                    });
                }
            });
        }

    });

    //操作事件
    $("#taskwarning_list").on('click', '.taskWarning_operate',function() {
        var typeName;
        var url;
        var needFresh = false;

        var type = $(this).attr("_type");
        if ("delete" == type) {
            typeName = "删除";
            url = "/taskwarning/delete";
            needFresh = true;
        } else if ("modify" == type) {
            typeName = "编辑";
            url = "/taskwarning/modify";
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
        $('#addTaskwarningModal').modal({backdrop: false, keyboard: false}).modal('show');
    });
    //提交新增 保存
    var addModalValidate = $("#addTaskwarningModal .form").validate({
        errorElement : 'span',
        errorClass : 'help-block',
        focusInvalid : true,
        rules : {
            taskWarningCount : {
                required : true,
                maxlength: 50
            },
            status : {
                required : true,
                maxlength : 20
            }
        },
        messages : {
            taskWarningCount : {
                required :"请输入OA账号"
            },
            status : {
                required : "请选择告警账号状态"
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
            $.post("/taskwarning/add",  $("#addTaskwarningModal .form").serialize(), function(data, status) {
                if (data.code == "200") {
                    $('#addTaskwarningModal').modal('hide');
                    layer.open({
                        title: '系统提示',
                        content: '新增告警组成功',
                        icon: '1',
                        end: function(layer, index){
                            taskTable.fnDraw();
                            window.location.reload();
                        }
                    });
                } else {
                    layer.open({
                        title: '系统提示',
                        content: (data.msg || "新增告警组失败"),
                        icon: '2'
                    });
                }
            });
        }
    });

})