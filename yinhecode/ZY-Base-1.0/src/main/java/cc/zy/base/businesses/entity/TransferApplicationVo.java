package cc.zy.base.businesses.entity;


import cc.zy.base.common.converter.TimeConverter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 学籍异动申请表查询返回 Entity
 *
 * @author liuheng
 * @date 2021/01/25
 */
@Data
@Excel("异动信息表")
public class TransferApplicationVo {

    /**
     *异动编号
     */
    @ExcelField(value = "编号")
    private Integer id;

    /**
     * 批次名称
     */
    @ExcelField(value = "批次")
    private String batchName;

    /**
     * 院校简称
     */
    @ExcelField(value = "院校")
    private String collegeSimpleName;

    /**
     * 层次名称
     */
    @ExcelField(value = "层次")
    private String levelName;

    /**
     * 专业简称
     */
    @ExcelField(value = "专业")
    private String majorSimpleName;

    /**
     * 姓名
     */
    @ExcelField(value = "姓名")
    private String stuName;

    /**
     * 身份证号
     */
    @ExcelField(value = "身份证号")
    private String identity;

    /**
     * 手机号
     */
    @ExcelField(value = "手机号")
    private String tel;

    /**
     * 学号
     */
    @ExcelField(value = "学号")
    private String stuNum;

    /**
     * 学籍异动类型
     */
    @ExcelField(value = "异动类型")
    private String transferType;

    /**
     * 申请时间
     */
    @ExcelField(value = "申请时间", writeConverter = TimeConverter.class)
    private Date applicationTime;

    /**
     * 异动申请原因
     */
    @ExcelField(value = "申请原因")
    private String applicationReason;

    /**
     * 其他原因的补充说明
     */
    @ExcelField(value = "其他原因")
    private String otherReason;

    /**
     * 审批状态
     */
    @ExcelField(value = "审批状态")
    private String approvalStatus;

    /**
     * 审批时间
     */
    @ExcelField(value = "审批时间", writeConverter = TimeConverter.class)
    private Date approvalTime;

    /**
     * 审批意见
     */
    @ExcelField(value = "审批意见")
    private String opinion;

    /**
     * 班主任姓名
     */
    @ExcelField(value = "班主任姓名")
    private String userName;

    /**
     * 休学年限
     */
    @ExcelField(value = "休学年限")
    private Integer yearLimit;

    /**
     * 复学后新批次名称
     */
    @ExcelField(value = "复学批次")
    private String newBatchName;

    /**
     * 更换的新学习形式名称
     */
    @ExcelField(value = "新学习形式名称")
    private String newStudyTypeName;

    /**
     * 更换的新专业名称
     */
    @ExcelField(value = "新专业名称")
    private String newMajorName;

    /**
     * 班主任id
     */
    private Long userId;

    /**
     * 学生id
     */
    private Integer stuId;

    /**
     * 学籍异动类型id
     */
    private Integer transferTypeId;

    /**
     * 审批状态id
     */
    private Integer approvalStatusId;

    /**
     * 异动申请原因id
     */
    private Integer applicationReasonId;

    /**
     * 附件列表
     */
    private List<String> attachmentList;

    /**
     *层次id
     */
    private Integer level;

    /**
     *院校id
     */
    private Integer collegeId;

    /**
     *批次id
     */
    private Integer batchId;

    /**
     *专业id
     */
    private Integer majorId;

    /**
     *学习形式id
     */
    private Integer studyTypeId;

    /**
     * 学习形式
     */
    private String studyType;

    /**
     *班级id
     */
    private String classId;

    /**
     *性别id
     */
    private Integer sexId;

    /**
     *民族
     */
    private String nation;

    /**
     *出生地
     */
    private Integer nativeCity;

    /**
     *
     */
    private Integer nativeDistrict;

    /**
     *
     */
    private Integer nativeProvince;

    /**
     *
     */
    private Integer politicsId;

    /**
     *
     */
    private String diplomaNum;

    /**
     *毕业时间
     */
    private Date graduDate;

    /**
     *入学时间
     */
    private Date enrolDate;

    /**
     *紧急联系人电话
     */
    private String urgencyTel;

    /**
     *邮箱
     */
    private String email;

    /**
     *地址
     */
    private String address;

    /**
     *考试地点id
     */
    private Integer examLocationId;

    /**
     *身份证起效时间
     */
    private Date idenBeginDate;

    /**
     *身份证失效时间
     */
    private Date idecEndDate;

    /**
     *
     */
    private Integer wxAppOpenid;

    /**
     *
     */
    private Integer statusId;

    /**
     *
     */
    private Integer stageId;

    /**
     *
     */
    private Integer tracsaction;

    /**
     *
     */
    private Integer allowEssay;

    /**
     *
     */
    private String diplomaImgUrl;

    /**
     *
     */
    private String headImgUrl;

    /**
     *
     */
    private String idFrontImgUrl;

    /**
     *
     */
    private String idBackImgUrl;

    /**
     *
     */
    private String examStuNum;

    /**
     *
     */
    private String examRegritNum;


}
