package com.cg.controller;

import java.util.List;

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
import com.cg.service.ServiceService;
import com.cg.validation.ValidCheck;
import com.cg.vo.ServiceVo;

@RestController
public class ServiceController {
	@Autowired
	private ServiceService servService;
	
	@Autowired
	private ValidCheck valid;
	/*
	 * This method add the records to Service table
	 */
	@PostMapping("/service/new")
	public ResponseEntity<String> createService(@RequestBody ServiceVo vo) throws IntrusionException, ValidationException, InvalidInputException {
		boolean value=valid.serviceCheck(vo);
		ResponseEntity<String> result = null;
		if(value) {
			result=servService.save(vo);
		}
		return result;
	} 
	
	/*
	 * This method returns all the records from Service table
	 */
	@GetMapping("/service/all")
	public ResponseEntity<List<ServiceVo>> getServices() {
		List<ServiceVo> vo=servService.getAllService();
		return ResponseEntity.ok(vo);
	}
	
	/*
	 * This method adds filters and finds using ServiceId in Service table
	 */
	@GetMapping("/service/{id}")
	public ResponseEntity<ServiceVo> getServiceById(@PathVariable(value="id") long id) throws ResourceNotFoundException {
		ServiceVo vo=servService.getServiceById(id);
		return ResponseEntity.ok().body(vo);
	}
	
	/*
	 * This method adds filters and finds using AdminStatus in Service table
	 */
	@GetMapping("/service/status/{status}")
	public ResponseEntity<List<ServiceVo>> getServiceByStatus(@PathVariable(value="status") String status) throws ResourceNotFoundException {
		List<ServiceVo> vo=servService.getServiceByStatus(status);
		return ResponseEntity.ok().body(vo);
	}
	
	/*
	 * This method update the record of Service table
	 */
	@PutMapping("/service/{id}")
	public ResponseEntity<ServiceVo> updateService(@PathVariable(value="id") long id,@RequestBody ServiceVo v) throws ResourceNotFoundException, IntrusionException, ValidationException, InvalidInputException, DuplicateRecordFoundException{
		boolean value=valid.serviceCheck(v);
		ServiceVo vo = null;
		if(value) {
			vo=servService.updateService(id, v);
		}
		return ResponseEntity.ok().body(vo);
	}
	
	/*
	 * This method delete the record of Service table
	 */
	@DeleteMapping("/service/{id}")
	public String deleteService(@PathVariable(value="id") long id) throws ResourceNotFoundException{
		String result=servService.deleteService(id);
		return result;
	}
	
}

