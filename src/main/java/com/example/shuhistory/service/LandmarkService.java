package com.example.shuhistory.service;

import com.example.shuhistory.entity.LandmarkWithBLOBs;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LandmarkService {
    List<LandmarkWithBLOBs> getLandmarkList();

    LandmarkWithBLOBs getLandmarkDetail(Long id);
}
