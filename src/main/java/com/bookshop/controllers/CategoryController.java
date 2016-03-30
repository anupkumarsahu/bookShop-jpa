package com.bookshop.controllers;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookshop.model.Category;
import com.bookshop.service.CategoryService;

@Controller
@RequestMapping("/admin")
public class CategoryController {
	final Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/manageCategories")
	public String showManageCategories(Model uiModel) {
		uiModel.addAttribute("category", new Category());
		uiModel.addAttribute("categoryList", categoryService.listCategory());
		return "manageCategories";
	}

	@RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
	public String saveCategory(Model uiModel, @ModelAttribute("category") Category category,
			@Valid Category categoryValid, BindingResult result) {
		
		if (result.hasErrors()){
			return "manageCategories";
		} else {
			try {
				categoryService.saveCategory(category);
				return "redirect:/admin/manageCategories";
			} catch (ConstraintViolationException exp){
				uiModel.addAttribute("dbError", exp.getMessage());
				return "manageCategories";
			}
		}
	}
	
	@RequestMapping("/deleteCategory/{categoryNo}")
	public String deleteCategory(Model uiModel, @PathVariable("categoryNo") Integer categoryNo){
		try{
			categoryService.removeCategory(categoryNo);
			return "redirect:/admin/manageCategories";
		} catch (DataIntegrityViolationException exp) {
			uiModel.addAttribute("dbError", "Cannot delete a parent row.");
			uiModel.addAttribute("category", new Category());
			return "manageCategories";
		}
	}
	
	@RequestMapping("/editCategory/{categoryNo}")
	public String editCategory(Model uiModel, @PathVariable("categoryNo") Integer categoryNo){
		uiModel.addAttribute("category", categoryService.getCategoryById(categoryNo));
		return "manageCategories";
	}

}
