$(function () {
    var tableData = {};
    //列表
    var taskTable = $("#task_log_list").dataTable({
        "deferRender": true,
        "processing" : true,
        "serverSide": true,
        "ajax": {
            url: "/taskloglist/pagelist",
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
            { "data": 'taskLogId', "bSortable": false, "visible" : true},
            {
                "data": 'taskId',
                "visible" : true,
                "render": function ( data, type, row ) {
                    return data;
                }
            },
            {
                "data": 'taskRunnerId',
                "visible" : true,
                "render": function ( data, type, row ) {
                    return data;
                }
            },
            {
                "data": 'runnerAppKey',
                "visible" : true,
                "render": function ( data, type, row ) {
                    return data;
                }
            },
            {
                "data": 'runnerAppName',
                "visible" : true,
                "render": function ( data, type, row ) {
                    return data;
                }
            },
            {
                "data": 'runnerAddress',
                "visible" : true,
                "render": function ( data, type, row ) {
                    return data;
                }
            },
            {
                "data": 'message',
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
                "data": 'code',
                "visible" : true,
                "render": function ( data, type, row ) {
                    return data;
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

})