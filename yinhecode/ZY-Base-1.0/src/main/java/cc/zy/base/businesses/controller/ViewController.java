package cc.zy.base.businesses.controller;

import cc.zy.base.businesses.entity.*;
import cc.zy.base.businesses.service.*;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.utils.DateUtil;
import cc.zy.base.common.utils.FebsUtil;
import cc.zy.base.system.entity.User;
import cc.zy.base.system.service.IUserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author Jiangjinlin
 */
@Slf4j
@Controller("businessesView")
@RequiredArgsConstructor
public class ViewController extends BaseController {

    private final ICollegeService collegeService;


    private final ICustomStandardFeeService customStandardFeeService;
    private final IEntranceScoreService entranceScoreService;
    private final ITeachProgramService teachProgramService;
    private final IStudentService studentsService;
    private final IDicService dicService;
    private final IConfirmAddressService confirmAddressService;
    private final IStandardFeeService standardFeeService;

    private final IOtherPaymentService otherPaymentService;


    private final ISealService sealService;


    private final IClassesService classesService;
    private final ITransferApplicationService transferApplicationService;
    private final IVideoService videoService;
    private final ICTypeService cTypeService;
    private final IBatchService batchService;
    private final IRecycleService recycleService;
    private final IHomeworkService homeworkService;
    private final IRecruitStudentService recruitStudentService;
    private final IAdvertService advertService;
    private final IPapersService iPapersService;
    private final IReqResultExtensionService reqResultExtensionService;


    /**
     * @author huangjia
     * @date 2021-01-27 10:56:39
     * 论文的跳转控制转发
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "papers/list")
    @RequiresPermissions("papers:view")
    public String papers() {
        return FebsUtil.businessesView("paper/papers");
    }


    /**
     * @author huangjia
     * @date 2021-01-27 10:56:39
     * 论文终稿的跳转控制转发
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "paperFinal/list")
    @RequiresPermissions("papers:view")
    public String paperFinal() {
        return FebsUtil.businessesView("paper/paperFinal");
    }

    /**
     * @author huangjia
     * @date 2021-02-03 16:56:39
     * <p>
     * 论文初稿上传跳转页面
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "papers/papersupload/{id}")
    @RequiresPermissions("papers:view")
    public String papersupload(@PathVariable Integer id, Model model) {
        System.out.println(id + "****************");
        papersupload(id, model, true);
        return FebsUtil.businessesView("paper/papersupload");
    }

    /**
     * @author huangjia
     * @date 2021-02-03 16:56:39
     * <p>
     * 论文初稿上传跳转页面
     */
    private void papersupload(Integer id, Model model, Boolean transform) {
        Papers papers = iPapersService.findPapersById(id);
        model.addAttribute("papers", papers);
    }

    @GetMapping(FebsConstant.VIEW_PREFIX + "college/list")
    @RequiresPermissions("college:view")
    public String college() {
        return FebsUtil.businessesView("college/college");
    }

    /**
     * @return
     * @author wangpin
     * @date 2021/02/01
     * 跳转入学成绩页面
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "score/entranceScore")
    @RequiresPermissions("score:view")
    public String entranceScore() {
        return FebsUtil.businessesView("score/entranceScore");
    }

    /**
     * @return
     * @author wangpin
     * @date 2021/02/01
     * 跳转学期成绩页面
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "score/termScore")
    @RequiresPermissions("score:view")
    public String termScore() {
        return FebsUtil.businessesView("score/termScore");
    }

    /**
     * @return
     * @author wangpin
     * @date 2021/02/01
     * 跳转导入成绩页面
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "entranceScore/import")
    public String entranceScoreImport() {
        return FebsUtil.businessesView("score/entranceScoreImport");
    }

    @GetMapping(FebsConstant.VIEW_PREFIX + "college/detail/{id}")
    @RequiresPermissions("user:view")
    public String collegeDetail(@PathVariable Integer id, Model model) {
        resolveCollegeModel(id, model, true);
        return FebsUtil.businessesView("college/collegeDetail");
    }

    /**
     * @param id
     * @param model
     * @return
     * @author wangpin
     * @date 2021/02/01
     * 查询入学成绩详情
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "entranceScore/detail/{id}")
    @RequiresPermissions("user:view")
    public String entranceScoreDetail(@PathVariable Integer id, Model model) {
        resolveEntranceScoreModel(id, model, true);
        return FebsUtil.businessesView("score/entranceScoreDetail");
    }


    @GetMapping(FebsConstant.VIEW_PREFIX + "college/update/{id}")
    public String collegeUpdate(@PathVariable Integer id, Model model) {
        resolveCollegeModel(id, model, false);
        return FebsUtil.businessesView("college/collegeUpdate");
    }

    @GetMapping(FebsConstant.VIEW_PREFIX + "college/add")
    public String collegeAdd() {
        return FebsUtil.businessesView("college/collegeAdd");
    }

    /**
     * @return
     * @author wangpin
     * @date 2021/02/01
     * 查询入学成绩详情
     */
    private void resolveEntranceScoreModel(Integer id, Model model, Boolean transform) {
        System.out.println(id);
        //通过id获取三个联合主键
        EntranceScore entranceScoreById = entranceScoreService.getEntranceById(id);
        System.out.println(entranceScoreById);
        //通过三个联合主键查询个人总成绩详情
        EntranceScore scoreInfo = entranceScoreService.getEntranceScoreInfo(entranceScoreById);
        System.out.println(scoreInfo.getRemark());
        //通过三个联合主键查询个人单科成绩信息
        List<EntranceScore> scores = entranceScoreService.getEntranceScoreByIds(entranceScoreById);

        scoreInfo.setScores(scores);
        model.addAttribute("entranceScore", scoreInfo);
    }

    /**
     * @return
     * @author wangpin
     * @date 2021/02/04
     * 查询导入错误日志信息
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "entranceScore/errorResult")
    public String getErrorLog() {
        System.out.println("导出日志");
        return FebsUtil.businessesView("score/entranceExportResult");
    }

    /**
     * 裴子鉴开始
     * 跳转教学计划页面
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "teachProgram/list")
//    @RequiresPermissions("teachProgram:view")
    public String teachProgram() {
        return FebsUtil.businessesView("teachProgram/teachProgram");
    }

    @GetMapping(FebsConstant.VIEW_PREFIX + "teachProgram/update/{id}")
    public String teachProgramUpdate(@PathVariable Integer id, Model model) {

        resolveTeachProgramModel(id, model, false);
        return FebsUtil.businessesView("teachProgram/teachProgramUpdate");
    }

    private void resolveTeachProgramModel(Integer id, Model model, Boolean transform) {

        TeachProgram teachProgram = teachProgramService.findTeachById(id);
        System.out.println(teachProgram);
        model.addAttribute("teachProgram", teachProgram);
    }

    /**
     * 跳转批次复制页面
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "teachProgram/add")
//    @RequiresPermissions("teachProgram:view")
    public String teachProgramAdd() {

        return FebsUtil.businessesView("teachProgram/teachProgramAdd");
    }

    /**
     * 跳转批次增加页面
     *
     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "teachProgram/addNew")
//    @RequiresPermissions("teachProgram:view")
    public String teachProgramAddNew() {

        return FebsUtil.businessesView("teachProgram/teachProgramAddNew");
    }

    @GetMapping(FebsConstant.VIEW_PREFIX + "homework/homework")
    @RequiresPermissions("homework:view")
    public String homework() {
        return FebsUtil.businessesView("homework/homework");
    }


    @GetMapping(FebsConstant.VIEW_PREFIX + "homework/detail/{id}")
    public String homeworkDetail(@PathVariable Integer id, Model model) {

        resolveHomeworkModel(id, model, false);
        return FebsUtil.businessesView("homework/homeworkDetail");
    }

    private void resolveHomeworkModel(Integer id, Model model, Boolean transform) {

        Homework homework = homeworkService.findHomeworkById(id);
        System.out.println(homework);
        model.addAttribute("homework", homework);
    }

    @GetMapping("homework/result")
    public String homeworkResult() {
        return FebsUtil.view("homework/homeworkResult");
    }

    /**
     * 裴子鉴结束
     */
    private void resolveCollegeModel(Integer id, Model model, Boolean transform) {
        College college = collegeService.findById(id);
        if (college.getCreatedate() != null) {
            model.addAttribute("createDateTime", DateUtil.getDateFormat(college.getCreatedate(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        }
        if (college.getUpdatedate() != null) {
            model.addAttribute("updateDateTime", DateUtil.getDateFormat(college.getUpdatedate(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        }
        model.addAttribute("college", college);
    }
//********************************套内缴费开始************************************

    /**
     * standardFeeIndex
     * 套内缴费管理页面
     *
     * @author guankai
     * @date 2021-02-01 18:07
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "standardFee/list")
    @RequiresPermissions("standardFee:view")
    public String standardFeeIndex() {
        return FebsUtil.businessesView("standardFee/standardFee");
    }


    /**
     * 创建套内缴费页面
     *
     * @author guankai
     * @date 2021-02-01 18:07
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "standardFee/add")

    public String standardFeeAdd() {
        return FebsUtil.businessesView("standardFee/standardFeeAdd");
    }


    /**
     * 批次复制套内缴费页面
     *
     * @author guankai
     * @date 2021-02-01 18:07
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "standardFee/copy")

    public String standardFeeCopy() {
        return FebsUtil.businessesView("standardFee/standardFeeCopy");
    }


    @GetMapping(FebsConstant.VIEW_PREFIX + "standardFee/update/{id}")

    public String standardFeeUpdate(@PathVariable Integer id, Model model) {
        System.out.println("进入套内缴费修改页面");
        resolveStandardFeeModel(id, model, false);
        return FebsUtil.businessesView("standardFee/standardFeeUpdate");
    }


    private void resolveStandardFeeModel(Integer id, Model model, Boolean transform) {

        StandardFee standardFee = standardFeeService.findById(id);


        model.addAttribute("standardFee", standardFee);
    }
    //*******************************套内缴费结束*************************************

    //********************************自定义套内缴费开始************************************

    /**
     * 自定义套内缴费管理页面
     *
     * @author guankai
     * @date 2021-02-01 18:07
     */


    @GetMapping(FebsConstant.VIEW_PREFIX + "customStandardFee/list")
    @RequiresPermissions("customStandardFee:view")
    public String customStandardFeeIndex() {
        return FebsUtil.businessesView("customStandardFee/customStandardFee");
    }

    /**
     * 创建自定义套内缴费页面
     *
     * @author guankai
     * @date 2021-02-01 18:07
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "customStandardFee/add")

    public String customStandardFeeAdd() {
        return FebsUtil.businessesView("customStandardFee/customStandardFeeAdd");
    }

    @GetMapping(FebsConstant.VIEW_PREFIX + "customStandardFee/update/{id}")
    public String customStandardFeeUpdate(@PathVariable Integer id, Model model) {
        System.out.println("进入自定义套内缴费修改页面");

        resolveCustomStandardFeeModel(id, model, false);

        return FebsUtil.businessesView("customStandardFee/customStandardFeeUpdate");
    }


    private void resolveCustomStandardFeeModel(Integer id, Model model, Boolean transform) {

        CustomStandardFee customStandardFee = customStandardFeeService.findById(id);

        model.addAttribute("customStandardFee", customStandardFee);
    }
    //*******************************自定义套内缴费结束*************************************
//***********************************其他缴费开始*************************************


    /**
     * 其他缴费管理页面
     *
     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "otherPayment/list")
    @RequiresPermissions("otherPayment:view")
    public String otherPaymentIndex() {
        return FebsUtil.businessesView("otherPayment/otherPayment");
    }

    /**
     * 其他缴费修改页面
     *
     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "otherPayment/update/{id}")
    public String otherPaymentUpdate(@PathVariable Integer id, Model model) {
        System.out.println("进入其他缴费修改页面");
        resolveOtherPaymentModel(id, model, false);
        return FebsUtil.businessesView("otherPayment/otherPaymentUpdate");
    }

    /**
     * 创建其他缴费页面
     *
     * @author guankai
     * @date 2021-02-01 18:07
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "otherPayment/select")

    public String otherPaymentAdd() {
        System.out.println("============go otherPaymentSelect.html=============");
        return FebsUtil.businessesView("otherPayment/otherPaymentSelect");

    }

    /**
     * 创建其他缴费页面
     *
     * @author guankai
     * @date 2021-01-28 17:29:15
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "otherPayment/addOtherPayment/{id}")
    @ApiOperation("去学生详情页")
    public String addOtherPayment(@PathVariable Integer id, Model model) {
        Student student = studentsService.findById(id);
        model.addAttribute("student", student);
        return FebsUtil.businessesView("otherPayment/OtherPaymentAdd");
    }


    private void resolveOtherPaymentModel(Integer id, Model model, Boolean transform) {

        System.out.println("获取其他缴费对象");

        OtherPayment otherPayment = otherPaymentService.findById(id);

        model.addAttribute("otherPayment", otherPayment);
    }

    //***********************************其他缴费结束*************************************


    /**
     * linan开始
     **/
//    private final IConfirmAddressService confirmAddressService;

    /**
     * 去确认点列表
     *
     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "confirmAddress/list")
//    @RequiresPermissions("confirmAddress:view")
    public String confirmAddress() {
        return FebsUtil.businessesView("confirmAddress/confirmAddress");
    }

    /**
     * 去增加地点页面
     *
     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "confirmAddress/add")
    public String confirmAddressAdd() {
        return FebsUtil.businessesView("confirmAddress/confirmAddressAdd");
    }

    /**
     * 去确认点修改页面
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "confirmAddress/update/{id}")
    public String confirmAddressUpdate(@PathVariable Integer id, Model model) {
        resolveAddressModel(id, model, false);
        return FebsUtil.businessesView("confirmAddress/confirmAddressUpdate");
    }


    /**
     * 通过id查询确认地点对象
     *
     * @param id
     * @param model
     * @param transform
     */
    private void resolveAddressModel(Integer id, Model model, Boolean transform) {
        ConfirmAddress confirmAddress = confirmAddressService.findById(id);
        model.addAttribute("confirmAddress", confirmAddress);
    }

    /**
     * 去确认点详情页面
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "confirmAddress/detail/{id}")
    @RequiresPermissions("user:view")
    public String confirmAddresseDetail(@PathVariable Integer id, Model model) {
        resolveAddressModel(id, model, true);
        return FebsUtil.businessesView("confirmAddress/confirmAddressDetail");
    }

    /**
     * 去学生端后台首页页面
     *
     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "homePage/list")
//    @RequiresPermissions("homePage:view")
    public String homePage() {
        return FebsUtil.businessesView("homePage/homePage");
    }

    /**
     * 跳转到批次列表 batch
     */

    @GetMapping(FebsConstant.VIEW_PREFIX + "batch/list")
//    @RequiresPermissions("confirmAddress:view")
    public String batch() {
        return FebsUtil.businessesView("batch/batch");
    }

    /**
     * 去批次增加页面
     *
     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "batch/add")
    public String batchAdd() {
        return FebsUtil.businessesView("batch/batchAdd");
    }

    private void resolveBatchModel(Integer id, Model model, Boolean transform) {
        System.out.println("id@@@@@@@=" + id);
        Batch batch = batchService.findBatchsById(id);
        model.addAttribute("batch", batch);
    }

    /**
     * 去批次修改页面
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "batch/update/{id}")
    public String batchUpdate(@PathVariable Integer id, Model model) {
        resolveBatchModel(id, model, false);
        return FebsUtil.businessesView("batch/batchUpdate");
    }


    /**linan结束**/
    /**
     * linan结束
     **/

    /*广告开始-lijian*/
    @GetMapping(FebsConstant.VIEW_PREFIX + "advert/list")
    @RequiresPermissions("advert:view")
    public String advert() {
        return FebsUtil.businessesView("advert/advert");
    }

    @GetMapping(FebsConstant.VIEW_PREFIX + "advert/detail/{id}")
    @RequiresPermissions("user:view")
    public String advertDetail(@PathVariable Integer id, Model model) {
        resolveAdvertModel(id, model, true);
        return FebsUtil.businessesView("advert/advertDetail");
    }

    private void resolveAdvertModel(Integer id, Model model, Boolean transform) {
        Advert advertDetail = advertService.findAdvertDetailById(id);
        if (advertDetail.getCreateTime() != null) {
            model.addAttribute("createTime", DateUtil.getDateFormat(advertDetail.getCreateTime(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        }
        model.addAttribute("advert", advertDetail);
    }

    @GetMapping(FebsConstant.VIEW_PREFIX + "advert/update/{id}")
    public String advertUpdate(@PathVariable Integer id, Model model) {
        resolveAdvertModel(id, model, false);
        return FebsUtil.businessesView("advert/advertUpdate");
    }

    @GetMapping(FebsConstant.VIEW_PREFIX + "advert/add")
    public String advertAdd(Model model) {
        User principal = userService.findByName(getCurrentUser().getUsername());
        model.addAttribute("username", principal.getUsername());
        model.addAttribute("userId", principal.getUserId());
        return FebsUtil.businessesView("advert/advertAdd");
    }

    @GetMapping(FebsConstant.VIEW_PREFIX + "advert/loopSort/{id}")
    public String advertLoopSort(@PathVariable Integer id, Model model) {
        long useLoopCount = advertService.findUseLoopCount();
        model.addAttribute("id", id);
        model.addAttribute("count", useLoopCount);
        return FebsUtil.businessesView("advert/advertLoopSort");
    }
    /**李健结束**/

    /**
     * 张志钊开始
     **/
    private final IUserService userService;

    //跳转selectStudent页面
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/list")
    public String student() {
        return FebsUtil.businessesView("students/selectStudent");
    }

    //跳转到noticeAdd页面
    @GetMapping(FebsConstant.VIEW_PREFIX + "notice/add")
    public String noticeAdd(Model model) {
        User principal = userService.findByName(getCurrentUser().getUsername());
        model.addAttribute("username", principal.getUsername());//传递到noticeAdd页面
        model.addAttribute("userId", principal.getUserId());//传递到noticeAdd页面
        return FebsUtil.businessesView("notice/noticeAdd");
    }
    /**张志钊结束**/

    /**
     * 赵佳伟开始
     **/
    private final ICorrespondenceCollegeService correspondenceCollegeService;
    private final IProvinceService provinceService;

    /**
     * 跳转到函授站新增页面
     *
     * @author zhaojw
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "correspondenceCollege/add")
    @RequiresPermissions("college:view")
    public String countCorrespondenceCollegeAdd() {
        return FebsUtil.businessesView("correspondenceCollege/correspondenceCollegeAdd");
    }

    /**
     * 跳转到函授站信息页面
     *
     * @author zhaojw     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "correspondenceCollege/list")
    @RequiresPermissions("college:view")
    public String countCorrespondenceCollege() {
        return FebsUtil.businessesView("correspondenceCollege/correspondenceCollege");
    }

    /**
     * 跳转到函授站信息详情页面
     *
     * @author zhaojw     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "correspondence/detail/{id}")
    @RequiresPermissions("user:view")
    public String correspondenceCollegeDetail(@PathVariable Integer id, Model model) {
        resolvecorrespondenceModel(id, model, true);
        return FebsUtil.businessesView("correspondenceCollege/correspondenceCollegeDetail");
    }

    /**
     * 跳转到函授站修改页面
     *
     * @author zhaojw     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "correspondenceCollege/update/{id}")
    public String correspondenceCollegeUpdate(@PathVariable Integer id, Model model) {
        resolvecorrespondenceUpdateModel(id, model, false);
        return FebsUtil.businessesView("correspondenceCollege/correspondenceCollegeUpdate");
    }

    /**
     * 跳转到广告日志页面
     *
     * @author zhaojw     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "advertLog/list")
    @RequiresPermissions("college:view")
    public String countAdvertLog() {
        return FebsUtil.businessesView("advert/advertLog");
    }

    /**
     * 显示详情页面
     *
     * @param id        函授站id
     * @param model
     * @param transform
     * @author zhaojw
     */
    private void resolvecorrespondenceModel(Integer id, Model model, Boolean transform) {
        CorrespondenceCollege correspondenceCollege = correspondenceCollegeService.findCorrespondenceCollegeById(id);
        String province = correspondenceCollege.getProvinceName();
        String city = correspondenceCollege.getCityName();
        String area = correspondenceCollege.getAreaName();
        String address = correspondenceCollege.getAddress();
        address = province + city + area + address;
        correspondenceCollege.setAddress(address);
        if (correspondenceCollege.getCreateTime() != null) {
            model.addAttribute("createDateTime", DateUtil.getDateFormat(correspondenceCollege.getCreateTime(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        }
        model.addAttribute("correspondenceCollege", correspondenceCollege);
    }

    /**
     * 修改页面回填函授站信息
     *
     * @param id        函授站id     * @param model
     * @param transform
     * @author zhaojw
     */
    private void resolvecorrespondenceUpdateModel(Integer id, Model model, Boolean transform) {
        CorrespondenceCollege correspondenceCollege = correspondenceCollegeService.findCorrespondenceCollegeById(id);
        model.addAttribute("correspondenceCollege", correspondenceCollege);
    }
    /**赵佳伟结束**/

    /**
     * 郭志坤开始
     **/
    private final ISubjectCategoryService subjectCategoryService;
    private final IMajorService majorService;

    //学科类别列表
    @GetMapping(FebsConstant.VIEW_PREFIX + "subjectCategory/list")
//    @RequiresPermissions("subjectCategory:view")
    public String subjectCategory() {
        return FebsUtil.businessesView("subjectCategory/subjectCategory");
    }

    //学科类别修改
    @GetMapping(FebsConstant.VIEW_PREFIX + "subjectCategory/update/{id}")
    public String subjectCategoryUpdate(@PathVariable Integer id, Model model) {
        resolveSubjectCategoryModel(id, model, false);
        return FebsUtil.businessesView("subjectCategory/subjectCategoryUpdate");
    }

    //学科类别新增
    @GetMapping(FebsConstant.VIEW_PREFIX + "subjectCategory/add")
    public String subjectCategoryAdd(Model model) {
        User principal = userService.findByName(getCurrentUser().getUsername());
        model.addAttribute("user", principal);
        return FebsUtil.businessesView("subjectCategory/subjectCategoryAdd");
    }

    //类别findById
    private void resolveSubjectCategoryModel(Integer id, Model model, boolean b) {
        SubjectCategory subjectCategory = subjectCategoryService.findById(id);

        if (subjectCategory.getCreateTime() != null) {
            model.addAttribute("createDateTime", DateUtil.getDateFormat(subjectCategory.getCreateTime(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        }
        model.addAttribute("subjectCategory", subjectCategory);
    }

    //学科类别详情
    @GetMapping(FebsConstant.VIEW_PREFIX + "subjectCategory/detail/{id}")
    @RequiresPermissions("user:view")
    public String subjectCategoryDetail(@PathVariable Integer id, Model model) {
        resolveSubjectCategoryModel(id, model, true);
        return FebsUtil.businessesView("subjectCategory/subjectCategoryDetail");
    }


    //院校专业列表
    @GetMapping(FebsConstant.VIEW_PREFIX + "major/list")
//    @RequiresPermissions("major:view")
    public String major() {
        return FebsUtil.businessesView("major/major");
    }

    //院校专业修改
    @GetMapping(FebsConstant.VIEW_PREFIX + "major/update/{id}")
    public String majorUpdate(@PathVariable Integer id, Model model) {
        resolveMajorModel(id, model, false);
        return FebsUtil.businessesView("major/majorUpdate");
    }

    //院校专业新增
    @GetMapping(FebsConstant.VIEW_PREFIX + "major/add")
    public String majorAdd(Model model) {
        User principal = userService.findByName(getCurrentUser().getUsername());
        model.addAttribute("user", principal);
        return FebsUtil.businessesView("major/majorAdd");
    }

    //院校专业详情
    @GetMapping(FebsConstant.VIEW_PREFIX + "major/detail/{id}")
    @RequiresPermissions("user:view")
    public String majorDetail(@PathVariable Integer id, Model model) {
        resolveMajorModel(id, model, true);
        return FebsUtil.businessesView("major/majorDetail");
    }

    //院校专业findById
    private void resolveMajorModel(Integer id, Model model, boolean b) {
        Major major = majorService.findById(id);
        System.out.println(major);
        if (major.getCreateTime() != null) {
            model.addAttribute("createDateTime", DateUtil.getDateFormat(major.getCreateTime(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        }
        model.addAttribute("major", major);
    }
    /**郭志坤结束**/

    /**
     * 杨东豪开始
     **/
    /**
     * 跳转选择员工页面
     *
     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "businesses/user")
    public String systemUser() {
        return FebsUtil.view("system/user/selectUser");
    }

    /**
     * 跳转通知列表页面
     *
     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "businesses/Notice")
    public String Notice() {
        return FebsUtil.businessesView("notice/notice");
    }

    /**
     * 跳转修改通知
     *
     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "businesses/noticeEdit")
    public String noticeEdit() {
        return FebsUtil.businessesView("notice/noticeEdit");
    }

    @GetMapping(FebsConstant.VIEW_PREFIX + "noticeUser/statistics/{id}")
//    @RequiresPermissions("major:view")
    public String statistics(@PathVariable Integer id, Model model) {
        model.addAttribute("noticeId", id);
        return FebsUtil.businessesView("noticeUser/noticeUser");

    }

    private final INoticeService noticeService;

    /**
     * 通知详情
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "businesses/noticeDetail/{id}")
    public String noticeDetail(@PathVariable Integer id, Model model) {
        resolveNoticeModel(id, model, true);
        return FebsUtil.businessesView("notice/noticeDetail");
    }

    /**
     * 通知详情页面
     *
     * @param id
     * @param model
     * @param b
     */
    private void resolveNoticeModel(Integer id, Model model, boolean b) {
        List<Integer> userIdList = noticeService.findUserIdListByUserId(id);
        Notice noticeById = noticeService.findNoticeById(id);
        List list1 = new ArrayList();
        List<Student> students = studentsService.listByIds(userIdList);
        for (Integer userId : userIdList) {
            list1.add(userId);
        }
        if (noticeById.getCreateTime() != null) {
            model.addAttribute("createDateTime", DateUtil.getDateFormat(noticeById.getCreateTime(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        }
        //list转换为字符串
        String listString = "";
        for (Student s : students) {
            listString += s.getStuName() + ",";
        }
        listString = listString.substring(0, listString.length() - 1);
        model.addAttribute("noticeUserId", listString);
        model.addAttribute("noticeId", list1);
        model.addAttribute("noticeTitle", noticeById.getTitle());
        model.addAttribute("noticeContent", noticeById.getContent());
        model.addAttribute("noticeName", noticeById.getUserName());
        model.addAttribute("noticevoid", noticeById.getVideoUrl());
        model.addAttribute("fileurl", noticeById.getFile());
        model.addAttribute("noticelist", noticeById);
        model.addAttribute("id", id);
        model.addAttribute("img", noticeById.getImgUrl());
    }

    /**
     * 调转修改页面
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "businesses/noticeEdit/{id}")
    public String noticeEdit(@PathVariable Integer id, Model model) {

        resolveNoticeModel(id, model, true);
        return FebsUtil.businessesView("notice/noticeEdit");
    }

    /**杨东豪结束**/

    /**
     * 刘润雨开始
     **/
    @ApiOperation("学生列表view")
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/todolist")
    public String students(Model model) {
        log.debug("到达学生列表");
        User user = getCurrentUser();
        model.addAttribute("user", user);
        return FebsUtil.businessesView("students/studentsList");
    }

    /**
     * 公用方法，获取回收站学生信息
     *
     * @author hutengjiao
     * @date 2021/02/01
     */
    private void resolveRecycleModel(Integer id, Model model) {
        Recycle recycle = recycleService.findById(id);
        model.addAttribute("student", recycle);
    }


    @ApiOperation("公海列表view")
    @GetMapping(FebsConstant.VIEW_PREFIX + "seastu/list")
    public String seastu(Model model) {
        log.debug("到达公海列表");
        User user = getCurrentUser();
        model.addAttribute("user", user);
        return FebsUtil.businessesView("students/seaStudentsList");
    }

    @ApiOperation("学生管理日志view")
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/studentLog")
    public String studentLog(Model model) {
        log.debug("学生管理日志列表");
        User user = getCurrentUser();
        model.addAttribute("user", user);
        return FebsUtil.businessesView("students/studentLog");
    }

    @ApiOperation("班主任列表view")
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/recruitlist")
    public String recruitlist(Model model) {
        User user = getCurrentUser();
        model.addAttribute("user", user);
        return FebsUtil.businessesView("students/recruitStudentsList");
    }


    /**
     *  展示招生老师待办任务列表
     *
     * @author 刘润雨
     * @date 2021-01-28 17:29:15
     */
    @ApiOperation("待办任务列表view")
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/goUserTaskList/{userId}")
    public String goUserTaskList(@PathVariable Integer userId, Model model) {
        log.debug("userId:"+userId);
        model.addAttribute("userId", userId);
        return FebsUtil.businessesView("students/userTaskList");
    }

    @ApiOperation("回收站列表view")
    @GetMapping(FebsConstant.VIEW_PREFIX + "recycle/list")
    public String recycleList() {
        return FebsUtil.businessesView("recycle/recycleList");
    }

    /**
     * 去回收站详情页
     *
     * @author hutengjiao
     * @date 2021/02/01
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "recycle/detail/{id}")
    @ApiOperation("去回收站详情页")
    public String goRecycleDetai(@PathVariable Integer id, Model model) {
        log.debug("id:"+id);
        model.addAttribute("id", id);
        return FebsUtil.businessesView("recycle/recycleDetail");
    }

    /**
     * 去回收站学生报考信息页
     *
     * @author hutengjiao
     * @date 2021/02/01
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "recycle/recycleExaminfo")
    @ApiOperation("去回收站学生报考信息页")
    public String goRecycleExamInfo(Integer id, Model model) {
        log.debug("id:"+id);
        resolveRecycleModel(id, model);
        //获得学习形式
        List<Dic> studyType = dicService.findDicByType("study_type");
        log.debug("出参studyType:"+studyType);
        model.addAttribute("studyType", studyType);
        return FebsUtil.businessesView("recycle/recycleExamInfo");
    }

    /**
     * 去回收站学生报考信息页
     *
     * @author hutengjiao
     * @date 2021/02/01
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "recycle/recInfo")
    @ApiOperation("去回收站学生报考信息页")
    public String goRecycleInfo(Integer id, Model model) {
        resolveRecycleModel(id, model);
        //获得学习形式
        return FebsUtil.businessesView("recycle/recycleInfo");
    }

    @ApiOperation("创建标签view")
    @GetMapping(FebsConstant.VIEW_PREFIX + "recycle/label")
    public String recLabelAdd() {
        return FebsUtil.businessesView("recycle/recycleLabelAdd");
    }

    @ApiOperation("创建标签view")
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/label")
    public String stuLabelAdd() {
        return FebsUtil.businessesView("students/studentLabelAdd");
    }

    /**
     * 公用方法 获得班级学生 解析毕业日期
     *
     * @author 刘润雨
     * @date 2021-01-28 17:29:15
     */
    private Student resolveStudentModel(Integer id, Model model) {
        log.debug("id:"+id);
        Student student = studentsService.findById(id);
        try {
            Date graduDate = student.getGraduDate();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String graduDateStr = simpleDateFormat.format(graduDate);
            model.addAttribute("graduDateStr", graduDateStr);
        } catch (NullPointerException e) {
            log.debug("缺少日期信息");
        }
        model.addAttribute("student", student);
        log.debug("出参student:"+student);
        return student;
    }

    /**
     * 公用方法 获得组学生 解析毕业日期
     *
     * @author hutengjiao
     * @date
     */
    private ReqResultExtension resolveReqStudentModel(Integer id, Model model) {
        log.debug("id:"+id);
        ReqResultExtension reqStudent = reqResultExtensionService.findReqStudentByStuId(id);
        try {
            Date graduDate = reqStudent.getGraduDate();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String graduDateStr = simpleDateFormat.format(graduDate);
            model.addAttribute("graduDateStr", graduDateStr);
        } catch (NullPointerException e) {
            log.debug("缺少日期信息");
        }
        model.addAttribute("student", reqStudent);
        log.debug("出参student:"+reqStudent);
        return reqStudent;
    }

    /**
     * 公用方法 获得正式入学学生 解析毕业日期
     *
     * @author 刘润雨
     * @date 2021-01-28 17:29:15
     */
    private Student resolveRecruitStudentModel(Integer id, Model model) {
        log.debug("id:"+id);
        Student student = recruitStudentService.findById(id);
        try {
            Date graduDate = student.getGraduDate();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String graduDateStr = simpleDateFormat.format(graduDate);
            model.addAttribute("graduDateStr", graduDateStr);
        } catch (NullPointerException e) {
            System.out.println("缺少日期信息");
        }
        model.addAttribute("student", student);
        log.debug("出参student:"+student);
        return student;
    }

    /**
     * 去招生学生详情页,传入学生ID
     *
     * @author 刘润雨
     * @date 2021-01-28 17:29:15
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/detail/{id}")
    @ApiOperation("去学生详情页")
    public String goStudentDetai(@PathVariable Integer id, Model model) {
        log.debug("id:"+id);
        model.addAttribute("id", id);
        return FebsUtil.businessesView("students/studentDetail");
    }

    /**
     * 去公海学生详情页,传入学生ID
     *
     * @author 刘润雨
     * @date 2021-01-28 17:29:15
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/poolDetail/{id}")
    @ApiOperation("去学生详情页")
    public String goPoolStudentDetai(@PathVariable Integer id, Model model) {
        log.debug("id:"+id);
        model.addAttribute("id", id);
        return FebsUtil.businessesView("students/poolStudentDetail");
    }

    /**
     * 去班主任学生详情页,传入学生ID
     *
     * @author 刘润雨
     * @date 2021-01-28 17:29:15
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "recruitStudent/detail/{id}")
    @ApiOperation("去学生详情页")
    public String goRecruitStudentDetai(@PathVariable Integer id, Model model) {
        log.debug("id:"+id);
        model.addAttribute("id", id);
        return FebsUtil.businessesView("students/recruitStudentDetail");
    }

    /**
     * 去学生报考信息申请审核页,传入学生ID
     *
     * @author 刘润雨
     * @date 2021-01-28 17:29:15
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/checkExamTask")
    @ApiOperation("去学生报考信息申请审核页")
    public String checkExamTask(Integer id, Model model) {
        log.debug("id:"+id);
        model.addAttribute("stuId", id);
        return FebsUtil.businessesView("students/checkExamTask");
    }


    /**
     * 去学生待办任务详情页,传入学生ID
     *
     * @author 刘润雨
     * @date 2021-01-28 17:29:15
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/taskDetail/{id}")
    @ApiOperation("去学生详情页")
    public String goTaskDetail(@PathVariable Integer id, Model model) {
        log.debug("id:"+id);
        model.addAttribute("id", id);
        return FebsUtil.businessesView("students/taskDetail");
    }

    /**
     * 去学生报考信息页面
     *
     * @author 刘润雨
     * @date 2021-01-28 17:29:15
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/examinfo/{id}")
    @ApiOperation("去学生报考信息页")
    public String goStudentExamInfo(@PathVariable Integer id, Model model) {
        log.debug("id:"+id);
        resolveReqStudentModel(id, model);
        //获得学习形式
        List<Dic> studyType = dicService.findDicByType("study_type");
        model.addAttribute("studyType", studyType);
        log.debug("出参studyType:"+studyType);
        return FebsUtil.businessesView("students/examInfo");
    }

    /**
     * 去正式学生的报考信息页面
     *
     * @author 刘润雨
     * @date 2021-01-28 17:29:15
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "recruitStudent/examinfo/{id}")
    @ApiOperation("去学生报考信息页")
    public String goRecruitStudentExamInfo(@PathVariable Integer id, Model model) {
        log.debug("id:"+id);
        resolveRecruitStudentModel(id, model);
        //获得学习形式
        List<Dic> studyType = dicService.findDicByType("study_type");
        model.addAttribute("studyType", studyType);
        log.debug("出参studyType:"+studyType);
        return FebsUtil.businessesView("students/recruitExamInfo");
    }

    /**
     * 去公海学生的报考信息页面
     *
     * @author 刘润雨
     * @date 2021-01-28 17:29:15
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/poolExaminfo/{id}")
    @ApiOperation("去公海学生报考信息页")
    public String goPoolStudentExamInfo(@PathVariable Integer id, Model model) {
        log.debug("id:"+id);
        resolveReqStudentModel(id, model);
        //获得学习形式
        List<Dic> studyType = dicService.findDicByType("study_type");
        model.addAttribute("studyType", studyType);
        log.debug("出参studyType:"+studyType);
        return FebsUtil.businessesView("students/poolExamInfo");
    }

    /**
     * 去学生个人信息页
     *
     * @author 刘润雨
     * @date 2021-01-28 17:29:15
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/studentinfo")
    @ApiOperation("去学生个人信息页")
    public String goStudentInfo(Integer id, Model model) {
        log.debug("id:"+id);
        resolveReqStudentModel(id, model);
        return FebsUtil.businessesView("students/studentInfo");
    }

    /**
     * 去班主任管理学生个人信息页
     *
     * @author 刘润雨
     * @date 2021-01-28 17:29:15
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "recruitStudent/studentinfo")
    @ApiOperation("去学生个人信息页")
    public String goRecruitStudentInfo(Integer id, Model model) {
        log.debug("id:"+id);
        resolveRecruitStudentModel(id, model);
        //获得学习形式
        return FebsUtil.businessesView("students/recruitStudentInfo");
    }

    /**
     * 去公海管理学生个人信息页
     *
     * @author 刘润雨
     * @date 2021-01-28 17:29:15
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/poolStudentinfo")
    @ApiOperation("去公海学生个人信息页")
    public String goPoolStudentInfo(Integer id, Model model) {
        log.debug("id:"+id);
        resolveReqStudentModel(id, model);
        return FebsUtil.businessesView("students/poolStudentInfo");
    }

    /**
     * 去学生现场确认页面
     *
     * @author 刘润雨
     * @date 2021-01-28 17:29:15
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/examlocationconfirm")
    @ApiOperation("去学生现场确认页面")
    public String goExamLocationConfirm(Integer id, Model model) {
        log.debug("id:"+id);
//是否需要审核
        int check;
        ReqResultExtension student = reqResultExtensionService.findReqStudentByStuId(id);
        Integer examLocationId = student.getExamLocationId();

        Map<String, Object> task = studentsService.findTaskByStuidAndType(id, 5);
        log.debug("task:"+task);

        if (task != null) {
            Object after_update = task.get("AFTER_UPDATE");
            try {
                JSONObject jsonObject = new JSONObject((String) after_update);
                String examLocationId1 = jsonObject.getString("examLocationId");
                check = 1;
                model.addAttribute("student", student);
                model.addAttribute("check", check);
                ConfirmAddress confirmAddress = confirmAddressService.findById(Integer.parseInt(examLocationId1));
                log.debug(confirmAddress.toString());
                int taskId = (int) task.get("ID");
                model.addAttribute("taskId", taskId);
                model.addAttribute("examLocationId", confirmAddress);
                return FebsUtil.businessesView("students/examLocationConfirm");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (examLocationId != null && examLocationId != 0) {
            log.debug("进入check2界面" + examLocationId);
            check = 2;
            model.addAttribute("student", student);
            model.addAttribute("check", check);
            ConfirmAddress confirmAddress = confirmAddressService.findById(examLocationId);
            log.debug("查到的为" + confirmAddress);
            model.addAttribute("examLocationId", confirmAddress);
            model.addAttribute("taskId", null);
            return FebsUtil.businessesView("students/examLocationConfirm");
        } else {
            check = 3;
            model.addAttribute("student", student);
            model.addAttribute("check", check);
            model.addAttribute("examLocationId", null);
            model.addAttribute("taskId", null);
            return FebsUtil.businessesView("students/examLocationConfirm");
        }

        return FebsUtil.businessesView("students/examLocationConfirm");
    }


    @GetMapping(FebsConstant.VIEW_PREFIX + "student/update/{id}")
    public String studentUpdate(@PathVariable Integer id, Model model) {
        log.debug("id:"+id);
        resolveStudentModel(id, model, false);
        return FebsUtil.businessesView("students/identityConfirm");
    }

    private void resolveStudentModel(Integer id, Model model, Boolean transform) {
        log.debug("id:"+id);
        Student student = studentsService.findStudentById(id);
        model.addAttribute("student", student);
    }

    private void resolveRecruitStudentModel(Integer id, Model model, Boolean transform) {
        log.debug("id:"+id);
        Student student = recruitStudentService.findStudentById(id);
        model.addAttribute("student", student);
    }

    /**
     * 去学生身份证确认页
     *
     * @author hutengjiao
     * @date 2021/02/01
     */
    @ApiOperation("去学生身份证确认页")
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/affirm/identity")
    public String studentAffIdentity(Integer id, Integer typeId, Model model) {
        log.debug("id:"+id+"typeId:"+typeId);
        resolveReqStudentModel(id, model);
        Map<String, Object> indenDetail = studentsService.findTaskDetail(id, typeId);
        if (indenDetail != null) {
            Set<Map.Entry<String, Object>> entries = indenDetail.entrySet();
            for (Map.Entry<String, Object> entry : entries) {
                if (entry.getKey().equals("AFTER_UPDATE")) {
                    entry.getValue();
                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject((String) entry.getValue());
                        String idenFront = jsonObject.getString("iden_Front_Img_URL");
                        String idenBack = jsonObject.getString("iden_Back_Img_URL");
                        model.addAttribute("idenFront", idenFront);
                        model.addAttribute("idenBack", idenBack);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            model.addAttribute("indetity", indenDetail);
            log.debug("出参indenDetail:"+indenDetail);
        }
        return FebsUtil.businessesView("students/identityConfirm");
    }

    /**
     * @author hutengjiao
     * @date 2021/02/01
     */
    @ApiOperation("去学生照片确认页")
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/affirm/photo")
    public String studentAffPhoto(Integer id, Integer typeId, Model model) {
        log.debug("id:"+id+"typeId:"+typeId);
        resolveReqStudentModel(id, model);
        Map<String, Object> photoDetail = studentsService.findTaskDetail(id, typeId);
        log.debug("出参photoDetail:"+photoDetail);
        if (photoDetail != null) {
            Set<Map.Entry<String, Object>> entries = photoDetail.entrySet();
            for (Map.Entry<String, Object> entry : entries) {
                if (entry.getKey().equals("AFTER_UPDATE")) {
                    entry.getValue();
                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject((String) entry.getValue());
                        String headImgUrl = jsonObject.getString("Head_Img_Url");
                        model.addAttribute("photo", headImgUrl);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return FebsUtil.businessesView("students/photoConfirm");
    }

    /**
     * @author hutengjiao
     * @date 2021/02/01
     */
    @ApiOperation("去毕业证确认页")
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/affirm/diploma")
    public String studentAffDiploma(Integer id, Integer typeId, Model model) {
        log.debug("id:"+id+"typeId:"+typeId);
        resolveReqStudentModel(id, model);
        Map<String, Object> diplomaDetail = studentsService.findTaskDetail(id, typeId);
        log.debug("出参diplomaDetail:"+diplomaDetail);
        if (diplomaDetail != null) {
            Set<Map.Entry<String, Object>> entries = diplomaDetail.entrySet();
            for (Map.Entry<String, Object> entry : entries) {
                if (entry.getKey().equals("AFTER_UPDATE")) {
                    entry.getValue();
                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject((String) entry.getValue());
                        String diplomaImgUrl = jsonObject.getString("Diploma_Img_Url");
                        model.addAttribute("diploma", diplomaImgUrl);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return FebsUtil.businessesView("students/diplomaConfirm");
    }

    /**
     * 去学生缴费信息页
     *
     * @author 刘润雨
     * @date 2021-01-28 17:29:15
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/cost")
    @ApiOperation("去学生缴费信息页")
    public String cost(Integer id, Model model) {
        log.debug("id:"+id);
        resolveReqStudentModel(id, model);
        //获得学习形式
        return FebsUtil.businessesView("students/payDetail");
    }

    /**
     * 去班主任学生管理学生缴费信息页
     *
     * @author 刘润雨
     * @date 2021-01-28 17:29:15
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "recruitStudent/cost")
    @ApiOperation("去学生缴费信息页")
    public String recruitCost(Integer id, Model model) {
        log.debug("id:"+id);
        resolveRecruitStudentModel(id, model);
        //获得学习形式
        return FebsUtil.businessesView("students/recruitPayDetail");
    }

    /**
     * 去学生学习详情信息页
     *
     * @author hutengjiao
     * @date 2021/02/01
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/studyInfo")
    @ApiOperation("去学生学习详情信息页")
    public String studyInfo(Integer id, Model model) {
        log.debug("id:"+id);
        List<CollegeTerm> term = homeworkService.findTermByStuid(id);
        model.addAttribute("term", term);
        log.debug("出参term:"+term);
        resolveStudentModel(id, model);
        return FebsUtil.businessesView("students/studyDetail");
    }

    /**
     * 去班主任学生管理学习详情信息页
     *
     * @author hutengjiao
     * @date 2021/02/01
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "recruitStudent/studyInfo")
    @ApiOperation("去班主任学生管理学习详情信息页")
    public String recruitStudyInfo(Integer id, Model model) {
        log.debug("id:"+id);
        List<CollegeTerm> term = homeworkService.findTermByStuid(id);
        model.addAttribute("term", term);
        log.debug("出参term:"+term);
        resolveRecruitStudentModel(id, model);
        return FebsUtil.businessesView("students/recruitStudyDetail");
    }

    /**
     * 刘润雨结束
     **/

	/*
    *
    * 裴昊东
    *
    * */
    @GetMapping(FebsConstant.VIEW_PREFIX + "reqInfo/list")
//    @RequiresPermissions("college:view")
    public String reqInfo() {
        return FebsUtil.businessesView("reqInfo/reqInfo");
    }


    @GetMapping(FebsConstant.VIEW_PREFIX + "reqInfo/test")
//    @RequiresPermissions("college:view")
    public ModelAndView reqInfo(ModelAndView modelAndView) {
//        modelAndView.setViewName("forward:/reqInfo/test");
        modelAndView.setViewName("forward:/studentpool/add");
        return modelAndView;
    }


    /*
     *  李旭
     *
     * */

    private final IResolveExceptionService resolveExceptionService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "resolveException/list")
//    @RequiresPermissions("college:view")
    public String resolveException() {
        return FebsUtil.businessesView("resolveException/resolveException");
    }


    @GetMapping(FebsConstant.VIEW_PREFIX + "resolveException/detail/{id}")
//    @RequiresPermissions("college:view")
    public String resolveExceptionDetail(@PathVariable Integer id, Model model) {
        resolveExceptionModel(id, model, true);
        return FebsUtil.businessesView("resolveException/resolveExceptionDetail");
    }

    private void resolveExceptionModel(Integer id, Model model, Boolean transform) {
        ResolveException resolveException = resolveExceptionService.findById(id);
        if (resolveException.getExceptionTime() != null) {
            model.addAttribute("exceptionTime", DateUtil.getDateFormat(resolveException.getExceptionTime(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        }
        model.addAttribute("resolveException", resolveException);
    }

    //********************************李文龙印章跳转区间********************************************

    /**
     * 印章跳转主页面
     *
     * @author guozhaodi
     * @date 2021-01-27 09:56:39     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "seal/list")
    @RequiresPermissions("seal:view")
    public String seal() {
        return FebsUtil.businessesView("seal/seal");
    }

    @GetMapping(FebsConstant.VIEW_PREFIX + "seal/add")
    public String sealAdd() {
        return FebsUtil.businessesView("seal/sealAdd");
    }


    /**
     * 用于添加功能信息中的返回
     *
     * @param id
     * @param model 用于添加功能信息中的返回
     * @param id
     * @param model
     * @return
     * @author guozhaodi
     * @date 2021-01-27 09:56:39
     * 用于添加功能信息中的返回
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "seal/detail/{id}")
    public String sealdetail(@PathVariable Integer id, Model model) {
        System.out.println("ViewController.sealdetail" + id);
        resolveSealModel(id, model, false);
        return FebsUtil.businessesView("seal/sealUpdate");
    }

    /**
     * 查看详细功能的
     *
     * @param model
     * @return
     * @author guozhaodi
     * @date 2021-01-27 09:56:39     * @param id
     */

    @GetMapping(FebsConstant.VIEW_PREFIX + "seal/details/{id}")
    public String sealdetails(@PathVariable Integer id, Model model) {
        resolveSealModel(id, model, false);
        return FebsUtil.businessesView("seal/sealDetail");
    }

    /**
     * @param model
     * @param transform
     * @author guozhaodi
     * @date 2021-01-27 09:56:39
     * * @param id
     */
    private void resolveSealModel(Integer id, Model model, Boolean transform) {
        College college = sealService.findSealById(id);
        model.addAttribute("college", college);
    }


    //********************************李文龙印章跳转区间********************************************


    //********************************刘恒start********************************************

    /**
     * @return
     * @author liuheng
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "transferApplication/list")
    @RequiresPermissions("transferApplication:view")
    public String transferApplication() {
        return FebsUtil.businessesView("transferApplication/transferApplication");
    }

    /**
     * 通过id获取异动记录，获取异动类型id，跳转不同异动详情页面
     *
     * @param id
     * @param model
     * @return
     * @author liuheng
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "transferApplication/update/{id}")
    public String transferApplicationUpdate(@PathVariable Integer id, Model model) {
        int transferTypeId = resolveTransferApplicationModel(id, model, true);
        if (transferTypeId == dicService.findDicId("change_type", 1)) {
            return FebsUtil.businessesView("transferApplication/suspensionCollegeDetail");
        } else if (transferTypeId == dicService.findDicId("change_type", 2)) {
            return FebsUtil.businessesView("transferApplication/backCollegeDetail");
        } else if (transferTypeId == dicService.findDicId("change_type", 3)) {
            return FebsUtil.businessesView("transferApplication/dropOutDetail");
        } else if (transferTypeId == dicService.findDicId("change_type", 4)) {
            return FebsUtil.businessesView("transferApplication/majorChangeDetail");
        } else {
            return FebsUtil.businessesView("transferApplication/studyTypeChangeDetail");
        }
    }


    //li

    /**
     * @param id 学生组id
     * @description: 跳转：分组页面
     * @return: html页面路径
     * @author: LiPeng
     * @date: 2021/2/1
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "group/grouping/{id}")
    @RequiresPermissions("studentGroup:view")
    public String grouping(@PathVariable Integer id, Model model) {
        log.debug("跳转页面携带的学生组id：" + id);
        model.addAttribute("id", id);
        return FebsUtil.businessesView("group/grouping");
    }

    /**
     * @Description: 跳转：分班页面
     * @return: html页面路径
     * @author: LiPeng
     * @date: 2021/2/1
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "class/classGrouping/{id}")
    @RequiresPermissions("class:view")
    public String classGrouping(@PathVariable Integer id, Model model) {
        System.out.println("学生组id：" + id);
        model.addAttribute("id", id + 1000000);
        return FebsUtil.businessesView("class/classGrouping");
    }

    /**
     * @Description: 跳转：班级详情页面
     * @Param: classId 班级id
     * @return: html页面路径
     * @author: LiPeng
     * @date: 2021/2/1
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "class/detail/{classId}")
    public String classDetail(@PathVariable Integer classId, Model model) {
        resolveClassModel(classId, model, true);
        return FebsUtil.businessesView("class/classDetail");
    }

    /**
     * @Description: 根据班级id查询班级信息
     * @Param: classId 班级id；model 模板对象，用来向前端传递数据
     * @author: LiPeng
     * @date: 2021/2/1
     */
    private void resolveClassModel(Integer classId, Model model, Boolean transform) {
        Classes classes = this.classesService.findClassesById(classId);
        if (classes.getCreateTime() != null) {
            model.addAttribute("createDateTime", DateUtil.getDateFormat(classes.getCreateTime(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        }
        model.addAttribute("classes", classes);
    }

    /**
     * @Description: 跳转：复学操作页面
     * @Param: studentId 学生id；model 模板对象，用来向前端传递数据
     * @return: html页面
     * @author: LiPeng
     * @date: 2021/2/1
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/backCollege/{studentId}")
    public String backCollege(@PathVariable Integer studentId, Model model) {
        resolveRecruitStudentModel(studentId, model);
        return FebsUtil.businessesView("students/backCollege");
    }

    //hou

    /**
     * 从学生列表页面（班主任）跳转到更换学生专业页面
     *
     * @return html页面
     * @author houweikang
     * @date 2021/2/4
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "stuMajor/update/{studentId}")
    public String stuMajorUpdate(@PathVariable Integer studentId, Model model) {
        resolveRecruitStudentModel(studentId, model);
        return FebsUtil.businessesView("class/stuMajorUpdate");
    }

    /**
     * @return html页面
     * @Description 从班级页面跳转到班级增加页面
     * @author houweikang
     * @date 2021/2/2
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "class/add")
    public String classAdd() {
        return FebsUtil.businessesView("class/classAdd");
    }

    /**
     * @return html页面
     * @Description 跳转到班级列表页面
     * @author houweikang
     * @date 2021/2/2
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "classes/list")
    @RequiresPermissions("class:view")
    public String classes() {
        return FebsUtil.businessesView("class/class");
    }

    /**
     * @return html页面
     * @Description 从学生组页面跳转到增加学生组页面
     * @author houweikang
     * @date 2021/2/2
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "group/add")
    public String groupAdd() {
        return FebsUtil.businessesView("group/groupAdd");
    }

    /**
     * @return html页面
     * @Description 跳转到学生组页面
     * @author houweikang
     * @date 2021/2/2
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "studentGroup/list")
    @RequiresPermissions("studentGroup:view")
    public String group() {
        return FebsUtil.businessesView("group/group");
    }

    /**
     * @param id    班级id
     * @param model
     * @return html页面
     * @Description 跳转到跟换班主任页面
     * @author houweikang
     * @date 2021/2/2
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "teacher/update/{id}")
    public String teacherUpdate(@PathVariable Integer id, Model model) {
        resolveTeacherModel(id, model, false);
        return FebsUtil.businessesView("class/teacherUpdate");
    }

    /**
     * @param id
     * @param model
     * @param transform s
     * @return
     * @Description 获取班级的详细信息发送到页面
     * @author houweikang
     * @date 2021/2/2
     */
    private void resolveTeacherModel(Integer id, Model model, Boolean transform) {
        Classes classes = classesService.findById(id);
        if (classes.getCreateTime() != null) {
            model.addAttribute("createTime", DateUtil.getDateFormat(classes.getCreateTime(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        }
        model.addAttribute("classes", classes);
    }

    /**
     * @param id
     * @param model
     * @param transform
     * @return
     * @author liuheng
     */
    private Integer resolveTransferApplicationModel(Integer id, Model model, Boolean transform) {
        TransferApplicationVo transferApplication = transferApplicationService.findTransferDetailById(id);
        model.addAttribute("transferApplication", transferApplication);
        return transferApplication.getTransferTypeId();
    }


    //********************************刘恒end********************************************

    //********************************夏凯start********************************************
    @GetMapping(FebsConstant.VIEW_PREFIX + "video/list")
    public String video() {
        return FebsUtil.businessesView("video/video");
    }

    @GetMapping(FebsConstant.VIEW_PREFIX + "video/add")
    public String videoadd() {
        return FebsUtil.businessesView("video/videoAdd");
    }

    @GetMapping(FebsConstant.VIEW_PREFIX + "video/update/{id}")
    public String videoUpdate(@PathVariable Integer id, Model model) {
        resolveVideoModelUpdate(id, model, false);
        return FebsUtil.businessesView("video/videoUpdate");
    }

    @GetMapping(FebsConstant.VIEW_PREFIX + "video/updateSort/{id}")
    public String updateBySort(@PathVariable Integer id, Model model) {
        resolveVideoModel(id, model, false);
        return FebsUtil.businessesView("video/videoSort");
    }

    private void resolveVideoModel(@PathVariable Integer id, Model model, Boolean transform) {
        Video video = videoService.findById(id);
        List<Integer> sortList = videoService.selectSortList();
        model.addAttribute("sortList", sortList);
        model.addAttribute("video", video);
    }

    @GetMapping(FebsConstant.VIEW_PREFIX + "cType/add")
    public String cTypeAdd() {
        return FebsUtil.businessesView("video/cTypeAdd");
    }

    @GetMapping(FebsConstant.VIEW_PREFIX + "cType/list")

    public String cType() {
        return FebsUtil.businessesView("video/cType");
    }

    @GetMapping(FebsConstant.VIEW_PREFIX + "cType/sort/{id}")

    public String cTypeSort(@PathVariable Integer id, Model model, Boolean transform) {
        resolveCTypeModel1(id, model, false);
        return FebsUtil.businessesView("video/cTypeSort");
    }

    private void resolveCTypeModel1(@PathVariable Integer id, Model model, Boolean transform) {
        List<Integer> sort2List = cTypeService.selectSort2ByPid(id);
        CType cType = cTypeService.findById(id);

        if (cType.getCreateTime() != null) {
            model.addAttribute("createTime", DateUtil.getDateFormat(cType.getCreateTime(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        }
        if (cType.getUpdateTime() != null) {
            model.addAttribute("updateTime", DateUtil.getDateFormat(cType.getUpdateTime(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        }
        model.addAttribute("cType", cType);
        model.addAttribute("sort2List", sort2List);
    }

    private void resolveCTypeModel(@PathVariable Integer id, Model model, Boolean transform) {
        CType cType = cTypeService.findById(id);

        if (cType.getCreateTime() != null) {
            model.addAttribute("createTime", DateUtil.getDateFormat(cType.getCreateTime(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        }
        if (cType.getUpdateTime() != null) {
            model.addAttribute("updateTime", DateUtil.getDateFormat(cType.getUpdateTime(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        }
        model.addAttribute("cType", cType);
    }

    private void resolveVideoModelUpdate(Integer id, Model model, Boolean transform) {
        Video video = videoService.findById(id);
        int typeId = videoService.findTypeIdByVid(id);
        String typeName = video.getTypeName();
        String typeNameRe = null;
        if (typeName != null) {
            typeName.replaceAll("└", "");
        }
        video.setTypeName(typeNameRe);
        model.addAttribute("video", video);
        model.addAttribute("typeId", typeId);
    }

    private void resolveVideoModel1(Integer id, Model model, Boolean transform) {
        Video video = videoService.findById(id);
        //int typeId = videoService.findTypeIdByVid(id);
        String typeName = video.getTypeName();
        String typeNameRe = null;
        if (typeName != null) {
            typeNameRe = typeName.replaceAll("└", "");
        }
        video.setTypeName(typeNameRe);
        model.addAttribute("video", video);
        //model.addAttribute("typeId", typeId);
    }

    @GetMapping(FebsConstant.VIEW_PREFIX + "video/detail/{id}")
    public String videoDetail(@PathVariable Integer id, Model model) {
        resolveVideoModel1(id, model, false);
        return FebsUtil.businessesView("video/videoDetail");
    }

    @GetMapping(FebsConstant.VIEW_PREFIX + "cType/update/{id}")
    public String cTypeUpdate(@PathVariable Integer id, Model model) {
        resolveCTypeModel(id, model, false);
        return FebsUtil.businessesView("video/cTypeUpdate");
    }

    //********************************夏凯end********************************************


}
