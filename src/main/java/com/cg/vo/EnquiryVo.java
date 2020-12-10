package com.cg.vo;

import java.io.Serializable;
import java.util.Date;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;
/**
 * @author acer
 *
 */
@Data
public class EnquiryVo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value="enquiryId")
	private long  enquiryId;
	/*
	 * creating many to one relation with User
	 */
	/*
	 * @ManyToOne
	 * @JoinColumn(name="USER_ID") private User user;
	 */
	@JsonProperty(value="Description")
	private String description;
	
	@JsonProperty(value="EnquiryDate")
	private Date enquiryDate;	
	
	@JsonProperty(value="adminAction")
	private String adminAction;
	
	@JsonProperty(value="AdminStatus")
	private String adminStatus;
	
	@JsonProperty(value="AdminActionDate")
	private Date adminActionDate;
	/*
	 * creating many to one relation with EnquiryType
	 */
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="ENQUIRY_Type_ID") private EnquiryType enquiryType;
	 */

	public long getEnquiryId() {
		return enquiryId;
	}

	public void setEnquiryId(long enquiryId) {
		this.enquiryId = enquiryId;
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
	

	}
	



