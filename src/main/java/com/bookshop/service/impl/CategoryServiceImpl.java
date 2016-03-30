package com.bookshop.service.impl;

import java.util.List;

import org.apache.poi.hssf.record.formula.functions.True;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookshop.model.Category;
import com.bookshop.repository.CategoryRepository;
import com.bookshop.service.CategoryService;
import com.google.common.collect.Lists;

@Service("categoryService")
@Repository
@Transactional
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository categoryRepository;
	
	@Transactional
	@Override
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Category> listCategory() {
		return Lists.newArrayList(categoryRepository.findAll());
	}

	@Transactional
	@Override
	public void removeCategory(Integer categoryNo) {
		categoryRepository.delete(categoryNo);
		
	}

	@Transactional(readOnly=true)
	@Override
	public Category getCategoryById(Integer categoryNo) {
		return categoryRepository.findOne(categoryNo);
	}

}
