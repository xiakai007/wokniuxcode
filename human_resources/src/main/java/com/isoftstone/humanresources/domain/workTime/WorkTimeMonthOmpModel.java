package com.isoftstone.humanresources.domain.workTime;

import java.io.Serializable;
/** 
 * <p>Description: [员工OMP月考勤记录model]</p>
 * Created on 2020年10月13日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public class WorkTimeMonthOmpModel  implements Serializable {

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
     * 考勤月份 yyyy-MM
     */
	private String month;
	/**
     * 应出勤工时
     */
	private java.math.BigDecimal shouldtimes;
	/**
     * 请假工时
     */
	private java.math.BigDecimal holidaytimes;
	/**
     * 迟到工时
     */
	private java.math.BigDecimal latetimes;
	/**
     * 早退工时
     */
	private java.math.BigDecimal leaveearlytimes;
	/**
     * 外出公干总工时
     */
	private java.math.BigDecimal businesstimes;
	/**
     * 旷工工时
     */
	private java.math.BigDecimal absenteeismtimes;
	/**
     * 欠工时
     */
	private java.math.BigDecimal owetimes;
	/**
     * 补签到次数
     */
	private Integer supplysigninnum;
	/**
     * 最低服务工时
     */
	private java.math.BigDecimal servertimes;
	/**
     * 实际打卡工时
     */
	private java.math.BigDecimal realtimes;
	/**
     * 付费总工时
     */
	private java.math.BigDecimal paytimes;
	/**
     * 加班次数
     */
	private Integer overtimenum;
	/**
     * 加班总工时
     */
	private java.math.BigDecimal overtimes;
	/**
     * 工作日延长工时
     */
	private java.math.BigDecimal extendtimes;

	private String pdu;
	/**
	 * 離岸、在岸
	 */
	private String monthInShore;

	private String po ;

	private String partnerPm;

	private String bak;

	private String area;

	private String department ;

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPo() {
		return po;
	}

	public void setPo(String po) {
		this.po = po;
	}

	public String getPartnerPm() {
		return partnerPm;
	}

	public void setPartnerPm(String partnerPm) {
		this.partnerPm = partnerPm;
	}

	public String getBak() {
		return bak;
	}

	public void setBak(String bak) {
		this.bak = bak;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getMonthInShore() {
		return monthInShore;
	}

	public void setMonthInShore(String monthInShore) {
		this.monthInShore = monthInShore;
	}

	public String getPdu() {
		return pdu;
	}

	public void setPdu(String pdu) {
		this.pdu = pdu;
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
	* <p>Discription:[外出公干总工时]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getBusinesstimes(){
		return businesstimes;
	}
	/**
	* <p>Discription:[外出公干总工时]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setBusinesstimes(java.math.BigDecimal businesstimes){
		this.businesstimes = businesstimes;
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
	* <p>Discription:[补签到次数]</p>
	* Created on 2020年10月13日
	* @return Integer
    * @author:wangchun
    */
	public Integer getSupplysigninnum(){
		return supplysigninnum;
	}
	/**
	* <p>Discription:[补签到次数]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setSupplysigninnum(Integer supplysigninnum){
		this.supplysigninnum = supplysigninnum;
	}
	/**
	* <p>Discription:[最低服务工时]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getServertimes(){
		return servertimes;
	}
	/**
	* <p>Discription:[最低服务工时]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setServertimes(java.math.BigDecimal servertimes){
		this.servertimes = servertimes;
	}
	/**
	* <p>Discription:[实际打卡工时]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getRealtimes(){
		return realtimes;
	}
	/**
	* <p>Discription:[实际打卡工时]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setRealtimes(java.math.BigDecimal realtimes){
		this.realtimes = realtimes;
	}
	/**
	* <p>Discription:[付费总工时]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getPaytimes(){
		return paytimes;
	}
	/**
	* <p>Discription:[付费总工时]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setPaytimes(java.math.BigDecimal paytimes){
		this.paytimes = paytimes;
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
	* <p>Discription:[加班总工时]</p>
	* Created on 2020年10月13日
	* @return java.math.BigDecimal
    * @author:wangchun
    */
	public java.math.BigDecimal getOvertimes(){
		return overtimes;
	}
	/**
	* <p>Discription:[加班总工时]</p>
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
}