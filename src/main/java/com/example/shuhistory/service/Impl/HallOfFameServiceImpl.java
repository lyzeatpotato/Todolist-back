package com.example.shuhistory.service.Impl;

import com.example.shuhistory.entity.HallOfFameExample;
import com.example.shuhistory.entity.HallOfFameWithBLOBs;
import com.example.shuhistory.mapper.HallOfFameMapper;
import com.example.shuhistory.service.HallOfFameService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HallOfFameServiceImpl implements HallOfFameService {
    @Resource
    HallOfFameMapper hallOfFameMapper;

    @Override
    public List<HallOfFameWithBLOBs> getHallOfFameList() {
        return hallOfFameMapper.selectByExampleWithBLOBs(new HallOfFameExample());
    }

    @Override
    public HallOfFameWithBLOBs getHallOfFameDetail(Long id) {
        return hallOfFameMapper.selectByPrimaryKey(id);
    }
}
