package cc.zy.base.businesses.controller;

import cc.zy.base.businesses.utils.AliUploadAuthUtil;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.CreateUploadVideoResponse;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoResponse;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
import com.aliyuncs.vod.model.v20170321.RefreshUploadVideoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * 获取认证凭证
 *
 * @author LiuHeng
 * @date 2021-03-11 10:04:26
 */
@Slf4j
@RestController
public class AppTokenController {

    /**
     * 获取视频上传认证凭证
     *
     * @return CreateUploadVideoResponse 创建的认证凭证对象
     * @throws IOException
     */
    @ResponseBody
    @GetMapping("/getAuth")
    public CreateUploadVideoResponse getAuth(String title,String suffix) throws IOException {

        log.debug(String.format("title = %s, suffix = %s", title, suffix));

        DefaultAcsClient defaultAcsClient = null;
        CreateUploadVideoResponse videoResponse = null;

        try {
           defaultAcsClient = AliUploadAuthUtil.initVodClient();
        } catch (ClientException e) {
            log.error(String.format("ErrorMessage = %s",e.getLocalizedMessage()));
        }

        try {
            videoResponse = AliUploadAuthUtil.createUploadVideo(defaultAcsClient,title,suffix);
            log.debug(String.format("videoResponse = %s",videoResponse.toString()));
            return videoResponse;
        } catch (Exception e) {
            log.error(String.format("获取videoResponse失败 = %s",e.getMessage()));
            return null;
        }finally {
            if(defaultAcsClient != null){
                defaultAcsClient.shutdown();
            }
        }
    }

    /**
     * 刷新视频上传认证凭证
     *
     * @param videoId 视频id
     * @return RefreshUploadVideoResponse 刷新的认证凭证对象
     * @throws IOException
     */
    @ResponseBody
    @GetMapping("/refreshAuth")
    public RefreshUploadVideoResponse refreshAuth(String videoId) throws IOException {

        log.debug(String.format("videoId = %s", videoId));

        DefaultAcsClient defaultAcsClient = null;
        RefreshUploadVideoResponse videoResponse = null;

        try {
            defaultAcsClient = AliUploadAuthUtil.initVodClient();
        } catch (ClientException e) {
            log.error(String.format("ErrorMessage = %s",e.getLocalizedMessage()));
        }

        try {
            videoResponse = AliUploadAuthUtil.refreshUploadVideo(defaultAcsClient,videoId);
            log.debug(String.format("videoResponse = %s",videoResponse.toString()));
            return videoResponse;
        } catch (Exception e) {
            log.error(String.format("获取videoResponse失败 = %s",e.getMessage()));
            return null;
        }finally {
            if(defaultAcsClient != null){
                defaultAcsClient.shutdown();
            }
        }
    }

    /**
     * 获取视频播放地址
     *
     * @param videoId
     * @return
     * @throws IOException
     */
    @ResponseBody
    @GetMapping("/getVideoUrl")
    public List<GetPlayInfoResponse.PlayInfo> getVideoUrl(String videoId) throws IOException {

        log.debug(String.format("videoId = %s", videoId));

        DefaultAcsClient defaultAcsClient = null;
        GetPlayInfoResponse videoResponse = new GetPlayInfoResponse();

        try {
            defaultAcsClient = AliUploadAuthUtil.initVodClient();
        } catch (ClientException e) {
            log.error(String.format("ErrorMessage = %s", e.getLocalizedMessage()));
        }

        try {
            videoResponse = AliUploadAuthUtil.getPlayInfo(defaultAcsClient, videoId);
            log.debug(String.format("videoResponse = %s", videoResponse.toString()));
            List<GetPlayInfoResponse.PlayInfo> playInfoList = videoResponse.getPlayInfoList();
            return playInfoList;
        } catch (Exception e) {
            log.error(String.format("获取videoResponse失败 = %s", e.getMessage()));
            return null;
        }finally {
            if(defaultAcsClient != null){
                defaultAcsClient.shutdown();
            }
        }
    }

    /**
     * 获取视频播放凭证
     *
     * @param videoId
     * @return
     * @throws IOException
     */
    @ResponseBody
    @GetMapping("/getVideoPlayAuth")
    public GetVideoPlayAuthResponse getVideoPlayAuth(String videoId) throws IOException {

        log.debug(String.format("videoId = %s", videoId));

        DefaultAcsClient defaultAcsClient = null;
        GetVideoPlayAuthResponse videoPlayAuth = null;

        try {
            defaultAcsClient = AliUploadAuthUtil.initVodClient();
        } catch (ClientException e) {
            log.error(String.format("ErrorMessage = %s", e.getLocalizedMessage()));
        }

        try {
            videoPlayAuth = AliUploadAuthUtil.getVideoPlayAuth(defaultAcsClient, videoId);
            log.debug(String.format("videoPlayAuth = %s", videoPlayAuth.toString()));
            return videoPlayAuth;
        } catch (Exception e) {
            log.error(String.format("获取videoResponse失败 = %s", e.getMessage()));
            return null;
        }finally {
            if(defaultAcsClient != null){
                defaultAcsClient.shutdown();
            }
        }
    }


}