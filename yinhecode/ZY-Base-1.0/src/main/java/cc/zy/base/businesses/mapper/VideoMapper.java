package cc.zy.base.businesses.mapper;

import cc.zy.base.businesses.entity.Video;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 *  Mapper
 *
 * @author 夏凯
 * @date 2021-01-25 11:03:36
 */
public interface VideoMapper extends BaseMapper<Video> {
 int updateByIdSatus(@Param("id") int id, @Param("updateTime") Date updateTime, @Param("updateUserId")int updateUserId);
 Integer selectBySort( @Param("sort") Integer  sort);

 int updateByIdSortAB(@Param("id") int id,@Param("sort") Integer  sort);
 <T>IPage<Video> findVideo(Page<T> page, @Param("video") Video video);
 <T>IPage<Video> findVideoDetailPage(Page<T> page, @Param("video") Video video);
 long countVideoDetail(@Param("video") Video video);
 Video findById(@Param("id") Integer id);
 int updateByIdSatusUp(@Param("id") Integer id, @Param("updateTime") Date updateTime, @Param("updateUserId")int updateUserId);
 Integer selectByIdSort(@Param("id") Integer  id);;
 int findTypeIdByVid(@Param("id") Integer id);
 int findCourseIdByVid(@Param("id") Integer id);
 //新建视频，视频-课程-中间表增加一条记录
 int insertVideoCourse(@Param("courseId") Integer courseId,@Param("videoId")Integer videoId);
 //新建视频，视频-视频分类-中间表增加一条记录
 int insertVideoType(@Param("videoId")Integer videoId,@Param("typeId")Integer typeId);
 int insertCourseType(@Param("courseId") Integer courseId,@Param("typeId")Integer typeId);
 int insertVideo(Video video);
 int updateVideoSort(@Param("sortNow")Integer sortNow,@Param("videoId")Integer videoId);
 int updateVideo(Video video);
 int updateVideoType(@Param("videoId")Integer videoId,@Param("typeId")Integer typeId);
 List<Integer> selectByTypeId(@Param("id")Integer id);
 List<Integer> selectSortList();
 /**
  * 选择当前sort的最大值
  */
 int selectMaxSort();
 /**
  * 查找某视频名称是否存在
  */
 Video selectVideoByName(@Param("videoname")String videoname);
 /**
  * 查找某视频名称是否存在-更新
  */
 Video selectVideoByNameUpdate(@Param("videoname")String videoname,@Param("videoid")Integer videoid);

 /**
  * 查询课程类型下是否有未下架视频
  * @param id
  * @return
  */
 Integer selectVideoListByTypeId(@Param("id")Integer id);
}
