package com.isoftstone.humanresources.domain;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description: [意见建议表model]</p>
 * Created on 2020年05月25日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public class Suggest implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 主键
     */
	private Integer id;
	/**
     * 员工编码
     */
	private String employeeid;
	/**
     * 员工姓名
     */
	private String employeename;
	/**
     * 司龄
     */
	private String workage;
	/**
     * 产品用途
     */
	private String used;
	/**
     * 创意产品名称
     */
	private String productname;
	/**
     * 创意产品建议
     */
	private String productsuggest;

	private String productintroduce;
	/**
     * 新方式
     */
	private String newway;
	/**
     * 新客户群体
     */
	private String newgroup;
	/**
     * 新技术
     */
	private String newskill;
	/**
     * 推荐理由
     */
	private String introduce;
	/**
     * 相关资源
     */
	private String relation;
	/**
     * 需要的资源
     */
	private String needrelation;
	/**
     * 意见和建议
     */
	private String idea;
	/**
     * 我们的前景
     */
	private String vista;
	/**
     * 创新的意见
     */
	private String suggest;
	/**
     * 相关照片
     */
	private String imgs;

	private List<String> imgList;
	/**
     * 状态/权限
     */
	private String status;
	/**
     * 创建时间
     */
	private String createtime;
	/**
     * 更新时间
     */
	private String updatetime;
	/**
     * 备份
     */
	private String bak;

	public List<String> getImgList() {
		return imgList;
	}

	public void setImgList(List<String> imgList) {
		this.imgList = imgList;
	}

	public String getProductintroduce() {
		return productintroduce;
	}

	public void setProductintroduce(String productintroduce) {
		this.productintroduce = productintroduce;
	}

	// setter and getter
	/**
	* <p>Discription:[主键]</p>
	* Created on 2020年05月25日
	* @return Integer
    * @author:wangchun
    */
	public Integer getId(){
		return id;
	}
	/**
	* <p>Discription:[主键]</p>
	* Created on 2020年05月25日
	* @author:wangchun
	*/
	public void setId(Integer id){
		this.id = id;
	}
	/**
	* <p>Discription:[员工编码]</p>
	* Created on 2020年05月25日
	* @return String
    * @author:wangchun
    */
	public String getEmployeeid(){
		return employeeid;
	}
	/**
	* <p>Discription:[员工编码]</p>
	* Created on 2020年05月25日
	* @author:wangchun
	*/
	public void setEmployeeid(String employeeid){
		this.employeeid = employeeid;
	}
	/**
	* <p>Discription:[员工姓名]</p>
	* Created on 2020年05月25日
	* @return String
    * @author:wangchun
    */
	public String getEmployeename(){
		return employeename;
	}
	/**
	* <p>Discription:[员工姓名]</p>
	* Created on 2020年05月25日
	* @author:wangchun
	*/
	public void setEmployeename(String employeename){
		this.employeename = employeename;
	}
	/**
	* <p>Discription:[司龄]</p>
	* Created on 2020年05月25日
	* @return String
    * @author:wangchun
    */
	public String getWorkage(){
		return workage;
	}
	/**
	* <p>Discription:[司龄]</p>
	* Created on 2020年05月25日
	* @author:wangchun
	*/
	public void setWorkage(String workage){
		this.workage = workage;
	}

	public String getUsed() {
		return used;
	}

	public void setUsed(String used) {
		this.used = used;
	}

	/**
	* <p>Discription:[创意产品名称]</p>
	* Created on 2020年05月25日
	* @return String
    * @author:wangchun
    */
	public String getProductname(){
		return productname;
	}
	/**
	* <p>Discription:[创意产品名称]</p>
	* Created on 2020年05月25日
	* @author:wangchun
	*/
	public void setProductname(String productname){
		this.productname = productname;
	}
	/**
	* <p>Discription:[创意产品建议]</p>
	* Created on 2020年05月25日
	* @return String
    * @author:wangchun
    */
	public String getProductsuggest(){
		return productsuggest;
	}
	/**
	* <p>Discription:[创意产品建议]</p>
	* Created on 2020年05月25日
	* @author:wangchun
	*/
	public void setProductsuggest(String productsuggest){
		this.productsuggest = productsuggest;
	}
	/**
	* <p>Discription:[新方式]</p>
	* Created on 2020年05月25日
	* @return String
    * @author:wangchun
    */
	public String getNewway(){
		return newway;
	}
	/**
	* <p>Discription:[新方式]</p>
	* Created on 2020年05月25日
	* @author:wangchun
	*/
	public void setNewway(String newway){
		this.newway = newway;
	}
	/**
	* <p>Discription:[新客户群体]</p>
	* Created on 2020年05月25日
	* @return String
    * @author:wangchun
    */
	public String getNewgroup(){
		return newgroup;
	}
	/**
	* <p>Discription:[新客户群体]</p>
	* Created on 2020年05月25日
	* @author:wangchun
	*/
	public void setNewgroup(String newgroup){
		this.newgroup = newgroup;
	}
	/**
	* <p>Discription:[新技术]</p>
	* Created on 2020年05月25日
	* @return String
    * @author:wangchun
    */
	public String getNewskill(){
		return newskill;
	}
	/**
	* <p>Discription:[新技术]</p>
	* Created on 2020年05月25日
	* @author:wangchun
	*/
	public void setNewskill(String newskill){
		this.newskill = newskill;
	}
	/**
	* <p>Discription:[推荐理由]</p>
	* Created on 2020年05月25日
	* @return String
    * @author:wangchun
    */
	public String getIntroduce(){
		return introduce;
	}
	/**
	* <p>Discription:[推荐理由]</p>
	* Created on 2020年05月25日
	* @author:wangchun
	*/
	public void setIntroduce(String introduce){
		this.introduce = introduce;
	}
	/**
	* <p>Discription:[相关资源]</p>
	* Created on 2020年05月25日
	* @return String
    * @author:wangchun
    */
	public String getRelation(){
		return relation;
	}
	/**
	* <p>Discription:[相关资源]</p>
	* Created on 2020年05月25日
	* @author:wangchun
	*/
	public void setRelation(String relation){
		this.relation = relation;
	}
	/**
	* <p>Discription:[需要的资源]</p>
	* Created on 2020年05月25日
	* @return String
    * @author:wangchun
    */
	public String getNeedrelation(){
		return needrelation;
	}
	/**
	* <p>Discription:[需要的资源]</p>
	* Created on 2020年05月25日
	* @author:wangchun
	*/
	public void setNeedrelation(String needrelation){
		this.needrelation = needrelation;
	}
	/**
	* <p>Discription:[意见和建议]</p>
	* Created on 2020年05月25日
	* @return String
    * @author:wangchun
    */
	public String getIdea(){
		return idea;
	}
	/**
	* <p>Discription:[意见和建议]</p>
	* Created on 2020年05月25日
	* @author:wangchun
	*/
	public void setIdea(String idea){
		this.idea = idea;
	}
	/**
	* <p>Discription:[我们的前景]</p>
	* Created on 2020年05月25日
	* @return String
    * @author:wangchun
    */
	public String getVista(){
		return vista;
	}
	/**
	* <p>Discription:[我们的前景]</p>
	* Created on 2020年05月25日
	* @author:wangchun
	*/
	public void setVista(String vista){
		this.vista = vista;
	}
	/**
	* <p>Discription:[创新的意见]</p>
	* Created on 2020年05月25日
	* @return String
    * @author:wangchun
    */
	public String getSuggest(){
		return suggest;
	}
	/**
	* <p>Discription:[创新的意见]</p>
	* Created on 2020年05月25日
	* @author:wangchun
	*/
	public void setSuggest(String suggest){
		this.suggest = suggest;
	}
	/**
	* <p>Discription:[活动照片]</p>
	* Created on 2020年05月25日
	* @return String
    * @author:wangchun
    */
	public String getImgs(){
		return imgs;
	}
	/**
	* <p>Discription:[活动照片]</p>
	* Created on 2020年05月25日
	* @author:wangchun
	*/
	public void setImgs(String imgs){
		this.imgs = imgs;
	}
	/**
	* <p>Discription:[状态/权限]</p>
	* Created on 2020年05月25日
	* @return String
    * @author:wangchun
    */
	public String getStatus(){
		return status;
	}
	/**
	* <p>Discription:[状态/权限]</p>
	* Created on 2020年05月25日
	* @author:wangchun
	*/
	public void setStatus(String status){
		this.status = status;
	}
	/**
	* <p>Discription:[创建时间]</p>
	* Created on 2020年05月25日
	* @return String
    * @author:wangchun
    */
	public String getCreatetime(){
		return createtime;
	}
	/**
	* <p>Discription:[创建时间]</p>
	* Created on 2020年05月25日
	* @author:wangchun
	*/
	public void setCreatetime(String createtime){
		this.createtime = createtime;
	}
	/**
	* <p>Discription:[更新时间]</p>
	* Created on 2020年05月25日
	* @return String
    * @author:wangchun
    */
	public String getUpdatetime(){
		return updatetime;
	}
	/**
	* <p>Discription:[更新时间]</p>
	* Created on 2020年05月25日
	* @author:wangchun
	*/
	public void setUpdatetime(String updatetime){
		this.updatetime = updatetime;
	}
	/**
	* <p>Discription:[备份]</p>
	* Created on 2020年05月25日
	* @return String
    * @author:wangchun
    */
	public String getBak(){
		return bak;
	}
	/**
	* <p>Discription:[备份]</p>
	* Created on 2020年05月25日
	* @author:wangchun
	*/
	public void setBak(String bak){
		this.bak = bak;
	}
}
