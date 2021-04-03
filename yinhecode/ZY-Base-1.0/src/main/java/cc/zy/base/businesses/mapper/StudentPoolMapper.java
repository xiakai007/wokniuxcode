package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.Student;
import cc.zy.base.businesses.entity.StudentPool;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  Mapper
 *
 * @author Jiangjinlin
 * @date 2021-01-25 10:55:03
 */
public interface StudentPoolMapper extends BaseMapper<StudentPool> {

    /**
     * 添加学生信息到公海
     *
     * @param list 添加的学生集合
     * @return 添加成功数量
     */
    public  int   AddStudentPoolList(@Param("list") List<StudentPool> studentPools);
    /**
     * 判断学生信息是否重复
     *
     * @param studentPool 学生对象
     * @return 重复的对象
     */

    StudentPool  ifStudentPool(StudentPool studentPool);

    /**
     * 通过OpenId查找学生
     *
     * @param id id
     * @return 学生
     */
    StudentPool findStudentByOpenId(String openId);

    /**
     * 通过微信信息查找学生
     *
     * @return 学生
     */
    StudentPool findStudentByWxInfo(@Param("batch")String batch, @Param("idCard")String idCard, @Param("mobile")String mobile, @Param("studyMode")String studyMode);

    /**
     * 通过微信信息和OpenId查找学生
     *
     * @return 学生
     */
    StudentPool findStudentByWxInfoAndOpenId(@Param("batch")String batch, @Param("idCard")String idCard, @Param("mobile")String mobile, @Param("studyMode")String studyMode, @Param("openId")String openId);

}
