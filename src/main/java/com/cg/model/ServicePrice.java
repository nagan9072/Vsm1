package com.cg.model;

import javax.persistence.*;

@Entity  // Declare the class as entity or table
@Table(name="service_price")  // Declare the table name
public class ServicePrice {  
	
	@Id   // specifies the property, use for identity of the class
	@Column(name="service_price_id")//Specify the column name
	@GeneratedValue(strategy = GenerationType.AUTO) //generates an automatic value during commit for every new entity object
	private long servicePriceId;
	
	@Column(name="service_amount")
	private long serviceAmount;
	
	/*
	 * creating many to one relation with VehicleType
	 */
	
	@ManyToOne
	@JoinColumn(name="vehicle_type_id")
	private VehicleType vehicleType;
	
	/*
	 * creating many to one relation with ServiceType
	 */
	
	@ManyToOne
	@JoinColumn(name="service_type_id")
	private ServiceType serviceType;
	
	public ServicePrice() {}
	
	public ServicePrice(long servicePriceId) {
		super();
		this.servicePriceId=servicePriceId;
	}
	
	public ServicePrice(long servicePriceId, long serviceAmount) {
		super();
		this.servicePriceId = servicePriceId;
		this.serviceAmount = serviceAmount;
	}

	// getters and setters of entity table

	public long getServicePriceid() {
		return servicePriceId;
	}

	public void setServicePriceid(long servicePriceId) {
		this.servicePriceId = servicePriceId;
	}

	public long getServiceAmount() {
		return serviceAmount;
	}

	public void setServiceAmount(long serviceAmount) {
		this.serviceAmount = serviceAmount;
	}
	
	public long getServicePriceId() {
		return servicePriceId;
	}

	public void setServicePriceId(long servicePriceId) {
		this.servicePriceId = servicePriceId;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	//Override toString() method
	@Override
	public String toString() {
		return "ServicePrice [servicePriceid=" + servicePriceId + ", ServiceAmount=" + serviceAmount + ", vehicleType="
				+ vehicleType + ", serviceType=" + serviceType + "]";
	}
	
	
}
