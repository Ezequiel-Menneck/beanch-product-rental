package com.strategy.service.strategy.productType;

import com.strategy.dto.ProductOrderDTO;
import com.strategy.model.ProductType;
import com.strategy.service.strategy.CalculateProductType;
import org.springframework.stereotype.Service;

@Service
public class BeachChair implements CalculateProductType {

    private final static Double comissionValue = 0.5;

    @Override
    public ProductType getProductTypeName() {
        return ProductType.BEACH_CHAIR;
    }

    @Override
    public Long getProductTotal(ProductOrderDTO productOrderDTO) {
        return (productOrderDTO.getTimeHour() * productValue());
    }

    @Override
    public Long getUserAmount(ProductOrderDTO productOrderDTO) {
        return (long) (getProductTotal(productOrderDTO) * comissionValue);
    }

    @Override
    public Long productValue() {
        return 35L * 100;
    }

}
