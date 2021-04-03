package cc.zy.base.businesses.mapper;


import cc.zy.base.businesses.entity.ConfirmAddress;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 现场确认地点 Mapper
 *
 * @author Jiangjinlin
 * @date 2021-01-25 18:18:46
 */
public interface ConfirmAddressMapper extends BaseMapper<ConfirmAddress> {


    /**
     * 查找用户详细信息
     *
     * @param page 分页对象
     * @param confirmAddress 确认地址对象，用于传递查询条件
     * @return Ipage
     */
    <T> IPage<ConfirmAddress> findAddressDetailPage(Page<T> page, @Param("confirmAddress") ConfirmAddress confirmAddress);

    long countAddressDetail(@Param("confirmAddress") ConfirmAddress confirmAddress);

    /**
     * 通过ID查找用户
     *
     * @param id id
     * @return 现场确认地
     */
    ConfirmAddress findById(Integer addressId);

    /**
     * 查找院校详细信息
     *
     * @param confirmAddress 地址对象，用于传递查询条件
     * @return List<ConfirmAddress>
     */
    List<ConfirmAddress> findAddressDetail(@Param("confirmAddress") ConfirmAddress confirmAddress);



}
