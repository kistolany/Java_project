package com.tolany.java.Java_project.servicec;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.test.web.servlet.MockMvcExtensionsKt;

import com.tolany.java.Java_project.exception.NotfoundException;
import com.tolany.java.Java_project.intity.Brand;
import com.tolany.java.Java_project.repository.BrandRepository;
import com.tolany.java.Java_project.service.BrandService;
import com.tolany.java.Java_project.serviceImpl.BrandServiceIMPL;

import lombok.Builder;
import net.bytebuddy.NamingStrategy.Suffixing.BaseNameResolver.ForGivenType;

@ExtendWith(MockitoExtension.class)
public class serviceTest {
    @Mock
	private BrandRepository brandRepository;
	
	private BrandService service;
	@BeforeEach
	public void setUp() {
		service=new BrandServiceIMPL(brandRepository);
	}
	/*
	@Test
	public void testService() {
		
		//given
//		Brand brand = Brand.builder()
//				.id(22)
//				.name("Apple")
//				.build();
		Brand brand = new Brand();
		brand.setId(22);
		brand.setName("Apple");
//		
		//when
		when(brandRepository.save(any(Brand.class))).thenReturn(brand);
		Brand returnBrand = service.create(new Brand());
		//Brand returnBrand = service.create(Brand.builder().build());
		
		
//      when(brandRepository.save(brand)).thenReturn(brand);
//		Brand returnBrand = service.create(brand);
		
		
		//then
		assertEquals(22, returnBrand.getId());
		assertEquals("Apple",returnBrand.getName());
	}
	*/
	
	//@Test
	public void testService() {
		//given
		Brand brand = new Brand();
		brand.setName("Apple");
		//when 
		service.create(brand);
		//then
		verify(brandRepository,times(1)).save(brand);//check brandRepository.save() in brandServiceIpml
		//time(1) mean that call this 1 public Brand create(Brand brand) {
		//return brandRepository.save(brand);
	
	}
	
	//@Test
	public void getById() {
		//given
		Brand brand = new Brand();
		brand.setId(1L);
		
	    //when
		when(brandRepository.findById(1L)).thenReturn(Optional.of(brand));
		Brand returnBrand = service.getById(brand.getId());
		//thenb
		assertThat(returnBrand);
	}
	
	//@Test//test exception
	public void getByIdException() {
		//given
	
		when(brandRepository.findById(2L)).thenReturn(Optional.empty());
       assertThatThrownBy(()->service.getById(2L))
            .isInstanceOf(NotfoundException.class)
             .hasMessage("Brand with id=2 is not found");

               
		
	   
	}
	
	
}
