package com.capgemini.fds.services.withMock;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capgemini.fds.exceptions.DuplicateItemException;
import com.capgemini.fds.exceptions.NoSuchItemFoundException;
import com.capgemini.fds.entities.Category;
import com.capgemini.fds.entities.Item;
import com.capgemini.fds.repositories.IItemRepository;
import com.capgemini.fds.services.IItemService;

@SpringBootTest
class IItemServiceImplTestWithMock {

	@Autowired
	private IItemService service;
	
	@MockBean
	private IItemRepository repository;
	
	@Test
	void testAddItemShouldReturnItemObject() throws DuplicateItemException, NoSuchItemFoundException {
		Category category = new Category(2,"Non-Veg");
		Item item = new Item(2,"Fish",1,150,category);
	
		Optional<Item> expected = Optional.of(item);
		when(repository.findById(2)).thenReturn(expected);
		
		Item result = service.viewItem(item.getItemId());
		assertEquals(item, result);
	}
	
	@Test
	void testViewAllItems() {
		List<Item> list = service.viewAllItems();
		assertEquals(list, list);
		
}
	
}