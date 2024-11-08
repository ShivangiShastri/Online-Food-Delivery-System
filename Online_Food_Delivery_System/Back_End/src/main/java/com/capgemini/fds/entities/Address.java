package com.capgemini.fds.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("address")
@Scope("prototype")
@Entity
@Table(name = "ADDRESS")

public class Address  {
	
	@Id
	@Column(name = "ADDRESS_ID")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int addressId;

	@Column(name = "BUILDING_NAME",length=30)
	@NotNull
	private String buildingName;

	@Column(name = "AREA", length=30)
	@NotNull
	private String area;

	@Column(name = "STREET_NO",length=30)
	@NotNull
	private String streetNo;

	@Column(name = "CITY",length=20)
	@NotNull
	private String city;

	@Column(name = "STATE",length=30)
	@NotNull
	private String state;

	@Column(name = "COUNTRY",length=20)
	@NotNull
	private String country;

	@Column(name = "PINCODE",length=10)
	@NotNull
	private String pincode;

	public Address() {
	}

	public Address(int addressId, String buildingName, String area, String streetNo, String city, String state,
			String country, String pincode) {
		super();
		this.addressId = addressId;
		this.buildingName = buildingName;
		this.area = area;
		this.streetNo = streetNo;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", buildingName=" + buildingName + ", area=" + area + ", streetNo="
				+ streetNo + ", city=" + city + ", state=" + state + ", country=" + country + ", pincode=" + pincode
				+ "]";
	}
	
}