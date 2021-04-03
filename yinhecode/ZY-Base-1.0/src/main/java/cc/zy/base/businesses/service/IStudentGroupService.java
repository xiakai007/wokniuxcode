package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.StudentGroup;

import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 学生组表	 Service接口
 *
 * @author LiPeng
 * @date 2021-01-26 16:24:15
 */
public interface IStudentGroupService extends IService<StudentGroup> {
    /**
     * 查询（分页）
     *
     * @param request      QueryRequest
     * @param studentGroup studentGroup
     * @return IPage<StudentGroup>
     * @author houweikang
     * @date 2021/2/1
     */
    IPage<StudentGroup> findStudentGroups(QueryRequest request, StudentGroup studentGroup);

    /**
     * @description: 查询满足查询条件的所有结果
     * @param: studentGroup 学生组对象，用来传递查询条件
     * @return: 查询到的学生组集合
     * @author: LiPeng
     * @date: 2021/2/28
     */
    List<StudentGroup> findStudentGroups(StudentGroup studentGroup);

    /**
     * @Description: 查询所有学生组，倒序
     * @return: 学生组集合
     * @author: LiPeng
     * @date: 2021/2/1
     */
    List<StudentGroup> findStudentGroups();

    /**
     * 新增
     *
     * @param studentGroup studentGroup
     */
    void createStudentGroup(StudentGroup studentGroup);

    /**
     * 删除学生组
     *
     * @param groupIds 学生组 id数组
     * @author houweikang
     * @date 2021/2/1
     */
    void deleteStudentGroup(String[] groupIds);

    /**
     * 新增学生组
     *
     * @param studentGroup 学生组
     * @author houweikang
     * @date 2021/2/1
     */
    void createGroup(StudentGroup studentGroup);
}