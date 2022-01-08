package com.javaee.fotis.servlet;

import java.io.IOException;
import java.util.List;

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
@WebServlet(urlPatterns = "/servlet/books")
public class ServletFindAllBooks extends HttpServlet {
	
	/** Inject bookService */
	@Autowired
	BookService bookService;

	/**	*/
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Book> books = bookService.findAll();
		for (Book book : books) {
			resp.getWriter().println(book.toString());
		}
	}


}
