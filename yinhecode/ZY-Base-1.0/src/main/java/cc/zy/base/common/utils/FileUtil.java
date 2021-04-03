package cc.zy.base.common.utils;

import cc.zy.base.common.entity.FebsConstant;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.FileSystemUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author MrBird
 */
@Slf4j
public abstract class FileUtil {

    private static final int BUFFER = 1024 * 8;

    /**
     * 压缩文件或目录
     *
     * @param fromPath 待压缩文件或路径
     * @param toPath   压缩文件，如 xx.zip
     */
    public static void compress(String fromPath, String toPath) throws IOException {
        File fromFile = new File(fromPath);
        File toFile = new File(toPath);
        if (!fromFile.exists()) {
            throw new FileNotFoundException(fromPath + "不存在！");
        }
        try (
                FileOutputStream outputStream = new FileOutputStream(toFile);
                CheckedOutputStream checkedOutputStream = new CheckedOutputStream(outputStream, new CRC32());
                ZipOutputStream zipOutputStream = new ZipOutputStream(checkedOutputStream)
        ) {
            String baseDir = "";
            compress(fromFile, zipOutputStream, baseDir);
        }
    }

    /**
     * 文件下载
     *
     * @param filePath 待下载文件路径
     * @param fileName 下载文件名称
     * @param delete   下载后是否删除源文件
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    public static void download(String filePath, String fileName, Boolean delete, HttpServletResponse response) throws Exception {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new Exception("文件未找到");
        }

        String fileType = getFileType(file);
        if (!fileTypeIsValid(fileType)) {
            throw new Exception("暂不支持该类型文件下载");
        }
        response.setHeader("Content-Disposition", "attachment;fileName=" + java.net.URLEncoder.encode(fileName, "utf-8"));
        response.setContentType("multipart/form-data");
        response.setCharacterEncoding("utf-8");
        try (InputStream inputStream = new FileInputStream(file); OutputStream os = response.getOutputStream()) {
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
        } finally {
            if (delete) {
                FileSystemUtils.deleteRecursively(file);
            }
        }
    }

    /**
     * 获取文件类型
     *
     * @param file 文件
     * @return 文件类型
     * @throws Exception Exception
     */
    private static String getFileType(File file) throws Exception {
        Preconditions.checkNotNull(file);
        if (file.isDirectory()) {
            throw new Exception("file不是文件");
        }
        String fileName = file.getName();
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }


    /**
     * 校验文件类型是否是允许下载的类型
     * （出于安全考虑：https://github.com/wuyouzhuguli/FEBS-Shiro/issues/40）
     *
     * @param fileType fileType
     * @return Boolean
     */
    private static Boolean fileTypeIsValid(String fileType) {
        Preconditions.checkNotNull(fileType);
        fileType = StringUtils.lowerCase(fileType);
        return ArrayUtils.contains(FebsConstant.VALID_FILE_TYPE, fileType);
    }

    private static void compress(File file, ZipOutputStream zipOut, String baseDir) throws IOException {
        if (file.isDirectory()) {
            compressDirectory(file, zipOut, baseDir);
        } else {
            compressFile(file, zipOut, baseDir);
        }
    }

    private static void compressDirectory(File dir, ZipOutputStream zipOut, String baseDir) throws IOException {
        File[] files = dir.listFiles();
        if (files != null && ArrayUtils.isNotEmpty(files)) {
            for (File file : files) {
                compress(file, zipOut, baseDir + dir.getName() + File.separator);
            }
        }
    }

    private static void compressFile(File file, ZipOutputStream zipOut, String baseDir) throws IOException {
        if (!file.exists()) {
            return;
        }
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
            ZipEntry entry = new ZipEntry(baseDir + file.getName());
            zipOut.putNextEntry(entry);
            int count;
            byte[] data = new byte[BUFFER];
            while ((count = bis.read(data, 0, BUFFER)) != -1) {
                zipOut.write(data, 0, count);
            }
        }
    }

//    /**
//     *取系统时间字符串（年月日时分秒）<BR>
//     *@return   时间字符串
//     */
//    public static String getSysTime()
//    {
//        //定义日历对象
//        Calendar calendar = new GregorianCalendar();
//
//        //年
//        String year = String.valueOf(calendar.get(Calendar.YEAR));
//        //月
//        String month = String.valueOf(calendar.get(Calendar.MONTH)+1);
//        //日
//        String day = String.valueOf(calendar.get(Calendar.DATE));
//        //时
//        String hour = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
//        //分
//        String minute = String.valueOf(calendar.get(Calendar.MINUTE));
//        //秒
//        String second = String.valueOf(calendar.get(Calendar.SECOND));
//        //毫秒
//        String millSecond = String.valueOf(calendar.get(Calendar.MILLISECOND));
//        //时间字符串2
//        String date = year+month+day+hour+minute+second+millSecond;
//
//        //返回
//        return date;
//    }
//
//    public static String upFileLoad(String path, String fileName) throws Exception
//    {
//        int random = (int)(Math.random()*100000+1);
//        // 文件上传的相对路径
//        String imagePath = getSysTime() + random + getExtention(fileName);
//        // 判断目标文件是否存在
//        File destFile = new File(ReadProperties.getProperties(Const.SERVICE_IMAGE_PATH));
//        // 如果目标文件所在目录不存在，则创建目录
//        if (!destFile.getParentFile().exists()) {
//            System.out.println("目标文件所在目录不存在，准备创建。。。");
//            while (!destFile.getAbsoluteFile().mkdirs()) {
//                System.out.println("复制文件失败：创建目标文件所在目录失败！");
//            }
//        }
//        // 构造文件名称
//        String imageFileName = ReadProperties.getProperties(Const.SERVICE_IMAGE_PATH) + imagePath;
//
//        FileInputStream file = new FileInputStream(path);
//
//        FileOutputStream inFile = new FileOutputStream(imageFileName);
//        int total = file.available();
//        while(true)
//        {
//            byte[] fileByte = new byte[total];
//            int temp = file.read(fileByte);
//            if(temp < 0)
//            {
//                break;
//            }
//            inFile.write(fileByte,0,temp);
//        }
//        file.close();
//        inFile.close();
//        return imagePath;
//    }
//
//    /**
//     * 截取上传文件后缀
//     * @return 文件后缀
//     */
//    public static String getExtention(String fileName)
//    {
//        int pos = fileName.lastIndexOf(".");
//        return fileName.substring(pos);
//    }
}
