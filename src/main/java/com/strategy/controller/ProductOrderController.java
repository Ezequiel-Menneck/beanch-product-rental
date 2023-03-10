package com.strategy.controller;

import javax.validation.Valid;

import com.strategy.model.ProductOrder;
import com.strategy.model.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.strategy.dto.ProductOrderDTO;
import com.strategy.service.ProductOrderService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class ProductOrderController {
	
	@Autowired
	private ProductOrderService productOrderService;

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void createOrder(@RequestBody @Valid ProductOrderDTO productOrderDTO) {
		productOrderService.createOrder(productOrderDTO);
	}

	@GetMapping
	@ResponseBody
	public List<ProductOrder> findAll() {
		return productOrderService.findAll();
	}

	@GetMapping("/{productType}")
	@ResponseBody
	public List<ProductOrder> findByProductType(@PathVariable ProductType productType) {
		return productOrderService.findByProductType(productType);
	}

	@GetMapping("/id/{id}")
	@ResponseBody
	public Optional<ProductOrder> findById(@PathVariable Long id) {
		return productOrderService.findById(id);
	}

}
