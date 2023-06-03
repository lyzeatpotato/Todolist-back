package com.example.shuhistory.service;

import com.example.shuhistory.entity.MemorabiliaFiguresWithBLOBs;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemorabiliaService {
    List<MemorabiliaFiguresWithBLOBs> getMemorabiliaList();

    MemorabiliaFiguresWithBLOBs getMemorabiliaDetail(Long id);

    List<MemorabiliaFiguresWithBLOBs> getMemorabiliaDetailByYear(String year);

}
