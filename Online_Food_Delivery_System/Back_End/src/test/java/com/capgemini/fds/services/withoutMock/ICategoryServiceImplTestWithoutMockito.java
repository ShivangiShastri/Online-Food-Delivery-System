package com.capgemini.fds.services.withoutMock;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.fds.entities.Category;
import com.capgemini.fds.exceptions.DuplicateCategoryException;
import com.capgemini.fds.services.ICategoryService;

@SpringBootTest
class ICategoryServiceImplTestWithoutMockito {

	@Autowired
	private ICategoryService service;

	@Test
	void testAddCategoryShouldReturnCategoryObject() throws DuplicateCategoryException {
		Category category = new Category(2, "Non Veg");

		Category result = service.addCategory(category);
		assertEquals(category.getCategoryName(), result.getCategoryName());
	}

	@Test
	void testViewAllCategory() {
		List<Category> list = service.viewAllCategory();
		assertEquals(list, list);
	}

	
	void testUpdateCategory() {
		fail("Not yet implemented");
	}

	
	void testRemoveCategory() {
		fail("Not yet implemented");
	}


	void testViewCategory() {
		fail("Not yet implemented");
	}

}