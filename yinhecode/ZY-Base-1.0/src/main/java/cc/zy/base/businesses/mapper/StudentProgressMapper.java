package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.Province;
import cc.zy.base.businesses.entity.StudentProgress;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 学籍进度
 * @author 赵佳伟
 * @date 2021/01/27
 */
public interface StudentProgressMapper extends BaseMapper<Province> {

    /**
     * 根据学生id查询学籍、异动、写论文的状态
     * @param id
     * @return
     */
    StudentProgress findStatusBySid(@Param("id") Integer id);

    /**
     * 根据状态id查询字典表里的具体内容
     */
    String findStatusNameById(@Param("id") Integer id);
}
