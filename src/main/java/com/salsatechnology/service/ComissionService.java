package com.salsatechnology.service;

import com.salsatechnology.model.ProductOrder;
import com.salsatechnology.model.ProductType;
import com.salsatechnology.repository.ComissionRepository;

public class ComissionService implements ComissionRepository {

    private ProductOrder productOrder;

    public ComissionService(ProductOrder productOrder) {
        this.productOrder = productOrder;
    }

    @Override
    public void calculateComission(ProductType productType) {
        switch (productType) {
            case SURFBOARD -> calculateComissionSurfboard();
            case BEACH_CHAIR -> calculateComissionBeachChair();
            case SUNSHADE -> calculateComissionSunshade();
            case SAND_BOARD -> calculateComissionSandBoard();
            case BEACH_TABLE -> calculateComissionBeachTable();
        }
    }

    @Override
    public void calculateComissionSurfboard() {
        productOrder.setProductValue(50L * 100);
        productOrder.setProductTotal((productOrder.getProductValue() * productOrder.getTimeHour()));
        productOrder.setUserAmount((long) (productOrder.getProductTotal() * 0.156));
    }

    @Override
    public void calculateComissionBeachChair() {
        productOrder.setProductValue(35L * 100);
        productOrder.setProductTotal((productOrder.getProductValue() * productOrder.getTimeHour()));
        productOrder.setUserAmount((long) (productOrder.getProductTotal() * 0.05));
    }

    @Override
    public void calculateComissionSunshade() {
        productOrder.setProductValue(40L * 100);
        productOrder.setProductTotal((productOrder.getProductValue() * productOrder.getTimeHour()));
        productOrder.setUserAmount((long) (productOrder.getProductTotal() * 0.103));
    }

    @Override
    public void calculateComissionSandBoard() {
        productOrder.setProductValue(25L * 100);
        productOrder.setProductTotal((productOrder.getProductValue() * productOrder.getTimeHour()));
        productOrder.setUserAmount((long) (productOrder.getProductTotal() * 0.09));
    }

    @Override
    public void calculateComissionBeachTable() {
        productOrder.setProductValue(25L * 100);
        productOrder.setProductTotal((productOrder.getProductValue() * productOrder.getTimeHour()));
        productOrder.setUserAmount((long) (productOrder.getProductTotal() * 0.081));
    }
}
