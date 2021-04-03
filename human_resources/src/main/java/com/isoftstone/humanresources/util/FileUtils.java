package com.isoftstone.humanresources.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class FileUtils {

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {

        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    public static void main(String[] args)
    {
//		String smtp = "smtp.isoftstone.com";
//		String from = "wlren@isoftstone.com";
//		String to = "wlren@isoftstone.com";
//		String copyto = "";
//		String subject = "GTS&核心网 招聘日报";
//		StringBuffer strBuffer = ReadDateAnalysis.readModel(System.getProperty("user.dir") + "\\bin\\sum.html");
//		// strBuffer.append(" </table></body></html>");
//		String content = strBuffer.toString();
//		String username = "wlren@isoftstone.com";
//		String password = "9ol.)P:?";
//		MailSendServer.sendAndCc(smtp, from, to, copyto, subject, content, username, password);

        try {
            final Base64.Decoder decoder = Base64.getDecoder();
            final Base64.Encoder encoder = Base64.getEncoder();
            final String text = "0db9oNPceW53JCxeNJ0jIw==";
            final byte[] textByte  = text.getBytes("UTF-8");

            final String encodedText = encoder.encodeToString(textByte);
            System.out.println(encodedText);
    //解码
            System.out.println(new String(decoder.decode(encodedText), "UTF-8"));

//            final Base64.Decoder decoder = Base64.getDecoder();
//            final Base64.Encoder encoder = Base64.getEncoder();
//            final String text = "0db9oNPceW53JCxeNJ0jIw==";
//            final byte[] textByte = text.getBytes("UTF-8");
//    //编码
//            final String encodedText = encoder.encodeToString(textByte);
//            System.out.println(encodedText);
//    //解码
//            System.out.println(new String(decoder.decode(encodedText), "UTF-8"));
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }
//编码
    }

}
