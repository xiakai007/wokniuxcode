package com.isoftstone.humanresources.domain.workTime;

import java.io.Serializable;
/** 
 * <p>Description: [考勤机配置表model]</p>
 * Created on 2020年10月28日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public class TerminalInfoModel  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 主键
     */
	private Integer id;
	/**
     * 区域
     */
	private String area;
	/**
     * 终端ID
     */
	private String terminalId;
	/**
     * 在岸、离岸
     */
	private String shoreType;
	/**
     * 终端位置
     */
	private String address;
	/**
     * 状态
     */
	private String status;
	/**
     * 创建时间
     */
	private java.util.Date createTime;
	/**
     * 备份
     */
	private String bak;
	
	// setter and getter
	/**
	* <p>Discription:[主键]</p>
	* Created on 2020年10月28日
	* @return Integer
    * @author:wangchun
    */
	public Integer getId(){
		return id;
	}
	/**
	* <p>Discription:[主键]</p>
	* Created on 2020年10月28日
	* @author:wangchun
	*/
	public void setId(Integer id){
		this.id = id;
	}
	/**
	* <p>Discription:[区域]</p>
	* Created on 2020年10月28日
	* @return String
    * @author:wangchun
    */
	public String getArea(){
		return area;
	}
	/**
	* <p>Discription:[区域]</p>
	* Created on 2020年10月28日
	* @author:wangchun
	*/
	public void setArea(String area){
		this.area = area;
	}
	/**
	* <p>Discription:[终端ID]</p>
	* Created on 2020年10月28日
	* @return String
    * @author:wangchun
    */
	public String getTerminalId(){
		return terminalId;
	}
	/**
	* <p>Discription:[终端ID]</p>
	* Created on 2020年10月28日
	* @author:wangchun
	*/
	public void setTerminalId(String terminalId){
		this.terminalId = terminalId;
	}
	/**
	* <p>Discription:[在岸、离岸]</p>
	* Created on 2020年10月28日
	* @return String
    * @author:wangchun
    */
	public String getShoreType(){
		return shoreType;
	}
	/**
	* <p>Discription:[在岸、离岸]</p>
	* Created on 2020年10月28日
	* @author:wangchun
	*/
	public void setShoreType(String shoreType){
		this.shoreType = shoreType;
	}
	/**
	* <p>Discription:[终端位置]</p>
	* Created on 2020年10月28日
	* @return String
    * @author:wangchun
    */
	public String getAddress(){
		return address;
	}
	/**
	* <p>Discription:[终端位置]</p>
	* Created on 2020年10月28日
	* @author:wangchun
	*/
	public void setAddress(String address){
		this.address = address;
	}
	/**
	* <p>Discription:[状态]</p>
	* Created on 2020年10月28日
	* @return String
    * @author:wangchun
    */
	public String getStatus(){
		return status;
	}
	/**
	* <p>Discription:[状态]</p>
	* Created on 2020年10月28日
	* @author:wangchun
	*/
	public void setStatus(String status){
		this.status = status;
	}
	/**
	* <p>Discription:[创建时间]</p>
	* Created on 2020年10月28日
	* @return java.util.Date
    * @author:wangchun
    */
	public java.util.Date getCreateTime(){
		return createTime;
	}
	/**
	* <p>Discription:[创建时间]</p>
	* Created on 2020年10月28日
	* @author:wangchun
	*/
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	/**
	* <p>Discription:[备份]</p>
	* Created on 2020年10月28日
	* @return String
    * @author:wangchun
    */
	public String getBak(){
		return bak;
	}
	/**
	* <p>Discription:[备份]</p>
	* Created on 2020年10月28日
	* @author:wangchun
	*/
	public void setBak(String bak){
		this.bak = bak;
	}
}
