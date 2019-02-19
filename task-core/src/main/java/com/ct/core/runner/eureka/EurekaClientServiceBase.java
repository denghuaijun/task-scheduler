package com.ct.core.runner.eureka;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.EurekaInstanceConfig;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.appinfo.LeaseInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;

import java.util.Map;


@Slf4j
public class EurekaClientServiceBase {

    private static ApplicationInfoManager applicationInfoManager = null;
    private static EurekaClient eurekaClient = null;
    private static Environment environment = null;

    public static void instance(ApplicationInfoManager applicationInfoManager,
                              EurekaClient eurekaClient,
                                   Environment environment) {

        if (EurekaClientServiceBase.applicationInfoManager == null && EurekaClientServiceBase.eurekaClient == null && EurekaClientServiceBase.environment == null) {
            EurekaClientServiceBase.applicationInfoManager = applicationInfoManager;
            EurekaClientServiceBase.eurekaClient = eurekaClient;
            EurekaClientServiceBase.environment = environment;
        }
    }

    public void stop() {
        log.info("start shutdown server.");
        if (eurekaClient != null) {
            log.info("Shutting down server.");
            eurekaClient.shutdown();
        }
    }


    public static ApplicationInfoManager initializeApplicationInfoManager(EurekaInstanceConfig instanceConfig) {
        InstanceInfo instanceInfo = create(instanceConfig);
        return new ApplicationInfoManager(instanceConfig, instanceInfo);

    }

    public static EurekaClient initializeEurekaClient(ApplicationInfoManager applicationInfoManager,EurekaClientConfigBean clientConfig) {
        DiscoveryClient eurekaClient = new DiscoveryClient(applicationInfoManager, clientConfig);
        return eurekaClient;
    }


    private static InstanceInfo create(EurekaInstanceConfig config) {
        LeaseInfo.Builder leaseInfoBuilder = LeaseInfo.Builder.newBuilder()
                .setRenewalIntervalInSecs(config.getLeaseRenewalIntervalInSeconds())
                .setDurationInSecs(config.getLeaseExpirationDurationInSeconds());

        // Builder the instance information to be registered with eureka
        InstanceInfo.Builder builder = InstanceInfo.Builder.newBuilder();

        String namespace = config.getNamespace();
        if (!namespace.endsWith(".")) {
            namespace = namespace + ".";
        }
        builder.setNamespace(namespace).setAppName(config.getAppname())
                .setInstanceId(config.getInstanceId())
                .setAppGroupName(config.getAppGroupName())
                .setDataCenterInfo(config.getDataCenterInfo())
                .setIPAddr(config.getIpAddress()).setHostName(config.getHostName(false))
                .setPort(config.getNonSecurePort())
                .enablePort(InstanceInfo.PortType.UNSECURE,
                        config.isNonSecurePortEnabled())
                .setSecurePort(config.getSecurePort())
                .enablePort(InstanceInfo.PortType.SECURE, config.getSecurePortEnabled())
                .setVIPAddress(config.getVirtualHostName())
                .setSecureVIPAddress(config.getSecureVirtualHostName())
                .setHomePageUrl(config.getHomePageUrlPath(), config.getHomePageUrl())
                .setStatusPageUrl(config.getStatusPageUrlPath(),
                        config.getStatusPageUrl())
                .setHealthCheckUrls(config.getHealthCheckUrlPath(),
                        config.getHealthCheckUrl(), config.getSecureHealthCheckUrl())
                .setASGName(config.getASGName());

        // Add any user-specific metadata information
        for (Map.Entry<String, String> mapEntry : config.getMetadataMap().entrySet()) {
            String key = mapEntry.getKey();
            String value = mapEntry.getValue();
            builder.add(key, value);
        }

        InstanceInfo instanceInfo = builder.build();
        instanceInfo.setLeaseInfo(leaseInfoBuilder.build());
        return instanceInfo;
    }

}
