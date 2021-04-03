package cc.zy.base.businesses.service.impl;


import cc.zy.base.businesses.entity.StandardFee;
import cc.zy.base.businesses.mapper.StandardFeeMapper;
import cc.zy.base.businesses.service.IStandardFeeService;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.SortUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *  Service实现
 *
 * @author Jiangjinlin
 * @date 2021-01-26 09:54:23
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StandardFeeServiceImpl extends ServiceImpl<StandardFeeMapper, StandardFee> implements IStandardFeeService  {
    @Resource
    private final StandardFeeMapper standardFeeMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteStandardFees(String[] standardFeeIds) {
        List<String> list = Arrays.asList(standardFeeIds);
        // 删除用户
        this.removeByIds(list);
    }

    @Override
    public List<Map<String, String>> batchAll(Integer id) {
        return standardFeeMapper.batchAll(id);
    }

    @Override
    public List<Map<String, String>> collegeAll(Integer batchId) {
        return standardFeeMapper.collegeAll(batchId);
    }

    @Override
    public List<Map<String, String>> levelAll(Integer batchId, Integer collegeId) {
        return standardFeeMapper.levelAll(batchId,collegeId);
    }

    @Override
    public List<Map<String, String>> subjectCategoryAll(Integer batchId, Integer collegeId, Integer levelId) {
        return standardFeeMapper.subjectCategoryAll(batchId,collegeId,levelId);
    }

    @Override
    public List<Map<String, String>> majorAll(Integer batchId, Integer collegeId, Integer levelId, Integer subjectCategoryId) {
        return standardFeeMapper.majorAll(batchId,collegeId,levelId,subjectCategoryId);
    }


    @Override
    public List<Map<String, String>> cultivateAll() {
        return standardFeeMapper.cultivateAll();
    }

    @Override
    public List<Map<String, String>> oldBatchAll() {
        return standardFeeMapper.oldBatchAll();
    }

    @Override
    public List<Map<String, String>> newBatchAll() {
        return standardFeeMapper.newBatchAll();
    }

    @Override
    public int count(StandardFee standardFee) {

        StandardFee s1=new StandardFee();
        s1.setPaymenExplain("报名费");
        s1.setBatchId(standardFee.getBatchId());
        s1.setCultivate(standardFee.getCultivate());
//        boolean b=false;
//        BigDecimal entryFee = standardFee.getEntryFee();
//        String s = entryFee.toString();
//        char[] chars = s.toCharArray();
//        for (char aChar : chars) {
//            if(aChar=='.'){
//                b=true;
//            }
//        }
//        if (!b){
//            char[] a=new char[chars.length+3];
//        }
        s1.setOriginalPrice(standardFee.getEntryFee());
        s1.setCollegeId(standardFee.getCollegeId());

        s1.setStudyLevelId(standardFee.getStudyLevelId());
        s1.setMajorId(standardFee.getMajorId());
        s1.setSubjectCategoryId(standardFee.getSubjectCategoryId());

        StandardFee s2=new StandardFee();
        s2.setPaymenExplain("第一学年");
        s2.setBatchId(standardFee.getBatchId());
        s2.setCultivate(standardFee.getCultivate());
        s2.setOriginalPrice(standardFee.getFirstFee());
        s2.setCollegeId(standardFee.getCollegeId());

        s2.setStudyLevelId(standardFee.getStudyLevelId());
        s2.setMajorId(standardFee.getMajorId());
        s2.setSubjectCategoryId(standardFee.getSubjectCategoryId());

        StandardFee s3=new StandardFee();
        s3.setPaymenExplain("第二学年");
        s3.setBatchId(standardFee.getBatchId());
        s3.setCultivate(standardFee.getCultivate());
        s3.setOriginalPrice(standardFee.getSecondFee());
        s3.setCollegeId(standardFee.getCollegeId());

        s3.setStudyLevelId(standardFee.getStudyLevelId());
        s3.setMajorId(standardFee.getMajorId());
        s3.setSubjectCategoryId(standardFee.getSubjectCategoryId());

        StandardFee s4=new StandardFee();
        s4.setPaymenExplain("第三学年");
        s4.setBatchId(standardFee.getBatchId());
        s4.setCultivate(standardFee.getCultivate());
        s4.setOriginalPrice(standardFee.getThirdlyFee());
        s4.setCollegeId(standardFee.getCollegeId());

        s4.setStudyLevelId(standardFee.getStudyLevelId());
        s4.setMajorId(standardFee.getMajorId());
        s4.setSubjectCategoryId(standardFee.getSubjectCategoryId());
         StandardFee s5=new StandardFee();
          StandardFee s6=new StandardFee();
        if(standardFee.getFourthlyFee()!=null){

            s5.setPaymenExplain("第四学年");
            s5.setBatchId(standardFee.getBatchId());
            s5.setCultivate(standardFee.getCultivate());
            s5.setOriginalPrice(standardFee.getFourthlyFee());
            s5.setCollegeId(standardFee.getCollegeId());

            s5.setStudyLevelId(standardFee.getStudyLevelId());
            s5.setMajorId(standardFee.getMajorId());
            s5.setSubjectCategoryId(standardFee.getSubjectCategoryId());


            s6.setPaymenExplain("第五学年");
            s6.setBatchId(standardFee.getBatchId());
            s6.setCultivate(standardFee.getCultivate());
            s6.setOriginalPrice(standardFee.getFifthFee());
            s6.setCollegeId(standardFee.getCollegeId());

            s6.setStudyLevelId(standardFee.getStudyLevelId());
            s6.setMajorId(standardFee.getMajorId());
            s6.setSubjectCategoryId(standardFee.getSubjectCategoryId());


        }


        int count=0;


            count += this.standardFeeMapper.addStandardFee(s1);
            count += this.standardFeeMapper.addStandardFee(s2);
            count += this.standardFeeMapper.addStandardFee(s3);
            count += this.standardFeeMapper.addStandardFee(s4);
            if(standardFee.getFourthlyFee()!=null&&standardFee.getFifthFee()!=null){
                 count += this.standardFeeMapper.addStandardFee(s5);
                 count += this.standardFeeMapper.addStandardFee(s6);

            }

        return count;
    }

    @Override
    public int verify(Integer id) {
        return standardFeeMapper.verify(id);
    }

    @Override
    public int copy(Integer oldid, Integer newid) {
        int i = standardFeeMapper.deleteById(newid);
         int copy=0;
        if(i>=0){
             copy = standardFeeMapper.copy(oldid, newid);
        }

        return copy;
    }

    @Override
    public int verifys(Integer batchId,Integer collegeId,Integer studyLevelId,Integer subjectCategoryId,Integer majorId,Integer cultivate) {
        return standardFeeMapper.verifys( batchId, collegeId, studyLevelId, subjectCategoryId, majorId, cultivate);
    }

    @Override
    public IPage<StandardFee> findStandardFees(QueryRequest request, StandardFee standardFee) {
       LambdaQueryWrapper<StandardFee> queryWrapper = new LambdaQueryWrapper<>();
        Page<StandardFee> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(baseMapper.countStandardFeeDetail(standardFee));
        SortUtil.handlePageSort(request, page, "T.ID", FebsConstant.ORDER_DESC, false);
        return this.baseMapper.findStandardFeeDetailPage(page,standardFee);
    }
//    @Override
//    public IPage<StandardFee> findStandardFees(QueryRequest request, StandardFee standardFee) {
//        LambdaQueryWrapper<StandardFee> queryWrapper = new LambdaQueryWrapper<>();
//        // TODO 设置查询条件
//        Page<StandardFee> page = new Page<>(request.getPageNum(), request.getPageSize());
//        return this.page(page, queryWrapper);
//
//
////          Page<StandardFee> page = new Page<>(request.getPageNum(), request.getPageSize());
////        page.setSearchCount(false);
////        page.setTotal(baseMapper.countStandardFeeDetail(standardFee));
////        SortUtil.handlePageSort(request, page, "id", FebsConstant.ORDER_ASC, false);
////        return this.baseMapper.findStandardFeeDetailPage(page,standardFee);
//    }

    @Override
    public List<StandardFee> findStandardFees(StandardFee standardFee) {
	    LambdaQueryWrapper<StandardFee> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

//    @Override
//    public List<Map<String, Object>> fingStandardFeeAll() {
//
//        return this.standardFeeMapper.fingStandardFeeAll();
//    }

        @Override
    public StandardFee findById(Integer id) {
        return this.baseMapper.findById(id);
    }

    @Override
    public int addStandardFee(StandardFee standardFee) {
        return standardFeeMapper.addStandardFee(standardFee);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createStandardFee(StandardFee standardFee) {
        this.save(standardFee);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateStandardFee(StandardFee standardFee) {
        this.saveOrUpdate(standardFee);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteStandardFee(StandardFee standardFee) {
        LambdaQueryWrapper<StandardFee> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}
}
