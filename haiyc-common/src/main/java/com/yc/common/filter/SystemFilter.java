package com.yc.common.filter;

import com.yc.common.constant.Constant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(1)
@Component
public class SystemFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 设置CORS跨域参数
        this.setResponseCors(request, response);
        filterChain.doFilter(request,response);
    }

    /**
     * 功能描述: 设置CORS跨域请求参数<br>
     *
     */
    private void setResponseCors(HttpServletRequest request, HttpServletResponse response) {
        String origin = request.getHeader(Constant.CORS_REQ_ORIGIN);
        if (StringUtils.isNotBlank(origin)) {
            response.setHeader(Constant.CORS_RES_ORIGIN, Constant.CORS_RES_ORIGIN_VALUE);
            response.setHeader(Constant.CORS_CREDENTIALS, Constant.CORS_TRUE);
            response.setHeader(Constant.CORS_RES_METHODS, Constant.CORS_RES_METHODS_VALUE);
            response.setHeader(Constant.CORS_RES_HEADER, Constant.CORS_RES_HEADER_VALUE);
            response.setHeader(Constant.CORS_RES_MAX_AGE, Constant.CORS_RES_MAX_AGE_VALUE);
        }
    }

    @Override
    public void destroy() {
    }
}
