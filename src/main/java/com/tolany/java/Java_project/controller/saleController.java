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
import com.tolany.java.Java_project.dto.SaleDTO;
import com.tolany.java.Java_project.intity.Product;
import com.tolany.java.Java_project.mapper.ProductMapper;
import com.tolany.java.Java_project.service.ProductService;
import com.tolany.java.Java_project.service.SaleService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("sell")
public class saleController {
   private final SaleService saleService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody SaleDTO saleDTO){
		saleService.saleProducts(saleDTO);
		return ResponseEntity.ok().build();
	}
	
}

