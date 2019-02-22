package com.ct.admin.dao.mapper;

import com.ct.admin.dao.entity.TaskInterfaceLog;
import com.ct.admin.dao.entity.TaskInterfaceLogExample;
import com.ct.admin.dao.entity.TaskInterfaceLogWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface TaskInterfaceLogMapper {
    @SelectProvider(type=TaskInterfaceLogSqlProvider.class, method="countByExample")
    long countByExample(TaskInterfaceLogExample example);

    @DeleteProvider(type=TaskInterfaceLogSqlProvider.class, method="deleteByExample")
    int deleteByExample(TaskInterfaceLogExample example);

    @Delete({
        "delete from task_interface_log",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into task_interface_log (task_request_path, task_request_time, ",
        "task_reponse_time, task_session_id, ",
        "task_client_ip, task_request_method, ",
        "task_request_type, task_reponse_code, ",
        "create_time, remark, ",
        "task_request_param, task_reponse_param)",
        "values (#{taskRequestPath,jdbcType=VARCHAR}, #{taskRequestTime,jdbcType=TIMESTAMP}, ",
        "#{taskReponseTime,jdbcType=TIMESTAMP}, #{taskSessionId,jdbcType=VARCHAR}, ",
        "#{taskClientIp,jdbcType=VARCHAR}, #{taskRequestMethod,jdbcType=VARCHAR}, ",
        "#{taskRequestType,jdbcType=VARCHAR}, #{taskReponseCode,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{remark,jdbcType=VARCHAR}, ",
        "#{taskRequestParam,jdbcType=LONGVARCHAR}, #{taskReponseParam,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(TaskInterfaceLogWithBLOBs record);

    @InsertProvider(type=TaskInterfaceLogSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(TaskInterfaceLogWithBLOBs record);

    @SelectProvider(type=TaskInterfaceLogSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="task_request_path", property="taskRequestPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_request_time", property="taskRequestTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="task_reponse_time", property="taskReponseTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="task_session_id", property="taskSessionId", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_client_ip", property="taskClientIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_request_method", property="taskRequestMethod", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_request_type", property="taskRequestType", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_reponse_code", property="taskReponseCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_request_param", property="taskRequestParam", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="task_reponse_param", property="taskReponseParam", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<TaskInterfaceLogWithBLOBs> selectByExampleWithBLOBs(TaskInterfaceLogExample example);

    @SelectProvider(type=TaskInterfaceLogSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="task_request_path", property="taskRequestPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_request_time", property="taskRequestTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="task_reponse_time", property="taskReponseTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="task_session_id", property="taskSessionId", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_client_ip", property="taskClientIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_request_method", property="taskRequestMethod", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_request_type", property="taskRequestType", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_reponse_code", property="taskReponseCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    List<TaskInterfaceLog> selectByExample(TaskInterfaceLogExample example);

    @Select({
        "select",
        "id, task_request_path, task_request_time, task_reponse_time, task_session_id, ",
        "task_client_ip, task_request_method, task_request_type, task_reponse_code, create_time, ",
        "remark, task_request_param, task_reponse_param",
        "from task_interface_log",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="task_request_path", property="taskRequestPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_request_time", property="taskRequestTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="task_reponse_time", property="taskReponseTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="task_session_id", property="taskSessionId", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_client_ip", property="taskClientIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_request_method", property="taskRequestMethod", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_request_type", property="taskRequestType", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_reponse_code", property="taskReponseCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_request_param", property="taskRequestParam", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="task_reponse_param", property="taskReponseParam", jdbcType=JdbcType.LONGVARCHAR)
    })
    TaskInterfaceLogWithBLOBs selectByPrimaryKey(Long id);

    @UpdateProvider(type=TaskInterfaceLogSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TaskInterfaceLogWithBLOBs record, @Param("example") TaskInterfaceLogExample example);

    @UpdateProvider(type=TaskInterfaceLogSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") TaskInterfaceLogWithBLOBs record, @Param("example") TaskInterfaceLogExample example);

    @UpdateProvider(type=TaskInterfaceLogSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TaskInterfaceLog record, @Param("example") TaskInterfaceLogExample example);

    @UpdateProvider(type=TaskInterfaceLogSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TaskInterfaceLogWithBLOBs record);

    @Update({
        "update task_interface_log",
        "set task_request_path = #{taskRequestPath,jdbcType=VARCHAR},",
          "task_request_time = #{taskRequestTime,jdbcType=TIMESTAMP},",
          "task_reponse_time = #{taskReponseTime,jdbcType=TIMESTAMP},",
          "task_session_id = #{taskSessionId,jdbcType=VARCHAR},",
          "task_client_ip = #{taskClientIp,jdbcType=VARCHAR},",
          "task_request_method = #{taskRequestMethod,jdbcType=VARCHAR},",
          "task_request_type = #{taskRequestType,jdbcType=VARCHAR},",
          "task_reponse_code = #{taskReponseCode,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "task_request_param = #{taskRequestParam,jdbcType=LONGVARCHAR},",
          "task_reponse_param = #{taskReponseParam,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(TaskInterfaceLogWithBLOBs record);

    @Update({
        "update task_interface_log",
        "set task_request_path = #{taskRequestPath,jdbcType=VARCHAR},",
          "task_request_time = #{taskRequestTime,jdbcType=TIMESTAMP},",
          "task_reponse_time = #{taskReponseTime,jdbcType=TIMESTAMP},",
          "task_session_id = #{taskSessionId,jdbcType=VARCHAR},",
          "task_client_ip = #{taskClientIp,jdbcType=VARCHAR},",
          "task_request_method = #{taskRequestMethod,jdbcType=VARCHAR},",
          "task_request_type = #{taskRequestType,jdbcType=VARCHAR},",
          "task_reponse_code = #{taskReponseCode,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "remark = #{remark,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TaskInterfaceLog record);
}