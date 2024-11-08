package com.capgemini.fds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.fds.entities.Restaurant;

public interface IRestaurantRepository extends JpaRepository<Restaurant, Integer>{

	
}