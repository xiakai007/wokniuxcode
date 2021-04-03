package cc.zy.base.businesses.controller;

import cc.zy.base.businesses.entity.College;
import cc.zy.base.businesses.service.IPaymentService;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.FebsUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("payment")
public class IPaymentController {
    @Resource
    private final IPaymentService iPaymentService;


    @GetMapping("list")
    @ResponseBody
    //@RequiresPermissions("payment:list")
    public FebsResponse collegeList() {
        System.out.println("进入查询退费申请控制器");
        List<Map<String, Object>> resultList = iPaymentService.refundApplyListForFinanace();


        return new FebsResponse().success().data(resultList);
    }



}
