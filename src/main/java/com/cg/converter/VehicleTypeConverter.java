package com.cg.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cg.model.VehicleType;
import com.cg.vo.VehicleTypeVo;

@Component
public class VehicleTypeConverter {

	public VehicleTypeVo modelToVo(VehicleType vehicletype) {
		VehicleTypeVo vo=new VehicleTypeVo();
		vo.setVehicleTypeId(vehicletype.getVehicleTypeId());
		vo.setVehicleTypeName(vehicletype.getVehicleTypeName());
		return vo;
	}
	
	public List<VehicleTypeVo> modelToVo(List<VehicleType>vehicletype) {
		return vehicletype.stream().map(x -> modelToVo(x)).collect(Collectors.toList());
	}
	
	public VehicleType voToModel(VehicleTypeVo vo) {
		VehicleType vehicletype=new VehicleType();
		vehicletype.setVehicleTypeId(vo.getVehicleTypeId());
		vehicletype.setVehicleTypeName(vo.getVehicleTypeName());
		return vehicletype;
	}
	
	public List<VehicleType> voToModel(List<VehicleTypeVo> vo) {
		return vo.stream().map(x -> voToModel(x)).collect(Collectors.toList());
	}
	
	
}
