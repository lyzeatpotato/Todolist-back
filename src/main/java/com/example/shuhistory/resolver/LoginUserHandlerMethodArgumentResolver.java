package com.example.shuhistory.resolver;

import com.example.shuhistory.annotation.LoginUser;
import com.example.shuhistory.entity.User;
import com.example.shuhistory.interceptor.AuthInterceptor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 参数的解析器，将登录用户对象注入到接口里
 */
@Component
public class LoginUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(User.class) && parameter.hasParameterAnnotation(LoginUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        // 获取登录用户信息
        Object object = webRequest.getAttribute(AuthInterceptor.USER_INFO, RequestAttributes.SCOPE_REQUEST);
        if (object == null) return null;
        return (User) object;
    }
}
