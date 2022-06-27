package com.zensar.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.blog.entities.Category;
import com.zensar.blog.exceptions.ResourceNotFoundException;
import com.zensar.blog.payloads.CategoryDto;
import com.zensar.blog.repositories.CategoryRepo;
import com.zensar.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
  //To update category
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category cat=this.modelmapper.map(categoryDto, Category.class);
		Category addedcat=this.categoryRepo.save(cat);
		
		return this.modelmapper.map(addedcat, CategoryDto.class);
	}
  //To Update category
	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		
		Category cat=this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("Category", "CategoryId",categoryId));
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		Category updatedcat=this.categoryRepo.save(cat);
		
		return this.modelmapper.map(updatedcat, CategoryDto.class );
	}
  //to get one by one category
	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category cat=this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));
		return this.modelmapper.map(cat, CategoryDto.class);
		
		
	}
  //to get all category
	@Override
	public List<CategoryDto> getCategories() {
		List<Category> categories=this.categoryRepo.findAll();
		List<CategoryDto>catDtos=categories.stream().
		                 map((cat)->this.modelmapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		
		return catDtos;
	}
   //To delete category
	@Override
	public void deleteCategory(Integer categoryId) {
		
	Category cat=this.categoryRepo.findById(categoryId)
			.orElseThrow(()->new ResourceNotFoundException("Category", "categoryId",categoryId));
	this.categoryRepo.delete(cat);
		
	}

}
