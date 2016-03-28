package com.bookshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bookshop.model.Book;
import com.bookshop.repository.BookRepository;
import com.bookshop.service.BookService;
import com.google.common.collect.Lists;

public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Transactional
	@Override
	public List<Book> listBook() {
		return Lists.newArrayList(bookRepository.findAll());
	}

	@Transactional
	@Override
	public void saveBook(Book book) {
		bookRepository.save(book);
		
	}

	@Override
	public void removeBook(Integer bookNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Book getBookById(Integer bookNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> listNewReleases() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> listUpdatedBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> listTopTitles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateHits(Integer bookNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyCustomersByMail(Book book) {
		// TODO Auto-generated method stub
		
	}

}
