package com.capgemini.fds.services.withMock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capgemini.fds.entities.Address;
import com.capgemini.fds.entities.Customer;
import com.capgemini.fds.exceptions.DuplicateCustomerException;
import com.capgemini.fds.exceptions.NoSuchCustomerException;
import com.capgemini.fds.repositories.ICustomerRepository;
import com.capgemini.fds.services.ICustomerService;

@SpringBootTest
class ICustomerServiceImplTestwithMock {

	@Autowired
	private ICustomerService service;

	@MockBean
	private ICustomerRepository repository;

	@Test
	void testFindCustomerByIdShouldReturnCustomerObject() throws DuplicateCustomerException, NoSuchCustomerException {
		Address address = new Address(6, "Villa", "Koregaon", "15", "Pune", "MH", "India", "423781");
		Customer customer = new Customer(6, "Reva", "Bose", "9822953122", "m#3si11@abc.com", "Female", "22", address);

		
		Optional<Customer> expected = Optional.of(customer);
		when(repository.findById(6)).thenReturn(expected);

		Customer result = service.viewCustomerById(customer.getCustomerId());
		assertEquals(customer, result);

	}

	@Test
	void testFindStudentByIdShouldThrowNoSuchStudentException() {
		assertThrows(NoSuchCustomerException.class, () -> {
			service.viewCustomerById(-1);
		});
	}

	@Test
	void testFindAllCustomersShouldReturnListOfCustomers() {
		List<Customer> list = service.viewAllCustomer();
		assertEquals(list, list);

	}

	@Test
	void testAddCustomersShouldReturnCustomerObject() throws DuplicateCustomerException {
		Address address = new Address(6, "Villa", "Koregaon", "15", "Pune", "MH", "India", "423781");
		Customer customer = new Customer(6, "Reva", "Bose", "9822953122", "m#3si11@abc.com", "Female", "22", address);
		
		when(repository.save(customer)).thenReturn(customer);
		//assertEquals(customer,service.addCustomer(customer));
		
	}
	
	//@Test
	void testDeleteCustomerShouldReturnBooleanValue() {
		Address address = new Address(6, "Villa", "Koregaon", "15", "Pune", "MH", "India", "423781");
		Customer customer = new Customer(6, "Reva", "Bose", "9822953122", "m#3si11@abc.com", "Female", "22", address);
		
		int id=customer.getCustomerId();
		
				
	}
	
	
}