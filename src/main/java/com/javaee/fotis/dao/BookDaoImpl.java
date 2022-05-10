package com.javaee.fotis.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Repository;

import com.javaee.fotis.po.Book;

/**
 * Implementation of {@link BookDao}
 */
@Repository
public class BookDaoImpl implements BookDao {

	/** Persistence Context manager */
	@PersistenceContext
	EntityManager em;

	/**
	 * Fetches a book by its primary key
	 * 
	 * @param id
	 * @return Book
	 */
	@Override
	public Book find(@NotNull Long id) {
		return em.find(Book.class, id);
	}

	/**
	 * Persists a Book
	 * 
	 * @param book
	 * @return Book
	 */
	@Override
	public Book create(@NotNull Book book) {
		em.persist(book);
		return book;
	}

	/**
	 * Deletes a Book by id
	 * 
	 * @param id
	 */
	@Override
	public void delete(@NotNull Long id) {
		em.remove(em.getReference(Book.class, id));
	}

	/**
	 * Returns all Books in the DB
	 * 
	 * @return Books
	 */
	@Override
	public List<Book> findAll() {
		TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b ORDER BY b.id", Book.class); //$NON-NLS-1$
		return query.getResultList();
	}

	/**
	 * Counts the number of Books in the DB.
	 * 
	 * @return number of Books
	 */
	@Override
	public Long countAll() {
		TypedQuery<Long> query = em.createQuery("SELECT count(b) FROM Book b", Long.class); //$NON-NLS-1$
		return query.getSingleResult();
	}

}
