package com.ct.admin.controller;

import com.ct.admin.handler.HasPermission;
import com.ct.admin.model.MarkdownEntity;
import com.ct.admin.utils.MarkDown2HtmlWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 任务帮助后台markdown文件转为html文件工具类
 */
@Controller
@Slf4j
public class TaskRunHelperController {

    @HasPermission(value = true)
    @RequestMapping(value = "/taskrunhelper")
    public String index(Model model) {
        String file = "md/helper.md";
        try {
            MarkdownEntity markdownEntity = MarkDown2HtmlWrapper.ofFile(file);
            model.addAttribute("html",markdownEntity.toString());
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("html","<i><h3><font color =\"red\"><strong>页面跳转异常,异常信息："+e.getMessage()+"</strong></font></h3><i>");
        }
        return "task/helper";
    }
}
