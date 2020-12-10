package com.cg.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cg.model.Mechanics;
import com.cg.model.ServiceType;
import com.cg.model.User;
import com.cg.model.VehicleType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class ServiceVo {

	@JsonProperty(value = "id")
	private long serviceId;

	@JsonProperty(value = "requestDate")
	private Date serviceRequestDate;

	@JsonProperty(value = "brand")
	private String vehicleBrand;

	@JsonProperty(value = "regNo")
	private String vehicleRegno;

	@JsonProperty(value = "status")
	private String adminStatus;

	@JsonProperty(value = "deliverDate")
	private Date deliveryDate;

	
//	 @ManyToOne 
//	 @JoinColumn(name="user_id") private User users;
	/*
	 * 
	 * creating many to one relation with User
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="user_id") private User users;
	 * 
	 * creating many to one relation with VehicleType
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="vehicle_type_id") private VehicleType vehicleType;
	 * 
	 * 
	 * creating many to one relation with Mechanics
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="mehanicId") private Mechanics mehanicId;
	 * 
	 * 
	 * creating many to one relation with ServiceType
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="service_type_id") private ServiceType serviceTypeId;
	 * 
	 * 
	 * // getters and setters of entity table
	 * 
	 * public User getUsers() { return users; } public void setUsers(User users) {
	 * this.users = users; }
	 *
	public User getUsers() { 
		return users; 
	} 
	public void setUsers(User users) {
	 this.users = users; 
	} */
	public long getServiceId() {
		return serviceId;
	}

	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}

	public Date getServiceRequestDate() {
		return serviceRequestDate;
	}

	public void setServiceRequestDate(Date serviceRequestDate) {
		this.serviceRequestDate = serviceRequestDate;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	public String getVehicleRegno() {
		return vehicleRegno;
	}

	public void setVehicleRegno(String vehicleRegno) {
		this.vehicleRegno = vehicleRegno;
	}

	public String getAdminStatus() {
		return adminStatus;
	}

	public void setAdminStatus(String adminStatus) {
		this.adminStatus = adminStatus;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	/* public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Mechanics getMehanicId() {
		return mehanicId;
	}

	public void setMehanicId(Mechanics mehanicId) {
		this.mehanicId = mehanicId;
	}

	public ServiceType getServiceTypeId() {
		return serviceTypeId;
	}

	public void setServiceTypeId(ServiceType serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}   */
}
