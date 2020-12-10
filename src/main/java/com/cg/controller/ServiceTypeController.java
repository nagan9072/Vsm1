package com.cg.controller;

import java.util.List;
import java.util.Optional;

import org.owasp.esapi.errors.IntrusionException;
import org.owasp.esapi.errors.ValidationException;
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
import com.cg.exception.InvalidInputException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.ServiceType;
import com.cg.repository.ServiceTypeRepository;
import com.cg.service.ServiceTypeService;
import com.cg.validation.ValidCheck;
import com.cg.vo.ServiceTypeVo;

@RestController
public class ServiceTypeController {
    @Autowired
	private ServiceTypeService serviceTypeService;
    @Autowired
    private ValidCheck check;
    
    /*
	 * This method adds entity to ServiceType entity
	 */
    
      @PostMapping("/servicetype/new")
      public ResponseEntity<String> createServiceType(@RequestBody ServiceTypeVo vo)throws InvalidInputException, DuplicateRecordFoundException, IntrusionException, ValidationException {
    	  ResponseEntity<String> result = null;
    	  if(check.serviceTypeCheck(vo)) {
    	  result = serviceTypeService.createServiceType(vo);
    	  }
        return result;
      }
    
    
   	/*
   	 * This method displays all entity from ServiceType table
   	 */
    
      @GetMapping("/servicetype/all")
      public ResponseEntity<List<ServiceTypeVo>> getAllServiceType(){
       List<ServiceTypeVo> vo = serviceTypeService.getAllServiceType(); 
       return ResponseEntity.ok(vo);
      }
      
     /*
  	 * This method delete entity from ServiceType table
  	 */
		
	  @DeleteMapping("/servicetype/{id}") 
	  public String deleteServiceType(@PathVariable(value="id") long serviceTypeId)throws ResourceNotFoundException {
	  String result = serviceTypeService.deleteServiceType(serviceTypeId);
	  return result;
	  }
	  
     /*
	 * This method updates  entity in ServiceType table
	 */
	  
	  @PutMapping("/servicetype/{id}")
	  public ResponseEntity<ServiceTypeVo> updateServiceType(@PathVariable(value="id") long serviceTypeId,@RequestBody ServiceTypeVo svo) throws InvalidInputException, ResourceNotFoundException, DuplicateRecordFoundException, IntrusionException, ValidationException {
		  ServiceTypeVo vo = null;
		  if(check.serviceTypeCheck(svo)) {
		   vo = serviceTypeService.updateServiceType(serviceTypeId, svo);
		  }
	  return ResponseEntity.ok(vo);
	  }
	  
         /*
	 * This method search the entity using ServiceTypeId
	 */
      @GetMapping("/servicetype/{id}")
      public ResponseEntity<ServiceTypeVo> getServiceTypeByServiceTypeById(@PathVariable(value="id") long serviceTypeId) throws ResourceNotFoundException {
    	 ServiceTypeVo service = serviceTypeService.getServiceTypeById(serviceTypeId);
         return ResponseEntity.ok().body(service);
      } 
    
    
    
}



