package com.woniu.service.impl;

import com.woniu.service.ProductService;

public class ProductServiceImpl implements ProductService {
    @Override
    public void addProduct(int id) {
        System.out.println("addProduct(int id)");
    }

    @Override
    public void removeProduct(int id) {
        System.out.println("removeProduct(int id)");
    }
}
