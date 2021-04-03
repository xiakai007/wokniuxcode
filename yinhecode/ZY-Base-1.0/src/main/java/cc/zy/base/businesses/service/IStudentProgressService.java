package cc.zy.base.businesses.service;

import cc.zy.base.businesses.entity.StudentProgress;

import java.util.Map;


/**
 * 学籍进度
 * @author zhaojw
 * @date 2021/01/28
 */

public interface IStudentProgressService {

    /**
     * 查询学籍进度
     */
    Map<String,String> calculateProgress(Integer id);


}
