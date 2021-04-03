package com.isoftstone.humanresources.util;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;


public class FtpUtil {
    private final static Logger logger = LoggerFactory.getLogger(FtpUtil.class);
    public static boolean uploadFiles(String originFileName, InputStream input, String address, String port, String username
            , String password, String path
    ) {

        logger.info("----------登录用户的接入参数------{},{},{},{},{},{},{}",originFileName, input,address,port,username,password,path);
        boolean success = false;
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("GBK");
        try {
            int reply;
            ftp.connect(address, Integer.parseInt(port));// 连接FTP服务器
            ftp.login(username, password);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            //设置为被动模式
            ftp.enterLocalPassiveMode();
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.makeDirectory(path);
            ftp.changeWorkingDirectory(path);
            ftp.storeFile(originFileName, input);
            input.close();
            ftp.logout();
            success = true;
        } catch (IOException e) {
            logger.error("-----------连接异常--------", e);
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return success;
    }


}
