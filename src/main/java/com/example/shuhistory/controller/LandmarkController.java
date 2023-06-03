package com.example.shuhistory.controller;

import com.example.shuhistory.annotation.AuthToken;
import com.example.shuhistory.service.LandmarkService;
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

@Api(tags = "2.建校地标")
@ApiSupport(order = 3)
@RestController
@RequestMapping("landmark")
public class LandmarkController {
    @Resource
    LandmarkService landmarkService;

    @ApiOperation("获取建校地标列表")
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "header")})
//    @AuthToken
    @GetMapping("list")
    public BasicResponse getLandmarkList() {
        return BasicResponseUtils.success(landmarkService.getLandmarkList());
    }

    @ApiOperation("获取建校地标详情")
    @ApiOperationSupport(order = 100)
    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "header")})
//    @AuthToken
    @GetMapping("detail")
    public BasicResponse getLandmarkDetail(@RequestParam("id") Long id) {
        return BasicResponseUtils.success(landmarkService.getLandmarkDetail(id));
    }
}
