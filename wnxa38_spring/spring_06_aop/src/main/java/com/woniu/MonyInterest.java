package com.woniu;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MonyInterest implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        String methodName = mi.getMethod().getName();
        System.out.println("环绕通知开启");
        Object returnValue = mi.proceed();
        if(methodName.equals("saveMoney")){
            int m=(int)returnValue;
            Object aThis = mi.getThis();
            if(aThis instanceof NormalCard){
                //普通卡收取10元卡费
                m-=10;
            }
            if(aThis instanceof VipCard){
                //会员卡收取20元卡费
                m-=20;
            }
            returnValue=m;
        }
        return returnValue;
    }
}
