package com.example.shuhistory.controller;

import com.example.shuhistory.annotation.AuthToken;
import com.example.shuhistory.entity.CloudBlessWithBLOBs;
import com.example.shuhistory.service.CloudBlessService;
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

@Api(tags = "4.云上祝福")
@ApiSupport(order = 5)
@RestController
@RequestMapping("cloudbless")
public class CloudBlessController {
    @Resource
    CloudBlessService cloudBlessService;

    @ApiOperation("获取云上祝福列表")
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "header")})
//    @AuthToken
    @GetMapping("list")
    public BasicResponse getCloudBlessList() {
        return BasicResponseUtils.success(cloudBlessService.getCloudBlessList());
    }

    @ApiOperation("获取云上祝福列表详情")
    @ApiOperationSupport(order = 2)
    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "header")})
//    @AuthToken
    @GetMapping("detail")
    public BasicResponse getCloudBlessDetail(@RequestParam("id") Long id) {
        return BasicResponseUtils.success(cloudBlessService.getCloudBlessDetail(id));
    }

    @ApiOperation("存储云上祝福的信息")
    @ApiOperationSupport(order = 3)
    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "header")})
//    @AuthToken
    @GetMapping("addItem")
    public BasicResponse insertCloudBless(@RequestParam("status") String status, @RequestParam("content") String content,
                                          @RequestParam("distance") String distance, @RequestParam("city") String city,
                                          @RequestParam("show_distance") String show_distance)
    {
        // 向service层传递参数列表
        String [] paramList = new String[]{status, content, distance, city, show_distance};
        return BasicResponseUtils.success(cloudBlessService.insertCloudBlessList(paramList));
    }
}
