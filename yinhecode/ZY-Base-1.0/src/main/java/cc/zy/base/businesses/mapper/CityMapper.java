package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.City;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 市
 * @author 赵佳伟
 * @date 2021-01-26
 */
public interface CityMapper extends BaseMapper<City> {

    /**
     * 根据省份查询城市情况
     * @Param pid 省份id
     */
    List<City> findCityByPid(@Param("pid") String pid);

    /**
     * 根据id查询市信息
     * @param id
     * @return City实体对象
     */
    City findCityByid(@Param("id")Integer id);

    /**
     * 查询所有市
     * @return 所有市的集合
     */
    List<City> findAllCity();

}
