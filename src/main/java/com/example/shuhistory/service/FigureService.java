package com.example.shuhistory.service;

import com.example.shuhistory.entity.SchoolHistoryFigures;
import com.example.shuhistory.entity.SchoolHistoryFiguresWithBLOBs;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FigureService {
    List<SchoolHistoryFiguresWithBLOBs> getFigureList();

    List<SchoolHistoryFigures> getToDoList();

    SchoolHistoryFiguresWithBLOBs getFigureDetail(Long id);
}
