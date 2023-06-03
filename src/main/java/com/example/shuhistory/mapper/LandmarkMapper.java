package com.example.shuhistory.mapper;

import com.example.shuhistory.entity.Landmark;
import com.example.shuhistory.entity.LandmarkExample;
import com.example.shuhistory.entity.LandmarkWithBLOBs;
import com.example.shuhistory.mapper.generated.LandmarkSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface LandmarkMapper {
    @SelectProvider(type= LandmarkSqlProvider.class, method="countByExample")
    long countByExample(LandmarkExample example);

    @DeleteProvider(type=LandmarkSqlProvider.class, method="deleteByExample")
    int deleteByExample(LandmarkExample example);

    @Delete({
        "delete from landmark",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into landmark (title, time, ",
        "place_name, longitude_latitude, ",
        "event_title, event_content, ",
        "picture)",
        "values (#{title,jdbcType=VARCHAR}, #{time,jdbcType=VARCHAR}, ",
        "#{placeName,jdbcType=VARCHAR}, #{longitudeLatitude,jdbcType=VARCHAR}, ",
        "#{eventTitle,jdbcType=LONGVARCHAR}, #{eventContent,jdbcType=LONGVARCHAR}, ",
        "#{picture,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(LandmarkWithBLOBs record);

    @InsertProvider(type=LandmarkSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(LandmarkWithBLOBs record);

    @SelectProvider(type=LandmarkSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
        @Result(column="place_name", property="placeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="longitude_latitude", property="longitudeLatitude", jdbcType=JdbcType.VARCHAR),
        @Result(column="event_title", property="eventTitle", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="event_content", property="eventContent", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="picture", property="picture", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<LandmarkWithBLOBs> selectByExampleWithBLOBs(LandmarkExample example);

    @SelectProvider(type=LandmarkSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
        @Result(column="place_name", property="placeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="longitude_latitude", property="longitudeLatitude", jdbcType=JdbcType.VARCHAR)
    })
    List<Landmark> selectByExample(LandmarkExample example);

    @Select({
        "select",
        "id, title, time, place_name, longitude_latitude, event_title, event_content, ",
        "picture",
        "from landmark",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
        @Result(column="place_name", property="placeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="longitude_latitude", property="longitudeLatitude", jdbcType=JdbcType.VARCHAR),
        @Result(column="event_title", property="eventTitle", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="event_content", property="eventContent", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="picture", property="picture", jdbcType=JdbcType.LONGVARCHAR)
    })
    LandmarkWithBLOBs selectByPrimaryKey(Long id);

    @UpdateProvider(type=LandmarkSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") LandmarkWithBLOBs record, @Param("example") LandmarkExample example);

    @UpdateProvider(type=LandmarkSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") LandmarkWithBLOBs record, @Param("example") LandmarkExample example);

    @UpdateProvider(type=LandmarkSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Landmark record, @Param("example") LandmarkExample example);

    @UpdateProvider(type=LandmarkSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LandmarkWithBLOBs record);

    @Update({
        "update landmark",
        "set title = #{title,jdbcType=VARCHAR},",
          "time = #{time,jdbcType=VARCHAR},",
          "place_name = #{placeName,jdbcType=VARCHAR},",
          "longitude_latitude = #{longitudeLatitude,jdbcType=VARCHAR},",
          "event_title = #{eventTitle,jdbcType=LONGVARCHAR},",
          "event_content = #{eventContent,jdbcType=LONGVARCHAR},",
          "picture = #{picture,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(LandmarkWithBLOBs record);

    @Update({
        "update landmark",
        "set title = #{title,jdbcType=VARCHAR},",
          "time = #{time,jdbcType=VARCHAR},",
          "place_name = #{placeName,jdbcType=VARCHAR},",
          "longitude_latitude = #{longitudeLatitude,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Landmark record);
}