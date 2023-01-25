package com.strategy.service.strategy;

import com.strategy.dto.ProductOrderDTO;
import com.strategy.model.ProductType;

public interface CalculateProductType {

    ProductType getProductTypeName();

    Long getProductTotal(ProductOrderDTO productOrderDTO);

    Long getUserAmount(ProductOrderDTO productOrderDTO);

    Long productValue();

}
