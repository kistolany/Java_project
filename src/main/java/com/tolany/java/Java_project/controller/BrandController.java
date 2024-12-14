package com.tolany.java.Java_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tolany.java.Java_project.dto.BrandDTO;
import com.tolany.java.Java_project.intity.Brand;
import com.tolany.java.Java_project.mapper.BrandMapper;
import com.tolany.java.Java_project.service.BrandService;




@RestController
@RequestMapping("brands")
public class BrandController {
    @Autowired
	private BrandService brandService;
    
     @PostMapping
   // @RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO){
		Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
		brand=brandService.create(brand);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toDTO(brand));
	}
     
     @GetMapping("{id}")
     public ResponseEntity<?> getOne(@PathVariable("id") Integer brandId ){
    	 Brand brand = brandService.getById(brandId);
    	  return ResponseEntity.ok(BrandMapper.INSTANCE.toDTO(brand));
     }
     
 	@PutMapping("{id}")
     public ResponseEntity<?> Update(@PathVariable("id") Integer updateId,@RequestBody BrandDTO brandDTO){
    	 Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
    	 brand=brandService.update(updateId, brand);
    	 return ResponseEntity.ok(BrandMapper.INSTANCE.toDTO(brand));
     }
 	
 	  @GetMapping
      public ResponseEntity<?> getBrands(){
     	 return ResponseEntity.ok(brandService.getBrands());
     	  //return ResponseEntity.ok(BrandMapper.INSTANCE.toDTO(brand));
      }
}
