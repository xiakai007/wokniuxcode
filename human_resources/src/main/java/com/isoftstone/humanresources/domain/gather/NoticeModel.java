package com.isoftstone.humanresources.domain.gather;

import java.io.Serializable;
/** 
 * <p>Description: [消息通知表model]</p>
 * Created on 2020年06月08日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public class NoticeModel  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 
     */
	private Integer id;
	/**
     * 发布时间
     */
	private String createDate;
	/**
     * 通知标题
     */
	private String noticeTitle;
	/**
     * 通知体
     */
	private String noticeBody;
	/**
     * 发布人
     */
	private String pushUser;
	/**
     * 通知对象
     */
	private String noticeObj;
	/**
     * 通知状态 0：开 1：关
     */
	private String noticeStatus;
	/**
     * 通知类型
     */
	private String noticeType;
	/**
     * 通知图片
     */
	private String img;
	/**
     * 备份
     */
	private String bak;
	
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
	* <p>Discription:[发布时间]</p>
	* Created on 2020年06月08日
	* @return String
    * @author:wangchun
    */
	public String getCreateDate(){
		return createDate;
	}
	/**
	* <p>Discription:[发布时间]</p>
	* Created on 2020年06月08日
	* @author:wangchun
	*/
	public void setCreateDate(String createDate){
		this.createDate = createDate;
	}
	/**
	* <p>Discription:[通知标题]</p>
	* Created on 2020年06月08日
	* @return String
    * @author:wangchun
    */
	public String getNoticeTitle(){
		return noticeTitle;
	}
	/**
	* <p>Discription:[通知标题]</p>
	* Created on 2020年06月08日
	* @author:wangchun
	*/
	public void setNoticeTitle(String noticeTitle){
		this.noticeTitle = noticeTitle;
	}
	/**
	* <p>Discription:[通知体]</p>
	* Created on 2020年06月08日
	* @return String
    * @author:wangchun
    */
	public String getNoticeBody(){
		return noticeBody;
	}
	/**
	* <p>Discription:[通知体]</p>
	* Created on 2020年06月08日
	* @author:wangchun
	*/
	public void setNoticeBody(String noticeBody){
		this.noticeBody = noticeBody;
	}
	/**
	* <p>Discription:[发布人]</p>
	* Created on 2020年06月08日
	* @return String
    * @author:wangchun
    */
	public String getPushUser(){
		return pushUser;
	}
	/**
	* <p>Discription:[发布人]</p>
	* Created on 2020年06月08日
	* @author:wangchun
	*/
	public void setPushUser(String pushUser){
		this.pushUser = pushUser;
	}
	/**
	* <p>Discription:[通知对象]</p>
	* Created on 2020年06月08日
	* @return String
    * @author:wangchun
    */
	public String getNoticeObj(){
		return noticeObj;
	}
	/**
	* <p>Discription:[通知对象]</p>
	* Created on 2020年06月08日
	* @author:wangchun
	*/
	public void setNoticeObj(String noticeObj){
		this.noticeObj = noticeObj;
	}
	/**
	* <p>Discription:[通知状态 0：开 1：关]</p>
	* Created on 2020年06月08日
	* @return String
    * @author:wangchun
    */
	public String getNoticeStatus(){
		return noticeStatus;
	}
	/**
	* <p>Discription:[通知状态 0：开 1：关]</p>
	* Created on 2020年06月08日
	* @author:wangchun
	*/
	public void setNoticeStatus(String noticeStatus){
		this.noticeStatus = noticeStatus;
	}
	/**
	* <p>Discription:[通知类型]</p>
	* Created on 2020年06月08日
	* @return String
    * @author:wangchun
    */
	public String getNoticeType(){
		return noticeType;
	}
	/**
	* <p>Discription:[通知类型]</p>
	* Created on 2020年06月08日
	* @author:wangchun
	*/
	public void setNoticeType(String noticeType){
		this.noticeType = noticeType;
	}
	/**
	* <p>Discription:[通知图片]</p>
	* Created on 2020年06月08日
	* @return String
    * @author:wangchun
    */
	public String getImg(){
		return img;
	}
	/**
	* <p>Discription:[通知图片]</p>
	* Created on 2020年06月08日
	* @author:wangchun
	*/
	public void setImg(String img){
		this.img = img;
	}
	/**
	* <p>Discription:[备份]</p>
	* Created on 2020年06月08日
	* @return String
    * @author:wangchun
    */
	public String getBak(){
		return bak;
	}
	/**
	* <p>Discription:[备份]</p>
	* Created on 2020年06月08日
	* @author:wangchun
	*/
	public void setBak(String bak){
		this.bak = bak;
	}
}
