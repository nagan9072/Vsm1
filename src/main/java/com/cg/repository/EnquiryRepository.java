package com.cg.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.model.Enquiry;


//repository that extends JpaRepository  
@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Long>{

	public List<Enquiry> findByAdminStatus(String status);
	

}
