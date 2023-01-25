package com.strategy.service;

import javax.transaction.Transactional;

import com.strategy.model.ProductType;
import com.strategy.service.strategy.CalculateProductType;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.strategy.dto.ProductOrderDTO;
import com.strategy.model.ProductOrder;
import com.strategy.repository.ProductOrderRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

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

		CalculateProductType calculateProductType = comissionFactoryService.findComission(productOrder.getProductType());

		productOrder.setProductValue(calculateProductType.productValue());
		productOrder.setProductTotal(calculateProductType.getProductTotal(productOrderDTO));
		productOrder.setUserAmount(calculateProductType.getUserAmount(productOrderDTO));

		return productOrder;
	}

	public List<ProductOrder> findAll() {
		return productOrderRepository.findAll();
	}

	public List<ProductOrder> findByProductType(ProductType productType) {
		return productOrderRepository.findAll().stream().filter(x -> x.getProductType() == productType).toList();
	}

	public Optional<ProductOrder> findById(Long id) {
		return productOrderRepository.findById(id);
	}

}
