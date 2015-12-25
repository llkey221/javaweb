package com.study.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class AllFilter
 */
@WebFilter("/AllFilter")
public class AllFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AllFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("springstudy执行前");
		HttpServletRequest req=(HttpServletRequest)request;
		
		System.out.println("当前请求的Url是："+req.getServerName()+":"+req.getServerPort()+req.getRequestURI());
		// pass the request along the filter chain
		chain.doFilter(request, response);
		System.out.println("springstudy执行后");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		String filterName=fConfig.getFilterName();
		System.out.println("当前正在执行的FilterName："+filterName);
		
		Enumeration<String> initParameters=fConfig.getInitParameterNames();
		
		while(initParameters.hasMoreElements()){
			String name=initParameters.nextElement();
			String value=fConfig.getInitParameter(name);
			System.out.println(String.format("%s= %s", name,value));
		}
	}

}
