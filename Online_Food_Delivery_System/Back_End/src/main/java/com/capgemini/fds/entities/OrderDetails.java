package com.capgemini.fds.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



@Component("orderDetails")
@Scope("prototype")
@Entity
@Table(name = "ORDER_DETAILS")

public class OrderDetails {

	// Primary Key
	@Id
	@Column(name = "ORDER_ID")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;

	@Column(name = "ORDER_DATE")
	@NotNull
	private LocalDateTime orderDate;

	@Column(name = "ORDER_STATUS", length = 20)
	@NotNull
	private String orderStatus;

	// One to One Association is done on FoodCart class and OrderDetails class
	@Autowired
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CART_ID") // Foreign Key
	private FoodCart cart;

	public FoodCart getCart() {
		return cart;
	}

	// Setter injection
	public void setCart(FoodCart cart) {
		this.cart = cart;
	}

	// Constructor injection
	public OrderDetails(FoodCart cart) {
		this.cart = cart;
	}

	// Default Constructor
	public OrderDetails() {

	}

	// Parameterized constructor
	public OrderDetails(int orderId, LocalDateTime orderDate, FoodCart cart, String orderStatus) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.cart = cart;
		this.orderStatus = orderStatus;
	}

	// Getter and Setter methods
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", orderDate=" + orderDate + ", cart=" + cart + ", orderStatus="
				+ orderStatus + "]";
	}
}