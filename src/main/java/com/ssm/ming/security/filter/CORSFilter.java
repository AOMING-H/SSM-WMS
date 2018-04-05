package com.ssm.ming.security.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Wenming.Huang
 * @date 2018-03-07
 * @version 1.0
 */
public class CORSFilter implements Filter {

    @Override
    public void init(FilterConfig var1) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
            ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        filterChain.doFilter(servletRequest, servletResponse);
    }
    
    @Override
    public void destroy() {
    }
}
