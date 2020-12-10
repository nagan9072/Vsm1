package com.cg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.model.Role;
import com.cg.model.VehicleType;

@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleType,Long>{
	public Optional<VehicleType> findByVehicleTypeName(String VehicleTypeName);

}
