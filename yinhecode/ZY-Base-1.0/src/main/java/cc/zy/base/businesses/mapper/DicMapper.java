package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.Dic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 字典表 Mapper
 *
 * @author LiPeng
 * @date 2021-01-27 19:34:24
 */
public interface DicMapper extends BaseMapper<Dic> {

    Dic findDicByid(@Param("id") Integer id);
	/**
     * 查找字典详细信息
     *
     * @param type 字典类型，用于传递查询条件
     * @return List<Dic>
     */
    List<Dic> findDicByType(String type);

}
