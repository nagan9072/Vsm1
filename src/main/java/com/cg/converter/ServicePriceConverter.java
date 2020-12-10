package com.cg.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cg.model.ServicePrice;
import com.cg.vo.ServicePriceVo;

@Component
public class ServicePriceConverter {
	public ServicePriceVo modelToVo(ServicePrice servicePrice) {
		ServicePriceVo vo=new ServicePriceVo();
		vo.setServicePriceId(servicePrice.getServicePriceid());
		vo.setServiceAmount(servicePrice.getServiceAmount());
		return vo;
	}

	public List<ServicePriceVo> modelToVo(List<ServicePrice> servicePrice) {
		return servicePrice.stream().map(x -> modelToVo(x)).collect(Collectors.toList());
	}

	public ServicePrice voToModel(ServicePriceVo vo) {
		ServicePrice servicePrice=new ServicePrice();
		servicePrice.setServicePriceid(vo.getServicePriceId());
		servicePrice.setServiceAmount(vo.getServiceAmount());
		return servicePrice;
	}

	public List<ServicePrice> voToModel(List<ServicePriceVo> vo) {
		return vo.stream().map(x -> voToModel(x)).collect(Collectors.toList());
	}
}

