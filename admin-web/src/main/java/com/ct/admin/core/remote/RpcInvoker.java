package com.ct.admin.core.remote;

import com.ct.admin.core.schedule.SchedulerFactory;
import com.ct.core.model.ReturnDTO;
import com.ct.core.model.RpcTransport;
import com.ct.core.utils.HessianSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * RPC基本属性 请求执行器
 */
@AllArgsConstructor
@Data
@Slf4j
public class RpcInvoker {

    private RpcTransport.RpcRequestTransport rpcRequestTransport;

    public Object invoke(Object[] argv) throws Throwable {
        Map<String, Collection<String>> headers = new HashMap<>();

        ReturnDTO execute;
        if (StringUtils.isBlank(rpcRequestTransport.getClientAddress())) {
             execute = execute(rpcRequestTransport);
        } else {
            Client client = new Client.DefaultClient();
             execute = client.execute(rpcRequestTransport);
        }
        return execute;
    }

    public ReturnDTO execute(RpcTransport.RpcRequestTransport rpcRequestTransport) {
        ReturnDTO returnDTO;
        byte[] serialize = HessianSerializer.serialize(rpcRequestTransport);
        rpcRequestTransport.setClientAddress("http://"+rpcRequestTransport.getAppKey());
        try {
            byte[] result = SchedulerFactory.getRestTemplate().postForObject("http://"+rpcRequestTransport.getAppKey(), serialize, byte[].class);
            returnDTO = (ReturnDTO) HessianSerializer.deserialize(result, ReturnDTO.class);
        } catch (Exception e) {
            returnDTO = ReturnDTO.FAIL();
            returnDTO.setMsg("执行客户端返回失败"+e.getMessage());
            log.error("error: "+e.getMessage());
        }
        return returnDTO;
    }
}
