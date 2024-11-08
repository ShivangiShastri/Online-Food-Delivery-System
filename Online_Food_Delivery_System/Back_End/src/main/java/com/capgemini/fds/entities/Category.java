package com.capgemini.fds.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("category")
@Scope("prototype")
@Entity
@Table(name = "CATEGORY2")
public class Category {
	// Primary Key
	@Id
	@Column(name = "CATEGORY_ID")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int categoryId;

	@Column(name = "CATEGORY_NAME", length = 20)
	@NotNull
	private String categoryName;

	// Default Constructor
	public Category() {

	}

	// Parameterized constructor
	public Category(int categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}

	
}