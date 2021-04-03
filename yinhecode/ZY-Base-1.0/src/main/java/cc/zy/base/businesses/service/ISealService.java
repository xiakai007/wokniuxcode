package cc.zy.base.businesses.service;


import cc.zy.base.businesses.entity.College;
import cc.zy.base.businesses.entity.Seal;
import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 印章Service接口
 *
 * @author guozhaodi
 * @date 2021-01-27 09:56:39
 */
public interface ISealService extends IService<Seal> {
    /**
     * 查询所有院校和相关印章的信息（分页）
     *
     * @param   request QueryRequest
     * @param   College college
     * @return IPage<College>
     * @author guozhaodi
     * @date 2021-01-27 09:56:39
     */
    IPage<College> findSeals(QueryRequest request, College college);

    /**
     * 修改相关学校对应的印章
     * 无返回
     * @param  seal seal
     * @author guozhaodi
     * @date   2021-01-27 09:56:39
     */
    void updateSeal(Seal seal);

    /**
     * 根据id查询该印章的相关信息(用于修改子页面数据展示的返回)
     *
     * @param  id  院校id
     * @return College
     * @author guozhaodi
     * @date   2021-01-27 09:56:39
     */
    College findSealById(Integer id);


}
