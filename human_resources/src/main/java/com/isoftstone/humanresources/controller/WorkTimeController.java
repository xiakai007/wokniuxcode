package com.isoftstone.humanresources.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isoftstone.humanresources.domain.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.isoftstone.humanresources.service.WorkTimeService;
import com.isoftstone.humanresources.util.CommonConstant;

@Controller
@RequestMapping(value = "/hr_manager/workTime")
@Api(value = "工时管理API")
public class WorkTimeController {
	
	@Autowired
	private WorkTimeService workTimeService;

	/**
	 * 工时模板下载
	 * @param fileName
	 * @param response
	 * @param request
	 * @return
	 */
	@CrossOrigin
	@GetMapping(path = "/loadExclWorkTime")
	public ResponseEntity<String> loadExclWorkTime(@RequestParam("fileName") String fileName,HttpServletResponse response,HttpServletRequest request){
		String returnStr = null;
		try {
			workTimeService.loadExcl(response, request,fileName);
		} catch (Exception e) {
			returnStr = e.toString();
		}
		return new ResponseEntity<>(returnStr, HttpStatus.OK);
	}

	/**
	 * IPSA--月工时批量导入
	 * @param file
	 * @param request
	 * @return
	 */
	@CrossOrigin
	@PostMapping(path = "/importWorkTimeMonthExcl" )
	public ResponseEntity<Map<String, List<Object>>> importWorkTimeMonthExcl(@RequestParam("file") MultipartFile file,HttpServletRequest request){
		String returnStr;
		Map<String, List<Object>> map = new HashMap<>();
        List<Object> listReturn = new ArrayList<>();
		 try
	        {
	            if(file.isEmpty()){
	            	returnStr = "文件不存在！";
	            	listReturn.add(returnStr);
	            	map.put(CommonConstant.RETURN_ERROR, listReturn);
	            	return new ResponseEntity<>(map, HttpStatus.OK);
	            }
            map = workTimeService.importIPASWorkTimeMonth(file);
        }catch (Exception e){
            returnStr = e.toString();
            listReturn.add(returnStr);
        	map.put(CommonConstant.RETURN_ERROR, listReturn);
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
	}

	/**
	 * IPSA-- 日工時導入
	 * @param file
	 * @param request
	 * @return
	 */
	@CrossOrigin
	@PostMapping(path = "/importWorkTimeDayExcl")
	public ResponseEntity<Map<String, List<Object>>> importWorkTimeDayExcl(@RequestParam("file") MultipartFile file,HttpServletRequest request){
		String returnStr = null;
		Map<String, List<Object>> map = new HashMap<>();
        List<Object> listReturn = new ArrayList<>();
		 try
	        {
	            if(file.isEmpty()){
	            	returnStr = "文件不存在！";
	            	listReturn.add(returnStr);
	            	map.put(CommonConstant.RETURN_ERROR, listReturn);
	            	return new ResponseEntity<>(map, HttpStatus.OK);
	            }
	            map = workTimeService.importIPASWorkTimeDay(file);
	        }catch (Exception e){
	        	returnStr = e.toString();
	            listReturn.add(returnStr);
	        	map.put(CommonConstant.RETURN_ERROR, listReturn);
	        }
		return new ResponseEntity<>(map, HttpStatus.OK);
	}


	/**
	 * OMP--月工时批量导入
	 * @param file
	 * @param request
	 * @return
	 */
	@CrossOrigin
	@PostMapping(path = "/importOmpWorkTimeMonth" )
	public ResponseEntity<Map<String, List<Object>>> importOmpWorkTimeMonthExcl(@RequestParam("file") MultipartFile file,HttpServletRequest request){
		String returnStr;
		Map<String, List<Object>> map = new HashMap<>();
		List<Object> listReturn = new ArrayList<>();
		try
		{
			if(file.isEmpty()){
				returnStr = "文件不存在！";
				listReturn.add(returnStr);
				map.put(CommonConstant.RETURN_ERROR, listReturn);
				return new ResponseEntity<>(map, HttpStatus.OK);
			}
			map = workTimeService.importOmpWorkTimeMonth(file);
		}catch (Exception e){
			returnStr = e.toString();
			listReturn.add(returnStr);
			map.put(CommonConstant.RETURN_ERROR, listReturn);
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	/**
	 * OMP-- 日工時導入
	 * @param file
	 * @param request
	 * @return
	 */
	@CrossOrigin
	@PostMapping(path = "/importOmpWorkTimeDay")
	public ResponseEntity<Map<String, List<Object>>> importOmpWorkTimeDayExcl(@RequestParam("file") MultipartFile file,HttpServletRequest request){
		String returnStr = null;
		Map<String, List<Object>> map = new HashMap<>();
		List<Object> listReturn = new ArrayList<>();
		try
		{
			if(file.isEmpty()){
				returnStr = "文件不存在！";
				listReturn.add(returnStr);
				map.put(CommonConstant.RETURN_ERROR, listReturn);
				return new ResponseEntity<>(map, HttpStatus.OK);
			}
			map = workTimeService.importOmpWorkTimeDay(file);
		}catch (Exception e){
			returnStr = e.toString();
			listReturn.add(returnStr);
			map.put(CommonConstant.RETURN_ERROR, listReturn);
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	/**
	 * 导出excel月份差异信息
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value = "/exportDifMonth", method = RequestMethod.GET)
	public ResponseEntity<Result> exportDifMonth(HttpServletRequest request, HttpServletResponse response) {
		request.getSession();
		Result result = null;
		try {
			result = workTimeService.exportDifMonth(response);
			if (null == result) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	/**
	 * 导出excel日差异信息
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value = "/exportDifDay", method = RequestMethod.GET)
	public ResponseEntity<Result> exportDifDay(HttpServletRequest request, HttpServletResponse response) {
		request.getSession();
		Result result = null;
		try {
			result = workTimeService.exportDifDay(response);
			if (null == result) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	/**
	 * 导出OMP异常数据信息
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value = "/exportOMPException", method = RequestMethod.GET)
	public ResponseEntity<Result> exportOMPException(HttpServletRequest request, HttpServletResponse response) {
		request.getSession();
		Result result = null;
		try {
			result = workTimeService.exportOMPException(response);
			if (null == result) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	/**
	 * 导出OMP异常数据信息
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value = "/exportOMPException1", method = RequestMethod.GET)
	public ResponseEntity<Result> exportOMPWorkTimeException1(HttpServletRequest request, HttpServletResponse response) {
		request.getSession();
		Result result = null;
		try {
			result = workTimeService.exportOMPWorkTimeException1(response);
			if (null == result) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	/**
	 * 导出OMP异常数据信息
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value = "/exportOMPException2", method = RequestMethod.GET)
	public ResponseEntity<Result> exportOMPWorkTimeException2(HttpServletRequest request, HttpServletResponse response) {
		request.getSession();
		Result result = null;
		try {
			result = workTimeService.exportOMPWorkTimeException2(response);
			if (null == result) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}


	/**
	 * 导出OMP异常数据信息
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value = "/exportOMPOvertimes", method = RequestMethod.GET)
	public ResponseEntity<Result> exportOMPOvertimes(HttpServletRequest request, HttpServletResponse response) {
		request.getSession();
		Result result = null;
		try {
			result = workTimeService.exportOMPOvertimes(response);
			if (null == result) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}


	/**
	 * 导出OMP个人汇总数据信息
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value = "/exportOMPSumtimes", method = RequestMethod.GET)
	public ResponseEntity<Result> exportOMPSumtimes(HttpServletRequest request, HttpServletResponse response) {
		request.getSession();
		Result result = null;
		try {
			result = workTimeService.exportOMPSumtimes(response);
			if (null == result) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	/**
	 * 导出OMP数据信息
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value = "/exportOMPSumPduAndDeptment", method = RequestMethod.GET)
	public ResponseEntity<Result> exportOMPSumPduAndDeptment(HttpServletRequest request, HttpServletResponse response) {
		request.getSession();
		Result result = null;
		try {
			result = workTimeService.exportOMPSumPduAndDeptment(response);
			if (null == result) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}


	/**
	 * TM考勤异常明细信息
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value = "/exportAllOMPException", method = RequestMethod.GET)
	public ResponseEntity<Result> exportAllOMPException(HttpServletRequest request, HttpServletResponse response) {
		request.getSession();
		Result result = null;
		try {
			result = workTimeService.exportAllOMPException(response);
			if (null == result) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
