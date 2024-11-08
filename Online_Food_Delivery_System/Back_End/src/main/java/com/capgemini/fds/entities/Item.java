package com.capgemini.fds.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("item")
@Scope("prototype")
@Entity
@Table(name = "ITEM")
public class Item {
	@Id
	@Column(name = "ITEM_ID")
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private int itemId;

	@Column(name = "ITEM_NAME", length = 30)
	@NotNull
	private String itemName;

	@Column(name = "ITEM_QUANTITY", length = 30)
	@NotNull
	private int quantity;

	@Column(name = "ITEM_COST", length = 30)
	private double cost;

	@Autowired
	@OneToOne(cascade = CascadeType.ALL)
	// @JoinColumn(name = "CATEGORY_ID")
	private Category category;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Item(Category category) {
		super();
		this.category = category;
	}

	/*
	 * @Autowired
	 * 
	 * @ManyToMany(fetch = FetchType.LAZY, mappedBy = "items")
	 * // @JoinColumn(name="ITEM_ID")
	 */
	/*
	 * @Autowired
	 * 
	 * @ManyToOne private Restaurant restaurant;
	 * 
	 * 
	 * public Restaurant getRestaurant() { return restaurant; }
	 * 
	 * public void setRestaurant(Restaurant restaurant) { this.restaurant =
	 * restaurant; }
	 * 
	 * public Item(Restaurant restaurant) { this.restaurant = restaurant; }
	 */

	public Item() {

	}

	public Item(int itemId, @NotNull String itemName, @NotNull int quantity, double cost, Category category) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.cost = cost;
		this.category = category;

	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", quantity=" + quantity + ", cost=" + cost
				+ ", category=" + category + "]";
	}

}