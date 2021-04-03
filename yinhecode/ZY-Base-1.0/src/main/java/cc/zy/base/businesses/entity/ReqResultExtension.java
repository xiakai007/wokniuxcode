package cc.zy.base.businesses.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Entity
 *
 * @author LiXu
 * @date 2021/01/30
 */
@Data
@TableName("t_req_result_extension")
public class ReqResultExtension {

    /**
     *
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 返回结果表ID
     */
    @TableField("REQ_INFO_ID")
    private Integer reqInfoId;

    /**
     * 返回结果解析表ID
     */
    @TableField("REQ_RESULT_ID")
    private Long reqResultId;

    /**
     *
     */
    @TableField("IDENTITY")
    private String identity;

    /**
     * 层次ID
     */
    @TableField("LEVEL")
    private Integer level;

    /**
     * 学号(院校分配)
     */
    @TableField("STU_NUM")
    private String stuNum;

    /**
     * 院校ID
     */
    @TableField("COLLEGE_ID")
    private Integer collegeId;

    /**
     * 批次ID
     */
    @TableField("BATCH_ID")
    private Integer batchId;

    /**
     * 专业ID
     */
    @TableField("MAJOR_ID")
    private Integer majorId;

    /**
     * 学习形式（成教、网教、电大）
     */
    @TableField("STUDY_TYPE_ID")
    private Integer studyTypeId;

    /**
     * 班级ID 参考班级表
     */
    @TableField("CLASS_ID")
    private String classId;

    /**
     * 姓名
     */
    @TableField("STU_NAME")
    private String stuName;

    /**
     * 性别
     */
    @TableField("SEX_ID")
    private Integer sexId;

    /**
     * 民族 引用外键
     */
    @TableField("NATION")
    private Integer nation;

    /**
     * 籍贯 市
     */
    @TableField("NATIVE_CITY")
    private Integer nativeCity;

    /**
     * 籍贯 区县
     */
    @TableField("NATIVE_DISTRICT")
    private Integer nativeDistrict;

    /**
     * 籍贯 省
     */
    @TableField("NATIVE_PROVINCE")
    private Integer nativeProvince;

    /**
     * 政治面貌（群众、中共党员、其他党派）
     */
    @TableField("POLITICS_ID")
    private Integer politicsId;

    /**
     * 毕业证号
     */
    @TableField("DIPLOMA_NUM")
    private String diplomaNum;

    /**
     * 毕业日期
     */
    @TableField("GRADU_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date graduDate;

    /**
     * 入学日期
     */
    @TableField("ENROL_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date enrolDate;

    /**
     * 手机号
     */
    @TableField("TEL")
    private String tel;

    /**
     * 紧急联系手机号
     */
    @TableField("URGENCY_TEL")
    private String urgencyTel;

    /**
     * EMAIL
     */
    @TableField("EMAIL")
    private String email;

    /**
     * 现住地
     */
    @TableField("ADDRESS")
    private String address;

    /**
     * 现场确认地
     */
    @TableField("EXAM_LOCATION_ID")
    private Integer examLocationId;

    /**
     * 身份证起始日期
     */
    @TableField("IDEN_BEGIN_DATE")
    private Date idenBeginDate;

    /**
     * 身份证失效日期
     */
    @TableField("IDEC_END_DATE")
    private Date idecEndDate;

    /**
     * 关联微信小程序的ID
     */
    @TableField("WX_APP_OPENID")
    private Integer wxAppOpenid;

    /**
     * 是否移入回收站 0是 1否
     */
    @TableField("STATUS_ID")
    private Integer statusId;

    /**
     * 学籍状态（考前、在籍）
     */
    @TableField("STAGE_ID")
    private Integer stageId;

    /**
     * 异动类型 类型ID
     */
    @TableField("TRACSACTION")
    private Integer tracsaction;

    /**
     * 允许论文写作 字典表52允许 53不允许
     */
    @TableField("ALLOW_ESSAY")
    private Integer allowEssay;

    /**
     * 毕业证照片 阿里云文件服务器地址
     */
    @TableField("DIPLOMA_IMG_URL")
    private String diplomaImgUrl;

    /**
     * 头像照片 阿里云文件服务器地址
     */
    @TableField("HEAD_IMG_URL")
    private String headImgUrl;

    /**
     * 身份证正面照片 阿里云文件服务器地址
     */
    @TableField("ID_FRONT_IMG_URL")
    private String idFrontImgUrl;

    /**
     * 身份证背面照片 阿里云文件服务器地址
     */
    @TableField("ID_BACK_IMG_URL")
    private String idBackImgUrl;

    /**
     * 考生号
     */
    @TableField("EXAM_STU_NUM")
    private String examStuNum;

    /**
     * 准考证号
     */
    @TableField("EXAM_REGRIT_NUM")
    private String examRegritNum;

    /**
     *
     */
    @TableField("EX1")
    private String ex1;

    /**
     *
     */
    @TableField("EX2")
    private String ex2;

    /**
     *
     */
    @TableField("EX3")
    private String ex3;

    /**
     *
     */
    @TableField("EX4")
    private String ex4;

    /**
     *
     */
    @TableField("EX5")
    private String ex5;

    /**
     *
     */
    @TableField("EX6")
    private String ex6;

    /**
     *
     */
    @TableField("EX7")
    private String ex7;

    /**
     *
     */
    @TableField("EX8")
    private String ex8;

    /**
     *
     */
    @TableField("EX9")
    private String ex9;

    /**
     *
     */
    @TableField("EX10")
    private String ex10;

    /**
     * 批次名称
     */
    @TableField(exist = false)
    private String batchName;

    /**
     * 院校名称
     */
    @TableField(exist = false)
    private String collegeName;

    /**
     * 层次名称
     */
    @TableField(exist = false)
    private String levelName;

    /**
     * 专业名称
     */
    @TableField(exist = false)
    private String majorName;

    /**
     * 学习形式名称
     */
    @TableField(exist = false)
    private String studyTypeName;

    /**
     * 招生老师id
     */
    @TableField(exist = false)
    private Long userId;

    /**
     * 招生老师
     */
    @TableField(exist = false)
    private String userName;

    /**
     * 学生组id
     */
    @TableField(exist = false)
    private String groupId;

    /**
     * 学生组名
     */
    @TableField(exist = false)
    private String groupNo;

    /**
     * 民族名称
     */
    @TableField(exist = false)
    private String nationName;

    /**
     * 籍贯
     */
    @TableField(exist = false)
    private String nativeName;

    /**
     * 政治面貌
     */
    @TableField(exist = false)
    private String politicsName;

}
