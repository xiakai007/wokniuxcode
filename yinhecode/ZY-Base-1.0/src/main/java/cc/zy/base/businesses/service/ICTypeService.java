package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.CType;


import cc.zy.base.businesses.entity.CTypeTree;
import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author quxiaolong
 * @date 2021-01-25 10:44:35
 */
public interface ICTypeService extends IService<CType> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param cType cType
     * @return IPage<CType>
     */
    IPage<CType> findCTypes(QueryRequest request, CType cType);
    /**
     * 查询（所有）
     *
     * @param cType cType
     * @return List<CType>
     */
    List<CType> findCTypes(CType cType);
    /**
     * 新增
     *
     * @param cType cType
     */
    boolean createCType(CType cType);
    /**
     * 修改
     *
     * @param cType cType
     */
    void updateCType(CType cType);
    /**
     * 删除
     *
     * @param cType cType
     */
    void deleteCType(CType cType);
    /**
     * 获取类别树（下拉选使用）
     *
     * @return 部门树集合
     */
    List<CTypeTree<CType>> findCType();
    /**
     * 视频增加、修改获取类别树（下拉选使用）
     *
     * @return 类别树集合
     */
    List<CTypeTree<CType>> findCTypexk();

    /**
     * 获取类别列表（树形列表）
     *
     * @param cType 部门对象（传递查询参数）
     * @return 类别树
     */
    List<CTypeTree<CType>> findCType(CType cType);
    /**
     * 更新类别状态
     * @param id
     */
    void updateByIdStatus(int id);
    /**
     *更新类别状态为上架状态
     * @param id
     */
    void updateByIdStatusUp(int id);
    /**
     * @description 类别排序
     * @param id 类别id
     * @param sort1 一级类别排序字段
     * @param sort2 二级类别排序字段
     * @param sort3 文本框输入的序号
     * @return
     */
    boolean updateSort(int id, int sort1, int sort2, int sort3);

    /**
     * 通过ID查找
     *
     * @param id id
     * @return 类别信息
     */
    CType findById(int id);
    /**
     * 查找分类的一级目录
     * @return
     */
    List<CTypeTree<CType>> selectCTypeList1();
    /**
     * 查询一级目录下所有sort2
     * @return
     */
    List<Integer> selectSort2ByPid(Integer id);
}

