package com.isoftstone.humanresources.domain.recruit;

import java.io.Serializable;
/** 
 * <p>Description: [组织管理表model]</p>
 * Created on 2020年03月17日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public class PduCostcenterModel  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 
     */
	private Integer id;
	/**
     * 业务线
     */
	private String businessLine;
	/**
     * DU
     */
	private String businesssoneline;
	/**
     * 区域
     */
	private String area;
	/**
     * 成本中心
     */
	private String costCenter;
	/**
     * pdu
     */
	private String pdu;
	
	// setter and getter
	/**
	* <p>Discription:[]</p>
	* Created on 2020年03月17日
	* @return Integer
    * @author:wangchun
    */
	public Integer getId(){
		return id;
	}
	/**
	* <p>Discription:[]</p>
	* Created on 2020年03月17日
	* @author:wangchun
	*/
	public void setId(Integer id){
		this.id = id;
	}

	public String getBusinessLine() {
		return businessLine;
	}

	public void setBusinessLine(String businessLine) {
		this.businessLine = businessLine;
	}

	/**
	* <p>Discription:[DU]</p>
	* Created on 2020年03月17日
	* @return String
    * @author:wangchun
    */
	public String getBusinesssoneline(){
		return businesssoneline;
	}
	/**
	* <p>Discription:[DU]</p>
	* Created on 2020年03月17日
	* @author:wangchun
	*/
	public void setBusinesssoneline(String businesssoneline){
		this.businesssoneline = businesssoneline;
	}
	/**
	* <p>Discription:[区域]</p>
	* Created on 2020年03月17日
	* @return String
    * @author:wangchun
    */
	public String getArea(){
		return area;
	}
	/**
	* <p>Discription:[区域]</p>
	* Created on 2020年03月17日
	* @author:wangchun
	*/
	public void setArea(String area){
		this.area = area;
	}
	/**
	* <p>Discription:[成本中心]</p>
	* Created on 2020年03月17日
	* @return String
    * @author:wangchun
    */
	public String getCostCenter(){
		return costCenter;
	}
	/**
	* <p>Discription:[成本中心]</p>
	* Created on 2020年03月17日
	* @author:wangchun
	*/
	public void setCostCenter(String costCenter){
		this.costCenter = costCenter;
	}
	/**
	* <p>Discription:[pdu]</p>
	* Created on 2020年03月17日
	* @return String
    * @author:wangchun
    */
	public String getPdu(){
		return pdu;
	}
	/**
	* <p>Discription:[pdu]</p>
	* Created on 2020年03月17日
	* @author:wangchun
	*/
	public void setPdu(String pdu){
		this.pdu = pdu;
	}
}
