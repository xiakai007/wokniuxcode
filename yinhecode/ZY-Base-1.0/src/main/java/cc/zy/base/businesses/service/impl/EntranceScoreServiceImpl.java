package cc.zy.base.businesses.service.impl;


import cc.zy.base.businesses.entity.EntranceScore;
import cc.zy.base.businesses.entity.EntrytestScore;
import cc.zy.base.businesses.entity.ErrorLog;
import cc.zy.base.businesses.mapper.EntranceScoreMapper;
import cc.zy.base.businesses.mapper.TestSubjectMapper;
import cc.zy.base.businesses.service.IEntranceScoreService;
import cc.zy.base.businesses.utils.ReadExcel;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.SortUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 *  Service实现
 *
 * @author Jiangjinlin
 * @date 2021-01-23 23:11:18
 */
@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EntranceScoreServiceImpl extends ServiceImpl<EntranceScoreMapper, EntranceScore> implements IEntranceScoreService {

    private final EntranceScoreMapper entranceScoreMapper;
    @Resource
    private TestSubjectMapper testSubjectMapper;
    @Override
    public IPage<EntranceScore> findTEntranceScores(QueryRequest request, EntranceScore entranceScore) {
        LambdaQueryWrapper<EntranceScore> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<EntranceScore> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<EntranceScore> findTEntranceScores(EntranceScore entranceScore) {
	    LambdaQueryWrapper<EntranceScore> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createTEntranceScore(EntranceScore entranceScore) {
        this.save(entranceScore);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateTEntranceScore(EntranceScore entranceScore) {
        this.saveOrUpdate(entranceScore);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTEntranceScore(EntranceScore entranceScore) {
        LambdaQueryWrapper<EntranceScore> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}
    /**
     * 获取错误日志信息
     * @return
     */
    @Override
    public IPage<ErrorLog> getErrorLogs(QueryRequest request,HttpSession session) {
        String unique=(String) session.getAttribute("unique");
        System.out.println("日志唯一编码"+unique);
        Page<ErrorLog> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(this.baseMapper.getErrorLogsDetail(unique));
        SortUtil.handlePageSort(request, page, "CREATE_TIME", FebsConstant.ORDER_DESC, false);
        return this.baseMapper.getErrorLogs(page,unique);
    }

    /**
     * 获取列表信息
     * @param entranceScore
     * @param request
     * @return
     */
    @Override
    public IPage<EntranceScore> findList(EntranceScore entranceScore, QueryRequest request) {
        List<EntranceScore> entranceScore1 = this.baseMapper.getSequenceNecessary(entranceScore);
        if (entranceScore1!=null&&!entranceScore1.isEmpty()){
            String sequence = this.baseMapper.getSequence(entranceScore);
            Page<EntranceScore> page = new Page<>(request.getPageNum(), request.getPageSize());
            page.setSearchCount(false);
            Long l = this.baseMapper.countEntranceScoreDetail(entranceScore);
            if (l==null||l==0){
                page.setTotal(0);
                SortUtil.handlePageSort(request, page, "id", FebsConstant.ORDER_ASC, false);
                return this.baseMapper.findList(page,sequence, entranceScore);
            }else {
                page.setTotal(this.baseMapper.countEntranceScoreDetail(entranceScore));
                SortUtil.handlePageSort(request, page, "id", FebsConstant.ORDER_ASC, false);
                return this.baseMapper.findList(page,sequence, entranceScore);
            }
        } else {
            //查询初始数据
            Page<EntranceScore> page = new Page<>(request.getPageNum(), request.getPageSize());
            log.info("初始化表头");
            String sql="MAX(IF(c.`SUBJECT` = '大学语文', b.SCORE, 0)) AS 'chinese',MAX(IF(c.`SUBJECT` = '政治', b.SCORE, 0)) AS 'o',MAX(IF(c.`SUBJECT` = '英语(专升本)', b.SCORE, 0)) AS 'n'";
            return this.baseMapper.findList(page,sql, entranceScore);
        }
    }

  /**
   * 导出列表信息
   * @param entranceScore
   * @param request
   * @return
   */
  @Override
  public List<EntranceScore> exportList(EntranceScore entranceScore, QueryRequest request) {
    List<EntranceScore> entranceScore1 = this.baseMapper.getSequenceNecessary(entranceScore);
    if (entranceScore1!=null&&!entranceScore1.isEmpty()){
      String sequence = this.baseMapper.getSequence(entranceScore);
      return this.baseMapper.exportList(sequence, entranceScore);
    } else {
      //查询初始数据
      String sql="MAX(IF(c.`SUBJECT` = '大学语文', b.SCORE, 0)) AS 'chinese',MAX(IF(c.`SUBJECT` = '政治', b.SCORE, 0)) AS 'o',MAX(IF(c.`SUBJECT` = '英语(专升本)', b.SCORE, 0)) AS 'n'";
      return this.baseMapper.exportList(sql, entranceScore);
    }
  }

    /**
     * 获取所有批次名称
     * @return
     */
    @Override
    public List<EntranceScore> getBatchs() {
        return this.entranceScoreMapper.getBatchs();
    }
    /**
     * 通过批次Id获取院校名称
     * @return
     */
    @Override
    public List<EntranceScore> getCollegesByBatchId(Integer batchId) {
        return this.baseMapper.getCollegesByBatchId(batchId);
    }

    @Override
    public Integer getStuTotalScore(EntranceScore entranceScore) {
        return this.baseMapper.getStuTotalScore(entranceScore);
    }

    @Override
    public List<EntranceScore> getSubjectsAliasAndNum(String levelName, String subtypeName) {
        return testSubjectMapper.getSubjectsAliasAndNum(levelName,subtypeName);
    }

    @Override
    public List<EntranceScore> getEntranceIds(String levelName, String subtypeName, String batchName) {
        return testSubjectMapper.getEntranceIds(levelName,subtypeName,batchName);
    }
    /**
     * 增加入学成绩数据
     * @param entranceScore
     * @param score
     * @return
     */
    @Override
    public int insertEntrance(EntranceScore entranceScore, String score) {
        return this.baseMapper.insertEntrance(entranceScore,score);
    }

    /**
     * 检查数据库是否有同批次，同一个人
     * @param identity
     * @param batchId
     * @return
     */
    @Override
    public List<EntranceScore> checkUnique(String identity, String batchId) {
        return this.baseMapper.checkUnique(identity,batchId);
    }
    /**
     * 查询所有
     * @param entranceScore
     * @param request
     * @return
     */
    @Override
    public IPage<EntranceScore> findAllList(EntranceScore entranceScore, QueryRequest request) {
        String sequence = this.baseMapper.getAllSequence();
        Page<EntranceScore> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        Long l = this.baseMapper.countEntranceScoreDetail(entranceScore);
        if (l==null||l==0){
            page.setTotal(0);
            SortUtil.handlePageSort(request, page, "id", FebsConstant.ORDER_ASC, false);
            return this.baseMapper.findList(page,sequence, entranceScore);
        }else {
            page.setTotal(this.baseMapper.countEntranceScoreDetail(entranceScore));
            SortUtil.handlePageSort(request, page, "id", FebsConstant.ORDER_ASC, false);
            return this.baseMapper.findList(page,sequence, entranceScore);
        }
    }

    /**
     * 用id获取EntranceScore
     * @param id
     * @return
     */
    @Override
    public EntranceScore getEntranceById(Integer id) {
        return this.baseMapper.getEntranceById(id);
    }
    /**
     * 通过联合主键获取Entrance对象
     * @param entranceScore
     * @return
     */
    @Override
    public List<EntranceScore> getEntranceScoreByIds(EntranceScore entranceScore) {
        return this.baseMapper.getEntranceScoreByIds(entranceScore);
    }
    /**
     *获取个人总成绩
     * @param entranceScore
     * @return
     */
    @Override
    public EntrytestScore getTotalScore(EntranceScore entranceScore) {
        return this.baseMapper.getTotalScore(entranceScore);
    }
    /**
     * 修改入学成绩状态
     * @param entranceScore
     * @return
     */
    @Override
    public int changeEntranceScoreStatus(EntranceScore entranceScore) {
        return this.baseMapper.changeEntranceScoreStatus(entranceScore);
    }
    /**
     * 获取个人总成绩信息
     * @param entranceScore
     * @return
     */
    @Override
    public EntranceScore getEntranceScoreInfo(EntranceScore entranceScore) {
        return this.baseMapper.getEntranceScoreInfo(entranceScore);
    }
    /**
     * 读取excel数据
     * @param iEntranceScoreService
     * @param multipartFile
     * @return
     */
    @Override
    @Transactional
    public String readData(IEntranceScoreService iEntranceScoreService, MultipartFile multipartFile,HttpSession session) {
        List<EntranceScore> list = null;
        String code="";
        try {
            //读取excel数据
            FebsResponse febsResponse = ReadExcel.readData(iEntranceScoreService,multipartFile);
            String message =(String) febsResponse.get("message");
            if (message.equals("200")){
                //成功获取excel中的数据
                List<EntranceScore>  entranceScores =(List<EntranceScore>) febsResponse.get("data");
                String finalscore = entranceScores.get(0).getFinalscore();
                System.out.println(finalscore);
                //向入学成绩表中添加读取到的入学成绩的数据
                int i = this.baseMapper.addEntranceList(entranceScores);
                //向入学总成绩表中添加入学成绩的数据
                int i1 = this.baseMapper.addEntryTestList(entranceScores);
                code="200";
            }else {
                List<ErrorLog> errorLogs =(List<ErrorLog>) febsResponse.get("data");
                String unique = errorLogs.get(0).getUnique();
                session.setAttribute("unique",unique);
                int i = this.baseMapper.addErrorLogList(errorLogs);
                code="400";
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return code;
    }
}
