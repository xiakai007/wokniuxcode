package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.*;

import cc.zy.base.common.entity.QueryRequest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * Service接口
 *
 * @author Jiangjinlin
 * @date 2021-01-18 10:51:13
 */
public interface ICollegeService extends IService<College> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param college college
     * @return IPage<College>
     */
    IPage<College> findColleges(QueryRequest request, College college);

    /**
     * 通过ID查找院校详细信息
     *
     * @param id id
     * @return 院校信息
     */
    College findCollegeDetailList(Integer id);

    /**
     * 通过ID查找院校详细信息
     *
     * @param id id
     * @return 院校信息
     */
    College findById(Integer id);

    /**
     * 查询（所有）
     *
     * @param college college
     * @return List<College>
     */
    List<College> findColleges(College college);

    /**
     * 新增
     *
     * @param college college
     */
    void createCollege(College college);

    /**
     * 修改
     *
     * @param college college
     */
    void updateCollege(College college);

    /**
     * 删除
     *
     * @param college college
     */
    void deleteCollege(College college);

    /**
     * 删除院校
     *
     * @param collegeIds 院校 id数组
     */
    void deleteColleges(String[] collegeIds);

    /**
     * 查询不带分页
     */
    List<College> findCollageListNotPage(College college);

    /**
     * @Description: 级联：查询所有院校
     * @return: 院校集合
     * @author: LiPeng
     * @date: 2021/2/1
     */
    List<College> findCollegeForSelect();

    /**
     * @Description: 级联：根据院校id查询层次
     * @Param: collegeId 院校id
     * @return: 层次集合
     * @author: LiPeng
     * @date: 2021/2/1
     */
    List<Level> findLevelForSelect(Integer collegeId);

    /**
     * @Description: 级联：根据院校id、层次id查询专业
     * @Param: collegeId 院校id；levelId 层次id
     * @return: 专业集合
     * @author: LiPeng
     * @date: 2021/2/1
     */
    List<Major> findMajorForSelect(Integer collegeId, Integer levelId);

    /**
     * @Description: 所有有效批次
     * @return: 批次集合
     * @author: LiPeng
     * @date: 2021/2/1
     */
    List<Batch> findBatchForSelect();

    /**
     * 查询前台输入的全称或简称是否存在
     *
     * @param name
     * @param simplename
     * @return
     */
    Boolean isRepetitive(String name, String simplename);

    /**
     * @description: 查询所有学习形式
     * @return: 学习形式集合
     * @author: LiPeng
     * @date: 2021/3/4
     */
    List<Dic> findStudyTypeForSelect();
}