package com.abdelrahman.leadcaptureapi.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abdelrahman.leadcaptureapi.dto.ApiResponse;
import com.abdelrahman.leadcaptureapi.dto.LeadRequest;
import com.abdelrahman.leadcaptureapi.dto.LeadResponse;
import com.abdelrahman.leadcaptureapi.mapper.LeadMapper;
import com.abdelrahman.leadcaptureapi.model.Lead;
import com.abdelrahman.leadcaptureapi.service.LeadService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/leads")
@Validated
@RequiredArgsConstructor
public class LeadController {

	private final LeadService leadService;
	private final LeadMapper mapper;
	
	@PostMapping
	public ResponseEntity<ApiResponse> register(@Valid@RequestBody LeadRequest request){
		Lead object = leadService.register(mapper.toEntity(request));
		return new ResponseEntity<ApiResponse>(new ApiResponse("You register successfully!", object), HttpStatus.CREATED);
	}
	@GetMapping("/search-email")
	public ResponseEntity<ApiResponse> getByEmail(@Email@NotBlank@RequestParam String email){
		
		List<Lead> leads =   leadService.getByEmail(email);
		List<LeadResponse> response = mapper.toListDto(leads);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Find successflly", response), HttpStatus.OK);
	}
	@GetMapping("/search-name")
	public ResponseEntity<ApiResponse> getByName(@NotBlank@RequestParam String name){
		List<Lead> leads =   leadService.findByName(name);
		List<LeadResponse> response = mapper.toListDto(leads);		return new ResponseEntity<ApiResponse>(new ApiResponse("Find successflly", response), HttpStatus.OK);
	}
	@GetMapping("/search-name-email")
	public ResponseEntity<ApiResponse> getByNameAndEmail(@NotBlank@RequestParam String name,@Email@NotBlank@RequestParam String email){
		List<Lead> leads =   leadService.findByNameAndEmail(name,email);
		List<LeadResponse> response = mapper.toListDto(leads);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Find successflly", response), HttpStatus.OK);
	}
	@GetMapping("/search-address")
	public ResponseEntity<ApiResponse> getByAddress(@NotBlank@RequestParam String address){
		List<Lead> leads =   leadService.findByAddress(address);
		List<LeadResponse> response = mapper.toListDto(leads);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Find successflly", response), HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<ApiResponse> getAll(
			@RequestParam(defaultValue = "0") int pageNumber,
			@RequestParam(defaultValue = "5") int pageSize,
			@RequestParam(defaultValue = "createdAt") String sortBy,
			@RequestParam(defaultValue = "ASC") String sortType
			){
		Page<Lead> leads =  leadService.findAll(pageNumber,pageSize,sortBy,sortType);
		Page<LeadResponse> response = leads.map(lead->mapper.toDto(lead));
		return new ResponseEntity<ApiResponse>(new ApiResponse("Find successflly", response), HttpStatus.OK);
	}
}
