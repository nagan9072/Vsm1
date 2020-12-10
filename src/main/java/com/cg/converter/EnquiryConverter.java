package com.cg.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cg.model.Enquiry;
import com.cg.vo.EnquiryVo;

@Component
public class EnquiryConverter {
	
	public EnquiryVo modelToVo(Enquiry enquiry) {
		EnquiryVo enqvo=new EnquiryVo();
		enqvo.setEnquiryId(enquiry.getEnquiryId());
		enqvo.setDescription(enquiry.getDescription());
		enqvo.setEnquiryDate(enquiry.getEnquiryDate());
		enqvo.setAdminAction(enquiry.getAdminAction());
		enqvo.setAdminStatus(enquiry.getAdminStatus());
		enqvo.setAdminActionDate(enquiry.getAdminActionDate());
		return enqvo;	
	}
	
	public List<EnquiryVo> modelToVo(List<Enquiry> enquiry) {
		return enquiry.stream().map(x -> modelToVo(x)).collect(Collectors.toList());
	}
     public  Enquiry voToModel(EnquiryVo enqvo){
    	 Enquiry enquiry=new Enquiry();
    	 enquiry.setEnquiryId(enqvo.getEnquiryId());
 		 enquiry.setDescription(enqvo.getDescription());
 		 enquiry.setEnquiryDate(enqvo.getEnquiryDate());
 		 enquiry.setAdminAction(enqvo.getAdminAction());
 		 enquiry.setAdminStatus(enqvo.getAdminStatus());
 		 enquiry.setAdminActionDate(enqvo.getAdminActionDate());
 		 return enquiry; 
     }
     public List<Enquiry> voToModel(List<EnquiryVo> enqvo) {
 		return enqvo.stream().map(x -> voToModel(x)).collect(Collectors.toList());
 	}
}
