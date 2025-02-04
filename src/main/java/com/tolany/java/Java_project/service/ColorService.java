package com.tolany.java.Java_project.service;

import com.tolany.java.Java_project.intity.Color;

public interface ColorService {
 
	Color create(Color color);
	Color getById(Long getId);
}
