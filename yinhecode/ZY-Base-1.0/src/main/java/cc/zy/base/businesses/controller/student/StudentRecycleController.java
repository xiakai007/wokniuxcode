package cc.zy.base.businesses.controller.student;

import cc.zy.base.businesses.entity.Recycle;
import cc.zy.base.businesses.entity.Student;
import cc.zy.base.businesses.service.IRecycleService;
import cc.zy.base.businesses.service.impl.RecycleServiceImpl;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author lalala
 * @date 2021\1\27 0027 17:58
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("recycle")
public class StudentRecycleController extends BaseController {
    private final IRecycleService recycleService;
    /**
     * 返回回收站表数据
     *
     * @author jiangweiguang
     * @date 2021\2\1 0022 16:50
     */
    @GetMapping("list")
    @ResponseBody
    @RequiresPermissions("recycle:view")
    public FebsResponse recycleList(QueryRequest request, Recycle recycle) {
        log.debug("返回recycleList方法"+recycle+","+request);
        Map<String, Object> dataTable = getDataTable(this.recycleService.findRecycle(request, recycle));
        log.debug("返回recycleList方法"+dataTable.toString());
        return new FebsResponse().success().data(dataTable);
    }
}
