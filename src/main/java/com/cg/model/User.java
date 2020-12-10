package com.cg.model;

import java.util.Date; 
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity  // Declare the class as entity or table
@Table(name="USE")  // Declare the table name
public class User {
	
	@Id   // specifies the property, use for identity of the class
	@Column(name = "USER_ID")  //Specify the column name
	@GeneratedValue(strategy = GenerationType.AUTO) //generates an automatic value during commit for every new entity object
	private long userId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName="None";
	@Column(name = "MOBILE_NUMBER")
	private String mobileNumber;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "CREATED_DATE")
	private Date createdDate = new java.sql.Date(new java.util.Date().getTime());;
	@Column(name="LAST_UPDATED_DATE")
	private Date lastUpdatedDate;
	
	/*
	 * creating many to one relation with role
	 */
	 
	@ManyToOne
	@JoinColumn(name="roleId")
	private Role role;
	
	/*
	 * creating one to many relation with Service
	 */
	
	@OneToMany(mappedBy="users",cascade=CascadeType.ALL)
	private Set<Services> set1 = new HashSet<Services>();
	
	
	/*
	 * creating many to one relation with Enquiry
	 */
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Enquiry> set = new HashSet<Enquiry>();

	public User() {}
	
	public User(long userId) {
		this.userId=userId;
	}
	
	public User(long userId, String firstName, String lastName, String mobileNumber, String email, String password,
			Date createdDate, Date lastUpdatedDate) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
		this.createdDate = createdDate;
		this.lastUpdatedDate = lastUpdatedDate;
	}

	// getters and setters of entity table
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	//Override toString() method
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNumber="
				+ mobileNumber + ", email=" + email + ", password=" + password + ", createdDate=" + createdDate
				+ ", lastUpdatedDate=" + lastUpdatedDate + ", role=" + role + ", set1=" + set1 + ", set=" + set + "]";
	}
	

}
