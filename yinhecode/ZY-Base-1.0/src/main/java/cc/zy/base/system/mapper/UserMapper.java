package cc.zy.base.system.mapper;

import cc.zy.base.system.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author MrBird
 */
public interface UserMapper extends BaseMapper<User> {
	
	/**
     * 查找请求用户列表
     *
     * @return 用户
     */
    List<User> findReqUserList();

    /**
     * 通过用户名查找用户
     *
     * @param username 用户名
     * @return 用户
     */
    User findByName(String username);

    /**
     * 查找用户详细信息
     *
     * @param page 分页对象
     * @param user 用户对象，用于传递查询条件
     * @return Ipage
     */
    <T> IPage<User> findUserDetailPage(Page<T> page, @Param("user") User user);

    long countUserDetail(@Param("user") User user);

    /**
     * 查找用户详细信息
     *
     * @param user 用户对象，用于传递查询条件
     * @return List<User>
     */
    List<User> findUserDetail(@Param("user") User user);

    /**
     * 通用组件选择用户信息
     * @param user 分页对象，用于传递查询条件
     * @return Ipage
     */
    <T> IPage<User> selectUserDetailPage(Page<T> page, @Param("user") User user);

    /**
     * 通用组件选择用户信息
     * @param user 用于传递查询条件
     * @return List<User>
     */
    List<User> selectUserDetail(@Param("user") User user);
}
