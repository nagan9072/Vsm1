package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import com.cg.converter.EnquiryConverter;
import com.cg.exception.DuplicateRecordFoundException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.Enquiry;
import com.cg.repository.EnquiryRepository;
import com.cg.vo.EnquiryVo;

/*defining the business logic */
@Service
public class EnquiryService {
	@Autowired
	private EnquiryRepository enqRepo;
	@Autowired
	private EnquiryConverter enqConverter;

	/*
	 * This method get all enquiry from enquiry table
	 */
	public List<EnquiryVo> getAllEnquiry(){
		List<Enquiry> enquiry=enqRepo.findAll();
		return enqConverter.modelToVo(enquiry);
	}
	/*
	 * This method get enquiry Id from enquiry table
	 */
	public EnquiryVo getEnquiryById(long id) throws ResourceNotFoundException{
		Enquiry enquiry=enqRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Enquiry Not found for this id "+id ));
		EnquiryVo enqVo=enqConverter.modelToVo(enquiry);
		return enqVo;
	}
	/*
	 * This method create enquiry from enquiry table
	 */
	public ResponseEntity<String> createEnquiry(EnquiryVo enqVo) throws DuplicateRecordFoundException {
		Enquiry enquiry=enqConverter.voToModel(enqVo);
		enquiry=enqRepo.save(enquiry);
		EnquiryVo evo=enqConverter.modelToVo(enquiry);
		return new ResponseEntity<> ("Enquiry Added!!"+"Status: "+evo.getAdminStatus(),HttpStatus.OK);
	}
	/*
	 * This method get Admin status enquiry from enquiry table
	 */
	public List<EnquiryVo> getEnquiryByStatus(String status) throws ResourceNotFoundException{
		List<Enquiry> enquiry=enqRepo.findByAdminStatus(status);
		return enqConverter.modelToVo(enquiry);
	}
	/*
	 * This method update the enquiry from enquiry table
	 */
	public EnquiryVo updateEnquiry(long id, EnquiryVo eV) throws ResourceNotFoundException,DuplicateRecordFoundException {
		Enquiry enquiry=enqRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Enquiry Not found for this id "+id ));
		if(enquiry.getDescription().equals(eV.getDescription()) && enquiry.getAdminStatus().equals(eV.getAdminStatus())) {
			throw new DuplicateRecordFoundException("This given values are already exist in the table !!");
		}
		enquiry.setDescription(eV.getDescription());
		enquiry.setAdminStatus(eV.getAdminStatus());
		enqRepo.save(enquiry);
		EnquiryVo enqVo=enqConverter.modelToVo(enquiry);
		return enqVo;
	}
	/*
	 * This method delete enquiry from enquiry table
	 */
	public String deleteStudent(long id) throws ResourceNotFoundException {
		Enquiry enquiry=enqRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Enquiry Not found for this id "+id ));
		enqRepo.delete(enquiry);
		return "Enquiry Deleted Successfully!!";
	}
	
	

}
