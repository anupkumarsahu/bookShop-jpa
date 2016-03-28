package com.bookshop.service;

import java.util.List;

import com.bookshop.model.Book;

public interface BookService {
	
	public List<Book> listBook();
	public void saveBook(Book book);
	public void removeBook(Integer bookNo);
    public Book getBookById(Integer bookNo);
    public List<Book> listNewReleases();
    public List<Book> listUpdatedBooks();
    public List<Book> listTopTitles();
    public void updateHits(Integer bookNo);
    public void notifyCustomersByMail(Book book);

}
