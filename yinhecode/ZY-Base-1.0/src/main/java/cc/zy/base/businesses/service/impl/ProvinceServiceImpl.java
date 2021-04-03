package cc.zy.base.businesses.service.impl;


import cc.zy.base.businesses.entity.Province;
import cc.zy.base.businesses.mapper.ProvinceMapper;
import cc.zy.base.businesses.service.IProvinceService;
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
 * @date 2021-01-26 11:49:58
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProvinceServiceImpl extends ServiceImpl<ProvinceMapper, Province> implements IProvinceService {

    private final ProvinceMapper provinceMapper;


    @Override
    public List<Province> findProvinces(Integer pid) {
		return provinceMapper.findAllProvince(pid);
    }

    @Override
    public Integer findProvinceId(String name) {
        return provinceMapper.findProvinceId(name);
    }


}
