package com.ct.admin.core.remote;


import com.ct.core.model.RpcTransport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ Author     ：libin
 * @ Date       ：Created in 15:17 2018/9/6
 * @ Description：动态代理实现类
 * @ Modified By：
 * @Version:
 */
public class InvokeHandler implements InvocationHandler {

    private RpcInvoker rpcInvoker;

    public InvokeHandler(RpcInvoker rpcInvoker) {
        this.rpcInvoker = rpcInvoker;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().toLowerCase().equals("tostring")) {
            return rpcInvoker.toString();
        }

        RpcTransport.RpcRequestTransport rpcRequestTransport = rpcInvoker.getRpcRequestTransport();
        rpcRequestTransport.setMethodName(method.getName());
        System.out.println("执行远程RPC 调用 返回详细内容");
        return rpcInvoker.invoke(args);

    }
}
