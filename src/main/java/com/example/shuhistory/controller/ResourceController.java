package com.example.shuhistory.controller;

import com.example.shuhistory.annotation.AuthToken;
import com.example.shuhistory.service.ResourceService;
import com.example.shuhistory.utils.BasicResponseUtils;
import com.example.shuhistory.vo.BasicResponse;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "7.请求静态资源文件")
@ApiSupport(order = 9)
@RestController
@RequestMapping("resource")
@Slf4j
public class ResourceController {

    @Resource
    ResourceService resourceService;

    @ApiOperation("全部静态资源")
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "header")})
//    @AuthToken
    @GetMapping("list")
    public BasicResponse findAllResource() {
        return BasicResponseUtils.success(resourceService.findAllResource());
    }

    @ApiOperation("根据id获取静态资源文件")
    @ApiOperationSupport(order = 2)
    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "header")})
//    @AuthToken
    @GetMapping("detail")
    public BasicResponse findResourceById(@RequestParam("id") Long id) {
        return BasicResponseUtils.success(resourceService.findResourceById(id));
    }

    @ApiOperation("新增静态资源文件")
    @ApiOperationSupport(order = 3)
    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "header")})
//    @AuthToken
    @GetMapping("add")
    public BasicResponse addResourceData(@RequestParam("name") String name, @RequestParam("path") String path) {
        String[] paramList = new String[]{name, path};
        return BasicResponseUtils.success(resourceService.addResource(paramList));
    }
}
