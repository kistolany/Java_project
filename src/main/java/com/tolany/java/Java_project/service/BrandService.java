package com.tolany.java.Java_project.service;

import com.tolany.java.Java_project.intity.Brand;

public interface BrandService {
	Brand create(Brand brand);
	Brand getById(Integer id);
	Brand update(Integer id,Brand brandUpdate );
}
