package com.tolany.java.Java_project.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tolany.java.Java_project.dto.BrandDTO;
import com.tolany.java.Java_project.dto.ModelDTO;
import com.tolany.java.Java_project.dto.PageDTO;
import com.tolany.java.Java_project.intity.Brand;
import com.tolany.java.Java_project.intity.Model;
import com.tolany.java.Java_project.mapper.BrandMapper;
import com.tolany.java.Java_project.mapper.ModelDtoMapper;
import com.tolany.java.Java_project.service.BrandService;
import com.tolany.java.Java_project.service.ModelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("brands")
public class BrandController {

	private final BrandService brandService;
	private final ModelService modelService;

	private final ModelDtoMapper modelMapper;

	@PostMapping
	// @RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO) {
		Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
		brand = brandService.create(brand);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toDTO(brand));
	}

	@GetMapping("{id}/models")
	public ResponseEntity<?> getModelByBrandId(@PathVariable("id") Long brandId) {
		List<Model>brands= modelService.getByBrand(brandId);
		List<ModelDTO> list = brands.stream()
				 //.map(brand->modelMapper.toModelDTO(brand))
				.map(modelMapper::toModelDTO)
				.toList();
		return ResponseEntity.ok(list);
	}

	@PutMapping("{id}")
	public ResponseEntity<?> Update(@PathVariable("id") Long updateId, @RequestBody BrandDTO brandDTO) {
		Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
		brand = brandService.update(updateId, brand);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toDTO(brand));
	}

	@GetMapping("/filter")
	public ResponseEntity<List<BrandDTO>> getBrands(@RequestParam("name") String name) {
		// Call the service to find brands containing the 'name'
		List<BrandDTO> list = brandService.findByName(name).stream().map(brand -> BrandMapper.INSTANCE.toDTO(brand))
				.collect(Collectors.toList());
		return ResponseEntity.ok(list);
	}

	@GetMapping
	public ResponseEntity<?> getBrands(@RequestParam Map<String, String> params) {
		Page<Brand> list = brandService.getBrands(params);
		PageDTO page = new PageDTO(list);
// 		 List<BrandDTO>  list=brandService.getBrands(params)
//		    .stream()
//		    .map(brand -> BrandMapper.INSTANCE.toDTO(brand))
//		    .collect(Collectors.toList());
		return ResponseEntity.ok(page);

	}
}
