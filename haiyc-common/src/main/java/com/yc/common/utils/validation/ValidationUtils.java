package com.yc.common.utils.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.hibernate.validator.HibernateValidator;

/**
 * @Description: 遵循JSR303规范的Validation框架实现的验证工具类
 * @author 村子里最好的剑
 * @date 2020年10月30日
 */
public class ValidationUtils {
    /**
     * Validator
     */
    // 默认校验Bean中所有字段
    // 快速返回校验失败的信息
    private static final Validator FASTVALIDATOR = Validation.byProvider(HibernateValidator.class).configure()
            .addProperty("hibernate.validator.fail_fast", "true").buildValidatorFactory().getValidator();

    /**
     * 私有构造器，此类仅作为静态工具类，不需实例化
     */
    private ValidationUtils() {

    }

    /**
     * 校验Bean对象是否所有字段的值都是合法的
     *
     * @param t 被验证对象
     * @param groups 组
     * @return true - 验证成功;false - 验证失败或参数为空
     */
    public static <T> boolean isValid(T t, Class<?>... groups) {
        if (null == t) {
            return false;
        }
        return FASTVALIDATOR.validate(t).isEmpty();
    }

    /**
     * 校验Bean对象是否所有字段的值都是合法的
     * 这边用的是快速校验，只要有一个属性不通过立马返回
     * @param
     * @param t 被验证对象
     * @param groups 组
     * @return 当验证正确的情况下返回空字符串;当验证失败的情况下返回错误原因 ;
     */
    public static <T> ViolationMessage validate(T t, Class<?>... groups) {
        Set<ConstraintViolation<T>> constraintViolations = FASTVALIDATOR.validate(t, groups);
        if (!constraintViolations.isEmpty()) {
            ViolationMessage vm = new ViolationMessage();
            for (ConstraintViolation<T> cv : constraintViolations) {
                vm = new ViolationMessage();
                vm.setProperty(cv.getPropertyPath().toString());
                vm.setMessage(cv.getMessageTemplate());
            }
            return vm;
        }
        return null;
    }
}

