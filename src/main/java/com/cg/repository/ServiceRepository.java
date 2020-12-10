package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.model.Services;
import com.cg.model.User;

@Repository
public interface ServiceRepository extends JpaRepository<Services,Long>{
	public List<Services> findByAdminStatus(String adminStatus);
	
	/* @Query("SELECT s FROM Services s WHERE s.vehicleBrand =:a and s.vehicleRegno=:b")
	public Services findByAll(String a,String b);  */
	
}
