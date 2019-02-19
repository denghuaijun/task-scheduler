package com.ct.admin.core.remote;

import com.ct.core.model.RpcTransport;
import com.ct.core.utils.RpcResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;

/**
 * 远程调用代理
 * 通过RPC 调用远程 runner
 */
@Slf4j
public class ClientProxyBean implements FactoryBean {


    private RpcTransport.RpcRequestTransport rpcRequestTransport;

    private RpcResolver.RpcResolverDecoder rpcResolverDecoder;

    private RpcResolver.RpcResolverEncoder rpcResolverEncoder;


    public ClientProxyBean(RpcTransport.RpcRequestTransport rpcRequestTransport) {
        this.rpcRequestTransport = rpcRequestTransport;
    }

    //代理bean
    @Override
    public Object getObject() throws Exception {
        return get();
    }

    public Object get() {
        //配置解码器
        this.rpcResolverDecoder = new RpcResolver.RpcResolverDecoder();
        this.rpcResolverEncoder = new RpcResolver.RpcResolverEncoder();

        RpcInvoker rpcInvoker = new RpcInvoker(rpcRequestTransport);
        return new ProxyFactory(rpcRequestTransport.getInterfaceClass()).getProxy(rpcInvoker);
    }

    @Override
    public Class<?> getObjectType() {
        return rpcRequestTransport.getInterfaceClass();
    }
}
