package com.bookshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookshop.model.Country;
import com.bookshop.repository.CountryRepository;
import com.bookshop.service.CountryService;
import com.google.common.collect.Lists;

@Service("countryService")
@Repository
@Transactional
public class CountryServiceImpl implements CountryService{

	@Autowired
	private CountryRepository countryRepository;
	
	@Transactional(readOnly=true)
	@Override
	public List<Country> findAll() {
		return Lists.newArrayList(countryRepository.findAll());
	}

	@Transactional(readOnly=true)
	@Override
	public Country findById(Integer id) {
		return countryRepository.findOne(id);
	}

	@Override
	public Country save(Country country) {
		return countryRepository.save(country);
	}

	@Override
	public void delete(Integer id) {
		countryRepository.delete(id);;
	}

}
