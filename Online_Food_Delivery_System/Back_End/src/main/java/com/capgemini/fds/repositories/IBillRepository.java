package com.capgemini.fds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.fds.entities.Bill;

public interface IBillRepository extends JpaRepository<Bill, Integer>{
	
}