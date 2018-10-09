package com.ct.admin.controller;

import com.ct.admin.model.TaskDTO;
import com.ct.admin.service.TaskService;
import com.ct.admin.service.TaskrunnerService;
import com.ct.core.model.ReturnDTO;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @ Author     ：libin
 * @ Date       ：Created in 17:14 2018/9/7
 * @ Description：任务controller
 * @ Modified By：
 * @Version:
 */
@Controller
public class TaskController {

    @Resource
    private TaskService taskService;

    @Resource
    private TaskrunnerService taskrunerService;

    /**
     * 查询页面
     * @param model
     * @param jobGroup
     * @return
     */
    @RequestMapping(value = "/tasklist")
    public String index(Model model, @RequestParam(required = false, defaultValue = "-1") int jobGroup) {
        //查询全部有效的taskrunner
        model.addAttribute("taskrunnerList", taskrunerService.findAllTaskrunner());
        return "task/tasklist";
    }

    @RequestMapping("/tasklist/pagelist")
    @ResponseBody
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int start,
                                        @RequestParam(required = false, defaultValue = "10") int length) {

        return taskService.pageList(start, length);
    }

    @RequestMapping("/task/delete")
    @ResponseBody
    public ReturnDTO<String> taskDelete(long id) {
        return taskService.taskDelete(id);
    }

    @RequestMapping("/task/add")
    @ResponseBody
    public ReturnDTO<String> taskAdd(TaskDTO taskDTO) throws SchedulerException {
        return taskService.taskAdd(taskDTO);
    }


    @RequestMapping("/task/modify")
    @ResponseBody
    public ReturnDTO<String> reschedule(TaskDTO taskDTO) {

        return taskService.taskModify(taskDTO);
    }

    @RequestMapping("/task/pause")
    @ResponseBody
    public ReturnDTO<String> pause(int id) {
        return taskService.pause(id);
    }

    @RequestMapping("/task/resume")
    @ResponseBody
    public ReturnDTO<String> resume(int id) {
        return taskService.resume(id);
    }

    @RequestMapping("/task/trigger")
    @ResponseBody
    public ReturnDTO<String> triggerJob(int id) {
        return taskService.triggerJob(id);
    }

}
