package cc.zy.base.others.mapper;

import cc.zy.base.common.annotation.DataPermission;
import cc.zy.base.others.entity.DataPermissionTest;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author MrBird
 */
@DataPermission(methods = {"selectPage"})
public interface DataPermissionTestMapper extends BaseMapper<DataPermissionTest> {

}
