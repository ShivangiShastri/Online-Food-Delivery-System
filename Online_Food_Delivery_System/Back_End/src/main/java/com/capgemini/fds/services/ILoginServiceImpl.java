package com.capgemini.fds.services;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.fds.entities.Login;
import com.capgemini.fds.exceptions.UserNotFoundException;
import com.capgemini.fds.repositories.ILoginRepository;

@Service("loginservice")

public class ILoginServiceImpl implements ILoginService {
	@Autowired
	private ILoginRepository repository;

	@Override
	public Login signIn(int userId) throws UserNotFoundException {
		Optional<Login> result = repository.findById(userId);
		Login login = null;
		if (result.isPresent()) {
			login = result.get();
		} else {
			throw new UserNotFoundException("User Not Found.");
		}
		return login;
	}

	public Login validatePassword(Login login) {

		String pass = login.getPassword();

		String regex1 = "^(?=.*[0-9])" // Regular Expression for pass, which is taking password.
				+ "(?=.[a-z])(?=.[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";

		Pattern p2 = Pattern.compile(regex1); // Compiles the given regular expression into a pattern for pass.

		if (pass == null) {
			return null;
		}

		Matcher m1 = p2.matcher(pass);
		if (m1.matches()) {
			return login;
		} else {
			return null;
		}

	}

	@Override
	public Login signOut(Login login) {

		return null;
	}

}