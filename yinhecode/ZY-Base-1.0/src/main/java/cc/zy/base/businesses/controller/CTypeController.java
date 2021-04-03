package cc.zy.base.businesses.controller;


import cc.zy.base.businesses.entity.CType;
import cc.zy.base.businesses.entity.CTypeTree;
import cc.zy.base.businesses.service.ICTypeService;
import cc.zy.base.common.annotation.ControllerEndpoint;
import cc.zy.base.common.controller.BaseController;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.exception.FebsException;
import cc.zy.base.common.utils.FebsUtil;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 *  Controller
 *
 * @author quxiaolong
 * @date 2021-01-25 10:44:35
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("cType")
public class CTypeController extends BaseController {
    @Resource
    private  ICTypeService cTypeService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "cType")
    public String cTypeIndex(){
        return FebsUtil.view("cType/cType");
    }

    /**
     *
     * @description 条件查询课程分类列表
     * @param cType  课程类型对象参数
     * @return dataTable 课程分类列表
     */
    @ResponseBody
    @GetMapping("list")
    public FebsResponse cTypeList(QueryRequest request, CType cType) {
        log.debug("课程类型对象参数:" + cType);
        Map<String, Object> dataTable = getDataTable(this.cTypeService.findCTypes(request, cType));
        log.debug("课程分类列表:" + dataTable);
        return new FebsResponse().success().data(dataTable);
    }

    /**
     *
     * @description 获取类别树
     * @return cTypeTrees  类别树列表
     * @throws FebsException 类别树构建失败异常
     */
    @ResponseBody
    @GetMapping("select/tree")
    @ControllerEndpoint(exceptionMessage = "获取类别树失败")
    public FebsResponse getCTypeTree() throws FebsException {
        List<CTypeTree<CType>> cTypeTrees = this.cTypeService.findCType();
        log.debug("类别树列表：" + cTypeTrees);
        return new FebsResponse().success().data(cTypeTrees);
    }


    /**
     * @description 视频增加、修改获取类别树
     * @return cTypeTrees  类别树列表
     * @throws FebsException
     */
    @ResponseBody
    @GetMapping("select/treexk")
    @ControllerEndpoint(exceptionMessage = "视频增加、修改获取类别树失败")
    public FebsResponse getCTypeTreexk() throws FebsException {
        List<CTypeTree<CType>> cTypeTrees = this.cTypeService.findCTypexk();
        log.debug("视频增加、修改获取类别树：" + cTypeTrees);
        return new FebsResponse().success().data(cTypeTrees);
    }


    /**
     *
     * @description 获取类别树
     * @return cTypeTrees  类别树列表
     * @throws FebsException 类别树构建失败异常
     */
    @GetMapping("tree")
    @ResponseBody
    @ControllerEndpoint(exceptionMessage = "获取类别树失败")
    public FebsResponse getCTypeTree( CType cType) throws FebsException {
        log.debug("获取类别树cType:"+cType);
        List<CTypeTree<CType>> cTypeTrees = this.cTypeService.findCType(cType);
        log.debug("获取类别树cTypeTrees:"+cTypeTrees);
        return new FebsResponse().success().data(cTypeTrees);
    }

    /**
     * @description 删除类别树
     * @param cType 课程类别对象参数
     * @return
     */
    @ResponseBody
    @GetMapping("delete")
    @RequiresPermissions("cType:delete")
    @ControllerEndpoint(operation = "删除CType", exceptionMessage = "删除CType失败")
    public FebsResponse deleteCType(CType cType) {
        this.cTypeService.deleteCType(cType);
        return new FebsResponse().success();
    }

    /**
     * @description 删除类别树
     * @param cType
     * @return
     */
    @ResponseBody
    @PostMapping("update")
    @ControllerEndpoint(operation = "修改CType", exceptionMessage = "修改CType失败")
    public FebsResponse updateCType(CType cType) {
        this.cTypeService.updateCType(cType);
        return new FebsResponse().success();
    }

    @ResponseBody
    @PostMapping("cType/excel")
    @RequiresPermissions("cType:export")
    @ControllerEndpoint(operation = "修改CType", exceptionMessage = "导出Excel失败")
    public void export(QueryRequest queryRequest, CType cType, HttpServletResponse response) {
        List<CType> cTypes = this.cTypeService.findCTypes(queryRequest, cType).getRecords();
        ExcelKit.$Export(CType.class, response).downXlsx(cTypes, false);
    }

    /**
     * @description 更新类别状态
     * @param id 类别id
     * @return
     */
    @ResponseBody
    @GetMapping("updateByIdSatus")
    public FebsResponse updateByIdSatus(int id) {
        log.debug("更新类别状态，类别id"+id);
        this.cTypeService.updateByIdStatus(id);
        return new FebsResponse().success();
    }

    /**
     * @description 更新类别状态为上架状态
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping("updateByIdSatusUp")
    public FebsResponse updateByIdSatusUp(int id) {
        log.debug("更新类别状态为上架状态，类别id"+id);
        this.cTypeService.updateByIdStatusUp(id);
        return new FebsResponse().success();
    }

    /**
     * @description 类别排序
     * @param id 类别id
     * @param sort1 一级类别排序字段
     * @param sort2 二级类别排序字段
     * @param sort3 文本框输入的序号
     * @return
     */
    @ResponseBody
    @GetMapping("updateSort")
    public FebsResponse updateSort(int id,int sort1,int sort2,int sort3) {

        log.debug("类别id"+id+",一级类别排序字段值："+sort1+",二级类别排序字段值："+sort2+
                ",文本框输入的序号："+sort3);
        boolean flag = this.cTypeService.updateSort(id, sort1, sort2, sort3);
        if (flag){
            return new FebsResponse().success();
        }else {
            return new FebsResponse().fail().message("不能与自身交换");
        }


    }

    /**
     * @description 增加类别
     * @param cType 课程类别对象参数
     * @return
     */
    @ResponseBody
    @PostMapping("add")
    @ControllerEndpoint(operation = "新增CType", exceptionMessage = "新增CType失败")
    public FebsResponse addCType(@Valid CType cType) {

        log.debug("增加类别参数"+cType);
        boolean flag = this.cTypeService.createCType(cType);
        if (flag){
            return new FebsResponse().success();
        }else {
            return new FebsResponse().fail().message("该类型已存在，请勿重复添加");
        }

    }

    /**
     * @description 选择一级类别
     * @return
     * @throws FebsException
     */
    @ResponseBody
    @GetMapping("select/tree1")
    @ControllerEndpoint(exceptionMessage = "获取类别树失败")
    public FebsResponse getCTypeTree1() throws FebsException {
        List<CTypeTree<CType>> cTypeTrees = cTypeService.selectCTypeList1();
        log.debug("选择一级类别参数:"+cTypeTrees);
        return new FebsResponse().success().data(cTypeTrees);
    }
}