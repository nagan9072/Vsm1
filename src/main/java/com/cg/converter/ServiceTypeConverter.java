package com.cg.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cg.model.ServiceType;
import com.cg.vo.ServiceTypeVo;

@Component
public class ServiceTypeConverter {
	public ServiceTypeVo modelToVo(ServiceType serviceType) {
		ServiceTypeVo vo=new ServiceTypeVo();
		vo.setServiceTypeId(serviceType.getServiceTypeId());
		vo.setServiceTypeName(serviceType.getServiceTypeName());
		return vo;
	}

	public List<ServiceTypeVo> modelToVo(List<ServiceType> serviceType) {
		return serviceType.stream().map(x -> modelToVo(x)).collect(Collectors.toList());
	}

	public ServiceType voToModel(ServiceTypeVo vo) {
		ServiceType serviceType=new ServiceType();
		serviceType.setServiceTypeId(vo.getServiceTypeId());
		serviceType.setServiceTypeName(vo.getServiceTypeName());
		return serviceType;
	}

	public List<ServiceType> voToModel(List<ServiceTypeVo> vo) {
		return vo.stream().map(x -> voToModel(x)).collect(Collectors.toList());
	}
}
