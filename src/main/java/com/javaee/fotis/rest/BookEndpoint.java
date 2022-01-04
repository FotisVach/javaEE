package com.javaee.fotis.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaee.fotis.po.Book;
import com.javaee.fotis.service.BookService;

/**
 * Book Rest Endpoint
 */
@RestController
@RequestMapping("/api/books")
public class BookEndpoint {

	/** Need to inject the Book Service */
	@Autowired
	BookService bookService;

	/**
	 * Returns a Book for the DB.
	 * 
	 * @param id
	 * @return a Book
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBook(@PathVariable Long id) {
		Book book = bookService.find(id);
		
		if (book == null) {
			return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	/**
	 * Stores a new Book to the DB.
	 * 
	 * @param book
	 * @return The new Book
	 */
	@PostMapping()
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		book.setId(null);
		bookService.create(book);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	/**
	 * Deletes a book
	 * 
	 * @param id
	 * @return No content status
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable Long id) {
		// Try to find Book
		Book bookToBeDeleted = bookService.find(id);
		// If it does not exist throw a RuntimeException
		if (bookToBeDeleted == null) {
			return new ResponseEntity<>("Book id not found - " + id, HttpStatus.NOT_FOUND); //$NON-NLS-1$
		}
		// Else Delete Book
		bookService.delete(id);
		// We could also change the response to a String confirmation msg
		return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Returns all the books from the DB, or a No_Content response if there are no books
	 * 
	 * @return Books
	 */
	@GetMapping()
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> books = bookService.findAll();
		
		if (books.size() == 0) {
			return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
		}
	
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	/**
	 * Returns the existing number of books in the DB.
	 * 
	 * @return The number of Books
	 */
	@GetMapping("/count")
	public ResponseEntity<Long> countBooks() {
		return new ResponseEntity<Long>(bookService.countAll(), HttpStatus.OK);
	}
	
	
}
