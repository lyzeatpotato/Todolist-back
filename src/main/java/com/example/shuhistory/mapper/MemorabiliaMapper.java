package com.example.shuhistory.mapper;

import com.example.shuhistory.entity.MemorabiliaFiguresExample;
import com.example.shuhistory.entity.MemorabiliaFiguresWithBLOBs;
import com.example.shuhistory.mapper.generated.MemorabiliaSqlProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface MemorabiliaMapper {

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
//    @Insert({
//        "insert into school_history_figures (name, title, ",
//        "label, avatar, ",
//        "introduction, story, ",
//        "video)",
//        "values (#{name,jdbcType=VARCHAR}, #{title,jdbcType=VARCHAR}, ",
//        "#{label,jdbcType=VARCHAR}, #{avatar,jdbcType=LONGVARCHAR}, ",
//        "#{introduction,jdbcType=LONGVARCHAR}, #{story,jdbcType=LONGVARCHAR}, ",
//        "#{video,jdbcType=LONGVARCHAR})"
//    })
//    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
//    int insert(SchoolHistoryFiguresWithBLOBs record);
//
//    @InsertProvider(type=SchoolHistoryFiguresSqlProvider.class, method="insertSelective")
//    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
//    int insertSelective(SchoolHistoryFiguresWithBLOBs record);

    @SelectProvider(type= MemorabiliaSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="event", property="event", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="year", property="year", jdbcType=JdbcType.VARCHAR),
        @Result(column="month", property="month", jdbcType=JdbcType.VARCHAR),
        @Result(column="picture", property="picture", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="pic_detail", property="pic_detail", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="school", property="school", jdbcType=JdbcType.VARCHAR)
    })
    List<MemorabiliaFiguresWithBLOBs> selectByExampleWithBLOBs(MemorabiliaFiguresExample example);

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
        "id, name, event, year, month, picture, pic_detail, school",
        "from memorabilia",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="event", property="event", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="year", property="year", jdbcType=JdbcType.VARCHAR),
        @Result(column="month", property="month", jdbcType=JdbcType.VARCHAR),
        @Result(column="picture", property="picture", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="pic_detail", property="pic_detail", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="school", property="school", jdbcType=JdbcType.VARCHAR)
    })
    MemorabiliaFiguresWithBLOBs selectByPrimaryKey(Long id);

    @Select({
            "select",
            "id, name, event, year, month, picture, pic_detail, school",
            "from memorabilia",
            "where year = #{year,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="event", property="event", jdbcType=JdbcType.LONGVARCHAR),
            @Result(column="year", property="year", jdbcType=JdbcType.VARCHAR),
            @Result(column="month", property="month", jdbcType=JdbcType.VARCHAR),
            @Result(column="picture", property="picture", jdbcType=JdbcType.LONGVARCHAR),
            @Result(column="pic_detail", property="pic_detail", jdbcType=JdbcType.LONGVARCHAR),
            @Result(column="school", property="school", jdbcType=JdbcType.VARCHAR)
    })
    List<MemorabiliaFiguresWithBLOBs> selectByYear(String year);

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