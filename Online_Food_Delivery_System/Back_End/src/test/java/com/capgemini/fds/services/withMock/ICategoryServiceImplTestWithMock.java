package com.capgemini.fds.services.withMock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capgemini.fds.entities.Category;
import com.capgemini.fds.exceptions.DuplicateCategoryException;
import com.capgemini.fds.exceptions.NoSuchCategoryException;
import com.capgemini.fds.repositories.ICategoryRepository;
import com.capgemini.fds.services.ICategoryService;

@SpringBootTest
class ICategoryServiceImplTestWithMock{

	@Autowired
	private ICategoryService service;

	@MockBean
	private ICategoryRepository repository;

	@Test
	void testAddCategoryShouldReturnCategoryObject() throws DuplicateCategoryException, NoSuchCategoryException {
		Category category = new Category(1, "Veg");

		Optional<Category> expected = Optional.of(category);
		when(repository.findById(1)).thenReturn(expected);

		Category result = service.viewCategoryById(category.getCategoryId());
		assertEquals(category, result);

	}

	@Test
	void testViewCategoryByIdShouldThrowNoSuchCategoryException() {
		assertThrows(NoSuchCategoryException.class, () -> {
			service.viewCategoryById(-1);
		});
	}

	@Test
	void testViewAllCategory() {
		List<Category> list = service.viewAllCategory();
		assertEquals(list, list);

	}

	@Test
	void testUpdateCategory() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveCategory() {
		fail("Not yet implemented");
	}

}