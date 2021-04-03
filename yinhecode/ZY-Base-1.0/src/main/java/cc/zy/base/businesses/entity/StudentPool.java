package cc.zy.base.businesses.entity;

import java.io.Serializable;
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
 * @date 2021-01-26 10:29:14
 */
@Data
@TableName("t_student_pool")
public class StudentPool implements Serializable, Cloneable{


    /**
     *
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private String id;

    /**
     * 
     */
    @TableId(value = "ID_CARD", type = IdType.AUTO)
    private String idCard;

    /**
     * 
     */
    @TableId(value = "BATCH", type = IdType.AUTO)
    private Integer batch;

    /**
     * 
     */
    @TableId(value = "STUDY_MODE", type = IdType.AUTO)
    private Integer studyMode;

    /**
     * 
     */
    @TableField("REQ_EXTENSION_ID")
    private Integer reqExtensionId;

    /**
     * 
     */
    @TableField("DISTINCT_REQ_ID")
    private Integer distinctReqId;

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
    private Integer gender;

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
    private Integer channel;

    /**
     * 
     */
    @TableField("PREFECTURE")
    private String prefecture;

    /**
     * 自定义字段
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
    @TableField("CONTAC_TTIME")
    private Date contacTtime;

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

    /**
     *
     */
    @TableField("OPEN_ID")
    private String openId;

    /**
     *
     */
    @TableField("NICK_NAME")
    private String nickName;

    /**
     *
     */
    @TableField("UNION_ID")
    private String unionId;


}
