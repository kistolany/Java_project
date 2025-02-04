package com.tolany.java.Java_project.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tolany.java.Java_project.dto.ProductSaleDTO;
import com.tolany.java.Java_project.dto.SaleDTO;
import com.tolany.java.Java_project.exception.ApiException;
import com.tolany.java.Java_project.intity.Product;
import com.tolany.java.Java_project.intity.Sale;
import com.tolany.java.Java_project.intity.Sale_detail;
import com.tolany.java.Java_project.repository.ProductRepository;
import com.tolany.java.Java_project.repository.SaleDetailRepository2;
import com.tolany.java.Java_project.repository.SaleRepository;
import com.tolany.java.Java_project.service.ProductService;
import com.tolany.java.Java_project.service.SaleService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SaleServiceIMPI implements SaleService {
	private final ProductService productService;
	private final ProductRepository productRepository;
	private final SaleRepository saleRepository;
	private final SaleDetailRepository2 detailRepository;
	

	@Override
	public void saleProducts(SaleDTO saleDTO) {
		List<Long> productIds = saleDTO.getProducts().stream().map(ProductSaleDTO::getProductId).toList();
		// validation product
		productIds.forEach(productService::getById);

		List<Product> products = productRepository.findAllById(productIds);
		Map<Long, Product> productMap = products.stream()
				.collect(Collectors.toMap(Product::getId, Function.identity()));

		// validate stock

		saleDTO.getProducts().forEach(ps -> {
			Product product = productMap.get(ps.getProductId());
			if (product.getAvailableUnit() < ps.getNumberUnit()) {
				throw new ApiException(HttpStatus.BAD_REQUEST,
						"Product [%s] is not enongh in stock".formatted(product.getName()));
			}
		});

		// sell
		Sale sale = new Sale();
		sale.setSoldDate(saleDTO.getSoldDate());
		saleRepository.save(sale);
		// saleDetail
		saleDTO.getProducts().forEach(ps -> {
			Product product = productMap.get(ps.getProductId());
			Sale_detail detail = new Sale_detail();
			detail.setAmounth(product.getSalePrice());
			detail.setProduct(product);
			detail.setSale(sale);
			detail.setUnit(ps.getNumberUnit());

			detailRepository.save(detail);
			// cut stock
			Long productcutStock=product.getAvailableUnit()- ps.getNumberUnit();
			 product.setAvailableUnit(productcutStock);
		        productRepository.save(product);
		});

		
		
       
	}

	private void validate(SaleDTO saleDTO) {
		List<Long> productIds = saleDTO.getProducts().stream().map(ProductSaleDTO::getProductId).toList();
		// validation product
		productIds.forEach(productService::getById);

		List<Product> products = productRepository.findAllById(productIds);
		Map<Long, Product> productMap = products.stream()
				.collect(Collectors.toMap(Product::getId, Function.identity()));

		// validate stock

		saleDTO.getProducts().forEach(ps -> {
			Product product = productMap.get(ps.getProductId());
			if (product.getAvailableUnit() < ps.getNumberUnit()) {
				throw new ApiException(HttpStatus.BAD_REQUEST,
						"Product [%s] is not enongh in stock".formatted(product.getName()));
			}
		});

		// sell

	}

}
