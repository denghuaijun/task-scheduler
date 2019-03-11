package com.taikang.task.data.dao.extension.mapper;

import com.taikang.task.data.dao.extension.entity.HdQueryCallCountDTO;
import org.apache.ibatis.annotations.SelectProvider;

public interface HdQueryCallVendorMapper {

    /**
     * 根据接口编码及相关条件查询当前供应商的调用次数
     * @param callCountDTO
     * @return
     */
    @SelectProvider(type = HdQueryCallVendorSqlProvider.class,method = "countByCallCount")
    public long countByCallCountDto(HdQueryCallCountDTO callCountDTO);
}
