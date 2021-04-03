package cc.zy.base.businesses.service;


import cc.zy.base.businesses.entity.Video;
import cc.zy.base.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  Service接口
 *
 * @author 夏凯
 * @date 2021-01-25 11:03:36
 */
public interface IVideoService extends IService<Video> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param video video
     * @return IPage<Video>
     */
    IPage<Video> findVideos(QueryRequest request, Video video);

    /**
     * 查询（所有）
     *
     * @param video video
     * @return List<Video>
     */
    List<Video> findVideos(Video video);

    /**
     * 新增
     *
     * @param video video
     */
    boolean createVideo(Video video);

    /**
     * 修改
     *
     * @param video video
     */
    boolean updateVideo(Video video);

    /**
     * 删除
     *
     * @param video video
     */
    void deleteVideo(Video video);
    /**
     * 视频下架
     */
    void updateByIdSatus(int id);
    /**
     * 视频排序（一）
     */
    boolean updateBySort(int id, Integer sort, int sort1);
    /**
     * 查询
     */
    IPage<Video> findVideo(QueryRequest request, Video video);

    /**
     * 根据视频id查询视频详情
     * @param id
     * @return
     */
    Video findById(Integer id);
    /**
     * 视频上架
     */
    void updateByIdSatusUp(int id);

    /**
     * 根据视频id获取类别id
     * @param id
     * @return
     */
    int findTypeIdByVid(Integer id);
    /**
     * 查询所有的序号
     * @return
     */
    List<Integer> selectSortList();
    /**
     * 查找某视频名称是否存在
     */
    boolean checkVideoName(String videoname);
    /**
     * 查找某视频名称是否存在-更新
     */
    boolean checkVideoNameUpdate(String videoname, Integer videoid);
}

