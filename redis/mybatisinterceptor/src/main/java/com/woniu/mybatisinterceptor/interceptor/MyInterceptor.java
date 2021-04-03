package com.woniu.mybatisinterceptor.interceptor;


import com.woniu.mybatisinterceptor.util.MyPageHelper;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;

import java.sql.Connection;

/**
 * 分页拦截添加sql
 */
@Intercepts({@Signature(type = StatementHandler.class,method = "prepare",args = {Connection.class,Integer.class})})
public class MyInterceptor implements Interceptor{
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("已经被拦截了");
        StatementHandler statementHandler = (StatementHandler)invocation.getTarget();
        MetaObject metaObject = MetaObject.forObject(statementHandler,new DefaultObjectFactory(),new DefaultObjectWrapperFactory(),new DefaultReflectorFactory());
        String sql = metaObject.getValue("delegate.boundSql.sql").toString();
        System.out.println("原sql："+sql);
        if(MyPageHelper.getLimit()!=null&&MyPageHelper.getLimit()!=0){
            sql=sql+" limit "+MyPageHelper.getOffset()+","+MyPageHelper.getLimit();
            System.out.println("新sql："+sql);
            metaObject.setValue("delegate.boundSql.sql",sql);
            MyPageHelper.removeOffsetLimit();
        }
        Object proceed = invocation.proceed();
        return proceed;
    }
}
