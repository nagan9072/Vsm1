package com.cg.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class EnquiryTypeVo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value="enqTypeId")
	private long enquiryTypeId;
	
	@JsonProperty(value="enqTypeName")
	private String enquiryTypeName;

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
	
	

}
