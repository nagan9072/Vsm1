package com.cg.vo;

import java.io.Serializable;



import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.Data;

@Data
public class RoleVo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value="roleId")
	private long roleId;
	@JsonProperty(value="roleName")
	private String roleName;
	
	public RoleVo() {
	}
	public RoleVo(long roleId) {
		super();
		this.roleId = roleId;
	}
	public RoleVo(long roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}
	
	// getters and setters of entity table
	public long getRoleId() {
			return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}

