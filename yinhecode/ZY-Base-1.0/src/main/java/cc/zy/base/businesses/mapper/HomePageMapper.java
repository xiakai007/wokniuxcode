package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.College;
import cc.zy.base.businesses.entity.HomePage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 首页栏位表 Mapper
 *
 * @author Jiangjinlin
 * @date 2021-01-27 10:29:21
 */
public interface HomePageMapper extends BaseMapper<HomePage> {


    /**
     * 通过ID查找用户
     *
     * @param id id
     * @return 首页对象
     */
    HomePage findById(Integer id);

    /**
     * 查找院校详细信息
     *
     * @param homePage 院校对象，用于传递查询条件
     * @return List<HomePage>
     */
    List<HomePage> findHomePageDetail(@Param("college") HomePage homePage);

    List<HomePage> findAllHomePage();


}
