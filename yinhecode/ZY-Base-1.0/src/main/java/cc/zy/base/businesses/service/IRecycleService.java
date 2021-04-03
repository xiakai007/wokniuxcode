package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.Recycle;
import cc.zy.base.businesses.entity.StuLabel;
import cc.zy.base.businesses.entity.Student;
import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * Service接口
 *
 * @author JiangWeiguang
 * @date 2021\1\22 0022 16:50
 */
public interface IRecycleService extends IService<Recycle> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param recycle recycle
     * @return IPage<Student>
     */
    IPage<Recycle> findRecycle(QueryRequest request, Recycle recycle);

    /**
     * 查询（分页）
     *
     */
    Recycle findById(Integer id);

}
