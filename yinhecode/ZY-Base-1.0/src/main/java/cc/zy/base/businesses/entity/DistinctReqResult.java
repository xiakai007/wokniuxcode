package cc.zy.base.businesses.entity;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *  Entity
 *
 * @author Jiangjinlin
 * @date 2021-01-25 16:04:23
 */
@Data
@TableName("t_distinct_req_result")
public class DistinctReqResult {

    /**
     * 
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableField("REQ_INFO_ID")
    private Integer reqInfoId;

    /**
     * 
     */
    @TableField("FOLLOW_USER_ID")
    private Integer followUserId;

    /**
     * 
     */
    @TableField("GROUP_ID")
    private Integer groupId;

    /**
     * 
     */
    @TableField("NAME")
    private String name;

    /**
     * 
     */
    @TableField("EC_CALL")
    private String ecCall;

    /**
     * 
     */
    @TableField("GENDER")
    private String gender;

    /**
     * 
     */
    @TableField("BIRTHDAY")
    private Date birthday;

    /**
     * 
     */
    @TableField("IS_LUNAR_BIRTHDAY")
    private Integer isLunarBirthday;

    /**
     * 
     */
    @TableField("TITLE")
    private String title;

    /**
     * 
     */
    @TableField("QQ")
    private String qq;

    /**
     * 
     */
    @TableField("MOBILE")
    private String mobile;

    /**
     * 
     */
    @TableField("PHONE")
    private String phone;

    /**
     * 
     */
    @TableField("FAX")
    private String fax;

    /**
     * 
     */
    @TableField("EMAIL")
    private String email;

    /**
     * 
     */
    @TableField("COMPANY")
    private String company;

    /**
     * 
     */
    @TableField("COMPANY_URL")
    private String companyUrl;

    /**
     * 
     */
    @TableField("COMPANY_ADDRESS")
    private String companyAddress;

    /**
     * 
     */
    @TableField("MEMO")
    private String memo;

    /**
     * 
     */
    @TableField("VOCATION")
    private String vocation;

    /**
     * 
     */
    @TableField("CHANNEL")
    private String channel;

    /**
     * 
     */
    @TableField("PREFECTURE")
    private String prefecture;

    /**
     * 
     */
    @TableField("FIELD_INFOS")
    private String fieldInfos;

    /**
     * 
     */
    @TableField("CRM_ID")
    private Integer crmId;

    /**
     * 
     */
    @TableField("MODIFY_TIME")
    private Date modifyTime;

    /**
     * 
     */
    @TableField("CONTACT_TIME")
    private Date contactTime;

    /**
     * 
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 
     */
    @TableField("LAST_FOLLOW_USER_ID")
    private Integer lastFollowUserId;

    /**
     * 
     */
    @TableField("STEP")
    private Integer step;

}
