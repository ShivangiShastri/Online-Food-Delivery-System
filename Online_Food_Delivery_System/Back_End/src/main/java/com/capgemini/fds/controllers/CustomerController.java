package com.capgemini.fds.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.fds.entities.Customer;
import com.capgemini.fds.exceptions.DuplicateCustomerException;
import com.capgemini.fds.exceptions.NoSuchCustomerException;
import com.capgemini.fds.services.ICustomerService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "customers")
public class CustomerController {

	@Autowired
	private ICustomerService service;

	
	  // http://localhost:/9090/OnlineFoodDeliveryApp/customers
	  
	  @PostMapping(consumes = "application/json") public ResponseEntity<Customer>
	  addCustomer(@RequestBody Customer customer) throws DuplicateCustomerException
	  {
	  
	  Customer result = service.addCustomer(customer); ResponseEntity<Customer>
	  response = null; if (result != null) { response = new
	  ResponseEntity<Customer>(HttpStatus.CREATED); return response; } throw new
	  DuplicateCustomerException("Customer already exists"); }
	 

	// http://localhost:/9090/OnlineFoodDeliveryApp/customers
	@GetMapping(produces = "application/json")
	public List<Customer> getAllCustomers() {
		List<Customer> result = service.viewAllCustomer();
		return result;
	}

	// http://localhost:/9090/OnlineFoodDeliveryApp/customers/byId
	@GetMapping(path = "byId/{customerId}", produces = "application/json")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") int customerId)
			throws NoSuchCustomerException {
		Customer result = service.viewCustomerById(customerId);
		ResponseEntity<Customer> response = null;
		if (result != null) {
			response = new ResponseEntity<Customer>(result, HttpStatus.OK);
			return response;
		}
		throw new NoSuchCustomerException("Customer Not Found.");
	}

	// http://localhost:/9090/OnlineFoodDeliveryApp/customers/byId
	@DeleteMapping(path = "byId/{customerId}")
	public boolean deleteCustomer(@PathVariable("customerId") int customerId) throws NoSuchCustomerException {
		return service.removeCustomer(customerId);
	}

	@ExceptionHandler(value = DuplicateCustomerException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Customer Id already exists.")
	public void handleDuplicateCustomer() {

	}

	@ExceptionHandler(value = NoSuchCustomerException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Customer Not Found.")
	public void handleNoSuchCustomer() {

	}
}