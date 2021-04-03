package com.isoftstone.humanresources.domain.recruit;

import java.io.Serializable;
/** 
 * <p>Description: [面试记录表model]</p>
 * Created on 2019年11月04日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2019年
 */
public class InterviewRecordModel  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 面试编号
     */
	private Integer recordid;
	/**
     * 候选人编号
     */
	private Integer candidateid;
	/**
     * 员工编号
     */
	private Integer employeeid;
	/**
	 * 候选人名称
	 */
	private String candidateName;
	/**
	 * 员工名称
	 */
	private String employeeName;
	/**
     * 面试官
     */
	private String candidatemanager;
	/**
     * 所在项目组
     */
	private String projectteam;
	/**
     * 面试时间
     */
	private String interviewtime;
	/**
     * 面试结果
     */
	private String interviewresult;
	/**
     * 面试类型，初试、复试、机试、OMP录入
     */
	private String interviewtype;
	/**
     * 备注
     */
	private String bak;

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	// setter and getter
	/**
	* <p>Discription:[面试编号]</p>
	* Created on 2019年11月04日
	* @return Integer
    * @author:wangchun
    */
	public Integer getRecordid(){
		return recordid;
	}
	/**
	* <p>Discription:[面试编号]</p>
	* Created on 2019年11月04日
	* @author:wangchun
	*/
	public void setRecordid(Integer recordid){
		this.recordid = recordid;
	}
	/**
	* <p>Discription:[候选人编号]</p>
	* Created on 2019年11月04日
	* @return Integer
    * @author:wangchun
    */
	public Integer getCandidateid(){
		return candidateid;
	}
	/**
	* <p>Discription:[候选人编号]</p>
	* Created on 2019年11月04日
	* @author:wangchun
	*/
	public void setCandidateid(Integer candidateid){
		this.candidateid = candidateid;
	}
	/**
	* <p>Discription:[员工编号]</p>
	* Created on 2019年11月04日
	* @return Integer
    * @author:wangchun
    */
	public Integer getEmployeeid(){
		return employeeid;
	}
	/**
	* <p>Discription:[员工编号]</p>
	* Created on 2019年11月04日
	* @author:wangchun
	*/
	public void setEmployeeid(Integer employeeid){
		this.employeeid = employeeid;
	}
	/**
	* <p>Discription:[面试官]</p>
	* Created on 2019年11月04日
	* @return String
    * @author:wangchun
    */
	public String getCandidatemanager(){
		return candidatemanager;
	}
	/**
	* <p>Discription:[面试官]</p>
	* Created on 2019年11月04日
	* @author:wangchun
	*/
	public void setCandidatemanager(String candidatemanager){
		this.candidatemanager = candidatemanager;
	}
	/**
	* <p>Discription:[所在项目组]</p>
	* Created on 2019年11月04日
	* @return String
    * @author:wangchun
    */
	public String getProjectteam(){
		return projectteam;
	}
	/**
	* <p>Discription:[所在项目组]</p>
	* Created on 2019年11月04日
	* @author:wangchun
	*/
	public void setProjectteam(String projectteam){
		this.projectteam = projectteam;
	}

	public String getInterviewtime() {
		return interviewtime;
	}

	public void setInterviewtime(String interviewtime) {
		this.interviewtime = interviewtime;
	}

	/**
	* <p>Discription:[面试结果]</p>
	* Created on 2019年11月04日
	* @return String
    * @author:wangchun
    */
	public String getInterviewresult(){
		return interviewresult;
	}
	/**
	* <p>Discription:[面试结果]</p>
	* Created on 2019年11月04日
	* @author:wangchun
	*/
	public void setInterviewresult(String interviewresult){
		this.interviewresult = interviewresult;
	}
	/**
	* <p>Discription:[面试类型，初试、复试、机试、OMP录入]</p>
	* Created on 2019年11月04日
	* @return String
    * @author:wangchun
    */
	public String getInterviewtype(){
		return interviewtype;
	}
	/**
	* <p>Discription:[面试类型，初试、复试、机试、OMP录入]</p>
	* Created on 2019年11月04日
	* @author:wangchun
	*/
	public void setInterviewtype(String interviewtype){
		this.interviewtype = interviewtype;
	}
	/**
	* <p>Discription:[备注]</p>
	* Created on 2019年11月04日
	* @return String
    * @author:wangchun
    */
	public String getBak(){
		return bak;
	}
	/**
	* <p>Discription:[备注]</p>
	* Created on 2019年11月04日
	* @author:wangchun
	*/
	public void setBak(String bak){
		this.bak = bak;
	}
}
