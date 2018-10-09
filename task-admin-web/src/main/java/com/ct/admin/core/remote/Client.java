package com.ct.admin.core.remote;

import com.ct.core.model.ReturnDTO;
import com.ct.core.model.RpcTransport;
import com.ct.core.utils.HessianSerializer;
import com.ct.core.utils.HttpUtil;

/**
 * @ Author     ：libin
 * @ Date       ：Created in 16:18 2018/9/6
 * @ Description：client 远程调用
 * @ Modified By：
 * @Version:
 */
public interface Client {

    ReturnDTO execute(RpcTransport.RpcRequestTransport rpcRequestTransport);


    /**
     * 默认调用器
     */
    class DefaultClient implements Client {

        @Override
        public ReturnDTO execute(RpcTransport.RpcRequestTransport rpcRequestTransport) {
            ReturnDTO returnDTO;
            byte[] serialize = HessianSerializer.serialize(rpcRequestTransport);
            try {
                byte[] bytes = HttpUtil.postRequestBody(serialize, rpcRequestTransport.getClientAddress());

                returnDTO = (ReturnDTO) HessianSerializer.deserialize(bytes, ReturnDTO.class);

            } catch (Exception e) {
                returnDTO = ReturnDTO.FAIL();
                returnDTO.setMsg("执行客户端返回失败"+e.getMessage());
            }
            return returnDTO;
        }
    }


}
