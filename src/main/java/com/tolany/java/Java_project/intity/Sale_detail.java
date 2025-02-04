package com.tolany.java.Java_project.intity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
//@Builder
//@RequiredArgsConstructor
@Data
@Entity
@Table(name = "sale_detail")
public class Sale_detail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	    private Long id;
	
	@ManyToOne
	@JoinColumn(name = "sale_id")
	    private Sale sale;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@Column(name = "amounth")
    private BigDecimal amounth;
	
	@Column(name = "unit")
    private Long unit;
	    
}
