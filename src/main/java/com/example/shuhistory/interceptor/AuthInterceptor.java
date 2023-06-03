package com.example.shuhistory.interceptor;

import com.alibaba.fastjson.JSON;
import com.example.shuhistory.annotation.AuthToken;
import com.example.shuhistory.entity.User;
import com.example.shuhistory.enums.ResponseCodeEnums;
import com.example.shuhistory.utils.BasicResponseUtils;
import com.example.shuhistory.utils.JWTResult;
import com.example.shuhistory.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 权限的校验拦截器
 */
@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {
    public static final String USER_INFO = "USER_INFO";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        AuthToken annotation;
        if (handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(AuthToken.class);
        } else {
            return true;
        }
        //没有声明需要权限,或者声明不验证权限
        if (annotation == null || !annotation.validate()) {
            return true;
        }
        //从header中获取token
        String token = request.getHeader("token");
//        if (token == null) {
//            log.info(ResponseCodeEnums.JWT_NOT_EXIST.getMsg());
//            returnResponse(response, ResponseCodeEnums.JWT_NOT_EXIST);
//            return false;
//        }
        // 验证token信息
        JWTResult jwtResult = JwtUtils.validateJWT(token);
        if (!jwtResult.isSuccess()) {
            log.info(jwtResult.getCodeEnum().getMsg());
            returnResponse(response, jwtResult.getCodeEnum());
            return false;
        }
        // token验证通过，将用户信息放在request中，供需要用user信息的接口里从token取数据
        Claims claims = jwtResult.getClaims();
//        User user = new User();
//        user.setId(Long.valueOf(claims.getId()));
//        user.setUsername(claims.getSubject());
//        request.setAttribute(USER_INFO, user);
        return true;
    }

    /**
     * token认证不成功时，返回给response
     * @param response HttpServletResponse
     * @param errEnum ResponseCodeEnums
     */
    private void returnResponse(HttpServletResponse response, ResponseCodeEnums errEnum) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.print(JSON.toJSONString(BasicResponseUtils.error(errEnum)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
