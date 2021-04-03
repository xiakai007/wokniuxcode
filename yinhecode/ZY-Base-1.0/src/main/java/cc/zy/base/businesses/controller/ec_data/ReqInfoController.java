package cc.zy.base.businesses.controller.ec_data;

import cc.zy.base.businesses.service.IDicService;
import cc.zy.base.businesses.service.IReqInfoService;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.FebsUtil;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 *  Controller
 *
 * @author peihaodong
 * @date 2021-01-25 19:58:35
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("reqInfo")
public class ReqInfoController extends BaseController {
    @Resource
    private final IReqInfoService reqInfoService;
    @Resource
    private final IDicService dicService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "reqInfo")
    public String reqInfoIndex(){
        return FebsUtil.view("reqInfo/reqInfo");
    }


    /**
     * 异常请求列表
     */
    @GetMapping("list")
    @ResponseBody
//    @RequiresPermissions("reqInfo:view")
    public FebsResponse reqInfoList(QueryRequest request, String startDate,String endDate
            , Integer triggerType, Integer reqUserId) {
        if (reqUserId != null) {
            if (reqUserId == 0){
                reqUserId = null;
            }
        }
        if (triggerType != null) {
            if (triggerType == 0){
                triggerType = null;
            }
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate0 = null;
        Date endDate0 =null;
        try {
            if (startDate != null) {
                startDate0 = simpleDateFormat.parse(startDate);
            }
            if (endDate != null) {
                endDate0 = simpleDateFormat.parse(endDate);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(startDate0);
        System.out.println(endDate0);
        System.out.println(triggerType);
        System.out.println(reqUserId);
        int status = dicService.findDicId("req_info_status",2);
        Map<String, Object> dataTable = getDataTable(this.reqInfoService.selectReqInfosByCondition(request, startDate0,
                endDate0, triggerType, reqUserId,status));
        return new FebsResponse().success().data(dataTable);
    }


//    //同步EC数据
//    @GetMapping("test")
//    @ResponseBody
//    public String testReq(){
//        //创建请求信息对象，记录信息
//        ReqInfo reqInfo = new ReqInfo();
//        //获取触发方式 （id值）
//        Dic dic = new Dic();
//        dic.setType("trigger_type");
//        dic.setSid(2);
//        List<Dic> dics = dicService.findDics(dic);
//        int triggerType = dics.get(0).getId();
//        reqInfo.setTriggerType(triggerType);
//
//        //设置请求路径
////        String url = "https://open.workec.com/newdoc/doc/GLh4YsMiq";
//        String url = "http://api.map.baidu.com/place/v2/search?query=%E8%A3%B4&region=%E8%A5%BF%E5%AE%89&output=json&ak=1fKv3t19x4EMRYWjWc5DZWT1L9LwIrd5&page_size=20&page_num=1";
//        reqInfo.setUrl(url);
//
//        //获取设置用户信息
//        Long reqUserIdLong = FebsUtil.getCurrentUser().getUserId();
//        long reqUserId = reqUserIdLong;
//        reqInfo.setReqUserId((int)reqUserId);
//
//        //记录请求时间
//        Date reqTime = new Date();
//        reqInfo.setReqTime(reqTime);
//
//
//        // 创建Get请求
//        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//        HttpGet httpGet = new HttpGet(url);
//        // 响应模型
//        CloseableHttpResponse response = null;
//        try {
//            // 由客户端执行(发送)Get请求
//            response = httpClient.execute(httpGet);
//
//
//            //获取响应状态码respStatusCode
//            int respStatusCode = response.getStatusLine().getStatusCode();
//            reqInfo.setRespStatusCode(respStatusCode);
//
//            //设置请求信息状态
//            int status;
//            if (respStatusCode != 200){
//                status = dicService.findDicId("req_info_status",2);
//            }else {
//                status = dicService.findDicId("req_info_status",0);
//            }
//            reqInfo.setStatus(status);
//
//            //获取头信息
//            Header[] headers = response.getAllHeaders();
//            for (Header header : headers) {
//                System.out.println(header);
//            }
//
//
//            //获取请求结果data数据
//            // 从响应模型中获取响应实体
//            HttpEntity responseEntity = response.getEntity();
//            if (responseEntity != null) {
//                String strJson = EntityUtils.toString(responseEntity);
//                System.out.println("响应内容为:" + strJson);
//                ObjectMapper objectMapper = new ObjectMapper();
//                String resultData = strJson;//需要修改
//                reqInfo.setResultData(resultData);
//            }
//
//
//            //插入数据库REQ_INFO表中
//            reqInfoService.createReqInfo(reqInfo);
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                // 释放资源
//                if (httpClient != null) {
//                    httpClient.close();
//                }
//                if (response != null) {
//                    response.close();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return "请求信息添加成功";
//    }


}
