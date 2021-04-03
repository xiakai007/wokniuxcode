package com.isoftstone.humanresources.domain.gather;

import java.io.Serializable;
/** 
 * <p>Description: [点赞表model]</p>
 * Created on 2020年05月26日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public class ZanModel  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 主键
     */
	private Integer id;
	/**
     * 类型，文章、评论
     */
	private String type;
	/**
     * 知识点、新鲜事、风采展示对应的ID
     */
	private String zanid;
	/**
	 * 类型：知识点 KS、 新鲜事 NEWS、风采展示 GA
	 */
	private String zantype;
	/**
     * 员工编码
     */
	private String employeeid;
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

	public String getZantype() {
		return zantype;
	}

	public void setZantype(String zantype) {
		this.zantype = zantype;
	}

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
	* <p>Discription:[类型，文章、评论]</p>
	* Created on 2020年05月26日
	* @return String
    * @author:wangchun
    */
	public String getType(){
		return type;
	}
	/**
	* <p>Discription:[类型，文章、评论]</p>
	* Created on 2020年05月26日
	* @author:wangchun
	*/
	public void setType(String type){
		this.type = type;
	}
	/**
	* <p>Discription:[知识点、新鲜事、风采展示对应的ID]</p>
	* Created on 2020年05月26日
	* @return String
    * @author:wangchun
    */
	public String getZanid(){
		return zanid;
	}
	/**
	* <p>Discription:[知识点、新鲜事、风采展示对应的ID]</p>
	* Created on 2020年05月26日
	* @author:wangchun
	*/
	public void setZanid(String zanid){
		this.zanid = zanid;
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
