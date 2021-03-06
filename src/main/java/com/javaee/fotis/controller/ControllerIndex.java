package com.javaee.fotis.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaee.fotis.enums.Language;
import com.javaee.fotis.po.Book;
import com.javaee.fotis.service.BookService;

/**
 * Index Controller
 */
@SuppressWarnings("nls")
@Controller
public class ControllerIndex {

	/** Flag for displaying message on delete */
	Boolean deletedFlag = false;
	
	/** Insert error message */
	String insertErrorMsg;

	/** Need to inject the Book Service */
	@Autowired
	BookService bookService;

	/** The home Page URL */
	static final String HOME_PAGE_URL = "/home";

	/**
	 * Home Page Controller
	 * 
	 * @param model
	 * @return The homePage
	 */
	@RequestMapping(HOME_PAGE_URL)
	public String homePage(Model model) {
		List<Book> books = bookService.findAll();
		model.addAttribute("books", books);
		if (deletedFlag) {
			model.addAttribute("deletedFlag", true);
			deletedFlag = false;
		}
		if (insertErrorMsg != null) {
			model.addAttribute("insertErrorMsg", insertErrorMsg);
			insertErrorMsg = null;
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
	 * Go to Page to add a new Book.
	 * 
	 * @param model
	 * @return the addBookPage
	 */
	@GetMapping("/addBook")
	public String addBookPage(Model model) {
		model.addAttribute("book", new Book());
		return "addBookPage";
	}

	/**
	 * Saves a new Book
	 *
	 * @param book
	 * @return to home Page
	 */
	@PostMapping("/addBook")
	public String addBook(@ModelAttribute("book") Book book) {
		try {
			bookService.create(book);
		} catch (Exception e) {
			// TODO : log this - fix app lgging
			e.printStackTrace();
			insertErrorMsg = e.getMessage();
		}
		return "redirect:" + HOME_PAGE_URL;
	}

	/**
	 * Redirects to /home
	 * 
	 * @return The homePage
	 */
	@GetMapping("/")
	public String contextRootPage() {
		return "redirect:" + HOME_PAGE_URL;
	}
	
	/**
	 * List of all Languages
	 * 
	 * @return List of all Languages
	 */
	@ModelAttribute("allLanguages")
	public List<Language> getAllLanguages() {
		return Arrays.asList(Language.values());
	}

}
