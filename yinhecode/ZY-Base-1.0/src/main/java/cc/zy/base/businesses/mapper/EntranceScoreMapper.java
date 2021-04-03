package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.EntranceScore;
import cc.zy.base.businesses.entity.EntrytestScore;
import cc.zy.base.businesses.entity.ErrorLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  Mapper
 *[sdwdwrqrwerqwe rwrewqwrwr w rrwqr wefddw wrwqre qq w qqqwA"A
 *
 * @author Jiangjinlin
 * @date 2021-01-23 23:11:18
 */
public interface EntranceScoreMapper extends BaseMapper<EntranceScore> {
    String getSequence(@Param("entranceScore") EntranceScore entranceScore);
    String getAllSequence();
    //列表查询
    <T> IPage<EntranceScore> findList(@Param("page") Page<EntranceScore> page, @Param("sql") String sql, @Param("entranceScore") EntranceScore entranceScore);
    //详情查询

    Long countEntranceScoreDetail(@Param("entranceScore") EntranceScore entranceScore);

    List<EntranceScore> exportList(@Param("sql") String sql, @Param("entranceScore") EntranceScore entranceScore);
    //获取所有有效批次
    List<EntranceScore> getBatchs();
    List<EntranceScore> getSequenceNecessary(@Param("entranceScore") EntranceScore entranceScore);

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
    Integer getStuTotalScore(@Param("entranceScore") EntranceScore entranceScore);

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
    List<EntranceScore> checkUnique(@Param("identity")String identity,@Param("batchName")String batchName);

    /**
     * 用id获取EntranceScore
     * @param id
     * @return
     */
    EntranceScore getEntranceById(@Param("id")Integer id);

    /**
     * 通过联合主键获取Entrance对象
     * @param entranceScore
     * @return
     */
    List<EntranceScore> getEntranceScoreByIds(@Param("entranceScore") EntranceScore entranceScore);

    /**
     *
     * @param entranceScore
     * @return
     */
    EntrytestScore getTotalScore(@Param("entranceScore") EntranceScore entranceScore);

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
     * 添加数据
     * @param entranceList
     * @return
     */
    int addEntranceList(@Param("entranceList")List<EntranceScore> entranceList);

    /**
     * 增加日志
     * @param errorLogList
     * @return
     */
    int addErrorLogList(@Param("errorLogList")List<ErrorLog> errorLogList);

    /**
     * 增加个人总成绩信息
     * @param entranceList
     * @return
     */
    int addEntryTestList(@Param("entryTestList")List<EntranceScore> entranceList);

    /**
     * 获取错误日志信息
     * @return
     */
    IPage<ErrorLog> getErrorLogs(@Param("page") Page<ErrorLog> page,@Param("unique")String unique);
    /**
     * 获取错误日志信息条目数
     * @return
     */
    Long getErrorLogsDetail(@Param("unique")String unique);

    /**
     * 删除日志表
     */
    void deleteErrorLogs();
}
