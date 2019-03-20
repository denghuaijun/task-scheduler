package com.ct.admin.controller;

import com.ct.admin.annotation.PermessionLimit;
import com.ct.admin.handler.HasPermission;
import com.ct.admin.handler.SecurityInteceptor;
import com.ct.admin.model.LoginUserDTO;
import com.ct.admin.service.TaskService;
import com.ct.admin.service.TaskWarningService;
import com.ct.admin.service.TaskrunnerService;
import com.ct.core.model.ReturnDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户登录注销控制类
 */
@Controller
public class LoginController {

    @Resource
    private TaskService taskService;

    @Resource
    private TaskrunnerService taskrunerService;

    @Resource
    private TaskWarningService taskWarningService;

    @RequestMapping("/toLogin")
    @HasPermission(value = true)
    @PermessionLimit(limit=false)
    public String toLogin(Model model, HttpServletRequest request) {
        if (SecurityInteceptor.ifLogin(request)) {
            return "redirect:/";
        }
        return "task/login";
    }

    @RequestMapping("/task/login")
    @PermessionLimit(limit=false)
    @HasPermission(value = true)
    @ResponseBody
    public ReturnDTO<String> Login(Model model, HttpServletRequest request, HttpServletResponse response, LoginUserDTO loginUserDTO) {
        if (SecurityInteceptor.ifLogin(request)) {
            return ReturnDTO.SUCCESS();
        }
        //参数校验
        if (StringUtils.isBlank(loginUserDTO.getLoginUserName()) || StringUtils.isBlank(loginUserDTO.getLoginPassWord())){
            return new ReturnDTO(ReturnDTO.RETURN_FAIL_CODE, "用户名或密码为空！");

        }
        boolean ifRem = (StringUtils.isNotBlank(loginUserDTO.getIfRemember()) && "on".equals(loginUserDTO.getIfRemember()))?true:false;
        boolean loginRet = SecurityInteceptor.Checklogin(response, loginUserDTO.getLoginUserName(), loginUserDTO.getLoginPassWord(), ifRem);
        if (!loginRet) {
            return new ReturnDTO(ReturnDTO.RETURN_FAIL_CODE, "用户名密码错误！");
        }
        return ReturnDTO.SUCCESS();
    }
    @RequestMapping(value="logout", method= RequestMethod.POST)
    @ResponseBody
    @PermessionLimit(limit=false)
    @HasPermission(value = true)
    public ReturnDTO<String> logout(HttpServletRequest request, HttpServletResponse response){
        if (SecurityInteceptor.ifLogin(request)) {
            SecurityInteceptor.logout(request, response);
        }
        return ReturnDTO.SUCCESS();
    }
}
