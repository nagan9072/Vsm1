package com.cg.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity // Declare the class as entity or table
@Table(name="Vehicle_Type")  // Declare the table name
public class VehicleType {
	
	@Id   // specifies the property, use for identity of the class
	@Column(name="vehicle_Type_id")//Specify the column name
	@GeneratedValue(strategy = GenerationType.AUTO) //generates an automatic value during commit for every new entity object
	private long vehicleTypeId;
	
	@Column(name="vechicle_Type_name")
	private String vehicleTypeName;
	
	/*
	 * creating one to many relation with Service
	 */
	
	@OneToMany(mappedBy="vehicleType",cascade = CascadeType.ALL)
	private Set<Services> service = new HashSet<Services>();
	
	/*
	 * creating one to many relation with ServicePrice
	 */
	
	@OneToMany(mappedBy="vehicleType",cascade=CascadeType.ALL)
	private Set<ServicePrice> serviceprice=new HashSet<ServicePrice>();
	
	public VehicleType() {}
	
	public VehicleType(long vehicleTypeId) {
		super();
		this.vehicleTypeId=vehicleTypeId;
	}
	
	public VehicleType(long vehicleTypeId, String vehicleTypeName) {
		super();
		this.vehicleTypeId = vehicleTypeId;
		this.vehicleTypeName = vehicleTypeName;
	}

	// getters and setters of entity table
	
	public long getVehicleTypeId() {
		return vehicleTypeId;
	}
	public void setVehicleTypeId(long vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}
	public String getVehicleTypeName() {
		return vehicleTypeName;
	}
	public void setVehicleTypeName(String vehicleTypeName) {
		this.vehicleTypeName = vehicleTypeName;
	}
	
	//Override toString() method
	@Override
	public String toString() {
		return "VehicleType [vehicleTypeId=" + vehicleTypeId + ", vehicleTypeName=" + vehicleTypeName + ", service="
				+ service + ", serviceprice=" + serviceprice + "]";
	}

}

