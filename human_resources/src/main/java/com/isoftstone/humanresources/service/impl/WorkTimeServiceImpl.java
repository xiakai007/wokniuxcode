package com.isoftstone.humanresources.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isoftstone.humanresources.dao.*;
import com.isoftstone.humanresources.domain.Result;
import com.isoftstone.humanresources.domain.SystemConfigInformation;
import com.isoftstone.humanresources.domain.workTime.*;
import com.isoftstone.humanresources.service.TerminalInfoService;
import com.isoftstone.humanresources.util.*;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import com.isoftstone.humanresources.controller.OrganizationController;
import com.isoftstone.humanresources.domain.EmployeeWorkTimeDayInformation;
import com.isoftstone.humanresources.domain.EmployeeWorkTimeMonthInfomation;
import com.isoftstone.humanresources.service.WorkTimeService;

@Service
public class WorkTimeServiceImpl implements WorkTimeService{

	@Autowired
	private WorkTimeDao workTimeDao;
	@Autowired
	private WorkTimeMonthIpsaDao workTimeMonthIpsaDao;
	@Autowired
	private WorkTimeDayIpsaDao workTimeDayIpsaDao;
	@Autowired
	private WorkTimeDayOmpDao workTimeDayOmpDao;
	@Autowired
	private WorkTimeMonthOmpDao workTimeMonthOmpDao;

	@Autowired
	private SystemConfigDao systemConfigDao;


	@Resource
	private TerminalInfoService terminalInfoService;

	 private final static Logger logger = LoggerFactory.getLogger(WorkTimeServiceImpl.class);
	
	@Override
	public Map<String, List<Object>> importIPASWorkTimeDay(MultipartFile file) throws IOException {
		List<WorkTimeDayIpsaModel> list = new ArrayList<>();
		StringBuilder st = new StringBuilder();
		Map<String, List<Object>> map = new HashMap<>();
		List<Object> listReturn = new ArrayList<>();
        List<Object> listReturnError = new ArrayList<>();
		try {

			WorkTimeDayIpsaModel vo = null;
			InputStream in = file.getInputStream();
			/**
			 * 获取excl表中的值
			 */
			List<List<Object>> listob = new ImportExcelUtil().getOmpBankListByExcel(in,file.getOriginalFilename(),0 , 1, 25);
			in.close();
			for (int i = 0; i < listob.size(); i++) {
				vo = new WorkTimeDayIpsaModel();
				vo.setEmployeeid(StringUtil.isEmpty(String.valueOf(listob.get(i).get(0)))?0:ConversionUtils.trimPoint(String.valueOf(listob.get(i).get(0))));
				vo.setEmployeename(String.valueOf(listob.get(i).get(1)));
				vo.setCardid(String.valueOf(listob.get(i).get(2)));
				vo.setWorkarea(String.valueOf(listob.get(i).get(5)));
				vo.setWorkstatus(String.valueOf(listob.get(i).get(3)));
				vo.setPersonalstatus(String.valueOf(listob.get(i).get(4)));
				//班次名称
				vo.setDaycount(String.valueOf(listob.get(i).get(7)));
				//考勤日期
				vo.setWorkday(String.valueOf(listob.get(i).get(8)));
				//日期类型
				vo.setDaycatagray(String.valueOf(listob.get(i).get(9)));
				vo.setFirstrecordPlace(String.valueOf(listob.get(i).get(12)));
				vo.setFirstrecordtime(String.valueOf(listob.get(i).get(11)));
				vo.setLastRecordPlace(String.valueOf(listob.get(i).get(15)));
				vo.setLastrecordtime(String.valueOf(listob.get(i).get(14)));

				vo.setActualtimes(ConversionUtils.getBigDecimal(listob.get(i).get(16)));
				vo.setHolidaytimes(ConversionUtils.getBigDecimal(listob.get(i).get(18)));
				vo.setBusinessTimes(ConversionUtils.getBigDecimal(listob.get(i).get(19)));
				vo.setOutworktimes(ConversionUtils.getBigDecimal(listob.get(i).get(20)));
				//旷工、迟到、早退、延迟工时，加班工时
				vo.setAbsenteeismtimes(ConversionUtils.getBigDecimal(listob.get(i).get(21)));
				vo.setLatetimes(ConversionUtils.getBigDecimal(String.valueOf(listob.get(i).get(22))));
				vo.setPenalizetimes(ConversionUtils.getBigDecimal(String.valueOf(listob.get(i).get(23))));
				vo.setExtendtimes(ConversionUtils.getBigDecimal(String.valueOf(listob.get(i).get(24))));
				vo.setOvertimes(ConversionUtils.getBigDecimal(listob.get(i).get(25)));

				//合作类型
//				vo.setCopcatagray(String.valueOf(listob.get(i).get(8)));
//				vo.setCopmodel(String.valueOf(listob.get(i).get(8)));
//				vo.setMonthinshore(String.valueOf(listob.get(i).get(8)));
//				vo.setCu(String.valueOf(listob.get(i).get(58)));
				list.add(vo);
			}
			map.put("importFailure", listReturn);
			if(CollectionUtils.isEmpty(listReturn)) {
				//先进行删除然后再添加
				int delNum = workTimeDayIpsaDao.removeWorkTimeDayIpsaById(null);
				logger.info("removeWorkTimeDayIpsaById is："+delNum);
				int result = workTimeDayIpsaDao.importWorkTimeDay(list);
				if (result == 0) {
					st.append("新增到数据库异常");
					listReturnError.add(st.toString());
					map.put(CommonConstant.RETURN_ERROR, listReturnError);
					return map;
				}
			}
			}catch (Exception e) {
				listReturnError.add(e.toString());
            	map.put(CommonConstant.RETURN_ERROR, listReturnError);
                return map;
			}
		return map;
	}

	@Override
	public void loadExcl(HttpServletResponse response, HttpServletRequest request,String fileName)throws Exception {
		
		OutputStream outp = null;
		FileInputStream in = null;
		try {
			String ctxPath = System.getProperty("user.dir") + "/src/main/resources/templates/";
			String filedownload = ctxPath + fileName;
			fileName = URLEncoder.encode(fileName, "UTF-8");
			// 要下载的模板所在的绝对路径
			response.reset();
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
			response.setContentType("application/octet-stream;charset=UTF-8");
			outp = response.getOutputStream();
			in = new FileInputStream(filedownload);
			response.setHeader("Content-Length", String.valueOf(in.available()));
			byte[] b = new byte[1024];
			int i = 0;
			while ((i = in.read(b)) > 0) {
				outp.write(b, 0, i);
			}
			outp.flush();

		} catch (IOException e) {
			throw new IOException(e);
		} finally {
			if (in != null) {
				in.close();
				in = null;
			}
			if (outp != null) {
				outp.close();
				outp = null;
			}
		}

	}

	@Override
	public Map<String, List<Object>> importIPASWorkTimeMonth(MultipartFile file) throws IOException {
		List<WorkTimeMonthIpsaModel> list = new ArrayList<>();
		StringBuilder st = new StringBuilder();
		Map<String, List<Object>> map = new HashMap<>();
		List<Object> listReturn = new ArrayList<>();
        List<Object> listReturnError = new ArrayList<>();
		try {

			WorkTimeMonthIpsaModel vo = null;
			InputStream in =null;
			List<List<Object>> listob = null;
			in = file.getInputStream();
			/**
			 * 获取excl表中的值
			 */
//			listob = CsvReadUtil.readCsv(in);
			listob = new ImportExcelUtil().getBankListByExcel(in,file.getOriginalFilename(),0);
			in.close();
			for (int i = 0; i < listob.size(); i++) {
				vo = new WorkTimeMonthIpsaModel();
//				if(!empList.contains(StringUtil.isEmpty(String.valueOf(listob.get(i).get(0)))?0:ConversionUtils.trimPoint(String.valueOf(listob.get(i).get(0))))){
//					listReturn.add(listob.get(i));
//					continue;
//				}
				vo.setEmployeeid(StringUtil.isEmpty(String.valueOf(listob.get(i).get(0)))?0:ConversionUtils.trimPoint(String.valueOf(listob.get(i).get(0))));
				vo.setEmployeename(String.valueOf(listob.get(i).get(1)));
				vo.setCardid(String.valueOf(listob.get(i).get(2)));
				vo.setArea(String.valueOf(listob.get(i).get(6)));
				vo.setMonth( String.valueOf(listob.get(i).get(7)).replace("\"","").replace("-",""));
				vo.setShoulddays(new Double(Double.parseDouble(String.valueOf(listob.get(i).get(8)))).intValue());
				vo.setActualdays(ConversionUtils.getBigDecimal(listob.get(i).get(9)));
				vo.setShouldtimes(ConversionUtils.getBigDecimal(listob.get(i).get(10)));
				vo.setActualtimes(ConversionUtils.getBigDecimal(listob.get(i).get(11)));
				//请假工时
				vo.setHolidaytimes(ConversionUtils.getBigDecimal(listob.get(i).get(12)));
				vo.setBusinesstimes(ConversionUtils.getBigDecimal(String.valueOf(listob.get(i).get(13))));
				vo.setBusinesstriptimes(ConversionUtils.getBigDecimal(String.valueOf(listob.get(i).get(14))));
				vo.setLatetimes(ConversionUtils.getBigDecimal(String.valueOf(listob.get(i).get(15))));
				vo.setLeaveearlytimes(ConversionUtils.getBigDecimal(String.valueOf(listob.get(i).get(16))));
				vo.setAbsenteeismtimes(ConversionUtils.getBigDecimal(String.valueOf(listob.get(i).get(17))));
				vo.setOwetimes(ConversionUtils.getBigDecimal(listob.get(i).get(18)));
				vo.setOvertimenum(new Double(Double.parseDouble(String.valueOf(listob.get(i).get(20)))).intValue());
				vo.setOvertimes(ConversionUtils.getBigDecimal(listob.get(i).get(19)));
				vo.setExtendtimes(ConversionUtils.getBigDecimal(String.valueOf(listob.get(i).get(21))));
				list.add(vo);
			}
			map.put("importFailure", listReturn);
            if (st.length() > 0) {
            	listReturnError.add(st.toString());
            	map.put(CommonConstant.RETURN_ERROR, listReturnError);
                return map;
            }
			if((!list.isEmpty()) && list.size() > 0)
			{
				int delNum = workTimeMonthIpsaDao.removeWorkTimeMonthIpsaById(null);
				logger.info("removeWorkTimeMonthIpsaById is："+delNum);
				int result = this.workTimeMonthIpsaDao.importWorkTimeMonth(list);
				if(result == 0){
					st.append("新增到数据库失败");
					listReturnError.add(st.toString());
					map.put(CommonConstant.RETURN_ERROR, listReturnError);
					return map;
				}
			}else
			{
				st.append("请输入数据");
				listReturnError.add(st.toString());
            	map.put(CommonConstant.RETURN_ERROR, listReturnError);
                return map;
			}
			
			}catch(Exception e){
				st.append("excl导入异常"+e.toString());
			}
		return map;
	}
	
	/**
	 * 批量导入日考勤信息
	 * @param list
	 * @param result
	 * @return
	 */
	private int batchSave(List<EmployeeWorkTimeDayInformation> list,int result){
		int size = list.size();
		int index = 0;
		boolean flag = true;
		try {
			while(flag) {
				if(index+5000>=size) {
					result += workTimeDao.importWorkTimeDay(list.subList(index, size-1));
					flag = false;
				}else {
					result += workTimeDao.importWorkTimeDay(list.subList(index, index+5000));
					index = index+5000;
				}
				
			}
		} catch (Exception e) {
			result = 0;
		}
		return result;
	}

	/**
	 * 导入OMP的月工时信息
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@Override
	public Map<String, List<Object>> importOmpWorkTimeMonth(MultipartFile file) throws IOException {
		List<WorkTimeMonthOmpModel> list = new ArrayList<>();
		StringBuilder st = new StringBuilder();
		Map<String, List<Object>> map = new HashMap<>();
		List<Object> listReturn = new ArrayList<>();
		List<Object> listReturnError = new ArrayList<>();

		List<SystemConfigInformation> listSys = systemConfigDao.queryConfigByType("pdu");
		try {

			WorkTimeMonthOmpModel vo = null;
			List<FileModel> unzipFile = new ImportExcelUtil().unzip(file);
			for(FileModel model : unzipFile) {
				List<List<Object>> listob = new ImportExcelUtil().getOmpBankListByExcel(model.getFileInputstream(),model.getFileName(), 1,3,20);

				String[] fileName = model.getFileName().split("_");

				model.getFileInputstream().close();
				logger.error("----------："+model.getFileName());
				for (int i = 0; i < listob.size(); i++) {
					if(StringUtil.isEmpty(String.valueOf(listob.get(i).get(1)))||"姓名".equals(String.valueOf(listob.get(i).get(1))) ){
						continue;
					}
					vo = new WorkTimeMonthOmpModel();
					vo.setEmployeename(String.valueOf(listob.get(i).get(1)));
					logger.error("-----name:-----："+String.valueOf(listob.get(i).get(1)));
					vo.setCardid(String.valueOf(listob.get(i).get(2)));
					vo.setMonth(fileName[0]);
					vo.setShouldtimes(listob.get(i).get(5) == null || StringUtil.isEmpty(String.valueOf(listob.get(i).get(5)))  ? new BigDecimal(0.00) : ConversionUtils.getBigDecimal(listob.get(i).get(5)));
					vo.setHolidaytimes(listob.get(i).get(6) == null || StringUtil.isEmpty(String.valueOf(listob.get(i).get(6)))  ? new BigDecimal(0.00) : ConversionUtils.getBigDecimal(listob.get(i).get(6)));

					vo.setAbsenteeismtimes(listob.get(i).get(7) == null || StringUtil.isEmpty(String.valueOf(listob.get(i).get(7))) ? new BigDecimal(0.00) : ConversionUtils.getBigDecimal(listob.get(i).get(7)));
					vo.setLatetimes(listob.get(i).get(8) == null|| StringUtil.isEmpty(String.valueOf(listob.get(i).get(8)))  ? new BigDecimal(0.00) : ConversionUtils.getBigDecimal(listob.get(i).get(8)));
					vo.setLeaveearlytimes(listob.get(i).get(9) == null || StringUtil.isEmpty(String.valueOf(listob.get(i).get(9))) ? new BigDecimal(0.00) : ConversionUtils.getBigDecimal(listob.get(i).get(9)));
					vo.setBusinesstimes(listob.get(i).get(10) == null || StringUtil.isEmpty(String.valueOf(listob.get(i).get(10))) ? new BigDecimal(0.00) : ConversionUtils.getBigDecimal(listob.get(i).get(10)));
					vo.setSupplysigninnum(listob.get(i).get(11) == null || StringUtil.isEmpty(String.valueOf(listob.get(i).get(11))) ? 0:Integer.parseInt(String.valueOf(listob.get(i).get(11))));

					vo.setServertimes(listob.get(i).get(12) == null|| StringUtil.isEmpty(String.valueOf(listob.get(i).get(12)))  ? new BigDecimal(0.00) :ConversionUtils.getBigDecimal(listob.get(i).get(12)));
					vo.setRealtimes(listob.get(i).get(13) == null|| StringUtil.isEmpty(String.valueOf(listob.get(i).get(13)))  ? new BigDecimal(0.00) :ConversionUtils.getBigDecimal(listob.get(i).get(13)));

					vo.setOwetimes(listob.get(i).get(14) == null|| StringUtil.isEmpty(String.valueOf(listob.get(i).get(14)))  ? new BigDecimal(0.00) :ConversionUtils.getBigDecimal(listob.get(i).get(14)));
					vo.setOvertimes(listob.get(i).get(15) == null || StringUtil.isEmpty(String.valueOf(listob.get(i).get(15))) ? new BigDecimal(0.00) :ConversionUtils.getBigDecimal(listob.get(i).get(15)));
					vo.setMonthInShore(String.valueOf(listob.get(i).get(16)));
					vo.setPaytimes(listob.get(i).get(17) == null || StringUtil.isEmpty(String.valueOf(listob.get(i).get(17))) ? new BigDecimal(0.00) :ConversionUtils.getBigDecimal(listob.get(i).get(17)));
//					vo.setExtendtimes(ConversionUtils.getBigDecimal(listob.get(i).get(12)));
					vo.setPdu(fileName[5]);
					vo.setArea(fileName[2]);
					vo.setPo(String.valueOf(listob.get(i).get(0)));
					//根据PDU信息找到对应的交付部
					vo.setPartnerPm(String.valueOf(listob.get(i).get(19)));
					for(SystemConfigInformation information :listSys){
						if(information.getConfigName().equals(fileName[5])){
							vo.setDepartment(information.getConfigValue());
							break;
						}
					}
					list.add(vo);
				}
			}

//			map.put("importFailure", listReturn);
//			if (st.length() > 0) {
//				listReturnError.add(st.toString());
//				map.put(CommonConstant.RETURN_ERROR, listReturnError);
//				return map;
//			}
			if((!list.isEmpty()) && list.size() > 0)
			{
				int delNum = workTimeMonthOmpDao.removeWorkTimeMonthOmpById(null);
				logger.info("removeWorkTimeMonthOmpById is："+delNum);
				int result = this.workTimeMonthOmpDao.importWorkTimeMonth(list);
				if(result == 0){
					st.append("新增到数据库失败");
					listReturnError.add(st.toString());
					map.put(CommonConstant.RETURN_ERROR, listReturnError);
					return map;
				}
			}else
			{
				st.append("请输入数据");
				listReturnError.add(st.toString());
				map.put(CommonConstant.RETURN_ERROR, listReturnError);
				return map;
			}

		}catch(Exception e){
			st.append("excl导入异常"+e.toString());
		}
		return map;
	}

	//导入Omp的日工时信息

	/**
	 * 导入Omp的日工时信息
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@Override
	public Map<String, List<Object>> importOmpWorkTimeDay(MultipartFile file) throws IOException {
		List<WorkTimeDayOmpModel> list = new ArrayList<WorkTimeDayOmpModel>();
		StringBuilder st = new StringBuilder();
		Map<String, List<Object>> map = new HashMap<>();
		List<Object> listReturn = new ArrayList<Object>();
		List<Object> listReturnError = new ArrayList<Object>();
		try {

			WorkTimeDayOmpModel vo = null;
			List<FileModel> unzipFile = new ImportExcelUtil().unzip(file);
			//获取终端设备的配置信息
			List<TerminalInfoModel> terminalInfoModelList = terminalInfoService.queryListTerminalInfo(null ,null) ;
			String day = CommonConstant.EMPTY_STRING ;
			String cardid = CommonConstant.EMPTY_STRING ;
			String name  = CommonConstant.EMPTY_STRING ;
			String terminalIds = CommonConstant.EMPTY_STRING ;
			String terminalIdShore = CommonConstant.EMPTY_STRING ;
			String terminalNames = CommonConstant.EMPTY_STRING ;
			String  terminalId= CommonConstant.EMPTY_STRING ;
			String  timeMsg= CommonConstant.EMPTY_STRING ;
			List<String> timeList = null ;

			for(FileModel model : unzipFile) {

				Map<Integer ,List<List<Object>>>  dayMap   = new ImportExcelUtil().getOmpBankListByExcelForEveryDay(model.getFileInputstream(),model.getFileName(), 5,1,19);
				//签到汇总信息
				List<List<Object>> listob = dayMap.get(0);
				//签到明细信息
				List<List<Object>> listobDetail = dayMap.get(1);

				List<List<Object>> listobOverTimeDetail = dayMap.get(2);

				String[] fileName = model.getFileName().split("_");
				model.getFileInputstream().close();

				for (int i =0; i < listob.size(); i++) {
					vo = new WorkTimeDayOmpModel();
					name =String.valueOf(listob.get(i).get(2));
					vo.setEmployeename(name);
					cardid = String.valueOf(listob.get(i).get(0));
					vo.setCardid(cardid);
					day = DateUtil.formatDate(DateUtil.getDate( Integer.parseInt( String.valueOf(listob.get(i).get(3)).replace(".0000","") )),"yyyy-MM-dd");
					vo.setWorkday(day);
					vo.setWorkcatagray(String.valueOf(listob.get(i).get(12)));
					vo.setPo(String.valueOf(listob.get(i).get(9)));
					vo.setPersonstatus(String.valueOf(listob.get(i).get(13)));

					vo.setActualtimes(listob.get(i).get(14) == null || StringUtil.isEmpty(String.valueOf(listob.get(i).get(14)))  ? new BigDecimal(0.00) : ConversionUtils.getBigDecimal(listob.get(i).get(14)));
					vo.setHolidaytimes(listob.get(i).get(15) == null || StringUtil.isEmpty(String.valueOf(listob.get(i).get(15)))  ? new BigDecimal(0.00) : ConversionUtils.getBigDecimal(listob.get(i).get(15)));
					vo.setAbsenteeismtimes(listob.get(i).get(16) == null || StringUtil.isEmpty(String.valueOf(listob.get(i).get(16))) ? new BigDecimal(0.00) : ConversionUtils.getBigDecimal(listob.get(i).get(16)));
					vo.setPenalizetimes(listob.get(i).get(17) == null || StringUtil.isEmpty(String.valueOf(listob.get(i).get(17))) ? new BigDecimal(0.00) :ConversionUtils.getBigDecimal(listob.get(i).get(17)));
					vo.setOvertimes(listob.get(i).get(19) == null || StringUtil.isEmpty(String.valueOf(listob.get(i).get(19))) ? new BigDecimal(0.00) :ConversionUtils.getBigDecimal(listob.get(i).get(19)));
//					vo.setExtendtimes(listob.get(i).get(15) == null || StringUtil.isEmpty(String.valueOf(listob.get(i).get(15))) ? new BigDecimal(0.00) :ConversionUtils.getBigDecimal(listob.get(i).get(15)));
					vo.setCopcatagray(String.valueOf(listob.get(i).get(4)));
					vo.setCopmodel(String.valueOf(listob.get(i).get(5)));
					vo.setMonthinshore(String.valueOf(listob.get(i).get(6)));
					terminalIds = CommonConstant.EMPTY_STRING;
					terminalNames = CommonConstant.EMPTY_STRING ;
					terminalIdShore = CommonConstant.EMPTY_STRING;
					timeMsg= CommonConstant.EMPTY_STRING ;
					timeList = new ArrayList<String>();
					//条件需匹配： 身份证信息、名字、日期匹配
					//把符合条件的数据放在list中
					for (int j =0; j < listobDetail.size(); j++) {
						if( !cardid.equals(String.valueOf(listobDetail.get(j).get(0)))||!name.equals(String.valueOf(listobDetail.get(j).get(2))) ||
								!day.equals(DateUtil.formatDate(DateUtil.getDate( Integer.parseInt( String.valueOf(listobDetail.get(j).get(8)).replace(".0000","") )),"yyyy-MM-dd"))){
							continue;
						}
						//如果时间大于5点半则记录下来
						if(DateUtil.greaterDownhour(String.valueOf(listobDetail.get(j).get(9)))) {
							timeList.add(String.valueOf(listobDetail.get(j).get(9)));
						}
						terminalId= String.valueOf(listobDetail.get(j).get(3)).replace(".0000","") ;
						terminalIdShore = terminalIdShore + terminalId  + "," ;
						terminalIds = terminalIds +  getTerminalType(terminalId,terminalInfoModelList) + "," ;
						terminalNames = terminalNames + getTerminalName(terminalId,terminalInfoModelList) + "," ;
						timeMsg = timeMsg + listobDetail.get(j).get(9) +  "," ;
						if(!StringUtil.isEmpty(String.valueOf(listobDetail.get(j).get(11)))){
							vo.setReplenish(String.valueOf(listobDetail.get(j).get(11)));
							vo.setReplenishMsg(String.valueOf(listobDetail.get(j).get(12)));
							vo.setReplenishTime(String.valueOf(listobDetail.get(j).get(9)));
							if(String.valueOf(listobDetail.get(j).get(11)).equals("补签")||String.valueOf(listobDetail.get(j).get(11)).equals("请假")||String.valueOf(listobDetail.get(j).get(11)).equals("补签到")){
								vo.setEmployeeid(1);
							}
						}
					}

					//把符合条件的数据放在list中
					for (int k =0; k < listobOverTimeDetail.size(); k++) {
						if( cardid.equals(String.valueOf(listobOverTimeDetail.get(k).get(0)))&& name.equals(String.valueOf(listobOverTimeDetail.get(k).get(2))) &&
								 day.equals(DateUtil.formatDate(DateUtil.getDate( Integer.parseInt( String.valueOf(listobOverTimeDetail.get(k).get(3)).replace(".0000","") )),"yyyy-MM-dd"))){
							vo.setReplenish("加班");
							vo.setReplenishMsg(String.valueOf(listobOverTimeDetail.get(k).get(9)));
							vo.setReplenishTime(String.valueOf(listobOverTimeDetail.get(k).get(6))+"--"+String.valueOf(listobOverTimeDetail.get(k).get(7)));
							break;
						}
					}

					//判断当天打卡有没有补工时嫌疑
					if(timeList.size()>2){
						Collections.sort(timeList);
						//与这个时间作比较
						if(DateUtil.greater1hour(timeList.get(0),timeList.get(timeList.size()-1)) ){
							vo.setException1("1");
						}else{
							vo.setException1("0");
						}
					}
					vo.setShoreMsg(terminalIds);
					vo.setSignMsg(terminalNames);
					vo.setTerminalIds(terminalIdShore);
					vo.setPdu(fileName[5]);
					vo.setArea(fileName[2]);
					vo.setBak(timeMsg);
					vo.setMonthStr(fileName[0]);
					list.add(vo);
				}
			}

//			map.put("importFailure", listReturn);
//			if (st.length() > 0) {
//				listReturnError.add(st.toString());
//				map.put(CommonConstant.RETURN_ERROR, listReturnError);
//				return map;
//			}
			if((!list.isEmpty()) && list.size() > 0)
			{
				int delNum = workTimeDayOmpDao.removeWorkTimeDayOmpById(null);
				logger.info("removeWorkTimeDayOmpById is："+delNum);

//				List<List<WorkTimeDayOmpModel>> split = split(list , 10);
//				for (int i = 0,length = split.size(); i < length; i++) {
//					System.out.println(split.get(i));
//				}
				int result = this.workTimeDayOmpDao.importWorkTimeDay(list);
				if(result == 0){
					st.append("新增到数据库失败");
					listReturnError.add(st.toString());
					map.put(CommonConstant.RETURN_ERROR, listReturnError);
					return map;
				}
			}else
			{
				st.append("请输入数据");
				listReturnError.add(st.toString());
				map.put(CommonConstant.RETURN_ERROR, listReturnError);
				return map;
			}

		}catch(Exception e){
			logger.error(e.toString());
			st.append("excl导入异常"+e.toString());
		}
		return map;
	}

	public String getTerminalName(String  terminalId ,List<TerminalInfoModel> terminalInfoModelList ){
		for(TerminalInfoModel terminalInfo: terminalInfoModelList ){
			if(terminalInfo.getTerminalId().equals(terminalId)){
				return terminalInfo.getAddress() ;
			}
		}
		return terminalId ;
	}

	public String getTerminalType(String  terminalId ,List<TerminalInfoModel> terminalInfoModelList ){
		for(TerminalInfoModel terminalInfo: terminalInfoModelList ){
			if(terminalInfo.getTerminalId().equals(terminalId)){
				return terminalInfo.getShoreType() ;
			}
		}
		return terminalId ;
	}

	/**
	 * 月差异数据导出
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public Result exportDifMonth(HttpServletResponse response) throws Exception{
		//得到所有要导出的数据
		List<ExportDiffentMonth> diffentMonthList = new ArrayList<ExportDiffentMonth>();
		try {
			diffentMonthList = workTimeMonthOmpDao.exportDifMonth();
			//定义导出的excel名字
			String excelName = "工时月度差异表";
			//获取需要转出的excel表头的map字段
			LinkedHashMap<String, String> fileMap = new LinkedHashMap<>();
			fileMap.put("ipsaemployeeID","IPSA-工号");
			fileMap.put("ipsaemployeeName","IPSA-姓名");
			fileMap.put("ipsaarea","IPSA-区域");
			fileMap.put("omppdu","PDU");
			fileMap.put("ipsamonth","统计月份");
			fileMap.put("ipsashouldDays","IPSA-应出勤天数" );
			fileMap.put("ipsaactualDays","IPSA-实际出勤天数");
			fileMap.put("ipsashouldTimes","IPSA-应出勤工时");
			fileMap.put("ompshouldTimes","OMP-应出勤工时");
			fileMap.put("ipsaactualTimes","IPSA-工作日出勤工时");
			fileMap.put("ipsaholidayTimes","IPSA-请假工时");
			fileMap.put("ompholidayTimes","OMP-请假工时");
			fileMap.put("ipsabusinessTimes","IPSA-公出工时");
			fileMap.put("ompbusinessTimes","OMP-外出公干总工时");
			fileMap.put("ipsabusinessTripTimes","IPSA-出差工时");
			fileMap.put("ipsalateTimes","IPSA-迟到工时");
			fileMap.put("omplateTimes","OMP-迟到工时");
			fileMap.put("ipsaLeaveEarlyTimes","IPSA-早退工时");
			fileMap.put("ompLeaveEarlyTimes","OMP-早退工时");
			fileMap.put("ipsaabsenteeismTimes","IPSA-旷工工时");
			fileMap.put("ompabsenteeismTimes","OMP-旷工工时");
			fileMap.put("ipsaoweTimes","IPSA-欠工时");
			fileMap.put("ompoweTimes","OMP-欠工时");
			fileMap.put("ipsaovertimeNum","IPSA-加班次数");
			fileMap.put("ipsaovertimes","IPSA-加班工时");
			fileMap.put("ompoverTimes","OMP-加班总工时");
			fileMap.put("ipsaextendTimes","IPSA-工作日延长工时");
			fileMap.put("ompoutTimes","OMP-延长工时");
			fileMap.put("ompsupplySignInNum","OMP-补签到次数");

			fileMap.put("ompserverTimes","OMP-最低服务工时");
			fileMap.put("omprealTimes","OMP-实际打卡工时");
			fileMap.put("omppayTimes","OMP-付费总工时");
			fileMap.put("ompmonthInShore","OMP-月度在岸/离岸" );

			fileMap.put("difworkTimes","出勤工时差异");
			fileMap.put("difholidayTimes","请假工时差异");
			fileMap.put("diflateLeaveTimes","迟到&早退工时差异");
			fileMap.put("difabsenteeismTimes","旷工工时差异");
			fileMap.put("difoverTimes","加班工时差异");
			fileMap.put("difextendTimes","延长工时差异");

			//导出用户相关信息
			ExportExcelUtils.export(excelName, diffentMonthList, fileMap, response);
			return new Result(true, "导出成功");
		} catch (Exception e) {
			logger.error(e.toString());
			return new Result(false, "导出失败");
		}
	}

	/**
	 * 日差异数据导出
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public Result exportDifDay(HttpServletResponse response) throws Exception{
		//得到所有要导出的数据
		List<ExportDiffentDay> diffentDayList = new ArrayList<ExportDiffentDay>();
		try {
			diffentDayList = workTimeMonthOmpDao.exportDifDay();
			//定义导出的excel名字
			String excelName = "工时日差异表";
			//获取需要转出的excel表头的map字段
			LinkedHashMap<String, String> fileMap = new LinkedHashMap<>();
			fileMap.put("ipsaemployeeID","IPSA-工号");
			fileMap.put("ipsaemployeeName","IPSA-员工姓名");
			fileMap.put("ipsaworkArea","IPSA-工作地");
			fileMap.put("ipsaworkStatus","IPSA-考勤状态");
			fileMap.put("ipsapersonalStatus","IPSA-人员状态");
			fileMap.put("ipsadayCount","IPSA-班次");
			fileMap.put("ipsaworkDay","IPSA-考勤日期yyyy-MM-dd");
			fileMap.put("ipsadayCatagray","IPSA-日期类型");
			fileMap.put("ipsafirstRecordPlace","IPSA-初次打卡地点");
			fileMap.put("ipsafirstRecordTime","IPSA-初次打卡");
			fileMap.put("ipsalastRecordPlace","IPSA-末次打卡地点");
			fileMap.put("ipsalastRecordTime","IPSA-末次打卡");
			fileMap.put("ipsaactualTimes","IPSA-出勤工时");
			fileMap.put("ipsaholidayTimes","IPSA-请假工时");
			fileMap.put("ipsabusinessTimes","IPSA-出差工时");
			fileMap.put("ipsaoutWorkTimes","IPSA-因公外出工时");
			fileMap.put("ipsaabsenteeismTimes","IPSA-旷工工时");
			fileMap.put("ipsaworkBadTimes","IPSA-异常工时");
			fileMap.put("ipsapenalizeTimes","IPSA-早退处罚工时");
			fileMap.put("ipsalateTimes","IPSA-迟到工时");
			fileMap.put("ipsaovertimes","IPSA-加班工时");
			fileMap.put("ipsaextendTimes","IPSA-延长工时");
			fileMap.put("ipsacopCatagray","IPSA-合作类型");
			fileMap.put("ipsacopModel","IPSA-合作模式");
			fileMap.put("ipsamonthInShore","IPSA-月度在岸/离岸");

			fileMap.put("omppo","OMP-PO");
			fileMap.put("omppersonStatus","OMP-人员状态");
			fileMap.put("ompactualTimes","OMP-出勤工时");
			fileMap.put("ompholidayTimes","OMP-请假工时");
			fileMap.put("ompabsenteeismTimes","OMP-旷工工时");
			fileMap.put("omppenalizeTimes","OMP-早退处罚工时");
			fileMap.put("ompovertimes","OMP-加班工时");
			fileMap.put("ompextendTimes","OMP-延长工时");
			fileMap.put("ompcopCatagray","OMP-合作类型");
			fileMap.put("ompcopModel","OMP-合作模式");
			fileMap.put("ompmonthInShore","OMP-月度在岸/离岸");

			fileMap.put("shoreMsg","当日打卡在离岸");
			fileMap.put("signMsg","当日打卡卡机信息");

			fileMap.put("difworkTimes","出勤工时差异");
			fileMap.put("difholidayTimes","请假工时差异");
			fileMap.put("diflateLeaveTimes","迟到&早退工时差异");
			fileMap.put("difabsenteeismTimes","旷工工时差异");
			fileMap.put("difoverTimes","加班工时差异");

			//导出用户相关信息
			ExportExcelUtils.export(excelName, diffentDayList, fileMap, response);
			return new Result(true, "导出成功");
		} catch (Exception e) {
			logger.error(e.toString());
			return new Result(false, "导出失败");
		}
	}

	/**
	 * 判断数组内元素是否全部相同
	 * @param a
	 * @return
	 */
	public Boolean getDiffent(String[] a){
		for(int i=0; i<a.length-1; i++) {
			//如果有请假和补签到的则不记录
			if(a[i].equals("请假")||a[i].equals("补签到")||a[i].equals("补签")){
				return true;
			}
			for (int j=i+1; j<a.length; j++) {
				if(a[j].equals("请假")||a[j].equals("补签到")||a[j].equals("补签")){
					return true;
				}
				//j从个i+1开始就可以了，因为i以前都比较过了
				if (!a[i].equals(a[j])) return false; //如果有一个不同就说明不一致
			}
		}
		return true; //能走到这里就说明全一致
	}

	/**
	 * OMP日考勤异常数据导出--异地打卡
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public Result exportOMPException(HttpServletResponse response) throws Exception{
		//得到所有要导出的数据
		List<WorkTimeDayOmpModel>  workTimeDayOmpModelList = new ArrayList<WorkTimeDayOmpModel>();

		List<WorkTimeDayOmpModel>  exportList = new ArrayList<WorkTimeDayOmpModel>();
		try {
			workTimeDayOmpModelList = workTimeDayOmpDao.queryAllWorkTimeDayOmp();
			for(WorkTimeDayOmpModel model: workTimeDayOmpModelList){
				if( StringUtil.isEmpty(model.getShoreMsg())){
					continue;
				}
				String[] tmpStr = model.getShoreMsg().substring(0,model.getShoreMsg().length()-1).split(",");
				//一条记录的不关注 :请假、加班到凌晨等
				if(tmpStr.length ==1){
					continue;
				}
				//
				if( !getDiffent(tmpStr)){
					exportList.add(model);
				}
			}

			//定义导出的excel名字
			String excelName = "OMP工时异地打卡数据表";
			//获取需要转出的excel表头的map字段
			LinkedHashMap<String, String> fileMap = new LinkedHashMap<>();
			fileMap.put("area","区域");
			fileMap.put("pdu","所在PDU");
			fileMap.put("po","PO");
			fileMap.put("employeename","员工姓名");
			fileMap.put("monthStr","月份");
			fileMap.put("workday","考勤日期yyyy-MM-dd");
			fileMap.put("personstatus","人员状态");
			fileMap.put("workcatagray","班次类型");
			fileMap.put("monthinshore","OMP-月度在岸/离岸");
			fileMap.put("terminalIds","当日打卡卡机编号");
			fileMap.put("shoreMsg","当日打卡在离岸");
			fileMap.put("signMsg","当日打卡卡机信息");

			//导出用户相关信息
			ExportExcelUtils.export(excelName, exportList, fileMap, response);
			return new Result(true, "导出成功");
		} catch (Exception e) {
			logger.error(e.toString());
			return new Result(false, "导出失败");
		}
	}


	/**
	 * OMP日考勤异常数据导出--补工时，规则1，当天有2个打卡超过一个小时以上的
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public Result exportOMPWorkTimeException1(HttpServletResponse response) throws Exception{
		//得到所有要导出的数据
		List<WorkTimeDayOmpModel>  workTimeDayOmpModelList = new ArrayList<WorkTimeDayOmpModel>();

		try {
			workTimeDayOmpModelList = workTimeDayOmpDao.queryAllOmpException1();

			//定义导出的excel名字
			String excelName = "OMP补工时（当天2次打卡）数据";
			//获取需要转出的excel表头的map字段
			LinkedHashMap<String, String> fileMap = new LinkedHashMap<>();
			fileMap.put("area","区域");
			fileMap.put("pdu","所在PDU");
			fileMap.put("po","PO");
			fileMap.put("employeename","员工姓名");
			fileMap.put("monthStr","月份");
			fileMap.put("workcatagray","班次类型");
			fileMap.put("workday","考勤日期yyyy-MM-dd");
			fileMap.put("personstatus","人员状态");
			fileMap.put("workcatagray","班次类型");
			fileMap.put("bak","当日打卡记录");
			fileMap.put("terminalIds","当日打卡卡机编号");
			fileMap.put("signMsg","当日打卡卡机信息");

			//导出用户相关信息
			ExportExcelUtils.export(excelName, workTimeDayOmpModelList, fileMap, response);
			return new Result(true, "导出成功");
		} catch (Exception e) {
			logger.error(e.toString());
			return new Result(false, "导出失败");
		}
	}

	/**
	 * OMP日考勤异常数据导出--补工时，前20天工时不够8个小时
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public Result exportOMPWorkTimeException2(HttpServletResponse response) throws Exception{
		//得到所有要导出的数据
		List<WorkTimeDayOmpModel>  workTimeDayOmpModelList = new ArrayList<WorkTimeDayOmpModel>();

		try {
			workTimeDayOmpModelList = workTimeDayOmpDao.queryAllOmpException2();


			//定义导出的excel名字
			String excelName = "OMP补工时（20天不够8小时）数据";
			//获取需要转出的excel表头的map字段
			LinkedHashMap<String, String> fileMap = new LinkedHashMap<>();
			fileMap.put("area","区域");
			fileMap.put("pdu","所在PDU");
			fileMap.put("po","PO");
			fileMap.put("employeename","员工姓名");
			fileMap.put("monthStr","月份");
			fileMap.put("workcatagray","班次类型");
			fileMap.put("workday","考勤日期yyyy-MM-dd");
			fileMap.put("personstatus","人员状态");
			fileMap.put("workcatagray","班次类型");
			fileMap.put("bak","当日打卡记录");
			fileMap.put("terminalIds","当日打卡卡机编号");
			fileMap.put("signMsg","当日打卡卡机信息");

			//导出用户相关信息
			ExportExcelUtils.export(excelName, workTimeDayOmpModelList, fileMap, response);
			return new Result(true, "导出成功");
		} catch (Exception e) {
			logger.error(e.toString());
			return new Result(false, "导出失败");
		}
	}



	/**
	 * OMP日考勤加班工时数
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public Result exportOMPOvertimes(HttpServletResponse response) throws Exception{
		//得到所有要导出的数据
		List<WorkTimeMonthOmpOverTimes>  ompOverTimes = new ArrayList<WorkTimeMonthOmpOverTimes>();

		try {
			ompOverTimes = workTimeMonthOmpDao.exportOMPOvertimes();

			//定义导出的excel名字
			String excelName = "OMP月考勤加班工时数据";
			//获取需要转出的excel表头的map字段
			LinkedHashMap<String, String> fileMap = new LinkedHashMap<>();
			fileMap.put("area","区域");
			fileMap.put("department","所在交付部");
			fileMap.put("pdu","所在PDU");
			fileMap.put("po","PO");
			fileMap.put("partnerPm","合作PM");
			fileMap.put("employeename","员工姓名");
			fileMap.put("cardid","身份证号");
			fileMap.put("month","月份");
			fileMap.put("extendTimes","工作日延长工时");
			fileMap.put("extendTimesAvg","工作日平均延长工时（人天）");

			fileMap.put("overTimes","周末加班工时");
			fileMap.put("difTimes","工作日延长工时与周末加班工时差额");
			fileMap.put("poNum","PO人力数量");
			fileMap.put("poOverTimes","P0工作日加班总时长");
			fileMap.put("poOverTimesAvg","P0工作日人均加班时长");
			fileMap.put("pduNum","PDU人力数量");
			fileMap.put("pduOverTimes","PDU工作日加班总时长");
			fileMap.put("pduOverTimesAvg","PDU工作日人均加班时长");
			fileMap.put("departmentNum","交付部人力数量");
			fileMap.put("departmentOverTimes","交付部工作日加班总时长");
			fileMap.put("departmentOverTimesAvg","交付部工作日人均加班时长");

			//导出用户相关信息
			ExportExcelUtils.export(excelName, ompOverTimes, fileMap, response);
			return new Result(true, "导出成功");
		} catch (Exception e) {
			logger.error(e.toString());
			return new Result(false, "导出失败");
		}
	}

	/**
	 * OMP日考勤加班工时数
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public Result exportOMPSumtimes(HttpServletResponse response) throws Exception{
		//得到所有要导出的数据
		List<WorkTimeMonthOmpOverTimes>  ompOverTimes = new ArrayList<WorkTimeMonthOmpOverTimes>();

		try {
			ompOverTimes = workTimeMonthOmpDao.exportOMPSumtimes();
			//定义导出的excel名字
			String excelName = "OMP月考勤数据汇总";
			//获取需要转出的excel表头的map字段
			LinkedHashMap<String, String> fileMap = new LinkedHashMap<>();
			fileMap.put("area","区域");
			fileMap.put("department","所在交付部");
			fileMap.put("pdu","所在PDU");
			fileMap.put("partnerPm","合作PM");
			fileMap.put("pm","软通PM");
			fileMap.put("employeename","员工姓名");
			fileMap.put("cardid","身份证号");
			fileMap.put("month","月份");
			fileMap.put("shouldtimes","OMP-应出勤工时");
			fileMap.put("holidaytimes","OMP-请假工时");
			fileMap.put("businesstimes","OMP-外出公干总工时");
			fileMap.put("latetimes","OMP-迟到工时");
			fileMap.put("leaveearlytimes","OMP-早退工时");
			fileMap.put("absenteeismtimes","OMP-旷工工时");
			fileMap.put("owetimes","OMP-欠工时");
			fileMap.put("supplysigninnum","OMP-补签到次数");
			fileMap.put("servertimes","OMP-最低服务工时");
			fileMap.put("realtimes","OMP-实际打卡工时");
			fileMap.put("paytimes","OMP-付费总工时");
			fileMap.put("extendTimes","工作日延长工时");
			fileMap.put("extendTimesAvg","工作日平均延长工时（人天）");
			fileMap.put("overTimes","周末加班工时");
			fileMap.put("difTimes","工作日延长工时与周末加班工时差额");
			//导出用户相关信息
			ExportExcelUtils.export(excelName, ompOverTimes, fileMap, response);
			return new Result(true, "导出成功");
		} catch (Exception e) {
			logger.error(e.toString());
			return new Result(false, "导出失败");
		}
	}

 	 public <E> List<Object> toObject(List<E> list){
		List<Object> objlist = new ArrayList<Object>();
		for(Object e : list){
			Object obj = (Object)e;
			objlist.add(obj);
		}
		return objlist;
	}


	/**
	 * OMP日考勤加班工时数
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public Result exportOMPSumPduAndDeptment(HttpServletResponse response) throws Exception{
		//得到所有要导出的数据
		List<WorkTimeMonthOmpSum>  ompOverTimes = new ArrayList<WorkTimeMonthOmpSum>();
		List<WorkTimeMonthOmpSum>  pduTimes = workTimeMonthOmpDao.exportOMPSumPdu();
		List<WorkTimeMonthOmpSum>  departmentTimes = workTimeMonthOmpDao.exportOMPSumDepartment();
		List<SystemConfigInformation> listSys = systemConfigDao.queryConfigByType("pdu");

		for(WorkTimeMonthOmpSum model:departmentTimes){
			model.setDepartment(model.getName());
			ompOverTimes.add(model);
			for(SystemConfigInformation information: listSys){
				if(information.getConfigValue().equals(model.getName())){

					for(WorkTimeMonthOmpSum ompSum : pduTimes){
						if(ompSum.getName().equals(information.getConfigName())){
							ompSum.setPdu(ompSum.getName());
							ompOverTimes.add(ompSum);
						}
					}
				}
			}
		}
		try {
			//定义导出的excel名字
			String excelName = "部门OMP月考勤数据汇总";
			//获取需要转出的excel表头的map字段
			LinkedHashMap<String, String> fileMap = new LinkedHashMap<>();
			fileMap.put("department","交付部");
			fileMap.put("pdu","PDU");
			fileMap.put("num","人数");
			fileMap.put("extraTimes","工作日延长工时");
			fileMap.put("extraTimesAvg","工作日平均延长工时");
			fileMap.put("extraTimesAvgPerDay","工作日平均延长工时（人天）");
			fileMap.put("overTimes","周末加班工时");
			//导出用户相关信息
			ExportExcelUtils.export(excelName, ompOverTimes, fileMap, response);
			return new Result(true, "导出成功");
		} catch (Exception e) {
			logger.error(e.toString());
			return new Result(false, "导出失败");
		}
	}


	/**
	 *
	 * @param list 要拆分的list
	 * @param size 每次拆分的大小
	 * @return
	 */
	public  List<List<Object>> split(List<Object> list, int size){
		if(list==null || list.size()==0){
			return null;
		}
		// 获得数据总量
		int count = list.size();
		// 计算出要分成几个批次
		int pageCount = (count / size) + (count % size == 0 ? 0 : 1);
		List<List<Object>> temp = new ArrayList<>(pageCount);
		for (int i = 0, from = 0,to = 0; i < pageCount; i++) {
			from = i*size;
			to = from+size;
			// 如果超过总数量，则取到最后一个数的位置
			to = to>count?count:to;
			// 对list 进行拆分
			List<Object> list1 = list.subList(from, to);
			// 将拆分后的list放入大List返回
			temp.add(list1);
			// 也可以改造本方法，直接在此处做操作
		}
		return temp;
	}


	/**
	 * OMP日考勤加班工时数
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public Result exportAllOMPException(HttpServletResponse response) throws Exception{
		//得到所有要导出的数据
		List<ExportFileModel> fileModels = new ArrayList<ExportFileModel>();
		fileModels.add(getSumOpm());
		fileModels.add(getPmException());
		fileModels.add(getOpmExceptionLate());
		fileModels.add(getOpmExceptionLeaveEarly());
		fileModels.add(getOpmExceptionAbsenteeism());
		fileModels.add(getOpmExceptionOwe());
		try {

			//导出用户相关信息
			ExportExcelUtils.exportManySheet("TM考勤异常明细", fileModels,  response);
			return new Result(true, "导出成功");
		} catch (Exception e) {
			logger.error(e.toString());
			return new Result(false, "导出失败");
		}
	}


	public ExportFileModel getSumOpm(){
		ExportFileModel model = new ExportFileModel();
		//得到所有要导出的数据
		List<WorkTimeMonthOmpOverTimes> ompOverTimes = workTimeMonthOmpDao.exportOMPSumtimes();
		//定义导出的excel名字
		model.setExcelName( "OMP月考勤数据汇总");
		//获取需要转出的excel表头的map字段
		LinkedHashMap<String, String> fileMap = new LinkedHashMap<>();
		fileMap.put("area","区域");
		fileMap.put("department","所在交付部");
		fileMap.put("pdu","所在PDU");
		fileMap.put("pm","软通PM");
		fileMap.put("employeename","员工姓名");
		fileMap.put("cardid","身份证号");
		fileMap.put("month","月份");
		fileMap.put("shouldtimes","OMP-应出勤工时");
		fileMap.put("holidaytimes","OMP-请假工时");
		fileMap.put("businesstimes","OMP-外出公干总工时");
		fileMap.put("latetimes","OMP-迟到工时");
		fileMap.put("leaveearlytimes","OMP-早退工时");
		fileMap.put("absenteeismtimes","OMP-旷工工时");
		fileMap.put("owetimes","OMP-欠工时");
		fileMap.put("supplysigninnum","OMP-补签到次数");
		fileMap.put("servertimes","OMP-最低服务工时");
		fileMap.put("realtimes","OMP-实际打卡工时");
		fileMap.put("paytimes","OMP-付费总工时");
		fileMap.put("extendTimes","工作日延长工时");
		fileMap.put("extendTimesAvg","工作日平均延长工时（人天）");
		fileMap.put("overTimes","周末加班工时");
		fileMap.put("difTimes","工作日延长工时与周末加班工时差额");
		model.setList(toObject(ompOverTimes));
		model.setFieldMap(fileMap);
		return model;
	}

	public ExportFileModel getPmException(){
		ExportFileModel model = new ExportFileModel();
		//得到所有要导出的数据
		//定义导出的excel名字
		model.setExcelName( "PM异常汇总");
		//获取需要转出的excel表头的map字段
		List<WorkTimeMonthOmpSumByPm>  ompTimes = workTimeMonthOmpDao.exportOMPSumByPm() ;
			//获取需要转出的excel表头的map字段
		LinkedHashMap<String, String> fileMap = new LinkedHashMap<>();

		fileMap.put("area","区域");
		fileMap.put("pm","PM");
		fileMap.put("countnum","项目的人数");

		fileMap.put("absenteeismTimesCount","旷工人数");
		fileMap.put("absenteeismtimes","旷工工时（单位小时）");
		fileMap.put("holidayTimesCount","请假人数");
		fileMap.put("holidaytimes","请假工时（单位小时）");
		fileMap.put("lateTimesCount","迟到人数");
		fileMap.put("latetimes","迟到工时（单位小时）");
		fileMap.put("leaveEarlyTimesCount","早退人数");
		fileMap.put("LeaveEarlytimes","早退工时（单位小时）");
		fileMap.put("oweTimesCount","欠工时人数");
		fileMap.put("owetimes","欠工时总工时（单位小时）");

		model.setList(toObject(ompTimes));
		model.setFieldMap(fileMap);
		return model;
	}

	public ExportFileModel getOpmExceptionLate(){
		ExportFileModel model = new ExportFileModel();
		//得到所有要导出的数据
		List<WorkTimeMonthOmpOverTimes> ompTimes = workTimeMonthOmpDao.exportOMPException(CommonConstant.TIME_STATUS_LATE);
		//定义导出的excel名字
		model.setExcelName( "迟到");
		//获取需要转出的excel表头的map字段
		LinkedHashMap<String, String> fileMap = new LinkedHashMap<>();
		fileMap.put("area","区域");
		fileMap.put("department","所在交付部");
		fileMap.put("pdu","所在PDU");
		fileMap.put("pm","软通PM");
		fileMap.put("employeename","员工姓名");
		fileMap.put("cardid","身份证号");
		fileMap.put("month","月份");
		fileMap.put("latetimes","OMP-迟到工时");
		fileMap.put("leaveearlytimes","OMP-早退工时");
		fileMap.put("absenteeismtimes","OMP-旷工工时");
		fileMap.put("owetimes","OMP-欠工时");
		model.setList(toObject(ompTimes));
		model.setFieldMap(fileMap);
		return model;
	}


	public ExportFileModel getOpmExceptionLeaveEarly(){
		ExportFileModel model = new ExportFileModel();
		//得到所有要导出的数据
		List<WorkTimeMonthOmpOverTimes> ompTimes = workTimeMonthOmpDao.exportOMPException(CommonConstant.TIME_STATUS_LEAVEEARLY);
		//定义导出的excel名字
		model.setExcelName( "早退");
		//获取需要转出的excel表头的map字段
		LinkedHashMap<String, String> fileMap = new LinkedHashMap<>();
		fileMap.put("area","区域");
		fileMap.put("department","所在交付部");
		fileMap.put("pdu","所在PDU");
		fileMap.put("pm","软通PM");
		fileMap.put("employeename","员工姓名");
		fileMap.put("cardid","身份证号");
		fileMap.put("month","月份");
		fileMap.put("latetimes","OMP-迟到工时");
		fileMap.put("leaveearlytimes","OMP-早退工时");
		fileMap.put("absenteeismtimes","OMP-旷工工时");
		fileMap.put("owetimes","OMP-欠工时");
		model.setList(toObject(ompTimes));
		model.setFieldMap(fileMap);
		return model;
	}

	public ExportFileModel getOpmExceptionAbsenteeism(){
		ExportFileModel model = new ExportFileModel();
		//得到所有要导出的数据
		List<WorkTimeMonthOmpOverTimes> ompTimes = workTimeMonthOmpDao.exportOMPException(CommonConstant.TIME_STATUS_ABSENTEEISM);
		//定义导出的excel名字
		model.setExcelName( "旷工");
		//获取需要转出的excel表头的map字段
		LinkedHashMap<String, String> fileMap = new LinkedHashMap<>();
		fileMap.put("area","区域");
		fileMap.put("department","所在交付部");
		fileMap.put("pdu","所在PDU");
		fileMap.put("pm","软通PM");
		fileMap.put("employeename","员工姓名");
		fileMap.put("cardid","身份证号");
		fileMap.put("month","月份");
		fileMap.put("latetimes","OMP-迟到工时");
		fileMap.put("leaveearlytimes","OMP-早退工时");
		fileMap.put("absenteeismtimes","OMP-旷工工时");
		fileMap.put("owetimes","OMP-欠工时");
		model.setList(toObject(ompTimes));
		model.setFieldMap(fileMap);
		return model;
	}

	public ExportFileModel getOpmExceptionOwe(){
		ExportFileModel model = new ExportFileModel();
		//得到所有要导出的数据
		List<WorkTimeMonthOmpOverTimes> ompTimes = workTimeMonthOmpDao.exportOMPException(CommonConstant.TIME_STATUS_OWE);
		//定义导出的excel名字
		model.setExcelName( "欠工时");
		//获取需要转出的excel表头的map字段
		LinkedHashMap<String, String> fileMap = new LinkedHashMap<>();
		fileMap.put("area","区域");
		fileMap.put("department","所在交付部");
		fileMap.put("pdu","所在PDU");
		fileMap.put("pm","软通PM");
		fileMap.put("employeename","员工姓名");
		fileMap.put("cardid","身份证号");
		fileMap.put("month","月份");
		fileMap.put("latetimes","OMP-迟到工时");
		fileMap.put("leaveearlytimes","OMP-早退工时");
		fileMap.put("absenteeismtimes","OMP-旷工工时");
		fileMap.put("owetimes","OMP-欠工时");
		model.setList(toObject(ompTimes));
		model.setFieldMap(fileMap);
		return model;
	}
}
