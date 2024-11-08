package com.capgemini.fds.services;

import com.capgemini.fds.entities.Login;
import com.capgemini.fds.exceptions.UserNotFoundException;

public interface ILoginService {

	public Login signOut(Login login);

	public Login signIn(int userId) throws UserNotFoundException;

}