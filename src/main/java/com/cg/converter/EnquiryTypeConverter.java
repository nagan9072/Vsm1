package com.cg.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cg.model.EnquiryType;
import com.cg.vo.EnquiryTypeVo;

@Component
public class EnquiryTypeConverter {

	/*
	 * Converting all the EnquiryType model to Vo which is returning single value
	 */
	public EnquiryTypeVo modelToVo(EnquiryType EnTy) {
		EnquiryTypeVo vo=new EnquiryTypeVo();
		vo.setEnquiryTypeId(EnTy.getEnquiryTypeId());
		vo.setEnquiryTypeName(EnTy.getEnquiryTypeName());
		return vo;
	}
	
	/*
	 * Converting the EnquiryType model to Vo which is returning Multiple value
	 */
	public List<EnquiryTypeVo> modelToVo(List<EnquiryType> EnTy) {
		return EnTy.stream().map(x -> modelToVo(x)).collect(Collectors.toList());
	}
	
	/*
	 * Converting all the EnquiryType Vo to Model which is returning single value
	 */
	public EnquiryType voToModel(EnquiryTypeVo vo) {
		EnquiryType EnTy=new EnquiryType();
		EnTy.setEnquiryTypeId(vo.getEnquiryTypeId());
		EnTy.setEnquiryTypeName(vo.getEnquiryTypeName());
		return EnTy;
	}
	
	/*
	 * Converting the EnquiryType Vo to Model which is returning Multiple value
	 */
	public List<EnquiryType> voToModel(List<EnquiryTypeVo> vo) {
		return vo.stream().map(x -> voToModel(x)).collect(Collectors.toList());
	}
	
	
}
