package com.ct.admin.dao.mapper;

import com.ct.admin.dao.entity.TaskRunnerRegistry;
import com.ct.admin.dao.entity.TaskRunnerRegistryExample;
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

public interface TaskRunnerRegistryMapper {
    @SelectProvider(type=TaskRunnerRegistrySqlProvider.class, method="countByExample")
    long countByExample(TaskRunnerRegistryExample example);

    @DeleteProvider(type=TaskRunnerRegistrySqlProvider.class, method="deleteByExample")
    int deleteByExample(TaskRunnerRegistryExample example);

    @Delete({
        "delete from task_runner_registry",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into task_runner_registry (task_runner_appkey, task_runner_address, ",
        "push_time)",
        "values (#{taskRunnerAppkey,jdbcType=VARCHAR}, #{taskRunnerAddress,jdbcType=VARCHAR}, ",
        "#{pushTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(TaskRunnerRegistry record);

    @InsertProvider(type=TaskRunnerRegistrySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(TaskRunnerRegistry record);

    @SelectProvider(type=TaskRunnerRegistrySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="task_runner_appkey", property="taskRunnerAppkey", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_runner_address", property="taskRunnerAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="push_time", property="pushTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TaskRunnerRegistry> selectByExample(TaskRunnerRegistryExample example);

    @Select({
        "select",
        "id, task_runner_appkey, task_runner_address, push_time",
        "from task_runner_registry",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="task_runner_appkey", property="taskRunnerAppkey", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_runner_address", property="taskRunnerAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="push_time", property="pushTime", jdbcType=JdbcType.TIMESTAMP)
    })
    TaskRunnerRegistry selectByPrimaryKey(Long id);

    @UpdateProvider(type=TaskRunnerRegistrySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TaskRunnerRegistry record, @Param("example") TaskRunnerRegistryExample example);

    @UpdateProvider(type=TaskRunnerRegistrySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TaskRunnerRegistry record, @Param("example") TaskRunnerRegistryExample example);

    @UpdateProvider(type=TaskRunnerRegistrySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TaskRunnerRegistry record);

    @Update({
        "update task_runner_registry",
        "set task_runner_appkey = #{taskRunnerAppkey,jdbcType=VARCHAR},",
          "task_runner_address = #{taskRunnerAddress,jdbcType=VARCHAR},",
          "push_time = #{pushTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TaskRunnerRegistry record);
}