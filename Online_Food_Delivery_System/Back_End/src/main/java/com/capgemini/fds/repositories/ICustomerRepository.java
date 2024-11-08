package com.capgemini.fds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.fds.entities.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer>{
 
}