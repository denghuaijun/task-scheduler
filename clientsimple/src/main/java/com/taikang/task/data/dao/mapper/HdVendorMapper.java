package com.taikang.task.data.dao.mapper;

import com.taikang.task.data.dao.entity.HdVendor;
import com.taikang.task.data.dao.entity.HdVendorExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface HdVendorMapper {
    @SelectProvider(type=HdVendorSqlProvider.class, method="countByExample")
    long countByExample(HdVendorExample example);

    @DeleteProvider(type=HdVendorSqlProvider.class, method="deleteByExample")
    int deleteByExample(HdVendorExample example);

    @Delete({
        "delete from hd_vendor",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into hd_vendor (vendor_code, vendor_name, ",
        "vendor_person, vendor_phone, ",
        "vendor_status, creator_code, ",
        "created_time, modify_code, ",
        "modify_time)",
        "values (#{vendorCode,jdbcType=VARCHAR}, #{vendorName,jdbcType=VARCHAR}, ",
        "#{vendorPerson,jdbcType=VARCHAR}, #{vendorPhone,jdbcType=VARCHAR}, ",
        "#{vendorStatus,jdbcType=INTEGER}, #{creatorCode,jdbcType=VARCHAR}, ",
        "#{createdTime,jdbcType=TIMESTAMP}, #{modifyCode,jdbcType=VARCHAR}, ",
        "#{modifyTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(HdVendor record);

    @InsertProvider(type=HdVendorSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(HdVendor record);

    @SelectProvider(type=HdVendorSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="vendor_code", property="vendorCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="vendor_name", property="vendorName", jdbcType=JdbcType.VARCHAR),
        @Result(column="vendor_person", property="vendorPerson", jdbcType=JdbcType.VARCHAR),
        @Result(column="vendor_phone", property="vendorPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="vendor_status", property="vendorStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="creator_code", property="creatorCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_code", property="modifyCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<HdVendor> selectByExample(HdVendorExample example);

    @Select({
        "select",
        "id, vendor_code, vendor_name, vendor_person, vendor_phone, vendor_status, creator_code, ",
        "created_time, modify_code, modify_time",
        "from hd_vendor",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="vendor_code", property="vendorCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="vendor_name", property="vendorName", jdbcType=JdbcType.VARCHAR),
        @Result(column="vendor_person", property="vendorPerson", jdbcType=JdbcType.VARCHAR),
        @Result(column="vendor_phone", property="vendorPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="vendor_status", property="vendorStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="creator_code", property="creatorCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_code", property="modifyCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP)
    })
    HdVendor selectByPrimaryKey(Long id);

    @UpdateProvider(type=HdVendorSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") HdVendor record, @Param("example") HdVendorExample example);

    @UpdateProvider(type=HdVendorSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") HdVendor record, @Param("example") HdVendorExample example);

    @UpdateProvider(type=HdVendorSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(HdVendor record);

    @Update({
        "update hd_vendor",
        "set vendor_code = #{vendorCode,jdbcType=VARCHAR},",
          "vendor_name = #{vendorName,jdbcType=VARCHAR},",
          "vendor_person = #{vendorPerson,jdbcType=VARCHAR},",
          "vendor_phone = #{vendorPhone,jdbcType=VARCHAR},",
          "vendor_status = #{vendorStatus,jdbcType=INTEGER},",
          "creator_code = #{creatorCode,jdbcType=VARCHAR},",
          "created_time = #{createdTime,jdbcType=TIMESTAMP},",
          "modify_code = #{modifyCode,jdbcType=VARCHAR},",
          "modify_time = #{modifyTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(HdVendor record);
}