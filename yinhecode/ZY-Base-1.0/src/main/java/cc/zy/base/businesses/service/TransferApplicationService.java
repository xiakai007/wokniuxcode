package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.TransferApplication;
import cc.zy.base.businesses.entity.TransferApplicationVo;
import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * Service接口
 *
 * @author Jiangjinlin
 * @date 2021-01-18 10:51:13
 */
public interface TransferApplicationService extends IService<TransferApplication> {
    /**
     * 查询（分页）
     *
     * @param request             QueryRequest
     * @param transferApplication transferApplication
     * @return IPage<TransferApplication>
     */
    IPage<TransferApplicationVo> findTransferApplications(QueryRequest request, TransferApplication transferApplication);


    TransferApplicationVo findTransferDetailById(Integer id);

    /**
     * 查询（所有）
     *
     * @param transferApplication transferApplication
     * @return List<TransferApplication>
     */
    List<TransferApplication> findTransferApplications(TransferApplication transferApplication);

    /**
     * 新增
     *
     * @param transferApplication transferApplication
     */
    void createTransferApplication(TransferApplication transferApplication);

    /**
     * 修改
     *
     * @param transferApplication transferApplication
     */
    void updateTransferApplication(TransferApplication transferApplication);

}
