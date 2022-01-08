package com.javaee.fotis.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.javaee.fotis.po.Book;
import com.javaee.fotis.service.BookService;

/**
 * PoC of servlet
 */
@WebServlet(urlPatterns = "/servlet/book")
public class ServletFindBook extends HttpServlet {
	
	/** Inject bookService */
	@Autowired
	BookService bookService;

	/**	*/
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("nls")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = new Long(req.getParameter("id")); //$NON-NLS-1$
		
		Book book = bookService.find(id);
		if (book == null) {
			throw new RuntimeException("Bad Request - Book id not found: " + id);
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/showBookPageServlet.jsp");
		req.setAttribute("book", book);
		dispatcher.forward(req, resp);
	}

}
