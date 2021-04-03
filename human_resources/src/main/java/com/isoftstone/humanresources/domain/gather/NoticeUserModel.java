package com.isoftstone.humanresources.domain.gather;

import java.io.Serializable;
/** 
 * <p>Description: [消息通知人model]</p>
 * Created on 2020年06月08日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public class NoticeUserModel  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 
     */
	private Integer id;
	/**
     * 通知序号
     */
	private Integer noticeId;
	/**
     * 被通知人
     */
	private String noticeUser;
	/**
     * 通知是否已读 0：未读 1：已读
     */
	private Integer noticeSight;
	/**
     * 邮件是否发送 0：未发送 1：发送
     */
	private Integer mailSend;
	
	// setter and getter
	/**
	* <p>Discription:[]</p>
	* Created on 2020年06月08日
	* @return Integer
    * @author:wangchun
    */
	public Integer getId(){
		return id;
	}
	/**
	* <p>Discription:[]</p>
	* Created on 2020年06月08日
	* @author:wangchun
	*/
	public void setId(Integer id){
		this.id = id;
	}
	/**
	* <p>Discription:[通知序号]</p>
	* Created on 2020年06月08日
	* @return Integer
    * @author:wangchun
    */
	public Integer getNoticeId(){
		return noticeId;
	}
	/**
	* <p>Discription:[通知序号]</p>
	* Created on 2020年06月08日
	* @author:wangchun
	*/
	public void setNoticeId(Integer noticeId){
		this.noticeId = noticeId;
	}
	/**
	* <p>Discription:[被通知人]</p>
	* Created on 2020年06月08日
	* @return String
    * @author:wangchun
    */
	public String getNoticeUser(){
		return noticeUser;
	}
	/**
	* <p>Discription:[被通知人]</p>
	* Created on 2020年06月08日
	* @author:wangchun
	*/
	public void setNoticeUser(String noticeUser){
		this.noticeUser = noticeUser;
	}
	/**
	* <p>Discription:[通知是否已读 0：未读 1：已读]</p>
	* Created on 2020年06月08日
	* @return Integer
    * @author:wangchun
    */
	public Integer getNoticeSight(){
		return noticeSight;
	}
	/**
	* <p>Discription:[通知是否已读 0：未读 1：已读]</p>
	* Created on 2020年06月08日
	* @author:wangchun
	*/
	public void setNoticeSight(Integer noticeSight){
		this.noticeSight = noticeSight;
	}
	/**
	* <p>Discription:[邮件是否发送 0：未发送 1：发送]</p>
	* Created on 2020年06月08日
	* @return Integer
    * @author:wangchun
    */
	public Integer getMailSend(){
		return mailSend;
	}
	/**
	* <p>Discription:[邮件是否发送 0：未发送 1：发送]</p>
	* Created on 2020年06月08日
	* @author:wangchun
	*/
	public void setMailSend(Integer mailSend){
		this.mailSend = mailSend;
	}
}
