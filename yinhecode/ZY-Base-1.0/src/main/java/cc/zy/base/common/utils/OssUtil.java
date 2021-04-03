package cc.zy.base.common.utils;

import cc.zy.base.common.entity.OssProperties;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.http.HttpRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.*;

/**
 * @author 第4组-文件上传工具类
 * @date 2021-01-30 11:03:36
 */
public abstract class OssUtil {
    public static String upload(MultipartFile file, OssProperties ossProperties, String module)throws Exception{

        String endpoint = ossProperties.getEndpoint();
        String keyid = ossProperties.getKeyid();
        String keysecret = ossProperties.getKeysecret();
        String bucketname = ossProperties.getBucketname();
        // <yourObjectName>上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        //String folder = new DateTime().toString("yyyy/MM/dd");
        InputStream inputStream=file.getInputStream();
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, keyid, keysecret);
        String fileName=null;
        String fileExtension=null;

            String originalFilename = file.getOriginalFilename();
            fileName = UUID.randomUUID().toString();
            fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
            String objectName = module + "/" +  fileName + fileExtension;
            // 上传文件到指定的存储空间（bucketName）并将其保存为指定的文件名称（objectName）。
            ossClient.putObject(bucketname, objectName,inputStream);
            String uploadUrl="https://" + bucketname + "." + endpoint + "/" + module+"/"+ fileName + fileExtension;


        // 关闭OSSClient。
        ossClient.shutdown();
        return uploadUrl;
    }
}
