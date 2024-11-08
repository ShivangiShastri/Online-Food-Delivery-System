package com.capgemini.fds.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.fds.entities.Category;
import com.capgemini.fds.entities.Customer;
import com.capgemini.fds.exceptions.DuplicateCategoryException;
import com.capgemini.fds.services.ICategoryService;

@RestController
@RequestMapping(path = "categories")
public class CategoryController {

	@Autowired
	private ICategoryService service;

	// http://localhost:9090/OnlineFoodDeliveryApp/categories - - Method Post
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) throws DuplicateCategoryException {
		Category result = service.addCategory(category);
		ResponseEntity<Category> response = null;
		if (result !=null) {
			response = new ResponseEntity<Category>(HttpStatus.CREATED);
			return response;
		}
		throw new DuplicateCategoryException("Category does not exists.");
	}

	//http://localhost:/9090/OnlineFoodDeliveryApp/customers
		@GetMapping(produces = "application/json")
		public List<Category> getAllCategories() {
			List<Category> result = service.viewAllCategory();
			return result;
		}
	
	@ExceptionHandler(value = DuplicateCategoryException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Category does not exists.")
	public void handleDuplicateCategoryException() {

	}
}