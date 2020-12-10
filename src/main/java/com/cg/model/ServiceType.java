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
@Table(name = "SERVICE_TYPE")  // Declare the table name
public class ServiceType {
	
	@Id  // specifies the property, use for identity of the class
	@Column(name = "SERVICE_TYPE_ID")//Specify the column name
	@GeneratedValue(strategy = GenerationType.AUTO) //generates an automatic value during commit for every new entity object
	private long serviceTypeId;
	@Column(name = "SERVICE_TYPE_NAME")
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

	public ServiceType() {}
	
	public ServiceType(long serviceTypeId) {
		super();
		this.serviceTypeId = serviceTypeId;
	}
	
	public ServiceType(long serviceTypeId, String serviceTypeName) {
		super();
		this.serviceTypeId = serviceTypeId;
		this.serviceTypeName = serviceTypeName;
	}
	
	// getters and setters of entity table
	
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
	
	//Override toString() method
	@Override
	public String toString() {
		return "ServiceType [serviceTypeId=" + serviceTypeId + ", serviceTypeName=" + serviceTypeName + "]";
	}
	

}
