package com.javaee.fotis.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaee.fotis.dao.BookDao;
import com.javaee.fotis.po.Book;

/**
 * Implementation of {@link BookService}
 */
@Transactional(Transactional.TxType.SUPPORTS)
@Service
public class BookServiceImpl implements BookService {
	/** Need to inject Book dao */
	@Autowired
	BookDao bookDao;

	@Override
	public Book find(@NotNull Long id) {
		return bookDao.find(id);
	}

	@Transactional(Transactional.TxType.REQUIRED)
	@Override
	public Book create(@NotNull Book book) {
		return bookDao.create(book);
	}

	@Transactional(Transactional.TxType.REQUIRED)
	@Override
	public void delete(@NotNull Long id) {
		bookDao.delete(id);
	}

	@Override
	public List<Book> findAll() {
		return bookDao.findAll();
	}

	@Override
	public Long countAll() {
		return bookDao.countAll();
	}

}
