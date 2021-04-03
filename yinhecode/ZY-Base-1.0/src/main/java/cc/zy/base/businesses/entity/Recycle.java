package cc.zy.base.businesses.entity;

import java.util.Date;

import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Entity
 *
 * @author LiPeng
 * @date 2021-01-27 19:13:18
 */
@Data
@TableName("t_recycle")
public class Recycle {

    /**
     * 主键 自增
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     *
     */
    @TableField("STU_ID")
    private Integer stuId;
    /**
     * 身份证号
     */
    @TableField("IDENTITY")
    private String identity;
    /**
     *  外键---层次
     */
    @TableField("LEVEL")
    private Integer level;
    @TableField("t_level")
    private String levelname;

    /**
     * 学号(院校分配)
     */
    @TableField("STU_NUM")
    private String stuNum;

    /**
     * 外键 字典表主键---院校
     */
    @TableField("COLLEGE_ID")
    private Integer collegeId;
    @TableField("COLLEGE_ID")
    private String name;

    @ExcelField(value = "院校名称")
    @TableField(exist = false)
    private String collegeName;

    /**
     * 外键 字典表主键---批次
     */
    @TableField("BATCH_ID")
    private Integer batchId;
    @TableField(exist = false)
    private String batchName;
    /**
     * 外键 字典表主键---专业
     */
    @TableField("MAJOR_ID")
    private Integer majorId;


    @TableField("major_ID")
    private String fullName;

    /**
     * 外键 字典表主键---学习形式（成教、网教、电大）
     */
    @TableField("STUDY_TYPE_ID")
    private Integer studyTypeId;

    /**
     * 外键 班级表	班级ID---参考班级表
     */
    @TableField("CLASS_ID")
    private String classId;
    @ExcelField(value = "班级名称")
    @TableField(exist = false)
    private String className;
    //@TableField("CLASS_ID")
    //private String username;

    /**
     * 姓名
     */
    @TableField("STU_NAME")
    private String stuName;

    /**
     * 外键 字典表主键---性别
     */
    @TableField("SEX_ID")
    private Integer sexId;

    /**
     * 外键	民族 引用外键
     */
    @TableField("NATION")
    private Integer nation;

    /**
     *
     */
    @TableField("NATIVE_CITY")
    private Integer nativeCity;

    /**
     *
     */
    @TableField("NATIVE_DISTRICT")
    private Integer nativeDistrict;

    /**
     *
     */
    @TableField("NATIVE_PROVINCE")
    private Integer nativeProvince;

    /**
     *
     */
    @TableField("POLITICS_ID")
    private Integer politicsId;

    /**
     *
     */
    @TableField("DIPLOMA_NUM")
    private String diplomaNum;

    /**
     *
     */
    @TableField("GRADU_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date graduDate;

    /**
     *
     */
    @TableField("ENROL_DATE")
    private Date enrolDate;

    /**
     * 手机号
     */
    @TableField("TEL")
    private String tel;

    /**
     *
     */
    @TableField("URGENCY_TEL")
    private String urgencyTel;

    /**
     *
     */
    @TableField("EMAIL")
    private String email;

    /**
     *
     */
    @TableField("ADDRESS")
    private String address;

    /**
     *
     */
    @TableField("EXAM_LOCATION_ID")
    private Integer examLocationId;

    /**
     *
     */
    @TableField("IDEN_BEGIN_DATE")
    private Date idenBeginDate;

    /**
     *
     */
    @TableField("IDEC_END_DATE")
    private Date idecEndDate;

    /**
     *
     */
    @TableField("WX_APP_OPENID")
    private Integer wxAppOpenid;

    /**
     *
     */
    @TableField("STATUS_ID")
    private Integer statusId;

    /**
     *
     */
    @TableField("STAGE_ID")
    private Integer stageId;

    /**
     *
     */
    @TableField("TRACSACTION")
    private Integer tracsaction;

    /**
     *
     */
    @TableField("ALLOW_ESSAY")
    private Integer allowEssay;

    /**
     *
     */
    @TableField("DIPLOMA_IMG_URL")
    private String diplomaImgUrl;

    /**
     *
     */
    @TableField("HEAD_IMG_URL")
    private String headImgUrl;

    /**
     *
     */
    @TableField("ID_FRONT_IMG_URL")
    private String idFrontImgUrl;

    /**
     *
     */
    @TableField("ID_BACK_IMG_URL")
    private String idBackImgUrl;

    /**
     *
     */
    @TableField("EXAM_STU_NUM")
    private String examStuNum;

    /**
     *
     */
    @TableField("EXAM_REGRIT_NUM")
    private String examRegritNum;
    @TableField(exist = false)
    private String nationName;

    @TableField(exist = false)
    private String nativeName;

    @TableField(exist = false)
    private String politicsName;

    /**
     *
     */
    @TableField(exist = false)
    private String majorName;

    /**
     *
     */
    @TableField(exist = false)
    private String studyTypeName;

    /**
     *
     */
    @TableField(exist = false)
    private String userId;

    /**
     *
     */
    @TableField(exist = false)
    private String userName;

}
