package cc.zy.base.common.authentication;

public enum LoginType {
    OPENID("OpenId"), SHIRO("Shiro");

    private String type;

    private LoginType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type.toString();
    }
}
