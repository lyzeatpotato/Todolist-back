package com.example.shuhistory.service.Impl;

import com.example.shuhistory.entity.SchoolHistoryFigures;
import com.example.shuhistory.entity.SchoolHistoryFiguresExample;
import com.example.shuhistory.entity.SchoolHistoryFiguresWithBLOBs;
import com.example.shuhistory.mapper.SchoolHistoryFiguresMapper;
import com.example.shuhistory.service.FigureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FigureServiceImpl implements FigureService {
    @Resource
    SchoolHistoryFiguresMapper schoolHistoryFiguresMapper;

    @Override
    public List<SchoolHistoryFiguresWithBLOBs> getFigureList() {
        SchoolHistoryFiguresExample example = new SchoolHistoryFiguresExample();
        return schoolHistoryFiguresMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<SchoolHistoryFigures> getToDoList() {
        SchoolHistoryFiguresExample example = new SchoolHistoryFiguresExample();
        return schoolHistoryFiguresMapper.selectByExample(example);
    }

    @Override
    public SchoolHistoryFiguresWithBLOBs getFigureDetail(Long id) {
        return schoolHistoryFiguresMapper.selectByPrimaryKey(id);
    }
}
