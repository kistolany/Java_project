package com.tolany.java.Java_project.service;

import java.util.List;


import com.tolany.java.Java_project.intity.Model;

public interface ModelService {
	Model save(Model model);
	List<Model> getByBrand(Long brandId);
	Model findById(Long getId);
}
