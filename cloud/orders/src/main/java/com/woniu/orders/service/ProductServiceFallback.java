package com.woniu.orders.service;

import com.woniu.product.ResultVo;
import com.woniu.product.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceFallback implements ProductService{
    @Override
    public ResultVo findAllProductRem() {
        ResultVo vo = new ResultVo();
        vo.setStatus(Status.ERROR);
        vo.setMessage("发生降级，启动备用");
        return vo;
    }
}
