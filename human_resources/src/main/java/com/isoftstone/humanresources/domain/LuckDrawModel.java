package com.isoftstone.humanresources.domain;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description: [抽奖信息表model]</p>
 * Created on 2019年12月13日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2019年
 */
public class LuckDrawModel  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 员工编号
     */
	private Integer employeeid;
	/**
     * 员工姓名
     */
	private String employeename;
	/**
     * 部门名称
     */
	private String departmentname;
	/**
     * 创建时间
     */
	private String createtime;
	/**
     * 状态
     */
	private String status;
	/**
     * 备份
     */
	private String bak;

	private String image; //图片地址集合

	private String ip;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	// setter and getter
	/**
	* <p>Discription:[员工编号]</p>
	* Created on 2019年12月13日
	* @return Integer
    * @author:wangchun
    */
	public Integer getEmployeeid(){
		return employeeid;
	}
	/**
	* <p>Discription:[员工编号]</p>
	* Created on 2019年12月13日
	* @author:wangchun
	*/
	public void setEmployeeid(Integer employeeid){
		this.employeeid = employeeid;
	}
	/**
	* <p>Discription:[员工姓名]</p>
	* Created on 2019年12月13日
	* @return String
    * @author:wangchun
    */
	public String getEmployeename(){
		return employeename;
	}
	/**
	* <p>Discription:[员工姓名]</p>
	* Created on 2019年12月13日
	* @author:wangchun
	*/
	public void setEmployeename(String employeename){
		this.employeename = employeename;
	}
	/**
	* <p>Discription:[部门名称]</p>
	* Created on 2019年12月13日
	* @return String
    * @author:wangchun
    */
	public String getDepartmentname(){
		return departmentname;
	}
	/**
	* <p>Discription:[部门名称]</p>
	* Created on 2019年12月13日
	* @author:wangchun
	*/
	public void setDepartmentname(String departmentname){
		this.departmentname = departmentname;
	}
	/**
	* <p>Discription:[创建时间]</p>
	* Created on 2019年12月13日
	* @return String
    * @author:wangchun
    */
	public String getCreatetime(){
		return createtime;
	}
	/**
	* <p>Discription:[创建时间]</p>
	* Created on 2019年12月13日
	* @author:wangchun
	*/
	public void setCreatetime(String createtime){
		this.createtime = createtime;
	}
	/**
	* <p>Discription:[状态]</p>
	* Created on 2019年12月13日
	* @return String
    * @author:wangchun
    */
	public String getStatus(){
		return status;
	}
	/**
	* <p>Discription:[状态]</p>
	* Created on 2019年12月13日
	* @author:wangchun
	*/
	public void setStatus(String status){
		this.status = status;
	}
	/**
	* <p>Discription:[备份]</p>
	* Created on 2019年12月13日
	* @return String
    * @author:wangchun
    */
	public String getBak(){
		return bak;
	}
	/**
	* <p>Discription:[备份]</p>
	* Created on 2019年12月13日
	* @author:wangchun
	*/
	public void setBak(String bak){
		this.bak = bak;
	}
}
