package com.capgemini.fds.services.withoutMock;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.fds.entities.Address;
import com.capgemini.fds.entities.Category;
import com.capgemini.fds.entities.Item;
import com.capgemini.fds.entities.Restaurant;
import com.capgemini.fds.exceptions.DuplicateRestaurantException;
import com.capgemini.fds.services.IRestaurantService;

@SpringBootTest
class IRestaurantServiceImplTest {

	@Autowired
	private IRestaurantService service;

	@Test
	void testAddShouldReturnRestaurantObject() throws DuplicateRestaurantException {
		Address address = new Address(5, "Srushti", "Kothrud", "10", "Pune", "MH", "India", "431334");
		Category category =new Category(1, "Veg");
		Item item1 = new Item(5, "Manchurian",1,100, category);
		Item item2 = new Item(6, "Paneer",1,150, category);
		Set<Item> items= new HashSet();
		items.add(item1);
		items.add(item2);
		
		Restaurant restaurant = new Restaurant(5,"Ratna","Aishwarysa","8967541212",address, items);
		
		 Restaurant result=service.addRestaurant(restaurant);
		 assertEquals(restaurant.getRestaurantName(),result.getRestaurantName());

	}

	@Test
	void testFindAllRestaurants() {
		List<Restaurant> list = service.viewAllRestaurants();
		assertEquals(list, list);
	}
}




/*
 * Address address = new Address(1, "ABCD", "Rahatani", "5", "Pune", "MH",
 * "India", "411017"); Category category =new Category(1, "Veg"); Category
 * category2= new Category(2,"NonVeg"); Item item1 = new Item(1,
 * "Manchurian",1,100, category); Item item2 = new Item(2, "Fish",1,200,
 * category2); Set<Item> items= new HashSet(); items.add(item1);
 * items.add(item2);
 * 
 * Restaurant restaurant = new
 * Restaurant(1,"Vaishali","Reva"," 8923677542",address, items);
 * 
 * Restaurant result=service.addRestaurant(restaurant);
 * assertEquals(restaurant.getRestaurantName(),result.getRestaurantName());
 */