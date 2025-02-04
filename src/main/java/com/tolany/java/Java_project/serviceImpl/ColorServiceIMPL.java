package com.tolany.java.Java_project.serviceImpl;

import org.springframework.stereotype.Service;

import com.tolany.java.Java_project.exception.NotfoundException;
import com.tolany.java.Java_project.intity.Color;
import com.tolany.java.Java_project.repository.ColorRepository;
import com.tolany.java.Java_project.service.ColorService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ColorServiceIMPL implements ColorService {

	private final ColorRepository colorRepository;
	@Override
	public Color create(Color color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getById(Long getId) {
		// TODO Auto-generated method stub
		return colorRepository.findById(getId)
				.orElseThrow(()->new NotfoundException("color", getId));
	}

	
}
