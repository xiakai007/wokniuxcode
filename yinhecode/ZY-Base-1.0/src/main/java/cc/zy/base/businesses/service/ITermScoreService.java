package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.*;


import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *  Service接口
 *
 * @author zzz
 * @date 2021-01-28 16:13:11
 */
public interface ITermScoreService extends IService<TermScore> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param termScore termScore
     * @return IPage<TermScore>
     */
    IPage<TermScore> findTermScores(QueryRequest request, TermScore termScore);

    /**
     * 读取excel数据
     *
     * @param multipartFile
     * @return
     */
    public String readData(MultipartFile multipartFile, HttpSession session);

    /**
     * 查询（所有）
     *
     * @param termScore termScore
     * @return List<TermScore>
     */
    List<TermScore> findTermScores(TermScore termScore);

    /**
     * 新增
     *
     * @param termScore termScore
     */
    void createTermScore(TermScore termScore);

    /**
     * 修改
     *
     * @param termScore termScore
     */
    void updateTermScore(TermScore termScore);

    /**
     * 删除
     *
     * @param termScore termScore
     */
    void deleteTermScore(TermScore termScore);
    /**
     * 查询列表
     * @author wangpin
     * @param termScore
     * @return
     */
    IPage<TermScore> getTermScoreList(QueryRequest request,TermScore termScore);

    /**
     * 获取所有学校名称
     * @return
     */
    List<College> getCollegeList();
    /**
     * 通过学校id获取层次名称
     * @param collegeId
     * @return
     */
    List<Level> getLevelListByCollegeId(Integer collegeId);
    /**
     * 通过学校和层次获取对应专业
     * @param collegeId
     * @param levelId
     * @return
     */
    List<Major> getMajorListByIds(Integer collegeId,Integer levelId);
    /**
     * 通过学校和层次及专业获取对应课程
     * @param collegeId
     * @param levelId
     * @param majorId
     * @return
     */
    List<TeachProgram> getCourseNameByIds(Integer collegeId,Integer levelId,Integer majorId,Integer termId);
    /**
     * 根据层次id获取对应学期
     * @param levelId
     * @return
     */
    List<CollegeTerm> getTermsByLevelId(@Param("levelId")Integer levelId);
}
