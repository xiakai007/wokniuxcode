package com.isoftstone.humanresources.domain.recruit;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description: [候选人信息表model]</p>
 * Created on 2019年11月04日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2019年
 */
public class CandidateModel  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 候选人编号
     */
	private Integer candidateID;
	/**
     * 候选人姓名
     */
	private String candidateName;
	/**
     * 性别
     */
	private String sex;
	/**
     * 手机号码
     */
	private String mobile;
	/**
     * 邮箱
     */
	private String email;
	/**
     * 身份证号
     */
	private String cardID;
	/**
     * 状态
     */
	private String status;
	/**
     * 技能
     */
	private String skill;
	/**
     * 工作年限
     */
	private String workYear;
	/**
     * 出生日期
     */
	private String birthday;
	/**
     * 专业
     */
	private String major;
	/**
     * 毕业院校
     */
	private String graducationSchool;
	/**
     * 毕业时间
     */
	private String graducationDate;
	/**
     * 参加工作时间
     */
	private String workDate;
	/**
     * 是否211
     */
	private String is211;
	/**
     * 招聘顾问
     */
	private String rmo;
	/**
     * 招聘责任人
     */
	private String responsible;
	/**
     * 工作区域
     */
	private String area;
	/**
     * 简历地址
     */
	private String resumeurl;
	/**
     * 备份
     */
	private String bak;

	private String createTime;

	private String createUser;

	/**
	 * 初次预约时间
	 */
	private String firstOrderTime;

	/**
	 *  面试记录
	 */
	private List<InterviewRecordModel> interviewRecordModelList;

	public List<InterviewRecordModel> getInterviewRecordModelList() {
		return interviewRecordModelList;
	}

	public void setInterviewRecordModelList(List<InterviewRecordModel> interviewRecordModelList) {
		this.interviewRecordModelList = interviewRecordModelList;
	}

	public String getFirstOrderTime() {
		return firstOrderTime;
	}

	public void setFirstOrderTime(String firstOrderTime) {
		this.firstOrderTime = firstOrderTime;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	/**
	* <p>Discription:[性别]</p>
	* Created on 2019年11月04日
	* @return String
    * @author:wangchun
    */
	public String getSex(){
		return sex;
	}
	/**
	* <p>Discription:[性别]</p>
	* Created on 2019年11月04日
	* @author:wangchun
	*/
	public void setSex(String sex){
		this.sex = sex;
	}
	/**
	* <p>Discription:[手机号码]</p>
	* Created on 2019年11月04日
	* @return String
    * @author:wangchun
    */
	public String getMobile(){
		return mobile;
	}
	/**
	* <p>Discription:[手机号码]</p>
	* Created on 2019年11月04日
	* @author:wangchun
	*/
	public void setMobile(String mobile){
		this.mobile = mobile;
	}
	/**
	* <p>Discription:[邮箱]</p>
	* Created on 2019年11月04日
	* @return String
    * @author:wangchun
    */
	public String getEmail(){
		return email;
	}
	/**
	* <p>Discription:[邮箱]</p>
	* Created on 2019年11月04日
	* @author:wangchun
	*/
	public void setEmail(String email){
		this.email = email;
	}

	/**
	* <p>Discription:[状态]</p>
	* Created on 2019年11月04日
	* @return String
    * @author:wangchun
    */
	public String getStatus(){
		return status;
	}
	/**
	* <p>Discription:[状态]</p>
	* Created on 2019年11月04日
	* @author:wangchun
	*/
	public void setStatus(String status){
		this.status = status;
	}
	/**
	* <p>Discription:[技能]</p>
	* Created on 2019年11月04日
	* @return String
    * @author:wangchun
    */
	public String getSkill(){
		return skill;
	}
	/**
	* <p>Discription:[技能]</p>
	* Created on 2019年11月04日
	* @author:wangchun
	*/
	public void setSkill(String skill){
		this.skill = skill;
	}

	/**
	* <p>Discription:[出生日期]</p>
	* Created on 2019年11月04日
	* @return String
    * @author:wangchun
    */
	public String getBirthday(){
		return birthday;
	}
	/**
	* <p>Discription:[出生日期]</p>
	* Created on 2019年11月04日
	* @author:wangchun
	*/
	public void setBirthday(String birthday){
		this.birthday = birthday;
	}
	/**
	* <p>Discription:[专业]</p>
	* Created on 2019年11月04日
	* @return String
    * @author:wangchun
    */
	public String getMajor(){
		return major;
	}
	/**
	* <p>Discription:[专业]</p>
	* Created on 2019年11月04日
	* @author:wangchun
	*/
	public void setMajor(String major){
		this.major = major;
	}

	/**
	* <p>Discription:[是否211]</p>
	* Created on 2019年11月04日
	* @return String
    * @author:wangchun
    */
	public String getIs211(){
		return is211;
	}
	/**
	* <p>Discription:[是否211]</p>
	* Created on 2019年11月04日
	* @author:wangchun
	*/
	public void setIs211(String is211){
		this.is211 = is211;
	}
	/**
	* <p>Discription:[招聘顾问]</p>
	* Created on 2019年11月04日
	* @return String
    * @author:wangchun
    */
	public String getRmo(){
		return rmo;
	}
	/**
	* <p>Discription:[招聘顾问]</p>
	* Created on 2019年11月04日
	* @author:wangchun
	*/
	public void setRmo(String rmo){
		this.rmo = rmo;
	}
	/**
	* <p>Discription:[招聘责任人]</p>
	* Created on 2019年11月04日
	* @return String
    * @author:wangchun
    */
	public String getResponsible(){
		return responsible;
	}
	/**
	* <p>Discription:[招聘责任人]</p>
	* Created on 2019年11月04日
	* @author:wangchun
	*/
	public void setResponsible(String responsible){
		this.responsible = responsible;
	}
	/**
	* <p>Discription:[工作区域]</p>
	* Created on 2019年11月04日
	* @return String
    * @author:wangchun
    */
	public String getArea(){
		return area;
	}
	/**
	* <p>Discription:[工作区域]</p>
	* Created on 2019年11月04日
	* @author:wangchun
	*/
	public void setArea(String area){
		this.area = area;
	}
	/**
	* <p>Discription:[简历地址]</p>
	* Created on 2019年11月04日
	* @return String
    * @author:wangchun
    */
	public String getResumeurl(){
		return resumeurl;
	}
	/**
	* <p>Discription:[简历地址]</p>
	* Created on 2019年11月04日
	* @author:wangchun
	*/
	public void setResumeurl(String resumeurl){
		this.resumeurl = resumeurl;
	}
	/**
	* <p>Discription:[备份]</p>
	* Created on 2019年11月04日
	* @return String
    * @author:wangchun
    */
	public String getBak(){
		return bak;
	}
	/**
	* <p>Discription:[备份]</p>
	* Created on 2019年11月04日
	* @author:wangchun
	*/
	public void setBak(String bak){
		this.bak = bak;
	}

	public Integer getCandidateID() {
		return candidateID;
	}

	public void setCandidateID(Integer candidateID) {
		this.candidateID = candidateID;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getCardID() {
		return cardID;
	}

	public void setCardID(String cardID) {
		this.cardID = cardID;
	}

	public String getWorkYear() {
		return workYear;
	}

	public void setWorkYear(String workYear) {
		this.workYear = workYear;
	}

	public String getGraducationSchool() {
		return graducationSchool;
	}

	public void setGraducationSchool(String graducationSchool) {
		this.graducationSchool = graducationSchool;
	}

	public String getGraducationDate() {
		return graducationDate;
	}

	public void setGraducationDate(String graducationDate) {
		this.graducationDate = graducationDate;
	}

	public String getWorkDate() {
		return workDate;
	}

	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}
}
