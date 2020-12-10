package com.cg.model;

import java.util.Date;  

import javax.persistence.*;

@Entity // Declare the class as entity or table
@Table(name="ENQUIRY") // Declare the table name
public class Enquiry {
	
	@Id   // specifies the property, use for identity of the class
	@Column(name = "ENQUIRY_ID")  //Specify the column name
	@GeneratedValue(strategy = GenerationType.AUTO) //generates an automatic value during commit for every new entity object
	private long enquiryId;
	
	@Column(name = "DESCRIPTION", length=500)
	private String description;
	
	@Column(name = "ENQUIRY_DATE")
	private Date enquiryDate;	
	
	@Column(name = "ADMIN_ACTION")
	private String adminAction;
	
	@Column(name = "ADMIN_STATUS")
	private String adminStatus;
	
	@Column(name = "ADMIN_ACTION_DATE")
	private Date adminActionDate;
	
	/*
	 * creating many to one relation with User
	 */
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
	
	/*
	 * creating many to one relation with EnquiryType
	 */
	@ManyToOne
	@JoinColumn(name="ENQUIRY_Type_ID")
	private EnquiryType enquiryType;
	
	public Enquiry() {}
	
	public Enquiry(long enquiryId) {
		this.enquiryId = enquiryId;
	}
	
	public Enquiry(long enquiryId, String description, Date enquiryDate, String adminAction, String adminStatus,
			Date adminActionDate) {
		super();
		this.enquiryId = enquiryId;
		this.description = description;
		this.enquiryDate = enquiryDate;
		this.adminAction = adminAction;
		this.adminStatus = adminStatus;
		this.adminActionDate = adminActionDate;
	}
	// getters and setters of entity table

	public long getEnquiryId() {
		return enquiryId;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setEnquiryId(long enquiryId) {
		this.enquiryId = enquiryId;
	}
	public User getUserId() {
		return user;
	}
	public void setUserId(User userId) {
		this.user = userId;
	}
	public EnquiryType getEnquiryType() {
		return enquiryType;
	}
	public void setEnquiryType(EnquiryType enquiryType) {
		this.enquiryType = enquiryType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getEnquiryDate() {
		return enquiryDate;
	}
	public void setEnquiryDate(Date enquiryDate) {
		this.enquiryDate = enquiryDate;
	}
	public String getAdminAction() {
		return adminAction;
	}
	public void setAdminAction(String adminAction) {
		this.adminAction = adminAction;
	}
	public String getAdminStatus() {
		return adminStatus;
	}
	public void setAdminStatus(String adminStatus) {
		this.adminStatus = adminStatus;
	}
	public Date getAdminActionDate() {
		return adminActionDate;
	}
	public void setAdminActionDate(Date adminActionDate) {
		this.adminActionDate = adminActionDate;
	}

	
	//Override toString() method
	@Override
	public String toString() {
		return "Enquiry [enquiryId=" + enquiryId + ", user=" + user + ", description=" + description + ", enquiryDate="
				+ enquiryDate + ", adminAction=" + adminAction + ", adminStatus=" + adminStatus + ", adminActionDate="
				+ adminActionDate + ", enquiryType=" + enquiryType + "]";
	}

	
		
}
