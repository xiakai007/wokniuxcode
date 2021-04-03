package com.isoftstone.humanresources.domain.gather;

import java.io.Serializable;
/** 
 * <p>Description: [关注表model]</p>
 * Created on 2020年05月26日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public class FollowModel  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 主键
     */
	private Integer id;
	/**
     * 类型
     */
	private String type;
	/**
     * 员工编码
     */
	private String employeeid;
	/**
     * 被关注员工编码
     */
	private String followid;
	/**
     * 状态
     */
	private String status;
	/**
     * 创建时间
     */
	private String createtime;
	/**
     * 备份
     */
	private String bak;
	
	// setter and getter
	/**
	* <p>Discription:[主键]</p>
	* Created on 2020年05月26日
	* @return Integer
    * @author:wangchun
    */
	public Integer getId(){
		return id;
	}
	/**
	* <p>Discription:[主键]</p>
	* Created on 2020年05月26日
	* @author:wangchun
	*/
	public void setId(Integer id){
		this.id = id;
	}
	/**
	* <p>Discription:[类型]</p>
	* Created on 2020年05月26日
	* @return String
    * @author:wangchun
    */
	public String getType(){
		return type;
	}
	/**
	* <p>Discription:[类型]</p>
	* Created on 2020年05月26日
	* @author:wangchun
	*/
	public void setType(String type){
		this.type = type;
	}
	/**
	* <p>Discription:[员工编码]</p>
	* Created on 2020年05月26日
	* @return String
    * @author:wangchun
    */
	public String getEmployeeid(){
		return employeeid;
	}
	/**
	* <p>Discription:[员工编码]</p>
	* Created on 2020年05月26日
	* @author:wangchun
	*/
	public void setEmployeeid(String employeeid){
		this.employeeid = employeeid;
	}
	/**
	* <p>Discription:[被关注员工编码]</p>
	* Created on 2020年05月26日
	* @return String
    * @author:wangchun
    */
	public String getFollowid(){
		return followid;
	}
	/**
	* <p>Discription:[被关注员工编码]</p>
	* Created on 2020年05月26日
	* @author:wangchun
	*/
	public void setFollowid(String followid){
		this.followid = followid;
	}
	/**
	* <p>Discription:[状态]</p>
	* Created on 2020年05月26日
	* @return String
    * @author:wangchun
    */
	public String getStatus(){
		return status;
	}
	/**
	* <p>Discription:[状态]</p>
	* Created on 2020年05月26日
	* @author:wangchun
	*/
	public void setStatus(String status){
		this.status = status;
	}
	/**
	* <p>Discription:[创建时间]</p>
	* Created on 2020年05月26日
	* @return String
    * @author:wangchun
    */
	public String getCreatetime(){
		return createtime;
	}
	/**
	* <p>Discription:[创建时间]</p>
	* Created on 2020年05月26日
	* @author:wangchun
	*/
	public void setCreatetime(String createtime){
		this.createtime = createtime;
	}
	/**
	* <p>Discription:[备份]</p>
	* Created on 2020年05月26日
	* @return String
    * @author:wangchun
    */
	public String getBak(){
		return bak;
	}
	/**
	* <p>Discription:[备份]</p>
	* Created on 2020年05月26日
	* @author:wangchun
	*/
	public void setBak(String bak){
		this.bak = bak;
	}
}
