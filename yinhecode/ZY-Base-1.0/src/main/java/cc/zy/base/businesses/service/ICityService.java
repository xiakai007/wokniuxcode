package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.City;


import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 市
 * @author 赵佳伟
 * @date 2021-01-26 11:50:10
 */
public interface ICityService extends IService<City> {

    /**
     * 查询（根据省份id）
     * @return List<City>
     */
    List<City> findCitys(String pid);

    /**
     * 根据id查城市
     */
    City findCityById(Integer id);

    /**
     * 查询所有市
     * @return
     */
    List<City> findAllCity();


}
