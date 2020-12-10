package com.cg.converter;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cg.model.Mechanics;
import com.cg.vo.MechanicsVo;

@Component
public class MechanicsConverter {

	public MechanicsVo modelToVo(Mechanics mechanic) {
		MechanicsVo vo=new MechanicsVo();
		vo.setId(mechanic.getMechanicId());
		vo.setFirstName(mechanic.getFirstName());
		vo.setLastName(mechanic.getLastName());
		vo.setAddress(mechanic.getAddress());
		vo.setMobileNumber(mechanic.getMobileNumber());
		vo.setEmail(mechanic.getEmail());
		return vo;
	}
	
	public List<MechanicsVo> modelToVo(List<Mechanics> mechanic) {
		return mechanic.stream().map(x -> modelToVo(x)).collect(Collectors.toList());
	}
	
	public Mechanics voToModel(MechanicsVo vo) {
		Mechanics mechanic=new Mechanics();
		mechanic.setMechanicId(vo.getId());
		mechanic.setFirstName(vo.getFirstName());
		mechanic.setLastName(vo.getLastName());
		mechanic.setAddress(vo.getAddress());
		mechanic.setEmail(vo.getEmail());
		mechanic.setMobileNumber(vo.getMobileNumber());
		return mechanic;
	}
	
	public List<Mechanics> voToModel(List<MechanicsVo> vo) {
		return vo.stream().map(x -> voToModel(x)).collect(Collectors.toList());
	}
	
	
}