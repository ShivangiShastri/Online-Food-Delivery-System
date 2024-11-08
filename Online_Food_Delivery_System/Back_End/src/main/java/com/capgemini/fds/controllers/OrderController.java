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

import com.capgemini.fds.entities.OrderDetails;
import com.capgemini.fds.exceptions.DuplicateOrderException;
import com.capgemini.fds.exceptions.NoSuchOrderException;
import com.capgemini.fds.services.IOrderService;

@RestController
@RequestMapping(path = "orders")
public class OrderController {
	@Autowired
	private IOrderService service;

	// http://localhost:9090/OnlineFoodDeliveryApp/orders - - Method Post
	@PostMapping(consumes = "application/json")
	public ResponseEntity<OrderDetails> addOrder(@RequestBody OrderDetails order) throws  DuplicateOrderException {
		OrderDetails result = service.addOrder(order);
		ResponseEntity<OrderDetails> response = null;
		if(result !=null) {
			response = new ResponseEntity<OrderDetails>(HttpStatus.CREATED);
			return response;
		}
		throw new DuplicateOrderException("Order already exists");
	}
	
	//http://localhost:9090/OnlineFoodDeliveryApp/orders - - Method Get
    @GetMapping(produces = "application/json")
    public List<OrderDetails> getAllOrders() {
        List<OrderDetails> result = service.viewAllOrders();
        return result;
    }
	
	@ExceptionHandler(value=DuplicateOrderException.class)
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR, reason="Order does not exists.")
	public void handleDuplicateOrderException() {
		
	}

}