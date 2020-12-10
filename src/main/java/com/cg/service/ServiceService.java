package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.converter.ServiceConverter;
import com.cg.exception.DuplicateRecordFoundException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.Services;
import com.cg.repository.ServiceRepository;
import com.cg.vo.ServiceVo;


@Service
public class ServiceService {
	
	@Autowired
	ServiceRepository repo;
	@Autowired
	private ServiceConverter converter;
	
	/*
	 * This method returns all the records of Service table
	 */
	public List<ServiceVo> getAllService() {
		List<Services> st=repo.findAll();
		return converter.modelToVo(st);
	}

	/*
	 * This method adds filters and finds using ServiceId in Service table
	 */
	public ServiceVo getServiceById(long id) throws ResourceNotFoundException {
		Services service=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("No service found with this id "+id ));
		ServiceVo vo=converter.modelToVo(service);
		return vo;
	}

	/*
	 * This method add the records to Service table
	 */
	public ResponseEntity<String> save(ServiceVo vo) {
		Services service=converter.voToModel(vo);
		service=repo.save(service);
		ServiceVo svo=converter.modelToVo(service);
		return new ResponseEntity<>("Service Registered SuccessFully!!!  Your Service Id:"+svo.getServiceId(),HttpStatus.OK);
	}

	/*
	 * This method update the records of Service table
	 */
	public ServiceVo updateService(long id, ServiceVo v) throws ResourceNotFoundException, DuplicateRecordFoundException {
		Services service=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("No service found with this id "+id ));
		if(service.getVehicleBrand().equals(v.getVehicleBrand()) && service.getVehicleRegno().equals(v.getVehicleRegno())) {
			throw new DuplicateRecordFoundException("The given values are already available in the table!! Please try to update New Values...");
		}
		service.setVehicleRegno(v.getVehicleRegno());
		service.setVehicleBrand(v.getVehicleBrand());
		repo.save(service);
		ServiceVo vo=converter.modelToVo(service);
		return vo;
	}

	/*
	 * This method delete the record of Service table
	 */
	public String deleteService(long id) throws ResourceNotFoundException {
		Services service=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("No service found with this id "+id ));
		repo.delete(service);
		return "Service Deleted Successfully!!";
	}

	/*
	 * This method adds filters and finds using AdminStatus in Service table
	 */
	public List<ServiceVo> getServiceByStatus(String status) {
		List<Services> service=repo.findByAdminStatus(status);
		return converter.modelToVo(service);
	}

	
}
