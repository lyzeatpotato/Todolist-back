package com.example.shuhistory.utils;

import com.example.shuhistory.enums.ResponseCodeEnums;
import com.example.shuhistory.vo.BasicResponse;

/**
 * 基本响应工具类，简化controller返回响应的代码。
 */
public class BasicResponseUtils {
    /**
     * 返回自定义响应（包含数据）
     */
    public static BasicResponse info(Integer code, String message, Object data) {
        return new BasicResponse(code, message, data);
    }

    /**
     * 成功并返回数据
     */
    public static BasicResponse success(Object data) {
        BasicResponse response = new BasicResponse();
        response.setCode(ResponseCodeEnums.OK.getCode());
        response.setMessage(ResponseCodeEnums.OK.getMsg());
        response.setData(data);
        return response;
    }

    /**
     * 成功但不返回数据
     */
    public static BasicResponse success() {
        BasicResponse response = new BasicResponse();
        response.setCode(ResponseCodeEnums.OK.getCode());
        response.setMessage(ResponseCodeEnums.OK.getMsg());
        return response;
    }

    /**
     * 出错并返回枚举类型错误信息
     */
    public static BasicResponse error(ResponseCodeEnums responseCodeEnums) {
        BasicResponse response = new BasicResponse();
        response.setCode(responseCodeEnums.getCode());
        response.setMessage(responseCodeEnums.getMsg());
        return response;
    }
}
