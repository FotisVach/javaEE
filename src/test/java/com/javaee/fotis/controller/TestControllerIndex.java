package com.javaee.fotis.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import com.javaee.fotis.po.Book;
import com.javaee.fotis.service.BookService;

/**
 * 
 */
@SuppressWarnings("nls")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class TestControllerIndex {

	/** Mock Book Service */
	@MockBean
	BookService bookService;

	/**
	 * Assert main scenario
	 */
	@SuppressWarnings("unchecked")
	@Test
	void showAllBooks() {
		List<Book> bookList = Arrays.asList(new Book(), new Book());
		when(bookService.findAll()).thenReturn(bookList);
		Model model = new ExtendedModelMap();
		ControllerIndex controllerIndex = new ControllerIndex();
		controllerIndex.bookService = bookService;
		assertEquals("homePage", controllerIndex.homePage(model));
		List<Book> resultsModel = (List<Book>) model.getAttribute("books"); 
		assertEquals(2, resultsModel.size());
	}
	
	/**
	 * Assert scenario after book deletion
	 */
	@SuppressWarnings("unchecked")
	@Test
	void showAllBooksAfterDeletingABook() {
		List<Book> bookList = Arrays.asList(new Book(), new Book());
		when(bookService.findAll()).thenReturn(bookList);
		Model model = new ExtendedModelMap();
		ControllerIndex controllerIndex = new ControllerIndex();
		controllerIndex.bookService = bookService;
		controllerIndex.deletedFlag = true;
		assertEquals("homePage", controllerIndex.homePage(model));
		List<Book> resultsModel = (List<Book>) model.getAttribute("books"); 
		assertEquals(2, resultsModel.size());
		assertFalse(controllerIndex.deletedFlag);
		assertTrue((boolean) model.getAttribute("deletedFlag"));
	}
	
	/**
	 * Assert scenario after error
	 */
	@SuppressWarnings("unchecked")
	@Test
	void showAllBooksAfterError() {
		List<Book> bookList = Arrays.asList(new Book(), new Book());
		when(bookService.findAll()).thenReturn(bookList);
		Model model = new ExtendedModelMap();
		ControllerIndex controllerIndex = new ControllerIndex();
		controllerIndex.bookService = bookService;
		String errorThrown = "Error thrown";
		controllerIndex.insertErrorMsg = errorThrown;
		assertEquals("homePage", controllerIndex.homePage(model));
		List<Book> resultsModel = (List<Book>) model.getAttribute("books"); 
		assertEquals(2, resultsModel.size());
		assertNull(controllerIndex.insertErrorMsg);
		assertEquals(errorThrown, model.getAttribute("insertErrorMsg"));
	}
	
	/**
	 * Add books successfully
	 */
	@Test
	void addBook_success() {
		ControllerIndex controllerIndex = new ControllerIndex();
		controllerIndex.bookService = bookService;
		assertEquals("redirect:/home", controllerIndex.addBook(new Book()));
		assertNull(controllerIndex.insertErrorMsg);
	}
	
	/**
	 * Add books failed
	 */
	@Test
	void addBook_failed() {
		ControllerIndex controllerIndex = new ControllerIndex();
		controllerIndex.bookService = bookService;
		RuntimeException e = new RuntimeException("Dummy Message");
		when(bookService.create(Mockito.any(Book.class))).thenThrow(e);
		assertEquals("redirect:/home", controllerIndex.addBook(new Book()));
		assertEquals(e.getMessage(),controllerIndex.insertErrorMsg);
	}
	
	/**
	 * Delete book
	 */
	@Test
	void deleteBook() {
		ControllerIndex controllerIndex = new ControllerIndex();
		controllerIndex.bookService = bookService;
		
		assertEquals("redirect:/home", controllerIndex.delete(1L));
		assertTrue(controllerIndex.deletedFlag);
		Mockito.verify(controllerIndex.bookService).delete(1L);
	}

	/**
	 * Show book
	 */
	@Test
	void showBookPage() {
		ControllerIndex controllerIndex = new ControllerIndex();
		controllerIndex.bookService = bookService;
		Model model = new ExtendedModelMap();
		Book dummyBook = new Book();
		long bookId = 123L;
		when(bookService.find(bookId)).thenReturn(dummyBook);
		
		assertEquals("showBookPage", controllerIndex.showBookPage(bookId, model));
		Mockito.verify(controllerIndex.bookService).find(bookId);
		assertEquals(dummyBook, model.getAttribute("book"));
	}
	
	/**
	 * addBookPage
	 */
	@Test
	void addBookPage() {
		ControllerIndex controllerIndex = new ControllerIndex();
		Model model = new ExtendedModelMap();
		
		assertEquals("addBookPage", controllerIndex.addBookPage(model));
		assertTrue(model.getAttribute("book") instanceof Book);
	}
	
}
