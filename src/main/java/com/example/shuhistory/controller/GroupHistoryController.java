package com.example.shuhistory.controller;

import com.example.shuhistory.annotation.AuthToken;
import com.example.shuhistory.service.GrouphistoryService;
import com.example.shuhistory.utils.BasicResponseUtils;
import com.example.shuhistory.vo.BasicResponse;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "5.校史团史")
@ApiSupport(order = 6)
@RestController
@RequestMapping("grouphistory")
public class GroupHistoryController {
    @Resource
    GrouphistoryService grouphistoryService;

    @ApiOperation("获取团史列表")
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "header")})
//    @AuthToken
    @GetMapping("list")
    public BasicResponse getGroupHistoryList() {
        return BasicResponseUtils.success(grouphistoryService.getGroupHistoryList());
    }

    @ApiOperation("获取团史详情")
    @ApiOperationSupport(order = 100)
    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "header")})
//    @AuthToken
    @GetMapping("detail")
    public BasicResponse getGroupHistoryDetail(@RequestParam("id") Long id) {
        return BasicResponseUtils.success(grouphistoryService.getGroupHistoryDetail(id));
    }
}
