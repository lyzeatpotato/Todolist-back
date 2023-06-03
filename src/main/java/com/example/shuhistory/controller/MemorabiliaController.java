package com.example.shuhistory.controller;

import com.example.shuhistory.annotation.AuthToken;
import com.example.shuhistory.service.FigureService;
import com.example.shuhistory.service.MemorabiliaService;
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

@Api(tags = "1.百年事记")
@ApiSupport(order = 2)
@RestController
@RequestMapping("memorabilia")
public class MemorabiliaController {
    @Resource
    MemorabiliaService memorabiliaService;

    @ApiOperation("获取百年事记列表")
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "header")})
//    @AuthToken
    @GetMapping("list")
    public BasicResponse getMemorabiliaList() {
        return BasicResponseUtils.success(memorabiliaService.getMemorabiliaList());
    }

    @ApiOperation("获取百年事记列表详情")
    @ApiOperationSupport(order = 2)
    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "header")})
//    @AuthToken
    @GetMapping("detail")
    public BasicResponse getMemorabiliaDetail(@RequestParam("id") Long id) {
        return BasicResponseUtils.success(memorabiliaService.getMemorabiliaDetail(id));
    }

    @ApiOperation(value = "根据大事记年份获取列表详情", notes = "可查询的年份仅包含：1922-1927;1958-1962;1965-1968;1970,72,73,75,78,79,81,83,84,89,93,94,96,97,99,2003,2010,2013,2014;2016-2022")
    @ApiOperationSupport(order = 3)
    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "header")})
//    @AuthToken
    @GetMapping("year_detail")
    public BasicResponse getMemorabiliaDetailByYear(@RequestParam("year") String year) {
        return BasicResponseUtils.success(memorabiliaService.getMemorabiliaDetailByYear(year));
    }
}
