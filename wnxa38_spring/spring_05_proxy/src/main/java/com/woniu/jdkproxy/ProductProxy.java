package com.woniu.jdkproxy;

import com.woniu.service.ProductService;
import com.woniu.service.impl.ProductServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProductProxy implements InvocationHandler {
    private ProductService productService;

    public ProductProxy(ProductService productService) {
        this.productService = new ProductServiceImpl();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.methodBeforeLog(method,args);
        Object object=method.invoke(productService,args);
        this.afterReturingLog(proxy);
        return object;
    }
    public void methodBeforeLog(Method method, Object[] args){
        System.out.println("方法调用前");
    }
    public void afterReturingLog(Object result){
        System.out.println("方法调用后");
    }
}
