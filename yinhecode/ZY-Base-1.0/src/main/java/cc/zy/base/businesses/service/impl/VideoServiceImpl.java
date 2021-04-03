package cc.zy.base.businesses.service.impl;


import cc.zy.base.businesses.entity.CType;
import cc.zy.base.businesses.entity.College;
import cc.zy.base.businesses.entity.Video;
import cc.zy.base.businesses.mapper.CTypeMapper;
import cc.zy.base.businesses.mapper.VideoMapper;
import cc.zy.base.businesses.service.IVideoService;
import cc.zy.base.common.entity.FebsConstant;
import cc.zy.base.common.entity.QueryRequest;
import cc.zy.base.common.utils.FebsUtil;
import cc.zy.base.common.utils.SortUtil;
import cc.zy.base.system.entity.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Service实现
 *
 * @author 夏凯
 * @date 2021-01-25 11:03:36
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements IVideoService {

    private final VideoMapper videoMapper;
    private final CTypeMapper cTypeMapper;

    /**
     * 查询（所有）
     *
     * @param video video
     * @return List<Video>
     */
    @Override
    public List<Video> findVideos(Video video) {
        LambdaQueryWrapper<Video> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    /**
     * 新增
     *
     * @param video video
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean createVideo(Video video) {

        CType cType = cTypeMapper.selectById(video.getTypeId());
        if (cType.getPid() == 0) {
            return false;
        }
        long l = System.currentTimeMillis();
        Long userId = FebsUtil.getCurrentUser().getUserId();
        video.setCreateTime(new Date(l));
        video.setUpdateTime(new Date(l));
        video.setCreateUserId(userId.intValue());
        video.setUpdateUserId(userId.intValue());
        videoMapper.insertVideo(video);
        Integer videoId = video.getId();
        Integer typeId = video.getTypeId();
        int sortMax = videoMapper.selectMaxSort();
        int sortNow = sortMax + 1;
        videoMapper.updateVideoSort(sortNow, videoId);
        //videoMapper.insertVideoCourse(courseId,videoId);
        videoMapper.insertVideoType(videoId, typeId);
        //videoMapper.insertCourseType(courseId,typeId);
        return true;
    }


    /**
     * 删除
     *
     * @param video video
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteVideo(Video video) {
        LambdaQueryWrapper<Video> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wrapper);
    }

    /**
     * 视频下架
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateByIdSatus(int id) {
        long l = System.currentTimeMillis();
        Date updateTime = new Date(l);
        Long updateUserId = FebsUtil.getCurrentUser().getUserId();
        videoMapper.updateByIdSatus(id, updateTime, updateUserId.intValue());

    }

    /**
     * 视频排序（一）
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateBySort(int id, Integer sort, int sort1) {
        if (sort == sort1) {
            return false;
        }
        int sort2 = sort;
        int id1 = videoMapper.selectBySort(sort1);
        videoMapper.updateByIdSortAB(id, sort1);
        videoMapper.updateByIdSortAB(id1, sort2);
        return true;
    }

    /**
     * 查询
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public IPage<Video> findVideo(QueryRequest request, Video video) {
        Page<Video> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(baseMapper.countVideoDetail(video));
        SortUtil.handlePageSort(request, page, "sort", FebsConstant.ORDER_ASC, false);
        IPage<Video> videoDetailPage = this.videoMapper.findVideo(page, video);
        return videoDetailPage;
    }


    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param video   video
     * @return IPage<Video>
     */
    @Override
    public IPage<Video> findVideos(QueryRequest request, Video video) {
        // TODO 设置查询条件
        Page<Video> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(baseMapper.countVideoDetail(video));
        log.debug("条目数:" + page.getTotal());
        SortUtil.handlePageSort(request, page, "sort", FebsConstant.ORDER_ASC, false);
        IPage<Video> videoDetailPage = this.baseMapper.findVideoDetailPage(page, video);
        List<Video> videoList = videoDetailPage.getRecords();
        for (Video video1 : videoList) {
            String typeName = video1.getTypeName();
            String typeNameRe = null;
            if (typeName != null) {
                typeNameRe = typeName.replaceAll("└", "");
            }
            video1.setTypeName(typeNameRe);
        }
        videoDetailPage.setRecords(videoList);
        return videoDetailPage;
    }



    /**
     * 根据视频id查询视频详情
     *
     * @param id
     * @return
     */
    @Override
    public Video findById(Integer id) {
        Video video = videoMapper.findById(id);
        return video;
    }

    /**
     * 视频上架
     */
    @Override
    public void updateByIdSatusUp(int id) {
        long l = System.currentTimeMillis();
        Date updateTime = new Date(l);
        Long updateUserId = FebsUtil.getCurrentUser().getUserId();
        int typeId = cTypeMapper.selectByVideoId(id);
        cTypeMapper.updateByIdStatusUp(typeId, updateTime, updateUserId.intValue());
        int pid = cTypeMapper.findPid(typeId);
        cTypeMapper.updateByIdStatusUp(pid, updateTime, updateUserId.intValue());
        videoMapper.updateByIdSatusUp(id, updateTime, updateUserId.intValue());
    }



    /**
     * 根据视频id获取类别id
     *
     * @param id
     * @return
     */
    @Override
    public int findTypeIdByVid(Integer id) {
        int typeId = videoMapper.findTypeIdByVid(id);
        return typeId;
    }

    /**
     * 修改
     *
     * @param video video
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateVideo(Video video) {
        CType cType = cTypeMapper.selectById(video.getTypeId());
        if (cType.getPid() == 0) {
            return false;
        }
        long l = System.currentTimeMillis();
        User currentUser = FebsUtil.getCurrentUser();
        video.setUpdateTime(new Date(l));
        video.setUpdateUserId(currentUser.getUserId().intValue());
        Integer videoId = video.getId();
        Integer typeId = video.getTypeId();
        videoMapper.updateVideo(video);
        videoMapper.updateVideoType(videoId, typeId);
        return true;
    }



    /**
     * 查询所有的序号
     *
     * @return
     */

    @Override
    public List<Integer> selectSortList() {
        return videoMapper.selectSortList();
    }

    /**
     * 查找某视频名称是否存在
     */
    @Override
    public boolean checkVideoName(String videoname) {
        Video video = videoMapper.selectVideoByName(videoname);
        boolean flag = true;
        if (video != null && !video.equals("")) {
            flag = false;
        }
        return flag;
    }

    /**
     * 查找某视频名称是否存在-更新
     */
    @Override
    public boolean checkVideoNameUpdate(String videoname, Integer videoid) {
        Video video = videoMapper.selectVideoByNameUpdate(videoname, videoid);
        boolean flag = true;
        if (video != null && !video.equals("")) {
            flag = false;
        }
        return flag;
    }
}
