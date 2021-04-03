package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.ReqResultExtension;

import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.ArrayList;
import java.util.List;

/**
 * Service接口
 *
 * @author zzz
 * @date 2021/01/30
 */
public interface IReqResultExtensionService extends IService<ReqResultExtension> {
    /**
     * 查询（所有）
     *
     * @param reqResultExtension reqResultExtension
     * @return List<ReqResultExtension>
     */
    List<ReqResultExtension> findReqResultExtensions(ReqResultExtension reqResultExtension);

    /*
     *按照ID查询
     * @Pama("id") id 用于传递参数
     * return ReqResultExtension
     */
    ReqResultExtension findById(Integer id);

    /**
     * @description: 查：按条件查询学生，用于分组
     * @param: request 分页对象，内含分页参数、排序参数；reqResultExtension query对象，传递查询条件
     * @return: 包含分页参数，以及查询到的数据集合
     * @author: LiPeng
     * @date: 2021/2/3
     */
    IPage<ReqResultExtension> findStudentInfoForGrouping(QueryRequest request, ReqResultExtension reqResultExtension);

    /**
     * @description: 给学生分组
     * @param: ids 学生id集合；groupId 学生组的id
     * @author: LiPeng
     * @date: 2021/2/3
     */
    void updateGroupId(ArrayList<Integer> ids, Integer groupId);

    /**
     * @description: 按条件查询学生，然后给查询到的所有学生分组
     * @param: reqResultExtension 查询对象，传递查询条件；groupId 学生组id
     * @author: LiPeng
     * @date: 2021/2/3
     */
    void updateGroupIdAll(ReqResultExtension reqResultExtension, Integer groupId);

    /**
     * @description: 查：按条件查询学生，根据用户Id查找该Id下管理的学生组学生信息
     * @param: request 分页对象，内含分页参数、排序参数；reqResultExtension query对象，传递查询条件;userId 用户Id
     * @return: 包含分页参数，以及查询到的数据集合
     * @author: hutengjiao
     * @date: 2021/3/2
     */
    IPage<ReqResultExtension> findStudentForGroupingByUId(QueryRequest request, ReqResultExtension reqResultExtension,
                                                          Integer userId);

    /**
     * @description: 查：按条件查询学生，根据用户Id查找该Id下管理的学生组学生信息
     * @param: request 分页对象，内含分页参数、排序参数；reqResultExtension query对象，传递查询条件;userId 用户Id
     * @author: hutengjiao
     * @date: 2021/3/2
     */
    ReqResultExtension findReqStudentByStuId(Integer id);
}