package cc.zy.base.businesses.controller;


import cc.zy.base.businesses.entity.NoticeUser;
import cc.zy.base.businesses.service.INoticeUserService;
import cc.zy.base.common.annotation.ControllerEndpoint;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;

import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通知人表 Controller
 *
 * @author guozhikun
 * @date 2021-01-27 14:14:52
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("noticeUser")
public class NoticeUserController extends BaseController {
    @Resource
    private final INoticeUserService noticeUserService;

    /**
     * 阅读详情
     * 根据通知id查询阅读详情
     *
     * @param request
     * @param noticeUser
     * @param noticeId
     * @return
     */
    @ResponseBody
    @GetMapping("statistics/{noticeId}")
    public FebsResponse noticeUserList(QueryRequest request, NoticeUser noticeUser, @PathVariable Integer noticeId) {
        log.debug("通知id" + noticeId);
        Map<String, Object> dataTable = getDataTable(this.noticeUserService.findNoticeUsers(request, noticeUser, noticeId));
        return new FebsResponse().success().data(dataTable);
    }

    /**
     * 根据通知id获取应读人数和已读人数
     *
     * @param noticeId
     * @return
     */
    @ResponseBody
    @GetMapping("noticeUserCount")
    public Map<String, Object> noticeUserCount(Integer noticeId) {
        log.debug("通知id：" + noticeId);
        Map<String, Object> resultMap = new HashMap<>(16);
        long count = noticeUserService.countNoticeUser(noticeId);
        int readCount = noticeUserService.countNoticeUserRead(noticeId);
        if (count > 0 && readCount >= 0) {
            int countNoticeUser = (int) count;
            resultMap.put("count", countNoticeUser);
            resultMap.put("readCount", readCount);
        } else {
            resultMap.put("flag", false);
        }
        return resultMap;
    }

    /**
     * 导出Excel
     * @param queryRequest
     * @param noticeUser
     * @param response
     */
    @GetMapping("excel")
    @RequiresPermissions("user:export")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    public void export(QueryRequest queryRequest, NoticeUser noticeUser, HttpServletResponse response) {
        List<NoticeUser> noticeUsers = this.noticeUserService.findNoticeUserList();
        ExcelKit.$Export(NoticeUser.class, response).downXlsx(noticeUsers, false);
    }


}
