package com.isoftstone.humanresources.dao;

import com.isoftstone.humanresources.domain.EmployeePerformanceInformation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeePerformanceDao {

    /**
     * 批量插入绩效数据
     * @param list
     * @throws Exception
     */
    void importExcelEmployeePerformance(@Param("list") List<EmployeePerformanceInformation> list) throws Exception;
}
