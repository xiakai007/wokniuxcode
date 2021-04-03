package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.EntranceScore;
import cc.zy.base.businesses.entity.TestSubject;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestSubjectMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(TestSubject record);

    int insertSelective(TestSubject record);


    TestSubject selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(TestSubject record);

    int updateByPrimaryKey(TestSubject record);

    List<TestSubject> getSubjestsById(@Param("levelId") Integer levelId, @Param("subtypeId") Integer subtypeId);

    List<EntranceScore> getSubjectsAliasAndNum(@Param("levelName")String levelName, @Param("subtypeName")String subtypeName);

    List<EntranceScore> getEntranceIds(@Param("levelName")String levelName, @Param("subtypeName")String subtypeName,@Param("batchName")String batchName);
}