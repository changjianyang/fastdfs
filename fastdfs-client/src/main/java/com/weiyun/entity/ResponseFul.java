package com.weiyun.entity;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author YcJ
 * @Description
 * @Date 2020/2/18 12:58
 */
public class ResponseFul implements Serializable {
    public static final int OK = 0;

    public static String success(Object data, String msg) {
        JSONObject result = new JSONObject();
        result.put("error_code", OK);
        result.put("date", new Date());
        result.put("msg", msg);
        result.put("data", data);
        return result.toJSONString();
    }

    public static String fail(int code,String msg,Object data) {
        JSONObject result = new JSONObject();
        result.put("error_code", code);
        result.put("date", new Date());
        result.put("msg", msg);
        result.put("data", data);
        return result.toJSONString();
    }
}

