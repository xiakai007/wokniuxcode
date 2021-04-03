package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.DistinctReqResult;
import cc.zy.base.businesses.entity.ReqResultExtension;
import cc.zy.base.businesses.entity.Student;
import cc.zy.base.businesses.entity.StudentPool;

import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 *  Service接口
 *
 * @author Jiangjinlin
 * @date 2021-01-25 10:55:03
 */
public interface IStudentPoolService extends IService<StudentPool> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param studentPool studentPool
     * @return IPage<StudentPool>
     */
    IPage<StudentPool> findStudentPools(QueryRequest request, StudentPool studentPool);

    /**
     * 查询（所有）
     *
     * @param studentPool studentPool
     * @return List<StudentPool>
     */
    List<StudentPool> findStudentPools(StudentPool studentPool);

    /**
     * 新增
     *
     * @param studentPool studentPool
     */
    void createStudentPool(StudentPool studentPool);

    /**
     * 修改
     *
     * @param studentPool studentPool
     */
    void updateStudentPool(StudentPool studentPool);

    /**
     * 删除
     *
     * @param studentPool studentPool
     */
    void deleteStudentPool(StudentPool studentPool);
    /**
     * 增加
     *
     * @param studentPools List<StudentPool>
     */
    int   AddStudentPoolList(@Param("list") List<StudentPool> studentPools);

    /**
     * 判断
     * @author zhangkai
     * @date 2021-02-01 10:55:03
     * @param studentPool studentPool
     */
    StudentPool  ifStudentPool(StudentPool studentPool);

    FebsResponse addStudentPool(List<DistinctReqResult>  distinctReqResults) ;

    /**
     * 根据OpenId查询（单个学生）
     *
     * @return IPage<Student>
     */
    StudentPool findStudentByOpenId(String openId);

    /**
     * 根据微信信息查询（单个学生）
     *
     * @return IPage<Student>
     */
    StudentPool findStudentByWxInfo(String batch, String idCard, String mobile, String studyMode);

    /**
     * 根据微信信息和OpenId查询（单个学生）
     *
     * @return IPage<Student>
     */
    StudentPool findStudentByWxInfoAndOpenId(String batch, String idCard, String mobile, String studyMode, String openId);


}
