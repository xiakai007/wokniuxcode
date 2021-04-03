package com.isoftstone.humanresources.domain.gatherVo;

import com.isoftstone.humanresources.domain.gather.CommentModel;
import com.isoftstone.humanresources.domain.gather.ZanModel;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description: [知识管理表model]</p>
 * Created on 2020年05月29日
 * @author  <a href="mailto: chunwangi@isoftstone.com">wangchun</a>
 * @version 1.0 
 * Copyright (c) 2020年
 */
public class KmsVo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 主键
     */
	private Integer id;
	/**
     * 标题
     */
	private String subject;
	/**
     * 创建人
     */
	private Integer createbody;

	/**
	 * 创建人姓名
	 */
	private String createName;

	/**
	 * 创建人头像
	 */
	private String createImg;

	/**
     * 图片
     */
	private String imgs;
	/**
     * 状态/权限
     */
	private String status;
	/**
     * 知识类型
     */
	private String kmtype;
	/**
     * 创建时间
     */
	private String createtime;
	/**
     * 修改时间
     */
	private String updatetime;
	/**
     * 备注
     */
	private String bak;

	/**
	 * 评论
	 */
	private List<CommentModel> commentModelList;
	/**
	 * 点赞
	 */
	private List<ZanModel> zanModelList ;

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

	public String getCreateImg() {
		return createImg;
	}

	public void setCreateImg(String createImg) {
		this.createImg = createImg;
	}

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

	private List<String> imgList;

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
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
	* Created on 2020年05月29日
	* @return Integer
    * @author:wangchun
    */
	public Integer getId(){
		return id;
	}
	/**
	* <p>Discription:[主键]</p>
	* Created on 2020年05月29日
	* @author:wangchun
	*/
	public void setId(Integer id){
		this.id = id;
	}
	/**
	* <p>Discription:[标题]</p>
	* Created on 2020年05月29日
	* @return String
    * @author:wangchun
    */
	public String getSubject(){
		return subject;
	}
	/**
	* <p>Discription:[标题]</p>
	* Created on 2020年05月29日
	* @author:wangchun
	*/
	public void setSubject(String subject){
		this.subject = subject;
	}
	/**
	* <p>Discription:[创建人]</p>
	* Created on 2020年05月29日
	* @return Integer
    * @author:wangchun
    */
	public Integer getCreatebody(){
		return createbody;
	}
	/**
	* <p>Discription:[创建人]</p>
	* Created on 2020年05月29日
	* @author:wangchun
	*/
	public void setCreatebody(Integer createbody){
		this.createbody = createbody;
	}
	/**
	* <p>Discription:[图片]</p>
	* Created on 2020年05月29日
	* @return String
    * @author:wangchun
    */
	public String getImgs(){
		return imgs;
	}
	/**
	* <p>Discription:[图片]</p>
	* Created on 2020年05月29日
	* @author:wangchun
	*/
	public void setImgs(String imgs){
		this.imgs = imgs;
	}
	/**
	* <p>Discription:[状态/权限]</p>
	* Created on 2020年05月29日
	* @return String
    * @author:wangchun
    */
	public String getStatus(){
		return status;
	}
	/**
	* <p>Discription:[状态/权限]</p>
	* Created on 2020年05月29日
	* @author:wangchun
	*/
	public void setStatus(String status){
		this.status = status;
	}
	/**
	* <p>Discription:[知识类型]</p>
	* Created on 2020年05月29日
	* @return String
    * @author:wangchun
    */
	public String getKmtype(){
		return kmtype;
	}
	/**
	* <p>Discription:[知识类型]</p>
	* Created on 2020年05月29日
	* @author:wangchun
	*/
	public void setKmtype(String kmtype){
		this.kmtype = kmtype;
	}
	/**
	* <p>Discription:[创建时间]</p>
	* Created on 2020年05月29日
	* @return String
    * @author:wangchun
    */
	public String getCreatetime(){
		return createtime;
	}
	/**
	* <p>Discription:[创建时间]</p>
	* Created on 2020年05月29日
	* @author:wangchun
	*/
	public void setCreatetime(String createtime){
		this.createtime = createtime;
	}
	/**
	* <p>Discription:[修改时间]</p>
	* Created on 2020年05月29日
	* @return String
    * @author:wangchun
    */
	public String getUpdatetime(){
		return updatetime;
	}
	/**
	* <p>Discription:[修改时间]</p>
	* Created on 2020年05月29日
	* @author:wangchun
	*/
	public void setUpdatetime(String updatetime){
		this.updatetime = updatetime;
	}
	/**
	* <p>Discription:[备注]</p>
	* Created on 2020年05月29日
	* @return String
    * @author:wangchun
    */
	public String getBak(){
		return bak;
	}
	/**
	* <p>Discription:[备注]</p>
	* Created on 2020年05月29日
	* @author:wangchun
	*/
	public void setBak(String bak){
		this.bak = bak;
	}
}
