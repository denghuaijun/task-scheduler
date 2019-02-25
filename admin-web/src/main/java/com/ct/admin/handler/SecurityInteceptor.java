package com.ct.admin.handler;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ct.admin.dao.entity.TaskInterfaceLogWithBLOBs;
import com.ct.admin.dao.mapper.TaskInterfaceLogMapper;
import com.ct.admin.utils.HttpTools;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @Autowired
    private TaskInterfaceLogMapper taskInterfaceLogMapper;
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
       if (hasPermission(handler)){//如果在controller里面加了 @HasPermission(value = true)这个注解将不进行日志记录
           return true;
       }
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
     * @return
     */
    public boolean hasPermission(Object handler){
        if (handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            //首先获取方法上的注解
            HasPermission hasPermission = handlerMethod.getMethod().getAnnotation(HasPermission.class);
            if (hasPermission == null){//如果方法上的注解为空在获取类上的注解
                hasPermission = handlerMethod.getMethod().getDeclaringClass().getAnnotation(HasPermission.class);
            }
            //如果标记了注解则判断是否有权限
            if(hasPermission !=null && hasPermission.value()){
                return true;
            }
        }
        return false;
    }
}
