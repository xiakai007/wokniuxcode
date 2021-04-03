package com.woniu.orders.service;

import com.woniu.product.ResultVo;
import com.woniu.product.Status;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceFallbackFactory implements FallbackFactory<ProductService>{
    @Override
    public ProductService create(Throwable throwable) {
        log.error("{}",throwable);
        String message = throwable.getMessage();
        log.info(message);
        return new ProductService() {
            @Override
            public ResultVo findAllProductRem() {
                ResultVo vo = new ResultVo();
                vo.setStatus(Status.ERROR);
                vo.setMessage("发生降级，启动备用");
                return vo;
            }
        };
    }
}
