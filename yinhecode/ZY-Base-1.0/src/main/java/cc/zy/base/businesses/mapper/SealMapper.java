package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.College;
import cc.zy.base.businesses.entity.Seal;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;


/**
 * 印章mapper层
 *
 * @author Jiangjinlin
 * @date 2021-01-27 09:56:39
 */
public interface SealMapper extends BaseMapper<Seal> {

    /**
     * 查询所有学校和印章的信息
     *
     * @param page    分页
     * @param college 控制层传递学院查询条件对象
     * @return <T> IPage<College>
     * @author guozhaodi
     * @date 2021-01-27 09:56:39
     */
    <T> IPage<College> findSealDetailPage(Page<T> page, @Param("college") College college);

    /**
     * 查询当前共有多少印章信息
     *
     * @param college
     * @return long
     * @author guozhaodi
     * @date 2021-01-27 09:56:39
     */
    long countSealDetail(@Param("college") College college);

    /**
     * 根据院校id查询当前院校和印章信息（用于修改前页面信息展示）
     *
     * @param id
     * @return
     * @author guozhaodi
     * @date 2021-01-27 09:56:39
     */
    College findById(Integer id);

    /**
     * 根据院校id更改院校图片信息
     *
     * @param collegeId 院校id
     * 无返回
     * @author guozhaodi
     * @date 2021-01-27 09:56:39
     */
    void updateSealImgurlById(Integer collegeId);
}
