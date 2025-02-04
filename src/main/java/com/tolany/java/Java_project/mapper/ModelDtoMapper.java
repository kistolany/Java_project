package com.tolany.java.Java_project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.tolany.java.Java_project.dto.ModelDTO;
import com.tolany.java.Java_project.intity.Brand;
import com.tolany.java.Java_project.intity.Model;
import com.tolany.java.Java_project.service.BrandService;

@Mapper(componentModel = "Spring",uses = {BrandService.class})
public interface ModelDtoMapper {

	ModelDtoMapper INSTANCE = Mappers.getMapper(ModelDtoMapper.class);
	@Mapping(target = "brand",source = "brandId")
	Model toModel(ModelDTO modelDTO);
	
	@Mapping(target = "brandId",source = "brand.id")
	ModelDTO toModelDTO(Model model);
	/*
	default Brand toBrand(Integer brandId) {
		Brand brand = new Brand();
		brand.setId(brandId);
		return brand;
	}
	*/
}
