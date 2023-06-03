package com.example.shuhistory.mapper;

import com.example.shuhistory.entity.GroupHistory;
import com.example.shuhistory.entity.GroupHistoryExample;
import com.example.shuhistory.mapper.generated.GroupHistorySqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface GroupHistoryMapper {
    @SelectProvider(type= GroupHistorySqlProvider.class, method="countByExample")
    long countByExample(GroupHistoryExample example);

    @DeleteProvider(type=GroupHistorySqlProvider.class, method="deleteByExample")
    int deleteByExample(GroupHistoryExample example);

    @Delete({
        "delete from group_history",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into group_history (name, picture, ",
        "title, content)",
        "values (#{name,jdbcType=LONGVARCHAR}, #{picture,jdbcType=LONGVARCHAR}, ",
        "#{title,jdbcType=LONGVARCHAR}, #{content,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(GroupHistory record);

    @InsertProvider(type=GroupHistorySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(GroupHistory record);

    @SelectProvider(type=GroupHistorySqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="picture", property="picture", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<GroupHistory> selectByExampleWithBLOBs(GroupHistoryExample example);

    @SelectProvider(type=GroupHistorySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true)
    })
    List<GroupHistory> selectByExample(GroupHistoryExample example);

    @Select({
        "select",
        "id, name, picture, title, content",
        "from group_history",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="picture", property="picture", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    GroupHistory selectByPrimaryKey(Long id);

    @UpdateProvider(type=GroupHistorySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") GroupHistory record, @Param("example") GroupHistoryExample example);

    @UpdateProvider(type=GroupHistorySqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") GroupHistory record, @Param("example") GroupHistoryExample example);

    @UpdateProvider(type=GroupHistorySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") GroupHistory record, @Param("example") GroupHistoryExample example);

    @UpdateProvider(type=GroupHistorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(GroupHistory record);

    @Update({
        "update group_history",
        "set name = #{name,jdbcType=LONGVARCHAR},",
          "picture = #{picture,jdbcType=LONGVARCHAR},",
          "title = #{title,jdbcType=LONGVARCHAR},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(GroupHistory record);
}