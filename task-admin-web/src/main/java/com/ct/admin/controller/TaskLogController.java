package com.ct.admin.controller;


import com.ct.admin.service.TaskLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@Slf4j
public class TaskLogController {

    @Autowired
    private TaskLogService taskLogService;

    /**
     * 点击任务日志查看页面
     * @param model
     * @param jobGroup
     * @return
     */
    @RequestMapping(value = "/taskloglist")
    public String index(Model model, @RequestParam(required = false, defaultValue = "-1") int jobGroup) {
        //查询全部有效的taskrunner
        log.info("TaskLogController.taskloglist页面展示！");
        return "task/taskloglist";
    }

    /**
     * 数据回显
     */
    @RequestMapping("/taskloglist/pagelist")
    @ResponseBody
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int start,
                                        @RequestParam(required = false, defaultValue = "10") int length) {

        return taskLogService.pageList(start, length);
    }
}
