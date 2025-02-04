package com.tolany.java.Java_project.service;

import java.math.BigDecimal;

import com.tolany.java.Java_project.dto.ProductDTO;
import com.tolany.java.Java_project.dto.ProductImportDTO;
import com.tolany.java.Java_project.intity.Product;

public interface ProductService {
  Product save(Product product);
  Product getById(Long getId);
  
  void importProduct(ProductImportDTO importDTO);
  
  void setSalePrice(Long productId,BigDecimal price);
}
