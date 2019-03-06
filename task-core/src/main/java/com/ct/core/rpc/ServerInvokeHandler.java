package com.ct.core.rpc;

import com.ct.core.model.ReturnDTO;
import com.ct.core.model.RpcTransport;
import com.ct.core.runner.BeanFactoryMapper;
import com.ct.core.utils.HessianSerializer;
import com.ct.core.utils.HttpUtil;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.springframework.util.ReflectionUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;

/**
 * @ Author     ：libin
 * @ Date       ：Created in 19:09 2018/9/13
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class ServerInvokeHandler extends AbstractHandler {
    @Override
    public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {

        ReturnDTO invoke = invoke(request);
        httpServletResponse.setContentType(HttpUtil.MEDIA_TYPE_JSON.toString());
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        request.setHandled(true);

        OutputStream out = httpServletResponse.getOutputStream();
        byte[] serialize = HessianSerializer.serialize(invoke);
        out.write(serialize);
        out.flush();
    }

    public ReturnDTO invoke(HttpServletRequest request) {
        ReturnDTO returnDTO = ReturnDTO.SUCCESS();
        byte[] requestBytes = new byte[0];
        try {
            requestBytes = HttpUtil.readBytes(request);
            if (requestBytes == null || requestBytes.length==0) {
                returnDTO.setCode(ReturnDTO.RETURN_FAIL_CODE);
                returnDTO.setMsg("ReturnDTO byte[] is null");
                return returnDTO;
            }
            //解析request
            RpcTransport.RpcRequestTransport r = (RpcTransport.RpcRequestTransport)HessianSerializer.deserialize(requestBytes, RpcTransport.RpcRequestTransport.class);

            //返回扫描结果
            String mapKey = BeanFactoryMapper.createAppKey(r.getAppKey(), r.getAppName(), r.getMethodName());
            BeanFactoryMapper.ServiceBean beanMapper = BeanFactoryMapper.getBeanMapper(mapKey);
            Object bean = beanMapper.getBean();
            Method method = beanMapper.getMethod();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ReflectionUtils.invokeMethod(method, bean);
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnDTO;
    }
}
