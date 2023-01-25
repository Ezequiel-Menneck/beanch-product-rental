package com.strategy.service.strategy.productType;

import com.strategy.dto.ProductOrderDTO;
import com.strategy.model.ProductType;
import com.strategy.service.strategy.CalculateProductType;
import org.springframework.stereotype.Service;

@Service
public class Sunshade implements CalculateProductType {

    private final static Double comissionValue = 0.103;

    @Override
    public ProductType getProductTypeName() {
        return ProductType.SUNSHADE;
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
        return 40L * 100;
    }

}
