package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.Recycle;
import cc.zy.base.businesses.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * Mapper
 *
 * @author LiPeng
 * @date 2021-01-27 19:13:18
 */
public interface RecycleMapper extends BaseMapper<Recycle> {
    <T> Page<Recycle> findRecycleDetailPage(Page<T> page, @Param("recycle") Recycle recycle);

    long countRecycleDetail(@Param("recycle") Recycle recycle);

    Recycle findRecycleById(@Param("id") Integer id);
}
