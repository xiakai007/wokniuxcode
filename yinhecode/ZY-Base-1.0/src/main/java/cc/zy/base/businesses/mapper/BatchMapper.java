package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.Batch;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BatchMapper extends BaseMapper<Batch> {

    public List<Batch> findBatchs();

   public Batch findBatchsById(@Param("id") Integer id);

   /**
     * @Description: 查：所有有效批次
     * @return: 批次集合
     * @author: LiPeng
     * @date: 2021/2/1
     */
	List<Batch> selectBatchForSelect();

    /**
     *  @author huangjia
     * @date 2021/02/01
     * 批次查询分页
     * @param page
     * @param batch
     * @param <T>
     * @return     */
    <T> IPage<Batch> findBatchDetailPage(Page<T> page, @Param("batch") Batch batch);

    /**
     *  @author huangjia
    * @date 2021/02/01
     * 得到批次的分页总数
     * @param batch
     * @return
     */
    long countBatchDetail(@Param("batch") Batch batch);


}
