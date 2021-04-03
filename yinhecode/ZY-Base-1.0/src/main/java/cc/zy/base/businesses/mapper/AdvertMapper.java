package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.Advert;
import cc.zy.base.businesses.entity.AdvertLoop;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  Mapper
 *
 * @author lijian
 * @date 2021/01/25
 */
public interface AdvertMapper extends BaseMapper<Advert> {

    /**
     * 查找用户详细信息
     *
     * @param page 分页对象
     * @param advert 用户对象，用于传递查询条件
     * @return Ipage
     */
    <T> IPage<Advert> findAdvertDetailPage(Page<T> page, @Param("advert") Advert advert);

    long countAdvertDetail(@Param("advert") Advert advert);

    /**
     * 查找所有广告信息
     *
     * @param advert 广告对象，用于传递查询条件
     * @return List<College>
     */
    List<Advert> findAdvertList(@Param("advert") Advert advert);

    /**
     * 通过ID查找广告
     *
     * @param id id
     * @return 广告
     */
    Advert findById(Integer advertId);


    /*轮播广告部分*/
    /**
     * 查找所有轮播广告信息
     *
     *
     * @return List<Advert>
     */
    <T> IPage<AdvertLoop> findAdvertLoopList(Page<T> page);

    long countAdvertLoop();


    /**
     * 查找广告轮播表的空位置
     *
     *
     * @return 广告轮播的空位置的id
     */
    Integer getAdvertLoopId();
    /**
     * 通过id删除轮播列表中的广告
     * @param id id
     */
    void updateAdvertLoopById(Integer advertId);

    void addAdvertToAdvertLoop(@Param("advertId") Integer advertId,@Param("loopId")Integer loopId);

    /**
     * 每删除一次广告，就将之后的广告位置上移一位
     * @param advertId
     * @param loopId
     */
    void delAndChangeAdvertToAdvertLoop(Integer loopId);
    Integer[] getAdvertLoopIntegerArray(Integer advertId);
    Integer getDelAdvertLoopId(Integer advertId);

    /**
     * 将想去位置的广告移到该广告的位置，参数为该广告（advertId）想去的位置（id）
     *
     * @param id
     * @param advertId
     */
    void moveSiteForOrder(@Param("loopId")Integer loopId,@Param("advertId") Integer advertId);
}
