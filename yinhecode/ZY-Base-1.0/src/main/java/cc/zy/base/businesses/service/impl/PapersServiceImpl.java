package cc.zy.base.businesses.service.impl;

import cc.zy.base.businesses.entity.College;
import cc.zy.base.businesses.entity.Papers;
import cc.zy.base.businesses.mapper.PapersMapper;
import cc.zy.base.businesses.service.IPapersService;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.SortUtil;
import cc.zy.base.system.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 *  Service实现
 *
 * @author Jiangjinlin
 * @date 2021-01-25 10:40:25
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PapersServiceImpl extends ServiceImpl<PapersMapper, Papers> implements IPapersService {
    @Resource
    private final PapersMapper papersMapper;

    @Override
    /**
     *  @author huangjia
     * @date 2021/02/01
     * 论文初稿分页
     */
    public IPage<Papers> findPapersPage(QueryRequest request, Papers papers) {
        Page<Papers> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(papersMapper.countPapersDetail(papers));
        SortUtil.handlePageSort(request, page, "id", FebsConstant.ORDER_ASC, false);
        return this.papersMapper.papersDetailPage(page,papers);
    }

    @Override
    /**
     *  @author huangjia
     * @date 2021/02/01
     * 论文列表
     */
    public List<Papers> findPapers(Papers papers) {
		// TODO 设置查询条件
		return this.papersMapper.findPapersDetail(papers);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createPapers(Papers papers) {
        this.save(papers);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePapers(Papers papers) {
        this.saveOrUpdate(papers);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deletePapers(Papers papers) {
        LambdaQueryWrapper<Papers> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}

    @Override
    @Transactional(rollbackFor = Exception.class)
    /**
     *  @author huangjia
     * @date 2021/02/01
     * 驳回论文初稿
     */
    public void refusePaper(Integer statusId, Integer paperId) {
        papersMapper.refusePaper(statusId,paperId);
    }



    @Override
    /**
     *  @author huangjia
     * @date 2021/02/01
     * 通过id查找对应的paper对象
     */
    public Papers findPapersById(Integer paperId) {
        return papersMapper.findPapersById(paperId);
    }



    @Override
    @Transactional(rollbackFor = Exception.class)
    /**
     * *  @author huangjia
    * @date 2021/02/01
     * 一键转为终稿
     */
    public void addPapersFinal(Papers papers) {
        papersMapper.addPapersFinal(papers);
    }

    /**
     * *  @author huangjia
     * @date 2021/02/01
     * 论文初稿上传
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void uploadPapers(Papers papers) {
        papersMapper.uploadPapers(papers);
    }
}
