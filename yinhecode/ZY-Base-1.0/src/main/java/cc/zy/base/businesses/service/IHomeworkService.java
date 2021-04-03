package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.*;
import cc.zy.base.businesses.entity.Homework;
import cc.zy.base.businesses.entity.CollegeTerm;
import cc.zy.base.businesses.entity.Homework;

import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *  Service接口
 *
 * @author peizijian
 * @date 2021/01/29
 */
public interface IHomeworkService extends IService<Homework> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param homework homework
     * @author peizijian
     * @date 2021/01/29
     * @return IPage<Homework>
     */
    IPage<Homework> findHomeworks(QueryRequest request, Homework homework);

    /**
     * 查询（所有）
     *
     * @param homework homework
     * @author peizijian
     * @date 2021/01/29
     * @return List<Homework>
     */
    List<Homework> findHomeworks(Homework homework);

    /**
     * 新增
     * @param homework homework
     */
    void createHomework(Homework homework);

    /**
     * 修改
     *
     * @param homework homework
     */
    void updateHomework(Homework homework);

    /**
     * 删除
     *
     * @param homework homework
     */
    void deleteHomework(Homework homework);

    /**
     * 查询列表
     * @author peizijian
     * @date 2021/01/29
     * @param homework
     * @return
     */
    IPage<Homework> getHomeworkList(QueryRequest request,Homework homework);

    /**
     * 读取excel数据
     *
     * @param multipartFile
     * @return
     */
    public String readData(MultipartFile multipartFile, HttpSession session);

    /**
     * 获取所有学校名称
     * @author peizijian
     * @date 2021/01/29
     * @return
     */
    List<College> getCollegeList();
    /**
     * 通过学校id获取层次名称
     * @param collegeId
     * @author peizijian
     * @date 2021/01/29
     * @return
     */
    List<Level> getLevelListByCollegeId(Integer collegeId);
    /**
     * 通过学校和层次获取对应专业
     * @param collegeId
     * @param levelId
     * @author peizijian
     * @date 2021/01/29
     * @return
     */
    List<Major> getMajorListByIds(Integer collegeId, Integer levelId);
    /**
     * 通过学校和层次及专业获取对应课程
     * @param collegeId
     * @param levelId
     * @param majorId
     * @author peizijian
     * @date 2021/01/29
     * @return
     */
    List<TeachProgram> getCourseNameByIds(Integer collegeId, Integer levelId, Integer majorId, Integer termId);
    /**
     * 根据层次id获取对应学期
     * @param levelId
     * @author peizijian
     * @date 2021/01/29
     * @return
     */
    List<CollegeTerm> getTermsByLevelId(Integer levelId);

    /**
     * 根据层次id获取对应学年
     * @param levelId
     * @author peizijian
     * @date 2021/01/29
     * @return
     */
    List<CollegeYear> getYearByLevelId(Integer levelId);


    /**
     * 根据学生id查找目前学生已经上过的学期
     * @author peizijian
     * @date 2021/01/29
     */
    List<CollegeTerm> findTermByStuid(Integer id);

    /**
     * 根据学生id查找目前学生已经上过的学期及其作业
     * @author peizijian
     * @date 2021/01/29
     */
    List<Homework> findHomeWorkBystuid(Integer id,Integer termId);

    /**
     * 根据ID查询学生作业
     * @param id
     * @author pzj
     * @date 2021/02/01
     * @return
     */
    Homework findHomeworkById(Integer id);
}
