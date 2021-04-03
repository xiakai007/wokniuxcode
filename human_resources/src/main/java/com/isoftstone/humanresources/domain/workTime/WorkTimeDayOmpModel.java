package com.isoftstone.humanresources.domain.workTime;

import java.io.Serializable;
/** 
 * <p>Description: [员工OMP日考勤记录model]</p>
 * Created on 2020年10月13日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public class WorkTimeDayOmpModel  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 工号
     */
	private Integer employeeid;
	/**
     * 姓名
     */
	private String employeename;
	/**
     * 身份证号
     */
	private String cardid;
	/**
     * 考勤日期 yyyy-MM-dd
     */
	private String workday;
	/**
     * 班次
     */
	private String workcatagray;
	/**
     * PO
     */
	private String po;
	/**
     * 人员状态
     */
	private String personstatus;
	/**
     * 出勤工时
     */
	private java.math.BigDecimal actualtimes;
	/**
     * 请假工时
     */
	private java.math.BigDecimal holidaytimes;
	/**
     * 旷工工时
     */
	private java.math.BigDecimal absenteeismtimes;
	/**
     * 早退处罚工时
     */
	private java.math.BigDecimal penalizetimes;
	/**
     * 加班工时
     */
	private java.math.BigDecimal overtimes;
	/**
     * 延长工时
     */
	private java.math.BigDecimal extendtimes;
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
	 * 当天在岸、离岸信息
	 */
	private String shoreMsg ;
	/**
	 * 当天签到信息
	 */
	private String signMsg ;

	private String terminalIds ;

	private String bak ;

	private String pdu;

	private String exception1;

	private String exception2;

	private String area;

	private String monthStr ;

	private String replenish;

	private String replenishMsg;

	private String replenishTime;

	public String getReplenish() {
		return replenish;
	}

	public void setReplenish(String replenish) {
		this.replenish = replenish;
	}

	public String getReplenishMsg() {
		return replenishMsg;
	}

	public void setReplenishMsg(String replenishMsg) {
		this.replenishMsg = replenishMsg;
	}

	public String getReplenishTime() {
		return replenishTime;
	}

	public void setReplenishTime(String replenishTime) {
		this.replenishTime = replenishTime;
	}

	public String getMonthStr() {
		return monthStr;
	}

	public void setMonthStr(String monthStr) {
		this.monthStr = monthStr;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPdu() {
		return pdu;
	}

	public void setPdu(String pdu) {
		this.pdu = pdu;
	}

	public String getException1() {
		return exception1;
	}

	public void setException1(String exception1) {
		this.exception1 = exception1;
	}

	public String getException2() {
		return exception2;
	}

	public void setException2(String exception2) {
		this.exception2 = exception2;
	}

	public String getTerminalIds() {
		return terminalIds;
	}

	public void setTerminalIds(String terminalIds) {
		this.terminalIds = terminalIds;
	}

	public String getBak() {
		return bak;
	}

	public void setBak(String bak) {
		this.bak = bak;
	}

	public String getShoreMsg() {
		return shoreMsg;
	}

	public void setShoreMsg(String shoreMsg) {
		this.shoreMsg = shoreMsg;
	}

	public String getSignMsg() {
		return signMsg;
	}

	public void setSignMsg(String signMsg) {
		this.signMsg = signMsg;
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
	* <p>Discription:[姓名]</p>
	* Created on 2020年10月13日
	* @return String
    * @author:wangchun
    */
	public String getEmployeename(){
		return employeename;
	}
	/**
	* <p>Discription:[姓名]</p>
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
	* <p>Discription:[班次]</p>
	* Created on 2020年10月13日
	* @return String
    * @author:wangchun
    */
	public String getWorkcatagray(){
		return workcatagray;
	}
	/**
	* <p>Discription:[班次]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setWorkcatagray(String workcatagray){
		this.workcatagray = workcatagray;
	}
	/**
	* <p>Discription:[PO]</p>
	* Created on 2020年10月13日
	* @return String
    * @author:wangchun
    */
	public String getPo(){
		return po;
	}
	/**
	* <p>Discription:[PO]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setPo(String po){
		this.po = po;
	}
	/**
	* <p>Discription:[人员状态]</p>
	* Created on 2020年10月13日
	* @return String
    * @author:wangchun
    */
	public String getPersonstatus(){
		return personstatus;
	}
	/**
	* <p>Discription:[人员状态]</p>
	* Created on 2020年10月13日
	* @author:wangchun
	*/
	public void setPersonstatus(String personstatus){
		this.personstatus = personstatus;
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
}
