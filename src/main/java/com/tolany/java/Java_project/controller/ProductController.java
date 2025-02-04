package com.tolany.java.Java_project.controller;



import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tolany.java.Java_project.dto.PriceDTO;
import com.tolany.java.Java_project.dto.ProductDTO;
import com.tolany.java.Java_project.dto.ProductImportDTO;
import com.tolany.java.Java_project.intity.Product;
import com.tolany.java.Java_project.mapper.ProductMapper;
import com.tolany.java.Java_project.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("products")
public class ProductController {
   private final ProductService productService;
   private final ProductMapper mapper;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody ProductDTO productDto){
		Product product = mapper.toProduct(productDto);
		product=productService.save(product);
		return ResponseEntity.ok(product);
	}
	
	
	@PostMapping("productImport")
	public ResponseEntity<?> createProductImport(@RequestBody @Valid ProductImportDTO productDto){
		productService.importProduct(productDto);
		return ResponseEntity.ok().build();
	}
	
	
	@PostMapping("{productId}/setSalePrice")
	public ResponseEntity<?> createSaleprice(@PathVariable Long productId,@RequestBody PriceDTO priceDTO){
	  productService.setSalePrice(productId,priceDTO.getPrice());
		return ResponseEntity.ok().build();
	}
}

