package com.tolany.java.Java_project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tolany.java.Java_project.dto.ModelDTO;


import com.tolany.java.Java_project.intity.Model;

import com.tolany.java.Java_project.mapper.ModelDtoMapper;
import com.tolany.java.Java_project.repository.ModelRepository;

import com.tolany.java.Java_project.service.ModelService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
@AllArgsConstructor
@Service
public class ModelServiceIMPL implements ModelService{

	//@Autowired
	private final ModelRepository modelRepository;

	@Override
	public List<Model> getByBrand(Long brandId) {
		return modelRepository.findByBrandId(brandId);//.orElse;//.orElseThrow(()->new NotfoundException("Brand",id));
	}

	@Override
	public Model save(Model model) {
		//Integer branid = model.getBrand().getId();
		return modelRepository.save(model);
	}

	@Override
	public Model findById(Long getId) {
		return modelRepository.findById(getId)
				.orElseThrow(()->new RuntimeException("mode is not found"));
	}

	
	

}
