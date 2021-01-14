package com.yc.common.filter;

import javax.servlet.http.HttpServletRequest;

import com.yc.common.exception.BaseException;
import com.yc.common.result.ErrorResult;
import com.yc.common.result.ResponseURICache;
import com.yc.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Description 处理返回的结果
 * @Author 村子里最好的剑
 * @Date 2020-10-30 15:28
 */
@ControllerAdvice
@Slf4j
public class ResponseResultHandle implements ResponseBodyAdvice<Object> {

    //是否请求包含了包装注解标记，没有就直接返回，不需要重写返回体
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        //判断请求是否有包装标记
        return ResponseURICache.getInstance().get(request.getRequestURI());
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        //进入返回体重写格式
        if(body instanceof ErrorResult){
            //返回值异常，作包装处理
            ErrorResult errorResult = (ErrorResult) body;
            return Result.failure(errorResult.getCode(), errorResult.getMessage(), errorResult.getErrors());
        }
        return Result.success(body);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorResult handleRuntimeException(Exception e){
        ErrorResult errorResult = new ErrorResult();
        errorResult.setCode(500);
        errorResult.setMessage("服务器异常");
        errorResult.setErrors(e.getClass().getName());
        log.info("【服务器异常】：{}", errorResult);
        return errorResult;
    }

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public ErrorResult baseException(BaseException e){
        ErrorResult errorResult = new ErrorResult();
        errorResult.setCode(Integer.valueOf(e.getCode()));
        errorResult.setMessage(e.getDefaultFriendlyMessage());
        errorResult.setErrors(e.getClass().getName());
        return errorResult;
    }

}
