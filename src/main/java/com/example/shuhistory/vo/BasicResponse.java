package com.example.shuhistory.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 基本响应类，规定了返回前端的数据格式
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasicResponse {

    private Integer code;
    private String message;
    private Object data;
}
