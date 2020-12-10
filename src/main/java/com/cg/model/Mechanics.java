package com.cg.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity  // Declare the class as entity or table
@Table(name = "mechanics") // Declare the table name
public class Mechanics { 
	
	@Id   // specifies the property, use for identity of the class
	@Column(name = "mechanic_id") //Specify the column name
	@GeneratedValue(strategy = GenerationType.AUTO) //generates an automatic value during commit for every new entity object
	private long mechanicId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "mobile_number")
	private String mobileNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;
	
	/* 
	 * creating one to many relation with Service
	 */
	@OneToMany(mappedBy="mehanicId",cascade=CascadeType.ALL)
	private Set<Services> service=new HashSet<Services>();
	
	// getters and setters of entity table
	
	public Mechanics() {
		super();
	}
	
	public Mechanics(long mechanicId) {
		super();
		this.mechanicId=mechanicId;
	}
	
	public Mechanics(long mechanicId, String firstName, String lastName, String mobileNumber, String email,
			String address) {
		super();
		this.mechanicId = mechanicId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.address = address;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public long getMechanicId() {
		return mechanicId;
	}
	public void setMechanicId(long mechanicId) {
		this.mechanicId = mechanicId;
	}
	
	//Override toString() method
	@Override
	public String toString() {
		return "Mechanics [mechanicId=" + mechanicId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", mobileNumber="
				+ mobileNumber + ", email=" + email + ", address=" + address
				+ "]";
	}
	
	
	}
	



