package com.cg.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class UserVo implements Serializable{
	
	/**
	 *  Unique Serialversion ID
	 */
	private static final long serialVersionUID = 1L;
	
	
	@JsonProperty(value = "UserId")
	private long userId;
	@JsonProperty(value = "FirstName")
	private String firstName;
	@JsonProperty(value = "LastName")
	private String lastName;
	@JsonProperty(value = "MobileNumber")
	private String mobileNumber;
	@JsonProperty(value = "EmailId")
	private String email;
	@JsonProperty(value = "Password")
	private String password;
	
	//@JsonProperty(value = "role")
	private RoleVo roleVo;
	
	
	/* 
	 * Getters and Setters 
	 */
	
	
	public RoleVo getRoleVo() {
		return roleVo;
	}
	
	public void setRoleVo(RoleVo roleVo) {
		this.roleVo = roleVo;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}