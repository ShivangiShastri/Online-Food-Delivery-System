package com.capgemini.fds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.fds.entities.Item;

public interface IItemRepository extends JpaRepository<Item, Integer>{

	
}