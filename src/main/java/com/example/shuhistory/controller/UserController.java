package com.example.shuhistory.controller;

import com.example.shuhistory.annotation.AuthToken;
import com.example.shuhistory.annotation.LoginUser;
import com.example.shuhistory.entity.User;
import com.example.shuhistory.enums.ResponseCodeEnums;
import com.example.shuhistory.utils.BasicResponseUtils;
import com.example.shuhistory.utils.JWTResult;
import com.example.shuhistory.utils.JwtUtils;
import com.example.shuhistory.vo.BasicResponse;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Api(tags = "0.用户登录")
@ApiSupport(order = 1)
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    @ApiOperation(value = "用户登录", notes = "username为root, password为123456。登录成功返回一个随即生成的token。")
    @PostMapping("login")
    public BasicResponse login(@ApiIgnore HttpServletResponse response, @RequestParam("username") String username, @RequestParam("password") String password) throws IOException {
        if (username.equals("root") && password.equals("123456")) {
            String token = JwtUtils.createJWT("1", username, 60000L*60*24*30); // 30 days
            Cookie cookie = new Cookie("token", token);
            cookie.setMaxAge(30 * 24 * 60 * 60);
            cookie.setPath("/");
            response.addCookie(cookie);
            return BasicResponseUtils.success(token);
        }
        return BasicResponseUtils.error(ResponseCodeEnums.LOGIN_ERROR);
    }

    @ApiOperation("token测试")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", required = true, paramType = "header")
    })
    @GetMapping("getUsername")
//    @AuthToken
    public BasicResponse getUserId(@LoginUser User user) {
        log.info(user.toString());
        return BasicResponseUtils.success(user);
    }
}
