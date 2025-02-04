package com.tolany.java.Java_project.dto;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class SaleDTO {
	
    private List<ProductSaleDTO> products;
    private LocalDate soldDate;
}
