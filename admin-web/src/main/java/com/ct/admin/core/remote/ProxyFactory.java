package com.ct.admin.core.remote;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by libin on 2017/9/21.
 * 动态代理对象
 */
public class ProxyFactory {

    //动态代理目标
    private Class target;

    public ProxyFactory(Class target) {
        this.target = target;
    }

    //设置动态代理对象

    public <T> T getProxy(RpcInvoker rpcInvoker) {
        InvocationHandler handler = new InvokeHandler(rpcInvoker);
       return (T)Proxy.newProxyInstance(target.getClassLoader(), new Class[]{target}, handler);
    }

/*    public <T> T getProxy( Class<?>[] interfaces) {
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), interfaces, new InvokeHandler());
    }*/

}

