package cc.zy.base.common.authentication;

import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import io.swagger.annotations.ApiModelProperty;
import org.apache.shiro.authc.UsernamePasswordToken;

public class UserToken extends UsernamePasswordToken {
    //登录类型，判断是用户登录，学生登录
    private String loginType;
    private WxMaUserInfo userInfo;
    private String batchName;
    @ApiModelProperty(value = "身份证")
    private String identity;
    @ApiModelProperty(value = "电话")
    private String tel;
    @ApiModelProperty(value = "报考类型")
    private String studyTypeName;

    public UserToken(final String username, final String password, boolean rememberMe, String loginType) {
        super(username, password, rememberMe);
        this.loginType = loginType;
    }

    public UserToken(final WxMaUserInfo userInfo, final String batchName, final String identity, final String tel, final String studyTypeName, String loginType) {
        super(identity, "");
        this.userInfo = userInfo;
        this.batchName = batchName;
        this.identity = identity;
        this.tel = tel;
        this.studyTypeName = studyTypeName;
        this.loginType = loginType;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public WxMaUserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(WxMaUserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getStudyTypeName() {
        return studyTypeName;
    }

    public void setStudyTypeName(String studyTypeName) {
        this.studyTypeName = studyTypeName;
    }
}
