package com.example.shuhistory.service.Impl;

import com.example.shuhistory.entity.CloudBlessExample;
import com.example.shuhistory.entity.CloudBlessWithBLOBs;
import com.example.shuhistory.mapper.CloudBlessMapper;
import com.example.shuhistory.service.CloudBlessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CloudBlessServiceImpl implements CloudBlessService {
    @Resource
    CloudBlessMapper cloudBlessMapper;

    @Override
    public List<CloudBlessWithBLOBs> getCloudBlessList() {
        CloudBlessExample example = new CloudBlessExample();
        return cloudBlessMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public CloudBlessWithBLOBs getCloudBlessDetail(Long id) {
        return cloudBlessMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertCloudBlessList(String [] list) {
        CloudBlessWithBLOBs record = new CloudBlessWithBLOBs();
        record.setStatus(list[0]);
        record.setContent(list[1]);
        record.setDistance(list[2]);
        record.setCity(list[3]);
        record.setShow_distance(list[4]);
        return cloudBlessMapper.insert(record);
    }
}
