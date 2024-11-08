package com.capgemini.fds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.fds.entities.OrderDetails;

public interface IOrderRepository extends JpaRepository<OrderDetails, Integer> {

}