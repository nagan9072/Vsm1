package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.converter.ServicePriceConverter;
import com.cg.exception.DuplicateRecordFoundException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.ServicePrice;
import com.cg.repository.ServicePriceRepository;
import com.cg.vo.ServicePriceVo;

@Service
public class ServicePriceService {
  @Autowired
  private ServicePriceRepository servicePriceRepo;
   @Autowired
   private ServicePriceConverter converter;
    /*
	 * This method adds entity to ServicePrice entity
	 */
    
    public ResponseEntity<String> createServicePrice(ServicePriceVo servicePriceVo) throws DuplicateRecordFoundException {
    	ServicePrice servicePrice = converter.voToModel(servicePriceVo);
    	if(servicePriceRepo.findByServiceAmount(servicePrice.getServiceAmount()).isPresent()) throw new DuplicateRecordFoundException("Enter a valid  ServiceAmount");
    	servicePrice = servicePriceRepo.save(servicePrice);
    	ServicePriceVo svo = converter.modelToVo(servicePrice);
    	return new ResponseEntity<>("Registered SuccessFully!!!! "+svo.getServiceAmount(), HttpStatus.OK);
    }
    
    /*
	 * This method displays all entity from ServicePrice table
	 */
    
    public List<ServicePriceVo> getAllServicePrice(){
    	List<ServicePrice>st = servicePriceRepo.findAll();
    	return converter.modelToVo(st);
	}
    
    
    /*
	 * This method delete entity from ServicePrice table
	 */
	
    
	public String deleteServicePrice(long servicePriceId)throws ResourceNotFoundException {
		ServicePrice servicePrice = servicePriceRepo.findById(servicePriceId).orElseThrow(()-> new ResourceNotFoundException("ServicePriceId not found"));
		servicePriceRepo.delete(servicePrice);
		return "Record Deleted Successfully!!";
	}
	
	/*
	 * This method search the entity using ServicePriceId
	 */
	
	public  ServicePriceVo getServicePriceByServicePriceId(long servicePriceId)throws ResourceNotFoundException {
		ServicePrice servicePrice = servicePriceRepo.findById(servicePriceId).orElseThrow(()-> new ResourceNotFoundException("ServicePriceId not found"));
		ServicePriceVo servicePriceVo =converter.modelToVo(servicePrice);
		return servicePriceVo;
		
	}
	
	/*
	 * This method updates  entity in ServicePrice table
	 */

	
	public ServicePriceVo updateServicePrice(long servicePriceId,ServicePriceVo servicePriceVo) throws ResourceNotFoundException, DuplicateRecordFoundException{
		ServicePrice servicePrice = servicePriceRepo.findById(servicePriceId).orElseThrow(()-> new ResourceNotFoundException("ServicePriceId not found"));
		if(servicePriceRepo.findByServiceAmount(servicePriceVo.getServiceAmount()).isPresent()) throw new DuplicateRecordFoundException("Enter a valid  ServiceAmount");
		servicePrice.setServiceAmount(servicePriceVo.getServiceAmount());
		servicePriceRepo.save(servicePrice);
		ServicePriceVo svo = converter.modelToVo(servicePrice);
		return svo;
	}
}
