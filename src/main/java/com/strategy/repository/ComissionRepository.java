package com.strategy.repository;

import com.strategy.model.ProductType;
import org.springframework.stereotype.Repository;

@Repository
public interface ComissionRepository {

    ProductType getProductTypeName();

    void calc();

}
