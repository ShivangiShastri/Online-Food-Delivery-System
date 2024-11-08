package com.capgemini.fds.services.withMock;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean; //Using Mockito

import com.capgemini.fds.entities.Login;
import com.capgemini.fds.exceptions.UserNotFoundException;
import com.capgemini.fds.repositories.ILoginRepository;
import com.capgemini.fds.services.ILoginService;

@SpringBootTest
class ILoginServiceImplTestWithMock {

	@Autowired
	ILoginService service;
	@MockBean
	ILoginRepository repository;

	@Test
	void testUserShouldReturnCorrectValue() throws UserNotFoundException {
		Login login = new Login(101, "Pooja", "Pooja@123");

		Login result = service.signUp(login);

		assertEquals(login.getUserid(), result.getUserid());
		assertEquals(login.getPassword(), result.getPassword());

	}

}