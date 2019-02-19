package com.ct.admin.core.remote;


import com.ct.core.model.RpcTransport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

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
        return rpcInvoker.invoke(args);

    }
}
