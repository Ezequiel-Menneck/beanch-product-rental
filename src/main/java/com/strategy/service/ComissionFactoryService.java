package com.strategy.service;

import com.strategy.model.ProductType;
import com.strategy.service.strategy.CalculateProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class ComissionFactoryService {

    private Map<ProductType, CalculateProductType> map;

    @Autowired
    public ComissionFactoryService(Set<CalculateProductType> calculateProductTypeSet) {
        createComission(calculateProductTypeSet);
    }

    public CalculateProductType findComission(ProductType productType) {
        return map.get(productType);
    }

    private void createComission(Set<CalculateProductType> calculateProductTypeSet) {
        map = new HashMap<>();
        calculateProductTypeSet.forEach(
                x -> map.put(x.getProductTypeName(), x)
        );
    }

}
