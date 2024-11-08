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

@Component("bill")
@Scope("prototype")
@Entity
@Table(name = "BILL")

public class Bill {
	@Id//primary key
	@Column(name="BILL_ID")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int billId;
	
	@Column(name = "TOTAL_ITEM",length=2)
	@NotNull
	private int totalItem;

	@Column(name = "TOTAL_COST",length=5)
	@NotNull
	private double totalCost;

	@Column(name = "BILL_DATE")
	LocalDateTime billDate;

	//One to one mapping done with orderDetails;
	@Autowired
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ORDER_ID")
	@NotNull
	private OrderDetails order;
	
	public OrderDetails getOrder() {
		return order;
	}

	//Setter injection
	public void setOrder(OrderDetails order) {
		this.order = order;
	}

	//Constructor injection
	public Bill(@NotNull OrderDetails order) {
		super();
		this.order = order;
	}

	public Bill() {

	}

	public Bill(int billId, OrderDetails order, int totalItem, double totalCost, LocalDateTime billDate) {
		super();
		this.billId = billId;
		this.order = order;
		this.totalItem = totalItem;
		this.totalCost = totalCost;
		this.billDate = billDate;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	
	public int getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public LocalDateTime getBillDate() {
		return billDate;
	}

	public void setBillDate(LocalDateTime billDate) {
		this.billDate = billDate;
	}

	
	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", order=" + order + ", totalItem=" + totalItem + ", totalCost=" + totalCost
				+ ", billDate=" + billDate + "]";
	}

}