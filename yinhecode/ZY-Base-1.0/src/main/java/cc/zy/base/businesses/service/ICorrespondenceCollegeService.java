package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.CorrespondenceCollege;


import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 函授站
 * @author 赵佳伟
 * @date 2021-01-25 19:37:31
 */
public interface ICorrespondenceCollegeService extends IService<CorrespondenceCollege> {

    /**
     * 查询（分页）
     * @Param province 省id
     *        city 市id
     *        area 区id
     * @Param name 院校名称
     * @return IPage<CorrespondenceCollege>
     */
    IPage<CorrespondenceCollege> findCorrespondenceColleges(QueryRequest request, String province,String city,String name);

    /**
     * 新增函授站信息
     * @param correspondenceCollege correspondenceCollege
     */
    void createCorrespondenceCollege(CorrespondenceCollege correspondenceCollege);

    /**
     * 修改函授站信息
     * @param correspondenceCollege correspondenceCollege
     */
    int updateCorrespondenceCollege(CorrespondenceCollege correspondenceCollege);

    /**
     * 根据id查询函授站信息
     */
    CorrespondenceCollege findCorrespondenceCollegeById(Integer id);

    /**
     * 判断函授站名称是否重复
     */
    Boolean isRepetitive(String fullName, String simpleName);
}
