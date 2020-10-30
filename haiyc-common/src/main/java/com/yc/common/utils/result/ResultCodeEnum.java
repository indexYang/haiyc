package com.yc.common.utils.result;

/**
 * @Description 返回code枚举类型
 * @Author 村子里最好的剑
 * @Date 2020-10-30 13:40
 */
public enum ResultCodeEnum {
    //成功
    SUCCESS(1,"成功"),
    FAIL(2,"失败"),
    //参数错误100-199
    USER_UNLOG(10001, "未登录，受限资源需要登录才能访问"),
    HASLOGIN_OTHER(10002, "该账户已在其他设备登录，请注意安全"),
    ACCOUNT_NOT_EXISTING(10005, "用户不存在"),
    PASSWORD_ERR(10006, "密码错误"),
    ACCOUNT_LOCK(10007, "账号已锁定，请联系管理员");

    private Integer code;

    private String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }
}
