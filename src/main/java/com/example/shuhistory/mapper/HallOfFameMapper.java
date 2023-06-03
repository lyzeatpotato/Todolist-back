package com.example.shuhistory.mapper;

import com.example.shuhistory.entity.HallOfFame;
import com.example.shuhistory.entity.HallOfFameExample;
import com.example.shuhistory.entity.HallOfFameWithBLOBs;
import com.example.shuhistory.mapper.generated.HallOfFameSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface HallOfFameMapper {
    @SelectProvider(type= HallOfFameSqlProvider.class, method="countByExample")
    long countByExample(HallOfFameExample example);

    @DeleteProvider(type=HallOfFameSqlProvider.class, method="deleteByExample")
    int deleteByExample(HallOfFameExample example);

    @Delete({
        "delete from hall_of_fame",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into hall_of_fame (time, name, ",
        "title, picture, ",
        "label, deeds, ",
        "deeds_picture)",
        "values (#{time,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{title,jdbcType=LONGVARCHAR}, #{picture,jdbcType=LONGVARCHAR}, ",
        "#{label,jdbcType=LONGVARCHAR}, #{deeds,jdbcType=LONGVARCHAR}, ",
        "#{deedsPicture,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(HallOfFameWithBLOBs record);

    @InsertProvider(type=HallOfFameSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(HallOfFameWithBLOBs record);

    @SelectProvider(type=HallOfFameSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="picture", property="picture", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="label", property="label", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="deeds", property="deeds", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="deeds_picture", property="deedsPicture", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<HallOfFameWithBLOBs> selectByExampleWithBLOBs(HallOfFameExample example);

    @SelectProvider(type=HallOfFameSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<HallOfFame> selectByExample(HallOfFameExample example);

    @Select({
        "select",
        "id, time, name, title, picture, label, deeds, deeds_picture",
        "from hall_of_fame",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="picture", property="picture", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="label", property="label", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="deeds", property="deeds", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="deeds_picture", property="deedsPicture", jdbcType=JdbcType.LONGVARCHAR)
    })
    HallOfFameWithBLOBs selectByPrimaryKey(Long id);

    @UpdateProvider(type=HallOfFameSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") HallOfFameWithBLOBs record, @Param("example") HallOfFameExample example);

    @UpdateProvider(type=HallOfFameSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") HallOfFameWithBLOBs record, @Param("example") HallOfFameExample example);

    @UpdateProvider(type=HallOfFameSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") HallOfFame record, @Param("example") HallOfFameExample example);

    @UpdateProvider(type=HallOfFameSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(HallOfFameWithBLOBs record);

    @Update({
        "update hall_of_fame",
        "set time = #{time,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=LONGVARCHAR},",
          "picture = #{picture,jdbcType=LONGVARCHAR},",
          "label = #{label,jdbcType=LONGVARCHAR},",
          "deeds = #{deeds,jdbcType=LONGVARCHAR},",
          "deeds_picture = #{deedsPicture,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(HallOfFameWithBLOBs record);

    @Update({
        "update hall_of_fame",
        "set time = #{time,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(HallOfFame record);
}