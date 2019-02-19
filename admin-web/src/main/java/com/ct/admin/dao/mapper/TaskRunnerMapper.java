package com.ct.admin.dao.mapper;

import com.ct.admin.dao.entity.TaskRunner;
import com.ct.admin.dao.entity.TaskRunnerExample;
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

public interface TaskRunnerMapper {
    @SelectProvider(type=TaskRunnerSqlProvider.class, method="countByExample")
    long countByExample(TaskRunnerExample example);

    @DeleteProvider(type=TaskRunnerSqlProvider.class, method="deleteByExample")
    int deleteByExample(TaskRunnerExample example);

    @Delete({
        "delete from task_runner",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into task_runner (task_runner_name, task_runner_appkey, ",
        "task_runner_appname, task_runner_address, ",
        "status, active, ",
        "creator_id, create_at)",
        "values (#{taskRunnerName,jdbcType=VARCHAR}, #{taskRunnerAppkey,jdbcType=VARCHAR}, ",
        "#{taskRunnerAppname,jdbcType=VARCHAR}, #{taskRunnerAddress,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER}, #{active,jdbcType=SMALLINT}, ",
        "#{creatorId,jdbcType=BIGINT}, #{createAt,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(TaskRunner record);

    @InsertProvider(type=TaskRunnerSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(TaskRunner record);

    @SelectProvider(type=TaskRunnerSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="task_runner_name", property="taskRunnerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_runner_appkey", property="taskRunnerAppkey", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_runner_appname", property="taskRunnerAppname", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_runner_address", property="taskRunnerAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="active", property="active", jdbcType=JdbcType.SMALLINT),
        @Result(column="creator_id", property="creatorId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_at", property="createAt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TaskRunner> selectByExample(TaskRunnerExample example);

    @Select({
        "select",
        "id, task_runner_name, task_runner_appkey, task_runner_appname, task_runner_address, ",
        "status, active, creator_id, create_at",
        "from task_runner",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="task_runner_name", property="taskRunnerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_runner_appkey", property="taskRunnerAppkey", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_runner_appname", property="taskRunnerAppname", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_runner_address", property="taskRunnerAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="active", property="active", jdbcType=JdbcType.SMALLINT),
        @Result(column="creator_id", property="creatorId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_at", property="createAt", jdbcType=JdbcType.TIMESTAMP)
    })
    TaskRunner selectByPrimaryKey(Long id);

    @UpdateProvider(type=TaskRunnerSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TaskRunner record, @Param("example") TaskRunnerExample example);

    @UpdateProvider(type=TaskRunnerSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TaskRunner record, @Param("example") TaskRunnerExample example);

    @UpdateProvider(type=TaskRunnerSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TaskRunner record);

    @Update({
        "update task_runner",
        "set task_runner_name = #{taskRunnerName,jdbcType=VARCHAR},",
          "task_runner_appkey = #{taskRunnerAppkey,jdbcType=VARCHAR},",
          "task_runner_appname = #{taskRunnerAppname,jdbcType=VARCHAR},",
          "task_runner_address = #{taskRunnerAddress,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "active = #{active,jdbcType=SMALLINT},",
          "creator_id = #{creatorId,jdbcType=BIGINT},",
          "create_at = #{createAt,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TaskRunner record);
}