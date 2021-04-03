package com.woniu.cglibproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class GoodsServiceProxy implements MethodInterceptor {
    private GoodsService goods;

    public GoodsServiceProxy(com.woniu.cglibproxy.GoodsService goods) {
        this.goods = goods;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        this.methodBeforeLog(method,objects);
        Object object = method.invoke(goods, objects);
        this.afterReturingLog(object);
        return object;
    }
    public void methodBeforeLog(Method method, Object[] args){
        System.out.println("方法调用前的逻辑代码");
    }
    public void afterReturingLog(Object result){
        System.out.println("方法调用后的逻辑代码");
    }
}
