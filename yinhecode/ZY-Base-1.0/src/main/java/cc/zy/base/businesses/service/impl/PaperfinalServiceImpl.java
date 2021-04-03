package cc.zy.base.businesses.service.impl;

import cc.zy.base.businesses.entity.PaperFinal;
import cc.zy.base.businesses.entity.Papers;
import cc.zy.base.businesses.mapper.PaperFinalMapper;
import cc.zy.base.businesses.service.IPaperFinalService;
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
import java.util.Date;
import java.util.List;

/**
 * Service实现
 *
 * @author Jiangjinlin
 * @date 2021-01-26 14:57:22
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PaperfinalServiceImpl extends ServiceImpl<PaperFinalMapper, PaperFinal> implements IPaperFinalService {
    @Resource
    private final PaperFinalMapper paperfinalMapper;

    @Override
    /**
     *  @author huangjia
     * @date 2021/02/01
     * 论文终稿分页
     */
    public IPage<PaperFinal> findPaperfinalPage(QueryRequest request, PaperFinal paperFinal) {
        Page<Papers> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(paperfinalMapper.countPaperFinalDetail(paperFinal));
        SortUtil.handlePageSort(request, page, "id", FebsConstant.ORDER_ASC, false);
        return this.paperfinalMapper.paperFinalDetailPage(page, paperFinal);
    }

    @Override
    public List<PaperFinal> findPaperfinals(PaperFinal paperFinal) {
        // TODO 设置查询条件
        return this.paperfinalMapper.findPaperFinalDetail(paperFinal);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createPaperfinal(PaperFinal paperfinal) {
        this.save(paperfinal);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePaperfinal(PaperFinal paperfinal) {
        this.saveOrUpdate(paperfinal);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deletePaperfinal(PaperFinal paperfinal) {
        LambdaQueryWrapper<PaperFinal> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }

    @Override
    /**
     *  @author huangjia
     * @date 2021/02/01
     * 查找终稿的对象
     */
    public PaperFinal findPaperFinalById(Integer paperId) {
        return paperfinalMapper.findPaperFinalById(paperId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    /**
     * 终稿通过
     */
    public void updatePaperFinalStatus(Integer statusId, Date checkTime, Integer paperId) {
        paperfinalMapper.updatePaperFinalStatus(statusId, checkTime, paperId);
    }

    /**
     * *  @author huangjia
     * @date 2021/02/01
     * 论文终稿上传
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void uploadPaperFinals(PaperFinal paperFinal) {
        paperfinalMapper.uploadPaperFinals(paperFinal);
    }
}
