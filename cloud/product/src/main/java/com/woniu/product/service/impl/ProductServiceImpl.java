package com.woniu.product.service.impl;

import com.woniu.product.Product;
import com.woniu.product.mbg.mapper.ProductMapper;
import com.woniu.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductMapper productMapper;
    @Transactional(readOnly = true,propagation = Propagation.NEVER)
    @Override
    public List<Product> findAll() {
        return productMapper.selectByExample(null);
    }

    @Override
    public boolean addProduct(Product product) {
        int res = productMapper.insert(product);
        if(res==1){
            return true;
        }else {
            return false;
        }
    }

    @Transactional(readOnly = true,propagation = Propagation.NEVER)
    @Override
    public Product findByPid(Integer pid) {
        return productMapper.selectByPrimaryKey(pid);
    }
}
