package com.taikang.task.data.dao.mapper;

import com.taikang.task.data.dao.entity.HdCallTenant;
import com.taikang.task.data.dao.entity.HdCallTenantExample;
import com.taikang.task.data.dao.entity.HdCallTenantWithBLOBs;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface HdCallTenantMapper {
    @SelectProvider(type=HdCallTenantSqlProvider.class, method="countByExample")
    long countByExample(HdCallTenantExample example);

    @DeleteProvider(type=HdCallTenantSqlProvider.class, method="deleteByExample")
    int deleteByExample(HdCallTenantExample example);

    @Delete({
        "delete from hd_call_tenant",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into hd_call_tenant (serial_no, server_ip, ",
        "service_id, tenant_id, ",
        "client_ip, created_time, ",
        "id_type, id_num, req_param, ",
        "ret_content)",
        "values (#{serialNo,jdbcType=VARCHAR}, #{serverIp,jdbcType=VARCHAR}, ",
        "#{serviceId,jdbcType=BIGINT}, #{tenantId,jdbcType=BIGINT}, ",
        "#{clientIp,jdbcType=VARCHAR}, #{createdTime,jdbcType=TIMESTAMP}, ",
        "#{idType,jdbcType=INTEGER}, #{idNum,jdbcType=VARCHAR}, #{reqParam,jdbcType=LONGVARCHAR}, ",
        "#{retContent,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(HdCallTenantWithBLOBs record);

    @InsertProvider(type=HdCallTenantSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(HdCallTenantWithBLOBs record);

    @SelectProvider(type=HdCallTenantSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="serial_no", property="serialNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="server_ip", property="serverIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.BIGINT),
        @Result(column="tenant_id", property="tenantId", jdbcType=JdbcType.BIGINT),
        @Result(column="client_ip", property="clientIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="id_type", property="idType", jdbcType=JdbcType.INTEGER),
        @Result(column="id_num", property="idNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="req_param", property="reqParam", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="ret_content", property="retContent", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<HdCallTenantWithBLOBs> selectByExampleWithBLOBs(HdCallTenantExample example);

    @SelectProvider(type=HdCallTenantSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="serial_no", property="serialNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="server_ip", property="serverIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.BIGINT),
        @Result(column="tenant_id", property="tenantId", jdbcType=JdbcType.BIGINT),
        @Result(column="client_ip", property="clientIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="id_type", property="idType", jdbcType=JdbcType.INTEGER),
        @Result(column="id_num", property="idNum", jdbcType=JdbcType.VARCHAR)
    })
    List<HdCallTenant> selectByExample(HdCallTenantExample example);

    @Select({
        "select",
        "id, serial_no, server_ip, service_id, tenant_id, client_ip, created_time, id_type, ",
        "id_num, req_param, ret_content",
        "from hd_call_tenant",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="serial_no", property="serialNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="server_ip", property="serverIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.BIGINT),
        @Result(column="tenant_id", property="tenantId", jdbcType=JdbcType.BIGINT),
        @Result(column="client_ip", property="clientIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="id_type", property="idType", jdbcType=JdbcType.INTEGER),
        @Result(column="id_num", property="idNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="req_param", property="reqParam", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="ret_content", property="retContent", jdbcType=JdbcType.LONGVARCHAR)
    })
    HdCallTenantWithBLOBs selectByPrimaryKey(Long id);

    @UpdateProvider(type=HdCallTenantSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") HdCallTenantWithBLOBs record, @Param("example") HdCallTenantExample example);

    @UpdateProvider(type=HdCallTenantSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") HdCallTenantWithBLOBs record, @Param("example") HdCallTenantExample example);

    @UpdateProvider(type=HdCallTenantSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") HdCallTenant record, @Param("example") HdCallTenantExample example);

    @UpdateProvider(type=HdCallTenantSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(HdCallTenantWithBLOBs record);

    @Update({
        "update hd_call_tenant",
        "set serial_no = #{serialNo,jdbcType=VARCHAR},",
          "server_ip = #{serverIp,jdbcType=VARCHAR},",
          "service_id = #{serviceId,jdbcType=BIGINT},",
          "tenant_id = #{tenantId,jdbcType=BIGINT},",
          "client_ip = #{clientIp,jdbcType=VARCHAR},",
          "created_time = #{createdTime,jdbcType=TIMESTAMP},",
          "id_type = #{idType,jdbcType=INTEGER},",
          "id_num = #{idNum,jdbcType=VARCHAR},",
          "req_param = #{reqParam,jdbcType=LONGVARCHAR},",
          "ret_content = #{retContent,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(HdCallTenantWithBLOBs record);

    @Update({
        "update hd_call_tenant",
        "set serial_no = #{serialNo,jdbcType=VARCHAR},",
          "server_ip = #{serverIp,jdbcType=VARCHAR},",
          "service_id = #{serviceId,jdbcType=BIGINT},",
          "tenant_id = #{tenantId,jdbcType=BIGINT},",
          "client_ip = #{clientIp,jdbcType=VARCHAR},",
          "created_time = #{createdTime,jdbcType=TIMESTAMP},",
          "id_type = #{idType,jdbcType=INTEGER},",
          "id_num = #{idNum,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(HdCallTenant record);
}