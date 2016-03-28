package com.bookshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.bookshop.model.Country;

public interface CountryRepository extends CrudRepository<Country, Integer> {

}
