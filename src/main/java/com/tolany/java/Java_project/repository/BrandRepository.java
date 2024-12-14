package com.tolany.java.Java_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tolany.java.Java_project.intity.Brand;
@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    List<Brand> findByNameLike(String name);
    List<Brand> findByNameContaining(String name);
}
