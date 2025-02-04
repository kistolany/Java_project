package com.tolany.java.Java_project.intity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.DecimalMin;

import lombok.Data;
//
@Data
@Entity
@Table(name = "products",uniqueConstraints= {@UniqueConstraint(columnNames={"color_id","model_id"})})
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
    private Long id;
	
	@Column(name = "product_name")
    private String name;
	
	@Column(name = "available_unit")
    private Long availableUnit;
	
	@Column(name = "image_path")
    private String imagePath;
	@DecimalMin(value = "0.0001",message = "Price must be greater than 0")
	@Column(name = "sale_price")
    private BigDecimal salePrice;
	
	@ManyToOne
    @JoinColumn(name ="color_id")
    private Color color;

    @ManyToOne
    @JoinColumn(name ="model_id")
    private Model model;
}
