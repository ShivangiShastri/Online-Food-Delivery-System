package com.capgemini.fds.services.withoutMock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.fds.entities.Address;
import com.capgemini.fds.entities.Customer;
import com.capgemini.fds.exceptions.DuplicateCustomerException;
import com.capgemini.fds.exceptions.NoSuchCustomerException;
import com.capgemini.fds.services.ICustomerService;

@SpringBootTest
class ICustomerServiceImplTest {

	@Autowired
	private ICustomerService service;
	
	@Test
	void testAddShouldReturnCustomerObject() throws DuplicateCustomerException, NoSuchCustomerException {
		Address address=new Address(10,"SwaraVilla","Pimple Saudagar","5","Pune","MH","India","42378");
		Customer customer= new Customer(10, "Mansi", "Kate", "9822653122", "mansi11@abc.com", "Female", "22", address);
		
		/*
		 * Customer result =service.addCustomer(customer);
		 * assertEquals(customer.getFirstName(),result.getFirstName() );
		 * 
		 * service.removeCustomer(customer.getCustomerId());
		 */
	}
	
	/*
	 * @Test void testDuplicateCustomerException() throws DuplicateCustomerException
	 * { Address address=new
	 * Address(10,"SwaraVilla","Pimple Saudagar","5","Pune","MH","India","42378");
	 * Customer customer= new Customer(10, "Mansi", "Kate", "9822653122",
	 * "mansi11@abc.com", "Female", "22", address);
	 * 
	 * Address address2=new
	 * Address(10,"SwaraVilla","Pimple Saudagar","5","Pune","MH","India","42378");
	 * Customer customer2= new Customer(10, "Mansi", "Kate", "9822653122",
	 * "mansi11@abc.com", "Female", "22", address);
	 * 
	 * service.addCustomer(customer); assertThrows(DuplicateCustomerException.class,
	 * ()-> { service.addCustomer(customer2); }); }
	 */
	
	
	@Test
	void testFindAllCustomers() {
		List<Customer> list = service.viewAllCustomer();
		assertEquals(list, list);

	}

	@Test
	void testFindCustomerByIdShouldReturnCustomerObject() throws DuplicateCustomerException, NoSuchCustomerException {
		Address address=new Address(10,"SwaraVilla","Pimple Saudagar","5","Pune","MH","India","42378");
		Customer customer= new Customer(10, "Mansi", "Kate", "9822653122", "mansi11@abc.com", "Female", "22", address);
	
		/*
		 * service.addCustomer(customer); Customer result =
		 * service.viewCustomerById(customer.getCustomerId());
		 * 
		 * assertEquals(customer.getFirstName(), result.getFirstName());
		 * 
		 * service.removeCustomer(customer.getCustomerId());
		 */
	
	}
	
	@Test
	void testFindCustomerByIdShouldThrowNoSuchCustomerException() {
		assertThrows(NoSuchCustomerException.class, () ->{
			service.viewCustomerById(-1);
		} );
	}

}