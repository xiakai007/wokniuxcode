package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.PaperFinal;
import cc.zy.base.businesses.entity.Papers;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 *  Mapper
 *  @author huangjia
 * @date 2021/02/01
 * @author Jiangjinlin
 * @date 2021-01-26 14:57:22
 */
public interface PaperFinalMapper extends BaseMapper<PaperFinal> {
    /**
     * 查找用户详细信息
     *  @author huangjia
     * @date 2021/02/01
     * @param page    分页对象
     * @param paperFinal 用户对象，用于传递查询条件
     * @return Ipage
     */
    <T> IPage<PaperFinal> paperFinalDetailPage(Page<T> page, @Param("paperFinal") PaperFinal paperFinal);

    long countPaperFinalDetail(@Param("paperFinal") PaperFinal paperFinal);


    /**
     * 查找论文详细信息
     *  @author huangjia
     * @date 2021/02/01
     * @param paperFinal 论文对象，用于传递查询条件
     * @return List<TPapers>
     */
    List<PaperFinal> findPaperFinalDetail(@Param("paperFinal") PaperFinal paperFinal);


    /**
     *  @author huangjia
     * @date 2021/02/01
     * 为终稿查出对象
     * @param paperId
     */
    PaperFinal findPaperFinalById(Integer paperId);

    /**修改论文状态
     *  @author huangjia
     * @date 2021/02/01
     * @param statusId
     * @param paperId
     */
    void updatePaperFinalStatus(@Param("statusId") Integer statusId, @Param("checkTime") Date checkTime, @Param("paperId")Integer paperId);
    /**
     *  @author huangjia
     * @date 2021/02/01
     * 论文终稿上传
     * @param paperFinal
     */
    void uploadPaperFinals(PaperFinal paperFinal);
}
