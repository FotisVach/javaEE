package com.javaee.fotis.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.javaee.fotis.po.Book;

/**
 * Test class for {@link BookService}
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class TestBookService {

	/** Inject Data access object Layer */
	@Autowired
	BookService bookService;

	/**
	 * Tests {@link BookService#countAll()} & {@link BookService#delete(Long)}
	 */
	@Test
	void test_countAll_and_Delete() {
		Long numberOfBooks = bookService.countAll();
		assertEquals(100L, numberOfBooks);
		bookService.delete(1L);
		assertEquals(numberOfBooks - 1, bookService.countAll());
	}
	
	/**
	 * Tests {@link BookService#create(com.javaee.fotis.po.Book)}
	 */
	@SuppressWarnings("nls")
	@Test
	void test_create() {
		Book book = new Book();
		book.setTitle("adiaforo");
		book.setAuthor("adiaforo");
		book.setIsbn("adiaforo");
		assertTrue(bookService.create(book).getId() > 100);
		bookService.delete(book.getId());
	}

}
