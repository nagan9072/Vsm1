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
import com.cg.service.EnquiryService;
import com.cg.validation.ValidCheck;
import com.cg.vo.EnquiryVo;

//mark class as Controller  
@RestController
public class EnquiryController {
	//autowire the EnquiryService class  
	@Autowired 
	private EnquiryService enquiryService;
	
	@Autowired
	private ValidCheck valid;
	
	
	//creating post mapping that post the enquiry detail in the database  
	@PostMapping("/enquiries/new")
	public ResponseEntity<String> createEnquiry(@RequestBody EnquiryVo enqVo) throws DuplicateRecordFoundException, IntrusionException, ValidationException, InvalidInputException {
		boolean value=valid.enquiryCheck(enqVo);
		ResponseEntity<String> result=null;
		if(value) {
			result=enquiryService.createEnquiry(enqVo);
		}
		return result;
	} 
	//creating a get mapping that retrieves all the enquiry detail from the database   
	@GetMapping("/enquiries/all")
	public ResponseEntity<List<EnquiryVo>> getEnquiries() {
		List<EnquiryVo> enqVo=enquiryService.getAllEnquiry();
		return ResponseEntity.ok(enqVo);
	}
	//using get method and retrieves a specific enquiry detail
	@GetMapping("/enquiries/{id}")
	public ResponseEntity<EnquiryVo> getEnquiryId(@PathVariable(value="id") long enqId) throws ResourceNotFoundException{
		EnquiryVo enquiryVo=enquiryService.getEnquiryById(enqId);
		return ResponseEntity.ok().body(enquiryVo);
	}
	//using get method and retrieves a specific enquiry status detail
	/*
	 * @GetMapping("/enquires/status/{status}") public List<EnquiryVo>
	 * getEnquiryStatus(@PathVariable(value="status") String enqStatus) throws
	 * ResourceNotFoundException { EnquiryVo
	 * enquiryVo=enquiryService.getEnquiryStatus(enqStatus); return
	 * ResponseEntity.ok().body(enqStatus); }
	 */
	@GetMapping("/enquiries/status/{status}")
	public ResponseEntity<List<EnquiryVo>> getEnquiryByStatus(@PathVariable(value="status") String status) throws ResourceNotFoundException{
		List<EnquiryVo> enquiryVo=enquiryService.getEnquiryByStatus(status);
		return ResponseEntity.ok().body(enquiryVo);
	}
	//creating put mapping that updates the enquiry detail  
	@PutMapping("/enquiries/{id}")
	public ResponseEntity<EnquiryVo> updateEnquiry(@PathVariable(value="id") long enqId,@RequestBody EnquiryVo eV) throws ResourceNotFoundException, IntrusionException, ValidationException, InvalidInputException, DuplicateRecordFoundException {
		boolean value=valid.enquiryCheck(eV);
		EnquiryVo result=null;
		if(value) {
			result=enquiryService.updateEnquiry(enqId, eV);
		}
		return ResponseEntity.ok().body(result);
		//return ResponseEntity.ok().body(enqVo);
	}
	//creating a delete mapping that deletes a specified enquiry  
	@DeleteMapping("/enquiries/{id}")
	public String deleteEnquiry(@PathVariable(value="id") long enqId) throws ResourceNotFoundException {
	      String result=enquiryService.deleteStudent(enqId);
		return result;
	}
}
