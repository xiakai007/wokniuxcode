package cc.zy.base.businesses.controller;



import cc.zy.base.businesses.entity.CorrespondenceCollege;
import cc.zy.base.businesses.service.ICorrespondenceCollegeService;
import cc.zy.base.common.annotation.ControllerEndpoint;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.system.entity.User;
import cc.zy.base.system.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.validation.Valid;
import java.util.Map;

/**
 * 函授站管理
 * @author 赵佳伟
 * @date 2021-01-25 19:37:31
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
public class CorrespondenceCollegeController extends BaseController {

    private final ICorrespondenceCollegeService correspondenceCollegeService;
    private final IUserService userService;

    /**
     * 查询所有函授站信息，带分页
     * @param request
     * @param province 省id
     * @param city 市id
     * @param txtCollege 函授站名称
     * @return
     */
    @GetMapping("correspondenceCollege/list")
    @ResponseBody
    public FebsResponse correspondenceCollegeList(QueryRequest request,String province,String city,String txtCollege) {
        Map<String, Object> dataTable = getDataTable(this.correspondenceCollegeService.findCorrespondenceColleges(request,province,city,txtCollege));
        log.info("返回的集合为"+dataTable);
        return new FebsResponse().success().data(dataTable);
    }

    /**
     * 新增函授站
     * @param correspondenceCollege 函授站对象
     * @param province 省id
     * @param city 市id
     * @param area 区id
     * @return
     */
    @ControllerEndpoint(operation="新增CorrespondenceCollege", exceptionMessage="新增函授站信息异常")
    @PostMapping("correspondenceCollege/add")
    @ResponseBody
    public FebsResponse addCorrespondenceCollege(@Valid CorrespondenceCollege correspondenceCollege, String province, String city, String area) {
        correspondenceCollege.setProvinceId(Integer.parseInt(province));
        correspondenceCollege.setCityId(Integer.parseInt(city));
        correspondenceCollege.setAreaId(Integer.parseInt(area));
        User principal = userService.findByName(getCurrentUser().getUsername());
        int userId = Integer.parseInt(principal.getUserId()+"");
        correspondenceCollege.setCreateUserId(userId);
        this.correspondenceCollegeService.createCorrespondenceCollege(correspondenceCollege);
        return new FebsResponse().success();
    }

    /**
     * 修改函授站信息
     * @param correspondenceCollege 函授站对象
     * @return
     */
    @ControllerEndpoint(operation="修改CorrespondenceCollege", exceptionMessage="修改函授站信息异常")
    @PostMapping("correspondenceCollege/update")
    @ResponseBody
    public FebsResponse updateCorrespondenceCollege(CorrespondenceCollege correspondenceCollege) {
        log.info("前台给的id为："+correspondenceCollege.getId());
        this.correspondenceCollegeService.updateCorrespondenceCollege(correspondenceCollege);
        return new FebsResponse().success();
    }

    /**
     * 判断新增函授站时全称或简称是否重复
     * @param fullName 全称
     * @param simpleName 简称
     * @return Boolean false 名字重复不能提交
     *                 true 名称不重复，可以提交
     */
    @GetMapping("correspondenceCollege/isRepetitive")
    @ResponseBody
    public Boolean isRepetitive(String fullName, String simpleName) {
        log.info("前台传来的函授站全称为：" + fullName + "简称为：" + simpleName);
        Boolean repetitive = this.correspondenceCollegeService.isRepetitive(fullName, simpleName);
        return repetitive;
    }

}
