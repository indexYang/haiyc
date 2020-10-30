package com.yc.controller.user;

import com.yc.common.utils.result.ResponseResult;
import com.yc.common.utils.result.ResponseURICache;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Description 拦截缓存需要统一返回格式的方法
 * @Author 村子里最好的剑
 * @Date 2020-10-30 15:27
 */
@Component
public class ResponsResultInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("dasdasd");
        //请求的方法
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Class<?> clazz = handlerMethod.getBeanType();
            Method method = handlerMethod.getMethod();
            String rui = request.getRequestURI();
            if(null == ResponseURICache.getInstance().get(rui)) {
                if(clazz.isAnnotationPresent(ResponseResult.class)){
                    ResponseURICache.getInstance().set(rui, true);
                }else if(method.isAnnotationPresent(ResponseResult.class)){
                    ResponseURICache.getInstance().set(rui, true);
                }else{
                    ResponseURICache.getInstance().set(rui, false);
                }
            }
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception)
            throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView view)
            throws Exception {
        // TODO Auto-generated method stub

    }

}
