package com.yc.common.utils;

import java.util.HashMap;
import java.util.List;

/**
 * ajax输出对象
 * <p>
 * {code:1, message:"", data:{}}
 * </p>
 * <p>
 * {code:-1, message:""}
 * </p>
 *
 * @author 村子里最好的剑
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class AjaxResp extends HashMap<String, Object> {

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * 返回代码的key值
     */
    public static final String RET_KEY = "code";

    /**
     * 返回文字消息的key值
     */
    public static final String MSG_KEY = "message";

    /**
     * 返回数据的key值
     */
    public static final String DATA_KEY = "data";

    /**
     * 成功RET值
     */
    public static final Integer RET_OK = 1;

    /**
     * 默认的服务器异常值
     */
    public static final Integer RET_UNCATCHED = -9;

    /**
     * 默认的服务器异常消息
     */
    public static final String MSG_UNCATCHED = "服务器异常";

    /**
     * 只返回成功标志
     * 
     * @return AjaxResp
     */
    public static AjaxResp success() {
        return json(RET_OK);
    }

    /**
     * 成功，且传入键值对
     * 
     * @param key key
     * @param value value
     * @return AjaxResp
     */
    public static AjaxResp success(List<String> key, List<Object> value) {
        return json(key, value, RET_OK);
    }

    /**
     * 错误，错误码及错误提示
     * 
     * @param code 错误码
     * @param msg 提示
     * @return AjaxResp
     */
    public static AjaxResp error(Integer code, String msg) {
        return json(MSG_KEY, msg, code);
    }

    /**
     * 加入键值对
     * 
     * @param key key
     * @param value value
     * @return AjaxResp
     */
    public AjaxResp json(String key, Object value) {
        this.put(key, value);
        return this;
    }

    /**
     * 加入数据项
     * 
     * @param value value
     * @return AjaxResp
     */
    public AjaxResp jsonData(Object value) {
        this.put(DATA_KEY, value);
        return this;
    }

    /**
     * 加入多个键值对
     * 
     * @param keys list key
     * @param values list value
     * @return AjaxResp
     */
    public AjaxResp json(List<String> keys, List<Object> values) {
        if (keys == null) {
            return this;
        }
        for (int i = 0; i < keys.size(); i++) {
            this.put(keys.get(i), values.get(i));
        }
        return this;
    }

    /**
     * new json object对象
     * 
     * @return AjaxResp
     */
    public static AjaxResp json() {
        return new AjaxResp();
    }

    /**
     * 加入返回码
     * 
     * @param code code
     * @return AjaxResp
     */
    public static AjaxResp json(Integer code) {
        return json().json(RET_KEY, code);
    }

    /**
     * 加入返回码及键值对
     * 
     * @param key key
     * @param value value
     * @param code 返回码
     * @return AjaxResp
     */
    public static AjaxResp json(String key, Object value, Integer code) {
        return json(code).json(key, value);
    }

    /**
     * 加入返回码及多个键值对
     * 
     * @param keys list key
     * @param values list value
     * @param code 返回码
     * @return AjaxResp
     */
    public static AjaxResp json(List<String> keys, List<Object> values, Integer code) {
        AjaxResp obj = json(code);
        return obj.json(keys, values);
    }

}
