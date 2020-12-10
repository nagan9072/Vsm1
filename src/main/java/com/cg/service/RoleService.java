package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.converter.RoleConverter;
import com.cg.exception.DuplicateRecordFoundException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.Role;

import com.cg.repository.RoleRepository;
import com.cg.vo.RoleVo;


@Service
public class RoleService {
	@Autowired
	RoleRepository repo;
	@Autowired
	private RoleConverter converter;
	
	/*
	 * This method adds entity to Role table
	 */
	public ResponseEntity<String> createRoles(RoleVo vo) throws DuplicateRecordFoundException  {
		Role role=converter.voToModel(vo);
		if(repo.findByRoleName(role.getRoleName()).isPresent()) throw new DuplicateRecordFoundException("Enter a valid  Role name!!");
		role=repo.save(role);
		RoleVo rvo=converter.modelToVo(role);
		return new ResponseEntity<>("Registered SuccessFully!!! "+rvo.getRoleName(), HttpStatus.OK); 
	}
	
	/*
	 * This method shows all in Role table
	 */
	public List<RoleVo> getAllRole() {
		List<Role> rol=repo.findAll();
		return converter.modelToVo(rol);
	}
	
	/*
	 * This method adds filters and finds using RoleId in Role table
	 */
	public RoleVo getRoleById(long Id) throws ResourceNotFoundException {
		Role role=repo.findById(Id).orElseThrow(()->new ResourceNotFoundException("no role found with this id "+Id ));
		RoleVo vo=converter.modelToVo(role);
		return vo;
	}
	/*
	 * This method update entity to Role table
	 */
	public RoleVo updateRole(long Id, RoleVo v) throws ResourceNotFoundException {
		Role role=repo.findById(Id).orElseThrow(()->new ResourceNotFoundException("no role found with this id "+Id ));
		role.setRoleName(v.getRoleName());
		repo.save(role);
		RoleVo vo=converter.modelToVo(role);
		return vo;
	}
	/*
	 * This method delete entity to Role table
	 */
	public String deleteRole(long Id) throws ResourceNotFoundException {
		Role role=repo.findById(Id).orElseThrow(()->new ResourceNotFoundException("no role found with this id "+Id ));
		repo.delete(role);
		return "Record Deleted Successfully!!";
	}

	public ResponseEntity<String> save(RoleVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
