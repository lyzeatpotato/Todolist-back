package com.example.shuhistory.service.Impl;

import com.example.shuhistory.entity.Resource;
import com.example.shuhistory.mapper.ResourceMapper;
import com.example.shuhistory.service.ResourceService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ResourceServiceImpl implements ResourceService {

    @javax.annotation.Resource
    ResourceMapper resourceMapper;

    @Override
    public Resource findResourceById(Long id) {
        return resourceMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Resource> findAllResource() {
        Resource newResource = new Resource();
        return resourceMapper.selectAllResource(newResource);
    }

    @Override
    public int addResource(String[] params) {
        Resource newResource = new Resource();
        newResource.setName(params[0]);
        newResource.setPath(params[1]);
        return resourceMapper.insert(newResource);
    }
}
