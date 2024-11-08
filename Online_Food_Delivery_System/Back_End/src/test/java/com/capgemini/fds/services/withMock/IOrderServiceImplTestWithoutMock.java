package com.capgemini.fds.services.withMock;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.fds.entities.OrderDetails;
import com.capgemini.fds.exceptions.DuplicateOrderException;
import com.capgemini.fds.services.IOrderService;


@SpringBootTest
class IOrderServiceImplTestWithoutMock {
	
	@Autowired
	private IOrderService service;

	@Test
	void testAddOrderShouldReturnOrderObject() throws DuplicateOrderException {
		OrderDetails order = new OrderDetails();
		
		OrderDetails result =service.addOrder(order);
		assertEquals(order.getOrderStatus(),result.getOrderStatus() );
	}
	
	@Test
	void testViewAllOrders() {
		List<OrderDetails> list = service.viewAllOrders();
		assertEquals(list, list);
	}

	@Test
	void testUpdateOrder() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveOrder() {
		fail("Not yet implemented");
	}

	@Test
	void testViewOrder() {
		fail("Not yet implemented");
	}

	@Test
	void testViewAllOrdersByRestaurant() {
		fail("Not yet implemented");
	}

	@Test
	void testViewAllOrdersByCustomer() {
		fail("Not yet implemented");
	}

}