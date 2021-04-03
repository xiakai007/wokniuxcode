package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.ResolveException;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 *  Mapper
 *
 * @author Jiangjinlin
 * @date 2021-01-25 16:03:48
 */
public interface ResolveExceptionMapper extends BaseMapper<ResolveException> {
    /*
     *  按条件查询
     *  @param startTime  @param endTime  @param cboTriggerType   @param reqUserId 用于传递查询条件
     *  @return List<ResolveException>
     */
    <T>IPage<ResolveException> findByResolveException(Page page, @Param("dtpStartDate") Timestamp dtpStartDate, @Param("dtpEndDate") Timestamp dtpEndDate, @Param("cboTriggerType") Integer cboTriggerType, @Param("reqUserId") Integer reqUserId);
    long findByResolveExceptionCount(@Param("dtpStartDate") Timestamp dtpStartDate, @Param("dtpEndDate") Timestamp dtpEndDate, @Param("cboTriggerType") Integer cboTriggerType, @Param("reqUserId") Integer reqUserId);
    /*
    *  全部查询
    *
    *  @return List<ResolveException>
    */
    <T>IPage<ResolveException> findByResolveExceptions(Page<T> page);

    long findByResolveExceptionDicsCount();

    ResolveException findById(Integer id);
}
