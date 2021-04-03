package com.woniu.gateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
@Component
public class MyAuthFilter implements GlobalFilter,Ordered{

    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("into my filter");
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if("admin".equals(token)){
            Mono<Void> filter = chain.filter(exchange);
            return filter;
        }else {
            System.out.println("认证失败");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();//中断流
        }
    }

    public int getOrder() {
        return 0;
    }
}
