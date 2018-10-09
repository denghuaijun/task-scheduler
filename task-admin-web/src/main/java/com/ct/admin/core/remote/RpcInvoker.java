package com.ct.admin.core.remote;

import com.ct.core.model.ReturnDTO;
import com.ct.core.model.RpcTransport;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @ Author     ：libin
 * @ Date       ：Created in 13:17 2018/9/5
 * @ Description：RPC基本属性 请求执行器
 * @ Modified By：
 * @Version:
 */
@AllArgsConstructor
@Data
public class RpcInvoker {

    private RpcTransport.RpcRequestTransport rpcRequestTransport;

    public Object invoke(Object[] argv) throws Throwable {
        Map<String, Collection<String>> headers = new HashMap<>();
        Client client = new Client.DefaultClient();
        ReturnDTO execute = client.execute(rpcRequestTransport);
        return execute;
    }
}
