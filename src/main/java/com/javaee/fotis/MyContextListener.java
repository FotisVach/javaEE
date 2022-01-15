package com.javaee.fotis;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * PoC Servlet Context Listener
 */
@WebListener
public class MyContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext().log(">>>Custom Servlet Context Listener"); //$NON-NLS-1$
		sce.getServletContext().setSessionTimeout(1);
	}
	
}
