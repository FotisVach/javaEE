package com.javaee.fotis.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.javaee.fotis.po.Book;

/**
 * {@link Book} Service Layer
 */
public interface BookService {
	
	/**
	 * Fetches a book by its primary key
	 * 
	 * @param id
	 * @return Book
	 */
	Book find(@NotNull Long id);

	/**
	 * Persists a Book
	 * 
	 * @param book
	 * @return Book
	 */
	Book create(@NotNull Book book);

	/**
	 * Deletes a Book by id
	 * 
	 * @param id
	 */
	void delete(@NotNull Long id);

	/**
	 * Returns all Books in the DB
	 * 
	 * @return Books
	 */
	List<Book> findAll();

	/**
	 * Counts the number of Books in the DB.
	 * 
	 * @return number of Books
	 */
	Long countAll();

}
