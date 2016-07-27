/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dreamoval.aml.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

/**
 *
 * @author malike_st
 */
@Component
public class CORSFilter implements Filter {

    /**
     * Method to initialize filter
     * @param filterConfig given to initialize filter
     */
    public void init(FilterConfig filterConfig) {
    }

    /**
     * Method to check and use filters for request
     * @param req given as the ServletRequest type
     * @param res given as ServletResponse type
     * @param chain given as FilterChain
     * @throws IOException given as exception for input/output actions
     * @throws ServletException given as exception for Servlet actions
     */
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        chain.doFilter(req, res);
    }

    /**
     *
     */
    public void destroy() {
    }
}
