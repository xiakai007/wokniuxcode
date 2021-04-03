package cc.zy.base.businesses.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学籍进度
 * @author 赵佳伟
 * @date 2021/01/25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentProgress {

    /**
     * 学籍状态
     */
    private Integer stageId;

    /**
     * 异动类型
     */
    private Integer tracsaction;

    /**
     * 允许写论文状态id
     */
    private Integer allowEssay;

    /**
     * 字典表里的字段
     */
    private String detail;
}
