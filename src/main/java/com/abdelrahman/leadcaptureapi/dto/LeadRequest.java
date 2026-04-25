package com.abdelrahman.leadcaptureapi.dto;

import com.abdelrahman.leadcaptureapi.validation.Phone;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class LeadRequest {
	@NotBlank(message = "Name should not be empty")
	private String name;
	@NotBlank(message = "Phone should not be empty")
	@Phone(message = "Phone invalid")
	@Column(unique = true)
	private String phone;
	@NotBlank(message = "Email should not be empty")
	@Email(message = "Email invalid")
	private String email;
	@NotBlank(message = "Address should not be empty")
	private String address;
}
