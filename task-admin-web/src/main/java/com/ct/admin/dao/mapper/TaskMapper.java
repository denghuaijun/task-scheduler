package com.ct.admin.dao.mapper;

import com.ct.admin.dao.entity.Task;
import com.ct.admin.dao.entity.TaskExample;
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

public interface TaskMapper {
    @SelectProvider(type=TaskSqlProvider.class, method="countByExample")
    long countByExample(TaskExample example);

    @DeleteProvider(type=TaskSqlProvider.class, method="deleteByExample")
    int deleteByExample(TaskExample example);

    @Delete({
        "delete from task",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into task (task_name, fk_taskrunner_id, ",
        "task_cron, creator_id, ",
        "create_at, status, ",
        "task_status, active)",
        "values (#{taskName,jdbcType=VARCHAR}, #{fkTaskrunnerId,jdbcType=BIGINT}, ",
        "#{taskCron,jdbcType=VARCHAR}, #{creatorId,jdbcType=BIGINT}, ",
        "#{createAt,jdbcType=TIMESTAMP}, #{status,jdbcType=INTEGER}, ",
        "#{taskStatus,jdbcType=INTEGER}, #{active,jdbcType=SMALLINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Task record);

    @InsertProvider(type=TaskSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(Task record);

    @SelectProvider(type=TaskSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="task_name", property="taskName", jdbcType=JdbcType.VARCHAR),
        @Result(column="fk_taskrunner_id", property="fkTaskrunnerId", jdbcType=JdbcType.BIGINT),
        @Result(column="task_cron", property="taskCron", jdbcType=JdbcType.VARCHAR),
        @Result(column="creator_id", property="creatorId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_at", property="createAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="task_status", property="taskStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="active", property="active", jdbcType=JdbcType.SMALLINT)
    })
    List<Task> selectByExample(TaskExample example);

    @Select({
        "select",
        "id, task_name, fk_taskrunner_id, task_cron, creator_id, create_at, status, task_status, ",
        "active",
        "from task",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="task_name", property="taskName", jdbcType=JdbcType.VARCHAR),
        @Result(column="fk_taskrunner_id", property="fkTaskrunnerId", jdbcType=JdbcType.BIGINT),
        @Result(column="task_cron", property="taskCron", jdbcType=JdbcType.VARCHAR),
        @Result(column="creator_id", property="creatorId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_at", property="createAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="task_status", property="taskStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="active", property="active", jdbcType=JdbcType.SMALLINT)
    })
    Task selectByPrimaryKey(Long id);

    @UpdateProvider(type=TaskSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Task record, @Param("example") TaskExample example);

    @UpdateProvider(type=TaskSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Task record, @Param("example") TaskExample example);

    @UpdateProvider(type=TaskSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Task record);

    @Update({
        "update task",
        "set task_name = #{taskName,jdbcType=VARCHAR},",
          "fk_taskrunner_id = #{fkTaskrunnerId,jdbcType=BIGINT},",
          "task_cron = #{taskCron,jdbcType=VARCHAR},",
          "creator_id = #{creatorId,jdbcType=BIGINT},",
          "create_at = #{createAt,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER},",
          "task_status = #{taskStatus,jdbcType=INTEGER},",
          "active = #{active,jdbcType=SMALLINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Task record);
}