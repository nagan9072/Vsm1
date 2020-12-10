package com.cg.model;

import java.util.Date;

import javax.persistence.*;

@Entity // Declare the class as entity or table
@Table(name="service")  // Declare the table name
public class Services {
	
	@Id   // specifies the property, use for identity of the class
	@Column(name="service_id")//Specify the column name
	@GeneratedValue(strategy = GenerationType.AUTO) //generates an automatic value during commit for every new entity object
	private long serviceId;
	
	@Column(name="service_request_date")
	private Date serviceRequestDate;
	
	@Column(name="vehicle_brand")
	private String vehicleBrand;
	
	@Column(name="vehicle_regno")
	private String vehicleRegno;
	
	@Column(name="admin_status")
	private String adminStatus;
	
	@Column(name="delivery_date")
	private Date deliveryDate;
	
	/*
	 * creating many to one relation with User
	 */
	@ManyToOne
	@JoinColumn(name="user_id")
	private User users;
	/*
	 * creating many to one relation with VehicleType
	 */
	@ManyToOne
	@JoinColumn(name="vehicle_type_id")
	private VehicleType vehicleType;
	
	/*
	 * creating many to one relation with Mechanics
	 */
	@ManyToOne
	@JoinColumn(name="mehanicId")
	private Mechanics mehanicId;
	
	/*
	 * creating many to one relation with ServiceType
	 */
	@ManyToOne
	@JoinColumn(name="service_type_id")
	private ServiceType serviceTypeId;
	
	
	// getters and setters of entity table
	
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}
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
	public VehicleType getVehicleType() {
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
	}
	//Override toString() method
	@Override
	public String toString() {
		return "Service [serviceId=" + serviceId + ", users=" + users + ", serviceRequestDate=" + serviceRequestDate
				+ ", vehicleBrand=" + vehicleBrand + ", vehicleRegno=" + vehicleRegno + ", adminStatus=" + adminStatus
				+ ", deliveryDate=" + deliveryDate + ", vehicleType=" + vehicleType + ", mehanicId=" + mehanicId
				+ ", serviceTypeId=" + serviceTypeId + "]";
	}
	
	

}
