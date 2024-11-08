package com.capgemini.fds.services;

import java.util.List;

import com.capgemini.fds.entities.Category;
import com.capgemini.fds.exceptions.DuplicateCategoryException;

public interface ICategoryService {

	public Category addCategory(Category category) throws DuplicateCategoryException;
	public Category updateCategory(Category category);
	public Category removeCategory(Category category);
	public Category viewCategoryById(int categoryId);
	public List<Category> viewAllCategory();
	
}