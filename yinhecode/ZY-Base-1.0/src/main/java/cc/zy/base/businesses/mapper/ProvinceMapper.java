package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.Province;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  Mapper
 *
 * @author Jiangjinlin
 * @date 2021-01-26 11:49:58
 */
public interface ProvinceMapper extends BaseMapper<Province> {
    /**
     * 根据id查省份
     * @Param id可为空
     */
    List<Province> findAllProvince(@Param("id") Integer id);

    /**
     * 根据id查省份
     */
    Province findProvince(@Param("id") Integer id);

    /**
     * 根据省份查id
     */
    Integer findProvinceId(@Param("name") String name);



}
