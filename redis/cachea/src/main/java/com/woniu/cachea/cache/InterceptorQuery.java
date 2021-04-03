package com.woniu.cachea.cache;

import org.apache.ibatis.executor.CachingExecutor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

@Intercepts({@Signature(type =Executor.class,method = "query",args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class InterceptorQuery implements Interceptor{
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("进入InterceptorQuery了");
        Object target = invocation.getTarget();
        if(target instanceof CachingExecutor){
            Object proceed=null;
            Object[] args = invocation.getArgs();
            MappedStatement mappedStatement = (MappedStatement)args[0];
            Object parameterObject = args[1];
            BoundSql boundSql = mappedStatement.getBoundSql(parameterObject);
            String sql = boundSql.getSql();
            String lock=sql+parameterObject;
            synchronized (lock.intern()){
                proceed = invocation.proceed();
            }
            return proceed;
        }else {
            Object proceed = invocation.proceed();
            return proceed;
        }

    }
}
