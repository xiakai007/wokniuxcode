package com.isoftstone.humanresources.domain.gather;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>Description: [评论表model]</p>
 * Created on 2020年05月26日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public class UpConnectReg implements Serializable {

	private static final long serialVersionUID = -1L;

	/**
     * 主键
     */
	private String id;
	/**
     *
     */
	private Integer userid;
	/**
     *
     */
	private String password;
	/**
     *
     */
	private String down_link_ip;
	/**
     *
     */
	private String down_link_port;

	/**
	 *
	 */
	private Integer result;
	/**
     *
     */
	private List<String> remarks;
	/**
     *
     */
	private Date update_date;
	/**
     *
     */
	private Date insert_date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDown_link_ip() {
		return down_link_ip;
	}

	public void setDown_link_ip(String down_link_ip) {
		this.down_link_ip = down_link_ip;
	}

	public String getDown_link_port() {
		return down_link_port;
	}

	public void setDown_link_port(String down_link_port) {
		this.down_link_port = down_link_port;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public List<String> getRemarks() {
		return remarks;
	}

	public void setRemarks(List<String> remarks) {
		this.remarks = remarks;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public Date getInsert_date() {
		return insert_date;
	}

	public void setInsert_date(Date insert_date) {
		this.insert_date = insert_date;
	}
}
