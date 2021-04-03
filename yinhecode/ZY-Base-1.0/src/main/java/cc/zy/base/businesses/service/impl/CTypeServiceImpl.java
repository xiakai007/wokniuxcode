package cc.zy.base.businesses.service.impl;


import cc.zy.base.businesses.entity.CType;
import cc.zy.base.businesses.entity.CTypeTree;
import cc.zy.base.businesses.mapper.CTypeMapper;
import cc.zy.base.businesses.mapper.VideoMapper;
import cc.zy.base.businesses.service.ICTypeService;
import cc.zy.base.businesses.utils.TreeUtil;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.FebsUtil;
import cc.zy.base.common.utils.SortUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Service实现
 *
 * @author quxiaolong
 * @date 2021-01-25 10:44:35
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CTypeServiceImpl extends ServiceImpl<CTypeMapper, CType> implements ICTypeService {

    private final CTypeMapper cTypeMapper;
    private final VideoMapper videoMapper;

    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param cType cType
     * @return IPage<CType>
     */
    @Override
    public IPage<CType> findCTypes(QueryRequest request, CType cType) {
        log.debug("类型名称:" + cType.getName());
        Page<CType> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(true);
        if(cType.getName()==null||cType.getName().equals("")){
            List<String> list = cTypeMapper.selectRootNameLastInsert();
            if (list!=null&&!list.isEmpty()){
                cType.setName(list.get(0));
            }
        }
        log.debug("类型名称：" + cType.getName());
        page.setTotal(baseMapper.countCTypeDetail(cType));
        SortUtil.handlePageSort(request, page, "id", FebsConstant.ORDER_ASC, false);
        return this.baseMapper.findCTypeDetail(page, cType);
    }

    /**
     * 查询（所有）
     *
     * @param cType cType
     * @return List<CType>
     */
    @Override
    public List<CType> findCTypes(CType cType) {
        LambdaQueryWrapper<CType> queryWrapper = new LambdaQueryWrapper<>();
        return this.baseMapper.selectList(queryWrapper);
    }

    /**
     * 删除
     *
     * @param cType cType
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteCType(CType cType) {
        LambdaQueryWrapper<CType> wrapper = new LambdaQueryWrapper<>();
        this.remove(wrapper);
    }

    /**
     * 获取类别树（下拉选使用）
     *
     * @return 部门树集合
     */
    @Override
    public List<CTypeTree<CType>> findCType() {
        List<CType> cTypeList = this.baseMapper.selectList(new QueryWrapper<>());
        List<CTypeTree<CType>> trees = this.convertCType(cTypeList);
        return TreeUtil.buildCTypeTree(trees);
    }

    /**
     * 视频增加、修改获取类别树（下拉选使用）
     *
     * @return 类别树集合
     */
    @Override
    public List<CTypeTree<CType>> findCTypexk() {
        List<CType> cTypeList = this.baseMapper.selectList(new QueryWrapper<>());
        for (CType cType : cTypeList) {
            String name = cType.getName();
            String s = name.replaceAll("└", "");
            cType.setName(s);
        }
        List<CTypeTree<CType>> trees = this.convertCType(cTypeList);
        return TreeUtil.buildCTypeTree(trees);
    }

    /**
     * 获取类别列表（树形列表）
     *
     * @param cType 部门对象（传递查询参数）
     * @return 类别树
     */
    @Override
    public List<CTypeTree<CType>> findCType(CType cType) {
        QueryWrapper<CType> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(cType.getName())) {
            queryWrapper.lambda().eq(CType::getName, cType.getName());
        }
        List<CType> cTypeList = this.baseMapper.selectList(queryWrapper);
        List<CTypeTree<CType>> trees = this.convertCType(cTypeList);
        return TreeUtil.buildCTypeTree(trees);
    }

    private List<CTypeTree<CType>> convertCType(List<CType> CType) {
        List<CTypeTree<CType>> trees = new ArrayList<>();
        CType.forEach(cType -> {
            CTypeTree<CType> tree = new CTypeTree<>();
            tree.setId(String.valueOf(cType.getId()));
            tree.setParentId(String.valueOf(cType.getPid()));
            tree.setName(cType.getName());
            tree.setData(cType);
            trees.add(tree);
        });
        return trees;
    }

    /**
     * 更新类别状态
     * @param id
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateByIdStatus(int id) {
        int pid = cTypeMapper.findPid(id);
        long l = System.currentTimeMillis();
        Date updateTime = new Date(l);
        Long updateUserId = FebsUtil.getCurrentUser().getUserId();
        if (pid == 0) {
            cTypeMapper.updateByIdStatus(id, updateTime, updateUserId.intValue());
            cTypeMapper.updateByIdStatusSon(id, updateTime, updateUserId.intValue());
            List<Integer> idList = cTypeMapper.selectByPid(id);
            for (Integer integer : idList) {
                List<Integer> integers = videoMapper.selectByTypeId(integer);
                for (Integer integer1 : integers) {
                    videoMapper.updateByIdSatus(integer1, updateTime, updateUserId.intValue());
                }
            }
        } else if (pid != 0) {
            cTypeMapper.updateByIdStatusSonDown(id, updateTime, updateUserId.intValue());
            List<Integer> id1 = videoMapper.selectByTypeId(id);
            for (Integer integer : id1) {
                videoMapper.updateByIdSatus(integer, updateTime, updateUserId.intValue());
            }
        }
    }

    /**
     *更新类别状态为上架状态
     * @param id
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateByIdStatusUp(int id) {
        int pid = cTypeMapper.findPid(id);
        long l = System.currentTimeMillis();
        Date updateTime = new Date(l);
        Long updateUserId = FebsUtil.getCurrentUser().getUserId();
        cTypeMapper.findStatus(pid);
        cTypeMapper.updateByIdStatusUp(id, updateTime, updateUserId.intValue());
    }

    /**
     * @description 类别排序
     * @param id 类别id
     * @param sort1 一级类别排序字段
     * @param sort2 二级类别排序字段
     * @param sort3 文本框输入的序号
     * @return
     */
    @Override
    public boolean updateSort(int id, int sort1, int sort2, int sort3) {
        if (sort2 == sort3){
            return false;
        }
        int id1 = cTypeMapper.selectByIdPid(sort1, sort3);
        cTypeMapper.updateByIdSort(id, sort3);
        cTypeMapper.updateByIdSort(id1, sort2);
        return true;
    }

    /**
     * 通过ID查找
     *
     * @param id id
     * @return 类别信息
     */
    @Override
    public CType findById(int id) {
        return cTypeMapper.findById(id);
    }

    /**
     * 新增
     *
     * @param cType cType
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean createCType(CType cType) {
        log.debug("课程类型：" + cType);
        Integer ctypeId = cType.getId();
        Integer PId = 0;
        if (cType.getId() == null) {
            PId = 0;
        }else {
            PId = cType.getId();
        }
        QueryWrapper<CType> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",cType.getName());
        queryWrapper.eq("pid",PId);
        CType cType1 = baseMapper.selectOne(queryWrapper);
        if(cType1 != null){
            return false;
        }
        int cTypeSORT1MAX = baseMapper.findCTypeSORT1MAX();
        int ctypeSORT2MAX = 0;
        if (cType.getId() == null) {
            ctypeId = 0;
            cTypeSORT1MAX++;
        } else {
            cTypeSORT1MAX = baseMapper.findCTypeSort1Now(ctypeId);
            ctypeSORT2MAX = baseMapper.findCTypeSORT2MAX(cTypeSORT1MAX);
            ctypeSORT2MAX++;
            cType.setName("└" + cType.getName());
        }
        cType.setPid(ctypeId);
        cType.setSort1(cTypeSORT1MAX);
        cType.setSort2(ctypeSORT2MAX);
        cType.setCreateTime(new Date(System.currentTimeMillis()));
        cType.setCreateUserId(Math.toIntExact(FebsUtil.getCurrentUser().getUserId()));
        this.save(cType);
        return true;
    }

    /**
     * 修改
     *
     * @param cType cType
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCType(CType cType) {
        if (cType.getPid() != null) {
            CType cType1 = findById(cType.getPid());
            cType.setSort1(cType1.getSort1());
            CType cType2 = findById(cType.getId());
            if (!cType.getPid().equals(cType2.getPid())) {
                int ctypeSORT2MAX = baseMapper.findCTypeSORT2MAX(cType1.getSort1());
                cType.setSort2(ctypeSORT2MAX + 1);
                cType.setUpdateUserId(Math.toIntExact(FebsUtil.getCurrentUser().getUserId()));
                cType.setUpdateTime(new Date(System.currentTimeMillis()));
            }
        }
        cType.setUpdateUserId(Math.toIntExact(FebsUtil.getCurrentUser().getUserId()));
        cType.setUpdateTime(new Date(System.currentTimeMillis()));
        this.saveOrUpdate(cType);
    }

    /**
     * 查找分类的一级目录
     * @return
     */
    @Override
    public List<CTypeTree<CType>> selectCTypeList1() {
        List<CType> cTypeList1 = cTypeMapper.selectCTypeList1();
        List<CTypeTree<CType>> trees = this.convertCType(cTypeList1);
        return trees;
    }

    /**
     * 查询一级目录下所有sort2
     * @return
     */
    @Override
    public List<Integer> selectSort2ByPid(Integer id) {
        int i = cTypeMapper.selectPidById(id);
        int i1 = cTypeMapper.selectSort1ByPid(i);
        List<Integer> integers = cTypeMapper.selectSort2BySort1(i1);
        return integers;

    }

}
