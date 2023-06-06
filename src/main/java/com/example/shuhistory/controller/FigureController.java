package com.example.shuhistory.controller;

import com.example.shuhistory.annotation.AuthToken;
import com.example.shuhistory.entity.FileEvent;
import com.example.shuhistory.service.FigureService;
import com.example.shuhistory.utils.BasicResponseUtils;
import com.example.shuhistory.vo.BasicResponse;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;

@Api(tags = "3.上大人物")
@ApiSupport(order = 4)
@RestController
@RequestMapping("figure")
public class FigureController {
    @Resource
    FigureService figureService;

    @ApiOperation("获取校史人物列表")
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "header")})
//    @AuthToken
    @GetMapping("list")
    public BasicResponse getFigureList() {
        return BasicResponseUtils.success(figureService.getFigureList());
    }

    @ApiOperation("获取todolist")
    @ApiOperationSupport(order = 2)
    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "header")})
//    @AuthToken
    @GetMapping("listspecial")
    public BasicResponse getToDoList() {
        return BasicResponseUtils.success(figureService.getToDoList());
    }

    @ApiOperation("获取校史人物详情")
    @ApiOperationSupport(order = 3)
    @ApiImplicitParams({@ApiImplicitParam(name = "token", value = "token", required = true, paramType = "header")})
//    @AuthToken
    @GetMapping("detail")
    public BasicResponse getFigureDetail(@RequestParam("id") Long id) {
        return BasicResponseUtils.success(figureService.getFigureDetail(id));
    }

    @ApiOperation("新增todolist")
    @ApiOperationSupport(order = 4)
//    @AuthToken
    @PostMapping("add")
    public BasicResponse addNewToDo(@RequestParam("file") MultipartFile file,
                                    @RequestParam("name") String name,
                                    @RequestParam("title") String title,
                                    @RequestParam("story") String story
                                    ) {
        return BasicResponseUtils.success(figureService.addNewToDo(file, name, title, story));
    }
}
