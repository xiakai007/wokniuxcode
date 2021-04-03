package com.isoftstone.humanresources.domain;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description: [拜访记录表model]</p>
 * Created on 2020年03月03日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public class VisitModel  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 拜访记录编码
     */
	private Long visitid;
	/**
     * 参与人
     */
	private String players;
	/**
     * 拜访人员（客户，主要是华为方）
     */
	private String customers;
	/**
     * 拜访内容
     */
	private String content;
	/**
     * 拜访开始时间
     */
	private String visitbegintime;
	/**
     * 拜访结束时间
     */
	private String visitendtime;
	/**
     * 状态
     */
	private String status;
	/**
     * 创建人
     */
	private String creater;
	/**
     * 创建时间
     */
	private String creattime;
	/**
     * 备份
     */
	private String bak;

	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private VisitLeavemsgModel leavemsg;

	public VisitLeavemsgModel getLeavemsg() {
		return leavemsg;
	}

	public void setLeavemsg(VisitLeavemsgModel leavemsg) {
		this.leavemsg = leavemsg;
	}

	// 拜访遗留问题记录表
	private List<VisitLeavemsgModel> visitLeavemsgModelList;

	public List<VisitLeavemsgModel> getVisitLeavemsgModelList() {
		return visitLeavemsgModelList;
	}

	public void setVisitLeavemsgModelList(List<VisitLeavemsgModel> visitLeavemsgModelList) {
		this.visitLeavemsgModelList = visitLeavemsgModelList;
	}

	public Long getVisitid() {
		return visitid;
	}

	public void setVisitid(Long visitid) {
		this.visitid = visitid;
	}

	/**
	* <p>Discription:[参与人]</p>
	* Created on 2020年03月03日
	* @return String
    * @author:wangchun
    */
	public String getPlayers(){
		return players;
	}
	/**
	* <p>Discription:[参与人]</p>
	* Created on 2020年03月03日
	* @author:wangchun
	*/
	public void setPlayers(String players){
		this.players = players;
	}
	/**
	* <p>Discription:[拜访人员（客户，主要是华为方）]</p>
	* Created on 2020年03月03日
	* @return String
    * @author:wangchun
    */
	public String getCustomers(){
		return customers;
	}
	/**
	* <p>Discription:[拜访人员（客户，主要是华为方）]</p>
	* Created on 2020年03月03日
	* @author:wangchun
	*/
	public void setCustomers(String customers){
		this.customers = customers;
	}
	/**
	* <p>Discription:[拜访内容]</p>
	* Created on 2020年03月03日
	* @return String
    * @author:wangchun
    */
	public String getContent(){
		return content;
	}
	/**
	* <p>Discription:[拜访内容]</p>
	* Created on 2020年03月03日
	* @author:wangchun
	*/
	public void setContent(String content){
		this.content = content;
	}
	/**
	* <p>Discription:[拜访开始时间]</p>
	* Created on 2020年03月03日
	* @return String
    * @author:wangchun
    */
	public String getVisitbegintime(){
		return visitbegintime;
	}
	/**
	* <p>Discription:[拜访开始时间]</p>
	* Created on 2020年03月03日
	* @author:wangchun
	*/
	public void setVisitbegintime(String visitbegintime){
		this.visitbegintime = visitbegintime;
	}
	/**
	* <p>Discription:[拜访结束时间]</p>
	* Created on 2020年03月03日
	* @return String
    * @author:wangchun
    */
	public String getVisitendtime(){
		return visitendtime;
	}
	/**
	* <p>Discription:[拜访结束时间]</p>
	* Created on 2020年03月03日
	* @author:wangchun
	*/
	public void setVisitendtime(String visitendtime){
		this.visitendtime = visitendtime;
	}
	/**
	* <p>Discription:[状态]</p>
	* Created on 2020年03月03日
	* @return String
    * @author:wangchun
    */
	public String getStatus(){
		return status;
	}
	/**
	* <p>Discription:[状态]</p>
	* Created on 2020年03月03日
	* @author:wangchun
	*/
	public void setStatus(String status){
		this.status = status;
	}
	/**
	* <p>Discription:[创建人]</p>
	* Created on 2020年03月03日
	* @return String
    * @author:wangchun
    */
	public String getCreater(){
		return creater;
	}
	/**
	* <p>Discription:[创建人]</p>
	* Created on 2020年03月03日
	* @author:wangchun
	*/
	public void setCreater(String creater){
		this.creater = creater;
	}
	/**
	* <p>Discription:[创建时间]</p>
	* Created on 2020年03月03日
	* @return String
    * @author:wangchun
    */
	public String getCreattime(){
		return creattime;
	}
	/**
	* <p>Discription:[创建时间]</p>
	* Created on 2020年03月03日
	* @author:wangchun
	*/
	public void setCreattime(String creattime){
		this.creattime = creattime;
	}
	/**
	* <p>Discription:[备份]</p>
	* Created on 2020年03月03日
	* @return String
    * @author:wangchun
    */
	public String getBak(){
		return bak;
	}
	/**
	* <p>Discription:[备份]</p>
	* Created on 2020年03月03日
	* @author:wangchun
	*/
	public void setBak(String bak){
		this.bak = bak;
	}
}
