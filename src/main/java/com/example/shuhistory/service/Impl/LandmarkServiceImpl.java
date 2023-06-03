package com.example.shuhistory.service.Impl;

import com.example.shuhistory.entity.LandmarkExample;
import com.example.shuhistory.entity.LandmarkWithBLOBs;
import com.example.shuhistory.mapper.LandmarkMapper;
import com.example.shuhistory.service.LandmarkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LandmarkServiceImpl implements LandmarkService {
    @Resource
    LandmarkMapper landmarkMapper;

    @Override
    public List<LandmarkWithBLOBs> getLandmarkList() {
        return landmarkMapper.selectByExampleWithBLOBs(new LandmarkExample());
    }

    @Override
    public LandmarkWithBLOBs getLandmarkDetail(Long id) {
        return landmarkMapper.selectByPrimaryKey(id);
    }
}
