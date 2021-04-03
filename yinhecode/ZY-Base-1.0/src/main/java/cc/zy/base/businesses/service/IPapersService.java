package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.Papers;

import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  Service接口
 *
 * @author Jiangjinlin
 * @date 2021-01-25 10:40:25
 */
public interface IPapersService extends IService<Papers> {
    /**
     * 查询（分页）
     *  @author huangjia
     * @date 2021/02/01
     * @param request QueryRequest
     * @param papers papers
     * @return IPage<Papers>
     */
    IPage<Papers> findPapersPage(QueryRequest request, Papers papers);

    /**
     * 查询（所有）
     *  @author huangjia
     * @date 2021/02/01
     * @param papers
     * @return List<Papers>
     */
    List<Papers> findPapers(Papers papers);

    /**
     * 新增
     *  @author huangjia
     * @date 2021/02/01
     * @param papers
     */
    void createPapers(Papers papers);

    /**
     * 修改
     *  @author huangjia
     * @date 2021/02/01
     * @param papers
     */
    void updatePapers(Papers papers);

    /**
     * 删除
     *  @author huangjia
     * @date 2021/02/01
     * @param papers
     */
    void deletePapers(Papers papers);

    /**
     * 论文驳回
     *  @author huangjia
     * @date 2021/02/01
     * @param paperId
     */
    void refusePaper(Integer statusId,Integer paperId);



    /**
     * 一键转为终稿查出对象
     *  @author huangjia
     * @date 2021/02/01
     * @param paperId
     */
    Papers findPapersById(Integer paperId);


    /**
     * 一键转为终稿的增加
     *  @author huangjia
     * @date 2021/02/01
     * @param papers
     */
    void addPapersFinal(Papers papers);
    /**
     * 一论文初稿的上传
     *  @author huangjia
     * @date 2021/02/01
     * @param papers
     */
    void uploadPapers(Papers papers);


}
