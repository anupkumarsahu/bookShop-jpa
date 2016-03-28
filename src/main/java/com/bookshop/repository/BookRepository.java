package com.bookshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.bookshop.model.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

}
