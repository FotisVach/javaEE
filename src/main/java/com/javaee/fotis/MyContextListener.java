package com.javaee.fotis;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * PoC Servlet Context Listener
 */
@SuppressWarnings("nls")
@WebListener
public class MyContextListener implements ServletContextListener {

	/**
	 * Current System time when app start running
	 */
	Long startTime;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		startTime = System.currentTimeMillis();
		sce.getServletContext().log(">>>Custom Servlet Context Listener");
		sce.getServletContext().setSessionTimeout(1);
		sce.getServletContext().setAttribute("projectVersion", "0.0.1-SNAPSHOT");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("\n>>>Stopping server"); //$NON-NLS-1$
		Long secondsPassed = (System.currentTimeMillis() - startTime) / 1000;
		System.out.println(">>>Custom Servlet Context Listener Destroyed. App was running for: " + secondsPassed);
	}

}
