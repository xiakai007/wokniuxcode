package cc.zy.base.businesses.service.impl;

import cc.zy.base.businesses.entity.Dic;
import cc.zy.base.businesses.entity.Student;
import cc.zy.base.businesses.entity.TransferApplication;
import cc.zy.base.businesses.entity.TransferApplicationVo;
import cc.zy.base.businesses.mapper.DicMapper;
import cc.zy.base.businesses.mapper.StudentMapper;
import cc.zy.base.businesses.mapper.TransferApplicationMapper;
import cc.zy.base.businesses.service.IDicService;
import cc.zy.base.businesses.service.ITransferApplicationService;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.SortUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Service实现
 *
 * @author liuheng
 * @date 2021/01/25
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TransferApplicationServiceImpl extends ServiceImpl<TransferApplicationMapper, TransferApplication> implements ITransferApplicationService {

    @Resource
    private  TransferApplicationMapper transferApplicationMapper;

    @Resource
    private  StudentMapper studentMapper;

    @Resource
    private  DicMapper dicMapper;

    @Resource
    private  IDicService dicService;

    /**
     *
     * @Description 根据条件查询异动申请列表，根据审批状态和申请时间进行排序（分页）
     * @param transferApplication 异动申请对象
     * @return IPage 带分页的异动申请列表
     * @author liuheng
     */
    @Override
    public IPage<TransferApplicationVo> findTransferApplications(QueryRequest request, TransferApplication transferApplication) {
        log.debug("异动申请信息：" + transferApplication);
        Page<TransferApplicationVo> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(true);
        page.setTotal(baseMapper.countTransferApplication(transferApplication));

        SortUtil.handlePageSort(request, page, "approvalStatusId", FebsConstant.ORDER_ASC, false);
        SortUtil.handlePageSort(request, page, "applicationTime", FebsConstant.ORDER_ASC, false);
        return this.baseMapper.findTransferApplicationPage(page, transferApplication);
    }

    /**
     *
     * @Description 根据异动申请id查找对应异动类型id并返回不同的异动详情
     * @param id 异动申请id
     * @return transferApplicationVo 学生异动申请对象
     * @author liuheng
     */
    @Override
    public TransferApplicationVo findTransferDetailById(Integer id) {
        log.debug("异动申请id：" + id);
        TransferApplicationVo transferApplicationVo = this.transferApplicationMapper.findTransferDetailById(id);

        //查询异动记录对应申请材料集合
        List<String> attachmentList = this.transferApplicationMapper.findTransferAttachment(id);
        transferApplicationVo.setAttachmentList(attachmentList);

        //查询异动记录对应异动类型所对应的异动详情sid = 1 休学 ：2 复学 ： 3 退学 ：4 换专业 ：5 更换学习形式(枚举)
        if (transferApplicationVo != null && transferApplicationVo.getTransferTypeId() != null) {
            if (transferApplicationVo.getTransferTypeId() == dicService.findDicId("change_type", 1))
                transferApplicationVo.setYearLimit(this.transferApplicationMapper.findSuspensionCollegeByTransferApplicationId(transferApplicationVo.getId()));
            if (transferApplicationVo.getTransferTypeId() == dicService.findDicId("change_type", 2))
                transferApplicationVo.setNewBatchName(this.transferApplicationMapper.findBackCollegeByTransferApplicationId(transferApplicationVo.getId()));
            if (transferApplicationVo.getTransferTypeId() == dicService.findDicId("change_type", 4))
                transferApplicationVo.setNewMajorName(this.transferApplicationMapper.findMajorChangeByTransferApplicationId(transferApplicationVo.getId()));
            if (transferApplicationVo.getTransferTypeId() == dicService.findDicId("change_type", 5))
                transferApplicationVo.setNewStudyTypeName(this.transferApplicationMapper.findStudyTypeChangeByTransferApplicationId(transferApplicationVo.getId()));
        }
        log.debug("异动申请详情：" + transferApplicationVo);
        return transferApplicationVo;
    }

    /**
     *
     * @Description 不带分页的异动申请列表查询
     * @param transferApplication 异动申请对象
     * @return list 异动申请列表
     * @author liuheng
     */
    @Override
    public List<TransferApplication> findTransferApplications(TransferApplication transferApplication) {
        log.debug("异动申请：" + transferApplication);
        LambdaQueryWrapper<TransferApplication> queryWrapper = new LambdaQueryWrapper<>();
        return this.baseMapper.selectList(queryWrapper);
    }

    /**
     * @Description 根据学生端传回的异动申请信息添加异动信息
     * @param transferApplicationVo  学生异动申请对象
     * @author liuheng
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createTransferApplication(TransferApplicationVo transferApplicationVo) {
        log.debug("学生异动申请：" + transferApplicationVo);
        transferApplicationVo.setApplicationTime(new Date());

        //添加学生异动记录
        int i = transferApplicationMapper.addTransferApplication(transferApplicationVo);
        log.debug("刚插入记录的id：" + transferApplicationVo.getId());
        //根据异动申请类型的不同添加不同的异动申请详情sid=1 休学 ：2 复学 ： 3 退学 ：4 换专业 ：5 更换学习形式
        if (transferApplicationVo != null && transferApplicationVo.getTransferTypeId() != null) {
            if (transferApplicationVo.getTransferTypeId() == dicService.findDicId("change_type", 1))
                transferApplicationMapper.addSuspensionCollege(transferApplicationVo.getId(), transferApplicationVo.getYearLimit());
            if (transferApplicationVo.getTransferTypeId() == dicService.findDicId("change_type", 2))
                transferApplicationMapper.addBackCollege(transferApplicationVo.getId(), transferApplicationVo.getBatchId());
            if (transferApplicationVo.getTransferTypeId() == dicService.findDicId("change_type", 4))
                transferApplicationMapper.addMajorChange(transferApplicationVo.getId(), transferApplicationVo.getMajorId());
            if (transferApplicationVo.getTransferTypeId() == dicService.findDicId("change_type", 5))
                transferApplicationMapper.addStudyTypeChange(transferApplicationVo.getId(), transferApplicationVo.getStudyTypeId());
        }

        //添加异动申请附件
        for (String url : transferApplicationVo.getAttachmentList()) {
            transferApplicationMapper.addTransferApplicationAttachment(transferApplicationVo.getId(), url);
        }
    }

    /**
     *
     * @Description 根据异动审批意见、审批状态修改学生异动申请记录
     * @param transferApplication 异动申请对象
     * @author liuheng
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateTransferApplication(TransferApplication transferApplication) {
        log.debug("异动申请：" + transferApplication);
        //更新异动申请信息
        TransferApplication transferApplication1 = transferApplicationMapper.selectById(transferApplication.getId());
        transferApplication1.setOpinion(transferApplication.getOpinion());
        transferApplication1.setApprovalTime(new Date());
        transferApplication1.setApprovalStatusId(transferApplication.getApprovalStatusId());
        this.saveOrUpdate(transferApplication1);

        //查找异动对应异动状态
        Dic dic = dicMapper.selectById(transferApplication1.getTransferTypeId());
        QueryWrapper<Dic> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type", "change_status");
        queryWrapper.eq("detail", dic.getDetail());
        List<Dic> dicList = dicMapper.selectList(queryWrapper);

        //更新学生信息中的异动状态
        Student student = studentMapper.selectById(transferApplication1.getStuId());
        student.setTracsaction(dicList.get(0).getId());
        studentMapper.updateStudentTransaction(student);
    }
}
