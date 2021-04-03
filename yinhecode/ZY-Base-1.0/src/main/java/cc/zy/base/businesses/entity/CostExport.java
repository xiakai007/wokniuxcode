package cc.zy.base.businesses.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 该类主要cost.html客户选择条件的封装
 *
 * @author guozhaodi
 * @date 2021-02-04 11:45:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CostExport {

    /**
     * 批次id
     */
    private Integer batchId;

    /**
     * 院校id
     */
    private Integer collegeId;

    /**
     * 层次id
     */
    private Integer levelId;
    /**
     * 类别id
     */
    private Integer subjectCategoryId;

    /**
     * 专业id
     */
    private Integer majorId;

    /**
     * 付费查询开始时间
     */
    private String startdate;

    /**
     * 付费查询结束时间
     */
    private String enddate;


}



