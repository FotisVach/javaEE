package com.javaee.fotis.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import javax.validation.constraints.NotNull;

import com.javaee.fotis.po.Book;

/**
 * Data access object for {@link Book}
 */
@Transactional(TxType.SUPPORTS)
public class BookDao {

	/** The entity manager */
	@PersistenceContext
	EntityManager em;

	/**
	 * Fetches a book by its primary key
	 * 
	 * @param id
	 * @return Book
	 */
	public Book find(@NotNull Long id) {
		return em.find(Book.class, id);
	}

	/**
	 * Persists a Book
	 * 
	 * @param book
	 * @return Book
	 */
	@Transactional(TxType.REQUIRED)
	public Book create(@NotNull Book book) {
		em.persist(book);
		return book;
	}

	/**
	 * Deletes a Book by id
	 * 
	 * @param id
	 */
	@Transactional(TxType.REQUIRED)
	public void delete(@NotNull Long id) {
		em.remove(em.getReference(Book.class, id));
	}

	/**
	 * Returns all Books in the DB
	 * 
	 * @return Books
	 */
	public List<Book> findAll() {
		TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b ORDER BY b.title", Book.class); //$NON-NLS-1$
		return query.getResultList();
	}

	/**
	 * Counts the number of Books in the DB.
	 * 
	 * @return number of Books
	 */
	public Long countAll() {
		TypedQuery<Long> query = em.createQuery("SELECT count(b) FROM Book b", Long.class); //$NON-NLS-1$
		return query.getSingleResult();
	}

}
