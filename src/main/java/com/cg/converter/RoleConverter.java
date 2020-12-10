package com.cg.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cg.model.Role;
import com.cg.vo.RoleVo;

@Component
public class RoleConverter {

	public RoleVo modelToVo(Role role) {
		RoleVo vo=new RoleVo();
		vo.setRoleId(role.getRoleId());
		vo.setRoleName(role.getRoleName());
		return vo;
	}
	
	public List<RoleVo> modelToVo(List<Role> role) {
		return role.stream().map(x -> modelToVo(x)).collect(Collectors.toList());
	}
	
	public Role voToModel(RoleVo vo) {
		Role role=new Role();
		role.setRoleId(vo.getRoleId());
		role.setRoleName(vo.getRoleName());
		return role;
	}
	
	public List<Role> voToModel(List<RoleVo> vo) {
		return vo.stream().map(x -> voToModel(x)).collect(Collectors.toList());
	}
	
	
}
