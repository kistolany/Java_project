package com.tolany.java.Java_project.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.tolany.java.Java_project.intity.Brand;

@DataJpaTest // allow add Autowired
public class TestRepository { 
	@Autowired
 private BrandRepository brandRepository;//because is interface cannot create object ;replace by @Autowired for generate opject
	//@Test
	public void findByNameLike() {
		//Given
//		Brand brand =  Brand.builder()
//				.name("Apple")
//				.build();
		Brand brand = new Brand();
      brand.setId(1L);
		brand.setName("Apple");
		
		brandRepository.save(brand);
		//When
		List<Brand> brand1 = brandRepository.findByNameLike("%A%");
		
		//then
		assertEquals(1, brand1.size());
		assertEquals("Apple", brand1.get(0).getName());
		assertEquals(1, brand1.get(0).getId());
	
		
	}
	
}
