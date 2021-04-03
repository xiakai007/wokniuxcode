package com.woniu.product.controller;

import com.woniu.product.Product;
import com.woniu.product.ResultVo;
import com.woniu.product.Status;
import com.woniu.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Slf4j
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping(value = "/testLoadBalance")
    public ResultVo testLoadBalance(HttpServletRequest request){
        return new ResultVo(Status.SUCCESS,"product实例端口号"+request.getServerPort());
    }
    @GetMapping(value = "/product")
    public ResultVo findAllProduct(){
        try {
            List<Product> products = productService.findAll();
            return new ResultVo(Status.SUCCESS,"产品查询成功",products);
        } catch (Exception e) {
            return new ResultVo(Status.ERROR,"产品查询失败",e);
        }
    }
    @GetMapping(value = "/product/{pid}")
    public ResultVo findAlProductById(@PathVariable Integer pid,HttpServletRequest request){
        try {
            Product product = productService.findByPid(pid);
            if(product==null){
                log.debug("查询产品{}失败",pid);
                return new ResultVo(Status.ERROR,"产品pid查询成功,端口号："+request.getServerPort());
            }else {
                log.debug("查询产品{}成功",pid);
                return new ResultVo(Status.SUCCESS,"产品pid查询成功,端口号："+request.getServerPort(),product);
            }
        } catch (Exception e) {
            return new ResultVo(Status.ERROR,"产品查询失败,端口号："+request.getServerPort()+pid,e);
        }
    }
    @PostMapping(value = "addproduct")
    public ResultVo addproduct(@RequestBody Product product){
        boolean flag = productService.addProduct(product);
        if(flag){
            log.debug("增加产品成功{}",product);
            return new ResultVo(Status.SUCCESS,"增加产品成功");
        }else {
            log.debug("增加产品失败");
            return new ResultVo(Status.ERROR,"增加产品失败");
        }
    }
}
