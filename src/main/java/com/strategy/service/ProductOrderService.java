package com.strategy.service;

import javax.transaction.Transactional;

import com.strategy.repository.ComissionRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.strategy.dto.ProductOrderDTO;
import com.strategy.model.ProductOrder;
import com.strategy.repository.ProductOrderRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductOrderService {

	@Autowired
	private final ProductOrderRepository productOrderRepository;

	@Autowired
	private ComissionFactoryService comissionFactoryService;

	@Transactional
	public void createOrder(ProductOrderDTO productOrderDTO) {
		productOrderRepository.save(createProductOrder(productOrderDTO));
	}

	private ProductOrder createProductOrder(ProductOrderDTO productOrderDTO) {
		ProductOrder productOrder = new ProductOrder();
		productOrder.setUserName(productOrderDTO.getUserName());
		productOrder.setProductType(productOrderDTO.getProductType());
		productOrder.setTimeHour(productOrderDTO.getTimeHour());

		ComissionRepository comissionRepository = comissionFactoryService.findComission(productOrder.getProductType());

		System.out.println(comissionRepository);

		comissionRepository.calc();

		return productOrder;
	}

	public List<ProductOrder> findAll() {
		return productOrderRepository.findAll();
	}

}