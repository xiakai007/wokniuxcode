package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.CorrespondenceCollege;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 函授站表 Mapper
 *
 * @author zhaojw
 * @date 2021-01-25 19:37:31
 */
public interface CorrespondenceCollegeMapper extends BaseMapper<CorrespondenceCollege> {

    /**
     * 根据条件查询函授站点信息
     * @Param address 地址，由省市拼接而成
     * @Param name 院校名称
     * @author zhaojw
     */
    <T> IPage<CorrespondenceCollege> findCorrespondenceCollege(Page<T> page, @Param("province") String province,@Param("city") String  city,@Param("name") String name);

    /**
     * 根据条件查询函授站点信息的总条目数
     * @Param address 地址，由省市拼接而成
     * @Param name 院校名称
     * @author zhaojw
     */
    Long countCorrespondenceCollege(@Param("province") String province,@Param("city") String  city,@Param("name") String name);

    /**
     * 增加函授站信息
     */
    int insertCorrespondenceCollege(CorrespondenceCollege correspondenceCollege);

    /**
     * 根据id查询函授站详细信息
     */
    CorrespondenceCollege findCorrespondenceCollegeById(@Param("id") Integer id);

    /**
     * 修改函授站信息
     */
    int updateCorrespondenceCollege(CorrespondenceCollege correspondenceCollege);

    /**
     * 判断输入的函授站名称是否重复
     */
    List<Integer> isRepetitive(@Param("fullName") String fullName, @Param("simpleName") String simpleName);
}
