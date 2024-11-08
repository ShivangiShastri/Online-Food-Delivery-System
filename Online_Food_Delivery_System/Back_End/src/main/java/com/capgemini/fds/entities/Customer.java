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


@Component("customer")
@Scope("prototype")
@Entity
@Table(name = "CUSTOMER")
public class Customer {

	@Id
	@Column(name = "CUSTOMER_ID")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;

	@Column(name = "FIRST_NAME", length = 20)
	@NotNull
	private String firstName;

	@Column(name = "LAST_NAME", length = 20)
	@NotNull
	private String lastName;

	@Column(name = "MOBILE_NO", length = 15)
	@NotNull
	private String mobileNumber;

	@Column(name = "EMAIL", length = 40)
	@NotNull
	private String email;

	@Column(name = "GENDER", length = 10)
	private String gender;
	@Column(name = "AGE", length = 10)
	private String age;

	// One to One mapping
	@Autowired
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	private Address address;

	public Address getAddress() {
		return address;
	}

	//setter injection
	public void setAddress(Address address) {
		this.address = address;
	}
	
	//Constructor injection
	public Customer(Address address) {
		this.address = address;
	}
	
	public Customer() {

	}

	public Customer(int customerId, String firstName, String lastName, String mobileNumber, String email,
			String gender, String age, Address address) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.gender = gender;
		this.age = age;
		this.address = address;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobileNumber=" + mobileNumber + ", email=" + email + ", gender=" + gender + ", age=" + age
				+ ", address=" + address + "]";
	}

}