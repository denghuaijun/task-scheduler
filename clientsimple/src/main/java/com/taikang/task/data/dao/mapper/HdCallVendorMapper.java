package com.taikang.task.data.dao.mapper;

import com.taikang.task.data.dao.entity.HdCallVendor;
import com.taikang.task.data.dao.entity.HdCallVendorExample;
import com.taikang.task.data.dao.entity.HdCallVendorWithBLOBs;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface HdCallVendorMapper {
    @SelectProvider(type=HdCallVendorSqlProvider.class, method="countByExample")
    long countByExample(HdCallVendorExample example);

    @DeleteProvider(type=HdCallVendorSqlProvider.class, method="deleteByExample")
    int deleteByExample(HdCallVendorExample example);

    @Delete({
        "delete from hd_call_vendor",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into hd_call_vendor (tenant_id, service_id, ",
        "id_type, id_num, serial_no, ",
        "client_ip, server_ip, ",
        "falg_change, created_time, ",
        "expire_time, req_param, ",
        "health_data, ret_content)",
        "values (#{tenantId,jdbcType=BIGINT}, #{serviceId,jdbcType=BIGINT}, ",
        "#{idType,jdbcType=INTEGER}, #{idNum,jdbcType=VARCHAR}, #{serialNo,jdbcType=VARCHAR}, ",
        "#{clientIp,jdbcType=VARCHAR}, #{serverIp,jdbcType=VARCHAR}, ",
        "#{falgChange,jdbcType=INTEGER}, #{createdTime,jdbcType=TIMESTAMP}, ",
        "#{expireTime,jdbcType=TIMESTAMP}, #{reqParam,jdbcType=LONGVARCHAR}, ",
        "#{healthData,jdbcType=LONGVARCHAR}, #{retContent,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(HdCallVendorWithBLOBs record);

    @InsertProvider(type=HdCallVendorSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(HdCallVendorWithBLOBs record);

    @SelectProvider(type=HdCallVendorSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="tenant_id", property="tenantId", jdbcType=JdbcType.BIGINT),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.BIGINT),
        @Result(column="id_type", property="idType", jdbcType=JdbcType.INTEGER),
        @Result(column="id_num", property="idNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="serial_no", property="serialNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="client_ip", property="clientIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="server_ip", property="serverIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="falg_change", property="falgChange", jdbcType=JdbcType.INTEGER),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="expire_time", property="expireTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="req_param", property="reqParam", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="health_data", property="healthData", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="ret_content", property="retContent", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<HdCallVendorWithBLOBs> selectByExampleWithBLOBs(HdCallVendorExample example);

    @SelectProvider(type=HdCallVendorSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="tenant_id", property="tenantId", jdbcType=JdbcType.BIGINT),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.BIGINT),
        @Result(column="id_type", property="idType", jdbcType=JdbcType.INTEGER),
        @Result(column="id_num", property="idNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="serial_no", property="serialNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="client_ip", property="clientIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="server_ip", property="serverIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="falg_change", property="falgChange", jdbcType=JdbcType.INTEGER),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="expire_time", property="expireTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<HdCallVendor> selectByExample(HdCallVendorExample example);

    @Select({
        "select",
        "id, tenant_id, service_id, id_type, id_num, serial_no, client_ip, server_ip, ",
        "falg_change, created_time, expire_time, req_param, health_data, ret_content",
        "from hd_call_vendor",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="tenant_id", property="tenantId", jdbcType=JdbcType.BIGINT),
        @Result(column="service_id", property="serviceId", jdbcType=JdbcType.BIGINT),
        @Result(column="id_type", property="idType", jdbcType=JdbcType.INTEGER),
        @Result(column="id_num", property="idNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="serial_no", property="serialNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="client_ip", property="clientIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="server_ip", property="serverIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="falg_change", property="falgChange", jdbcType=JdbcType.INTEGER),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="expire_time", property="expireTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="req_param", property="reqParam", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="health_data", property="healthData", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="ret_content", property="retContent", jdbcType=JdbcType.LONGVARCHAR)
    })
    HdCallVendorWithBLOBs selectByPrimaryKey(Long id);

    @UpdateProvider(type=HdCallVendorSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") HdCallVendorWithBLOBs record, @Param("example") HdCallVendorExample example);

    @UpdateProvider(type=HdCallVendorSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") HdCallVendorWithBLOBs record, @Param("example") HdCallVendorExample example);

    @UpdateProvider(type=HdCallVendorSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") HdCallVendor record, @Param("example") HdCallVendorExample example);

    @UpdateProvider(type=HdCallVendorSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(HdCallVendorWithBLOBs record);

    @Update({
        "update hd_call_vendor",
        "set tenant_id = #{tenantId,jdbcType=BIGINT},",
          "service_id = #{serviceId,jdbcType=BIGINT},",
          "id_type = #{idType,jdbcType=INTEGER},",
          "id_num = #{idNum,jdbcType=VARCHAR},",
          "serial_no = #{serialNo,jdbcType=VARCHAR},",
          "client_ip = #{clientIp,jdbcType=VARCHAR},",
          "server_ip = #{serverIp,jdbcType=VARCHAR},",
          "falg_change = #{falgChange,jdbcType=INTEGER},",
          "created_time = #{createdTime,jdbcType=TIMESTAMP},",
          "expire_time = #{expireTime,jdbcType=TIMESTAMP},",
          "req_param = #{reqParam,jdbcType=LONGVARCHAR},",
          "health_data = #{healthData,jdbcType=LONGVARCHAR},",
          "ret_content = #{retContent,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(HdCallVendorWithBLOBs record);

    @Update({
        "update hd_call_vendor",
        "set tenant_id = #{tenantId,jdbcType=BIGINT},",
          "service_id = #{serviceId,jdbcType=BIGINT},",
          "id_type = #{idType,jdbcType=INTEGER},",
          "id_num = #{idNum,jdbcType=VARCHAR},",
          "serial_no = #{serialNo,jdbcType=VARCHAR},",
          "client_ip = #{clientIp,jdbcType=VARCHAR},",
          "server_ip = #{serverIp,jdbcType=VARCHAR},",
          "falg_change = #{falgChange,jdbcType=INTEGER},",
          "created_time = #{createdTime,jdbcType=TIMESTAMP},",
          "expire_time = #{expireTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(HdCallVendor record);
}