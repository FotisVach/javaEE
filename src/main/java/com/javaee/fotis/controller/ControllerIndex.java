package com.javaee.fotis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaee.fotis.po.Book;
import com.javaee.fotis.service.BookService;

/**
 * Index Controller
 */
@SuppressWarnings("nls")
@Controller
public class ControllerIndex {
	
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
		return "homePage";
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
