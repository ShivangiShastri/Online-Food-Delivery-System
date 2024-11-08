package com.capgemini.fds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.fds.entities.Login;

public interface ILoginRepository extends JpaRepository<Login, Integer>{
	
}