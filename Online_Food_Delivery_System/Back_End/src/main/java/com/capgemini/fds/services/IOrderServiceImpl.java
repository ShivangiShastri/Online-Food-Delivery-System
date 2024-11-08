package com.capgemini.fds.services;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.fds.entities.Customer;
import com.capgemini.fds.entities.OrderDetails;
import com.capgemini.fds.entities.Restaurant;
import com.capgemini.fds.exceptions.DuplicateOrderException;
import com.capgemini.fds.repositories.IOrderRepository;

@Service("service2")
public class IOrderServiceImpl implements IOrderService{
	
	@Autowired
	private IOrderRepository repository;

	@Override
	@Transactional
	public OrderDetails addOrder(OrderDetails order) throws DuplicateOrderException{
		if (validateOrder(order)) {
			try {
				OrderDetails result = repository.save(order);
				return (result.getOrderId() > 0) ? result : null;
			} catch (ConstraintViolationException e) {
				throw new DuplicateOrderException("Order already exists.");
			}
		}
		return order;
	}
	
	
	private boolean validateOrder(OrderDetails order) {
		if (!order.getOrderStatus().matches("[A-Za-z]+")) {
			return false;
		}
		return true;
	}

	public OrderDetails updateOrder(OrderDetails order) {
		
		return null;
	}

	public OrderDetails removeOrder(OrderDetails order) {
		
		return null;
	}

	@Override
	public OrderDetails viewOrderById(int orderId) {
		return null;
	}
	
	@Override
	public List<OrderDetails> viewAllOrders() {
		return repository.findAll();
	}

	public List<OrderDetails> viewAllOrdersByRestaurant(Restaurant resName) {
	
		return null;
	}

	public List<OrderDetails> viewAllOrdersByCustomer(Customer customer) {
		
		return null;
	}

}