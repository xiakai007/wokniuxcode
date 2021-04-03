package cc.zy.base.businesses.service.impl;

import cc.zy.base.businesses.entity.*;
import cc.zy.base.businesses.mapper.*;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.businesses.service.ICollegeService;
import cc.zy.base.common.utils.SortUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.annotation.Resource;
import java.util.*;

/**
 * Service实现
 *
 * @author Jiangjinlin
 * @date 2021-01-18 10:51:13
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CollegeServiceImpl extends ServiceImpl<CollegeMapper, College> implements ICollegeService {
    @Resource
    private final CollegeMapper collegeMapper;
    private final LevelMapper levelMapper;

    private final MajorMapper majorMapper;

    private final BatchMapper batchMapper;

    private final DicMapper dicMapper;

    @Override
    public IPage<College> findColleges(QueryRequest request, College college) {
        Page<College> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(baseMapper.countCollegeDetail(college));
        SortUtil.handlePageSort(request, page, "id", FebsConstant.ORDER_ASC, false);
        return this.baseMapper.findCollegeDetailPage(page, college);
    }

    @Override
    public College findById(Integer id) {
        return this.baseMapper.findById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteColleges(String[] collegeIds) {
        List<String> list = Arrays.asList(collegeIds);
        // 删除用户
        this.removeByIds(list);
    }

    @Override
    public List<College> findCollageListNotPage(College college) {
        List<College> collageListNotPage = baseMapper.findCollageListNotPage(college);
        return collageListNotPage;
    }


    @Override
    public College findCollegeDetailList(Integer id) {
        College param = new College();
        param.setId(id);
        List<College> college = this.baseMapper.findCollegeDetail(param);
        return CollectionUtils.isNotEmpty(college) ? college.get(0) : null;
    }

    @Override
    public List<College> findColleges(College college) {
        LambdaQueryWrapper<College> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createCollege(College college) {
        college.setCreatedate(new Date());
        college.setUpdatedate(new Date());
        this.save(college);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCollege(College college) {
        this.saveOrUpdate(college);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteCollege(College college) {
        LambdaQueryWrapper<College> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }

    /**
     * @Description: 级联：查询所有院校
     * @return: 院校集合
     * @author: LiPeng
     * @date: 2021/2/10
     */
    @Override
    public List<College> findCollegeForSelect() {
        return this.collegeMapper.selectCollegeForSelect();
    }

    /**
     * @Description: 级联：根据院校id查询层次
     * @Param: collegeId 院校id
     * @return: 层次集合
     * @author: LiPeng
     * @date: 2021/2/10
     */
    @Override
    public List<Level> findLevelForSelect(Integer collegeId) {
        return this.levelMapper.selectLevelForSelect(collegeId);
    }

    /**
     * @Description: 级联：根据院校id、层次id查询专业
     * @Param: collegeId 院校id；levelId 层次id
     * @return: 专业集合
     * @author: LiPeng
     * @date: 2021/2/10
     */
    @Override
    public List<Major> findMajorForSelect(Integer collegeId, Integer levelId) {
        return this.majorMapper.selectMajorForSelect(collegeId, levelId);
    }

    /**
     * @Description: 所有有效批次
     * @return: 批次集合
     * @author: LiPeng
     * @date: 2021/2/10
     */
    @Override
    public List<Batch> findBatchForSelect() {
        return this.batchMapper.selectBatchForSelect();
    }

    @Override
    public Boolean isRepetitive(String name, String simplename) {
        List<College> repetitive = collegeMapper.isRepetitive(name, simplename);
        Boolean flag = true;
        if (repetitive != null && repetitive.size() > 0) {
            flag = false;
        }
        return flag;
    }

    /**
     * @description: 查询所有学习形式
     * @return: 学习形式集合
     * @author: LiPeng
     * @date: 2021/3/4
     */
    @Override
    public List<Dic> findStudyTypeForSelect() {
        List<Dic> studyTypeList = this.dicMapper.findDicByType("study_type");
        return studyTypeList;
    }
}