package com.yc.common.result;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by 村子里最好的剑 on 2020/08/21.
 */
public class CreateResponse {

    /**
     * 输出对象成json string
     *
     * @param response - HttpServletResponse
     * @param data     - 输出对象
     * @param callback - callback方法名
     */
    public static void responseObject(ServletResponse response, Object data, String callback) {
        String content = data == null ? "" : JSON.toJSONString(data, SerializerFeature.WriteNullNumberAsZero);
        String jsonStr;
        response.setContentType("text/html;charset=UTF-8");
        if (!StringUtils.isBlank(callback)) {
            jsonStr = callback + "(" + content + ");";
        } else {
            jsonStr = content;
        }
        try {
            response.getWriter().write(jsonStr);
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
