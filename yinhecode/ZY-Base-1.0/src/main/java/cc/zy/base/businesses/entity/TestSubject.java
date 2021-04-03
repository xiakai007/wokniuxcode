package cc.zy.base.businesses.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * t_test_subject
 * @author wangpin
 * @date 2021/02/01
 */
@Data
public class TestSubject implements Serializable {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 科目名
     */
    private String subject;
    /**
     * 科目别名
     */
    private String alias;

    private static final long serialVersionUID = 1L;
}