package com.capgemini.fds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.fds.entities.Category;

public interface ICategoryRepository extends JpaRepository<Category, Integer>{

	}