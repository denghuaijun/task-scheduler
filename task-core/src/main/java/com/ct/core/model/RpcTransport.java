package com.ct.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

/**
 * @ Author     ：libin
 * @ Date       ：Created in 19:09 2018/9/13
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class RpcTransport implements Serializable {

    @Data
    @AllArgsConstructor
    public static class RpcRequestTransport implements Serializable {

        private String clientAddress;

        private long createTime;

        private Class<?> interfaceClass;

        private String appKey;

        private String appName;

        private String methodName;

    }

    public static RequestBuild RequestBuilder() {
        return new RequestBuild();
    }

    public static class RequestBuild {
        @Getter
        private String clientAddress;
        @Getter
        private long createTime;
        @Getter
        private Class<?> interfaceClass;
        @Getter
        private String appKey;
        @Getter
        private String appName;


        public RequestBuild appName(String appName) {
            this.appName = appName;
            return this;
        }

        public RequestBuild appKey(String appKey) {
            this.appKey = appKey;
            return this;
        }

        public RequestBuild clientAddress(String clientAddress) {
            this.clientAddress = clientAddress;
            return this;
        }

        public RequestBuild createTime(long createTime) {
            this.createTime = createTime;
            return this;
        }



        public RequestBuild interfaceClass(Class<?> interfaceClass) {
            this.interfaceClass = interfaceClass;
            return this;
        }



        public RpcRequestTransport build() {
            return new RpcRequestTransport(clientAddress,createTime,interfaceClass,appKey,appName,null);
        }
    }
}
