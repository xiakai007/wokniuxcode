package cc.zy.base.system.service;

import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.TreeNode;
import cc.zy.base.system.entity.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

/**
 * @author MrBird
 */
public interface IUserService extends IService<User> {
	
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
     * @param request request
     * @param user    用户对象，用于传递查询条件
     * @return IPage
     */
    IPage<User> findUserDetailList(User user, QueryRequest request);

    /**
     * 通用组件选择用户信息
     *
     * @param request request
     * @param user    用户对象，用于传递查询条件
     * @return IPage
     */
    IPage<User> selectUserDetailList(User user, QueryRequest request);

    /**
     * 通用组件选择用户信息
     *
     */
    List<User> selectUserDetail(User user);

    /**
     * 通过用户名查找用户详细信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    User findUserDetailList(String username);

    /**
     * 更新用户登录时间
     *
     * @param username 用户名
     */
    @Async(FebsConstant.ASYNC_POOL)
    void updateLoginTime(String username);

    /**
     * 新增用户
     *
     * @param user user
     */
    void createUser(User user);

    /**
     * 删除用户
     *
     * @param userIds 用户 id数组
     */
    void deleteUsers(String[] userIds);

    /**
     * 修改用户
     *
     * @param user user
     */
    void updateUser(User user);

    /**
     * 重置密码
     *
     * @param usernames 用户名数组
     */
    void resetPassword(String[] usernames);

    /**
     * 注册用户
     *
     * @param username 用户名
     * @param password 密码
     */
    void register(String username, String password);

    /**
     * 修改密码
     *
     * @param username 用户名
     * @param password 新密码
     */
    void updatePassword(String username, String password);

    /**
     * 更新用户头像
     *
     * @param username 用户名
     * @param avatar   用户头像
     */
    void updateAvatar(String username, String avatar);

    /**
     * 修改用户系统配置（个性化配置）
     *
     * @param username 用户名称
     * @param theme    主题风格
     * @param isTab    是否开启 TAB
     */
    void updateTheme(String username, String theme, String isTab);

    /**
     * 更新个人信息
     *
     * @param user 个人信息
     */
    void updateProfile(User user);

    /**
     * 获取用户角色和权限集
     *
     * @param user 用户
     */
    void doGetUserAuthorizationInfo(User user);

    /**
     * 构建用户部门树
     *
     * @return
     * @author liuheng
     */
    List<TreeNode> createUserDeptTree();
}
