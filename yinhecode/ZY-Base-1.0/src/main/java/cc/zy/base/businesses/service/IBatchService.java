package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.Batch;
import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IBatchService extends IService<Batch> {
    public List<Batch> findBatchs();

    public Batch findBatchsById(Integer id);
	/**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param batch batch
     * @return IPage<Batch>
     */
    IPage<Batch> findBatchs(QueryRequest request, Batch batch);

    /**
     * 查询（所有）
     *  @author huangjia
     * @date 2021/02/01
     * @param batch batch
     * @return List<Batch>
     */
    List<Batch> findBatchs(Batch batch);

    /**
     * 新增
     *
     * @param batch batch
     */
    void createBatch(Batch batch);

    /**
     * 修改
     *
     * @param batch batch
     */
    void updateBatch(Batch batch);

    /**
     * 删除
     *
     * @param batch batch
     */
    void deleteBatch(Batch batch);

    /**
     * 删除ln
     *
     * @param String[] batchIds
     */
    void deletebatchs(String[] batchIds);
}
