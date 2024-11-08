package com.capgemini.fds.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("restaurant")
@Scope("prototype")
@Entity
@Table(name = "RESTAURANT")
public class Restaurant {

	@Id
	@Column(name = "RESTAURANT_ID")
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private int restaurantId;

	@Column(name = "RESTAURANT_NAME", length = 30)
	@NotNull
	private String restaurantName;

	@Column(name = "MANAGER_NAME", length = 30)
	private String managerName;

	@Column(name = "CONTACT_NUMBER", length = 15)
	@NotNull
	private String contactNumber;

	// One to One Association is done on Restaurant class and Address class
	@Autowired
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	private Address address;

	// constructor injection
	public Restaurant(Address address) {
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	// setter injection
	public void setAddress(Address address) {
		this.address = address;
	}

	// Many to Many Association is done on Restaurant class and Item class
	/*
	 * @Autowired
	 * 
	 * @ManyToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "RESTAURANT_ITEMS", joinColumns = { @JoinColumn(name =
	 * "RESTAURANT_ID") }, inverseJoinColumns = {
	 * 
	 * @JoinColumn(name = "ITEM_ID") })
	 */

	/*
	 * @Autowired
	 * 
	 * @ManyToMany(cascade= CascadeType.ALL)
	 * 
	 * @JoinTable(name = "restaurant_items", joinColumns = {@JoinColumn(name =
	 * "RESTAURANT_ID")} , inverseJoinColumns = { @JoinColumn(name ="ITEM_ID")})
	 */
	@Autowired
	@OneToMany(cascade = CascadeType.ALL) // ....FOR UNIDIRECTIONAL
	 @JoinColumn(name = "ITEM_ID")
	private Set<Item> items;

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public Restaurant(Set<Item> items) {
		this.items = items;
	}

	public Restaurant() {

	}

	public Restaurant(int restaurantId, String restaurantName, String managerName, String contactNumber,
			Address address, Set<Item> items) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.managerName = managerName;
		this.contactNumber = contactNumber;
		this.address = address;
		this.items = items;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", managerName="
				+ managerName + ", contactNumber=" + contactNumber + ", address=" + address + ", items=" + items + "]";
	}

}