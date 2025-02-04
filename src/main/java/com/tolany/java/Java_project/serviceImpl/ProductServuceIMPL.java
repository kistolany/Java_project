package com.tolany.java.Java_project.serviceImpl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Http2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tolany.java.Java_project.dto.ProductImportDTO;
import com.tolany.java.Java_project.exception.ApiException;
import com.tolany.java.Java_project.exception.NotfoundException;
import com.tolany.java.Java_project.intity.Color;
import com.tolany.java.Java_project.intity.Product;
import com.tolany.java.Java_project.intity.Product_import;
import com.tolany.java.Java_project.mapper.ProductMapper;
import com.tolany.java.Java_project.repository.ProductImportRepository;
import com.tolany.java.Java_project.repository.ProductRepository;
import com.tolany.java.Java_project.service.ProductService;

import liquibase.pro.packaged.p;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class ProductServuceIMPL implements ProductService {

   private final ProductMapper productMapper;
	private final ProductRepository productRepository;
	private final ProductImportRepository productImportRepository;

	@Override
	public Product save(Product product) {
		String name ="%s %s".formatted(product.getModel().getName(),product.getColor().getName());
		product.setName(name);
		return productRepository.save(product);
	}

	@Override
	public Product getById(Long getId) {
		return productRepository.findById(getId).orElseThrow(()->new NotfoundException("Product", getId));
				
	}

	@Override
	public void importProduct(ProductImportDTO importDTO) {
		if(importDTO.getImportUnit()==null) {
			throw new ApiException(HttpStatus.BAD_REQUEST,"importUnit can't be Null");
		}
		//update product_import unit
      Product product =getById(importDTO.getProductId());
      Long availibleUnit = (long) 0;
      if(product.getAvailableUnit()!=null) {
    	  availibleUnit = product.getAvailableUnit();
      }
      product.setAvailableUnit(availibleUnit  + importDTO.getImportUnit());
        productRepository.save(product);
      
        //save product import 
         Product_import productImporthistory = productMapper.toProductImport(importDTO,product);
         productImportRepository.save(productImporthistory);
        
		
	}

	@Override
	public void setSalePrice(Long productId, BigDecimal price) {
       Product product = getById(productId);		
       product.setSalePrice(price);
       productRepository.save(product);
	}
	
	


}
