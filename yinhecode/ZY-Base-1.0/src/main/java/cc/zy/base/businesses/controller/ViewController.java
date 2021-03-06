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
     * ???????????????????????????
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "papers/list")
    @RequiresPermissions("papers:view")
    public String papers() {
        return FebsUtil.businessesView("paper/papers");
    }


    /**
     * @author huangjia
     * @date 2021-01-27 10:56:39
     * ?????????????????????????????????
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
     * ??????????????????????????????
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
     * ??????????????????????????????
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
     * ????????????????????????
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
     * ????????????????????????
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
     * ????????????????????????
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
     * ????????????????????????
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
     * ????????????????????????
     */
    private void resolveEntranceScoreModel(Integer id, Model model, Boolean transform) {
        System.out.println(id);
        //??????id????????????????????????
        EntranceScore entranceScoreById = entranceScoreService.getEntranceById(id);
        System.out.println(entranceScoreById);
        //???????????????????????????????????????????????????
        EntranceScore scoreInfo = entranceScoreService.getEntranceScoreInfo(entranceScoreById);
        System.out.println(scoreInfo.getRemark());
        //??????????????????????????????????????????????????????
        List<EntranceScore> scores = entranceScoreService.getEntranceScoreByIds(entranceScoreById);

        scoreInfo.setScores(scores);
        model.addAttribute("entranceScore", scoreInfo);
    }

    /**
     * @return
     * @author wangpin
     * @date 2021/02/04
     * ??????????????????????????????
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "entranceScore/errorResult")
    public String getErrorLog() {
        System.out.println("????????????");
        return FebsUtil.businessesView("score/entranceExportResult");
    }

    /**
     * ???????????????
     * ????????????????????????
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
     * ????????????????????????
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "teachProgram/add")
//    @RequiresPermissions("teachProgram:view")
    public String teachProgramAdd() {

        return FebsUtil.businessesView("teachProgram/teachProgramAdd");
    }

    /**
     * ????????????????????????
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
     * ???????????????
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
//********************************??????????????????************************************

    /**
     * standardFeeIndex
     * ????????????????????????
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
     * ????????????????????????
     *
     * @author guankai
     * @date 2021-02-01 18:07
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "standardFee/add")

    public String standardFeeAdd() {
        return FebsUtil.businessesView("standardFee/standardFeeAdd");
    }


    /**
     * ??????????????????????????????
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
        System.out.println("??????????????????????????????");
        resolveStandardFeeModel(id, model, false);
        return FebsUtil.businessesView("standardFee/standardFeeUpdate");
    }


    private void resolveStandardFeeModel(Integer id, Model model, Boolean transform) {

        StandardFee standardFee = standardFeeService.findById(id);


        model.addAttribute("standardFee", standardFee);
    }
    //*******************************??????????????????*************************************

    //********************************???????????????????????????************************************

    /**
     * ?????????????????????????????????
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
     * ?????????????????????????????????
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
        System.out.println("???????????????????????????????????????");

        resolveCustomStandardFeeModel(id, model, false);

        return FebsUtil.businessesView("customStandardFee/customStandardFeeUpdate");
    }


    private void resolveCustomStandardFeeModel(Integer id, Model model, Boolean transform) {

        CustomStandardFee customStandardFee = customStandardFeeService.findById(id);

        model.addAttribute("customStandardFee", customStandardFee);
    }
    //*******************************???????????????????????????*************************************
//***********************************??????????????????*************************************


    /**
     * ????????????????????????
     *
     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "otherPayment/list")
    @RequiresPermissions("otherPayment:view")
    public String otherPaymentIndex() {
        return FebsUtil.businessesView("otherPayment/otherPayment");
    }

    /**
     * ????????????????????????
     *
     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "otherPayment/update/{id}")
    public String otherPaymentUpdate(@PathVariable Integer id, Model model) {
        System.out.println("??????????????????????????????");
        resolveOtherPaymentModel(id, model, false);
        return FebsUtil.businessesView("otherPayment/otherPaymentUpdate");
    }

    /**
     * ????????????????????????
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
     * ????????????????????????
     *
     * @author guankai
     * @date 2021-01-28 17:29:15
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "otherPayment/addOtherPayment/{id}")
    @ApiOperation("??????????????????")
    public String addOtherPayment(@PathVariable Integer id, Model model) {
        Student student = studentsService.findById(id);
        model.addAttribute("student", student);
        return FebsUtil.businessesView("otherPayment/OtherPaymentAdd");
    }


    private void resolveOtherPaymentModel(Integer id, Model model, Boolean transform) {

        System.out.println("????????????????????????");

        OtherPayment otherPayment = otherPaymentService.findById(id);

        model.addAttribute("otherPayment", otherPayment);
    }

    //***********************************??????????????????*************************************


    /**
     * linan??????
     **/
//    private final IConfirmAddressService confirmAddressService;

    /**
     * ??????????????????
     *
     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "confirmAddress/list")
//    @RequiresPermissions("confirmAddress:view")
    public String confirmAddress() {
        return FebsUtil.businessesView("confirmAddress/confirmAddress");
    }

    /**
     * ?????????????????????
     *
     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "confirmAddress/add")
    public String confirmAddressAdd() {
        return FebsUtil.businessesView("confirmAddress/confirmAddressAdd");
    }

    /**
     * ????????????????????????
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
     * ??????id????????????????????????
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
     * ????????????????????????
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
     * ??????????????????????????????
     *
     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "homePage/list")
//    @RequiresPermissions("homePage:view")
    public String homePage() {
        return FebsUtil.businessesView("homePage/homePage");
    }

    /**
     * ????????????????????? batch
     */

    @GetMapping(FebsConstant.VIEW_PREFIX + "batch/list")
//    @RequiresPermissions("confirmAddress:view")
    public String batch() {
        return FebsUtil.businessesView("batch/batch");
    }

    /**
     * ?????????????????????
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
     * ?????????????????????
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


    /**linan??????**/
    /**
     * linan??????
     **/

    /*????????????-lijian*/
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
    /**????????????**/

    /**
     * ???????????????
     **/
    private final IUserService userService;

    //??????selectStudent??????
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/list")
    public String student() {
        return FebsUtil.businessesView("students/selectStudent");
    }

    //?????????noticeAdd??????
    @GetMapping(FebsConstant.VIEW_PREFIX + "notice/add")
    public String noticeAdd(Model model) {
        User principal = userService.findByName(getCurrentUser().getUsername());
        model.addAttribute("username", principal.getUsername());//?????????noticeAdd??????
        model.addAttribute("userId", principal.getUserId());//?????????noticeAdd??????
        return FebsUtil.businessesView("notice/noticeAdd");
    }
    /**???????????????**/

    /**
     * ???????????????
     **/
    private final ICorrespondenceCollegeService correspondenceCollegeService;
    private final IProvinceService provinceService;

    /**
     * ??????????????????????????????
     *
     * @author zhaojw
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "correspondenceCollege/add")
    @RequiresPermissions("college:view")
    public String countCorrespondenceCollegeAdd() {
        return FebsUtil.businessesView("correspondenceCollege/correspondenceCollegeAdd");
    }

    /**
     * ??????????????????????????????
     *
     * @author zhaojw     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "correspondenceCollege/list")
    @RequiresPermissions("college:view")
    public String countCorrespondenceCollege() {
        return FebsUtil.businessesView("correspondenceCollege/correspondenceCollege");
    }

    /**
     * ????????????????????????????????????
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
     * ??????????????????????????????
     *
     * @author zhaojw     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "correspondenceCollege/update/{id}")
    public String correspondenceCollegeUpdate(@PathVariable Integer id, Model model) {
        resolvecorrespondenceUpdateModel(id, model, false);
        return FebsUtil.businessesView("correspondenceCollege/correspondenceCollegeUpdate");
    }

    /**
     * ???????????????????????????
     *
     * @author zhaojw     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "advertLog/list")
    @RequiresPermissions("college:view")
    public String countAdvertLog() {
        return FebsUtil.businessesView("advert/advertLog");
    }

    /**
     * ??????????????????
     *
     * @param id        ?????????id
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
     * ?????????????????????????????????
     *
     * @param id        ?????????id     * @param model
     * @param transform
     * @author zhaojw
     */
    private void resolvecorrespondenceUpdateModel(Integer id, Model model, Boolean transform) {
        CorrespondenceCollege correspondenceCollege = correspondenceCollegeService.findCorrespondenceCollegeById(id);
        model.addAttribute("correspondenceCollege", correspondenceCollege);
    }
    /**???????????????**/

    /**
     * ???????????????
     **/
    private final ISubjectCategoryService subjectCategoryService;
    private final IMajorService majorService;

    //??????????????????
    @GetMapping(FebsConstant.VIEW_PREFIX + "subjectCategory/list")
//    @RequiresPermissions("subjectCategory:view")
    public String subjectCategory() {
        return FebsUtil.businessesView("subjectCategory/subjectCategory");
    }

    //??????????????????
    @GetMapping(FebsConstant.VIEW_PREFIX + "subjectCategory/update/{id}")
    public String subjectCategoryUpdate(@PathVariable Integer id, Model model) {
        resolveSubjectCategoryModel(id, model, false);
        return FebsUtil.businessesView("subjectCategory/subjectCategoryUpdate");
    }

    //??????????????????
    @GetMapping(FebsConstant.VIEW_PREFIX + "subjectCategory/add")
    public String subjectCategoryAdd(Model model) {
        User principal = userService.findByName(getCurrentUser().getUsername());
        model.addAttribute("user", principal);
        return FebsUtil.businessesView("subjectCategory/subjectCategoryAdd");
    }

    //??????findById
    private void resolveSubjectCategoryModel(Integer id, Model model, boolean b) {
        SubjectCategory subjectCategory = subjectCategoryService.findById(id);

        if (subjectCategory.getCreateTime() != null) {
            model.addAttribute("createDateTime", DateUtil.getDateFormat(subjectCategory.getCreateTime(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        }
        model.addAttribute("subjectCategory", subjectCategory);
    }

    //??????????????????
    @GetMapping(FebsConstant.VIEW_PREFIX + "subjectCategory/detail/{id}")
    @RequiresPermissions("user:view")
    public String subjectCategoryDetail(@PathVariable Integer id, Model model) {
        resolveSubjectCategoryModel(id, model, true);
        return FebsUtil.businessesView("subjectCategory/subjectCategoryDetail");
    }


    //??????????????????
    @GetMapping(FebsConstant.VIEW_PREFIX + "major/list")
//    @RequiresPermissions("major:view")
    public String major() {
        return FebsUtil.businessesView("major/major");
    }

    //??????????????????
    @GetMapping(FebsConstant.VIEW_PREFIX + "major/update/{id}")
    public String majorUpdate(@PathVariable Integer id, Model model) {
        resolveMajorModel(id, model, false);
        return FebsUtil.businessesView("major/majorUpdate");
    }

    //??????????????????
    @GetMapping(FebsConstant.VIEW_PREFIX + "major/add")
    public String majorAdd(Model model) {
        User principal = userService.findByName(getCurrentUser().getUsername());
        model.addAttribute("user", principal);
        return FebsUtil.businessesView("major/majorAdd");
    }

    //??????????????????
    @GetMapping(FebsConstant.VIEW_PREFIX + "major/detail/{id}")
    @RequiresPermissions("user:view")
    public String majorDetail(@PathVariable Integer id, Model model) {
        resolveMajorModel(id, model, true);
        return FebsUtil.businessesView("major/majorDetail");
    }

    //????????????findById
    private void resolveMajorModel(Integer id, Model model, boolean b) {
        Major major = majorService.findById(id);
        System.out.println(major);
        if (major.getCreateTime() != null) {
            model.addAttribute("createDateTime", DateUtil.getDateFormat(major.getCreateTime(), DateUtil.FULL_TIME_SPLIT_PATTERN));
        }
        model.addAttribute("major", major);
    }
    /**???????????????**/

    /**
     * ???????????????
     **/
    /**
     * ????????????????????????
     *
     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "businesses/user")
    public String systemUser() {
        return FebsUtil.view("system/user/selectUser");
    }

    /**
     * ????????????????????????
     *
     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "businesses/Notice")
    public String Notice() {
        return FebsUtil.businessesView("notice/notice");
    }

    /**
     * ??????????????????
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
     * ????????????
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
     * ??????????????????
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
        //list??????????????????
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
     * ??????????????????
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

    /**???????????????**/

    /**
     * ???????????????
     **/
    @ApiOperation("????????????view")
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/todolist")
    public String students(Model model) {
        log.debug("??????????????????");
        User user = getCurrentUser();
        model.addAttribute("user", user);
        return FebsUtil.businessesView("students/studentsList");
    }

    /**
     * ??????????????????????????????????????????
     *
     * @author hutengjiao
     * @date 2021/02/01
     */
    private void resolveRecycleModel(Integer id, Model model) {
        Recycle recycle = recycleService.findById(id);
        model.addAttribute("student", recycle);
    }


    @ApiOperation("????????????view")
    @GetMapping(FebsConstant.VIEW_PREFIX + "seastu/list")
    public String seastu(Model model) {
        log.debug("??????????????????");
        User user = getCurrentUser();
        model.addAttribute("user", user);
        return FebsUtil.businessesView("students/seaStudentsList");
    }

    @ApiOperation("??????????????????view")
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/studentLog")
    public String studentLog(Model model) {
        log.debug("????????????????????????");
        User user = getCurrentUser();
        model.addAttribute("user", user);
        return FebsUtil.businessesView("students/studentLog");
    }

    @ApiOperation("???????????????view")
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/recruitlist")
    public String recruitlist(Model model) {
        User user = getCurrentUser();
        model.addAttribute("user", user);
        return FebsUtil.businessesView("students/recruitStudentsList");
    }


    /**
     *  ????????????????????????????????????
     *
     * @author ?????????
     * @date 2021-01-28 17:29:15
     */
    @ApiOperation("??????????????????view")
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/goUserTaskList/{userId}")
    public String goUserTaskList(@PathVariable Integer userId, Model model) {
        log.debug("userId:"+userId);
        model.addAttribute("userId", userId);
        return FebsUtil.businessesView("students/userTaskList");
    }

    @ApiOperation("???????????????view")
    @GetMapping(FebsConstant.VIEW_PREFIX + "recycle/list")
    public String recycleList() {
        return FebsUtil.businessesView("recycle/recycleList");
    }

    /**
     * ?????????????????????
     *
     * @author hutengjiao
     * @date 2021/02/01
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "recycle/detail/{id}")
    @ApiOperation("?????????????????????")
    public String goRecycleDetai(@PathVariable Integer id, Model model) {
        log.debug("id:"+id);
        model.addAttribute("id", id);
        return FebsUtil.businessesView("recycle/recycleDetail");
    }

    /**
     * ?????????????????????????????????
     *
     * @author hutengjiao
     * @date 2021/02/01
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "recycle/recycleExaminfo")
    @ApiOperation("?????????????????????????????????")
    public String goRecycleExamInfo(Integer id, Model model) {
        log.debug("id:"+id);
        resolveRecycleModel(id, model);
        //??????????????????
        List<Dic> studyType = dicService.findDicByType("study_type");
        log.debug("??????studyType:"+studyType);
        model.addAttribute("studyType", studyType);
        return FebsUtil.businessesView("recycle/recycleExamInfo");
    }

    /**
     * ?????????????????????????????????
     *
     * @author hutengjiao
     * @date 2021/02/01
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "recycle/recInfo")
    @ApiOperation("?????????????????????????????????")
    public String goRecycleInfo(Integer id, Model model) {
        resolveRecycleModel(id, model);
        //??????????????????
        return FebsUtil.businessesView("recycle/recycleInfo");
    }

    @ApiOperation("????????????view")
    @GetMapping(FebsConstant.VIEW_PREFIX + "recycle/label")
    public String recLabelAdd() {
        return FebsUtil.businessesView("recycle/recycleLabelAdd");
    }

    @ApiOperation("????????????view")
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/label")
    public String stuLabelAdd() {
        return FebsUtil.businessesView("students/studentLabelAdd");
    }

    /**
     * ???????????? ?????????????????? ??????????????????
     *
     * @author ?????????
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
            log.debug("??????????????????");
        }
        model.addAttribute("student", student);
        log.debug("??????student:"+student);
        return student;
    }

    /**
     * ???????????? ??????????????? ??????????????????
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
            log.debug("??????????????????");
        }
        model.addAttribute("student", reqStudent);
        log.debug("??????student:"+reqStudent);
        return reqStudent;
    }

    /**
     * ???????????? ???????????????????????? ??????????????????
     *
     * @author ?????????
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
            System.out.println("??????????????????");
        }
        model.addAttribute("student", student);
        log.debug("??????student:"+student);
        return student;
    }

    /**
     * ????????????????????????,????????????ID
     *
     * @author ?????????
     * @date 2021-01-28 17:29:15
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/detail/{id}")
    @ApiOperation("??????????????????")
    public String goStudentDetai(@PathVariable Integer id, Model model) {
        log.debug("id:"+id);
        model.addAttribute("id", id);
        return FebsUtil.businessesView("students/studentDetail");
    }

    /**
     * ????????????????????????,????????????ID
     *
     * @author ?????????
     * @date 2021-01-28 17:29:15
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/poolDetail/{id}")
    @ApiOperation("??????????????????")
    public String goPoolStudentDetai(@PathVariable Integer id, Model model) {
        log.debug("id:"+id);
        model.addAttribute("id", id);
        return FebsUtil.businessesView("students/poolStudentDetail");
    }

    /**
     * ???????????????????????????,????????????ID
     *
     * @author ?????????
     * @date 2021-01-28 17:29:15
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "recruitStudent/detail/{id}")
    @ApiOperation("??????????????????")
    public String goRecruitStudentDetai(@PathVariable Integer id, Model model) {
        log.debug("id:"+id);
        model.addAttribute("id", id);
        return FebsUtil.businessesView("students/recruitStudentDetail");
    }

    /**
     * ????????????????????????????????????,????????????ID
     *
     * @author ?????????
     * @date 2021-01-28 17:29:15
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/checkExamTask")
    @ApiOperation("????????????????????????????????????")
    public String checkExamTask(Integer id, Model model) {
        log.debug("id:"+id);
        model.addAttribute("stuId", id);
        return FebsUtil.businessesView("students/checkExamTask");
    }


    /**
     * ??????????????????????????????,????????????ID
     *
     * @author ?????????
     * @date 2021-01-28 17:29:15
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/taskDetail/{id}")
    @ApiOperation("??????????????????")
    public String goTaskDetail(@PathVariable Integer id, Model model) {
        log.debug("id:"+id);
        model.addAttribute("id", id);
        return FebsUtil.businessesView("students/taskDetail");
    }

    /**
     * ???????????????????????????
     *
     * @author ?????????
     * @date 2021-01-28 17:29:15
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/examinfo/{id}")
    @ApiOperation("????????????????????????")
    public String goStudentExamInfo(@PathVariable Integer id, Model model) {
        log.debug("id:"+id);
        resolveReqStudentModel(id, model);
        //??????????????????
        List<Dic> studyType = dicService.findDicByType("study_type");
        model.addAttribute("studyType", studyType);
        log.debug("??????studyType:"+studyType);
        return FebsUtil.businessesView("students/examInfo");
    }

    /**
     * ????????????????????????????????????
     *
     * @author ?????????
     * @date 2021-01-28 17:29:15
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "recruitStudent/examinfo/{id}")
    @ApiOperation("????????????????????????")
    public String goRecruitStudentExamInfo(@PathVariable Integer id, Model model) {
        log.debug("id:"+id);
        resolveRecruitStudentModel(id, model);
        //??????????????????
        List<Dic> studyType = dicService.findDicByType("study_type");
        model.addAttribute("studyType", studyType);
        log.debug("??????studyType:"+studyType);
        return FebsUtil.businessesView("students/recruitExamInfo");
    }

    /**
     * ????????????????????????????????????
     *
     * @author ?????????
     * @date 2021-01-28 17:29:15
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/poolExaminfo/{id}")
    @ApiOperation("??????????????????????????????")
    public String goPoolStudentExamInfo(@PathVariable Integer id, Model model) {
        log.debug("id:"+id);
        resolveReqStudentModel(id, model);
        //??????????????????
        List<Dic> studyType = dicService.findDicByType("study_type");
        model.addAttribute("studyType", studyType);
        log.debug("??????studyType:"+studyType);
        return FebsUtil.businessesView("students/poolExamInfo");
    }

    /**
     * ????????????????????????
     *
     * @author ?????????
     * @date 2021-01-28 17:29:15
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/studentinfo")
    @ApiOperation("????????????????????????")
    public String goStudentInfo(Integer id, Model model) {
        log.debug("id:"+id);
        resolveReqStudentModel(id, model);
        return FebsUtil.businessesView("students/studentInfo");
    }

    /**
     * ???????????????????????????????????????
     *
     * @author ?????????
     * @date 2021-01-28 17:29:15
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "recruitStudent/studentinfo")
    @ApiOperation("????????????????????????")
    public String goRecruitStudentInfo(Integer id, Model model) {
        log.debug("id:"+id);
        resolveRecruitStudentModel(id, model);
        //??????????????????
        return FebsUtil.businessesView("students/recruitStudentInfo");
    }

    /**
     * ????????????????????????????????????
     *
     * @author ?????????
     * @date 2021-01-28 17:29:15
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/poolStudentinfo")
    @ApiOperation("??????????????????????????????")
    public String goPoolStudentInfo(Integer id, Model model) {
        log.debug("id:"+id);
        resolveReqStudentModel(id, model);
        return FebsUtil.businessesView("students/poolStudentInfo");
    }

    /**
     * ???????????????????????????
     *
     * @author ?????????
     * @date 2021-01-28 17:29:15
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/examlocationconfirm")
    @ApiOperation("???????????????????????????")
    public String goExamLocationConfirm(Integer id, Model model) {
        log.debug("id:"+id);
//??????????????????
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
            log.debug("??????check2??????" + examLocationId);
            check = 2;
            model.addAttribute("student", student);
            model.addAttribute("check", check);
            ConfirmAddress confirmAddress = confirmAddressService.findById(examLocationId);
            log.debug("????????????" + confirmAddress);
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
     * ???????????????????????????
     *
     * @author hutengjiao
     * @date 2021/02/01
     */
    @ApiOperation("???????????????????????????")
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
            log.debug("??????indenDetail:"+indenDetail);
        }
        return FebsUtil.businessesView("students/identityConfirm");
    }

    /**
     * @author hutengjiao
     * @date 2021/02/01
     */
    @ApiOperation("????????????????????????")
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/affirm/photo")
    public String studentAffPhoto(Integer id, Integer typeId, Model model) {
        log.debug("id:"+id+"typeId:"+typeId);
        resolveReqStudentModel(id, model);
        Map<String, Object> photoDetail = studentsService.findTaskDetail(id, typeId);
        log.debug("??????photoDetail:"+photoDetail);
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
    @ApiOperation("?????????????????????")
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/affirm/diploma")
    public String studentAffDiploma(Integer id, Integer typeId, Model model) {
        log.debug("id:"+id+"typeId:"+typeId);
        resolveReqStudentModel(id, model);
        Map<String, Object> diplomaDetail = studentsService.findTaskDetail(id, typeId);
        log.debug("??????diplomaDetail:"+diplomaDetail);
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
     * ????????????????????????
     *
     * @author ?????????
     * @date 2021-01-28 17:29:15
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/cost")
    @ApiOperation("????????????????????????")
    public String cost(Integer id, Model model) {
        log.debug("id:"+id);
        resolveReqStudentModel(id, model);
        //??????????????????
        return FebsUtil.businessesView("students/payDetail");
    }

    /**
     * ?????????????????????????????????????????????
     *
     * @author ?????????
     * @date 2021-01-28 17:29:15
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "recruitStudent/cost")
    @ApiOperation("????????????????????????")
    public String recruitCost(Integer id, Model model) {
        log.debug("id:"+id);
        resolveRecruitStudentModel(id, model);
        //??????????????????
        return FebsUtil.businessesView("students/recruitPayDetail");
    }

    /**
     * ??????????????????????????????
     *
     * @author hutengjiao
     * @date 2021/02/01
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "student/studyInfo")
    @ApiOperation("??????????????????????????????")
    public String studyInfo(Integer id, Model model) {
        log.debug("id:"+id);
        List<CollegeTerm> term = homeworkService.findTermByStuid(id);
        model.addAttribute("term", term);
        log.debug("??????term:"+term);
        resolveStudentModel(id, model);
        return FebsUtil.businessesView("students/studyDetail");
    }

    /**
     * ?????????????????????????????????????????????
     *
     * @author hutengjiao
     * @date 2021/02/01
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "recruitStudent/studyInfo")
    @ApiOperation("?????????????????????????????????????????????")
    public String recruitStudyInfo(Integer id, Model model) {
        log.debug("id:"+id);
        List<CollegeTerm> term = homeworkService.findTermByStuid(id);
        model.addAttribute("term", term);
        log.debug("??????term:"+term);
        resolveRecruitStudentModel(id, model);
        return FebsUtil.businessesView("students/recruitStudyDetail");
    }

    /**
     * ???????????????
     **/

	/*
    *
    * ?????????
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
     *  ??????
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

    //********************************???????????????????????????********************************************

    /**
     * ?????????????????????
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
     * ????????????????????????????????????
     *
     * @param id
     * @param model ????????????????????????????????????
     * @param id
     * @param model
     * @return
     * @author guozhaodi
     * @date 2021-01-27 09:56:39
     * ????????????????????????????????????
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "seal/detail/{id}")
    public String sealdetail(@PathVariable Integer id, Model model) {
        System.out.println("ViewController.sealdetail" + id);
        resolveSealModel(id, model, false);
        return FebsUtil.businessesView("seal/sealUpdate");
    }

    /**
     * ?????????????????????
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


    //********************************???????????????????????????********************************************


    //********************************??????start********************************************

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
     * ??????id???????????????????????????????????????id?????????????????????????????????
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
     * @param id ?????????id
     * @description: ?????????????????????
     * @return: html????????????
     * @author: LiPeng
     * @date: 2021/2/1
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "group/grouping/{id}")
    @RequiresPermissions("studentGroup:view")
    public String grouping(@PathVariable Integer id, Model model) {
        log.debug("??????????????????????????????id???" + id);
        model.addAttribute("id", id);
        return FebsUtil.businessesView("group/grouping");
    }

    /**
     * @Description: ?????????????????????
     * @return: html????????????
     * @author: LiPeng
     * @date: 2021/2/1
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "class/classGrouping/{id}")
    @RequiresPermissions("class:view")
    public String classGrouping(@PathVariable Integer id, Model model) {
        System.out.println("?????????id???" + id);
        model.addAttribute("id", id + 1000000);
        return FebsUtil.businessesView("class/classGrouping");
    }

    /**
     * @Description: ???????????????????????????
     * @Param: classId ??????id
     * @return: html????????????
     * @author: LiPeng
     * @date: 2021/2/1
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "class/detail/{classId}")
    public String classDetail(@PathVariable Integer classId, Model model) {
        resolveClassModel(classId, model, true);
        return FebsUtil.businessesView("class/classDetail");
    }

    /**
     * @Description: ????????????id??????????????????
     * @Param: classId ??????id???model ??????????????????????????????????????????
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
     * @Description: ???????????????????????????
     * @Param: studentId ??????id???model ??????????????????????????????????????????
     * @return: html??????
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
     * ?????????????????????????????????????????????????????????????????????
     *
     * @return html??????
     * @author houweikang
     * @date 2021/2/4
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "stuMajor/update/{studentId}")
    public String stuMajorUpdate(@PathVariable Integer studentId, Model model) {
        resolveRecruitStudentModel(studentId, model);
        return FebsUtil.businessesView("class/stuMajorUpdate");
    }

    /**
     * @return html??????
     * @Description ??????????????????????????????????????????
     * @author houweikang
     * @date 2021/2/2
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "class/add")
    public String classAdd() {
        return FebsUtil.businessesView("class/classAdd");
    }

    /**
     * @return html??????
     * @Description ???????????????????????????
     * @author houweikang
     * @date 2021/2/2
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "classes/list")
    @RequiresPermissions("class:view")
    public String classes() {
        return FebsUtil.businessesView("class/class");
    }

    /**
     * @return html??????
     * @Description ????????????????????????????????????????????????
     * @author houweikang
     * @date 2021/2/2
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "group/add")
    public String groupAdd() {
        return FebsUtil.businessesView("group/groupAdd");
    }

    /**
     * @return html??????
     * @Description ????????????????????????
     * @author houweikang
     * @date 2021/2/2
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "studentGroup/list")
    @RequiresPermissions("studentGroup:view")
    public String group() {
        return FebsUtil.businessesView("group/group");
    }

    /**
     * @param id    ??????id
     * @param model
     * @return html??????
     * @Description ??????????????????????????????
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
     * @Description ??????????????????????????????????????????
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


    //********************************??????end********************************************

    //********************************??????start********************************************
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
            typeName.replaceAll("???", "");
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
            typeNameRe = typeName.replaceAll("???", "");
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

    //********************************??????end********************************************


}
