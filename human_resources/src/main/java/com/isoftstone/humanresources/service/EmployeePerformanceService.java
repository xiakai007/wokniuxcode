package com.isoftstone.humanresources.service;

import com.isoftstone.humanresources.domain.Result;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface EmployeePerformanceService {
    /**
     * 批量导入员工绩效信息接口
     * @param file
     * @return
     */
    Result importExcelEmpPer(MultipartFile file) throws IOException;
}
