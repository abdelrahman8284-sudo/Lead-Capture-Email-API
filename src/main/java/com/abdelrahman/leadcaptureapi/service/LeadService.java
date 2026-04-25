package com.abdelrahman.leadcaptureapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.abdelrahman.leadcaptureapi.exception.AlreadyExistsException;
import com.abdelrahman.leadcaptureapi.exception.RecordNotFoundException;
import com.abdelrahman.leadcaptureapi.model.Lead;
import com.abdelrahman.leadcaptureapi.repository.LeadRepo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LeadService {

	private final LeadRepo repo;
	private final EmailService emailService;

	@Transactional
	public Lead register(Lead lead) {
		if(repo.existsByEmail(lead.getEmail()) || repo.existsByPhone(lead.getPhone())) {
			throw new AlreadyExistsException("This user already register");
		}
		
		Lead savedLead = repo.save(lead);
		String message = "أهلاً يا " + lead.getName() + "، تم استلام بياناتك بنجاح.";
		emailService.sendSimpleEmail(lead.getEmail(), "تأكيد الحجز", message);
		return savedLead;
	}

	public Lead findById(Long id) {
		return repo.findById(id).orElseThrow(() -> new RecordNotFoundException("This id not found!"));
	}

	public List<Lead> getByEmail(String email) {	
		return Optional.ofNullable(repo.findByEmailContainingIgnoreCase(email))
				.filter(list->!list.isEmpty())
				.orElseThrow(()->new RecordNotFoundException("No leads found for this email!"));
	}

	public List<Lead> findByNameAndEmail(String name, String email) {
		return Optional.ofNullable(repo.findByNameContainingIgnoreCaseAndEmailContainingIgnoreCase(name,email))
				.filter(list->!list.isEmpty())
				.orElseThrow(()->new RecordNotFoundException("No leads found for this user!"));

	}

	public List<Lead> findByName(String name) {
		return Optional.ofNullable(repo.findByNameContainingIgnoreCase(name))
				.filter(list->!list.isEmpty())
				.orElseThrow(()->new RecordNotFoundException("No leads found for this name!"));
	}

	public List<Lead> findByAddress(String address) {
		return Optional.ofNullable(repo.findByAddressContainingIgnoreCase(address))
				.filter(list->!list.isEmpty())
				.orElseThrow(()->new RecordNotFoundException("No leads found for this address!"));
	}

	public Page<Lead> findAll(int pageNumber,int pageSize,String sortBy ,String sortType) {
		Pageable page = PageRequest.of(pageNumber, pageSize, Direction.fromString(sortType),sortBy);
		Page<Lead> leads = repo.findAll(page);
		return leads;
	}
}
