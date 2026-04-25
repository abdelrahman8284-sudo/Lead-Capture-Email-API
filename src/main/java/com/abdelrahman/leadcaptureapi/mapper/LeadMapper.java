package com.abdelrahman.leadcaptureapi.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.abdelrahman.leadcaptureapi.dto.LeadRequest;
import com.abdelrahman.leadcaptureapi.dto.LeadResponse;
import com.abdelrahman.leadcaptureapi.model.Lead;

@Mapper(componentModel = "spring")
public interface LeadMapper {

	Lead toEntity(LeadRequest request);
	LeadResponse toDto(Lead lead);
	List<LeadResponse> toListDto(List<Lead> leads);
}
