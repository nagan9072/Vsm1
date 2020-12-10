package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.converter.ServiceTypeConverter;
import com.cg.exception.DuplicateRecordFoundException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.ServiceType;
import com.cg.repository.ServiceTypeRepository;
import com.cg.vo.ServiceTypeVo;

@Service
public class ServiceTypeService {
    @Autowired
	private ServiceTypeRepository  serviceRepo;
    @Autowired
	private ServiceTypeConverter converter;
	
    
    /*
	 * This method adds entity to ServiceType entity
	 */
    
	public  ResponseEntity<String> createServiceType(ServiceTypeVo vo)throws DuplicateRecordFoundException {
    	ServiceType  serviceType = converter.voToModel(vo);
    	if(serviceRepo.findByServiceTypeName(serviceType.getServiceTypeName()).isPresent()) throw new DuplicateRecordFoundException("Enter a valid  ServiceType name");
    	serviceType = serviceRepo.save(serviceType);
    	ServiceTypeVo svo = converter.modelToVo(serviceType);
    	return new ResponseEntity<>("Registered SuccessFully!!!! "+svo.getServiceTypeName(), HttpStatus.OK);
    	
    }
	
	/*
   	 * This method displays all entity from ServiceType table
   	 */
	
	public List<ServiceTypeVo> getAllServiceType(){
		List<ServiceType> st = serviceRepo.findAll();
		return converter.modelToVo(st);
	}
	
	 /*
  	 * This method delete entity from ServiceType table
  	 */
	
	public String deleteServiceType(long serviceTypeId) throws ResourceNotFoundException{
		ServiceType serviceType = serviceRepo.findById(serviceTypeId).orElseThrow(()-> new ResourceNotFoundException("ServiceTypeId not found"));
	    serviceRepo.delete(serviceType);  
		return "Record Deleted Successfully!!";
	}
	
	/*
	 * This method search the entity using ServiceTypeId
	 */
	
	public ServiceTypeVo getServiceTypeById(long serviceTypeId) throws ResourceNotFoundException {
		ServiceType serviceType = serviceRepo.findById(serviceTypeId).orElseThrow(()-> new ResourceNotFoundException("ServiceTypeId not found"));
		ServiceTypeVo vo = converter.modelToVo(serviceType);
		return vo;
}
    /*
	 * This method updates  entity in ServiceType table
	 */
	
	public ServiceTypeVo updateServiceType(long serviceTypeId, ServiceTypeVo vo)throws ResourceNotFoundException, DuplicateRecordFoundException {
		ServiceType serviceType = serviceRepo.findById(serviceTypeId).orElseThrow(()-> new ResourceNotFoundException("ServiceTypeId not found"));
		if(serviceRepo.findByServiceTypeName(vo.getServiceTypeName()).isPresent()) throw new DuplicateRecordFoundException("Enter a valid  ServiceType name");
		serviceType.setServiceTypeName(vo.getServiceTypeName());
		serviceRepo.save(serviceType);
		ServiceTypeVo svo = converter.modelToVo(serviceType);
		return svo;
	}
	
}
