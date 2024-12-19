package com.ecom.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.ecom.model.Category;

@Component
public interface CategoryService {

	
	public Category saveCategory(Category category);
	
	public Boolean existCategory(String name);
	
	public List<Category> getAllCategory();
	
	public Boolean deletCategory(int id);
	
	public Category getCategoryById(int id);
	
	public List<Category> getAllActiveCategory();

	public Page<Category> getAllCategoryPagination(Integer pageNo, Integer pageSize);


}
