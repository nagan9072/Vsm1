package com.cg.vo;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.cg.model.ServicePrice;
import com.cg.model.Services;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class ServiceTypeVo implements Serializable{
	private static final long serialVersionUID = 1L;
    
	@JsonProperty(value="serviceId")
   private long serviceTypeId;
	
	@JsonProperty(value="serviceName")
	private String serviceTypeName;
	

	/*
	 * creating one to many relation with Service
	 */
	
	@OneToMany(mappedBy="serviceTypeId",cascade=CascadeType.ALL)
	private Set<Services> service=new HashSet<Services>(); 
	
	/*
	 * creating one to many relation with ServicePrice
	 */
	
	@OneToMany(mappedBy="serviceType",cascade=CascadeType.ALL)
	private Set<ServicePrice> serviceprice=new HashSet<ServicePrice>();

	//getters and setters
	public long getServiceTypeId() {
		return serviceTypeId;
	}

	public void setServiceTypeId(long serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}

	public String getServiceTypeName() {
		return serviceTypeName;
	}

	public void setServiceTypeName(String serviceTypeName) {
		this.serviceTypeName = serviceTypeName;
	}


	
}
