package com.jonzhou.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter")
public class EncodingFilter implements Filter {
    protected String encoding = null;

    // 过滤的方法
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding(this.encoding);
        response.setContentType("text/html;charset="+this.encoding);
        chain.doFilter(request, response);
    }

    // 初始化处理
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
        encoding=filterConfig.getInitParameter("encoding");
    }

    // 销毁方法
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        encoding = null;
    }

}
