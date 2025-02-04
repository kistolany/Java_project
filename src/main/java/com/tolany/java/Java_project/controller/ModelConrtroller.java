package com.tolany.java.Java_project.controller;

import org.apache.catalina.mapper.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tolany.java.Java_project.dto.ModelDTO;
import com.tolany.java.Java_project.intity.Model;
import com.tolany.java.Java_project.mapper.ModelDtoMapper;
import com.tolany.java.Java_project.service.ModelService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@RestController
@RequestMapping("models")
public class ModelConrtroller {
	//@Autowired
	private final ModelService modelService;
	private final ModelDtoMapper modelMapper;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody ModelDTO modelDTO){
	//	 Model model = ModelMapper.INSTANCE.toModel(modelDTO);
		Model model = modelMapper.toModel(modelDTO);
		     model=modelService.save(model);
		return ResponseEntity.ok(modelMapper.toModelDTO(model));
	}
}
