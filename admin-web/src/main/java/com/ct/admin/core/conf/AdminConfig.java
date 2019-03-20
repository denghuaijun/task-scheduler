package com.ct.admin.core.conf;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * xxl-job config
 *
 * @author xuxueli 2017-04-28
 */
@Data
@Configuration
public class AdminConfig implements InitializingBean {

    private static AdminConfig adminConfig = null;
    public static AdminConfig getAdminConfig() {
        return adminConfig;
    }
    // conf


    @Value("${task.job.login.username}")
    private String loginUsername;

    @Value("${task.job.login.password}")
    private String loginPassword;



    @Override
    public void afterPropertiesSet() throws Exception {
       adminConfig=this;
    }
}
