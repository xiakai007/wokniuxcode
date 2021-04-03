package cc.zy.base.businesses.controller;

import cc.zy.base.businesses.entity.College;
import cc.zy.base.businesses.entity.HomePage;
import cc.zy.base.businesses.service.ICollegeService;
import cc.zy.base.businesses.service.IHomePageService;
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
 * 学生首页信息
 * @author linan
 * @date 2021-01-18
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("homePage")
public class HomePageController extends BaseController {

    @Resource
    private final IHomePageService homePageService;

    @GetMapping(FebsConstant.VIEW_BUS_PREFIX + "homePage")
    public String homePageIndex(){
        return FebsUtil.BusinessView("homePage/homePage");
    }

    /**
     * 修改首页信息
     * @param homePage
     * @return
     */
    @PostMapping("update")
    @ControllerEndpoint(operation = "修改首页信息", exceptionMessage = "修改首页信息失败")
    @ResponseBody
    public FebsResponse updateHomePage(@Valid HomePage homePage) {
        if (homePage.getId() == null) {
            throw new FebsException("ID为空");
        }
        this.homePageService.updateHomePage(homePage);
        return new FebsResponse().success();
    }

    /**
     *所有内容
     * @return 查询所有的首页信息
     */
    @GetMapping("homeList")
    @ResponseBody
    public FebsResponse getAllPages() {
        return new FebsResponse().success().data(homePageService.findAllHomePage());
    }


}
