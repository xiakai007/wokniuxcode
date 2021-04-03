package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.PaperFinal;

import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;
import java.util.List;

/**
 *  Service接口
 *
 * @author Jiangjinlin
 * @date 2021-01-26 14:57:22
 */
public interface IPaperFinalService extends IService<PaperFinal> {
    /**
     * 查询（分页）
     *  @author huangjia
     * @date 2021/02/01
     * @param request QueryRequest
     * @param paperfinal paperfinal
     * @return IPage<Paperfinal>
     */
    IPage<PaperFinal> findPaperfinalPage(QueryRequest request, PaperFinal paperfinal);

    /**
     * 查询（所有）
     *  @author huangjia
     * @date 2021/02/01
     * @param paperfinal paperfinal
     * @return List<Paperfinal>
     */
    List<PaperFinal> findPaperfinals(PaperFinal paperfinal);

    /**
     * 新增
     *
     * @param paperfinal paperfinal
     */
    void createPaperfinal(PaperFinal paperfinal);

    /**
     * 修改
     *
     * @param paperfinal paperfinal
     */
    void updatePaperfinal(PaperFinal paperfinal);

    /**
     * 删除
     *
     * @param paperfinal paperfinal
     */
    void deletePaperfinal(PaperFinal paperfinal);

    /**
     * 为终稿查出对象
     *  @author huangjia
     * @date 2021/02/01
     * @param paperId
     */
    PaperFinal findPaperFinalById(Integer paperId);

    /**修改论文状态
     *  @author huangjia
     * @date 2021/02/01
     * @param statusId
     * @param paperId
     */
    void updatePaperFinalStatus(Integer statusId, Date checkTime,Integer paperId);
    /**
     *  @author huangjia
     * @date 2021/02/01
     * 论文终稿上传
     * @param paperFinal
     */
    void uploadPaperFinals(PaperFinal paperFinal);
}
