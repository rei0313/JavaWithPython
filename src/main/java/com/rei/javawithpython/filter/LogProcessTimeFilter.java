package com.rei.javawithpython.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class LogProcessTimeFilter extends OncePerRequestFilter {

    private static final Logger LOG = LoggerFactory.getLogger(LogProcessTimeFilter.class);


    @Override
    protected void doFilterInternal(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, jakarta.servlet.FilterChain filterChain) throws jakarta.servlet.ServletException, IOException {
        long startTime = System.currentTimeMillis();
        filterChain.doFilter(request, response);
        long processTime = System.currentTimeMillis() - startTime;

        LOG.info("耗費" + processTime + "ms");
    }
}
