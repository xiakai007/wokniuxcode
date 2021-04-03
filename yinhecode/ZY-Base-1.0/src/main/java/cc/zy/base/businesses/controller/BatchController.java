package cc.zy.base.businesses.controller;

import cc.zy.base.businesses.entity.Batch;
import cc.zy.base.businesses.service.IBatchService;
import cc.zy.base.common.annotation.ControllerEndpoint;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.exception.FebsException;
import cc.zy.base.common.utils.FebsUtil;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.wuwenze.poi.ExcelKit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

/**
 * 批次信息
 * @author linan
 * @date 2021-02-01
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("batch")
public class BatchController extends BaseController {
    @Resource
    private IBatchService iBatchService;

    /**
     * 批次列表
     * @return
     */
    @GetMapping("getList")
    @ResponseBody
    public FebsResponse getBatchlist(){
        List<Batch> batchs = iBatchService.findBatchs();
        return new FebsResponse().success().data(batchs);
    }

    /**
     * 通过批次名称查询批次
     * @param batchName 批次名称
     * @return
     */
    @GetMapping("list2")
    public FebsResponse getBatchlistById(Integer batchName) {
        Batch batch = iBatchService.findBatchsById(batchName);
        return new FebsResponse().success().data(batch);
    }

    @GetMapping(FebsConstant.VIEW_PREFIX + "batch")
    public String batchIndex(){
        return FebsUtil.view("batch/batch");
    }

    /**
     * 得到所有的批次信息
     * @param batch
     * @return
     */
    @GetMapping("batch")
    @ResponseBody
    public FebsResponse getAllBatchs(Batch batch) {
        return new FebsResponse().success().data(iBatchService.findBatchs(batch));
    }

    /**
     * 批次列表
     * @param request
     * @param batch
     * @return
     */
    @GetMapping("list")
    @ResponseBody
    public FebsResponse batchList(QueryRequest request, Batch batch) {
        Map<String, Object> dataTable = getDataTable(this.iBatchService.findBatchs(request, batch));
        return new FebsResponse().success().data(dataTable);
    }

    /**
     *新增批次
     * @param batch
     * @return
     */
    @ControllerEndpoint(operation = "新增批次", exceptionMessage = "新增批次失败")
    @PostMapping("batch")
    @ResponseBody
    public FebsResponse addBatch(@Valid Batch batch) {

        List<Batch> list = iBatchService.findBatchs();
        if (!batch.getBatchName().equals("") && !batch.getStatus().equals("")){
            for (Batch batch1 : list) {
                if (batch1.getBatchName().equals(batch.getBatchName())){
                    throw new FebsException("批次名称重复,请重新输入");
                }
            }
            this.iBatchService.createBatch(batch);
        }else {
            throw new FebsException("批次名称或状态为空");
        }
        return new FebsResponse().success();
    }

    /**
     * 删除批次
     * @param batch
     * @return
     */
    @ControllerEndpoint(operation = "Batch", exceptionMessage = "Batch")
    @GetMapping("delete")
    @ResponseBody
    public FebsResponse deleteBatch(Batch batch) {
        this.iBatchService.deleteBatch(batch);
        return new FebsResponse().success();
    }

    /**
     * 修改批次
     * @param batch
     * @return
     */
    @ControllerEndpoint(operation = "修改批次", exceptionMessage = "修改批次失败")
    @PostMapping("update")
    @ResponseBody
    public FebsResponse updateBatch(Batch batch) {

        if (!batch.getBatchName().equals("") && !batch.getStatus().equals("")){
            this.iBatchService.updateBatch(batch);
        }else {
            throw new FebsException("批次名称和状态不可为空");
        }
        return new FebsResponse().success();
    }

    /**
     * 导出excel
     * @param queryRequest
     * @param batch
     * @param response
     */
    @ControllerEndpoint(operation = "导出文件", exceptionMessage = "导出文件失败")
    @GetMapping("excel")
    @ResponseBody
    public void export(QueryRequest queryRequest, Batch batch, HttpServletResponse response) {
        List<Batch> batchs = this.iBatchService.findBatchs(queryRequest, batch).getRecords();
        ExcelKit.$Export(Batch.class, response).downXlsx(batchs, false);
    }

    /**
     * 通过id删除批次
     * @param batchIds
     * @return
     */
    @GetMapping("deleteBatch/{batchIds}")
    @ControllerEndpoint(operation = "删除批次", exceptionMessage = "删除批次失败")
    @ResponseBody
    public FebsResponse deleteBatchs(@NotBlank(message = "{required}") @PathVariable String batchIds) {
        String[] ids = batchIds.split(StringPool.COMMA);
        this.iBatchService.deletebatchs(ids);
        return new FebsResponse().success();
    }

}
