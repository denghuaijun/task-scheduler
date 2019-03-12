package com.taikang.task.data.service;

import com.ct.core.utils.HttpUtil;
import com.taikang.task.data.dao.extension.entity.HdQueryCallCountDTO;
import com.taikang.task.data.dao.extension.mapper.HdQueryCallVendorMapper;
import com.taikang.task.data.dao.mapper.HdCallTenantMapper;
import com.taikang.task.data.springconfig.DataPropertiesUtil;
import com.taikang.task.data.util.enums.ContractCodeEnum;
import com.taikang.task.data.util.enums.VendorServiceContractCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private DataPropertiesUtil dataPropertiesUtil;

    @Autowired
    private HdQueryCallVendorMapper hdQueryCallVendorMapper;

    @Transactional
    public void pushData(){
        try{
            JSONObject jsonObject = new JSONObject();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            log.info("PushContractDataService.pushData start!");
            Date dateNow = new Date();
            //1、查询所有社保数据租户调用总数
//            HdCallTenantExample tenantExample = new HdCallTenantExample();
//            tenantExample.createCriteria().andServiceIdEqualTo(1L).andCreatedTimeLessThanOrEqualTo(new Date());
//            long callTotal = hdCallTenantMapper.countByExample(tenantExample);
//            log.info("查询出距当前时间:{},所有调用总数callTotal:{}",new Date(),callTotal);
            //获取租户调用表所有社保数据的总数，即为各供应商对应的调用总数
            Date lastDate = DateUtils.addDays(new Date(),-7);//上个周期时间
//            HdCallTenantExample tenantExample2 = new HdCallTenantExample();
//            tenantExample2.createCriteria().andServiceIdEqualTo(1L).andCreatedTimeBetween(lastDate,dateNow);
//            long incrementCount = hdCallTenantMapper.countByExample(tenantExample2);
//            log.info("查询上周时间:{},incrementCount:{}",lastDate,incrementCount);
             //查询批量插入数据量
            for (ContractCodeEnum contractCodeEnum : ContractCodeEnum.values()){
                long batchCount=0;
                long batchIncrementNum=0;
                HdQueryCallCountDTO dto = new HdQueryCallCountDTO();
                String contractCode = contractCodeEnum.getCode();
                String contractName = ContractCodeEnum.getContractNameByCode(contractCode);
                List<String> serviceCodeList = VendorServiceContractCodeEnum.getServiceCodeByContractCode(contractCode);
                dto.setFlagChange(dataPropertiesUtil.getFlagChange());
                dto.setServiceTypeId(dataPropertiesUtil.getBatchServiceId());
                dto.setCurrentTime(format.format(dateNow));
                for (String serviceCode : serviceCodeList){
                    dto.setServiceCode(serviceCode);
                    log.info("查询对应供应商接口serviceCode:{}", serviceCode);
                    batchCount += hdQueryCallVendorMapper.countByCallCountDto(dto);
                    dto.setLastWeekTime(format.format(lastDate));
                    batchIncrementNum +=hdQueryCallVendorMapper.countByCallCountDto(dto);
                }
               //组织推送的数据
                jsonObject.put("code",contractCode);
                jsonObject.put("name",contractName);
                jsonObject.put("countTotal",(batchCount));
                jsonObject.put("countIncrement",(batchIncrementNum));
                jsonObject.put("syncDate",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                log.info("合同厂商：{}推送数据开始，请求入参：{}",contractName,jsonObject.toString());
                new HttpUtil().post(jsonObject.toString(),dataPropertiesUtil.getPushUrl());
            }
            log.info("PushContractDataService.pushData end!");
        }catch (Exception e){
            log.info("PushContractDataService.pushData Exception:{}",e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }

    public static void main(String[] args) {
        log.info("VendorServiceContractCodeEnum.length:"+VendorServiceContractCodeEnum.values().length);
        for (VendorServiceContractCodeEnum serviceContractCodeEnum : VendorServiceContractCodeEnum.values()){
            System.out.println(serviceContractCodeEnum.getServiceCode());
        }
        long a = 200;
        long b = 300;
        log.info("total=:"+(a+b));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        Date dateBefore = new Date();
        System.out.println(format.format(now));
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//        calendar.add(Calendar.DAY_OF_MONTH,-6);
//        dateBefore = calendar.getTime();
        Date addDays = DateUtils.addDays(now, -7);
        System.out.println(format.format(addDays));

        List serviceCode = VendorServiceContractCodeEnum.getServiceCodeByContractCode("hd1");
        System.out.println(serviceCode);
    }

}
