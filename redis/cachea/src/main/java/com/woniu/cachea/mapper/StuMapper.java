package com.woniu.cachea.mapper;

import com.woniu.cachea.entity.Stu;
import com.woniu.cachea.entity.StuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stu
     *
     * @mbggenerated Thu Dec 24 23:44:47 CST 2020
     */
    int countByExample(StuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stu
     *
     * @mbggenerated Thu Dec 24 23:44:47 CST 2020
     */
    int deleteByExample(StuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stu
     *
     * @mbggenerated Thu Dec 24 23:44:47 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stu
     *
     * @mbggenerated Thu Dec 24 23:44:47 CST 2020
     */
    int insert(Stu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stu
     *
     * @mbggenerated Thu Dec 24 23:44:47 CST 2020
     */
    int insertSelective(Stu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stu
     *
     * @mbggenerated Thu Dec 24 23:44:47 CST 2020
     */
    List<Stu> selectByExample(StuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stu
     *
     * @mbggenerated Thu Dec 24 23:44:48 CST 2020
     */
    Stu selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stu
     *
     * @mbggenerated Thu Dec 24 23:44:48 CST 2020
     */
    int updateByExampleSelective(@Param("record") Stu record, @Param("example") StuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stu
     *
     * @mbggenerated Thu Dec 24 23:44:48 CST 2020
     */
    int updateByExample(@Param("record") Stu record, @Param("example") StuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stu
     *
     * @mbggenerated Thu Dec 24 23:44:48 CST 2020
     */
    int updateByPrimaryKeySelective(Stu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table stu
     *
     * @mbggenerated Thu Dec 24 23:44:48 CST 2020
     */
    int updateByPrimaryKey(Stu record);
}