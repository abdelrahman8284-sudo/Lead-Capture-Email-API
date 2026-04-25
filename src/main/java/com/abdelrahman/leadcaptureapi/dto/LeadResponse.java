package com.abdelrahman.leadcaptureapi.dto;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class LeadResponse {
	
	private Long id;
	private String name;
	private String phone;
	private String email;
	private String address;
	private LocalDateTime createdAt;
	private LocalDateTime lastUpdatedAt;
}
