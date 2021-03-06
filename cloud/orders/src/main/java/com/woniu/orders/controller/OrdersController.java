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
            //map??????java??????
            Product product = new Product();
            Map map = (Map)resultVo.getE();
            BeanUtil.fillBeanWithMap(map,product,true);
            Orders orders = new Orders();
            BeanUtil.copyProperties(product,orders,true);
            orders.setUname("admin");
            orders.setBuycount(buycount);
            boolean flag = ordersService.addOrders(orders);
            if (flag) {
                log.debug("??????????????????{}{}",pid,orders);
                return new ResultVo(Status.SUCCESS,"??????????????????");
            }else {
                log.debug("??????????????????",pid,orders);
                return new ResultVo(Status.ERROR,"??????????????????");
            }
        }else {
            return new ResultVo(Status.ERROR,"?????????????????????");
        }
    }
    @GetMapping(value = "orders")
    public ResultVo findAllOrders(){
        try {
            List<Orders> allOrders = ordersService.findAllOrders();
            log.debug("??????????????????{}",allOrders);
            return new ResultVo(Status.SUCCESS,"????????????????????????",allOrders);
        } catch (Exception e) {
            return new ResultVo(Status.ERROR,"????????????????????????");
        }
    }
    @GetMapping(value = "toaddproduct")
    public ResultVo toAddProduct(){
        Product product = new Product();
        product.setPname("????????????");
        product.setPprice(99.99f);
        product.setStorecount(2000);
        product.setDescribute("????????????????????????");
        ResultVo voAddProduct = restTemplate.postForObject("http://localhost:8000/addproduct", product, ResultVo.class);
        if(voAddProduct.getStatus()==200){
            log.debug("????????????????????????????????????");
            return new ResultVo(Status.SUCCESS,"????????????????????????????????????");
        }else {
            log.debug("????????????????????????????????????");
            return new ResultVo(Status.SUCCESS,"????????????????????????????????????");
        }
    }
}
