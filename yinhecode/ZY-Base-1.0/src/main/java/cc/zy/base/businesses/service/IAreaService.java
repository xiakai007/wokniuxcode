package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.Area;


import cc.zy.base.businesses.entity.City;
import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  区
 *
 * @author 赵佳伟
 * @date 2021-01-26 16:29:51
 */
public interface IAreaService extends IService<Area> {

    /**
     * 查询（根据市id查）
     * @param cid 市id
     * @return List<Area>
     */
    List<Area> findAreas(String cid);

    /**
     * 通过id查询地区
     * @param id
     * @return
     */
    Area findAreaById(Integer id);

    /**
     * 查询所有地区
     * @return
     */
    List<Area> findAllArea();



}
