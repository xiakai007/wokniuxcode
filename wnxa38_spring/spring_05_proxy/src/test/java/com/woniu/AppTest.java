package com.woniu;

import static org.junit.Assert.assertTrue;

import com.woniu.cglibproxy.GoodsService;
import com.woniu.cglibproxy.GoodsServiceProxy;
import com.woniu.jdkproxy.ProductProxy;
import com.woniu.service.ProductService;
import com.woniu.service.impl.ProductServiceImpl;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

import java.lang.reflect.Proxy;

public class AppTest
{
    @Test
    public void testCglib(){
        GoodsService goodsService = new GoodsService();
        //直接调addGoods方法增加商品，没有前后附加逻辑
        goodsService.addGoods();
        System.out.println("*****************");
        GoodsServiceProxy goodsServiceProxy = new GoodsServiceProxy(goodsService);
        Object object = Enhancer.create(GoodsService.class,goodsServiceProxy);
        GoodsService goodsServiceCglib=(GoodsService)object;
        //使用cglib代理实现调用核心逻辑前后的附加逻辑,不必有接口
        goodsServiceCglib.addGoods();
    }
    @Test
    public void testJdk(){
        ProductServiceImpl productServiceImpl = new ProductServiceImpl();
        ProductProxy productProxy = new ProductProxy(productServiceImpl);
        Class clazz=ProductServiceImpl.class;
        Object object= Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),productProxy);
        ProductService productService=(ProductService)object;
        //使用jdk动态代理实现调用核心逻辑前后的附加逻辑,必须有接口
        productService.addProduct();
    }
}
