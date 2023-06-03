package com.example.shuhistory.service;

import com.example.shuhistory.entity.GroupHistory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GrouphistoryService {
    List<GroupHistory> getGroupHistoryList();

    GroupHistory getGroupHistoryDetail(Long id);
}
