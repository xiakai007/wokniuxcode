package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.Area;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 区
 *
 * @author 赵佳伟
 * @date 2021-01-26 16:29:51
 */
public interface AreaMapper extends BaseMapper<Area> {

    /**
     * 根据城市id查询地区
     * @param cid 市id
     * @return
     */
    List<Area> findAreaByCid(@Param("cid") String cid);

    /**
     * 根据id查地区
     * @param id
     * @return
     */
    Area findAreaById(@Param("id") Integer id);

    /**
     * 查询所有的区信息
     * @return 所有的区信息集合
     */
	List<Area> findAllArea();

}
