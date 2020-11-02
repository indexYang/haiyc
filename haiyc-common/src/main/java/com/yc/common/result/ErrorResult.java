package com.yc.common.result;

/**
 * @Description
 * @Author 村子里最好的剑
 * @Date 2020-10-30 15:26
 */
public class ErrorResult {

    private Integer code;

    private String message;

    private Object errors;

    public  ErrorResult(){

    }

    public ErrorResult(Integer code,  String message, Object errors){
        this.code = code;
        this.message = message;
        this.errors = errors;
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

    public Object getErrors() {
        return errors;
    }

    public void setErrors(Object errors) {
        this.errors = errors;
    }

}

