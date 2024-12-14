package com.tolany.java.Java_project.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.tolany.java.Java_project.exception.ApiException;
import com.tolany.java.Java_project.exception.NotfoundException;
import com.tolany.java.Java_project.intity.Brand;
import com.tolany.java.Java_project.repository.BrandRepository;
import com.tolany.java.Java_project.service.BrandService;
@Service
public class BrandServiceIMPL implements BrandService{
@Autowired
 private BrandRepository brandRepository;
	@Override
	public Brand create(Brand brand) {
		return brandRepository.save(brand);
	}
	@Override
	public Brand getById(Integer id) {
		return brandRepository.findById(id)
				//.orElseThrow(()->new HttpClientErrorException(HttpStatus.NOT_FOUND,String.format(, id)));
				.orElseThrow(()->new NotfoundException("Brand",id));
}
	@Override
	public Brand update(Integer id, Brand brandUpdate) {
		Brand byId = getById(id);
		byId.setName(brandUpdate.getName());
		return brandRepository.save(byId);
	}
	
		

}
