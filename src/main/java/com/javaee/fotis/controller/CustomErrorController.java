package com.javaee.fotis.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Custom error Controller
 */
@Controller
public class CustomErrorController implements ErrorController {

	/**
	 * Custom error Controller
	 * 
	 * @param request
	 * @param model
	 * @return error page
	 */
	@SuppressWarnings("nls")
	@RequestMapping("/error")
	public String handleError(HttpServletRequest request, Model model) {
		model.addAttribute("ERROR_STATUS_CODE", request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
		model.addAttribute("ERROR_REQUEST_URI", request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI));
		model.addAttribute("ERROR_EXCEPTION", request.getAttribute(RequestDispatcher.ERROR_EXCEPTION));
		// do something like logging
		return "errorPage"; //$NON-NLS-1$
	}
}
