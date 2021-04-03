package cc.zy.base.businesses.service.impl;


import cc.zy.base.businesses.entity.SubjectCategory;
import cc.zy.base.businesses.mapper.SubjectCategoryMapper;
import cc.zy.base.businesses.service.ISubjectCategoryService;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.SortUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Date;
import java.util.List;

/**
 * 学科类别表 Service实现
 *
 * @author guozhikun
 * @date 2021-01-26 16:18:45
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SubjectCategoryServiceImpl extends ServiceImpl<SubjectCategoryMapper, SubjectCategory> implements ISubjectCategoryService {

    private final SubjectCategoryMapper subjectCategoryMapper;



    @Override
    public List<SubjectCategory> findSubjectCategorys(SubjectCategory subjectCategory) {
	    LambdaQueryWrapper<SubjectCategory> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

  

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSubjectCategory(SubjectCategory subjectCategory) {
        this.saveOrUpdate(subjectCategory);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteSubjectCategory(SubjectCategory subjectCategory) {
        LambdaQueryWrapper<SubjectCategory> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}


    @Override
    public List<SubjectCategory> getSubjectCategorys(Integer levelId) {
        return subjectCategoryMapper.getSubjectCategorys(levelId);
    }

	 @Override
    public IPage<SubjectCategory> findSubjectCategorys(QueryRequest request, SubjectCategory subjectCategory) {
        Page<SubjectCategory> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(baseMapper.countSubjectCategoryDetail(subjectCategory));
        SortUtil.handlePageSort(request,page,"createTime", FebsConstant.ORDER_DESC, true);
        return this.baseMapper.findSubjectCategoryDetailPage(page,subjectCategory);
    }

    @Override
    public SubjectCategory findById(Integer id) {
        return subjectCategoryMapper.findById(id);
    }

    @Override
    public List<SubjectCategory> findSubjectCategory() {
        return subjectCategoryMapper.findSubjectCategory();
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public String createSubjectCategory(SubjectCategory subjectCategory,Integer levelId) {
        String fullName = subjectCategory.getFullName();
        Integer subTypeIdByName = this.baseMapper.getSubTypeIdByName(fullName);
        if (subTypeIdByName==null||subTypeIdByName.equals("")){
            subjectCategory.setCreateTime(new Date());
            this.save(subjectCategory);
            log.info("类别名称    "+subjectCategory.getFullName());
            Integer subTypeId = this.baseMapper.getSubTypeIdByName(subjectCategory.getFullName());
            this.baseMapper.insertLevelAndSubtype(levelId,subTypeId);
            return "200";
        }else {
            return "400";
        }

    }
  
}
