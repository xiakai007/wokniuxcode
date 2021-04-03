package cc.zy.base.businesses.utils;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.CreateUploadVideoRequest;
import com.aliyuncs.vod.model.v20170321.CreateUploadVideoResponse;
import com.aliyuncs.vod.model.v20170321.RefreshUploadVideoRequest;
import com.aliyuncs.vod.model.v20170321.RefreshUploadVideoResponse;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoRequest;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoResponse;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
import com.aliyuncs.vod.model.v20170321.CreateUploadImageRequest;
import com.aliyuncs.vod.model.v20170321.CreateUploadImageResponse;

/**
 * 阿里云认证工具
 *
 * @author LiuHeng
 * @date 2021-03-11 09:49:21
 */
public class AliUploadAuthUtil {

    /**
     * 初始化客户端
     *
     * @param accessKeyId
     * @param accessKeySecret
     * @return
     * @throws ClientException
     */
    public static DefaultAcsClient initVodClient(String accessKeyId, String accessKeySecret) throws ClientException {

        String regionId = "cn-shanghai";  // 点播服务接入区域

        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        DefaultAcsClient client = new DefaultAcsClient(profile);

        return client;
    }

    /**
     * 获取视频上传地址和凭证
     * @param client 发送请求客户端
     * @return CreateUploadVideoResponse 获取视频上传地址和凭证响应数据
     * @throws Exception
     */
    public static CreateUploadVideoResponse createUploadVideo(DefaultAcsClient client, String title, String suffix) throws Exception {

        CreateUploadVideoRequest request = new CreateUploadVideoRequest();

        request.setTitle(title);
        request.setFileName(title+suffix);

        //UserData，用户自定义设置参数，用户需要单独回调URL及数据透传时设置(非必须)
        //JSONObject userData = new JSONObject();

        //UserData回调部分设置
        //JSONObject messageCallback = new JSONObject();
        //messageCallback.put("CallbackURL", "http://192.168.0.0/16");
        //messageCallback.put("CallbackType", "http");
        //userData.put("MessageCallback", messageCallback.toJSONString());

        //UserData透传数据部分设置
        //JSONObject extend = new JSONObject();
        //extend.put("MyId", "user-defined-id");
        //userData.put("Extend", extend.toJSONString());

        //request.setUserData(userData.toJSONString());

        return client.getAcsResponse(request);
    }

    /**
     * 刷新视频上传凭证
     * @param client 发送请求客户端
     * @return RefreshUploadVideoResponse 刷新视频上传凭证响应数据
     * @throws Exception
     */
    public static RefreshUploadVideoResponse refreshUploadVideo(DefaultAcsClient client,String videoId) throws Exception {

        RefreshUploadVideoRequest request = new RefreshUploadVideoRequest();
        request.setVideoId(videoId);

        return client.getAcsResponse(request);
    }

    /**
     * 获取视频播放地址
     *
     * @param client
     * @return
     * @throws Exception
     */
    public static GetPlayInfoResponse getPlayInfo(DefaultAcsClient client,String videoId) throws Exception {

        GetPlayInfoRequest request = new GetPlayInfoRequest();
        request.setVideoId(videoId);

        return client.getAcsResponse(request);
    }


    /**
     * 获取视频播放凭证
     *
     * @param client
     * @return
     * @throws Exception
     */
    public static GetVideoPlayAuthResponse getVideoPlayAuth(DefaultAcsClient client,String videoId) throws Exception {

        GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
        request.setVideoId(videoId);

        return client.getAcsResponse(request);
    }

    /**
     * 获取图片上传地址和凭证
     * @param client 发送请求客户端
     * @return CreateUploadImageResponse 获取图片上传地址和凭证响应数据
     * @throws Exception
     */
    public static CreateUploadImageResponse createUploadImage(DefaultAcsClient client, String type, String ext, String title) throws Exception {
        CreateUploadImageRequest request = new CreateUploadImageRequest();
        request.setImageType(type);
        request.setImageExt(ext);
        request.setTitle(title);

        JSONObject userData = new JSONObject();

        JSONObject messageCallback = new JSONObject();
        messageCallback.put("CallbackURL", "http://192.168.0.0/16");
        messageCallback.put("CallbackType", "http");
        userData.put("MessageCallback", messageCallback.toJSONString());

        JSONObject extend = new JSONObject();
        extend.put("MyId", "user-defined-id");
        userData.put("Extend", extend.toJSONString());

        request.setUserData(userData.toJSONString());

        return client.getAcsResponse(request);
    }

}
