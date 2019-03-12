package com.taikang.task.data.service.api;

import com.taikang.task.data.dao.mapper.HdCallTenantMapper;
import com.taikang.task.data.service.PushContractDataService;
import com.taikang.task.data.springconfig.DataPropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试调式接口
 */
@RestController
public class TestController {

    @Autowired
    private DataPropertiesUtil dataPropertiesUtil;

    @Autowired
    private HdCallTenantMapper hdCallTenantMapper;

    @Autowired
    private PushContractDataService pushContractDataService;

    @RequestMapping("/get")
    public String test(){
        System.out.println(dataPropertiesUtil.getPushUrl());
//        HdCallTenantExample example = new HdCallTenantExample();
//        example.createCriteria().andTenantIdEqualTo(1L);
//        List<HdCallTenant> hdCallTenants = hdCallTenantMapper.selectByExample(example);
//        System.out.println("hdCallTenants:"+hdCallTenants.toString());
        pushContractDataService.pushData();
        return "success";
    }
}
