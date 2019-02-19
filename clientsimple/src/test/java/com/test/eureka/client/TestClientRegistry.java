package com.test.eureka.client;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.DataCenterInfo;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.appinfo.MyDataCenterInstanceConfig;
import com.netflix.config.ConfigurationManager;
import com.netflix.discovery.DefaultEurekaClientConfig;
import com.netflix.discovery.DiscoveryClient;

import java.util.UUID;

/**
 * @ Author     ：libin
 * @ Date       ：Created in 19:08 2019/1/14
 * @ Description：
 * @ Modified By：
 * @Version:
 */
public class TestClientRegistry {

    public static void main(String[] args) {
        ConfigurationManager.getConfigInstance().setProperty("eureka.registration.enabled", "false");
        ConfigurationManager.getConfigInstance().setProperty("eureka.shouldFetchRegistry", "false");
        ConfigurationManager.getConfigInstance().setProperty("eureka.serviceUrl.default",
                "http://localhost:8761/");

        InstanceInfo.Builder builder = InstanceInfo.Builder.newBuilder();
        builder.setIPAddr("10.10.101.00");
        builder.setHostName("Hosttt");
        builder.setAppName("EurekaTestApp-" + UUID.randomUUID());
        builder.setDataCenterInfo(new DataCenterInfo() {
            @Override
            public DataCenterInfo.Name getName() {
                return Name.MyOwn;
            }
        });

        ApplicationInfoManager applicationInfoManager = new ApplicationInfoManager(new MyDataCenterInstanceConfig(), builder.build());
        DiscoveryClient client = new DiscoveryClient(applicationInfoManager, new DefaultEurekaClientConfig());
        System.out.println(client.getApplications());

        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
