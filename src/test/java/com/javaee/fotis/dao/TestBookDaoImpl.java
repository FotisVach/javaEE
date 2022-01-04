package com.javaee.fotis.dao;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.javaee.fotis.po.Book;

/**
 * Test class for {@link BookDao}
 */
@SpringBootTest
class TestBookDaoImpl {
	/** Inject Data access object Layer */
	@Autowired
	BookDao sut;

	/**
	 * Lifecycle tes.
	 */
	@Transactional
	@Test
	void test() {
		// Test that no books exists
		assertEquals(0L, sut.countAll());
		assertEquals(0L, sut.findAll().size());
		// Create a book
		Book b = new Book();
		String bookTitle = "A brief history of time"; //$NON-NLS-1$
		String bookauthor = "Hawking Stephen"; //$NON-NLS-1$
		b.setTitle(bookTitle);
		b.setAuthor(bookauthor);
		sut.create(b);
		
		Long bookKey = b.getId();
		// Check created book
		assertNotNull(bookKey);
		
		// Find created book
		Book newBook = sut.find(bookKey);
		// Check the found book
		assertEquals(bookTitle, newBook.getTitle());
		assertEquals(bookauthor, newBook.getAuthor());
		
		// Test that counts books
		assertEquals(1L, sut.countAll());
		assertEquals(1L, sut.findAll().size());
		
		// Delete the new book
		sut.delete(bookKey);
		
		// Test that no books exists
		assertEquals(0L, sut.countAll());
		assertEquals(0L, sut.findAll().size());
	}

}
