package com.ct.core.runner.eureka;

import com.netflix.appinfo.DataCenterInfo;
import com.netflix.appinfo.EurekaInstanceConfig;
import com.netflix.appinfo.MyDataCenterInfo;
import com.netflix.appinfo.MyDataCenterInstanceConfig;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

@Data
@Slf4j
public class EurekaInstanceConfigBean extends MyDataCenterInstanceConfig implements EurekaInstanceConfig {

    private String appname;

    private String virtualHostName;

    private String secureVirtualHostName;

    private int nonSecurePort;

    private String instanceId;

    private boolean preferIpAddress;

    public String hostname;

    private String ipAddress;

    private DataCenterInfo dataCenterInfo = new MyDataCenterInfo(
            DataCenterInfo.Name.MyOwn);


    @Override
    public String getHostName(boolean refresh) {
        return this.preferIpAddress ? this.ipAddress : this.hostname;
    }

    public static Builder builder() {
        return new Builder();
    }

     public static class Builder{
        private static final String UNKNOWN = "unknown";

        private String appname = UNKNOWN;

        private int nonSecurePort = 80;

        private String instanceId;

        private boolean preferIpAddress = true;


         public Builder appname(String appname) {
            this.appname = appname;
            return this;
        }

         public Builder instanceId(String instanceId) {
             this.instanceId = instanceId;
             return this;
         }

         public Builder preferIpAddress(boolean preferIpAddress) {
             this.preferIpAddress = preferIpAddress;
             return this;
         }


         public Builder nonSecurePort(int nonSecurePort) {
            this.nonSecurePort = nonSecurePort;
            return this;
         }





         public InetAddress findFirstNonLoopbackHostInfo() {
             InetAddress address = findFirstNonLoopbackAddress();

             return address;
         }


         public InetAddress findFirstNonLoopbackAddress() {
             InetAddress result = null;
             try {
                 int lowest = Integer.MAX_VALUE;
                 for (Enumeration<NetworkInterface> nics = NetworkInterface
                         .getNetworkInterfaces(); nics.hasMoreElements();) {
                     NetworkInterface ifc = nics.nextElement();
                     if (ifc.isUp()) {
                         log.trace("Testing interface: " + ifc.getDisplayName());
                         if (ifc.getIndex() < lowest || result == null) {
                             lowest = ifc.getIndex();
                         }
                         else if (result != null) {
                             continue;
                         }

                     }
                 }
             }
             catch (IOException ex) {
                 log.error("Cannot get first non-loopback address", ex);
             }

             if (result != null) {
                 return result;
             }

             try {
                 return InetAddress.getLocalHost();
             }
             catch (UnknownHostException e) {
                 log.warn("Unable to retrieve localhost");
             }

             return null;
         }

         /**
          * 关键代码 注册eureka实例信息
          * @return
          */
        public EurekaInstanceConfigBean builder() {
            EurekaInstanceConfigBean eurekaInstanceConfigBean = new EurekaInstanceConfigBean();
            eurekaInstanceConfigBean.setAppname(appname);
            eurekaInstanceConfigBean.setVirtualHostName(appname);
            eurekaInstanceConfigBean.setSecureVirtualHostName(appname);
            eurekaInstanceConfigBean.setNonSecurePort(nonSecurePort);
            eurekaInstanceConfigBean.setPreferIpAddress(preferIpAddress);
            eurekaInstanceConfigBean.setInstanceId(instanceId);

            InetAddress inetAddress = findFirstNonLoopbackHostInfo();
            eurekaInstanceConfigBean.setIpAddress(inetAddress.getHostAddress());
            eurekaInstanceConfigBean.setHostname(inetAddress.getHostName());

            eurekaInstanceConfigBean.setInstanceId(appname+"_"+inetAddress.getHostAddress()+":"+nonSecurePort+"["+inetAddress.getHostName()+"]");
            return eurekaInstanceConfigBean;
        }
    }

}
