package com.ct.core.runner.eureka;

import com.netflix.discovery.DefaultEurekaClientConfig;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Data
public class EurekaClientConfigBean extends DefaultEurekaClientConfig {

    private String[] serviceUrls;

    @Override
    public List<String> getEurekaServerServiceUrls(String myZone) {

        if (serviceUrls != null) {
            return Arrays.asList(serviceUrls);
        }

        return new ArrayList<String>();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder{

        private String[] serviceUrls;

        public Builder serviceUrls(String[] serviceUrls) {
            this.serviceUrls = serviceUrls;
            return this;
        }

        public EurekaClientConfigBean build() {
            EurekaClientConfigBean eurekaClientConfigBean = new EurekaClientConfigBean();
            eurekaClientConfigBean.setServiceUrls(serviceUrls);
            return eurekaClientConfigBean;
        }
    }
}
