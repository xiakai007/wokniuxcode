package com.woniu.mybatisinterceptor.cache;

import lombok.extern.slf4j.Slf4j;
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

/**
 * 解决缓存击穿时大量请求直接查询数据库问题：设置互斥锁，
 * 第一个人先查，有了缓存之后其他人再查
 */
@Slf4j
@Intercepts({@Signature(type =Executor.class,method = "query",args = {MappedStatement.class, Object.class,
        RowBounds.class, ResultHandler.class})})
public class InterceptorQuery implements Interceptor{
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        log.info("进入InterceptorQuery了");
        System.out.println("进入InterceptorQuery了");
        Object target = invocation.getTarget();
        if(target instanceof CachingExecutor){
            Object proceed=null;
            Object[] args = invocation.getArgs();
            //mybatis预编译处理，select * from table where id=? 即sql语句+参数，
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
