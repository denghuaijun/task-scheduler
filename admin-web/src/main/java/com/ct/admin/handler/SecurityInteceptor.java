package com.ct.admin.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限验证拦截器
 * @author itw_denghj
 * @时间 2019/2/20
 */
@Slf4j
public class SecurityInteceptor implements HandlerInterceptor {
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
        HandlerMethod methodHandle = (HandlerMethod) handler;
        log.info("SecurityInteceptor 请求requestURL:{}"+request.getRequestURI());
        log.info("SecurityInteceptor getMethod:{}"+request.getMethod());
        log.info("SecurityInteceptor getServletPath:{}"+request.getServletPath());

        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
