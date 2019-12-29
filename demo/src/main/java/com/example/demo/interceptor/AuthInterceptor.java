package com.example.demo.interceptor;

import com.example.demo.constant.ErrorCode;
import com.example.demo.model.RestResponse;
import com.example.demo.utils.TokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * <Description> 定义拦截器<br>
 */

public class AuthInterceptor implements HandlerInterceptor {

    /**
     * CODE_CN <br>
     */
    private static final String CODE_CN = "UTF-8";

    @Autowired
    private TokenUtil tokenUtil;

    /**
     * Description: 方法前拦截<br>
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws IOException
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String token = request.getHeader("token");
        if (!StringUtils.isEmpty(token)) {
            Map<String, String> map = tokenUtil.getUserName(token);
            if (map != null) {
                request.setAttribute("username", map.get("username"));
                request.setAttribute("realname", map.get("realname"));
                request.setAttribute("token", token);
                System.out.println("合格不需要拦截，放行");
                return true;
            }
        }

        RestResponse restResponse = new RestResponse(ErrorCode.Forbiden);
        response.setCharacterEncoding(CODE_CN);
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.getWriter().write(restResponse.toJsonString());
        return false;
    }

    /**
     * Description: 身份校验<br>
     *
     * @param request  请求
     * @param response 响应
     * @return <br>
     * @throws IOException <br>
     */
    private boolean checkAuthMethod(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return true;
    }

    /**
     * Description: 方法执行结束拦截<br>
     *
     * @param request      请求
     * @param response     响应
     * @param handler      方法
     * @param modelAndView 视图对象
     * @throws Exception <br>
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * Description: 方法后拦截<br>
     *
     * @param request  请求
     * @param response 响应
     * @param handler  方法
     * @param ex       异常
     * @throws Exception <br>
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
