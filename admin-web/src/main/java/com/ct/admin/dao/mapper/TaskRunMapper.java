package com.ct.admin.dao.mapper;

import com.ct.admin.dao.entity.TaskRun;
import com.ct.admin.dao.entity.TaskRunExample;
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

public interface TaskRunMapper {
    @SelectProvider(type=TaskRunSqlProvider.class, method="countByExample")
    long countByExample(TaskRunExample example);

    @DeleteProvider(type=TaskRunSqlProvider.class, method="deleteByExample")
    int deleteByExample(TaskRunExample example);

    @Delete({
        "delete from task_run",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into task_run (task_run_name, task_run_appkey, ",
        "task_run_address, status, ",
        "active, creator_id, ",
        "create_at)",
        "values (#{taskRunName,jdbcType=VARCHAR}, #{taskRunAppkey,jdbcType=VARCHAR}, ",
        "#{taskRunAddress,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, ",
        "#{active,jdbcType=SMALLINT}, #{creatorId,jdbcType=BIGINT}, ",
        "#{createAt,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(TaskRun record);

    @InsertProvider(type=TaskRunSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(TaskRun record);

    @SelectProvider(type=TaskRunSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="task_run_name", property="taskRunName", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_run_appkey", property="taskRunAppkey", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_run_address", property="taskRunAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="active", property="active", jdbcType=JdbcType.SMALLINT),
        @Result(column="creator_id", property="creatorId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_at", property="createAt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TaskRun> selectByExample(TaskRunExample example);

    @Select({
        "select",
        "id, task_run_name, task_run_appkey, task_run_address, status, active, creator_id, ",
        "create_at",
        "from task_run",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="task_run_name", property="taskRunName", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_run_appkey", property="taskRunAppkey", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_run_address", property="taskRunAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="active", property="active", jdbcType=JdbcType.SMALLINT),
        @Result(column="creator_id", property="creatorId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_at", property="createAt", jdbcType=JdbcType.TIMESTAMP)
    })
    TaskRun selectByPrimaryKey(Long id);

    @UpdateProvider(type=TaskRunSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TaskRun record, @Param("example") TaskRunExample example);

    @UpdateProvider(type=TaskRunSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TaskRun record, @Param("example") TaskRunExample example);

    @UpdateProvider(type=TaskRunSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TaskRun record);

    @Update({
        "update task_run",
        "set task_run_name = #{taskRunName,jdbcType=VARCHAR},",
          "task_run_appkey = #{taskRunAppkey,jdbcType=VARCHAR},",
          "task_run_address = #{taskRunAddress,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "active = #{active,jdbcType=SMALLINT},",
          "creator_id = #{creatorId,jdbcType=BIGINT},",
          "create_at = #{createAt,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TaskRun record);
}