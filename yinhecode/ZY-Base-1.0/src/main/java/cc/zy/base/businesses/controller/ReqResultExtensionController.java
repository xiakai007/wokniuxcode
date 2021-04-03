package cc.zy.base.businesses.controller;

import cc.zy.base.businesses.entity.ReqResultExtension;
import cc.zy.base.businesses.service.IReqResultExtensionService;
import cc.zy.base.common.annotation.ControllerEndpoint;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Map;

/**
 * Controller
 *
 * @author LiPeng
 * @date 2021-02-08 19:52:58
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("reqResultExtension")
public class ReqResultExtensionController extends BaseController {

    private final IReqResultExtensionService reqResultExtensionService;

    /**
     * @description: 学生分组时的查询结果列表
     * @param: request 含分页参数；reqResultExtension query对象，传递查询条件
     * @return: 包含分页信息的json数据
     * @author: LiPeng
     * @date: 2021/2/8
     */
    @ResponseBody
    @GetMapping("groupingList")
    public FebsResponse findStudentForClassGrouping(QueryRequest request, ReqResultExtension reqResultExtension) {
        log.debug("分组时查询学生的query对象：" + reqResultExtension);
        log.debug("分组时查询学生的分页排序对象：" + request);
        Map<String, Object> dataTable = getDataTable(
                this.reqResultExtensionService.findStudentInfoForGrouping(request, reqResultExtension));
        log.debug("分组时查询到的学生数据：" + dataTable);
        return new FebsResponse().success().data(dataTable);
    }

    /**
     * @description: 根据学生id对学生进行分组
     * @param: studentIds 学生id数组 字符串；groupId 学生组id
     * @return: json格式的简单响应数据
     * @author: LiPeng
     * @date: 2021/2/8
     */
    @ResponseBody
    @PostMapping("updateGroupId/{studentIds}/{groupId}")
    @ControllerEndpoint(operation = "学生分组", exceptionMessage = "学生分组失败异常")
    public FebsResponse updateClassIdByIds(@NotBlank(message = "{required}") @PathVariable String studentIds,
                                           @NotBlank(message = "{required}") @PathVariable String groupId) {
        log.debug("用来分组的学生id字符串" + studentIds);
        log.debug("用来分组的学生组id：" + groupId);
        if (studentIds != null && !studentIds.isEmpty() && groupId != null) {
            String[] ids = studentIds.split(StringPool.COMMA);
            ArrayList<Integer> idList = new ArrayList<>();
            for (String id : ids) {
                idList.add(Integer.parseInt(id));
            }
            this.reqResultExtensionService.updateGroupId(idList, Integer.parseInt(groupId));
            return new FebsResponse().success();
        } else {
            return new FebsResponse().fail().message("学生数量为0或学生组id为空，分组失败");
        }
    }

    /**
     * @description: 根据查询条件查询学生，然后对其进行分组
     * @param: reqResultExtension query对象，传递查询条件；groupId 学生组id
     * @return: json格式的简单响应数据
     * @author: LiPeng
     * @date: 2021/2/8
     */
    @ResponseBody
    @PostMapping("updateGroupIdAll")
    @ControllerEndpoint(operation = "学生分组", exceptionMessage = "学生分组失败异常")
    public FebsResponse updateClassIdAll(ReqResultExtension reqResultExtension,
                                         @NotBlank(message = "{required}") String groupId) {
        log.debug("用来分组的query对象：" + reqResultExtension);
        log.debug("用来分组的学生组id：" + groupId);
        if (groupId != null) {
            this.reqResultExtensionService.updateGroupIdAll(reqResultExtension, Integer.parseInt(groupId));
            return new FebsResponse().success();
        } else {
            return new FebsResponse().fail().message("学生组id为空，分组失败");
        }
    }
}