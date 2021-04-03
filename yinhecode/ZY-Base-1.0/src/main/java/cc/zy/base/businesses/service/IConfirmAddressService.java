package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.ConfirmAddress;


import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 现场确认地点 Service接口
 *
 * @author Jiangjinlin
 * @date 2021-01-25 18:18:46
 */
public interface IConfirmAddressService extends IService<ConfirmAddress> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param confirmAddress confirmAddress
     * @return IPage<ConfirmAddress>
     */
    IPage<ConfirmAddress> findConfirmAddresss(QueryRequest request, ConfirmAddress confirmAddress);

    /**
     * 查询（所有）
     *
     * @param confirmAddress confirmAddress
     * @return List<ConfirmAddress>
     */
    List<ConfirmAddress> findConfirmAddresss(ConfirmAddress confirmAddress);

    /**
     * 新增
     *
     * @param confirmAddress confirmAddress
     */
    void createConfirmAddress(ConfirmAddress confirmAddress);

    /**
     * 修改
     *
     * @param confirmAddress confirmAddress
     */
    void updateConfirmAddress(ConfirmAddress confirmAddress);

    /**
     * 删除
     *
     * @param confirmAddress confirmAddress
     */
    void deleteConfirmAddress(ConfirmAddress confirmAddress);

    ConfirmAddress findById(Integer id);

    void deleteAddress(String[] addresIds);
}
