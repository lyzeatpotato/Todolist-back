package com.example.shuhistory.mapper;

import com.example.shuhistory.entity.Resource;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ResourceMapper {

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    @Select({
            "select",
            "name, path",
            "from resource",
            "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="path", property="path", jdbcType=JdbcType.LONGVARCHAR),
    })
    Resource selectByPrimaryKey(Long id);

    @Select({
            "select * from resource"
    })
    List<Resource> selectAllResource(Resource resource);

    /**
     * 自主新增资源文件信息
     * @param resource
     * @return
     */
    @Insert({
            "insert into resource ",
            "(name, path)",
            "values (#{name,jdbcType=VARCHAR}, #{path,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Resource resource);
}
