package com.cg.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.DuplicateRecordFoundException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.ServicePrice;
import com.cg.service.ServicePriceService;
import com.cg.vo.ServicePriceVo;



@RestController
public class ServicePriceController {
	 
	@Autowired
	private ServicePriceService servicePriceService;
	 
	/*
	 * This method adds entity to ServicePrice entity
	 */
	
	@PostMapping("/serviceprice/new")
	public ResponseEntity<String> createServicePrice(@RequestBody ServicePriceVo servicePriceVo) throws DuplicateRecordFoundException {
		ResponseEntity<String> result = servicePriceService.createServicePrice(servicePriceVo);
		return result;
	}
	
	 
	/*
	 * This method displays all entity from ServicePrice table
	 */
	
	  @GetMapping("/serviceprice/all")
      public ResponseEntity<List<ServicePriceVo>> getAllServicePrice(){
		  List<ServicePriceVo> servicePriceVo = servicePriceService.getAllServicePrice(); 
		  return ResponseEntity.ok(servicePriceVo); 
      }
	  
    /*
	 * This method delete entity from ServicePrice table
	 */
	
	 @DeleteMapping("/serviceprice/{id}") 
	  public String deleteServicePrice(@PathVariable(value="id") long servicePriceId)throws ResourceNotFoundException {
	  String result = servicePriceService.deleteServicePrice(servicePriceId);
	  return result;
	  }
	 
    /*
	 * This method updates  entity in ServicePrice table
	 */
	 
	 @PutMapping("/serviceprice/{id}") 
	  public ResponseEntity<ServicePriceVo> updateServicePrice(@PathVariable(value="id") long servicePriceId,@RequestBody ServicePriceVo servicePriceVo)throws ResourceNotFoundException, DuplicateRecordFoundException {
	  ServicePriceVo svo =  servicePriceService.updateServicePrice(servicePriceId, servicePriceVo);
	  return ResponseEntity.ok(svo);
	  }
	 
	 
    /*
	 * This method search the entity using ServicePriceId
	 */
	 
	 @GetMapping("/serviceprice/{id}")
	 public ResponseEntity<ServicePriceVo> getServicePriceByServicePriceId(@PathVariable(value="id") long servicePriceId) throws ResourceNotFoundException {
		 ServicePriceVo servicePriceVo = servicePriceService.getServicePriceByServicePriceId(servicePriceId);
	     return ResponseEntity.ok().body(servicePriceVo);
	 }
	 

}
