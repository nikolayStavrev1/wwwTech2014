package com.wwwTech2014.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		if(req.getRequestURI().startsWith(req.getContextPath() + "/libs")){
			chain.doFilter(req, response);
			return;
		}
		
		if(req.getSession().getAttribute("User") == null && 
				!req.getRequestURI().equals(req.getContextPath() + "/login") &&
				!req.getRequestURI().equals(req.getContextPath() + "/register")){
			resp.sendRedirect(req.getContextPath() + "/login");
		} else if(req.getSession().getAttribute("User") != null && 
				(req.getRequestURI().equals(req.getContextPath() + "/login") ||
				req.getRequestURI().equals(req.getContextPath() + "/register"))) {
			resp.sendRedirect(req.getContextPath());
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
