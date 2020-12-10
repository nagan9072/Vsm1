package com.cg.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.Data;

@Data
public class VehicleTypeVo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value="vehicleId")
	private long vehicleTypeId;
	@JsonProperty(value="vehicleName")
	private String vehicleTypeName;
	
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
	
}