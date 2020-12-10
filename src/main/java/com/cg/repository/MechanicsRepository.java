package com.cg.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.model.Mechanics;
import com.cg.vo.MechanicsVo;

@Repository
public interface MechanicsRepository extends JpaRepository<Mechanics, Long>{
	public Mechanics findBymobileNumber(String mobileNumber);
	public Optional<Mechanics> findByEmail(String email);
	

}
