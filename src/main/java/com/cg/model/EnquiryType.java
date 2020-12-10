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


@Entity // Declare the class as entity or table
@Table(name = "enquiry_type")  // Declare the table name
public class EnquiryType {

	@Id   // specifies the property, use for identity of the class
	@Column(name = "Enquiry_TYPE_ID")	//Specify the column name
	@GeneratedValue(strategy = GenerationType.AUTO) //generates an automatic value during commit for every new entity object
	private long enquiryTypeId;
	
	@Column(name = "Enquiry_NAME")
	private String enquiryTypeName;
	
	/*
	 * creating one to many relation with Enquiry
	 */
	@OneToMany(mappedBy = "enquiryType", cascade = CascadeType.ALL)
	private Set<Enquiry> set = new HashSet<Enquiry>();
	
	public EnquiryType() {}
	
	public EnquiryType(long enquiryTypeId) {
		super();
		this.enquiryTypeId=enquiryTypeId;
	}
	
	public EnquiryType(long enquiryTypeId,String enquiryTypeName) {
		super();
		this.enquiryTypeId=enquiryTypeId;
		this.enquiryTypeName=enquiryTypeName;
	}
	
	// getters and setters of entity table
	
	public long getEnquiryTypeId() {
		return enquiryTypeId;
	}
	public void setEnquiryTypeId(long enquiryTypeId) {
		this.enquiryTypeId = enquiryTypeId;
	}
	public String getEnquiryTypeName() {
		return enquiryTypeName;
	}
	public void setEnquiryTypeName(String enquiryTypeName) {
		this.enquiryTypeName = enquiryTypeName;
	}
	
	//Override toString() method
	@Override
	public String toString() {
		return "EnquiryType [enquiryTypeId=" + enquiryTypeId + ", enquiryTypeName=" + enquiryTypeName + ", set=" + set
				+ "]";
	}
	
}
