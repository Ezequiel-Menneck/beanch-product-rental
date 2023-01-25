package com.strategy.entities;

import com.strategy.model.ProductOrder;
import com.strategy.model.ProductType;
import com.strategy.repository.ComissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Surfboard implements ComissionRepository {

    private final ProductOrder productOrder;

    @Autowired
    public Surfboard(ProductOrder productOrder) {
        this.productOrder = productOrder;
    }

    @Override
    public void calc() {
        productOrder.setProductValue(50L * 100);
        productOrder.setProductTotal(productOrder.getProductValue() * productOrder.getTimeHour());
        productOrder.setUserAmount((long) (productOrder.getProductTotal() * 0.156));
        System.out.println("caralho");
    }

    @Override
    public ProductType getProductTypeName() {
        return ProductType.SURFBOARD;
    }

}