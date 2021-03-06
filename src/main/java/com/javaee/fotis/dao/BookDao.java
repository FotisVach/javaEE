package com.javaee.fotis.dao;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.javaee.fotis.po.Book;

/**
 * Data access object for {@link Book}
 */
public interface BookDao {

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
