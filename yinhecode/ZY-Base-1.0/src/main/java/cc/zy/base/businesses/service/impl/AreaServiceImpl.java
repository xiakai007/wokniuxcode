package cc.zy.base.businesses.service.impl;


import cc.zy.base.businesses.entity.Area;
import cc.zy.base.businesses.entity.City;
import cc.zy.base.businesses.mapper.AreaMapper;
import cc.zy.base.businesses.service.IAreaService;
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
 * @date 2021-01-26 16:29:51
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AreaServiceImpl extends ServiceImpl<AreaMapper, Area> implements IAreaService {

    private final AreaMapper areaMapper;


    @Override
    public List<Area> findAreas(String cid) {
        return areaMapper.findAreaByCid(cid);
    }

    @Override
    public Area findAreaById(Integer id) {
        return areaMapper.findAreaById(id);
    }
	

    @Override
    public List<Area> findAllArea() {
        return areaMapper.findAllArea();
    }
}
