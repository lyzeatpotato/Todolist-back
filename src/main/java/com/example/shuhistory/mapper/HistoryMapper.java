package com.example.shuhistory.mapper;

import com.example.shuhistory.entity.History;
import com.example.shuhistory.entity.HistoryExample;
import com.example.shuhistory.mapper.generated.HistorySqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface HistoryMapper {
    @SelectProvider(type= HistorySqlProvider.class, method="countByExample")
    long countByExample(HistoryExample example);

    @DeleteProvider(type=HistorySqlProvider.class, method="deleteByExample")
    int deleteByExample(HistoryExample example);

    @Delete({
        "delete from history",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into history (title, content, ",
        "date)",
        "values (#{title,jdbcType=VARCHAR}, #{content,jdbcType=VARCHAR}, ",
        "#{date,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(History record);

    @InsertProvider(type=HistorySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(History record);

    @SelectProvider(type=HistorySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="date", property="date", jdbcType=JdbcType.TIMESTAMP)
    })
    List<History> selectByExample(HistoryExample example);

    @Select({
        "select",
        "id, title, content, date",
        "from history",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="date", property="date", jdbcType=JdbcType.TIMESTAMP)
    })
    History selectByPrimaryKey(Integer id);

    @UpdateProvider(type=HistorySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") History record, @Param("example") HistoryExample example);

    @UpdateProvider(type=HistorySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") History record, @Param("example") HistoryExample example);

    @UpdateProvider(type=HistorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(History record);

    @Update({
        "update history",
        "set title = #{title,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=VARCHAR},",
          "date = #{date,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(History record);
}