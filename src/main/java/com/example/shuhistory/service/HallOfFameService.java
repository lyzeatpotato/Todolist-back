package com.example.shuhistory.service;

import com.example.shuhistory.entity.HallOfFameWithBLOBs;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HallOfFameService {
    List<HallOfFameWithBLOBs> getHallOfFameList();

    HallOfFameWithBLOBs getHallOfFameDetail(Long id);
}
