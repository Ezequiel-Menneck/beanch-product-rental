package com.strategy.service;

import com.strategy.model.ProductType;
import com.strategy.repository.ComissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class ComissionFactoryService {

    private Map<ProductType, ComissionRepository> rob;

    @Autowired
    public ComissionFactoryService(Set<ComissionRepository> comissionRepositorySet) {
        createComission(comissionRepositorySet);
    }

    public ComissionRepository findComission(ProductType productType) {
        return rob.get(productType);
    }

    private void createComission(Set<ComissionRepository> comissionRepositorySet) {
        rob = new HashMap<>();
        comissionRepositorySet.forEach(
                x -> rob.put(x.getProductTypeName(), x)
        );
    }

}
