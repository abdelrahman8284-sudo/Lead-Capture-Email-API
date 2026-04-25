package com.abdelrahman.leadcaptureapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abdelrahman.leadcaptureapi.model.Lead;
@Repository
public interface LeadRepo extends JpaRepository<Lead, Long>{
	
		List<Lead> findByEmailContainingIgnoreCase(String subEmail);
		List<Lead> findByNameContainingIgnoreCaseAndEmailContainingIgnoreCase(String subName , String subEmail);
		List<Lead> findByNameContainingIgnoreCase(String subName);
		List<Lead> findByAddressContainingIgnoreCase(String address);
		boolean existsByEmail(String email);
		boolean existsByPhone(String phone);
}
