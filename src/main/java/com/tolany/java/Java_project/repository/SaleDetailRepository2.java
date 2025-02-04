package com.tolany.java.Java_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.tolany.java.Java_project.intity.Model;
import com.tolany.java.Java_project.intity.Sale;
import com.tolany.java.Java_project.intity.Sale_detail;

public interface SaleDetailRepository2 extends JpaRepository<Sale_detail, Long>{

}
