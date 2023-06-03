package com.example.shuhistory.controller;

import com.example.shuhistory.annotation.AuthToken;
import com.example.shuhistory.service.HallOfFameService;
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

@Api(tags = "6.荣誉人物")
@ApiSupport(order = 7)
@RestController
@RequestMapping("halloffame")
public class HallOfFameController {
    @Resource
    HallOfFameService hallOfFameService;


    @ApiOperation("获取光荣榜列表")
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "header")})
//    @AuthToken
    @GetMapping("list")
    public BasicResponse getHallOfFameList() {
        return BasicResponseUtils.success(hallOfFameService.getHallOfFameList());
    }

    @ApiOperation("获取光荣榜详情")
    @ApiOperationSupport(order = 100)
    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "header")})
//    @AuthToken
    @GetMapping("detail")
    public BasicResponse getHallOfFameDetail(@RequestParam("id") Long id) {
        return BasicResponseUtils.success(hallOfFameService.getHallOfFameDetail(id));
    }
}
