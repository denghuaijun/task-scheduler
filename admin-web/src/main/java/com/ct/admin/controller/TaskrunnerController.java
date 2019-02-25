package com.ct.admin.controller;

import com.ct.admin.handler.HasPermission;
import com.ct.admin.model.TaskRunnerDTO;
import com.ct.admin.service.TaskrunnerService;
import com.ct.core.model.ReturnDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 运行器controller
 */
@Controller
public class TaskrunnerController {

    @Resource
    private TaskrunnerService taskrunnerService;



    /**
     * 进入运行器页面
     * @param model
     * @return
     */
    @HasPermission(value = true)
    @RequestMapping(value = "/taskrunnerlist")
    public String index(Model model) {

        return "task/taskrunnerlist";
    }

    /**
     * 添加运行器
     * @param taskRunnerDTO
     * @return
     */
    @RequestMapping("/taskrunner/add")
    @ResponseBody
    public ReturnDTO<String> taskrunnerAdd(TaskRunnerDTO taskRunnerDTO) {
        return taskrunnerService.taskrunnerAdd(taskRunnerDTO);
    }

    /**
     * 删除运行器
     * @param taskRunnerDTO
     * @return
     */
    @RequestMapping("/taskrunner/delete")
    @ResponseBody
    public ReturnDTO<String> taskrunnerDelete(TaskRunnerDTO taskRunnerDTO) {
        taskRunnerDTO.setActive(0);
        return taskrunnerService.taskrunnerModify(taskRunnerDTO);
    }

    /**
     * 修改运行器
     * @param taskRunnerDTO
     * @return
     */
    @RequestMapping("/taskrunner/modify")
    @ResponseBody
    public ReturnDTO<String> taskrunnerModify(TaskRunnerDTO taskRunnerDTO)  {
        return taskrunnerService.taskrunnerModify(taskRunnerDTO);
    }


    /**
     * 分页
     * @param start
     * @param length
     * @return
     */
    @RequestMapping("/taskrunnerlist/pagelist")
    @ResponseBody
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int start,
                                        @RequestParam(required = false, defaultValue = "10") int length) {

        return taskrunnerService.pageList(start, length);
    }
}
