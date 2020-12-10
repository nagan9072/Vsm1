package com.cg.vo;
import lombok.Data;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cg.model.ServiceType;
import com.cg.model.VehicleType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Data
public class ServicePriceVo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value="servicePriceId")
	private long servicePriceId;
	
	@JsonProperty(value="serviceAmount")
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

	//getters and setters
	
	
	public long getServicePriceId() {
		return servicePriceId;
	}

	public void setServicePriceId(long servicePriceId) {
		this.servicePriceId = servicePriceId;
	}

	public long getServiceAmount() {
		return serviceAmount;
	}

	public void setServiceAmount(long serviceAmount) {
		this.serviceAmount = serviceAmount;
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
	
	
	
	
}
