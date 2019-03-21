package com.ct.admin.handler;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ct.admin.annotation.PermessionLimit;
import com.ct.admin.core.conf.AdminConfig;
import com.ct.admin.dao.entity.TaskInterfaceLogWithBLOBs;
import com.ct.admin.dao.mapper.TaskInterfaceLogMapper;
import com.ct.admin.utils.CookieUtil;
import com.ct.admin.utils.HttpTools;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;
import java.util.Date;

/**
 * 权限验证拦截器
 * @author itw_denghj
 * @时间 2019/2/20
 */
@Slf4j
public class SecurityInteceptor implements HandlerInterceptor {

    //请求开始时间定义为全局变量key，进行日志跟踪
    private static final String LOGGER_START_TIME="_start_time";
    //全局实体类跟踪标识
    private static final String LOGGER_ENTITY="_logger_entity";

    public static final String LOGIN_IDENTITY_KEY = "TASK_SCHEDULE_LOGIN_IDENTITY";

    private static String LOGIN_IDENTITY_TOKEN;
    @Autowired
    private TaskInterfaceLogMapper taskInterfaceLogMapper;

    /**
     * 通过登录的用户名及密码生成令牌
     * @return
     */
    public static String getLoginIdentityToken() {
        if (LOGIN_IDENTITY_TOKEN == null) {
            String username = AdminConfig.getAdminConfig().getLoginUsername();
            String password = AdminConfig.getAdminConfig().getLoginPassword();
            // login token
            String tokenTmp = DigestUtils.md5DigestAsHex(String.valueOf(username + "_" + password).getBytes());		//.getBytes("UTF-8")
            tokenTmp = new BigInteger(1, tokenTmp.getBytes()).toString(16);

            LOGIN_IDENTITY_TOKEN = tokenTmp;
        }
        return LOGIN_IDENTITY_TOKEN;
    }
    /**
     * 用户权限验证记录权限日志表
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            //登录跳转
            if (!ifLogin(request)) {
                PermessionLimit permission = handlerMethod.getMethodAnnotation(PermessionLimit.class);
                if (permission == null || permission.limit()) {
                    response.sendRedirect(request.getContextPath() + "/toLogin");
                    return false;
                }
            }
        }
        log.info("请求路径："+request.getRequestURI());
        //创建任务接口日志实体对象
        TaskInterfaceLogWithBLOBs logEntity = new TaskInterfaceLogWithBLOBs();
        //初始化set请求数据
        logEntity.setTaskClientIp(HttpTools.getIpAddress(request));
        logEntity.setTaskRequestMethod(request.getMethod());
        String contentType = request.getContentType();
        logEntity.setTaskRequestType(contentType);
        logEntity.setTaskRequestPath(request.getRequestURI());
        logEntity.setTaskSessionId(request.getRequestedSessionId());
        logEntity.setTaskRequestTime(new Date(System.currentTimeMillis()));
        //请求参数
        String requestParams = JSONObject.toJSONString(request.getParameterMap(), SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteMapNullValue);
        logEntity.setTaskRequestParam(requestParams);
        log.info("SecurityInteceptor 请求requestURL:{},requestParams:{}",request.getRequestURI(),requestParams);
        request.setAttribute(LOGGER_ENTITY,logEntity);
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }
    @Transactional
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        int status = response.getStatus();//返回状态码
        TaskInterfaceLogWithBLOBs interfaceLog = (TaskInterfaceLogWithBLOBs) request.getAttribute(LOGGER_ENTITY);
        if (interfaceLog !=null){
            String returnValue = String.valueOf(request.getAttribute("response"));
            interfaceLog.setTaskReponseTime(new Date(System.currentTimeMillis()));
            interfaceLog.setTaskReponseCode(status+"");
            interfaceLog.setCreateTime(new Date());
            interfaceLog.setTaskReponseParam(returnValue);
            taskInterfaceLogMapper.insertSelective(interfaceLog);
        }
        log.info("SecurityInteceptor 请求requestURL:{},status:{}",request.getRequestURI(),status);
    }

    /**
     * 判断是否有权限
     * @param handler
     * @param response
     * @param request
     * @return
     */
    public boolean hasPermission(Object handler, HttpServletResponse response, HttpServletRequest request)throws Exception{
        if (handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
           /* //首先获取方法上的注解
            HasPermission hasPermission = handlerMethod.getMethod().getAnnotation(HasPermission.class);
            if (hasPermission == null){//如果方法上的注解为空在获取类上的注解
                hasPermission = handlerMethod.getMethod().getDeclaringClass().getAnnotation(HasPermission.class);
            }
            //如果标记了注解则判断是否有权限
            if(hasPermission !=null && hasPermission.value()){
                return true;
            }*/
            //登录跳转
            if (!ifLogin(request)) {
                PermessionLimit permission = handlerMethod.getMethodAnnotation(PermessionLimit.class);
                if (permission == null || permission.limit()) {
                    response.sendRedirect(request.getContextPath() + "/toLogin");
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean ifLogin(HttpServletRequest request){
        String indentityInfo = CookieUtil.getValue(request, LOGIN_IDENTITY_KEY);
        if (indentityInfo==null || !getLoginIdentityToken().equals(indentityInfo.trim())) {
            return false;
        }
        return true;
    }
    public static boolean Checklogin(HttpServletResponse response, String username, String password, boolean ifRemember){

        // login token
        String tokenTmp = DigestUtils.md5DigestAsHex(String.valueOf(username + "_" + password).getBytes());
        tokenTmp = new BigInteger(1, tokenTmp.getBytes()).toString(16);

        if (!getLoginIdentityToken().equals(tokenTmp)){
            return false;
        }
        // do login
        CookieUtil.set(response, LOGIN_IDENTITY_KEY, getLoginIdentityToken(), ifRemember);
        return true;
    }
    public static void logout(HttpServletRequest request, HttpServletResponse response){
        CookieUtil.remove(request, response, LOGIN_IDENTITY_KEY);
    }
}
