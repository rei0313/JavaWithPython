package com.rei.javawithpython.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class IpAddressFilter extends OncePerRequestFilter {
    private static final Logger LOG = LoggerFactory.getLogger(IpAddressFilter.class);
    private static final ThreadLocal<String> ipAddressThreadLocal = new ThreadLocal<>();


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {

        String ip = request.getRemoteAddr();
        ipAddressThreadLocal.set(ip);
        chain.doFilter(request, response);
        LOG.info("IP位址： " + ip);
    }
    // 在想要取得ip的地方呼叫
    public static String getIpAddress() {
        return ipAddressThreadLocal.get();
    }


}