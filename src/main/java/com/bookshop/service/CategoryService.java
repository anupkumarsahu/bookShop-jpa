package com.bookshop.service;

import java.util.List;

import com.bookshop.model.Category;

public interface CategoryService{
	public Category saveCategory(Category category);
	public List<Category> listCategory();
	public void removeCategory(Integer categoryNo);
	public Category getCategoryById(Integer categoryNo);
}
