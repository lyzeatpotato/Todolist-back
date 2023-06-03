package com.example.shuhistory.service;

import com.example.shuhistory.entity.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResourceService {

    /**
     * 根据主键查询静态资源文件信息
     */
    Resource findResourceById(Long id);

    /**
     * 查询全部的静态资源列表
     * @return
     */
    List<Resource> findAllResource();

    /**
     * 新增静态资源信息
     */
    int addResource(String[] params);
}
