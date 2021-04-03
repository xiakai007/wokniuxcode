package cc.zy.base.businesses.service.impl;

import java.util.*;

import cc.zy.base.businesses.entity.*;
import cc.zy.base.businesses.mapper.ClassesMapper;
import cc.zy.base.businesses.mapper.ReqResultExtensionMapper;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.businesses.mapper.StudentMapper;
import cc.zy.base.businesses.service.IStudentService;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.exception.FebsException;
import cc.zy.base.common.utils.SortUtil;
import cc.zy.base.monitor.entity.SystemLog;
import cc.zy.base.system.entity.User;
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

/**
 * Service实现
 *
 * @author Jiangjinlin
 * @date 2021-01-25 11:45:25
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    private final StudentMapper studentMapper;
    private final ClassesMapper classesMapper;
    private final ReqResultExtensionMapper reqResultExtensionMapper;

    //通过学生表查询批次--使用批次表
    @Override
    public IPage<Student> selectStudentBatchPage(Student student, QueryRequest request) {
        Page<Student> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(baseMapper.countStudentDetail(student));
        SortUtil.handlePageSort(request, page, "id", FebsConstant.ORDER_ASC, false);
        return this.baseMapper.selectStudentBatchPage(page, student);
    }

    //学生选择，不分页
    @Override
    public List<Student> selectStudentDetail(Student student) {
        List<Student> students = this.baseMapper.selectStudentDetail(student);
        return this.baseMapper.selectStudentDetail(student);
    }

    @Override
    public IPage<Student> findStudents(QueryRequest request, Student student) {
        Page<Student> studentPage = new Page<>(request.getPageNum(), request.getPageSize());
        studentPage.setSearchCount(false);// 查询总记录数，默认是查询
        studentPage.setTotal(baseMapper.countStudentDetail(student));
        SortUtil.handlePageSort(request, studentPage, "ID", FebsConstant.ORDER_ASC, false);
        return this.baseMapper.findStudentDetailPage(studentPage, student);
    }

    @Override
    public List<Student> findStudents(Student student) {
        LambdaQueryWrapper<Student> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createStudent(Student student) {
        this.save(student);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateStudent(Student student) {
        this.saveOrUpdate(student);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteStudent(Student student) {
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }


    @Override
    public IPage<Student> selectStudentDetailList(Student student, QueryRequest request) {
        if (student != null && student.getStuName() != null) {
            student.setStuName(student.getStuName().trim());
        }
        Page<Student> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(baseMapper.countStudentDetail(student));
        SortUtil.handlePageSort(request, page, "id", FebsConstant.ORDER_ASC, false);
        return this.baseMapper.selectStudentDetailPage(page, student);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteStudents(String[] collegeIds) {
        List<String> list = Arrays.asList(collegeIds);
        this.removeByIds(list);
    }

    @Override
    public void creatStuLable(StuLabel stuLabel) {
        this.baseMapper.creatStuLabel(stuLabel);
    }

    @Override
    public List<StuLabel> checkYourLabel(Long id) {
        return this.baseMapper.checkYourLabel(id);
    }

    @Override
    public void setRecycleStatus(String[] studentIds) {
        this.baseMapper.setRecycleStatus(studentIds);
    }

    @Override
    public void insertIntoRecycle(List<Student> students) {
        this.baseMapper.insertIntoRecycle(students);
    }

    @Override
    public List<Student> selectStuForRecycle(String[] studentIds) {
        return this.baseMapper.selectStuForRecycle(studentIds);
    }

    @Override
    public Student findStudentById(Integer id) {
        return this.studentMapper.selectById(id);
    }
    @Override
    public Student findStudentByOpenId(String openId) {
        return this.studentMapper.findStudentByOpenId(openId);
    }

    @Override
    public Student findStudentByWxInfo(String batchName, String identity, String tel, String studyTypeName) {
        return this.studentMapper.findStudentByWxInfo(batchName, identity, tel, studyTypeName);
    }

    @Override
    public Student findStudentByWxInfoAndOpenId(String batchName, String identity, String tel, String studyTypeName, String openId) {
        return this.studentMapper.findStudentByWxInfoAndOpenId(batchName, identity, tel, studyTypeName, openId);
    }


    /**
     * 身份证、照片、毕业证审核驳回
     * 身份证、照片、毕业证审核驳回
     *
     * @param id
     * @param typeId
     * @param remark
     * @return
     */
    @Override
    public Boolean rejectTask(Integer id, Integer typeId, String remark) {
        int i = this.studentMapper.updateTaskStatusByStuId(id, typeId, remark);
        if (i > 0) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 根据学生Id和类型通过审核信息
     *
     * @param id
     * @param typeId
     * @param reqResultExtension ReqResultExtension
     * @return
     */
    @Override
    public Boolean passedTask(Integer id, Integer typeId, ReqResultExtension reqResultExtension) {
        int i = this.studentMapper.updateStatusByTask(id, typeId);
        if (i > 0) {
            int i1 = this.reqResultExtensionMapper.updateByStuId(id,reqResultExtension);
            if (i1 > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public Student findById(Integer id) {
        return this.baseMapper.findById(id);
    }


    /**
     * 通过学生Id和类型查找学生提交的信息详情
     *
     * @param id     id
     * @param typeId
     * @return
     */
    @Override
    public Map<String, Object> findTaskDetail(Integer id, Integer typeId) {
        return this.studentMapper.findTaskDetailByStuId(id, typeId);
    }

    @Override
    public void delLable(Integer id) {
        this.baseMapper.delLable(id);
    }

    /**
     * @param taskId
     * @param reqResultExtension
     * @return
     */
    @Override
    @Transactional
    public Boolean passExamTask(Integer taskId, ReqResultExtension reqResultExtension) {
        try {
            studentMapper.updateStatusById(taskId);
            reqResultExtensionMapper.updateByStuId(reqResultExtension.getId(),reqResultExtension);
        } catch (Exception e) {
            throw new FebsException("更新失败");
        }
        return true;
    }

    @Override
    @Transactional
    public Boolean noPassExamTask(Integer taskId) {
        try {
            studentMapper.updateStatusByIdNoPass(taskId, null);
        } catch (Exception e) {
            throw new FebsException("更新失败");
        }
        return true;
    }

    /**
     * 根据班级id查找该班所有学生id
     *
     * @param classId
     * @param typeId
     * @return Integer[]
     */
    @Override
    public Integer[] findStuIdBuClassId(String classId, Integer typeId) {
        Integer[] ids = this.studentMapper.selectStuidByClass(classId, typeId);
        return ids;
    }

    //学生现场确认地点审核通过
    @Override
    @Transactional
    public Boolean passExamLocation(Integer taskId, Integer stuId, Integer examLocationId,Integer confirmAddressId) {
        try {
            studentMapper.updateStatusById(taskId);
            if(examLocationId==confirmAddressId && examLocationId!=null && confirmAddressId!=null) {
                studentMapper.updateStudentExamLocation(stuId, examLocationId);
            }else {
                studentMapper.updateStudentExamLocation(stuId, confirmAddressId);
            }
        } catch (Exception e) {
            throw new FebsException("更新失败");
        }
        return true;
    }

    //学生现场确认地点审核不通过
    @Override
    public Boolean noPassExamLocation(Integer taskId, String remark) {
        try {
            studentMapper.updateStatusByIdNoPass(taskId, remark);
        } catch (Exception e) {
            throw new FebsException("更新失败");
        }
        return true;
    }

    @Override
    public Map<String, Object> findTaskByStuidAndType(Integer stuId, Integer typeId) {
        return studentMapper.findTaskByStuidAndType(stuId, typeId);
    }

    @Override
    public int updateStudentByEntity(Student student) {
        return studentMapper.updateById(student);
    }

    @Override
    public void overdueSet(int id) {
        baseMapper.overdueSet(id);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void studentReentry(Student student) {
        //将原有学生信息 异动状态更新为正常，并修改为放入回收站状态
        this.studentMapper.updateStudentForBackCollege(student.getId());
        //查找新的班级
        Classes classes = new Classes();
        classes.setBatchId(student.getBatchId());
        classes.setCollegeId(student.getCollegeId());
        classes.setLevelId(student.getLevel());
        classes.setMajorId(student.getMajorId());
        Integer classesId = this.classesMapper.selectClassesByUniqueCode(classes);
        //新增一条学生信息
        student.setClassId(classesId);
        ArrayList<Student> students = new ArrayList<>();
        students.add(student);
        Integer insertCount = this.studentMapper.insertStudentBatch(students);
        System.out.println("此次插入学生表数据共" + insertCount + "条");
    }

    @Override
    public List<StuColumn> checkYourColumn(Long id) {
        return null;
    }


    @Override
    public Map<String, Object> getStuExamPayInfo(Integer stuId) {
        Map<String, Object> entryFee = studentMapper.getEntryFee(stuId);
        return entryFee;
    }

    @Override
    public IPage<SystemLog> findStuLog(SystemLog systemLog, QueryRequest request) {
        Page<SystemLog> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(baseMapper.countStuLog(systemLog));
        SortUtil.handlePageSort(request, page, "id", FebsConstant.ORDER_ASC, false);
        log.info("返回loglist方法service");
        log.info(systemLog.toString());
        return this.baseMapper.findStuLog(page, systemLog);
    }
}
