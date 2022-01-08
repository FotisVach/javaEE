package com.javaee.fotis.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * PoC of servlet
 */
@WebServlet(urlPatterns = {"/servlet/poc", "*.servletpoc"})
public class ServletPoc extends HttpServlet {

	/**	*/
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("Hello Servlet"); //$NON-NLS-1$
	}


}
