package cc.zy.base.businesses.controller;

import cc.zy.base.businesses.entity.Papers;
import cc.zy.base.businesses.entity.TeachProgram;
import cc.zy.base.businesses.service.IBatchService;
import cc.zy.base.businesses.service.IPapersService;
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
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("papers")
public class PaperController extends BaseController {
    @Resource
    private IPapersService iPapersService;
    @Resource
    private IBatchService iBatchService;
    @Resource
    private ITeachProgramService iTeachProgramService;

    @GetMapping("list")
    @ResponseBody
    @RequiresPermissions("papers:view")
    public FebsResponse papersList(QueryRequest request, Papers papers) {
        IPage<Papers> papersPage = iPapersService.findPapersPage(request, papers);
        Map<String, Object> dataTable = getDataTable(papersPage);
        return new FebsResponse().success().data(dataTable);
    }

    /**
     * @author huangjia
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
     * @author huangjia
     * @date 2021/02/01
     * 做联合查询
     * 通过层次id查询到对应的专业名称
     */
    @GetMapping("majorName")
    @ResponseBody
    @RequiresPermissions("papers:view")
    public FebsResponse majorName(Integer collegeId, Integer levelId) {
        System.out.println(collegeId + levelId);
        List<TeachProgram> majorNames = iTeachProgramService.findMajoNameByLevelId(collegeId, levelId);
        return new FebsResponse().success().data(majorNames);
    }

    /**
     * @param queryRequest
     * @param papers
     * @param response
     * @author huangjia
     * @date 2021/02/01
     * 导出论文信息表
     */
    @GetMapping("excel")
    @RequiresPermissions("papers:view")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    public void export(QueryRequest queryRequest, Papers papers, HttpServletResponse response) {
        List<Papers> users = this.iPapersService.findPapersPage(queryRequest, papers).getRecords();
        ExcelKit.$Export(Papers.class, response).downXlsx(users, false);
    }


    /**
     * @author huangjia
     * @date 2021/02/01
     * 论文驳回
     */
    @GetMapping("update/{paperId}")
    @ResponseBody
    @RequiresPermissions("papers:view")
    @ControllerEndpoint(operation = "修改论文状态", exceptionMessage = "修改论文失败")
    public FebsResponse refusePaper(@PathVariable Integer paperId) {
        Papers papers = iPapersService.findPapersById(paperId);
        if (papers != null) {
            if ("3".equals(papers.getCheckStatus())) {
                iPapersService.refusePaper(2, paperId);
            }
        } else {
            throw new FebsException("驳回失败");
        }
        return new FebsResponse().success();
    }


    /**
     * @author huangjia
     * @date 2021/02/01
     * 论文一键转为终稿
     */
    @GetMapping("add/{paperId}")
    @ResponseBody
    @RequiresPermissions("papers:view")
    @ControllerEndpoint(operation = "一键转为终稿", exceptionMessage = "一键转为终稿失败")
    public FebsResponse addPaperFinal(@PathVariable Integer paperId) {
        System.out.println(paperId);
        Papers papers = iPapersService.findPapersById(paperId);
        if (papers != null) {
            if ("3".equals(papers.getCheckStatus())) {
                iPapersService.refusePaper(1, paperId);
                //增加论文终表的数据
                papers.setUpLoadTime(new Date(System.currentTimeMillis()));
                papers.setCheckStatus("1");
                iPapersService.addPapersFinal(papers);
            }
        } else {
            throw new FebsException("一键转为终稿失败");
        }
        return new FebsResponse().success();
    }

    /**
     * @author huangjia
     * @date 2021/02/01
     * 论文初稿上传
     */
    @GetMapping("uploads")
    @ResponseBody
    @RequiresPermissions("papers:view")
    @ControllerEndpoint(operation = "上传论文初稿", exceptionMessage = "上传论文初稿失败")
    public FebsResponse addPaperFinal(Integer paperId, String fileUrl) {
        Papers papers = new Papers();
        papers.setId(paperId);
        papers.setUpLoadTime(new Date(System.currentTimeMillis()));
        papers.setFile(fileUrl);
        iPapersService.uploadPapers(papers);
        return new FebsResponse().success();
    }

    /**
     * @author huangjia
     * @date 2021/02/04
     * 论文初稿下载
     */
    @PostMapping("fileDownload")
    @ResponseBody
    public String paperDownload(Integer paperId) {
        Papers papers = iPapersService.findPapersById(paperId);
        String filePathName = papers.getFile();
        log.debug(filePathName);
        return filePathName;
    }

    /**
     * @author huangjia
     * @date 2021/02/04
     * 论文初稿的批量下载
     */
    @PostMapping("fileBatchDownload")
    @ResponseBody
    public String paperBatchDownload(Integer[] paperIds, HttpServletResponse response ,Model model) {
        List<String> filePathNames = new ArrayList<>();
        log.debug(paperIds + "*****************************");
        for (Integer paperId : paperIds) {
            Papers papers = iPapersService.findPapersById(paperId);
            filePathNames.add(papers.getFile());
        }

        for (String filePathName : filePathNames) {
            //待下载文件名
            String fileName = filePathName;
            log.debug(fileName+"***********************");
            //设置为doc格式的文件
            response.setHeader("content-type", "application/msword");
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            byte[] buff = new byte[1024];
            //创建缓冲输入流
            BufferedInputStream bis = null;
            OutputStream outputStream = null;

            try {
                outputStream = response.getOutputStream();

                //这个路径为待下载文件的路径
                bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
                int read = bis.read(buff);

                //通过while循环写入到指定了的文件夹中
                while (read != -1) {
                    outputStream.write(buff, 0, buff.length);
                    outputStream.flush();
                    read = bis.read(buff);
                }
            } catch ( IOException e ) {
                e.printStackTrace();
                //出现异常返回给页面失败的信息
                model.addAttribute("result","下载失败");
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            //成功后返回成功信息
            model.addAttribute("result","下载成功");
        }
        return "ok";
    }
}
