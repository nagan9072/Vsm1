package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.converter.VehicleTypeConverter;
import com.cg.exception.DuplicateRecordFoundException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.Role;
import com.cg.model.VehicleType;

import com.cg.repository.VehicleTypeRepository;
import com.cg.vo.RoleVo;
import com.cg.vo.VehicleTypeVo;


@Service
public class VehicleTypeService {
	@Autowired
	VehicleTypeRepository repo;
	@Autowired
	private VehicleTypeConverter converter;
	/*
	 * This method adds entity in VehicleType table
	 */
	public ResponseEntity<String> createVehicleTypes(VehicleTypeVo vo) throws DuplicateRecordFoundException{
		VehicleType vehicletype=converter.voToModel(vo);
		if(repo.findByVehicleTypeName(vehicletype.getVehicleTypeName()).isPresent()) throw new DuplicateRecordFoundException("Enter a valid  vehicletype name");
		vehicletype=repo.save(vehicletype);
		VehicleTypeVo vtvo=converter.modelToVo(vehicletype);
		return new ResponseEntity<>("Registered SuccessFully!!! "+vtvo.getVehicleTypeName(),  HttpStatus.OK);
	}
	/*
	 * This method shows all in VehicleType table
	 */
	public List<VehicleTypeVo> getAllVehicleType() {
		List<VehicleType> vehicle=repo.findAll();
		return converter.modelToVo(vehicle);
	}
	
	/*
	 * This method adds filters and finds using VehicleTypeId in VehicleType table
	 */
	public VehicleTypeVo getVehicleTypeById(long Id) throws ResourceNotFoundException {
		VehicleType vehicletype=repo.findById(Id).orElseThrow(()->new ResourceNotFoundException("no vehicle found with this id "+Id ));
		VehicleTypeVo vo=converter.modelToVo(vehicletype);
		return vo;
	}
	
	/*
	 * This method update entity to Role table
	 */
	public VehicleTypeVo updateVehicleType(long Id, VehicleTypeVo v) throws ResourceNotFoundException {
		VehicleType vehicletype=repo.findById(Id).orElseThrow(()->new ResourceNotFoundException("no vehicle found with this id "+Id ));
		vehicletype.setVehicleTypeName(v.getVehicleTypeName());
		repo.save(vehicletype);
		VehicleTypeVo vo=converter.modelToVo(vehicletype);
		return vo;
	}
	/*
	 * This method delete entity to Role table
	 */
	public String deleteVehicleType(long Id) throws ResourceNotFoundException {
		VehicleType vehicletype=repo.findById(Id).orElseThrow(()->new ResourceNotFoundException("no vehicle found with this id "+Id ));
		repo.delete(vehicletype);
		return "Record Deleted Successfully!!";
	}
	public ResponseEntity<String> save(VehicleTypeVo vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}