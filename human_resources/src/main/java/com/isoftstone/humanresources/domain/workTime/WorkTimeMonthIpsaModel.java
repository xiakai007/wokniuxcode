package com.isoftstone.humanresources.domain.workTime;

import java.io.Serializable;
/** 
 * <p>Description: [员工IPSA月考勤记录model]</p>
 * Created on 2020年10月13日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public class WorkTimeMonthIpsaModel  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 工号
     */
	private Integer employeeid;
	/**
     * 员工姓名
     */
	private String employeename;
	/**
     * 身份证号
     */
	private String cardid;
	/**
     * 区域
     */
	private String area;
	/**
     * 考勤月份 yyyy-MM
     */
	private String month;
	/**
     * 应出勤天数
     */
	private Integer shoulddays;
	/**
     * 实际出勤天数
     */
	private java.math.BigDecimal actualdays;
	/**
     * 应出勤工时
     */
	private java.math.BigDecimal shouldtimes;
	/**
     * 工作日出勤工时
     */
	private java.math.BigDecimal actualtimes;
	/**
     * 请假工时
     */
	private java.math.BigDecimal holidaytimes;
	/**
     * 公出工时
     */
	private java.math.BigDecimal businesstimes;
	/**
     * 出差工时
     */
	private java.math.BigDecimal businesstriptimes;
	/**
     * 迟到工时
     */
	private java.math.BigDecimal latetimes;
	/**
     * 早退工时
     */
	private java.math.BigDecimal leaveearlytimes;
	/**
     * 旷工工时
     */
	private java.math.BigDecimal absenteeismtimes;
	/**
     * 欠工时
     */
	private java.math.BigDecimal owetimes;
	/**
     * 加班次数
     */
	private Integer overtimenum;
	/**
     * 加班工时
     */
	private java.math.BigDecimal overtimes;
	/**
     * 工作日延长工时
     */
	private java.math.BigDecimal extendtimes;
	/**
     * 在岸/离岸不带主机付费总工时（人时）
     */
	private java.math.BigDecimal notbringpctimes;
	/**
     * 离岸带主机付费总工时（人时）
     */
	private java.math.BigDecimal bringpctimes;
	/**
     * 入职时间 yyyy-MM-dd
     */
	private String inday;
	/**
     * 离职时间 yyyy-MM-dd
     */
	private String outday;
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
     * PSA产检假工时
     */
	private java.math.BigDecimal prenatalleave;
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
     * ehs风险
     */
	private java.math.BigDecimal ehs;
	/**
     * 工时不足8小时的异常原因
     */
	private String insufficientreasons;
	/**
     * 无考勤的异常原因
     */
	private String noworkreasons;
	/**
     * 月份不足15天的异常原因
     */
	private String monthinsufficientreasons;
	/**
     * CU
     */
	private String cu;
	
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
	* <p>Discription:[身份证号]</p>
	* Created on 2020年10月13日
	* @return String
    * @author:wangchun
    */
	public String getCardid(){
		return cardid;
	}
	/**
	* <p>Discription:[身份证号]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setCardid(String cardid){
		this.cardid = cardid;
	}
	/**
	* <p>Discription:[区域]</p>
	* Created on 2020年10月13日
	* @return String
    * @author:wangchun
    */
	public String getArea(){
		return area;
	}
	/**
	* <p>Discription:[区域]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setArea(String area){
		this.area = area;
	}
	/**
	* <p>Discription:[考勤月份 yyyy-MM]</p>
	* Created on 2020年10月13日
	* @return String
    * @author:wangchun
    */
	public String getMonth(){
		return month;
	}
	/**
	* <p>Discription:[考勤月份 yyyy-MM]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setMonth(String month){
		this.month = month;
	}
	/**
	* <p>Discription:[应出勤天数]</p>
	* Created on 2020年10月13日
	* @return Integer
    * @author:wangchun
    */
	public Integer getShoulddays(){
		return shoulddays;
	}
	/**
	* <p>Discription:[应出勤天数]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setShoulddays(Integer shoulddays){
		this.shoulddays = shoulddays;
	}
	/**
	* <p>Discription:[实际出勤天数]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getActualdays(){
		return actualdays;
	}
	/**
	* <p>Discription:[实际出勤天数]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setActualdays(java.math.BigDecimal actualdays){
		this.actualdays = actualdays;
	}
	/**
	* <p>Discription:[应出勤工时]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getShouldtimes(){
		return shouldtimes;
	}
	/**
	* <p>Discription:[应出勤工时]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setShouldtimes(java.math.BigDecimal shouldtimes){
		this.shouldtimes = shouldtimes;
	}
	/**
	* <p>Discription:[工作日出勤工时]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getActualtimes(){
		return actualtimes;
	}
	/**
	* <p>Discription:[工作日出勤工时]</p>
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
	* <p>Discription:[公出工时]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getBusinesstimes(){
		return businesstimes;
	}
	/**
	* <p>Discription:[公出工时]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setBusinesstimes(java.math.BigDecimal businesstimes){
		this.businesstimes = businesstimes;
	}
	/**
	* <p>Discription:[出差工时]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getBusinesstriptimes(){
		return businesstriptimes;
	}
	/**
	* <p>Discription:[出差工时]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setBusinesstriptimes(java.math.BigDecimal businesstriptimes){
		this.businesstriptimes = businesstriptimes;
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
	* <p>Discription:[早退工时]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getLeaveearlytimes(){
		return leaveearlytimes;
	}
	/**
	* <p>Discription:[早退工时]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setLeaveearlytimes(java.math.BigDecimal leaveearlytimes){
		this.leaveearlytimes = leaveearlytimes;
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
	* <p>Discription:[欠工时]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getOwetimes(){
		return owetimes;
	}
	/**
	* <p>Discription:[欠工时]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setOwetimes(java.math.BigDecimal owetimes){
		this.owetimes = owetimes;
	}
	/**
	* <p>Discription:[加班次数]</p>
	* Created on 2020年10月13日
	* @return Integer
    * @author:wangchun
    */
	public Integer getOvertimenum(){
		return overtimenum;
	}
	/**
	* <p>Discription:[加班次数]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setOvertimenum(Integer overtimenum){
		this.overtimenum = overtimenum;
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
	* <p>Discription:[工作日延长工时]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getExtendtimes(){
		return extendtimes;
	}
	/**
	* <p>Discription:[工作日延长工时]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setExtendtimes(java.math.BigDecimal extendtimes){
		this.extendtimes = extendtimes;
	}
	/**
	* <p>Discription:[在岸/离岸不带主机付费总工时（人时）]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getNotbringpctimes(){
		return notbringpctimes;
	}
	/**
	* <p>Discription:[在岸/离岸不带主机付费总工时（人时）]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setNotbringpctimes(java.math.BigDecimal notbringpctimes){
		this.notbringpctimes = notbringpctimes;
	}
	/**
	* <p>Discription:[离岸带主机付费总工时（人时）]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getBringpctimes(){
		return bringpctimes;
	}
	/**
	* <p>Discription:[离岸带主机付费总工时（人时）]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setBringpctimes(java.math.BigDecimal bringpctimes){
		this.bringpctimes = bringpctimes;
	}
	/**
	* <p>Discription:[入职时间 yyyy-MM-dd]</p>
	* Created on 2020年10月13日
	* @return String
    * @author:wangchun
    */
	public String getInday(){
		return inday;
	}
	/**
	* <p>Discription:[入职时间 yyyy-MM-dd]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setInday(String inday){
		this.inday = inday;
	}
	/**
	* <p>Discription:[离职时间 yyyy-MM-dd]</p>
	* Created on 2020年10月13日
	* @return String
    * @author:wangchun
    */
	public String getOutday(){
		return outday;
	}
	/**
	* <p>Discription:[离职时间 yyyy-MM-dd]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setOutday(String outday){
		this.outday = outday;
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
	* <p>Discription:[PSA产检假工时]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getPrenatalleave(){
		return prenatalleave;
	}
	/**
	* <p>Discription:[PSA产检假工时]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setPrenatalleave(java.math.BigDecimal prenatalleave){
		this.prenatalleave = prenatalleave;
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
	* <p>Discription:[ehs风险]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getEhs(){
		return ehs;
	}
	/**
	* <p>Discription:[ehs风险]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setEhs(java.math.BigDecimal ehs){
		this.ehs = ehs;
	}
	/**
	* <p>Discription:[工时不足8小时的异常原因]</p>
	* Created on 2020年10月13日
	* @return String
    * @author:wangchun
    */
	public String getInsufficientreasons(){
		return insufficientreasons;
	}
	/**
	* <p>Discription:[工时不足8小时的异常原因]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setInsufficientreasons(String insufficientreasons){
		this.insufficientreasons = insufficientreasons;
	}
	/**
	* <p>Discription:[无考勤的异常原因]</p>
	* Created on 2020年10月13日
	* @return String
    * @author:wangchun
    */
	public String getNoworkreasons(){
		return noworkreasons;
	}
	/**
	* <p>Discription:[无考勤的异常原因]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setNoworkreasons(String noworkreasons){
		this.noworkreasons = noworkreasons;
	}
	/**
	* <p>Discription:[月份不足15天的异常原因]</p>
	* Created on 2020年10月13日
	* @return String
    * @author:wangchun
    */
	public String getMonthinsufficientreasons(){
		return monthinsufficientreasons;
	}
	/**
	* <p>Discription:[月份不足15天的异常原因]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setMonthinsufficientreasons(String monthinsufficientreasons){
		this.monthinsufficientreasons = monthinsufficientreasons;
	}
	/**
	* <p>Discription:[CU]</p>
	* Created on 2020年10月13日
	* @return String
    * @author:wangchun
    */
	public String getCu(){
		return cu;
	}
	/**
	* <p>Discription:[CU]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setCu(String cu){
		this.cu = cu;
	}
}
