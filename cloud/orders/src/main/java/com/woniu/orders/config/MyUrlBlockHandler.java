package com.woniu.orders.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.woniu.product.ResultVo;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class MyUrlBlockHandler implements UrlBlockHandler{
    @Override
    public void blocked(HttpServletRequest request, HttpServletResponse response, BlockException e) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        ResultVo r=null;
        if(e instanceof FlowException){
            r=new ResultVo(-1,"接口被限流了");
        }else if(e instanceof DegradeException){
            r=new ResultVo(-2,"接口被降级了");
        }else if(e instanceof ParamFlowException){
            r=new ResultVo(-3,"参数限流");
        }else if(e instanceof AuthorityException){
            r=new ResultVo(-4,"授权");
        }else if(e instanceof SystemBlockException){
            r=new ResultVo(-5,"系统负载");
        }
    }
}
