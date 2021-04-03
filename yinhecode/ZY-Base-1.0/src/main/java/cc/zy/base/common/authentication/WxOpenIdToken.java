package cc.zy.base.common.authentication;

import io.swagger.annotations.ApiModelProperty;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author jiangjinlin
 * @date 2021/2/21 12:50
 */
public class WxOpenIdToken extends UsernamePasswordToken implements AuthenticationToken {

    @ApiModelProperty(value = "微信openId")
    private String openId;
    @ApiModelProperty(value = "学籍名称")
    private String batchName;
    @ApiModelProperty(value = "身份证")
    private String identity;
    @ApiModelProperty(value = "电话")
    private String tel;
    @ApiModelProperty(value = "报考类型")
    private String studyTypeName;
    @ApiModelProperty(value = "临时登录凭证")
    private String code;

    /**
     *
     */
    private static final long serialVersionUID = 4812793519945855483L;
    @Override
    public Object getPrincipal() {
        return openId;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    public WxOpenIdToken(String openId, String batchName, String code, String identity, String tel, String studyTypeName){
        this.openId=openId;
        this.batchName=batchName;
        this.code=code;
        this.identity=identity;
        this.tel=tel;
        this.studyTypeName=studyTypeName;
    }

    @Override
    public String toString() {
        return "AuthUser{" +
                "openId='" + openId + '\'' +
                ", batchName='" + batchName + '\'' +
                ", code='" + code + '\'' +
                ", identity='" + identity + '\'' +
                ", tel='" + tel + '\'' +
                ", studyTypeName=" + studyTypeName +
                '}';
    }
}
