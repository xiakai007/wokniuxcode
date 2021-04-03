package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.ReqResultExtension;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/**
 * Mapper
 *
 * @author zzz
 * @date 2021-01-30 15:13:49
 */
public interface ReqResultExtensionMapper extends BaseMapper<ReqResultExtension> {

    /*
     *按照ID查询
     * @Pama("id") id 用于传递参数
     * return ReqResultExtension
     */
    ReqResultExtension findById(Integer id);

    /**
     * @description: 查：按条件查询学生，用于分组
     * @param: page 分页对象，内含分页、排序参数；reqResultExtension query对象，传递查询条件
     * @return: 包含分页参数，以及查询到的数据集合
     * @author: LiPeng
     * @date: 2021/2/3
     */
    <T> IPage<ReqResultExtension> findStudentInfoForGrouping(Page<T> page, @Param("reqResultExtension") ReqResultExtension reqResultExtension);

    /**
     * @description: 查：按条件查询到的数据总数，用于分组
     * @param: reqResultExtension query对象，传递查询条件
     * @return: 查询到的数据总数
     * @author: LiPeng
     * @date: 2021/2/3
     */
    long countStudentInfoForGrouping(@Param("reqResultExtension") ReqResultExtension reqResultExtension);

    /**
     * @description: 改：给学生分组
     * @param: ids 学生id集合；groupId 学生组id
     * @return: 成功更新条数
     * @author: LiPeng
     * @date: 2021/2/3
     */
    Integer updateGroupId(@Param("ids") ArrayList<Integer> ids, @Param("groupId") Integer groupId);

    /**
     * @description: 查：按条件查询公海学生表中的学生id
     * @param: reqResultExtension query对象，传递查询条件
     * @return: 学生id集合
     * @author: LiPeng
     * @date: 2021/2/3
     */
    ArrayList<Integer> findIdsByParams(@Param("reqResultExtension") ReqResultExtension reqResultExtension);

    /**
     * @description: 查：按条件查询学生，根据用户id显示该id下管理的学生组的学生
     * @param: page 分页对象，内含分页、排序参数；reqResultExtension query对象，传递查询条件;userId 用户id
     * @return: 包含分页参数，以及查询到的数据集合
     * @author: hutengjiao
     * @date: 2021/3/2
     */
    <T> IPage<ReqResultExtension> findStudentInfoForGroupingByUId(Page<T> page, @Param("reqResultExtension")
            ReqResultExtension reqResultExtension,@Param("userId") Integer userId);

    /**
     * @description: 查：按条件查询到的数据总数，用于分组
     * @param: reqResultExtension query对象，传递查询条件
     * @return: 查询到的数据总数
     * @author: hutengjiao
     * @date: 2021/3/3
     */
    long countStudentInfoForGroupingByUId(@Param("reqResultExtension") ReqResultExtension reqResultExtension,
                                          @Param("userId") Integer userId);

    /**
     * @description: 查：按条件查询到的数据总数，用于分组
     * @param: reqResultExtension query对象，传递查询条件
     * @return: 查询到的数据总数
     * @author: hutengjiao
     * @date: 2021/3/3
     */
    ReqResultExtension findStudentInfoForPoolByStuId(@Param("id") Integer id);

    /**
     * @description: 查：审核信息，根据stuid更改公海学生提交的审核信息
     * @param: reqResultExtension query对象，传递查询条件
     * @return: 查询到的数据总数
     * @author: hutengjiao
     * @date: 2021/3/3
     */
    int updateByStuId(@Param("id") Integer id,ReqResultExtension reqResultExtension);

}