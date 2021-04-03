package com.isoftstone.humanresources.domain.gatherVo;

import com.isoftstone.humanresources.domain.gather.CommentModel;
import com.isoftstone.humanresources.domain.gather.ZanModel;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description: [活动风采表model]</p>
 * Created on 2020年05月25日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public class GroupActivitiesVo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 主键
     */
	private Integer id;
	/**
     * 时间
     */
	private String time;
	/**
     * 地点
     */
	private String address;
	/**
     * 主题
     */
	private String subject;
	/**
     * 参与人
     */
	private String mans;
	/**
     * 创建人
     */
	private String createbody;
	/**
	 * 创建人姓名
	 */
	private String createName ;
	/**
	 * 创建人头像
	 */
	private String createImg;
	/**
	 * PDU
	 */
	private String pdu;

	/**
	 * 创建人
	 */
	private String project;

	/**
	 * 创建人
	 */
	private String leader;

	/**
     * 活动照片
     */
	private String imgs;
	/**
	 * 照片列表
	 */
	private List<String> imgList;
	/**
     * 状态/权限
     */
	private String status;
	/**
     * 创建时间
     */
	private String createtime;
	/**
     * 更新时间
     */
	private String updatetime;
	/**
     * 备份
     */
	private String bak;
	/**
	 *  是否审批通过
	 */
	private  String approved;
	/**
	 *  审批人
	 */
	private Integer approveduser ;

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public Integer getApproveduser() {
		return approveduser;
	}

	public void setApproveduser(Integer approveduser) {
		this.approveduser = approveduser;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public String getCreateImg() {
		return createImg;
	}

	public void setCreateImg(String createImg) {
		this.createImg = createImg;
	}

	/**
	 * 评论
	 */
	private List<CommentModel> commentModelList;
	/**
	 * 点赞
	 */
	private List<ZanModel> zanModelList ;

	public List<CommentModel> getCommentModelList() {
		return commentModelList;
	}

	public void setCommentModelList(List<CommentModel> commentModelList) {
		this.commentModelList = commentModelList;
	}

	public List<ZanModel> getZanModelList() {
		return zanModelList;
	}

	public void setZanModelList(List<ZanModel> zanModelList) {
		this.zanModelList = zanModelList;
	}

	public List<String> getImgList() {
		return imgList;
	}

	public void setImgList(List<String> imgList) {
		this.imgList = imgList;
	}

	// setter and getter
	/**
	* <p>Discription:[主键]</p>
	* Created on 2020年05月25日
	* @return Integer
    * @author:wangchun
    */
	public Integer getId(){
		return id;
	}
	/**
	* <p>Discription:[主键]</p>
	* Created on 2020年05月25日
	* @author:wangchun
	*/
	public void setId(Integer id){
		this.id = id;
	}
	/**
	* <p>Discription:[时间]</p>
	* Created on 2020年05月25日
	* @return String
    * @author:wangchun
    */
	public String getTime(){
		return time;
	}
	/**
	* <p>Discription:[时间]</p>
	* Created on 2020年05月25日
	* @author:wangchun
	*/
	public void setTime(String time){
		this.time = time;
	}
	/**
	* <p>Discription:[地点]</p>
	* Created on 2020年05月25日
	* @return String
    * @author:wangchun
    */
	public String getAddress(){
		return address;
	}
	/**
	* <p>Discription:[地点]</p>
	* Created on 2020年05月25日
	* @author:wangchun
	*/
	public void setAddress(String address){
		this.address = address;
	}
	/**
	* <p>Discription:[主题]</p>
	* Created on 2020年05月25日
	* @return String
    * @author:wangchun
    */
	public String getSubject(){
		return subject;
	}
	/**
	* <p>Discription:[主题]</p>
	* Created on 2020年05月25日
	* @author:wangchun
	*/
	public void setSubject(String subject){
		this.subject = subject;
	}
	/**
	* <p>Discription:[参与人]</p>
	* Created on 2020年05月25日
	* @return String
    * @author:wangchun
    */
	public String getMans(){
		return mans;
	}
	/**
	* <p>Discription:[参与人]</p>
	* Created on 2020年05月25日
	* @author:wangchun
	*/
	public void setMans(String mans){
		this.mans = mans;
	}
	/**
	* <p>Discription:[创建人]</p>
	* Created on 2020年05月25日
	* @return String
    * @author:wangchun
    */
	public String getCreatebody(){
		return createbody;
	}
	/**
	* <p>Discription:[创建人]</p>
	* Created on 2020年05月25日
	* @author:wangchun
	*/
	public void setCreatebody(String createbody){
		this.createbody = createbody;
	}
	/**
	* <p>Discription:[活动照片]</p>
	* Created on 2020年05月25日
	* @return String
    * @author:wangchun
    */
	public String getImgs(){
		return imgs;
	}
	/**
	* <p>Discription:[活动照片]</p>
	* Created on 2020年05月25日
	* @author:wangchun
	*/
	public void setImgs(String imgs){
		this.imgs = imgs;
	}
	/**
	* <p>Discription:[状态/权限]</p>
	* Created on 2020年05月25日
	* @return String
    * @author:wangchun
    */
	public String getStatus(){
		return status;
	}
	/**
	* <p>Discription:[状态/权限]</p>
	* Created on 2020年05月25日
	* @author:wangchun
	*/
	public void setStatus(String status){
		this.status = status;
	}
	/**
	* <p>Discription:[创建时间]</p>
	* Created on 2020年05月25日
	* @return String
    * @author:wangchun
    */
	public String getCreatetime(){
		return createtime;
	}
	/**
	* <p>Discription:[创建时间]</p>
	* Created on 2020年05月25日
	* @author:wangchun
	*/
	public void setCreatetime(String createtime){
		this.createtime = createtime;
	}
	/**
	* <p>Discription:[更新时间]</p>
	* Created on 2020年05月25日
	* @return String
    * @author:wangchun
    */
	public String getUpdatetime(){
		return updatetime;
	}
	/**
	* <p>Discription:[更新时间]</p>
	* Created on 2020年05月25日
	* @author:wangchun
	*/
	public void setUpdatetime(String updatetime){
		this.updatetime = updatetime;
	}
	/**
	* <p>Discription:[备份]</p>
	* Created on 2020年05月25日
	* @return String
    * @author:wangchun
    */
	public String getBak(){
		return bak;
	}
	/**
	* <p>Discription:[备份]</p>
	* Created on 2020年05月25日
	* @author:wangchun
	*/
	public void setBak(String bak){
		this.bak = bak;
	}

	public String getPdu() {
		return pdu;
	}

	public void setPdu(String pdu) {
		this.pdu = pdu;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}
}
