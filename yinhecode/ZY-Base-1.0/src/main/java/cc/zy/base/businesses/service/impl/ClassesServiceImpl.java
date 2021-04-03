package cc.zy.base.businesses.service.impl;

import cc.zy.base.businesses.entity.*;
import cc.zy.base.businesses.mapper.ClassesMapper;
import cc.zy.base.businesses.mapper.DicMapper;
import cc.zy.base.businesses.mapper.StudentMapper;
import cc.zy.base.businesses.mapper.TeacherChangeLogMapper;
import cc.zy.base.businesses.service.IClassesService;
import cc.zy.base.businesses.service.IDicService;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.FebsUtil;
import cc.zy.base.common.utils.SortUtil;
import cc.zy.base.common.utils.TreeNode;
import cc.zy.base.common.utils.TreeNodeBuilder;
import cc.zy.base.system.entity.Dept;
import cc.zy.base.system.entity.User;
import cc.zy.base.system.mapper.DeptMapper;
import cc.zy.base.system.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.annotation.Resource;
import java.util.*;

/**
 * 班级表 Service实现
 *
 * @author Jiangjinlin
 * @date 2021-01-25 19:29:08
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ClassesServiceImpl extends ServiceImpl<ClassesMapper, Classes> implements IClassesService {

    private final ClassesMapper classesMapper;
    private final TeacherChangeLogMapper teacherChangeLogMapper;
    private final UserMapper userMapper;
    private final DeptMapper deptMapper;
    private final StudentMapper studentMapper;
    private final DicMapper dicMapper;
    private final IDicService dicService;

    @Override
    public IPage<Classes> findClassess(QueryRequest request, Classes classes) {
        Page<College> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(baseMapper.countClassesDetail(classes));
        SortUtil.handlePageSort(request, page, "createTime", FebsConstant.ORDER_DESC, true);
        return this.baseMapper.findClassesDetailPage(page, classes);
    }

    /**
     * @description: 查询满足查询条件的所有结果
     * @param: classes 班级对象，用来传递查询条件
     * @return: 查询到的班级集合
     * @author: LiPeng
     * @date: 2021/2/28
     */
    @Override
    public List<Classes> findClassess(Classes classes) {
        List<Classes> classesList = this.classesMapper.findClassesByCls(classes);
        return classesList;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateClasses(Classes classes) {
        this.saveOrUpdate(classes);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteClass(ArrayList<Integer> classIds) {
        HashMap<String, Object> map = new HashMap<>();
        for (Integer classId : classIds) {
            map.put("CLASS_ID", classId);
            this.teacherChangeLogMapper.deleteByMap(map);
        }
        this.removeByIds(classIds);
    }

    @Override
    public Classes findById(Integer id) {
        return this.baseMapper.findById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateTeacher(TeacherChangeLog teacherChangeLog) {

        teacherChangeLog.setChangeTime(new Date());
        this.teacherChangeLogMapper.insert(teacherChangeLog);

        Classes classes = new Classes();
        classes.setId(teacherChangeLog.getClassId());
        classes.setUserId(teacherChangeLog.getUserId());
        this.classesMapper.updateById(classes);
    }

    /**
     * 增加班级并给班主任日志表中添加
     *
     * @param classes 班级对象
     * @return boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean createClass(Classes classes) {

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("CLASS_NAME", classes.getClassName());
        Classes class1 = classesMapper.selectOne(queryWrapper);
        if (class1 == null) {
            classes.setCreateUserId(FebsUtil.getCurrentUser().getUserId());
            classes.setCreateTime(new Date());
            this.save(classes);

            TeacherChangeLog teacherChangeLog = new TeacherChangeLog();
            teacherChangeLog.setClassId(classes.getId());
            teacherChangeLog.setChangeTime(new Date());
            teacherChangeLog.setUserId(classes.getUserId());
            teacherChangeLog.setOldUserId(classes.getUserId());
            teacherChangeLog.setRemark(classes.getRemark());
            this.teacherChangeLogMapper.insert(teacherChangeLog);
            return true;
        } else {
            return false;
        }
    }

    /**
     * @description: 查：根据班级id查询班级
     * @param: classesId 班级id
     * @return: Classes 班级对象
     * @author: LiPeng
     * @date: 2021/2/8
     */
    @Override
    public Classes findClassesById(Integer classesId) {
        return this.classesMapper.selectClassesById(classesId);
    }

    /**
     * @description: 根据班级id查询班主任更换记录
     * @param: request 分页对象；classesId 班级id
     * @return: IPage 包含分页参数，以及历史班主任日志集合
     * @author: LiPeng
     * @date: 2021/2/8
     */
    @Override
    public IPage<TeacherChangeLog> findTeacherChangeLogByClassesId(QueryRequest request, Integer classesId) {
        Page<TeacherChangeLog> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(this.teacherChangeLogMapper.countTeacherChangeLog(classesId));
        SortUtil.handlePageSort(request, page, "changeTime", FebsConstant.ORDER_DESC, true);
        return this.teacherChangeLogMapper.selectTeacherChangeLogByClassId(page, classesId);
    }

    @Override
    public List<TreeNode> createUserDeptTree() {
        List<TreeNode> nodes = new ArrayList<>();
        List<Dept> deptList = deptMapper.selectList(null);
        TreeNode treeNode = null;
        if (deptList != null && !deptList.isEmpty()) {
            for (Dept dept : deptList) {
                treeNode = new TreeNode(dept);
                nodes.add(treeNode);
            }
        }
        List<User> userList = userMapper.selectList(null);
        if (userList != null && !userList.isEmpty()) {
            Classes classes = null;
            for (User user : userList) {
                classes = new Classes();
                classes.setUserId(user.getUserId());
                List<Classes> classList = classesMapper.findClassesByCls(classes);
                int countStu = 0;
                for (Classes cls : classList) {
                    countStu += cls.getStuNum();
                }
                if (countStu != 0) {
                    user.setUsername(user.getUsername() + "(" + countStu + ")");
                }
                treeNode = new TreeNode(user);
                nodes.add(treeNode);
            }
        }
        List<TreeNode> builder = TreeNodeBuilder.builder(nodes, 0L);
        return builder;
    }

    /**
     * @Description: 班级树形下拉菜单
     * @return: 树节点集合
     * @author: LiPeng
     * @date: 2021/2/8
     */
    @Override
    public List<TreeNode> findClassesTree() {
        //set集合去重
        Set<TreeNode> nodeSet = new HashSet();

        List<Classes> classesList = this.classesMapper.selectAllClasses();
        if (classesList != null && !classesList.isEmpty()) {
            //设置一级节点
            classesList.forEach(classes -> {
                TreeNode node = new TreeNode();
                node.setId(Long.valueOf(classes.getBatchId()));
                node.setName(classes.getBatchName());
                node.setOpen(false);
                node.setPid(0L);
                node.setParent(true);
                nodeSet.add(node);
            });
            //设置二级节点
            classesList.forEach(classes -> {
                TreeNode node = new TreeNode();
                node.setId(Long.valueOf(classes.getCollegeId() + "0" + classes.getBatchId()));
                node.setName(classes.getCollegeName());
                node.setOpen(false);
                node.setPid(Long.valueOf(classes.getBatchId()));
                node.setParent(true);
                nodeSet.add(node);
            });
            //设置三级节点 - 叶子结点
            classesList.forEach(classes -> {
                TreeNode node = new TreeNode();
                node.setId(classes.getId() + 1000000L);
                node.setName(classes.getClassName());
                node.setOpen(false);
                node.setPid(Long.valueOf(classes.getCollegeId() + "0" + classes.getBatchId()));
                node.setParent(false);
                nodeSet.add(node);
            });
        }

        //给非叶子节点设置children
        ArrayList<TreeNode> list = new ArrayList<>(nodeSet);
        List<TreeNode> builder = TreeNodeBuilder.builder(list, 0L);

        //按一级节点的id倒序
        Collections.sort(builder, (prev, next) -> (int) (next.getId() - prev.getId()));
        return builder;
    }

    @Override
    public void updateStuMajor(Student student) {
        Classes classes = new Classes();
        classes.setBatchId(student.getBatchId());
        classes.setCollegeId(student.getCollegeId());
        classes.setLevelId(student.getLevel());
        Integer classId = classesMapper.selectClassesByUniqueCode(classes);
        student.setClassId(classId);
        //查询字典表对应异动状态所对应的异动sid = 1 休学 ：2 复学 ： 3 换专业 ：4 更换学习形式 ：5 退学 ：6 无
        student.setTracsaction(dicService.findDicId("change_status", 6));
        studentMapper.updateById(student);
    }

    /**
     * @description: 查：按条件查询学生，用于分班
     * @param: request 分页对象，内含分页参数、排序参数；student query对象，传递查询条件
     * @return: 包含分页参数，以及查询到的数据集合
     * @author: LiPeng
     * @date: 2021/2/8
     */
    @Override
    public IPage<Student> findStudentForClassGrouping(QueryRequest request, Student student) {
        Page<Student> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(this.classesMapper.countStudentInfoForClassGrouping(student));
        return this.classesMapper.findStudentInfoForClassGrouping(page, student);
    }

    /**
     * @description: 给学生分班
     * @param: ids 学生id集合；classId 班级id
     * @author: LiPeng
     * @date: 2021/2/8
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateClassId(ArrayList<Integer> ids, Integer classId) {
        this.classesMapper.updateClassId(ids, classId);
    }

    /**
     * @description: 按条件查询学生，然后给查询到的所有学生分班
     * @param: student 查询对象，传递查询条件；classId 班级id
     * @author: LiPeng
     * @date: 2021/2/8
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateClassIdAll(Student student, Integer classId) {
        ArrayList<Integer> stuIds = this.classesMapper.findIdsByParams(student);
        this.classesMapper.updateClassId(stuIds, classId);
    }
}