package com.ct.admin.controller;

import com.ct.admin.model.TaskWarningDTO;
import com.ct.admin.service.TaskWarningService;
import com.ct.core.model.ReturnDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 运行器controller
 */
@Controller
public class TaskWarningController {


  @Autowired
  private TaskWarningService taskWarningService;


    /**
     * 进入告警器管理页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/taskwarninglist")
    public String index(Model model) {

        return "task/taskwarninglist";
    }
    /**
     * 添加告警器用户信息
     */
    @RequestMapping("/taskwarning/add")
    @ResponseBody
    public ReturnDTO<String> taskWarningAdd(TaskWarningDTO taskWarningDTO) {
        return taskWarningService.taskwarningAdd(taskWarningDTO);
    }
  /**
   * 分页
   * @param start
   * @param length
   * @return
   */
  @RequestMapping("/taskwarninglist/pagelist")
  @ResponseBody
  public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int start,
                                      @RequestParam(required = false, defaultValue = "10") int length) {

    return taskWarningService.pageList(start, length);
  }


}
