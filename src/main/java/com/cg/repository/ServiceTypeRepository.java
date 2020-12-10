package com.cg.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.model.ServiceType;



@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceType, Long>{

	public Optional<ServiceType> findByServiceTypeName(String serviceTypeName);

}
