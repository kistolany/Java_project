package com.tolany.java.Java_project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.tolany.java.Java_project.dto.BrandDTO;
import com.tolany.java.Java_project.intity.Brand;

@Mapper
public interface BrandMapper {

	BrandMapper INSTANCE =Mappers.getMapper(BrandMapper.class);
	Brand toBrand(BrandDTO brandDTO);
	BrandDTO toDTO(Brand brand);
	
}
