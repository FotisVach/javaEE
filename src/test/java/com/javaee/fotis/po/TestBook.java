package com.javaee.fotis.po;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test for {@link Book}
 */
class TestBook {

	/**
	 * Test equals implementation from lombok
	 */
	@Test
	void testEquals() {
		Book book1 = new Book();
		book1.setId(1L);

		Book book2 = new Book();
		book2.setId(1L);

		assertEquals(book1, book2);
	}

	/**
	 * Test equals implementation from lombok
	 */
	@Test
	void testNotEquals() {
		Book book1 = new Book();
		book1.setId(1L);

		Book book2 = new Book();
		book2.setId(2L);

		assertNotEquals(book1, book2);
	}

	/**
	 * Test equals implementation from lombok
	 */
	@Test
	void testHashcode_same() {
		Book book1 = new Book();
		book1.setId(1L);

		Book book2 = new Book();
		book2.setId(1L);

		assertEquals(book1.hashCode(), book2.hashCode());
	}

	/**
	 * Test equals implementation from lombok
	 */
	@Test
	void testtestHashcode_different() {
		Book book1 = new Book();
		book1.setId(1L);

		Book book2 = new Book();
		book2.setId(2L);

		assertNotEquals(book1.hashCode(), book2.hashCode());
	}

}
