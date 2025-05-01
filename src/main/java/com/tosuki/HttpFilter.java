package com.tosuki;

import jakarta.servlet.*;

import java.io.IOException;

public class HttpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("Http default filter instantied and registered!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Intercepting a http request");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
