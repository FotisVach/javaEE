package com.javaee.fotis;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * PoC Servlet Request Listener
 */
@WebListener
@SuppressWarnings("nls")
public class MyRequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		Date date = new Date();
		sre.getServletContext().log(">>> Request Destroyed: " + new Timestamp(date.getTime()));
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		Date date = new Date();
		sre.getServletContext().log(">>> Request Initialized: " + new Timestamp(date.getTime()));
	}

}
