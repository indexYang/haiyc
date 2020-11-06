package com.yc.shiro;

import com.yc.common.result.CreateResponse;
import com.yc.common.result.ResultCodeEnum;
import com.yc.common.utils.AjaxResp;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthcShiroFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception{
        if (isLoginRequest(request, response)) {
            if (isLoginSubmission(request, response)) {
                return executeLogin(request, response);
            } else {
                return true;
            }
        } else {
            // option请求处理
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;
            if (req.getMethod().equals(RequestMethod.OPTIONS.name())) {
                resp.setStatus(HttpStatus.OK.value());
                return true;
            }

            // 取消重定向，直接返回结果
            returnTokenInvalid((HttpServletRequest)request, (HttpServletResponse)response);
            return false;
        }
    }

    /**
     * 替代shiro重定向
     *
     * @param req
     * @param resp
     * @throws IOException
     */
    private void returnTokenInvalid(HttpServletRequest req, HttpServletResponse resp){
        CreateResponse.responseObject(resp, AjaxResp.error(ResultCodeEnum.USER_UNLOG.code(), ResultCodeEnum.USER_UNLOG.message()), "");
    }
}