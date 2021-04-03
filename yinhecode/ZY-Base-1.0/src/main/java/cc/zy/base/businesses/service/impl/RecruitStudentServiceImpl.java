package cc.zy.base.businesses.service.impl;

import cc.zy.base.businesses.entity.Classes;
import cc.zy.base.businesses.entity.StuColumn;
import cc.zy.base.businesses.entity.StuLabel;
import cc.zy.base.businesses.entity.Student;
import cc.zy.base.businesses.mapper.ClassesMapper;
import cc.zy.base.businesses.mapper.RecruitStudentMapper;
import cc.zy.base.businesses.mapper.StudentMapper;
import cc.zy.base.businesses.service.IRecruitStudentService;
import cc.zy.base.businesses.service.IStudentService;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.exception.FebsException;
import cc.zy.base.common.utils.SortUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Service实现
 *
 * @author Jiangjinlin
 * @date 2021-01-25 11:45:25
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RecruitStudentServiceImpl extends ServiceImpl<RecruitStudentMapper, Student> implements IRecruitStudentService {

    private final RecruitStudentMapper recruitStudentMapper;
    private final ClassesMapper classesMapper;

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

    //查询分页--学生表
    @Override
    public IPage<Student> selectStudentDetailList(Student student, QueryRequest request) {
        Page<Student> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        System.out.println("********" + baseMapper.countStudentDetail(student));
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
    public void setRecycleStatus(int id) {
        this.baseMapper.setRecycleStatus(id);
    }

    @Override
    public void insertIntoRecycle(Student student) {
        this.baseMapper.insertIntoRecycle(student);
    }

    @Override
    public Student selectStuForRecycle(int id) {
        return this.baseMapper.selectStuForRecycle(id);
    }

    @Override
    public Student findStudentById(Integer id) {
        return this.recruitStudentMapper.selectById(id);
    }

    @Override
    public Boolean rejectTask(Integer id, Integer typeId, String remark) {
        int i = this.recruitStudentMapper.updateTaskStatusByStuId(id, typeId, remark);
        if (i > 0) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Boolean passedTask(Integer id, Integer typeId, Student student) {
        int i = this.recruitStudentMapper.updateStatusByTask(id, typeId);
        if (i > 0) {
            int i1 = this.recruitStudentMapper.updateById(student);
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

    @Override
    public Map<String, Object> findTaskDetail(Integer id, Integer typeId) {
        return this.recruitStudentMapper.findTaskDetailByStuId(id, typeId);
    }

    @Override
    public void delLable(Integer id) {
        this.baseMapper.delLable(id);
    }

    @Override
    @Transactional
    public Boolean passExamTask(Integer taskId, Student student) {
        try {
            recruitStudentMapper.updateStatusById(taskId);
            recruitStudentMapper.updateById(student);
        } catch (Exception e) {
            throw new FebsException("更新失败");
        }
        return true;
    }

    @Override
    @Transactional
    public Boolean noPassExamTask(Integer taskId) {
        try {
            recruitStudentMapper.updateStatusByIdNoPass(taskId, null);
        } catch (Exception e) {
            throw new FebsException("更新失败");
        }
        return true;
    }

    @Override
    public Integer[] findStuIdBuClassId(String classId, Integer typeId) {
        Integer[] ids =this.recruitStudentMapper.selectStuidByClass(classId, typeId);
        return ids;
    }

    //学生现场确认地点审核通过
    @Override
    @Transactional
    public Boolean passExamLocation(Integer taskId, Integer stuId, Integer examLocationId) {
        try {
            recruitStudentMapper.updateStatusById(taskId);
            recruitStudentMapper.updateStudentExamLocation(stuId, examLocationId);
        } catch (Exception e) {
            throw new FebsException("更新失败");
        }
        return true;
    }

    //学生现场确认地点审核不通过
    @Override
    public Boolean noPassExamLocation(Integer taskId, String remark) {
        try {
            recruitStudentMapper.updateStatusByIdNoPass(taskId, remark);
        } catch (Exception e) {
            throw new FebsException("更新失败");
        }
        return true;
    }

    @Override
    public Map<String, Object> findTaskByStuidAndType(Integer stuId, Integer typeId) {
        return recruitStudentMapper.findTaskByStuidAndType(stuId, typeId);
    }

    @Override
    public int updateStudentByEntity(Student student) {
        return recruitStudentMapper.updateById(student);
    }

    @Override
    public void overdueSet(int id) {
        baseMapper.overdueSet(id);
    }

//    @Override
//    public void createColumn(StuColumn stuColumn) {
//        baseMapper.createColumn(stuColumn);
//    }
//
//    @Override
//    public List<StuColumn> checkYourColumn(Long id) {
//        return this.baseMapper.checkYourColumn(id);
//    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void studentReentry(Student student) {
        //将原有学生信息 异动状态更新为正常，并修改为放入回收站状态
        this.recruitStudentMapper.updateStudentForBackCollege(student.getId());
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
        Integer insertCount = this.recruitStudentMapper.insertStudentBatch(students);
        System.out.println("此次插入学生表数据共" + insertCount + "条");
    }

    @Override
    public List<StuColumn> checkYourColumn(Long id) {
        return null;
    }


    @Override
    public Map<String, String> getStuExamPayInfo(Integer stuId, String paymenExplain) {
        String ctime = null;
        String cost = null;
        String policy = null;
        String discountName = null;
        Map<String, String> map = new HashMap<>();
        Map<String, Object> shouldPay = recruitStudentMapper.getShouldPay(stuId, paymenExplain);
        int id = (int) (shouldPay.get("id"));
        String shouldPay1 = shouldPay.get("shouldPay") + "";
        Map<String, Object> truePay = recruitStudentMapper.getTruePay(stuId, id);
        if (truePay != null) {
            ctime = truePay.get("ctime") + "";
            // System.out.println(ctime);
            cost = truePay.get("cost") + "";
        }
        //System.out.println(cost);
        Map<String, Object> payDiscount = recruitStudentMapper.getPayDiscount(id, ctime);
        if (payDiscount != null) {
            policy = payDiscount.get("policy") + "";
            discountName = payDiscount.get("discountName") + "";
        }
        map.put("shouldPay", shouldPay1);
        map.put("cost", cost);
        map.put("policy", policy);
        map.put("discountName", discountName);
        map.put("ctime",ctime);
        return map;
    }

    @Override
    public Map<String, String> getStuStudyPayInfo(Integer stuId, String paymenExplain) {
        String ctime = null;
        String cost = null;
        String policy = null;
        String discountName = null;
        Map<String, String> map = new HashMap<>();
        Map<String, Object> shouldPay = recruitStudentMapper.getShouldPay(stuId, paymenExplain);
        int id = (int) (shouldPay.get("id"));
        String shouldPay1 = shouldPay.get("shouldPay") + "";
        Map<String, Object> truePay = recruitStudentMapper.getStudyTruePay(stuId, id);
        if (truePay != null) {
            ctime = truePay.get("ctime") + "";
            // System.out.println(ctime);
            cost = truePay.get("cost") + "";
        }
        //System.out.println(cost);
        Map<String, Object> payDiscount = recruitStudentMapper.getPayDiscount(id, ctime);
        if (payDiscount != null) {
            policy = payDiscount.get("policy") + "";
            discountName = payDiscount.get("discountName") + "";
        }
        map.put("shouldPay", shouldPay1);
        map.put("cost", cost);
        map.put("policy", policy);
        map.put("discountName", discountName);
        map.put("ctime",ctime);
        return map;
    }

    @Override
    public int findStudentStudyYear(Integer stuId) {
        return recruitStudentMapper.findStudentStudyYear(stuId);
    }
}
