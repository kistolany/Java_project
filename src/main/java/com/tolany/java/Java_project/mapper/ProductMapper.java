package com.tolany.java.Java_project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.web.bind.annotation.RequestMapping;


import com.tolany.java.Java_project.dto.ProductDTO;
import com.tolany.java.Java_project.dto.ProductImportDTO;
import com.tolany.java.Java_project.intity.Product;
import com.tolany.java.Java_project.intity.Product_import;
import com.tolany.java.Java_project.service.ColorService;
import com.tolany.java.Java_project.service.ModelService;
import com.tolany.java.Java_project.service.ProductService;

@Mapper(componentModel = "spring",uses= {ModelService.class,ColorService.class})
public interface ProductMapper {

	@Mapping(source = "modelId", target = "model")
	@Mapping(target = "color",source = "colorId")
	Product toProduct(ProductDTO productDTO);//method over loading same name
	
	@Mapping(target = "product",source = "product")
	@Mapping(target = "id",ignore = true)
	Product_import toProductImport(ProductImportDTO importDTO,Product product);
}
