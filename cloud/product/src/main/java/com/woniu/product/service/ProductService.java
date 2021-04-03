package com.woniu.product.service;


import com.woniu.product.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findByPid(Integer pid);
    boolean addProduct(Product product);
}
