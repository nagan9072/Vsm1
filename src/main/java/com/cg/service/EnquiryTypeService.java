package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.converter.EnquiryTypeConverter;
import com.cg.exception.DuplicateRecordFoundException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.EnquiryType;
import com.cg.repository.EnquiryTypeRepository;
import com.cg.vo.EnquiryTypeVo;

@Service
public class EnquiryTypeService {
	
	@Autowired
	EnquiryTypeRepository repo;
	@Autowired
	private EnquiryTypeConverter converter;
	
	/*
	 * Service to view all the Enquiry Types
	 */
	public List<EnquiryTypeVo> getAllEnquiryTypes() {
		List<EnquiryType> EnTy=repo.findAll();
		return converter.modelToVo(EnTy);
	}

	/*
	 * Service to get Enquiry Type by Id
	 */
	public EnquiryTypeVo getEnquTypeById(long id) throws ResourceNotFoundException {
		EnquiryType EnTy=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("no enquiry type is found with this id "+id ));
		EnquiryTypeVo vo=converter.modelToVo(EnTy);
		return vo;
	}

	/*
	 * Service to add new EnquiryType
	 */
	public ResponseEntity<String> addEnquiryType(EnquiryTypeVo vo) { 
		EnquiryType EnTy=converter.voToModel(vo);
		EnTy=repo.save(EnTy);
		EnquiryTypeVo svo=converter.modelToVo(EnTy);
		return new ResponseEntity<>("Registered SuccessFully!!! "+svo.getEnquiryTypeName(), HttpStatus.OK); 
	}

	/*
	 * Service to Update Exisiting Enquiry Type
	 */
	public EnquiryTypeVo updateEnquiryType(long id, EnquiryTypeVo v) throws ResourceNotFoundException, DuplicateRecordFoundException {
		EnquiryType EnTy=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("no enquiry type is found with this id "+id ));
		if(EnTy.getEnquiryTypeName().equals(v.getEnquiryTypeName()))
		{
			throw new DuplicateRecordFoundException("The given update is the same as before");
		}
		EnTy.setEnquiryTypeName(v.getEnquiryTypeName());
		repo.save(EnTy);
		EnquiryTypeVo vo=converter.modelToVo(EnTy);
		return vo;
	}

	/*
	 * Service to Delete Exisiting Enquiry Type
	 */
	public String deleteEnquiryType(long id) throws ResourceNotFoundException {
		EnquiryType EnTy=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("no enquiry type is found with this id "+id ));
		repo.delete(EnTy);
		return "Record Deleted Successfully!!";
	}
	
}
