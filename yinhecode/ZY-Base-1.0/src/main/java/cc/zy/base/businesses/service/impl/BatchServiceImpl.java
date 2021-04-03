package cc.zy.base.businesses.service.impl;

import cc.zy.base.businesses.entity.Batch;
import cc.zy.base.businesses.mapper.BatchMapper;
import cc.zy.base.businesses.service.IBatchService;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.SortUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BatchServiceImpl extends ServiceImpl<BatchMapper, Batch> implements IBatchService {
    /***
     * 完成批次下拉菜单
     */
    @Resource
    private BatchMapper batchMapper;

     public List<Batch> findBatchs(){
         List<Batch> batches = batchMapper.selectList(null);
         return  batches;
     }

    @Override
    public Batch findBatchsById(Integer id) {
        Batch batch = batchMapper.findBatchsById(id);
        return batch;
    }
	 @Override
     /**
      * *  @author huangjia
      * @date 2021/02/01
      * 批次查询分页
      */
    public IPage<Batch> findBatchs(QueryRequest request, Batch batch) {

         Page<Batch> page = new Page<>(request.getPageNum(), request.getPageSize());
         page.setSearchCount(false);
         page.setTotal(baseMapper.countBatchDetail(batch));
         SortUtil.handlePageSort(request, page, "id", FebsConstant.ORDER_ASC, false);
         return this.baseMapper.findBatchDetailPage(page, batch);
    }

    @Override
    public List<Batch> findBatchs(Batch batch) {
	    LambdaQueryWrapper<Batch> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createBatch(Batch batch) {
        this.save(batch);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateBatch(Batch batch) {
        this.saveOrUpdate(batch);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(Batch batch) {
        LambdaQueryWrapper<Batch> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}


	//批次删除--ln
    @Override
    public void deletebatchs(String[] batchIds) {
        List<String> list = Arrays.asList(batchIds);
        this.removeByIds(list);
    }
}
