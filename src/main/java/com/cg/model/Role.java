package com.cg.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.cg.vo.UserVo;

@Entity// Declare the class as entity or table
@Table(name ="Role")  // Declare the table name
public class Role {
	
	@Id // specifies the property, use for identity of the class
	@Column(name = "ROLE_ID") //Specify the column name
	@GeneratedValue(strategy = GenerationType.AUTO) //generates an automatic value during commit for every new entity object
	private long roleId;
	
	@Column(name = "ROLE_NAME")
	private String roleName;
	
	/* 
	 * creating one to many relation with User
	 */
	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
	private Set<User> user = new HashSet<User>();
	
	public Role() {};
	
	public Role(long roleId) {
		super();
		this.roleId = roleId;
	}
	
	public Role(long roleId, String roleName) {
		super();
		this.roleId= roleId;
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
	
	//Override toString() method
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
}
