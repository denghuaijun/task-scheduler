package com.taikang.task.data.service.api;

import com.taikang.task.data.dao.entity.HdCallTenant;
import com.taikang.task.data.dao.entity.HdCallTenantExample;
import com.taikang.task.data.dao.mapper.HdCallTenantMapper;
import com.taikang.task.data.springconfig.DataPropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 测试调式接口
 */
@RestController
public class TestController {

    @Autowired
    private DataPropertiesUtil dataPropertiesUtil;

    @Autowired
    private HdCallTenantMapper hdCallTenantMapper;

    @RequestMapping("/get")
    public String test(){
        System.out.println(dataPropertiesUtil.getPushUrl());
        HdCallTenantExample example = new HdCallTenantExample();
        example.createCriteria().andTenantIdEqualTo(1L);
        List<HdCallTenant> hdCallTenants = hdCallTenantMapper.selectByExample(example);
        System.out.println("hdCallTenants:"+hdCallTenants.toString());
        return "success";
    }
}
