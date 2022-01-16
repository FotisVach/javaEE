package com.javaee.fotis.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * PoC for filter
 */
@WebFilter(urlPatterns = "*")
public class DummyFilter implements Filter {
	
	/** Servlet Context */
	@Autowired
	ServletContext context; 

	@SuppressWarnings("nls")
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		context.log("Request made to: " + ((HttpServletRequest) request).getRequestURI());
		chain.doFilter(request, response);
	}

}
