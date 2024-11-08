package com.capgemini.fds.services;

import java.util.List;

import com.capgemini.fds.entities.Customer;
import com.capgemini.fds.entities.OrderDetails;
import com.capgemini.fds.entities.Restaurant;
import com.capgemini.fds.exceptions.DuplicateOrderException;

public interface IOrderService {

	public OrderDetails addOrder(OrderDetails order) throws DuplicateOrderException;
	public OrderDetails updateOrder(OrderDetails order);
	public OrderDetails removeOrder(OrderDetails order);
	public OrderDetails viewOrderById(int orderId);
	public List<OrderDetails> viewAllOrders();
	public List<OrderDetails> viewAllOrdersByRestaurant(Restaurant resName);
	public List<OrderDetails> viewAllOrdersByCustomer(Customer customer);
	
	
	
}