package cc.zy.base.common.authentication;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @Author: zh
 * @Date: 2020/9/8 14:59
 */
//@ApiModel("登录信息类")
@Data
public class WxLoginVo {
    public WxLoginVo(){}

    //	@ApiModelProperty("授权码")
    @NotNull
    private String code;

    /**
     * 小程序 AppID
     */
    private String appid;


    //	@ApiModelProperty("用户信息对象，不包含 openid 等敏感信息")
    private WxUserInfo userInfo;


    //	@ApiModelProperty("不包括敏感信息的原始数据字符串，用于计算签名")
    private String rawData;


    //	@ApiModelProperty("使用 sha1( rawData + sessionkey ) 得到字符串，用于校验用户信息")
    private String signature;


    //	@ApiModelProperty("包括敏感数据在内的完整用户信息的加密数据")
    private String encryptedData;


    //	@ApiModelProperty("加密算法的初始向量")
    private String iv;

    private String batchName;
    @ApiModelProperty(value = "身份证")
    private String identity;
    @ApiModelProperty(value = "电话")
    private String tel;
    @ApiModelProperty(value = "报考类型")
    private String studyTypeName;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class WxUserInfo{
        /**
         * 昵称
         */
        private String nickName;

        /**
         * 头像url
         */
        private String avatarUrl;

        /**
         * 性别 : 0 => 未知, 1 => 男性, 2 => 女性
         */
        private Integer gender;

        /**
         * 国家
         */
        private String country;

        /**
         * 省份
         */
        private String province;

        /**
         * 城市
         */
        private String city;

        /**
         * 语言, 显示 country，province，city 所用的语言
         *      en : 英文
         *      zh_CN : 简体中文
         *      zh_TW : 繁体中文
         */
        private String language;
    }

}
