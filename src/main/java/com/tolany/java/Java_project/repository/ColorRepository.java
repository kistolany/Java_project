package com.tolany.java.Java_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tolany.java.Java_project.intity.Color;
@Repository
public interface ColorRepository extends JpaRepository<Color, Long>{

}
