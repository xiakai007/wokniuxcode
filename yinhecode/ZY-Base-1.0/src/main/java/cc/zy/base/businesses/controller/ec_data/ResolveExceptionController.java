package cc.zy.base.businesses.controller.ec_data;


import cc.zy.base.businesses.entity.ResolveException;
import cc.zy.base.businesses.service.IResolveExceptionService;
import cc.zy.base.common.annotation.ControllerEndpoint;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.FebsUtil;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *  Controller
 *
 * @author LiXu
 * @date 2021/01/25
 *
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
public class ResolveExceptionController extends BaseController {

    private final IResolveExceptionService resolveExceptionService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "resolveException")
    public String resolveExceptionIndex(){
        return FebsUtil.view("resolveException/resolveException");
    }

    /*
     *异常详情展示列表
     */
    @GetMapping("resolveException/list")
    @ResponseBody
//    @RequiresPermissions("resolveException:list")
    public FebsResponse resolveExceptionList(QueryRequest request, String startDate, String  endDate, Integer triggerType,
                                             Integer reqUserId, ResolveException resolveException) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Timestamp dtpStartDate = null;
        Timestamp dtpEndDate =null;
        try {
            if (startDate != null) {
               Date startDate0 = simpleDateFormat.parse(startDate);
               dtpStartDate = new Timestamp(startDate0.getTime());
            }
            if (endDate != null) {
                Date  endDate0 = simpleDateFormat.parse(endDate);
                dtpEndDate = new Timestamp(endDate0.getTime());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Map<String, Object> dataTable = getDataTable(this.resolveExceptionService.findByResolveException(request, dtpStartDate, dtpEndDate, triggerType, reqUserId));
        return new FebsResponse().success().data(dataTable);
    }
}
