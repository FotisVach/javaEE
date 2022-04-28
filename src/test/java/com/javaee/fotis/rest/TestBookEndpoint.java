package com.javaee.fotis.rest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.javaee.fotis.dao.BookDao;
import com.javaee.fotis.po.Book;
import com.javaee.fotis.service.BookService;

/**
 * Test class for {@link BookEndpoint}
 */
@SuppressWarnings("nls")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class TestBookEndpoint {
	
	/** Inject Data access object Layer */
	@Autowired
	BookDao sut;
	/** Random port the app is deployed during test */
	@LocalServerPort
	private int port;

	/** Inject Rest Template for test */
	@Autowired
	private TestRestTemplate restTemplate;

	/** Number of Books in the DB - initial number in DB = 100 books */
	private Long numberOfBooks = 100L;

	/**
	 * Test Method for {@link BookEndpoint#createBook(Book)}
	 */
	@Test
	void test_createBook() {
		BookEndpoint ep = new BookEndpoint();
		ep.bookService = mock(BookService.class);
		Book book = new Book();
		book.setId(111L);
		
		ResponseEntity<Book> re = ep.createBook(book);
		assertEquals(HttpStatus.OK, re.getStatusCode());
		assertNull(re.getBody().getId());
		verify(ep.bookService).create(any(Book.class));
	}

	/**
	 * Test Method for {@link BookEndpoint#deleteBook(Long)}
	 */
	@Test
	void test_deleteBook() {
		// Test functionality when the book is not exists
		ResponseEntity<String> response = restTemplate.exchange("http://localhost:" + port + "/api/books/1001", 
				HttpMethod.DELETE, null, String.class);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		assertTrue(response.getBody().contains("Book id not found - 1001"));
		// Test functionality when the book is not exists
		BookEndpoint ep = new BookEndpoint();
		ep.bookService = mock(BookService.class);
		Long id = 666L;
		when(ep.bookService.find(id)).thenReturn(new Book());
		
		assertEquals(HttpStatus.NO_CONTENT, ep.deleteBook(id).getStatusCode());
		verify(ep.bookService).find(id);
		verify(ep.bookService).delete(id);
	}

	/**
	 * Test Method for {@link BookEndpoint#countBooks()}
	 */
	@Test
	void test_countBooks() {
		assertEquals(numberOfBooks.longValue(),
				restTemplate.getForObject("http://localhost:" + port + "/api/books/count", Long.class));
	}

	/**
	 * Test Method for {@link BookEndpoint#getBooks()}
	 */
	@Test
	void test_getBooks() {
		Book[] books = restTemplate.getForObject("http://localhost:" + port + "/api/books", Book[].class);
		assertEquals(numberOfBooks.longValue(), books.length);
		assertEquals(1L, books[0].getId());
		assertEquals(100L, books[99].getId());
	}
	
	/**
	 * Test Method for {@link BookEndpoint#getBooks()}
	 */
	@Test
	void test_getBooks2() {
		BookEndpoint ep = new BookEndpoint();
		ep.bookService = mock(BookService.class);
		when(ep.bookService.findAll()).thenReturn(new ArrayList<Book>());
		
		assertSame(HttpStatus.NO_CONTENT, ep.getBooks().getStatusCode());
	}

	/**
	 * Test Method for {@link BookEndpoint#getBook(Long)}
	 */
	@Test
	void test_getBook() {
		Book book = restTemplate.getForObject("http://localhost:" + port + "/api/books/1", Book.class);
		assertEquals(1L, book.getId());
		assertEquals("Alika Robbins", book.getAuthor());

		book = restTemplate.getForObject("http://localhost:" + port + "/api/books/101", Book.class);
		assertNull(book);
	}

}
