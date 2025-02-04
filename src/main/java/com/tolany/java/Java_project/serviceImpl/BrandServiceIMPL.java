package com.tolany.java.Java_project.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tolany.java.Java_project.exception.NotfoundException;
import com.tolany.java.Java_project.intity.Brand;
import com.tolany.java.Java_project.repository.BrandRepository;
import com.tolany.java.Java_project.service.BrandService;
import com.tolany.java.Java_project.spec.BrandFilter;
import com.tolany.java.Java_project.spec.BrandSpec;
import com.tolany.java.Java_project.util.pageUtil;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class BrandServiceIMPL implements BrandService{
@Autowired
 private final BrandRepository brandRepository;
	@Override
	public Brand create(Brand brand) {
		return brandRepository.save(brand);
	}
	@Override
	public Brand getById(Long id) {
		return brandRepository.findById(id)
				//.orElseThrow(()->new HttpClientErrorException(HttpStatus.NOT_FOUND,String.format(, id)));
				.orElseThrow(()->new NotfoundException("Brand",id));
}
	@Override
	public Brand update(Long id, Brand brandUpdate) {
		Brand byId = getById(id);
		byId.setName(brandUpdate.getName());
		return brandRepository.save(byId);
	}
//	
//	@Override
//	public List<Brand> getBrands(Map<String, String> params) {
//		BrandFilter brandFilter = new BrandFilter();
//		
//		if(params.containsKey("name")) {
//			String name = params.get("name");
//			brandFilter.setName(name);
//		}
//		if(params.containsKey("id")) {
//			String id = params.get("id");
//			brandFilter.setId(Integer.parseInt(id));
//		}
//	
//		
//		BrandSpec brandSpec = new BrandSpec(brandFilter);
//		
//		return brandRepository.findAll(brandSpec);
//
//	}
	@Override
	public Page<Brand> getBrands(Map<String, String> params) {
		BrandFilter brandFilter = new BrandFilter();
		
		if(params.containsKey("name")) {
			String name = params.get("name");
			brandFilter.setName(name);
		}
		if(params.containsKey("id")) {
			String id = params.get("id");
			brandFilter.setId(Integer.parseInt(id));
		}
		int pageLimit =pageUtil.DEFOULT_PAGE_LIMIT ;
		if(params.containsKey(pageUtil.PAGE_LIMIT)) {
			pageLimit = Integer.parseInt(params.get(pageUtil.PAGE_LIMIT) );
		}
		//Todo at to function
		int pageNumber = pageUtil.DEFOULT_PAGE_NUMBER;
		if(params.containsKey(pageUtil.PAGE_NUMBER)) {
			pageNumber = Integer.parseInt(params.get(pageUtil.PAGE_NUMBER) );
		}
		
		BrandSpec brandSpec = new BrandSpec(brandFilter);
		Pageable pageable =pageUtil.getPageable(pageNumber,pageLimit );//get page 
		//Page<Brand> page = brandRepository.findAll(brandSpec,org.springframework.data.domain.Pageable.ofSize(0));
		Page<Brand> page = brandRepository.findAll(brandSpec,pageable);
		
		return page;
	}
	
	
//	@Override
//	public List<Brand> getBrands() {
//		
//		return brandRepository.findAll();
//	}
	
	
	@Override
	public List<Brand> findByName(String name) {
	
		//return brandRepository.findByNameLike("%"+name+"%");
		return brandRepository.findByNameContaining(name);
	}
	
		

}
