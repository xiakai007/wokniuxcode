package cc.zy.base.businesses.mapper;
import cc.zy.base.businesses.entity.*;
import cc.zy.base.businesses.entity.Homework;
import cc.zy.base.businesses.entity.CollegeTerm;
import cc.zy.base.businesses.entity.Homework;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  Mapper
 *
 * @author pzj
 * @date 2021/01/29
 */
public interface HomeworkMapper extends BaseMapper<Homework> {

    /**
     * 查询列表
     * @author pzj
     * @date 2021/01/29
     * @param homework
     * @return
     */
    IPage<Homework> getHomeworkList(@Param("page") Page<Homework> page, @Param("homework")Homework homework);

    Long countHomeworkDetail(@Param("homework")Homework homework);

    /**
     * 通过学校id获取层次名称
     * @param collegeId
     * @author pzj
     * @date 2021/01/29
     * @return
     */
    List<Level> getLevelListByCollegeId(@Param("collegeId") Integer collegeId);

    /**
     * 通过学校和层次获取对应专业
     * @param collegeId
     * @param levelId
     * @author pzj
     * @date 2021/01/29
     * @return
     */
    List<Major> getMajorListByIds(@Param("collegeId")Integer collegeId, @Param("levelId")Integer levelId);

    /**
     * 通过学校和层次及专业获取对应课程
     * @param collegeId
     * @param levelId
     * @param majorId
     * @author pzj
     * @date 2021/01/29
     * @return
     */
    List<TeachProgram> getCourseNameByIds(@Param("collegeId")Integer collegeId, @Param("levelId")Integer levelId, @Param("majorId")Integer majorId, @Param("termId")Integer termId);

    /**
     * 根据层次id获取对应学期
     * @param levelId
     * @author pzj
     * @date 2021/01/29
     * @return
     */
    List<CollegeTerm> getTermsByLevelId(@Param("levelId")Integer levelId);

    /**
     * 根据层次id获取对应学年
     * @param levelId
     * @author pzj
     * @date 2021/01/29
     * @return
     */
    List<CollegeYear> getYearByLevelId(@Param("levelId")Integer levelId);
    /**
     * 根据学生id在homework表中查找学期
     * @author pzj
     * @date 2021/01/29
     */
    List<CollegeTerm> selectTermByStuId(@Param("id") Integer id);

    /**
     * 根据学生id在homework表中查找学期
     * @author pzj
     * @date 2021/01/29
     */
    List<Homework> selectHomeworkByStuId(@Param("id") Integer id,@Param("termId")Integer termId);

    /**
     *数据导出
     * @param homework
     * @author pzj
     * @date 2021/02/01
     * @return
     */
    List<Homework> export (@Param("homework")Homework homework);

    /**
     * 根据ID查询学生作业
     * @param id
     * @author pzj
     * @date 2021/02/01
     * @return
     */
    Homework findHomeworkById(@Param("id")Integer id);

    /**
     * 添加作业信息数据
     * @param homeworkList
     * @return
     */
    int addHomeworkList(@Param("homeworkList")List<Homework> homeworkList);

    /**
     * 增加日志
     * @param errorLogList
     * @return
     */
    int addErrorLogList(@Param("errorLogList")List<ErrorLog> errorLogList);

    /**
     * 获取错误日志信息
     * @return
     */
    IPage<ErrorLog> getErrorLogs(Page<EntranceScore> page);
    /**
     * 获取错误日志信息条目数
     * @return
     */
    Long getErrorLogsDetail();

    /**
     * 删除日志表
     */
    void deleteErrorLogs();

    /**
     * 通过三个联合主键获取学生ID
     * @param homework
     * @return
     */
    Integer getStudentIdByPrimery(@Param("homework")Homework homework);

    /**
     * 通过批次、院校、专业、层次、学期和课程名获取对应课程对应的ID
     * @param homework
     * @return
     */
    Integer getCourseIdByCourseName(@Param("homework")Homework homework);

    /**
     * 检查数据唯一性
     * @param homework
     * @return
     */
    Homework checkUniqueByHomework(@Param("homework")Homework homework);

    /**
     * 查询是否通过ID
     * @param ispassName
     * @return
     */
    Integer getIspassByIspassName(@Param("ispassName")String ispassName);

}
