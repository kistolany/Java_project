package com.tolany.java.Java_project.intity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "product_import")
public class Product_import {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "import_date")
    private LocalDate importDate;
	
	@Column(name = "import_unit")
    private Long  importUnit;
	
	@Column(name = "price_per_unit")
    private BigDecimal priceUnit;
    
    @ManyToOne
    @JoinColumn(name ="product_id")
    private Product product;
}
