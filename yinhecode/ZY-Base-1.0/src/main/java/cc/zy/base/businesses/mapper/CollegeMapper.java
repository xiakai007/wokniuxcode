package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.College;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author Jiangjinlin
 * @date 2021-01-18 10:51:13
 */
public interface CollegeMapper extends BaseMapper<College> {

    /**
     * 查找用户详细信息
     *
     * @param page    分页对象
     * @param college 用户对象，用于传递查询条件
     * @return Ipage
     */
    <T> IPage<College> findCollegeDetailPage(Page<T> page, @Param("college") College college);

    long countCollegeDetail(@Param("college") College college);

    /**
     * 通过ID查找用户
     *
     * @return 院校
     */
    College findById(Integer collegeId);

    /**
     * 查找院校详细信息
     *
     * @param college 院校对象，用于传递查询条件
     * @return List<College>
     */
    List<College> findCollegeDetail(@Param("college") College college);

    /**
     * 查询不带分页
     */
    List<College> findCollageListNotPage(@Param("college") College college);

    /**
     * @Description: 级联：查询所有院校
     * @return: 院校集合
     * @author: LiPeng
     * @date: 2021/2/1
     */
    List<College> selectCollegeForSelect();

    /**
     * @param name       院校全称
     * @param simplename 院校简称
     * @return
     */
    List<College> isRepetitive(@Param("name") String name, @Param("simplename") String simplename);


}
