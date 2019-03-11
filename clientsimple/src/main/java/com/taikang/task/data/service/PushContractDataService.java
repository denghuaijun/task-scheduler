package com.taikang.task.data.service;

import com.taikang.task.data.dao.mapper.HdCallTenantMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * 合同到期及调用次数调度业务实现类
 * @author itw_denghj
 * @时间 2019/3/11
 */
@Slf4j
@Service
public class PushContractDataService {

    @Autowired
    private HdCallTenantMapper hdCallTenantMapper;

    @Transactional
    public void pushData(){
        try{
            log.info("PushContractDataService.pushData start!");

            log.info("PushContractDataService.pushData end!");
        }catch (Exception e){
            log.info("PushContractDataService.pushData Exception:{}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }

}
