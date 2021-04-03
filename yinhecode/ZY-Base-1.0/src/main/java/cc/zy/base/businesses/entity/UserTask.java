package cc.zy.base.businesses.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *  存储招生老师需要处理的待办任务
 *
 * @author 刘润雨
 * @date 2021-01-28 17:29:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("招生老师待办任务")
public class UserTask {
    @ApiModelProperty("学生id")
    private Integer stuId;

    @ApiModelProperty("学生姓名")
    private String stuName;

    @ApiModelProperty("组名称")
    private String groupNo;

    @ApiModelProperty("组ID")
    private Integer groupId;

    @ApiModelProperty("招生人员id")
    private Integer userId;

    @ApiModelProperty("招生人员待办任务")
    private Integer taskNum;
}
