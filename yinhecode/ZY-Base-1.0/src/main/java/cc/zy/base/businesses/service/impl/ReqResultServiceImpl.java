package cc.zy.base.businesses.service.impl;


import cc.zy.base.businesses.entity.ReqInfo;
import cc.zy.base.businesses.entity.ReqResult;
import cc.zy.base.businesses.entity.ReqResultExtension;
import cc.zy.base.businesses.mapper.ReqResultMapper;
import cc.zy.base.businesses.service.IDicService;
import cc.zy.base.businesses.service.IReqResultExtensionService;
import cc.zy.base.businesses.service.IReqResultService;
import cc.zy.base.businesses.utils.ECUtil;
import cc.zy.base.common.entity.QueryRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *  Service实现
 *
 * @author LiXu
 * @date 2021/01/25
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ReqResultServiceImpl extends ServiceImpl<ReqResultMapper, ReqResult> implements IReqResultService {
    @Resource
    private IReqResultExtensionService extensionService;

    private final ReqResultMapper reqResultMapper;

    private final IDicService dicService;

    @Override
    public IPage<ReqResult> findReqResults(QueryRequest request, ReqResult reqResult) {
        LambdaQueryWrapper<ReqResult> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<ReqResult> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<ReqResult> findReqResults(ReqResult reqResult) {
	    LambdaQueryWrapper<ReqResult> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createReqResult(ReqResult reqResult) {
        this.save(reqResult);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateReqResult(ReqResult reqResult) {
        this.saveOrUpdate(reqResult);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteReqResult(ReqResult reqResult) {
        LambdaQueryWrapper<ReqResult> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addReqResultList(List<ReqResult> reqResultList) {
        this.baseMapper.addReqResultList(reqResultList);
    }

    @Override
    public int addReqResultGetId(ReqResult reqResult) {
        return this.baseMapper.addReqResultGetId(reqResult);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ReqResult addReqResultAndReqResultExtension(ReqResult reqResult, ReqInfo reqInfo) {
        reqResult.setReqInfoId(reqInfo.getId());
        int i = addReqResultGetId(reqResult);
        reqResult.setId(i);
//        ReqResultExtension reqResultExtension = new ReqResultExtension();
//        //根据CrmId来查询标签ID
//        String sex = reqResult.getGender();
//        if("男".equals(sex)){
//            reqResultExtension.setSexId(dicService.findDicId("sex",1));
//        }else if("女".equals(sex)){
//            reqResultExtension.setSexId(dicService.findDicId("sex",2));
//        }else if("未知".equals(sex)){
//            reqResultExtension.setSexId(dicService.findDicId("sex",32));
//        }
//        //姓名
//        reqResultExtension.setStuName(reqResult.getName());
//        //手机号码
//        reqResultExtension.setTel(reqResult.getMobile());
//        //创建时间
//        reqResultExtension.setEnrolDate(reqResult.getCreateTime());
//
//
//        ECUtil instance = ECUtil.getInstance();
//        List<Integer> labelIds = instance.getLabelIds((long)reqResult.getCrmId());
//        Map<Long, Map<String, String>> lableMap = instance.getLableMap();
//        for (Integer labelId : labelIds) {
//            Map<String, String> stringStringMap = lableMap.get(labelId);
//            String s = stringStringMap.get("电话状态");
//            String s1 = stringStringMap.get("是否加微信");
//            String s2 = stringStringMap.get("客户意向度");
//            String s3 = stringStringMap.get("报考层次");
//            if("高起专".equals(s3)){
//                reqResultExtension.setLevel(2);
//            }else if("专升本".equals(s3)){
//                reqResultExtension.setLevel(1);
//            }else if("高起本".equals(s3)){
//                reqResultExtension.setLevel(3);;
//            }
//            String s4 = stringStringMap.get("报考类型");
//            if("国开".equals(s4)){
//                reqResultExtension.setStudyTypeId(dicService.findDicId("study_type",3));
//            }else if("网络教育".equals(s4)){
//                reqResultExtension.setStudyTypeId(dicService.findDicId("study_type",2));
//            }else if("成教".equals(s4)){
//                reqResultExtension.setStudyTypeId(dicService.findDicId("study_type",1));
//            }
//            String s5 = stringStringMap.get("年龄");
//            String s6 = stringStringMap.get("班型");
//            String s7 = stringStringMap.get("有无毕业证");
//        }
//
//
//
//        //把自定义字段解析成标签ID
//
//        reqResultExtension.setReqInfoId(reqInfo.getId());
//        reqResultExtension.setReqResultId(reqResult.getId());
//        reqResultExtension.setId(reqResult.getId());
//        String fid = reqResult.getFieldInfos();
//        List lists = JSON.parseObject(fid, List.class);
//        for (Object list1 : lists) {
//            Map<String,String> map1 = JSON.parseObject(list1.toString(), Map.class);
//            Set<String> strings = map1.keySet();
//            for (String string : strings) {
//                Integer indb = Integer.parseInt(string);
//
//
//            }
//        }
//
//        extensionService.createReqResultExtension(reqResultExtension);
        return reqResult;
    }
}
