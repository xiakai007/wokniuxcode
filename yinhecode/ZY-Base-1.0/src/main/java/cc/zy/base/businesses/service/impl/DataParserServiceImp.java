package cc.zy.base.businesses.service.impl;

import cc.zy.base.businesses.entity.DistinctReqResult;
import cc.zy.base.businesses.entity.ReqInfo;
import cc.zy.base.businesses.entity.ReqResult;
import cc.zy.base.businesses.entity.ResolveException;
import cc.zy.base.businesses.service.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DataParserServiceImp implements IDataParserService{

    @Resource
    private IReqInfoService reqInfoService;
    @Resource
    private IReqResultService reqResultService;
    @Resource
    private IDistinctReqResultService distinctReqResultService;
    @Resource
    private IResolveExceptionService resolveExceptionService;
    @Resource
    private IDicService dicService;

    @Override
    public void dataParser() {
        //查询EC拉取成功但是还没有解析的数据
        ReqInfo reqInfo = new ReqInfo();
        reqInfo.setStatus(dicService.findDicId("req_info_status",0));
        try {
            List<ReqInfo>  reqInfos = reqInfoService.findReqInfos(reqInfo);


            //解析data数据
            for (ReqInfo info : reqInfos) {
                String resultData = info.getResultData();
                Map map = JSON.parseObject(resultData, Map.class);
                String l =map.get("customerInfoList").toString();
                List list = JSON.parseObject(l, List.class);
                info.setRespStatusCode(list.size());
                List<DistinctReqResult> distinctReqResults = new ArrayList<>();
                for (Object o : list) {
                    ReqResult reqResult = null;
                    try {
                        reqResult = JSONObject.parseObject(o.toString(), ReqResult.class);

                        try {
                            //把解析的EC数据添加到EC返回结果表中，同时解析自定义字段、增加并保持二者的事务同步
                             ReqResult reqResult1 = new ReqResult();
                            reqResult1 = reqResultService.addReqResultAndReqResultExtension(reqResult,info);


                            //把符合条件的解析的data数据转换为distinctReqResults集合为去重做准备
                            DistinctReqResult distinctReqResult = new DistinctReqResult();
                            distinctReqResult = JSONObject.parseObject(o.toString(), DistinctReqResult.class);
                            distinctReqResult.setId(reqResult1.getId());
                            distinctReqResults.add(distinctReqResult);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e) {
                        ResolveException resolveException = new ResolveException();
                        resolveException.setReqInfoId(info.getId());
                        resolveException.setExceptionTime(new Timestamp(System.currentTimeMillis()));
                        resolveException.setReqUserId(info.getReqUserId());
                        resolveException.setTriggerType(info.getTriggerType());
                        resolveException.setExceptionInfo("解析"+o+"的时候出错，错误为"+e);
                        resolveExceptionService.createResolveException(resolveException);
                    }
                }


                info.setResolveSuccess(distinctReqResults.size());
                //去除和数据库相同的数据然后批量插入 EC 去重 返回结果表
                List<DistinctReqResult> distinctReqResultList = new ArrayList<>();
                for (DistinctReqResult distinctReqResult : distinctReqResults) {
                    DistinctReqResult distinctReqResultBySome = new DistinctReqResult();
                    distinctReqResultBySome = distinctReqResultService.findDistinctReqResultBySome(distinctReqResult);
                    if(distinctReqResultBySome!=null){
                        distinctReqResultList.add(distinctReqResult);
                    }
                }
                HashSet hs1 = new HashSet(distinctReqResults);
                HashSet hs2 = new HashSet(distinctReqResultList);
                hs1.removeAll(hs2);
                List<DistinctReqResult> addDistinctReqResultList = new ArrayList<>();
                addDistinctReqResultList.addAll(hs1);
                try {
                    if(addDistinctReqResultList!=null&&addDistinctReqResultList.size()>0){
                        distinctReqResultService.addReqResultList(addDistinctReqResultList);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //修改请求信息表
                info.setStatus(dicService.findDicId("req_info_status",1));
                reqInfoService.updateReqInfo(info);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
