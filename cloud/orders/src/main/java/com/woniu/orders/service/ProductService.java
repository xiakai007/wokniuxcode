package com.woniu.orders.service;

import com.woniu.product.ResultVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "microproduct",
fallbackFactory = ProductServiceFallbackFactory.class)
public interface ProductService {
    @GetMapping(value = "/product")
    public ResultVo findAllProductRem();
}
