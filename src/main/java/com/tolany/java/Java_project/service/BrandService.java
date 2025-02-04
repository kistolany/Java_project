package com.tolany.java.Java_project.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.tolany.java.Java_project.intity.Brand;

public interface BrandService {
	Brand create(Brand brand);
	Brand getById(Long id);
	Brand update(Long id,Brand brandUpdate );
	//List<Brand> getBrands(Map<String , String >  params);
	List<Brand> findByName(String name);
	Page<Brand> getBrands(Map<String , String >  params);
}
