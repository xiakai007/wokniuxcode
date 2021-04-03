package com.isoftstone.humanresources.service.impl;

import com.isoftstone.humanresources.dao.EmployeeDao;
import com.isoftstone.humanresources.dao.EmployeePerformanceDao;
import com.isoftstone.humanresources.dao.WorkTimeDao;
import com.isoftstone.humanresources.domain.EmployeePerformanceInformation;
import com.isoftstone.humanresources.domain.Result;
import com.isoftstone.humanresources.service.EmployeePerformanceService;
import com.isoftstone.humanresources.util.CommonConstant;
import com.isoftstone.humanresources.util.ConversionUtils;
import com.isoftstone.humanresources.util.ImportExcelUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service(value = "EmployeePerformanceService")
public class EmployeePerformanceServiceImpl implements EmployeePerformanceService {
    private final static Logger logger = LoggerFactory.getLogger(EmployeePerformanceService.class);
    @Autowired
    private EmployeePerformanceDao employeePerformanceDao;

    @Autowired
	private WorkTimeDao workTimeDao;
    
    @Override
    public Result importExcelEmpPer(MultipartFile file) {
        logger.info("----------导入绩效数据接入参数------{}", file);
        List<EmployeePerformanceInformation> list = new ArrayList<>();
        try {
            InputStream inputStream = file.getInputStream();
            
            List<Integer> empList = workTimeDao.getEmployeeIds();
            //调用工具类获取员工绩效数据
            List<List<Object>> listob = new ImportExcelUtil().getBankListByExcel(inputStream, file.getOriginalFilename(),0);
            inputStream.close();                  //释放流
            for (int i = 0; i < listob.size(); i++) {
                EmployeePerformanceInformation emp = new EmployeePerformanceInformation();
                String str = (String) listob.get(i).get(0);
                Integer empID = StringUtils.isEmpty(str)?0:ConversionUtils.trimPoint(str);
                if(!empList.contains(empID)){
                	continue;
                }
                emp.setEmployeeID(empID);                                                            //工号
                String startDate = (String) listob.get(i).get(1);
                String strStartDate = ConversionUtils.dateChange(startDate, CommonConstant.DATAFORMATTER);
                emp.setStartDate(strStartDate);                   //考核开始时间
                String endDate = (String) listob.get(i).get(2);
                String strEndDate = ConversionUtils.dateChange(endDate, CommonConstant.DATAFORMATTER);
                emp.setEndDate(strEndDate);                        //考核结束时间
                emp.setType(String.valueOf(listob.get(i).get(3))); //考核类型
                String strSource = (String) listob.get(i).get(4);
                Integer source = ConversionUtils.trimPoint(strSource);
                emp.setScore(source);                               //绩效分数
                emp.setLevel(String.valueOf(listob.get(i).get(5))); //绩效等级
                emp.setMaternityLeave(String.valueOf(listob.get(i).get(6))); //休产假天数
                emp.setIsGt45(String.valueOf(listob.get(i).get(7)));         //是否大于45天
                emp.setIsManageAgreed(String.valueOf(listob.get(i).get(8)));  //是否平台总经理形式行权
                emp.setQuarter(String.valueOf(listob.get(i).get(9)));  //考核季度
                String year = emp.getStartDate().substring(0,emp.getStartDate().indexOf("-")<0?emp.getStartDate().length():emp.getStartDate().indexOf("-"));
                Integer intYear = ConversionUtils.trimPoint(year);
                emp.setYear(intYear+"");                               //年度
                emp.setRemark(String.valueOf(listob.get(i).get(11)));  //备注
                list.add(emp);
            }
            //调用dao接口批量插入数据
            employeePerformanceDao.importExcelEmployeePerformance(list);
            return new Result(true, "导入绩效数据成功");
        } catch (Exception e) {
        	e.printStackTrace();
            logger.error("-----------导入绩效数据成功异常--------", e);
        }
        return new Result(false, "导入绩效数据失败");
    }
}
