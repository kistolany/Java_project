package com.tolany.java.Java_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.tolany.java.Java_project.intity.Brand;
@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>,JpaSpecificationExecutor<Brand>{
    List<Brand> findByNameLike(String name);//one 
    List<Brand> findByNameContaining(String name);
}
