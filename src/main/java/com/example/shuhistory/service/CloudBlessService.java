package com.example.shuhistory.service;

import com.example.shuhistory.entity.CloudBlessWithBLOBs;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CloudBlessService {
    List<CloudBlessWithBLOBs> getCloudBlessList();

    CloudBlessWithBLOBs getCloudBlessDetail(Long id);

    int insertCloudBlessList(String [] list);
}
