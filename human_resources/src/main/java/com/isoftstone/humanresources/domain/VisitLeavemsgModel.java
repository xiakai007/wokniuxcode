package com.isoftstone.humanresources.domain;

import java.io.Serializable;
/** 
 * <p>Description: [遗留问题记录表model]</p>
 * Created on 2020年03月03日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public class VisitLeavemsgModel  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 遗留问题编码
     */
	private Long leaveid;
	/**
     * 拜访记录编码
     */
	private Long visitid;
	/**
     * 遗留问题跟踪
     */
	private String content;
	/**
     * 遗留问题优先级
     */
	private String priority;
	/**
     * 遗留问题需要的支持
     */
	private String need;
	/**
     * 计划解决时间
     */
	private String resolvetime;
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

	public Long getLeaveid() {
		return leaveid;
	}

	public void setLeaveid(Long leaveid) {
		this.leaveid = leaveid;
	}

	public Long getVisitid() {
		return visitid;
	}

	public void setVisitid(Long visitid) {
		this.visitid = visitid;
	}

	/**
	* <p>Discription:[遗留问题跟踪]</p>
	* Created on 2020年03月03日
	* @return String
    * @author:wangchun
    */
	public String getContent(){
		return content;
	}
	/**
	* <p>Discription:[遗留问题跟踪]</p>
	* Created on 2020年03月03日
	* @author:wangchun
	*/
	public void setContent(String content){
		this.content = content;
	}
	/**
	* <p>Discription:[遗留问题优先级]</p>
	* Created on 2020年03月03日
	* @return String
    * @author:wangchun
    */
	public String getPriority(){
		return priority;
	}
	/**
	* <p>Discription:[遗留问题优先级]</p>
	* Created on 2020年03月03日
	* @author:wangchun
	*/
	public void setPriority(String priority){
		this.priority = priority;
	}
	/**
	* <p>Discription:[遗留问题需要的支持]</p>
	* Created on 2020年03月03日
	* @return String
    * @author:wangchun
    */
	public String getNeed(){
		return need;
	}
	/**
	* <p>Discription:[遗留问题需要的支持]</p>
	* Created on 2020年03月03日
	* @author:wangchun
	*/
	public void setNeed(String need){
		this.need = need;
	}
	/**
	* <p>Discription:[计划解决时间]</p>
	* Created on 2020年03月03日
	* @return String
    * @author:wangchun
    */
	public String getResolvetime(){
		return resolvetime;
	}
	/**
	* <p>Discription:[计划解决时间]</p>
	* Created on 2020年03月03日
	* @author:wangchun
	*/
	public void setResolvetime(String resolvetime){
		this.resolvetime = resolvetime;
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
}
