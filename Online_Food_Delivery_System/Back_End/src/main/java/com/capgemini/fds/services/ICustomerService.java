package com.capgemini.fds.services;

import java.util.List;

import com.capgemini.fds.entities.Customer;
import com.capgemini.fds.exceptions.DuplicateCustomerException;
import com.capgemini.fds.exceptions.NoSuchCustomerException;

public interface ICustomerService {

	public Customer addCustomer(Customer customer) throws DuplicateCustomerException;
	public Customer updateCustomer(Customer customer);
	public boolean removeCustomer(int customerId) throws NoSuchCustomerException;
	public Customer viewCustomerById(int id ) throws NoSuchCustomerException;
	public List<Customer> viewAllCustomer(); 
}