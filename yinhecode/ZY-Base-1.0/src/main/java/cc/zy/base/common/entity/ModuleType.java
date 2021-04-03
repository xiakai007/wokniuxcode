package cc.zy.base.common.entity;

/**
 * 第4组-oss文件夹路径枚举类
 */
public enum ModuleType {
    /**
     * img_photo
     */
    IMG_PHOTO("img_photo", "在线课程视频和图片文件夹"),
    /**
     * img_iden
     */
    IMG_IDEN("img_iden", "身份证图片文件夹"),
    /**
     * img_change
     */
    IMG_CHANGE("img_change", "3号文件夹"),
    /**
     * img_certificate
     */
    IMG_CERTIFICATE("img_certificate", "证书图片文件夹");


    String path;
    String describe;

    ModuleType(String path, String describe) {
        this.path = path;
        this.describe = describe;
    }
    public String getPath(){
        return path;
    }
    public String getDescribe(){
        return describe;
    }
}
