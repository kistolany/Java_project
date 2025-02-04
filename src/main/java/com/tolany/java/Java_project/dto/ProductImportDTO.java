package com.tolany.java.Java_project.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

@Data
public class ProductImportDTO {
@NotNull(message = "produc id can't be null")
 private Long productId;
@Min(value = 1,message = "import unit must be greater than 0")
 private Long importUnit;
@DecimalMin(value = "0.0001",message = "Price must be greater than 0")
 private BigDecimal priceUnit;
@NotNull(message = "import date can't be null")
 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
 private LocalDate importDate;
 
}
