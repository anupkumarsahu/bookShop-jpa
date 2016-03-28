package com.bookshop.service;

import java.util.List;

import com.bookshop.model.Country;

public interface CountryService {
	public List<Country> findAll();
	public Country findById(Integer id);
	public Country save(Country country);
	public void delete(Integer id);
}
