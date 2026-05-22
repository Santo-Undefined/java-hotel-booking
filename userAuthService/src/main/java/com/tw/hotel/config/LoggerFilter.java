package com.tw.hotel.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoggerFilter implements Filter {
    private final Logger logger = LoggerFactory.getLogger("Request Logger");

    @Override
    public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        long start = System.currentTimeMillis();

        try {
            chain.doFilter(req, response);
        } finally {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            long end = System.currentTimeMillis();
            long duration = end - start;
            logger.info("{} {} {} {} ms", request.getMethod(), request.getRequestURI(), httpResponse.getStatus(), duration);
        }
    }
}
