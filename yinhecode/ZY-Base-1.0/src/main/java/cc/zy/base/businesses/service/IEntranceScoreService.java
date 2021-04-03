package cc.zy.base.businesses.service;


import cc.zy.base.businesses.entity.EntranceScore;
import cc.zy.base.businesses.entity.EntrytestScore;
import cc.zy.base.businesses.entity.ErrorLog;
import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *  Service接口
 *
 * @author Jiangjinlin
 * @date 2021-01-23 23:11:18
 */
public interface IEntranceScoreService extends IService<EntranceScore> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param entranceScore tEntranceScore
     * @return IPage<TEntranceScore>
     */
    IPage<EntranceScore> findTEntranceScores(QueryRequest request, EntranceScore entranceScore);

    /**
     * 查询（所有）
     *
     * @param entranceScore tEntranceScore
     * @return List<TEntranceScore>
     */
    List<EntranceScore> findTEntranceScores(EntranceScore entranceScore);

    /**
     * 导出列表
     * @param entranceScore
     * @param request
     * @return
     */
    List<EntranceScore> exportList(EntranceScore entranceScore, QueryRequest request);
    /**
     * 新增
     *
     * @param entranceScore tEntranceScore
     */
    void createTEntranceScore(EntranceScore entranceScore);

    /**
     * 用id获取EntranceScore
     * @param id
     * @return
     */
    EntranceScore getEntranceById(Integer id);

    /**
     * 修改
     *
     * @param entranceScore tEntranceScore
     */
    void updateTEntranceScore(EntranceScore entranceScore);

    /**
     * 删除
     *
     * @param entranceScore tEntranceScore
     */
    void deleteTEntranceScore(EntranceScore entranceScore);

    /**
     * 列表查询
     * @param entranceScore
     * @param request
     * @return
     */
    IPage<EntranceScore> findList(EntranceScore entranceScore, QueryRequest request);

    /**
     * 获取所有有效批次
     * @return
     */
    List<EntranceScore> getBatchs();
    /**
     * 通过批次Id获取院校名称
     * @return
     */
    List<EntranceScore> getCollegesByBatchId(Integer batchId);
    /**
     * 获取学生所考科目总成绩
     * @param entranceScore
     * @return
     */
    Integer getStuTotalScore(EntranceScore entranceScore);


    /**
     * 获取课程别名和所在模板表格的列数
     * @param levelName
     * @param subtypeName
     * @return
     */
    List<EntranceScore> getSubjectsAliasAndNum(String levelName, String subtypeName);

    /**
     * 获取添加入学成绩表所需ids
     * @param levelName
     * @param subtypeName
     * @param batchName
     * @return
     */
    List<EntranceScore> getEntranceIds(@Param("levelName")String levelName, @Param("subtypeName")String subtypeName,@Param("batchName")String batchName);
    /**
     * 增加入学成绩数据
     * @param entranceScore
     * @param score
     * @return
     */
    int insertEntrance(@Param("entranceScore") EntranceScore entranceScore,@Param("score") String score);
    /**
     * 检查数据库是否有同批次，同一个人
     * @param identity
     * @param batchId
     * @return
     */
    List<EntranceScore> checkUnique(@Param("identity")String identity,@Param("batchId")String batchId);

    /**
     * 查询所有
     * @param entranceScore
     * @param request
     * @return
     */
    public IPage<EntranceScore> findAllList(EntranceScore entranceScore, QueryRequest request);
    /**
     * 通过联合主键获取Entrance对象
     * @param entranceScore
     * @return
     */
    List<EntranceScore> getEntranceScoreByIds( EntranceScore entranceScore);
    /**
     *获取个人总成绩
     * @param entranceScore
     * @return
     */
    EntrytestScore getTotalScore(EntranceScore entranceScore);
    /**
     * 修改入学成绩状态
     * @param entranceScore
     * @return
     */
    int changeEntranceScoreStatus(@Param("entranceScore") EntranceScore entranceScore);
    /**
     * 获取个人总成绩信息
     * @param entranceScore
     * @return
     */
    EntranceScore getEntranceScoreInfo(@Param("entranceScore") EntranceScore entranceScore);

    /**
     * 读取excel数据
     * @param iEntranceScoreService
     * @param multipartFile
     * @return
     */
    String readData(IEntranceScoreService iEntranceScoreService, MultipartFile multipartFile, HttpSession session);
    /**
     * 获取错误日志信息
     * @return
     */
    IPage<ErrorLog> getErrorLogs(QueryRequest request,HttpSession session);

}
