package com.capgemini.fds.services;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.fds.entities.Category;
import com.capgemini.fds.exceptions.DuplicateCategoryException;
import com.capgemini.fds.repositories.ICategoryRepository;

@Service("categoryservice")
public class ICategoryServiceImpl implements ICategoryService {

	@Autowired
	private ICategoryRepository repository;

	@Override
	@Transactional // (propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public Category addCategory(Category category) throws DuplicateCategoryException {
		if (validateCategory(category)) {
			try {
				Category result = repository.save(category);
				return (result.getCategoryId() > 0) ? result : null;
			} catch (ConstraintViolationException e) {
				throw new DuplicateCategoryException("Category already exists.");
			}
		}
		return category;
	}

	private boolean validateCategory(Category category) {
		if (!category.getCategoryName().matches("[A-Za-z ]+")) {
			return false;
		}
		return true;
	}

	public Category updateCategory(Category category) {

		return null;
	}

	public Category removeCategory(Category category) {

		return null;
	}

	
	public Category viewCategoryById(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Category> viewAllCategory() {
		return repository.findAll();
	}


}