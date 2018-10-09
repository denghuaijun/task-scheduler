package com.ct.core.utils;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public interface RpcResolver {

    public class RpcResolverEncoder{
        public <T> byte[] serialize(T obj) {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            HessianOutput ho = new HessianOutput(os);
            try {
                ho.writeObject(obj);
            } catch (IOException e) {
                throw new IllegalStateException(e.getMessage(), e);
            }
            return os.toByteArray();
        }
    }

    public class RpcResolverDecoder{
        public static <T> Object deserialize(byte[] bytes, Class<T> clazz) {
            ByteArrayInputStream is = new ByteArrayInputStream(bytes);
            HessianInput hi = new HessianInput(is);
            try {
                return hi.readObject();
            } catch (IOException e) {
                throw new IllegalStateException(e.getMessage(), e);
            }
        }
    }
}
