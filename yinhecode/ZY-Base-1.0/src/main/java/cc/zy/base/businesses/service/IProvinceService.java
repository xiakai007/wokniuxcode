package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.Province;


import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  省Service接口
 *
 * @author zhaojw
 * @date 2021-01-26 11:49:58
 */
public interface IProvinceService extends IService<Province> {


    /**
     * 查询（所有）
     * @return List<Province>
     */
    List<Province> findProvinces(Integer pid);

    /**
     * 根据省名字查询省id
     * @param name
     * @return
     */
    Integer findProvinceId(String name);

}
