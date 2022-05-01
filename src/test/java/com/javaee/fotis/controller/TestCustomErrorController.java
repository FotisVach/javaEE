package com.javaee.fotis.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.servlet.RequestDispatcher;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

/**
 * Test class for {@link CustomErrorController}
 */
@SuppressWarnings("nls")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class TestCustomErrorController {

	/**
	 * Test for {@link CustomErrorController#handleError(javax.servlet.http.HttpServletRequest, Model)}
	 */
	@Test
	void testHandleError() {
		MockHttpServletRequest mockServletRequest = new MockHttpServletRequest();
		String errorCode = "some error code";
		String errorUri = "some error Uri";
		String errorException = "some error Exception";
		mockServletRequest.setAttribute(RequestDispatcher.ERROR_STATUS_CODE, errorCode);
		mockServletRequest.setAttribute(RequestDispatcher.ERROR_REQUEST_URI, errorUri);
		mockServletRequest.setAttribute(RequestDispatcher.ERROR_EXCEPTION, errorException);
		Model model = new ExtendedModelMap();

		CustomErrorController customErrorController = new CustomErrorController();
		assertEquals("errorPage", customErrorController.handleError(mockServletRequest, model));
		assertEquals(errorCode, model.getAttribute("ERROR_STATUS_CODE"));
		assertEquals(errorUri, model.getAttribute("ERROR_REQUEST_URI"));
		assertEquals(errorException, model.getAttribute("ERROR_EXCEPTION"));
	}


}
