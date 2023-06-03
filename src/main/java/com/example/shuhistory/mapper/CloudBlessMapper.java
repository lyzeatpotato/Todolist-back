package com.example.shuhistory.mapper;

import com.example.shuhistory.entity.CloudBlessExample;
import com.example.shuhistory.entity.CloudBlessWithBLOBs;
import com.example.shuhistory.mapper.generated.CloudBlessSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface CloudBlessMapper {

//    @SelectProvider(type=SchoolHistoryFiguresSqlProvider.class, method="countByExample")
//    long countByExample(SchoolHistoryFiguresExample example);
//
//    @DeleteProvider(type=SchoolHistoryFiguresSqlProvider.class, method="deleteByExample")
//    int deleteByExample(SchoolHistoryFiguresExample example);
//
//    @Delete({
//        "delete from school_history_figures",
//        "where id = #{id,jdbcType=BIGINT}"
//    })
//    int deleteByPrimaryKey(Long id);
//
    @Insert({
        "insert into cloudbless ",
        "(status, content, ",
        "distance, city, show_distance)",
        "values (#{status,jdbcType=VARCHAR}, ",
        "#{content,jdbcType=LONGVARCHAR}, #{distance,jdbcType=VARCHAR}, ",
        "#{city,jdbcType=VARCHAR}, #{show_distance,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(CloudBlessWithBLOBs record);


    @SelectProvider(type= CloudBlessSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="distance", property="distance", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="show_distance", property="show_distance", jdbcType=JdbcType.VARCHAR),
    })
    List<CloudBlessWithBLOBs> selectByExampleWithBLOBs(CloudBlessExample example);

//    @SelectProvider(type=SchoolHistoryFiguresSqlProvider.class, method="selectByExample")
//    @Results({
//        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
//        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
//        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
//        @Result(column="label", property="label", jdbcType=JdbcType.VARCHAR)
//    })
//    List<SchoolHistoryFigures> selectByExample(SchoolHistoryFiguresExample example);

    @Select({
        "select",
        "id, status, content, distance, city, show_distance",
        "from cloudbless",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="distance", property="distance", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="show_distance", property="show_distance", jdbcType=JdbcType.VARCHAR),
    })
    CloudBlessWithBLOBs selectByPrimaryKey(Long id);


//    @UpdateProvider(type=SchoolHistoryFiguresSqlProvider.class, method="updateByExampleSelective")
//    int updateByExampleSelective(@Param("record") SchoolHistoryFiguresWithBLOBs record, @Param("example") SchoolHistoryFiguresExample example);
//
//    @UpdateProvider(type=SchoolHistoryFiguresSqlProvider.class, method="updateByExampleWithBLOBs")
//    int updateByExampleWithBLOBs(@Param("record") SchoolHistoryFiguresWithBLOBs record, @Param("example") SchoolHistoryFiguresExample example);
//
//    @UpdateProvider(type=SchoolHistoryFiguresSqlProvider.class, method="updateByExample")
//    int updateByExample(@Param("record") SchoolHistoryFigures record, @Param("example") SchoolHistoryFiguresExample example);
//
//    @UpdateProvider(type=SchoolHistoryFiguresSqlProvider.class, method="updateByPrimaryKeySelective")
//    int updateByPrimaryKeySelective(SchoolHistoryFiguresWithBLOBs record);
//
//    @Update({
//        "update school_history_figures",
//        "set name = #{name,jdbcType=VARCHAR},",
//          "title = #{title,jdbcType=VARCHAR},",
//          "label = #{label,jdbcType=VARCHAR},",
//          "avatar = #{avatar,jdbcType=LONGVARCHAR},",
//          "introduction = #{introduction,jdbcType=LONGVARCHAR},",
//          "story = #{story,jdbcType=LONGVARCHAR},",
//          "video = #{video,jdbcType=LONGVARCHAR}",
//        "where id = #{id,jdbcType=BIGINT}"
//    })
//    int updateByPrimaryKeyWithBLOBs(SchoolHistoryFiguresWithBLOBs record);
//
//    @Update({
//        "update school_history_figures",
//        "set name = #{name,jdbcType=VARCHAR},",
//          "title = #{title,jdbcType=VARCHAR},",
//          "label = #{label,jdbcType=VARCHAR}",
//        "where id = #{id,jdbcType=BIGINT}"
//    })
//    int updateByPrimaryKey(SchoolHistoryFigures record);
}