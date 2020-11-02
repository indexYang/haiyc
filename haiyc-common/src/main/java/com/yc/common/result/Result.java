package com.yc.common.result;

import java.io.Serializable;

/**
 * @Description 返回结果
 * @Author 村子里最好的剑
 * @Date 2020-10-30 15:26
 */
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code;

    private String message;

    private Object data;

    public Result() {
    }

    public Result(ResultCodeEnum resultCode, Object data) {
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
    }

    public static Result success(){
        Result result = new Result();
        result.setResultCode(ResultCodeEnum.SUCCESS);
        return result;
    }

    private void setResultCode(ResultCodeEnum resultCode) {
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public static Result success(Object data){
        Result result = new Result();
        result.setResultCode(ResultCodeEnum.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result failure(ResultCodeEnum resultCode){
        Result result = new Result();
        result.setResultCode(resultCode);
        return result;
    }

    public static Result failure(ResultCodeEnum resultCode, Object data){
        Result result = new Result();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }

    public static Result failure(Integer code, String message, Object errors) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setData(errors);
        return result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
