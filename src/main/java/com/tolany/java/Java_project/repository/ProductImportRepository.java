package com.tolany.java.Java_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.tolany.java.Java_project.dto.ProductImportDTO;
import com.tolany.java.Java_project.intity.Product;
import com.tolany.java.Java_project.intity.Product_import;

public interface ProductImportRepository extends JpaRepository<Product_import, Long>,JpaSpecificationExecutor<Product_import>{



	

}
