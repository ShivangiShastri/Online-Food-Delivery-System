package com.capgemini.fds.entities;

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

@Component("login")
@Scope("prototype")
@Entity
@Table(name = "LOGIN")

public class Login {

	@Id
	@Column(name = "USER_ID")
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;

	@Column(name = "USER_NAME", length = 20)
	@NotNull
	private String userName;

	@Column(name = "PASSWORD", length = 8)
	@NotNull
	private String password;

	// One to One Mapping
	@Autowired
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	// Setter Injection
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	// Constructor Injection
	public Login(Customer customer) {

		this.customer = customer;
	}

	public Login(int userid, String userName, String password) {
		super();
		this.userid = userid;
		this.userName = userName;
		this.password = password;
	}

	public Login() {

	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [userid=" + userid + ", userName=" + userName + ", password=" + password + "]";
	}

}