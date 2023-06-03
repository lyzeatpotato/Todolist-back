package com.example.shuhistory.service.Impl;

import com.example.shuhistory.entity.GroupHistory;
import com.example.shuhistory.entity.GroupHistoryExample;
import com.example.shuhistory.mapper.GroupHistoryMapper;
import com.example.shuhistory.service.GrouphistoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GrouphistoryServiceImpl implements GrouphistoryService {
    @Resource
    GroupHistoryMapper groupHistoryMapper;

    @Override
    public List<GroupHistory> getGroupHistoryList() {
        return groupHistoryMapper.selectByExampleWithBLOBs(new GroupHistoryExample());
    }

    @Override
    public GroupHistory getGroupHistoryDetail(Long id) {
        return groupHistoryMapper.selectByPrimaryKey(id);
    }
}
