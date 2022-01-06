package com.javaee.fotis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Index Controller
 */
@SuppressWarnings("nls")
@Controller
public class ControllerIndex {
	
	/** The home Page URL */
	private static final String homePageUrl = "/home";
	
	/**
	 * Home Page Controller
	 * 
	 * @return The homePage
	 */
	@GetMapping(homePageUrl)
	public String homePage() {
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
