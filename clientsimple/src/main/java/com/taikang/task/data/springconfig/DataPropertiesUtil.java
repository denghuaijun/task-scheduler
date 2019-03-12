package com.taikang.task.data.springconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author xuliang
 * @time 2018/8/13
 * @description 理赔配置类
 */
@Component
@Data
@ConfigurationProperties(prefix = "data")
public class DataPropertiesUtil {

    private String pushUrl;

    private Long batchTenantId;

    private Long batchServiceId;

    private String flagChange;
}
