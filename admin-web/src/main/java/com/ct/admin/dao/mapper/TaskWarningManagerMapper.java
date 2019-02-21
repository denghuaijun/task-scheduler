package com.ct.admin.dao.mapper;

import com.ct.admin.dao.entity.TaskWarningManager;
import com.ct.admin.dao.entity.TaskWarningManagerExample;
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

public interface TaskWarningManagerMapper {
    @SelectProvider(type=TaskWarningManagerSqlProvider.class, method="countByExample")
    long countByExample(TaskWarningManagerExample example);

    @DeleteProvider(type=TaskWarningManagerSqlProvider.class, method="deleteByExample")
    int deleteByExample(TaskWarningManagerExample example);

    @Delete({
        "delete from task_warning_manager",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into task_warning_manager (task_warning_count, task_warning_name, ",
        "create_time)",
        "values (#{taskWarningCount,jdbcType=VARCHAR}, #{taskWarningName,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(TaskWarningManager record);

    @InsertProvider(type=TaskWarningManagerSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(TaskWarningManager record);

    @SelectProvider(type=TaskWarningManagerSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="task_warning_count", property="taskWarningCount", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_warning_name", property="taskWarningName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TaskWarningManager> selectByExample(TaskWarningManagerExample example);

    @Select({
        "select",
        "id, task_warning_count, task_warning_name, create_time",
        "from task_warning_manager",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="task_warning_count", property="taskWarningCount", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_warning_name", property="taskWarningName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    TaskWarningManager selectByPrimaryKey(Long id);

    @UpdateProvider(type=TaskWarningManagerSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TaskWarningManager record, @Param("example") TaskWarningManagerExample example);

    @UpdateProvider(type=TaskWarningManagerSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TaskWarningManager record, @Param("example") TaskWarningManagerExample example);

    @UpdateProvider(type=TaskWarningManagerSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TaskWarningManager record);

    @Update({
        "update task_warning_manager",
        "set task_warning_count = #{taskWarningCount,jdbcType=VARCHAR},",
          "task_warning_name = #{taskWarningName,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TaskWarningManager record);
}