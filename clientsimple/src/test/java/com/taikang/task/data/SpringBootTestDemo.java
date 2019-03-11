package com.taikang.task.data;


import com.taikang.task.data.springconfig.DataPropertiesUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

/**
 * SpringBoot 单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootConfiguration
@WebAppConfiguration
@Slf4j
public class SpringBootTestDemo {

    @Resource
    private DataPropertiesUtil dataPropertiesUtil;

    @Test
    public  void  test(){
        log.info("单元测试开始");
      log.info(dataPropertiesUtil.getPushUrl());
    }
}
