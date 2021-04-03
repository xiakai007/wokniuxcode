package cc.zy.base.businesses.controller.transferApplication;

import cc.zy.base.businesses.entity.Dic;
import cc.zy.base.businesses.entity.Student;
import cc.zy.base.businesses.entity.TransferApplication;
import cc.zy.base.businesses.entity.TransferApplicationVo;
import cc.zy.base.businesses.service.IDicService;
import cc.zy.base.businesses.service.ITransferApplicationService;
import cc.zy.base.common.annotation.ControllerEndpoint;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.exception.FebsException;
import cc.zy.base.common.utils.FebsUtil;
import cc.zy.base.common.utils.TreeNode;
import cc.zy.base.system.service.IUserService;
import com.wuwenze.poi.ExcelKit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Controller
 *
 * @author liuheng
 * @date 2021/01/25
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("transferApplication")
public class TransferApplicationController extends BaseController {

    @Resource
    private final ITransferApplicationService transferApplicationService;

    @Resource
    private final IDicService dicService;

    @Resource
    private final IUserService userService;

    /**
     * @return
     * @author liuheng
     */
    @GetMapping(FebsConstant.VIEW_BUS_PREFIX + "transferApplication")
    public String transferApplicationIndex() {
        return FebsUtil.BusinessView("transferApplication/transferApplication");
    }

    /**
     *
     * @Description 条件查询异动信息列表
     * @param transferApplication 异动申请对象 接收参数 异动类型（字典表中id）
     * @param student 学生对象  接收参数 批次id、院校id、层次id、专业id、班主任（用户id）、学生姓名、身份证号、手机号
     * @return dataTable 异动申请信息列表
     * @author liuheng
     */
    @ResponseBody
    @GetMapping("list")
    @RequiresPermissions("transferApplication:view")
    public FebsResponse transferApplicationList(QueryRequest request, TransferApplication transferApplication, Student student) {
        log.debug(transferApplication == null ? "未选择异动类型" :
                "异动类型：" + transferApplication.getTransferTypeId());
        log.debug(student == null ? "未输入学生信息":
                "姓名：" + student.getStuName() +
                ",身份证号：" + student.getIdentity() +
                ",手机号：" + student.getTel() +
                ",批次id：" + student.getBatchId() +
                ",院校id：" + student.getCollegeId() +
                ",专业id：" + student.getMajorId() +
                ",层次id：" + student.getLevel() +
                ",班主任id：" + student.getUserId());
        if (student != null && student.getStuName() != null){
            student.setStuName(student.getStuName().trim());
        }
        transferApplication.setStudent(student);
        Map<String, Object> dataTable = getDataTable(this.transferApplicationService
                .findTransferApplications(request, transferApplication));
        log.debug("查询到的异动申请列表：" + dataTable);
        return new FebsResponse().success().data(dataTable);
    }

    /**
     *
     * @Description 学生端发起异动申请
     * @param transferApplicationVo  学生异动信息对象
     * @return Boolean 添加是否成功
     * @author liuheng
     */
    @ResponseBody
    @PostMapping("add")
    @ControllerEndpoint(operation = "新增异动申请", exceptionMessage = "新增异动申请失败")
    public FebsResponse addCollege(@Valid TransferApplicationVo transferApplicationVo) {
        this.transferApplicationService.createTransferApplication(transferApplicationVo);
        return new FebsResponse().success();
    }

    /**
     *
     * @Description 查询异动类型,页面异动下拉框
     * @return TransferTypeList 异动类型列表
     * @author liuheng
     */
    @ResponseBody
    @GetMapping("transferTypeList")
    public FebsResponse transferTypeList() {
        List<Dic> transferTypeList = this.dicService.findAllTransferType();
        return new FebsResponse().success().data(transferTypeList);
    }

    /**
     *
     * @Description 页面返回审批状态和意见，根据状态和意见修改异动信息
     * @param transferApplication 异动申请对象
     * @return Boolean 修改是否成功
     * @author liuheng
     */
    @ResponseBody
    @PostMapping("update")
    @ControllerEndpoint(operation = "修改异动申请", exceptionMessage = "修改异动申请失败")
    public FebsResponse updateTransferApplication(@Valid TransferApplication transferApplication) {
        log.debug("异动申请：" + transferApplication);
        if (transferApplication.getId() == null) {
            throw new FebsException("异动申请ID为空");
        }
        this.transferApplicationService.updateTransferApplication(transferApplication);
        return new FebsResponse().success();
    }

    /**
     *
     * @Description 用户——部门下拉选择树通用组件
     * @return nodeList json类型树形结构字符串
     * @author liuheng
     */
    @ResponseBody
    @GetMapping("userDeptTree")
    public List<TreeNode> userDeptTree() {
        List<TreeNode> nodeList = userService.createUserDeptTree();
        log.debug("用户树:" + nodeList);
        return nodeList;
    }

    /**
     *
     * @Description 学生异动申请列表导出excel
     * @param transferApplication 异动申请对象
     * @param student 学生对象
     * @author liuheng
     */
    @GetMapping("excel")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    public void export(QueryRequest queryRequest,
                       TransferApplication transferApplication,
                       HttpServletResponse response,
                       Student student) {
        transferApplication.setStudent(student);
        List<TransferApplicationVo> TransferApplicationVoList = this.transferApplicationService
                .findTransferApplications(queryRequest, transferApplication).getRecords();
        List<TransferApplicationVo> transferApplicationVos = new ArrayList<>();
        for (TransferApplicationVo transferApplicationVo : TransferApplicationVoList) {
            TransferApplicationVo transferDetailById = this.transferApplicationService
                    .findTransferDetailById(transferApplicationVo.getId());
            transferApplicationVos.add(transferDetailById);
        }
        ExcelKit.$Export(TransferApplicationVo.class, response).downXlsx(transferApplicationVos, false);
    }
}
