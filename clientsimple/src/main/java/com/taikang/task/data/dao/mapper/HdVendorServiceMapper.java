package com.taikang.task.data.dao.mapper;

import com.taikang.task.data.dao.entity.HdVendorService;
import com.taikang.task.data.dao.entity.HdVendorServiceExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface HdVendorServiceMapper {
    @SelectProvider(type=HdVendorServiceSqlProvider.class, method="countByExample")
    long countByExample(HdVendorServiceExample example);

    @DeleteProvider(type=HdVendorServiceSqlProvider.class, method="deleteByExample")
    int deleteByExample(HdVendorServiceExample example);

    @Delete({
        "delete from hd_vendor_service",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into hd_vendor_service (vendor_id, service_code, ",
        "authorize_msg, service_url, ",
        "interval, service_type_id, ",
        "service_desc, service_status, ",
        "level, service_link, ",
        "service_phone, creator_code, ",
        "created_time, modify_code, ",
        "modify_time)",
        "values (#{vendorId,jdbcType=VARCHAR}, #{serviceCode,jdbcType=VARCHAR}, ",
        "#{authorizeMsg,jdbcType=VARCHAR}, #{serviceUrl,jdbcType=VARCHAR}, ",
        "#{interval,jdbcType=INTEGER}, #{serviceTypeId,jdbcType=BIGINT}, ",
        "#{serviceDesc,jdbcType=VARCHAR}, #{serviceStatus,jdbcType=INTEGER}, ",
        "#{level,jdbcType=INTEGER}, #{serviceLink,jdbcType=VARCHAR}, ",
        "#{servicePhone,jdbcType=VARCHAR}, #{creatorCode,jdbcType=VARCHAR}, ",
        "#{createdTime,jdbcType=TIMESTAMP}, #{modifyCode,jdbcType=VARCHAR}, ",
        "#{modifyTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(HdVendorService record);

    @InsertProvider(type=HdVendorServiceSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(HdVendorService record);

    @SelectProvider(type=HdVendorServiceSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="vendor_id", property="vendorId", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_code", property="serviceCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="authorize_msg", property="authorizeMsg", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_url", property="serviceUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="interval", property="interval", jdbcType=JdbcType.INTEGER),
        @Result(column="service_type_id", property="serviceTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="service_desc", property="serviceDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_status", property="serviceStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="service_link", property="serviceLink", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_phone", property="servicePhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="creator_code", property="creatorCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_code", property="modifyCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<HdVendorService> selectByExample(HdVendorServiceExample example);

    @Select({
        "select",
        "id, vendor_id, service_code, authorize_msg, service_url, interval, service_type_id, ",
        "service_desc, service_status, level, service_link, service_phone, creator_code, ",
        "created_time, modify_code, modify_time",
        "from hd_vendor_service",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="vendor_id", property="vendorId", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_code", property="serviceCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="authorize_msg", property="authorizeMsg", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_url", property="serviceUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="interval", property="interval", jdbcType=JdbcType.INTEGER),
        @Result(column="service_type_id", property="serviceTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="service_desc", property="serviceDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_status", property="serviceStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="service_link", property="serviceLink", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_phone", property="servicePhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="creator_code", property="creatorCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_code", property="modifyCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP)
    })
    HdVendorService selectByPrimaryKey(Long id);

    @UpdateProvider(type=HdVendorServiceSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") HdVendorService record, @Param("example") HdVendorServiceExample example);

    @UpdateProvider(type=HdVendorServiceSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") HdVendorService record, @Param("example") HdVendorServiceExample example);

    @UpdateProvider(type=HdVendorServiceSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(HdVendorService record);

    @Update({
        "update hd_vendor_service",
        "set vendor_id = #{vendorId,jdbcType=VARCHAR},",
          "service_code = #{serviceCode,jdbcType=VARCHAR},",
          "authorize_msg = #{authorizeMsg,jdbcType=VARCHAR},",
          "service_url = #{serviceUrl,jdbcType=VARCHAR},",
          "interval = #{interval,jdbcType=INTEGER},",
          "service_type_id = #{serviceTypeId,jdbcType=BIGINT},",
          "service_desc = #{serviceDesc,jdbcType=VARCHAR},",
          "service_status = #{serviceStatus,jdbcType=INTEGER},",
          "level = #{level,jdbcType=INTEGER},",
          "service_link = #{serviceLink,jdbcType=VARCHAR},",
          "service_phone = #{servicePhone,jdbcType=VARCHAR},",
          "creator_code = #{creatorCode,jdbcType=VARCHAR},",
          "created_time = #{createdTime,jdbcType=TIMESTAMP},",
          "modify_code = #{modifyCode,jdbcType=VARCHAR},",
          "modify_time = #{modifyTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(HdVendorService record);
}