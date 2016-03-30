package com.bookshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.bookshop.model.Book;
import com.bookshop.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Integer> {

}
