package com.abdelrahman.leadcaptureapi.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.abdelrahman.leadcaptureapi.validation.Phone;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="leads")
@AllArgsConstructor@NoArgsConstructor@Setter@Getter
@EntityListeners(AuditingEntityListener.class)
public class Lead {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Name should not be empty")
	private String name;
	@NotBlank(message = "Phone should not be empty")
	@Phone(message = "Phone invalid")
	@Column(unique = true)
	private String phone;
	@NotBlank(message = "Email should not be empty")
	@Email(message = "Email invalid")
	@Column(unique = true)
	private String email;
	@NotBlank(message = "Address should not be empty")
	private String address;
	@CreatedDate
	private LocalDateTime createdAt;
	@LastModifiedDate
	private LocalDateTime lastUpdatedAt;
}
