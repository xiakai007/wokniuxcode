package com.isoftstone.humanresources.util;

import java.text.SimpleDateFormat;

/**
 * 配置常量值
 * 
 * @author WLREN
 *
 */
public class CommonConstant
{
	/**
	 * 日期格式 年-月-日
	 */
	public static final String DATAFORMATTER = "yyyy-MM-dd";
	
	public static final String DATAFORMATTERMONTH = "yyyy-MM";
	
	public static final String DATAFOMATTERTIMES = "HH:mm:ss";
	
	public static final String DATAFOMATTERDAY = "yyyy/MM/dd";

	/**
	 * 日期格式 年-月-日 时:分:秒
	 */
	public static final String DATAFORMATTER_FULL = "yyyy-MM-dd HH:mm:ss";
	
	public static final String DATAFORMATTER_ALL ="yyMMddhhmmss";

	public static final String EXTENSION_XLS = "xls";

	public static final String EXTENSION_XLSX = "xlsx";

	public static final String NO_ACTIVE_MESSAGE = "账号未激活，请联系管理员进行激活！";

	public static final String LOGIN_FAIL_MESSAGE = "用户名或密码错误，请核实！";

	public static final String LOGIN_NO_AUTHORITY = "账户未分配权限或出现异常，请联系管理员处理，如有不便，敬请谅解！";

	public static final String REGISTER_FAIL_MESSAGE = "注册失败！请重试！";

	public static final String IMPORT_NO_FILE_MESSAGE = "导入失败！ 未选择文件！";

	public static final String IMPORT_IPSA_LOSS_NO_FILE_MESSAGE = "请在IPSA系统中导出员工基础信息（离职）部分和</br>员工离职信息后，再导入到本系统使用!";

	public static final String IMPORT_FILE_TOO_LONG_MESSAGE = "导入失败！ 文件太大！";

	public static final String IMPORT_FILE_TYPE_ERROR_MESSAGE = "导入失败！ 文件类型错误！";

	public static final String IMPORT_FILE_CONTEXT_ERROR_MESSAGE = "导入失败！ 文件内容有误！";

	public static final String IMPORT_FILE_CONTEXT_ERROR_TITLT_ERROR = "导入失败！标题行与模板不匹配！";

	public static final String LOGGER_RECORD_ERROR_MESSAGE = "日志记录中存在非法字符，无法显示!";

	//

	public static final String USER_DIR = "user.dir";
	public static final String LOGIN_SUCCESS = "登录成功!";

	public static final String IS_YES = "是";

	public static final String IS_NO = "否";

	// month

	public static final String MONTH = "月";

	public static final String ZORE = "0";

	/**
	 * 日期格式 年-月
	 */
	public static final SimpleDateFormat DATE_MONTH_FORMAT = new SimpleDateFormat("yyyy-MM");

	public static final String COOPERATION_TYPE_ALL = "全部";

	public static final String COOPERATION_TYPE_TM = "TM";

	public static final String COOPERATION_TYPE_FP = "FP";
	// 统计图颜色集
	public static final String[] COLORS =
	{ "RGB(255,127,80)", "RGB(135,206,250)", "RGB(218,112,214)", "RGB(50,205,50)", "RGB(100,149,237)",
	        "RGB(255,105,180)", "RGB(186,85,211)", "RGB(205,92,92)", "RGB(255,165,0)", "RGB(64,224,208)" };

	// 超級用戶組名
	public static final String IS_SUPPER_USER = "超级用户组";

	// 工时异常原因标题
	public static final String WORKTIME_REASON_TITLE = "员工编号,姓名,考勤月份,异常原因";
	
	public static final String IMPORT_ERROR = "导入失败！模板不匹配！";

	public static final String ORGANZATION_TYPE_ERROR = "导入失败！模板不匹配！";

	//组织类型是BG部门
	public static final String ORGANZATION_TYPE_BG = "BG";

	//组织类型是BD部门
	public static final String ORGANZATION_TYPE_BD = "BD";

	//组织类型是BU部门
	public static final String ORGANZATION_TYPE_BU = "BU";

	//组织类型是CU部门
	public static final String ORGANZATION_TYPE_CU = "CU";

	//组织类型是PDU部门
	public static final String ORGANZATION_TYPE_PDU = "PDU";

	//组织类型是PO部门
	public static final String ORGANZATION_TYPE_PO = "PO";

	//组织类型是部门
	public static final String ORGANZATION_TYPE_DEPARENTMENT = "Department";

	//组织类型是项目组
	public static final String ORGANZATION_TYPE_PROJECTTEAM = "ProjectTeam";
	public static final String LOWER_ORGANZATION_TYPE_PROJECTTEAM = "projectTeam";

	//系统类型是HealthCheck
	public static final String HEALTH_CHECK_TYPE = "HealthCheck";

	//系统类型是HealthCheck
	public static final String HUAWEI_LEVEL_HEALTH_CHECK_TYPE = "HuaweiLevel";

	//健康常量
	public static final String STRING_HEALTH = "Health";

	//不健康常量
	public static final String STRING_UNHEALTH = "UnHealth";

	//工单状态常量
	public static final String STRING_STATUS = "未解决";
	public static final String MESSAGE_STRING_STATUS = "已解决";
	//工单等级常量
	public static final String STRING_ORDER_LEVEL = "一般";
	public static final String STRING_ORDER_CONTENT = "您的员工备份已完成,请确认。备份内容:";

	//系统任务中心路径
	public static final String TASK_ADDRESS = "http://119.3.193.108:8060/#/taskCenter/index";
	//邮件状态
	public static final String MESSAGE_STATUS="1";
	//邮件类型
	public static final String MESSAGE_TYPE="2";
	//空字符串
	public static final String EMPTY_STRING = "";

	public static final String STR_ENTRY = "在职";

	public static final String STR_LEAVE = "离职";
	//百分号
	public static final String STR_PERCENT= "%";
    //请求参数为空
	public static final String REQUEST_IS_NULL = "request param is null !";
    //入参错误
	public static final String REQUEST_VALUE_IS_ERROR =  "Entry error!";
	//日期类型：周
	public static final String DATE_TYPE_WEEK = "Week";
	//日期类型：天
	public static final String DATE_TYPE_DAY = "Day";
    //日期类型：月
	public static final String DATE_TYPE_MONTH= "Month";
	
	public static final String RETURN_STATUS = "status";
	
	public static final String RETURN_MESSAGE = "message";

	public static final String RETURN_ERROR = "error";

	public static final String EMAIL_SUFFIX =  "@isoftstone.com";
	
	public static final String SECURITY = "安全";
	
	public static final String PROCESS_AND_RESULTS = "项目过程和结果";
	
	public static final String PERSON_MANAGE = "人员管理";
	
	public static final String SATIS_FACTION = "满意度";
	
	public static final String QUALITY_SCORE = "质量得分";
	
	public static final String PRO_DELIVERY_QU_SCORE_FP = "过程交付质量得分(fp)";
	
	public static final String TIME_OF_DELIVERY_FP = "交付及时性得分(fp)";
	
	public static final String RATE_STAGE_ACCEPT_FP = "阶段性验收一次通过率(fp)";
	
	public static final String PERSON_ST_SCORE_FP = "人员稳定度(fp)";
	
	public static final String PRO_PERSON_ST_SCORE_FP = "项目人员稳定度(fp)";
	
	public static final String DELIVERY_SCHEDULE_DEV_FP = "交付进度偏差(fp)";
	
	public static final String PRO_DELIVERY_QUALITY_FP = "过程交付质量(fp)";
	
	public static final String PROJECT_DELIVERY_QUALITY_FP = "项目验收质量(fp)";
	
	public static final String QU_POINTS_CRITICAL_EVENTS_FP = "质量关键事件得分(fp)";
	
	public static final String QUALITY_SCORE_FP = "质量得分(fp)";
	
	public static final String QUALITY_SCORE_TM = "质量得分(TM)";
	
	public static final String DELIVERY_SCHEDULE_DEV_TM = "交付进度偏差(TM)";
	
	public static final String PRO_DELIVERY_QUALITY_TM = "过程交付质量(TM)";
	
	public static final String PROJECT_DELIVERY_QUALITY_TM = "项目验收质量(TM)";
	
	public static final String QU_POINTS_CRITICAL_EVENTS_TM = "质量关键事件得分(TM)";
	
	public static final String TASK_COMP_RATE_TIME_TM = "任务及时完成率得分(TM)";
	
	public static final String MISSION_PASS_RATE_TM = "任务一次通过率得分(TM)";
	
	public static final String RIDING_QUALITY_TM = "运行质量得分(TM)";
	
	public static final String TIMELY_ARRIVAL_RATEPER_TM = "人员及时到位率(TM)";
	
	public static final String PERSON_INTERVIEW_RATE_TM = "人员面试通过率(TM)";
	
	public static final String INFORMATION_SECURITY_TM = "信息安全得分(TM)";
	
	public static final String NETWORK_SECURITY_TM = "网络安全得分(TM)";
	
	public static final String VIA_BRAINSTUCK_TM = "满意度得分(TM)";
	
	public static final String PERSON_ST_SCORE_TM = "人员稳定度(TM)";

	public static final String IMG_LUCK = "luckimg";

	public static final String IMG_USER = "employeeimg";


	//知识点 KS、
	public static final String COMPOSE_TYPE_KS = "KS";

	// 新鲜事 NEWS、
	public static final String COMPOSE_TYPE_NEWS = "NEWS";

	//风采展示 GA
	public static final String COMPOSE_TYPE_GA = "GA";

	//考勤中的状态，迟到
	public static final String TIME_STATUS_LATE = "LATE";
	//考勤中的状态，早退
	public static final String TIME_STATUS_LEAVEEARLY = "LEAVEEARLY";
	//考勤中的状态，旷工
	public static final String TIME_STATUS_ABSENTEEISM = "ABSENTEEISM";
	//考勤中的状态，欠工时
	public static final String TIME_STATUS_OWE = "OWE";

}