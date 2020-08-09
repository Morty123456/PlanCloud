package org.hg.hystrix.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

/**
 * @author: wzh
 * @time: 2020/8/9 7:47
 * @description:
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(httpResponse);

        String url = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
//        System.out.println(url);
        Object user = httpRequest.getSession().getAttribute("username");
        if (url.startsWith("/static") || url.equals("/index") || url.startsWith("/login")) {
            //在白名单中的url,放行访问
            filterChain.doFilter(httpRequest, httpResponse);
            return;
        }
        else if (user != null) {
//            System.out.println("user不为空");
            //若为登录状态 放行访问
            filterChain.doFilter(httpRequest, httpResponse);
            return;
        } else {
            //否则默认访问index接口
//            System.out.println("还未登陆");
            wrapper.sendRedirect("/index");
        }
    }

    @Override
    public void destroy() {

    }
}

