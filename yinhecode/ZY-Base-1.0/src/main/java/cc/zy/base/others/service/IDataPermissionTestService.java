package cc.zy.base.others.service;

import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.others.entity.DataPermissionTest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * @author MrBird
 */
public interface IDataPermissionTestService extends IService<DataPermissionTest> {
    /**
     * 查询（分页）
     *
     * @param request            QueryRequest
     * @param dataPermissionTest dataPermissionTest
     * @return IPage<DataPermissionTest>
     */
    IPage<DataPermissionTest> findDataPermissionTests(QueryRequest request, DataPermissionTest dataPermissionTest);
}
