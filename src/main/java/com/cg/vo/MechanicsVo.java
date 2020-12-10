package com.cg.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data

public class MechanicsVo implements Serializable{
private static final long serialVersionUID = 1L;
	
	@JsonProperty(value="id")
	private long id;
	

	@JsonProperty(value="firstName")
	private String firstName;
	@JsonProperty(value="lastname")
	private String lastName;
	@JsonProperty(value="mobileNumber")
	private String mobileNumber;
	@JsonProperty(value="Address")
	private String address;
	@JsonProperty(value="Email")
	private String email;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "MechanicsVo [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNumber="
				+ mobileNumber + ", address=" + address + ", email=" + email + "]";
	}
}
