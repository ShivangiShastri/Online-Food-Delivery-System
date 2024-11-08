package com.capgemini.fds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.fds.entities.FoodCart;

public interface ICartRepository extends JpaRepository<FoodCart, Integer> {

}