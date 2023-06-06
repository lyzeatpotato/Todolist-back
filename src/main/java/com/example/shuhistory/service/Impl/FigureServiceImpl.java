package com.example.shuhistory.service.Impl;

import com.example.shuhistory.entity.ImageHolder;
import com.example.shuhistory.entity.SchoolHistoryFigures;
import com.example.shuhistory.entity.SchoolHistoryFiguresExample;
import com.example.shuhistory.entity.SchoolHistoryFiguresWithBLOBs;
import com.example.shuhistory.enums.FileStateEnums;
import com.example.shuhistory.mapper.SchoolHistoryFiguresMapper;
import com.example.shuhistory.service.FigureService;
import com.example.shuhistory.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FigureServiceImpl implements FigureService {
    @Resource
    SchoolHistoryFiguresMapper schoolHistoryFiguresMapper;

    @Autowired
    OssService ossService;

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

    @Override
    public int addNewToDo(MultipartFile file, String name, String title, String story) {
        ImageHolder imageHolder = ossService.addHeadImage(file);
        imageHolder.getFileName()
        SchoolHistoryFiguresWithBLOBs figuresWithBLOBs = new SchoolHistoryFiguresWithBLOBs();
        figuresWithBLOBs.setName(name);
        figuresWithBLOBs.setTitle(title);
        figuresWithBLOBs.setLabel("0");
        figuresWithBLOBs.setAvatar(avatar);
        figuresWithBLOBs.setIntroduction("暂无介绍");
        figuresWithBLOBs.setStory(story);
        int insert = schoolHistoryFiguresMapper.insert(figuresWithBLOBs);
        return insert;
    }
}
