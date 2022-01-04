package com.javaee.fotis.rest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpEntity;

import com.javaee.fotis.dao.BookDao;
import com.javaee.fotis.po.Book;

/**
 * Test class for {@link BookEndpoint}
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SuppressWarnings("nls")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class TestBookEndpoint {

	// /** Endpoint under Test */
	// @Autowired
	// BookEndpoint endPoint;

	// @Autowired
	// private MockMvc mockMvc;

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
	private Long numberOfBooks;

	/**
	 * Test Method for {@link BookEndpoint#createBook(Book)}
	 */
	@Test
	@Order(1)
	void test_createBook() {
		numberOfBooks = new Long(sut.findAll().size());
		Book book = new Book();
		book.setAuthor("Charles Bukowski");
		restTemplate.postForObject("http://localhost:" + port + "/api/books/", new HttpEntity<Book>(book), Book.class);

		numberOfBooks++;
	}

	/**
	 * Test Method for {@link BookEndpoint#deleteBook(Long)}
	 */
	@Test
	@Order(2)
	void test_deleteBook() {
		restTemplate.delete("http://localhost:" + port + "/api/books/1001");
		assertEquals(100, sut.findAll().size());

		numberOfBooks--;
	}

	/**
	 * Test Method for {@link BookEndpoint#countBooks()}
	 */
	@Test
	void test_countBooks() {
		assertTrue(restTemplate.getForObject("http://localhost:" + port + "/api/books/count", Long.class)
				.equals(numberOfBooks.longValue()));
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
