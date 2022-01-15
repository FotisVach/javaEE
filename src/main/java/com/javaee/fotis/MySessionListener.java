package com.javaee.fotis;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * PoC Servlet Session Listener
 */
@WebListener()
@SuppressWarnings("nls")
public class MySessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		Date date = new Date();
		se.getSession().getServletContext().log(">>> Session Created: " + new Timestamp(date.getTime()));
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		Date date = new Date();
		se.getSession().getServletContext().log(">>> Session Destroyed: " + new Timestamp(date.getTime()));
	}
	
	

}
