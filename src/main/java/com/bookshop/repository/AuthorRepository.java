package com.bookshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.bookshop.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

}
