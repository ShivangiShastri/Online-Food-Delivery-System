package com.capgemini.fds.services;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.fds.entities.Customer;
import com.capgemini.fds.exceptions.DuplicateCustomerException;
import com.capgemini.fds.exceptions.NoSuchCustomerException;
import com.capgemini.fds.repositories.ICustomerRepository;

@Service("customerservice")
public class ICustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository repository;

	@Override

	@Transactional
	public Customer addCustomer(Customer customer) throws DuplicateCustomerException {
		if (validateCustomer(customer)) {
			try {
				Customer result = repository.save(customer);
				return (result.getCustomerId() > 0) ? result : null;
			} catch (ConstraintViolationException e) {
				throw new DuplicateCustomerException("Customer already exists.");
			}
		}
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer viewCustomerById(int id) throws NoSuchCustomerException {
		Optional<Customer> result = repository.findById(id);

		Customer customer = null;
		if (result.isPresent()) {
			customer = result.get();
		} else {
			throw new NoSuchCustomerException("Student Not Found.");
		}
		return customer;
	}

	@Override
	public List<Customer> viewAllCustomer() {
		return repository.findAll();
	}

	private boolean validateCustomer(Customer customer) {
		if (!customer.getFirstName().matches("[A-Za-z]+")) {
			return false;
		} else if (!customer.getLastName().matches("[A-Za-z]+")) {
			return false;
		} else if (!customer.getMobileNumber().matches("[0-9]{10}")) {
			return false;
		} else if (!customer.getEmail().matches("^[a-zA-Z_-]+[a-zA-Z0-9_!#$%&`*+/=?{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
			return false;
		}

		return true;
	}

	@Override
	public boolean removeCustomer(int customerId) throws NoSuchCustomerException {
		Optional<Customer> result = repository.findById(customerId);
		if (result.isPresent()) {
			repository.delete(result.get());
			return true;
		}
		throw new NoSuchCustomerException("Customer not found");
	}
}