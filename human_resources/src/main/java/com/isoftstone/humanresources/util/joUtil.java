package com.isoftstone.humanresources.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class joUtil {

    /**
     * @title getHtmlResourceByUrl
     * @param url          网址
     * @param encoding     编码
     * @return String 返回类型
     */
    public static String getHtmlResourceByUrl(String url, String encoding) {
        StringBuffer buffer = new StringBuffer();
        try {
            //建立网络连接     异常捕获
            URL urlObj = new URL(url);
            //打开网络连接
            URLConnection urlconn = urlObj.openConnection();
            //IO流
            InputStreamReader in = new InputStreamReader(urlconn.getInputStream(), encoding);
            //建立缓存
            BufferedReader bfr = new BufferedReader(in);
            //临时文件
            String line = null;
            //读取
            while((line = bfr.readLine()) != null) {
                buffer.append(line);
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

        return buffer.toString();
    }


    public static void spiderURL(String url, String regex, String filename) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String time = sdf.format(new Date());
        System.out.println(time);

        URL realURL = null;
        URLConnection connection = null;
        BufferedReader br = null;
        PrintWriter pw = null;
        PrintWriter pw1 = null;

        Pattern pattern = Pattern.compile(regex);
        try {
            realURL = new URL(url);
            connection = realURL.openConnection();

            File fileDir = new File("E:/spider/" + time);
            if (!fileDir.exists()) {
                fileDir.mkdirs();
            }
// 将爬取到的内容放到E盘相应目录下
            pw = new PrintWriter(
                    new FileWriter("E:/spider/" + time + "/" + filename + "_content.txt"), true);
            pw1 = new PrintWriter(new FileWriter("E:/spider/" + time + "/" + filename + "_URL.txt"),
                    true);

            br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = null;

// 读写
            while ((line = br.readLine()) != null) {
                pw.println(line);
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    pw1.println(matcher.group());
                }

            }
            System.out.println("爬取成功！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                pw.close();
                pw1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String url = "https://www.chsi.com.cn/xlcx/bg.do?vcode=541566993474&ln=cn&srcid=pdf";
        String regex = "(http|https)://[\\w+\\.?/?]+\\.[A-Za-z]+";
        spiderURL(url, regex, "8btc");
    }

//    public static void main(String[] args){
//        String info = getHtmlResourceByUrl("https://www.chsi.com.cn/xlcx/bg.do?vcode=541566993474&ln=cn&srcid=pdf", "utf8");
//        System.out.println(info);
//    }

}