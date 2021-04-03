package cc.zy.base.businesses.service.impl;


import cc.zy.base.businesses.entity.City;
import cc.zy.base.businesses.mapper.CityMapper;
import cc.zy.base.businesses.service.ICityService;
import cc.zy.base.common.entity.QueryRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 *  Service实现
 *
 * @author Jiangjinlin
 * @date 2021-01-26 11:50:10
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements ICityService {

    private final CityMapper cityMapper;


    @Override
    public List<City> findCitys(String pid) {
		return cityMapper.findCityByPid(pid);
    }

    @Override
    public City findCityById(Integer id) {
        return cityMapper.findCityByid(id);
    }

    @Override
    public List<City> findAllCity() {
        return cityMapper.findAllCity();
    }


}
