package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.TransferApplication;
import cc.zy.base.businesses.entity.TransferApplicationVo;
import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 异动Service接口
 *
 * @author liuheng
 * @date 2021/01/25
 */
public interface ITransferApplicationService extends IService<TransferApplication> {
    /**
     * 查询（分页）
     *
     * @param request             QueryRequest
     * @param transferApplication transferApplication
     * @return IPage<TransferApplication>
     * @author liuheng
     */
    IPage<TransferApplicationVo> findTransferApplications(QueryRequest request, TransferApplication transferApplication);

    /**
     * 按id查询异动详情
     *
     * @param id
     * @return
     * @author liuheng
     */
    TransferApplicationVo findTransferDetailById(Integer id);

    /**
     * 查询（所有）
     *
     * @param transferApplication transferApplication
     * @return List<TransferApplication>
     * @author liuheng
     */
    List<TransferApplication> findTransferApplications(TransferApplication transferApplication);

    /**
     * 新增
     *
     * @param transferApplicationVo transferApplicationVo
     * @author liuheng
     */
    void createTransferApplication(TransferApplicationVo transferApplicationVo);

    /**
     * 修改 根据审批意见、审批时间、审批状态更新异动信息，同时修改对应学生异动状态信息
     *
     * @param transferApplication transferApplication
     * @author liuheng
     */
    void updateTransferApplication(TransferApplication transferApplication);

}
