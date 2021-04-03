package cc.zy.base.businesses.service.impl;

import cc.zy.base.businesses.entity.DistinctReqResult;
import cc.zy.base.businesses.entity.ReqResultExtension;
import cc.zy.base.businesses.entity.Student;
import cc.zy.base.businesses.entity.StudentPool;
import cc.zy.base.businesses.mapper.StudentMapper;
import cc.zy.base.businesses.mapper.StudentPoolMapper;
import cc.zy.base.businesses.service.IBatchService;
import cc.zy.base.businesses.service.IDicService;
import cc.zy.base.businesses.service.IReqResultExtensionService;
import cc.zy.base.businesses.service.IStudentPoolService;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 *  Service实现
 *
 * @author Jiangjinlin
 * @date 2021-01-25 10:55:03
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StudentPoolServiceImpl extends ServiceImpl<StudentPoolMapper, StudentPool> implements IStudentPoolService {
    private final StudentPoolMapper studentPoolMapper;
    @Resource
    private   IStudentPoolService studentPoolService;
    @Resource
    private   IReqResultExtensionService iReqResultExtensionService;
    @Resource
    private   IDicService iDicService;
    @Resource
    private   IBatchService iBatchService;
    @Override
    public IPage<StudentPool> findStudentPools(QueryRequest request, StudentPool studentPool) {
        LambdaQueryWrapper<StudentPool> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<StudentPool> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<StudentPool> findStudentPools(StudentPool studentPool) {
	    LambdaQueryWrapper<StudentPool> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createStudentPool(StudentPool studentPool) {
        this.save(studentPool);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateStudentPool(StudentPool studentPool) {
        this.saveOrUpdate(studentPool);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteStudentPool(StudentPool studentPool) {
        LambdaQueryWrapper<StudentPool> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}

    @Override
    public int AddStudentPoolList(List<StudentPool> studentPools) {
        int StudentPoolRetrnValue= baseMapper.AddStudentPoolList(studentPools);
        return  StudentPoolRetrnValue;
    }
    /**
     * @author zhangkai
     * @date 2021-02-01 10:55:03
     */
    @Override
    public StudentPool ifStudentPool(StudentPool studentPool) {
        StudentPool ifStudentPool= baseMapper.ifStudentPool(studentPool);
        return ifStudentPool;
    }

    @Override
    public FebsResponse addStudentPool(List<DistinctReqResult> distinctReqResults) {
        List<StudentPool>  studentPool=new ArrayList<StudentPool>();
        ReqResultExtension reqResultExtension=new ReqResultExtension();
        if (distinctReqResults!=null){
            for (int i = 0;i<distinctReqResults.size();i++) {
                reqResultExtension.setId(distinctReqResults.get(i).getId());
                List<ReqResultExtension> reqResultExtensionList = iReqResultExtensionService.findReqResultExtensions(reqResultExtension);
                studentPool.get(i).setIdCard(reqResultExtensionList.get(0).getIdentity());
                studentPool.get(i).setBatch(reqResultExtensionList.get(0).getBatchId());
                studentPool.get(i).setStudyMode(reqResultExtensionList.get(0).getStudyTypeId());
                studentPool.get(i).setReqExtensionId(distinctReqResults.get(i).getId());
                studentPool.get(i).setDistinctReqId(distinctReqResults.get(i).getId());
                studentPool.get(i).setReqInfoId(distinctReqResults.get(i).getReqInfoId());
                studentPool.get(i).setFollowUserId(distinctReqResults.get(i).getFollowUserId());
                studentPool.get(i).setGroupId(distinctReqResults.get(i).getGroupId());
                studentPool.get(i).setName(distinctReqResults.get(i).getName());
                studentPool.get(i).setGender(reqResultExtensionList.get(0).getSexId());
                studentPool.get(i).setBirthday(distinctReqResults.get(i).getBirthday());
                studentPool.get(i).setIsLunarBirthday(distinctReqResults.get(i).getIsLunarBirthday());
                studentPool.get(i).setTitle(distinctReqResults.get(i).getTitle());
                studentPool.get(i).setQq(distinctReqResults.get(i).getQq());
                studentPool.get(i).setMobile(distinctReqResults.get(i).getMobile());
                studentPool.get(i).setPhone(distinctReqResults.get(i).getPhone());
                studentPool.get(i).setFax(distinctReqResults.get(i).getFax());
                studentPool.get(i).setEmail(distinctReqResults.get(i).getEmail());
                studentPool.get(i).setCompany(distinctReqResults.get(i).getCompany());
                studentPool.get(i).setCompanyUrl(distinctReqResults.get(i).getCompanyUrl());
                studentPool.get(i).setCompanyAddress(distinctReqResults.get(i).getCompanyAddress());
                studentPool.get(i).setMemo(distinctReqResults.get(i).getMemo());
                studentPool.get(i).setVocation(distinctReqResults.get(i).getVocation());
                if( distinctReqResults.get(i).getChannel().equals("未知")){
                    //转为未0
                    studentPool.get(i).setChannel(0);
                }else {
                    //直接转化未数字
                    studentPool.get(i).setChannel(Integer.parseInt(distinctReqResults.get(i).getChannel()));
                }
                studentPool.get(i).setPrefecture(distinctReqResults.get(i).getPrefecture());
                //自定义字段
                studentPool.get(i).setFieldInfos(distinctReqResults.get(i).getFieldInfos());
                studentPool.get(i).setCrmId(distinctReqResults.get(i).getCrmId());
                studentPool.get(i).setModifyTime(distinctReqResults.get(i).getModifyTime());
                studentPool.get(i).setContacTtime(distinctReqResults.get(i).getBirthday());
                studentPool.get(i).setCreateTime(distinctReqResults.get(i).getCreateTime());
                studentPool.get(i).setLastFollowUserId(distinctReqResults.get(i).getLastFollowUserId());
                studentPool.get(i).setStep(distinctReqResults.get(i).getStep());
            }
        }
        //新的学生信息集合
        List<StudentPool>  NewStudentPool=new ArrayList<StudentPool>();
        if(studentPool.size()>0){
            for (int i = 0; i <studentPool.size();i++) {
                //          System.out.println(studentPool.get(i));
                StudentPool ifStudentPool = studentPoolService.ifStudentPool(studentPool.get(i));
                if (ifStudentPool!=null){
                    //有重复修改扩展表
                    System.out.println("数据库种");
                    //重复的扩展表id
                    ReqResultExtension reqResultExtensionOld = iReqResultExtensionService.findById(ifStudentPool.getReqExtensionId());
                    //新的id
                    ReqResultExtension reqResultExtensionNew = iReqResultExtensionService.findById(studentPool.get(i).getReqExtensionId());
                    if (reqResultExtensionOld.getLevel().equals(reqResultExtensionNew.getLevel())){
                        //相等修改
                        StudentPool  studentPoolUpdate=new StudentPool();
                        studentPoolUpdate.setId(studentPool.get(i).getId());
                        studentPoolUpdate.setIdCard(studentPool.get(i).getIdCard());
                        studentPoolUpdate.setBatch(studentPool.get(i).getBatch());
                        studentPoolUpdate.setReqExtensionId(studentPool.get(i).getReqExtensionId());
                        studentPoolService.updateStudentPool(studentPoolUpdate);
                    }else {
                        //不相等添加
                        NewStudentPool.add(studentPool.get(i));
                    }
                }else {
                    //没有重复加到新集合里面
                    NewStudentPool.add(studentPool.get(i));
                }
            }
            //一起加到学生公海表中
            if(NewStudentPool.size()>0){
                studentPoolService.AddStudentPoolList(NewStudentPool);
            }
        }
        return new FebsResponse().success();
    }

    @Override
    public StudentPool findStudentByOpenId(String openId)
    {

        return this.studentPoolMapper.findStudentByOpenId(openId);
    }
    @Override
    public StudentPool findStudentByWxInfo(String batch, String idCard, String mobile, String studyMode)
    {
        return this.studentPoolMapper.findStudentByWxInfo(batch, idCard, mobile, studyMode);
    }

    @Override
    public StudentPool findStudentByWxInfoAndOpenId(String batch, String idCard, String mobile, String studyMode, String openId)
    {
        return this.studentPoolMapper.findStudentByWxInfoAndOpenId(batch, idCard, mobile, studyMode, openId);
    }

}
