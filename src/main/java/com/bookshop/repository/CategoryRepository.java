package com.bookshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.bookshop.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
