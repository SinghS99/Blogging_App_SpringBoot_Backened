package com.zensar.blog.services;

import java.util.List;

import com.zensar.blog.payloads.CategoryDto;

public interface CategoryService {
	
   //create
	CategoryDto createCategory(CategoryDto categoryDto);
	
   //update
	CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId );
	
   //get	
	CategoryDto getCategory(Integer categoryId);
	
   //get All	
	List<CategoryDto>getCategories();
	
   //delete	
	void deleteCategory(Integer categoryId);

}
