package com.capgemini.fds.services.withoutMock;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.fds.exceptions.DuplicateItemException;
import com.capgemini.fds.entities.Category;
import com.capgemini.fds.entities.Item;
import com.capgemini.fds.services.IItemService;

@SpringBootTest
class IItemServiceImplTest {

	@Autowired
	private IItemService service;
	
	@Test
	void testShouldReturnItemObject() throws DuplicateItemException {
		Category category = new Category(1,"Veg");
		Item item = new Item(1,"Manchurian",1,200,category);
		
		Item result = service.addItem(item);
		assertEquals(item.getItemName(),result.getItemName());
	}
	
	@Test
	void testViewAllItems() {
		List<Item> list = service.viewAllItems();
		assertEquals(list, list);
}
	
}