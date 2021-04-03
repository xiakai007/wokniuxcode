package com.isoftstone.humanresources.domain.workTime;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>Description: [员工IPSA日考勤记录model]</p>
 * Created on 2020年10月13日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */

public class WorkTimeDayIpsaModel  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 工号
     */
	private Integer employeeid;
	/**
     * 员工姓名
     */
	private String employeename;

	private String cardid;
	/**
     * 工作地
     */
	private String workarea;
	/**
     * 考勤状态
     */
	private String workstatus;
	/**
     * 人员状态
     */
	private String personalstatus;
	/**
     * 班次
     */
	private String daycount;
	/**
     * 考勤日期 yyyy-MM-dd
     */
	private String workday;
	/**
     * 日期类型
     */
	private String daycatagray;
	/**
     * 初次打卡
     */
	private String firstrecordtime;
	/**
     * 末次打卡
     */
	private String lastrecordtime;
	/**
     * 出勤工时
     */
	private java.math.BigDecimal actualtimes;
	/**
     * 请假工时
     */
	private java.math.BigDecimal holidaytimes;
	/**
     * 因公外出工时
     */
	private java.math.BigDecimal outworktimes;
	/**
     * 旷工工时
     */
	private java.math.BigDecimal absenteeismtimes;
	/**
     * 异常工时
     */
	private java.math.BigDecimal workbadtimes;
	/**
     * 早退处罚工时
     */
	private java.math.BigDecimal penalizetimes;
	/**
     * 迟到工时
     */
	private java.math.BigDecimal latetimes;
	/**
     * 加班工时
     */
	private java.math.BigDecimal overtimes;
	/**
     * 延长工时
     */
	private java.math.BigDecimal extendtimes;
	/**
     * PSA年假工时
     */
	private java.math.BigDecimal annualleave;
	/**
     * PSA倒休时数
     */
	private java.math.BigDecimal resttimes;
	/**
     * PSA婚假工时
     */
	private java.math.BigDecimal marriageleave;
	/**
     * PSA产假工时
     */
	private java.math.BigDecimal maternityleave;
	/**
     * PSA陪产假工时
     */
	private java.math.BigDecimal paternityleave;
	/**
     * PSA哺乳假工时
     */
	private java.math.BigDecimal breastfeeding;
	/**
     * PSA病假工时
     */
	private java.math.BigDecimal sickleave;
	/**
     * PSA丧事假
     */
	private java.math.BigDecimal funeralleave;
	/**
     * PSA事假工时
     */
	private java.math.BigDecimal personalleave;
	/**
     * PSA加班倒休时数
     */
	private java.math.BigDecimal overtimeresttimes;
	/**
     * PSA因公外出时数
     */
	private java.math.BigDecimal outsidetimes;
	/**
     * 合作类型
     */
	private String copcatagray;
	/**
     * 合作模式
     */
	private String copmodel;
	/**
     * 月度在岸/离岸
     */
	private String monthinshore;
	/**
     * 离岸自带主机
     */
	private String daybringpcoutshore;
	/**
     * 所在CU
     */
	private String cu;

	private String firstrecordPlace;

	private String lastRecordPlace;

	private java.math.BigDecimal businessTimes;

	public BigDecimal getBusinessTimes() {
		return businessTimes;
	}

	public void setBusinessTimes(BigDecimal businessTimes) {
		this.businessTimes = businessTimes;
	}

	public String getFirstrecordPlace() {
		return firstrecordPlace;
	}

	public void setFirstrecordPlace(String firstrecordPlace) {
		this.firstrecordPlace = firstrecordPlace;
	}

	public String getLastRecordPlace() {
		return lastRecordPlace;
	}

	public void setLastRecordPlace(String lastRecordPlace) {
		this.lastRecordPlace = lastRecordPlace;
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	// setter and getter
	/**
	* <p>Discription:[工号]</p>
	* Created on 2020年10月13日
	* @return Integer
    * @author:wangchun
    */
	public Integer getEmployeeid(){
		return employeeid;
	}
	/**
	* <p>Discription:[工号]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setEmployeeid(Integer employeeid){
		this.employeeid = employeeid;
	}
	/**
	* <p>Discription:[员工姓名]</p>
	* Created on 2020年10月13日
	* @return String
    * @author:wangchun
    */
	public String getEmployeename(){
		return employeename;
	}
	/**
	* <p>Discription:[员工姓名]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setEmployeename(String employeename){
		this.employeename = employeename;
	}
	/**
	* <p>Discription:[工作地]</p>
	* Created on 2020年10月13日
	* @return String
    * @author:wangchun
    */
	public String getWorkarea(){
		return workarea;
	}
	/**
	* <p>Discription:[工作地]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setWorkarea(String workarea){
		this.workarea = workarea;
	}
	/**
	* <p>Discription:[考勤状态]</p>
	* Created on 2020年10月13日
	* @return String
    * @author:wangchun
    */
	public String getWorkstatus(){
		return workstatus;
	}
	/**
	* <p>Discription:[考勤状态]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setWorkstatus(String workstatus){
		this.workstatus = workstatus;
	}
	/**
	* <p>Discription:[人员状态]</p>
	* Created on 2020年10月13日
	* @return String
    * @author:wangchun
    */
	public String getPersonalstatus(){
		return personalstatus;
	}
	/**
	* <p>Discription:[人员状态]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setPersonalstatus(String personalstatus){
		this.personalstatus = personalstatus;
	}
	/**
	* <p>Discription:[班次]</p>
	* Created on 2020年10月13日
	* @return String
    * @author:wangchun
    */
	public String getDaycount(){
		return daycount;
	}
	/**
	* <p>Discription:[班次]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setDaycount(String daycount){
		this.daycount = daycount;
	}
	/**
	* <p>Discription:[考勤日期 yyyy-MM-dd]</p>
	* Created on 2020年10月13日
	* @return String
    * @author:wangchun
    */
	public String getWorkday(){
		return workday;
	}
	/**
	* <p>Discription:[考勤日期 yyyy-MM-dd]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setWorkday(String workday){
		this.workday = workday;
	}
	/**
	* <p>Discription:[日期类型]</p>
	* Created on 2020年10月13日
	* @return String
    * @author:wangchun
    */
	public String getDaycatagray(){
		return daycatagray;
	}
	/**
	* <p>Discription:[日期类型]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setDaycatagray(String daycatagray){
		this.daycatagray = daycatagray;
	}
	/**
	* <p>Discription:[初次打卡]</p>
	* Created on 2020年10月13日
	* @return String
    * @author:wangchun
    */
	public String getFirstrecordtime(){
		return firstrecordtime;
	}
	/**
	* <p>Discription:[初次打卡]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setFirstrecordtime(String firstrecordtime){
		this.firstrecordtime = firstrecordtime;
	}
	/**
	* <p>Discription:[末次打卡]</p>
	* Created on 2020年10月13日
	* @return String
    * @author:wangchun
    */
	public String getLastrecordtime(){
		return lastrecordtime;
	}
	/**
	* <p>Discription:[末次打卡]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setLastrecordtime(String lastrecordtime){
		this.lastrecordtime = lastrecordtime;
	}
	/**
	* <p>Discription:[出勤工时]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getActualtimes(){
		return actualtimes;
	}
	/**
	* <p>Discription:[出勤工时]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setActualtimes(java.math.BigDecimal actualtimes){
		this.actualtimes = actualtimes;
	}
	/**
	* <p>Discription:[请假工时]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getHolidaytimes(){
		return holidaytimes;
	}
	/**
	* <p>Discription:[请假工时]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setHolidaytimes(java.math.BigDecimal holidaytimes){
		this.holidaytimes = holidaytimes;
	}
	/**
	* <p>Discription:[因公外出工时]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getOutworktimes(){
		return outworktimes;
	}
	/**
	* <p>Discription:[因公外出工时]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setOutworktimes(java.math.BigDecimal outworktimes){
		this.outworktimes = outworktimes;
	}
	/**
	* <p>Discription:[旷工工时]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getAbsenteeismtimes(){
		return absenteeismtimes;
	}
	/**
	* <p>Discription:[旷工工时]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setAbsenteeismtimes(java.math.BigDecimal absenteeismtimes){
		this.absenteeismtimes = absenteeismtimes;
	}
	/**
	* <p>Discription:[异常工时]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getWorkbadtimes(){
		return workbadtimes;
	}
	/**
	* <p>Discription:[异常工时]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setWorkbadtimes(java.math.BigDecimal workbadtimes){
		this.workbadtimes = workbadtimes;
	}
	/**
	* <p>Discription:[早退处罚工时]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getPenalizetimes(){
		return penalizetimes;
	}
	/**
	* <p>Discription:[早退处罚工时]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setPenalizetimes(java.math.BigDecimal penalizetimes){
		this.penalizetimes = penalizetimes;
	}
	/**
	* <p>Discription:[迟到工时]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getLatetimes(){
		return latetimes;
	}
	/**
	* <p>Discription:[迟到工时]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setLatetimes(java.math.BigDecimal latetimes){
		this.latetimes = latetimes;
	}
	/**
	* <p>Discription:[加班工时]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getOvertimes(){
		return overtimes;
	}
	/**
	* <p>Discription:[加班工时]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setOvertimes(java.math.BigDecimal overtimes){
		this.overtimes = overtimes;
	}
	/**
	* <p>Discription:[延长工时]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getExtendtimes(){
		return extendtimes;
	}
	/**
	* <p>Discription:[延长工时]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setExtendtimes(java.math.BigDecimal extendtimes){
		this.extendtimes = extendtimes;
	}
	/**
	* <p>Discription:[PSA年假工时]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getAnnualleave(){
		return annualleave;
	}
	/**
	* <p>Discription:[PSA年假工时]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setAnnualleave(java.math.BigDecimal annualleave){
		this.annualleave = annualleave;
	}
	/**
	* <p>Discription:[PSA倒休时数]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getResttimes(){
		return resttimes;
	}
	/**
	* <p>Discription:[PSA倒休时数]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setResttimes(java.math.BigDecimal resttimes){
		this.resttimes = resttimes;
	}
	/**
	* <p>Discription:[PSA婚假工时]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getMarriageleave(){
		return marriageleave;
	}
	/**
	* <p>Discription:[PSA婚假工时]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setMarriageleave(java.math.BigDecimal marriageleave){
		this.marriageleave = marriageleave;
	}
	/**
	* <p>Discription:[PSA产假工时]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getMaternityleave(){
		return maternityleave;
	}
	/**
	* <p>Discription:[PSA产假工时]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setMaternityleave(java.math.BigDecimal maternityleave){
		this.maternityleave = maternityleave;
	}
	/**
	* <p>Discription:[PSA陪产假工时]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getPaternityleave(){
		return paternityleave;
	}
	/**
	* <p>Discription:[PSA陪产假工时]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setPaternityleave(java.math.BigDecimal paternityleave){
		this.paternityleave = paternityleave;
	}
	/**
	* <p>Discription:[PSA哺乳假工时]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getBreastfeeding(){
		return breastfeeding;
	}
	/**
	* <p>Discription:[PSA哺乳假工时]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setBreastfeeding(java.math.BigDecimal breastfeeding){
		this.breastfeeding = breastfeeding;
	}
	/**
	* <p>Discription:[PSA病假工时]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getSickleave(){
		return sickleave;
	}
	/**
	* <p>Discription:[PSA病假工时]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setSickleave(java.math.BigDecimal sickleave){
		this.sickleave = sickleave;
	}
	/**
	* <p>Discription:[PSA丧事假]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getFuneralleave(){
		return funeralleave;
	}
	/**
	* <p>Discription:[PSA丧事假]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setFuneralleave(java.math.BigDecimal funeralleave){
		this.funeralleave = funeralleave;
	}
	/**
	* <p>Discription:[PSA事假工时]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getPersonalleave(){
		return personalleave;
	}
	/**
	* <p>Discription:[PSA事假工时]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setPersonalleave(java.math.BigDecimal personalleave){
		this.personalleave = personalleave;
	}
	/**
	* <p>Discription:[PSA加班倒休时数]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getOvertimeresttimes(){
		return overtimeresttimes;
	}
	/**
	* <p>Discription:[PSA加班倒休时数]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setOvertimeresttimes(java.math.BigDecimal overtimeresttimes){
		this.overtimeresttimes = overtimeresttimes;
	}
	/**
	* <p>Discription:[PSA因公外出时数]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getOutsidetimes(){
		return outsidetimes;
	}
	/**
	* <p>Discription:[PSA因公外出时数]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setOutsidetimes(java.math.BigDecimal outsidetimes){
		this.outsidetimes = outsidetimes;
	}
	/**
	* <p>Discription:[合作类型]</p>
	* Created on 2020年10月13日
	* @return String
    * @author:wangchun
    */
	public String getCopcatagray(){
		return copcatagray;
	}
	/**
	* <p>Discription:[合作类型]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setCopcatagray(String copcatagray){
		this.copcatagray = copcatagray;
	}
	/**
	* <p>Discription:[合作模式]</p>
	* Created on 2020年10月13日
	* @return String
    * @author:wangchun
    */
	public String getCopmodel(){
		return copmodel;
	}
	/**
	* <p>Discription:[合作模式]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setCopmodel(String copmodel){
		this.copmodel = copmodel;
	}
	/**
	* <p>Discription:[月度在岸/离岸]</p>
	* Created on 2020年10月13日
	* @return String
    * @author:wangchun
    */
	public String getMonthinshore(){
		return monthinshore;
	}
	/**
	* <p>Discription:[月度在岸/离岸]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setMonthinshore(String monthinshore){
		this.monthinshore = monthinshore;
	}
	/**
	* <p>Discription:[离岸自带主机]</p>
	* Created on 2020年10月13日
	* @return String
    * @author:wangchun
    */
	public String getDaybringpcoutshore(){
		return daybringpcoutshore;
	}
	/**
	* <p>Discription:[离岸自带主机]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setDaybringpcoutshore(String daybringpcoutshore){
		this.daybringpcoutshore = daybringpcoutshore;
	}
	/**
	* <p>Discription:[所在CU]</p>
	* Created on 2020年10月13日
	* @return String
    * @author:wangchun
    */
	public String getCu(){
		return cu;
	}
	/**
	* <p>Discription:[所在CU]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setCu(String cu){
		this.cu = cu;
	}
}
