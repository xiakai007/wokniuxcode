package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.HomePage;


import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 首页栏位表 Service接口
 *
 * @author Jiangjinlin
 * @date 2021-01-27 10:29:21
 */
public interface IHomePageService extends IService<HomePage> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param homePage homePage
     * @return IPage<HomePage>
     */
    IPage<HomePage> findHomePages(QueryRequest request, HomePage homePage);

    /**
     * 查询（所有）
     *
     * @param homePage homePage
     * @return List<HomePage>
     */
    List<HomePage> findHomePages(HomePage homePage);

    /**
     * 新增
     *
     * @param homePage homePage
     */
    void createHomePage(HomePage homePage);

    /**
     * 修改
     *
     * @param homePage homePage
     */
    void updateHomePage(HomePage homePage);

    /**
     * 删除
     *
     * @param homePage homePage
     */
    void deleteHomePage(HomePage homePage);

    List<HomePage> findAllHomePage();

    HomePage findHomeById(Integer id);
}
