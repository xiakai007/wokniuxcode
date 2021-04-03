package com.woniu.orders.controller;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.woniu.orders.controllerexcep.OrdersControllerBlockHandler;
import com.woniu.orders.controllerexcep.OrdersControllerFallback;
import com.woniu.orders.mbg.model.Orders;
import com.woniu.orders.service.MyService;
import com.woniu.orders.service.OrdersService;
import com.woniu.orders.service.ProductService;
import com.woniu.product.Product;
import com.woniu.product.ResultVo;
import com.woniu.product.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@Slf4j
public class OrdersController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OrdersService ordersService;
    @Value("${service.product_url}")
    private String product_url;
    @Autowired
    private MyService myService;
    @Autowired
    private ProductService productService;

    @GetMapping("/product/{pid}")
    public ResultVo findProductById(@PathVariable Integer pid) {
        log.info("restTemplate", restTemplate);
        ResultVo resultVo = restTemplate.getForObject(product_url+"/product/{1}",
                ResultVo.class,pid);
        return resultVo;
    }
    @GetMapping(value = "findproduct")
    public ResultVo findAllProductRem(){
        return productService.findAllProductRem();
    }
    @GetMapping(value = "message1")
    public String message1(){
        String test = myService.getTest();
        System.out.println("into message1"+test);
        return "message1:"+System.currentTimeMillis();
    }
    @GetMapping(value = "message2")
    public String message2(){
        System.out.println("into message2");
        String test = myService.getTest();
        System.out.println("into message2"+test);
        return "message2:"+System.currentTimeMillis();
    }
    @GetMapping(value = "message3")
    @SentinelResource(
            blockHandlerClass = OrdersControllerBlockHandler.class,
            blockHandler = "messageBlockHandler",
            fallbackClass = OrdersControllerFallback.class,
            fallback = "messageFallback")
    public String message3(){
        int r = new Random().nextInt(3);
        if(r==0){
            throw new RuntimeException();
        }
        return "message3"+System.currentTimeMillis();
    }
    @GetMapping(value = "/orders/{pid}/{buycount}")
    public ResultVo addOrders(@PathVariable Integer pid, @PathVariable Integer buycount){
//        List<ServiceInstance> microproduct = discoveryClient.getInstances("microproduct");
//        String url = microproduct.get(0).getUri().toString();

        ResultVo resultVo = restTemplate.getForObject(product_url+"/product/{1}", ResultVo.class,pid);
        if(resultVo.getStatus()==200){
            //map转换java对象
            Product product = new Product();
            Map map = (Map)resultVo.getE();
            BeanUtil.fillBeanWithMap(map,product,true);
            Orders orders = new Orders();
            BeanUtil.copyProperties(product,orders,true);
            orders.setUname("admin");
            orders.setBuycount(buycount);
            boolean flag = ordersService.addOrders(orders);
            if (flag) {
                log.debug("增加订单成功{}{}",pid,orders);
                return new ResultVo(Status.SUCCESS,"增加订单成功");
            }else {
                log.debug("增加订单失败",pid,orders);
                return new ResultVo(Status.ERROR,"增加订单失败");
            }
        }else {
            return new ResultVo(Status.ERROR,"服务器通讯失败");
        }
    }
    @GetMapping(value = "orders")
    public ResultVo findAllOrders(){
        try {
            List<Orders> allOrders = ordersService.findAllOrders();
            log.debug("查询所有订单{}",allOrders);
            return new ResultVo(Status.SUCCESS,"查询所有订单成功",allOrders);
        } catch (Exception e) {
            return new ResultVo(Status.ERROR,"查询所有订单失败");
        }
    }
    @GetMapping(value = "toaddproduct")
    public ResultVo toAddProduct(){
        Product product = new Product();
        product.setPname("小米手表");
        product.setPprice(99.99f);
        product.setStorecount(2000);
        product.setDescribute("这是一块智能手表");
        ResultVo voAddProduct = restTemplate.postForObject("http://localhost:8000/addproduct", product, ResultVo.class);
        if(voAddProduct.getStatus()==200){
            log.debug("订单控制器中增加产品成功");
            return new ResultVo(Status.SUCCESS,"订单控制器中增加产品成功");
        }else {
            log.debug("订单控制器中增加产品失败");
            return new ResultVo(Status.SUCCESS,"订单控制器中增加产品失败");
        }
    }
}
