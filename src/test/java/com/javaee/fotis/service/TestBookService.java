package com.javaee.fotis.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

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
	void test() {
		Long numberOfBooks = bookService.countAll();
		assertEquals(100L, numberOfBooks);
		bookService.delete(1L);
		assertEquals(numberOfBooks - 1, bookService.countAll());
	}

}
