package com.bookshop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="CATEGORIES")
public class Category implements Serializable{
	@Id
    @GeneratedValue
    @Column(name="CATEGORYNO")
    private Integer categoryNo;
    @Column(name="CATEGORY")
    @NotEmpty(message="Category is mandatory")
    private String category;
    @Column(name="DESCRIPTION")
    @NotEmpty(message="Category description is mandatory")
    private String description;
	public Integer getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(Integer categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
