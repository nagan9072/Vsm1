package com.cg.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cg.model.Services;
import com.cg.vo.ServiceVo;

@Component
public class ServiceConverter {
	public ServiceVo modelToVo(Services service) {
		ServiceVo vo=new ServiceVo();
		vo.setDeliveryDate(service.getDeliveryDate());
		vo.setServiceId(service.getServiceId());
		vo.setVehicleBrand(service.getVehicleBrand());
		vo.setVehicleRegno(service.getVehicleRegno());
		vo.setAdminStatus(service.getAdminStatus());
		vo.setServiceRequestDate(service.getServiceRequestDate());
		return vo;
	}
	
	public List<ServiceVo> modelToVo(List<Services> student) {
		return student.stream().map(x -> modelToVo(x)).collect(Collectors.toList());
	}
	
	public Services voToModel(ServiceVo vo) {
		Services service=new Services();
		service.setDeliveryDate(vo.getDeliveryDate());
		service.setServiceId(vo.getServiceId());
		service.setVehicleBrand(vo.getVehicleBrand());
		service.setVehicleRegno(vo.getVehicleRegno());
		service.setAdminStatus(vo.getAdminStatus());
		service.setServiceRequestDate(vo.getServiceRequestDate());
		return service;
	}
	
	public List<Services> voToModel(List<ServiceVo> vo) {
		return vo.stream().map(x -> voToModel(x)).collect(Collectors.toList());
	}
	
	
}
