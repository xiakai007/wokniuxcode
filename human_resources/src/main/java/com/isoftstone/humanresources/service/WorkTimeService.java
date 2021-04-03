package com.isoftstone.humanresources.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isoftstone.humanresources.domain.Result;
import org.springframework.web.multipart.MultipartFile;

public interface WorkTimeService {
	
	/**
	 * 员工日工时导入
	 * @param file
	 * @return
	 * @throws IOException
	 */
	Map<String, List<Object>> importIPASWorkTimeDay(MultipartFile file) throws IOException;
	
	/**
     * 模板下载接口
     * @param response
     * @param request
     */
    void loadExcl(HttpServletResponse response,HttpServletRequest request,String fileName) throws Exception;
    
    /**
	 * 员工月工时导入
	 * @param file
	 * @return
	 * @throws IOException
	 */
    Map<String, List<Object>> importIPASWorkTimeMonth(MultipartFile file) throws IOException;

	/**
	 * Omp日工时导入
	 * @param file
	 * @return
	 * @throws IOException
	 */
	Map<String, List<Object>> importOmpWorkTimeMonth(MultipartFile file) throws IOException ;

	/**
	 * OMP日工时导入
	 * @param file
	 * @return
	 * @throws IOException
	 */
	Map<String, List<Object>> importOmpWorkTimeDay(MultipartFile file) throws IOException;
	/**
	 * 月差异数据导出
	 * @return
	 * @throws IOException
	 */
	Result exportDifMonth(HttpServletResponse response) throws Exception;

	/**
	 * 日差异数据导出
	 * @return
	 * @throws IOException
	 */
	Result exportDifDay(HttpServletResponse response) throws Exception;
	/**
	 * OMP异常数据导出
	 * @return
	 * @throws IOException
	 */
	Result exportOMPException(HttpServletResponse response) throws Exception;

	Result exportOMPWorkTimeException1(HttpServletResponse response) throws Exception;

	Result exportOMPWorkTimeException2(HttpServletResponse response) throws Exception;

	Result exportOMPOvertimes(HttpServletResponse response) throws Exception;

	Result exportOMPSumtimes(HttpServletResponse response) throws Exception;

	Result exportOMPSumPduAndDeptment(HttpServletResponse response) throws Exception;

	Result exportAllOMPException(HttpServletResponse response) throws Exception;

}
