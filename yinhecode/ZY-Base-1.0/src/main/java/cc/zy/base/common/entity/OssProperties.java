package cc.zy.base.common.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 第4组-oss属性
 * @date 2021-01-30 11:03:36
 */
@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class OssProperties {
    /**
     * 访问域名
     */
    private String endpoint;
    /**
     * 访问身份验证中用到用户标识
     */
    private String keyid;
    /**
     * 访问身份验证中用到用户密码
     */
    private String keysecret;
    /**
     * 存储空间名称
     */
    private String bucketname;
}
