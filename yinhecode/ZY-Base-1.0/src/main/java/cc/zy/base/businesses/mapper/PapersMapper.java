package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.Papers;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper
 *
 * @author Jiangjinlin
 * @date 2021-01-25 10:40:25
 */
public interface PapersMapper extends BaseMapper<Papers> {
    /**
     * 查找用户详细信息
     *  @author huangjia
     * @date 2021/02/01
     * @param page   分页对象
     * @param papers 用户对象，用于传递查询条件
     * @return Ipage
     */
    <T> IPage<Papers> papersDetailPage(Page<T> page, @Param("papers") Papers papers);

    long countPapersDetail(@Param("papers") Papers papers);


    /**
     * 查找论文详细信息
     *  @author huangjia
     * @date 2021/02/01
     * @param papers 论文对象，用于传递查询条件
     * @return List<TPapers>
     */
    List<Papers> findPapersDetail(@Param("papers") Papers papers);

    /**修改论文状态
     *  @author huangjia
     * @date 2021/02/01
     * @param statusId
     * @param paperId
     */
    void refusePaper(@Param("statusId") Integer statusId,@Param("paperId")Integer paperId);


    /**
     *  @author huangjia
     * @date 2021/02/01
     * @param paperId
     */
    Papers findPapersById(Integer paperId);

    /**
     *  @author huangjia
     * @date 2021/02/01
     * 一键转为终稿的增加
     * @param papers
     */
    void addPapersFinal(Papers papers);
    /**
     *  @author huangjia
     * @date 2021/02/01
     * 论文初稿上传
     * @param papers
     */
    void uploadPapers(Papers papers);


}
