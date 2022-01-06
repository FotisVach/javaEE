package com.javaee.fotis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaee.fotis.po.Book;
import com.javaee.fotis.service.BookService;

/**
 * Index Controller
 */
@SuppressWarnings("nls")
@Controller
public class ControllerIndex {

	/** Flag for displaying message on delete */
	private Boolean deletedFlag = false;

	/** Need to inject the Book Service */
	@Autowired
	private BookService bookService;

	/** The home Page URL */
	private static final String homePageUrl = "/home";

	/**
	 * Home Page Controller
	 * 
	 * @param model
	 * @return The homePage
	 */
	@RequestMapping(homePageUrl)
	public String homePage(Model model) {
		List<Book> books = bookService.findAll();
		model.addAttribute("books", books);
		if (deletedFlag == true) {
			model.addAttribute("deletedFlag", true);
			deletedFlag = false;
		}
		return "homePage";
	}

	/**
	 * Delete book process
	 * 
	 * @param bookId
	 * @return homePage
	 */
	@RequestMapping("deleteBook")
	public String delete(@RequestParam("bookId") Long bookId) {
		// delete the user
		bookService.delete(bookId);
		deletedFlag = true;
		// re-direct to /home
		return "redirect:/home";
	}

	/**
	 * Show Book Page Controller
	 * 
	 * @param bookId
	 * @param model
	 * @return The showBookPage
	 */
	@GetMapping("showBookPage")
	public String showBookPage(@RequestParam("bookId") Long bookId, Model model) {
		// Get user from DB
		Book book = bookService.find(bookId);
		// Set user as o model attribute to pre-populate form
		model.addAttribute(book);
		return "showBookPage";
	}

	/**
	 * Redirects to /home
	 * 
	 * @return The homePage
	 */
	@GetMapping("/")
	public String contextRootPage() {
		return "redirect:" + homePageUrl;
	}

}
