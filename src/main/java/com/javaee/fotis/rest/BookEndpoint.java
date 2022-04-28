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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

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
	@Operation(summary = "Get a book by its identifier")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Book Found", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Book.class)) }),
			  @ApiResponse(responseCode = "204", description = "No book with this ID found", 
			    content = @Content) })
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBook(@PathVariable Long id) {
		Book book = bookService.find(id);
		
		if (book == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(book, HttpStatus.OK);
	}

	/**
	 * Stores a new Book to the DB.
	 * 
	 * @param book
	 * @return The new Book
	 */
	@Operation(summary = "Creates and Stores a new Book")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "New Book saved", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Book.class)) }) })
	@PostMapping()
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		book.setId(null);
		bookService.create(book);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}

	/**
	 * Deletes a book
	 * 
	 * @param id
	 * @return No content status
	 */
	@Operation(summary = "Deletes a book")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "204", description = "Book Deleted", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Book.class)) }),
			  @ApiResponse(responseCode = "204", description = "No book with this ID found", 
			    content = @Content) })
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
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Returns all the books from the DB, or a No_Content response if there are no books
	 * 
	 * @return Books
	 */
	@Operation(summary = "Gets all books from the database")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "One or more Books found", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Book.class)) }),
			  @ApiResponse(responseCode = "204", description = "No book found", 
			    content = @Content) })
	@GetMapping()
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> books = bookService.findAll();
		
		if (books.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	
		return new ResponseEntity<>(books, HttpStatus.OK);
	}

	/**
	 * Returns the existing number of books in the DB.
	 * 
	 * @return The number of Books
	 */
	@Operation(summary = "Returns how many books exist in the database")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Number of books found", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = String.class)) }) })
	@GetMapping("/count")
	public ResponseEntity<Long> countBooks() {
		return new ResponseEntity<>(bookService.countAll(), HttpStatus.OK);
	}
	
	
}
