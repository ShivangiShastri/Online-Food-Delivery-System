package com.capgemini.fds.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.fds.entities.Login;
import com.capgemini.fds.exceptions.UserNotFoundException;
import com.capgemini.fds.services.ILoginService;

@RestController
@RequestMapping(path = "login")
public class LoginController {

	@Autowired
	private ILoginService service;

	// http://localhost:/9090/OnlineFoodDeliveryApp/login
	@GetMapping(path = "{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Login> getUserId(@PathVariable int userId) throws UserNotFoundException {
		Login result = service.signIn(userId);
		ResponseEntity<Login> response = null;
		if (result != null) {
			response = new ResponseEntity<Login>(result, HttpStatus.OK);
			return response;
		}
		throw new UserNotFoundException("User Not Found");
	}
}