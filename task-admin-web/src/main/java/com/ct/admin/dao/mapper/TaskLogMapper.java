package com.ct.admin.dao.mapper;

import com.ct.admin.dao.entity.TaskLog;
import com.ct.admin.dao.entity.TaskLogExample;
import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface TaskLogMapper {
    @SelectProvider(type=TaskLogSqlProvider.class, method="countByExample")
    long countByExample(TaskLogExample example);

    @DeleteProvider(type=TaskLogSqlProvider.class, method="deleteByExample")
    int deleteByExample(TaskLogExample example);

    @Insert({
        "insert into task_log (fk_task_id, fk_task_runner_id, ",
        "runner_appkey, runner_appname, ",
        "runner_address, message, ",
        "code, create_time)",
        "values (#{fkTaskId,jdbcType=BIGINT}, #{fkTaskRunnerId,jdbcType=BIGINT}, ",
        "#{runnerAppkey,jdbcType=VARCHAR}, #{runnerAppname,jdbcType=VARCHAR}, ",
        "#{runnerAddress,jdbcType=VARCHAR}, #{message,jdbcType=VARCHAR}, ",
        "#{code,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(TaskLog record);

    @InsertProvider(type=TaskLogSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(TaskLog record);

    @SelectProvider(type=TaskLogSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT),
        @Result(column="fk_task_id", property="fkTaskId", jdbcType=JdbcType.BIGINT),
        @Result(column="fk_task_runner_id", property="fkTaskRunnerId", jdbcType=JdbcType.BIGINT),
        @Result(column="runner_appkey", property="runnerAppkey", jdbcType=JdbcType.VARCHAR),
        @Result(column="runner_appname", property="runnerAppname", jdbcType=JdbcType.VARCHAR),
        @Result(column="runner_address", property="runnerAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="message", property="message", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TaskLog> selectByExample(TaskLogExample example);

    @UpdateProvider(type=TaskLogSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TaskLog record, @Param("example") TaskLogExample example);

    @UpdateProvider(type=TaskLogSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TaskLog record, @Param("example") TaskLogExample example);
}