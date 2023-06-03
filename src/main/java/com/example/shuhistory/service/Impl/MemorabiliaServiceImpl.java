package com.example.shuhistory.service.Impl;

import com.example.shuhistory.entity.MemorabiliaFiguresExample;
import com.example.shuhistory.entity.MemorabiliaFiguresWithBLOBs;
import com.example.shuhistory.mapper.MemorabiliaMapper;
import com.example.shuhistory.service.MemorabiliaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MemorabiliaServiceImpl implements MemorabiliaService {
    @Resource
    MemorabiliaMapper memorabiliaMapper;

    @Override
    public List<MemorabiliaFiguresWithBLOBs> getMemorabiliaList() {
        MemorabiliaFiguresExample example = new MemorabiliaFiguresExample();
        return memorabiliaMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public MemorabiliaFiguresWithBLOBs getMemorabiliaDetail(Long id) {
        return memorabiliaMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<MemorabiliaFiguresWithBLOBs> getMemorabiliaDetailByYear(String year) {
        return memorabiliaMapper.selectByYear(year);
    }
}
