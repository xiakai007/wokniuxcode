package cc.zy.base.businesses.controller;


import cc.zy.base.businesses.entity.Notice;
import cc.zy.base.businesses.entity.NoticeUser;
import cc.zy.base.businesses.entity.StudentGroup;
import cc.zy.base.businesses.service.INoticAddService;
import cc.zy.base.businesses.service.INoticeService;
import cc.zy.base.businesses.service.INoticeUserService;
import cc.zy.base.common.annotation.ControllerEndpoint;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.FebsUtil;
import cc.zy.base.system.entity.User;
import cc.zy.base.system.service.IUserService;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 通知表 Controller
 *
 * @author 杨东豪
 * @date 2021-01-26
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("notice")
public class NoticeController extends BaseController {

    private final INoticeService noticeService;
    private final INoticAddService noticAddService;
    private final IUserService userService;
    private final INoticeUserService noticeUserService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "notice")
    public String noticeIndex() {
        return FebsUtil.view("notice/notice");
    }

    @GetMapping("notice")
    @ResponseBody
    @RequiresPermissions("notice:list")
    public FebsResponse getAllNotices(Notice notice) {
        return new FebsResponse().success().data(noticeService.findNotices(notice));
    }

    @GetMapping("list")
    @ResponseBody
    @RequiresPermissions("notice:list")
    public FebsResponse noticeList(QueryRequest request, Notice notice) {
        Map<String, Object> dataTable = getDataTable(this.noticeService.findNotices(request, notice));
        return new FebsResponse().success().data(dataTable);
    }

    /**
     * 通知列表，进页面时默认显示当前用户所创建的通知
     *
     * @param notice  前台传来的notice对象
     * @param request
     * @return
     * @author 赵佳伟
     * @date 2021-01-26 11:52:14
     */
    @GetMapping("foundNoticeSelect")
    @ResponseBody
    public FebsResponse foundNoticeSelect(Notice notice, QueryRequest request) {
        log.debug("通知对象：" + notice);
        Map<String, Object> dataTable;
        //防空指针
        if (notice != null) {
            //判断是否为刚进页面
            if (notice.getCreateUserId() == null) {
                //返回当前用户的信息
                User principal = userService.findByName(getCurrentUser().getUsername());
                int userId = Integer.parseInt(principal.getUserId() + "");
                notice.setCreateUserId(userId);
            }
        }
        dataTable = getDataTable(this.noticeService.findNoticesDetailList(notice, request));
        return new FebsResponse().success().data(dataTable);
    }

    /**
     * 新增通知
     *
     * @param notice
     * @return
     * @author 赵佳伟
     * @date 2021-01-26 11:52:14
     */
    @ControllerEndpoint(operation = "新增通知", exceptionMessage = "新增通知异常")
    @PostMapping("add")
    @ResponseBody
    public FebsResponse addNotice(@Valid Notice notice, String myfile) {
        log.info("前台传过来的对象是：" + notice);
        notice.setCreateTime(new Date());
        notice.setFile(myfile);
        this.noticAddService.insertNotice(notice);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除通知", exceptionMessage = "删除通知异常")
    @GetMapping("delete")
    @ResponseBody
    @RequiresPermissions("notice:delete")
    public FebsResponse deleteNotice(Notice notice) {
        log.debug("删除通知的通知对象：" + notice);
        this.noticeService.deleteNotice(notice);
        return new FebsResponse().success();
    }

    /**
     * @param id 广告id
     * @return
     * @author 赵佳伟
     * @date 2021-01-26 11:52:14
     * 草稿发送功能
     */
    @ControllerEndpoint(operation = "草稿发送", exceptionMessage = "草稿发送异常")
    @PostMapping("update")
    @ResponseBody
    public FebsResponse updateNotice(Integer id) {
        log.info("广告id：" + id);
        if (id == null) {
            return new FebsResponse().fail().message("广告id为空，草稿发送失败");
        }
        this.noticAddService.sendNotice(id);
        return new FebsResponse().success();
    }


    /**
     * 保存草稿的功能
     *
     * @param notice
     * @return
     * @author 赵佳伟
     * @date 2021-01-26 11:52:14
     */
    @ResponseBody
    @PostMapping("addTemp")
    @ControllerEndpoint(operation = "保存草稿", exceptionMessage = "保存草稿异常")
    public FebsResponse deleteNoticeById(Notice notice, String myfile) {
        notice.setFile(myfile);
        noticAddService.insertNoticeTemp(notice);
        return new FebsResponse().success();
    }

    /**
     * 创建人查学生
     *
     * @param noticeId 通知id
     * @return
     */
    @ResponseBody
    @GetMapping("findCreatIdByUserId")
    public FebsResponse findCreatIdByUserId(String noticeId) {
        log.debug("通知id：" + noticeId);
        List<Notice> creatIdByUserId = this.noticeService.findCreatIdByUserId(Integer.parseInt(noticeId));
        return new FebsResponse().success().data(creatIdByUserId);
    }

    /**
     * 修改通知
     *
     * @param notice
     * @return
     */
    @ResponseBody
    @PostMapping("updateNoticeUser")
    @ControllerEndpoint(operation = "修改通知", exceptionMessage = "修改异常")
    public FebsResponse updateNoticeUser(Notice notice, String myfile) {
        log.debug("修改通知的通知对象：" + notice);
        log.debug("修改通知接前台传入参数：" + myfile);
        notice.setFile(myfile);
        noticeService.UpdateNoticeByidy(notice);
        noticeUserService.delectNoticeUserByNoticeId(notice.getId());
        String[] split = notice.getUserId().split(",");
        NoticeUser noticeUser = new NoticeUser();
        for (String s : split) {
            noticeUser.setNoticeId(notice.getId());
            noticeUser.setUserId(Integer.parseInt(s));
            noticeUserService.insertNoticeUserByNoticeId(noticeUser);

        }
        return new FebsResponse().success();
    }

    /**
     * 删除通知
     *
     * @param noticeId id
     * @return
     */
    @ResponseBody
    @GetMapping("deleteById/{noticeId}")
    public FebsResponse deleteNoticeById(@NotBlank(message = "{required}") @PathVariable String noticeId) {
        log.debug("删除通知id：" + noticeId);
        if (noticeId == null) {
            return new FebsResponse().fail().message("id为空，通知删除失败");
        }
        this.noticeService.deleteNoticeById(Integer.parseInt(noticeId));
        Notice notice = new Notice();
        notice.setId(Integer.parseInt(noticeId));
        noticeUserService.delectNoticeUserByNoticeId(notice.getId());
        return new FebsResponse().success();
    }

    /**
     * 获取登录用户id
     *
     * @return
     */
    @ResponseBody
    @GetMapping("findCreateUserId")
    public FebsResponse findCreateUserId() {
        User principal = userService.findByName(getCurrentUser().getUsername());
        int userId = Integer.parseInt(principal.getUserId() + "");
        return new FebsResponse().success().data(userId);
    }

    /**
     * 导出Excel
     *
     * @param queryRequest
     * @param notice
     * @param response
     */
    @GetMapping("excel")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    public void export(QueryRequest queryRequest, Notice notice, HttpServletResponse response) {
        List<Notice> noticeList = this.noticeService.findNoticesDetailList(notice,queryRequest).getRecords();
        ExcelKit.$Export(Notice.class, response).downXlsx(noticeList, false);
    }
}
