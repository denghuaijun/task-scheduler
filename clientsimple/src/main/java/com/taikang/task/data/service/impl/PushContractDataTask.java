package com.taikang.task.data.service.impl;

import com.ct.core.annotation.Runner;
import com.ct.core.client.RunnerInvokerDef;
import com.ct.core.model.ReturnDTO;
import com.taikang.task.data.service.PushContractDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 合同数据及调用次数统计任务类
 * @author itw_denghj
 * @时间 2019/3/11
 */
@Slf4j
@Runner(appname = "contractdata")
public class PushContractDataTask implements RunnerInvokerDef {
    @Autowired
    private PushContractDataService pushContractDataService;

    @Override
    public ReturnDTO<String> run() {
        log.info("PushContractDataTask-------Task.startTime:{}",System.currentTimeMillis());
        pushContractDataService.pushData();
        log.info("PushContractDataTask-------End.startTime:{}",System.currentTimeMillis());
        return null;
    }
}
