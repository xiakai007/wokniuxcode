package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.Major;
import cc.zy.base.businesses.entity.SubjectCategory;
import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * 专业表 Service接口
 *
 * @author guozhikun
 * @date 2021-01-26 19:41:01
 */
public interface IMajorService extends IService<Major> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param major major
     * @return IPage<Major>
     */
    IPage<Major> findMajors(QueryRequest request, Major major);

    /**
     * 全部专业列表
     * @return
     */
    List<Major> findMajor();

     /**
     * @Description 通过id查找专业简称
     * @param id   专业id
     * @return  专业对象
     * @author houweikang
     * @date   2021/2/3
     */
    Major findById(Integer id);
    /**
     * 查询（所有）
     *
     * @param major major
     * @return List<Major>
     */
    List<Major> findMajors(Major major);

    /**
     * 新增
     *
     * @param major major
     */
    void createMajor(Major major);

    /**
     * 修改
     *
     * @param major major
     */
    void updateMajor(Major major);

    /**
     * 删除
     *
     * @param major major
     */
    void deleteMajor(Major major);

	 /**
     * @Description: 根据批次id、院校id、层次id查询专业
     * @Param: batchId 批次id；collegeId 院校id；levelId 层次id
     * @return: 专业集合
     * @author: LiPeng
     * @date: 2021/2/1
     */
    List<Major> findMajorForSelect(Integer batchId, Integer collegeId, Integer levelId);
}

