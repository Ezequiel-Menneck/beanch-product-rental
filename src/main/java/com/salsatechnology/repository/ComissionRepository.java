package com.salsatechnology.repository;

import com.salsatechnology.model.ProductType;
import org.springframework.stereotype.Repository;

@Repository
public interface ComissionRepository {

    ProductType getProductTypeName();

    void calc();

}
