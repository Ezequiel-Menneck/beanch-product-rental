package com.salsatechnology.repository;

import com.salsatechnology.model.ProductType;

public interface ComissionRepository {

    void calculateComission(ProductType productType);
    void calculateComissionSurfboard();
    void calculateComissionBeachChair();
    void calculateComissionSunshade();
    void calculateComissionSandBoard();
    void calculateComissionBeachTable();

}
