package cc.zy.base.businesses.controller;

import cc.zy.base.businesses.entity.PaperFinal;
import cc.zy.base.businesses.entity.Papers;
import cc.zy.base.businesses.entity.TeachProgram;
import cc.zy.base.businesses.service.IPaperFinalService;
import cc.zy.base.businesses.service.ITeachProgramService;
import cc.zy.base.common.annotation.ControllerEndpoint;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.exception.FebsException;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wuwenze.poi.ExcelKit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("paperFinal")
public class PaperFinalController extends BaseController {
    @Resource
    private IPaperFinalService iPaperfinalService;
    @Resource
    private ITeachProgramService iTeachProgramService;

    @GetMapping("list")
    @ResponseBody
    @RequiresPermissions("papers:view")
    public FebsResponse papersFinalList(QueryRequest request, PaperFinal paperFinal) {
        IPage<PaperFinal> papersPage = iPaperfinalService.findPaperfinalPage(request, paperFinal);
        Map<String, Object> dataTable = getDataTable(papersPage);
        return new FebsResponse().success().data(dataTable);
    }

    /**
     *  @author huangjia
     * @date 2021/02/01
     * 导出论文终稿信息表
     *
     * @param queryRequest
     * @param paperFinal
     * @param response
     */
    @GetMapping("excel")
    @RequiresPermissions("papers:view")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    public void export(QueryRequest queryRequest, PaperFinal paperFinal, HttpServletResponse response) {
        List<PaperFinal> users = this.iPaperfinalService.findPaperfinalPage(queryRequest, paperFinal).getRecords();
        ExcelKit.$Export(Papers.class, response).downXlsx(users, false);
    }

    /**
     *  @author huangjia
     *@date 2021/02/01
     * 论文终表状态修改
     */
    @GetMapping("update/{paperId}")
    @ResponseBody
    @RequiresPermissions("papers:view")
    @ControllerEndpoint(operation = "修改论文状态", exceptionMessage = "修改论文状态失败")
    public FebsResponse refusePaper(@PathVariable Integer paperId) {
        PaperFinal paperFinal = iPaperfinalService.findPaperFinalById(paperId);
        System.out.println(paperFinal);
        if (paperFinal != null) {
            if ("1".equals(paperFinal.getPassStatus())) {
                iPaperfinalService.updatePaperFinalStatus(2, new Date(System.currentTimeMillis()), paperId);
            }
        } else {
            throw new FebsException("审批通过失败");
        }
        return new FebsResponse().success();
    }


    /**
     *  @author huangjia
     * @date 2021/02/01
     * 做联合查询
     * 通过院校id查询到对应的层次名称
     */
    @GetMapping("levelName")
    @ResponseBody
    @RequiresPermissions("papers:view")
    public FebsResponse levelName(Integer collegeId) {
        List<TeachProgram> levelNames = iTeachProgramService.findLevelNameByCollegeId(collegeId);
        return new FebsResponse().success().data(levelNames);
    }

    /**
     *  @author huangjia
     * @date 2021/02/01
     * 做联合查询
     * 通过层次id查询到对应的专业名称
     */
    @GetMapping("majorName")
    @ResponseBody
    @RequiresPermissions("papers:view")
    public FebsResponse majorName(Integer collegeId,Integer levelId) {
        List<TeachProgram> majorNames = iTeachProgramService.findMajoNameByLevelId(collegeId,levelId);
        return new FebsResponse().success().data(majorNames);
    }

    /**
     *  @author huangjia
     * @date 2021/02/01
     * 论文终稿上传
     */
    @GetMapping("uploadFinalPapers")
    @ResponseBody
    @RequiresPermissions("papers:view")
    @ControllerEndpoint(operation = "上传论文终稿", exceptionMessage = "上传论文终稿失败")
    public FebsResponse addPaperFinal(Integer paperId,String fileUrl) {
        PaperFinal paperFinal = new PaperFinal();
        paperFinal.setId(paperId);
        paperFinal.setUpdatetime(new Date(System.currentTimeMillis()));
        paperFinal.setFile(fileUrl);
        iPaperfinalService.uploadPaperFinals(paperFinal);
        return new FebsResponse().success();
    }

}
