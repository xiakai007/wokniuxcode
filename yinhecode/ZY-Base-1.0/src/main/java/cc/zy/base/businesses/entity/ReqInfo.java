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
 * @author peihaodong
 * @date 2021/01/25
 * */
@Data
@TableName("t_req_info")
public class ReqInfo {

    /**
     * 
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableField("URL")
    private String url;

    /**
     * 
     */
    @TableField("REQ_TIME")
    private Date reqTime;

    /**
     * 
     */
    @TableField("REQ_USER_ID")
    private Long reqUserId;

    /**
     * 
     */
    @TableField("RESP_STATUS_CODE")
    private Integer respStatusCode;

    /**
     * 
     */
    @TableField("RESP_STATUS_INFO")
    private String respStatusInfo;

    /**
     * 
     */
    @TableField("RESULT_COUNT")
    private Integer resultCount;

    /**
     * 
     */
    @TableField("RESOLVE_SUCCESS")
    private Integer resolveSuccess;

    /**
     * 
     */
    @TableField("TRIGGER_TYPE")
    private Integer triggerType;

    /**
     * 
     */
    @TableField("FILE_PATH")
    private String filePath;

    /**
     * 
     */
    @TableField("STATUS")
    private Integer status;

    /**
     * 
     */
    @TableField("RESULT_DATA")
    private String resultData;




    /*
    * 关联表字段
    * */
    //触发类型
    @TableField(exist = false)
    private String triggerTypeName;
    //请求人
    @TableField(exist = false)
    private String reqUserName;

}
