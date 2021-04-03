package com.isoftstone.humanresources.util;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.isoftstone.humanresources.domain.workTime.FileModel;
import org.apache.commons.collections.map.HashedMap;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

/**
 * excl导出工具类
 * @author bwning
 *
 */
public class ImportExcelUtil {
    
    private static final  String EXCEL2003L =".xls";    //2003- 版本的excel
    private static final  String EXCEL2007U =".xlsx";   //2007+ 版本的excel

    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

    /**
     * 描述：获取IO流中的数据，组装成List<List<Object>>对象
     * @param in,fileName
     * @param  i 第几个sheet页 从0开始的
     * @return
     * @throws IOException 
     */
    public  List<List<Object>> getBankListByExcel(InputStream in,String fileName,int i) throws MyException, IOException{
        List<List<Object>> list = null;
        
        //创建Excel工作薄
        Workbook work = this.getWorkbook(in,fileName);
        if(null == work){
            throw new MyException("创建Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;
        
        list = new ArrayList<List<Object>>();
        int endRow = 0;
        //遍历Excel中所有的sheet
        sheet = work.getSheetAt(i);
        if(sheet==null){return list;}
        //遍历当前sheet中的所有行
        for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
            row = sheet.getRow(j);
            if(isNull(row,endRow)||sheet.getFirstRowNum()==j){
                if(sheet.getFirstRowNum()==j){
                    endRow = row.getLastCellNum();
                }
                continue;
                }

            //遍历所有的列
            List<Object> li = new ArrayList<Object>();
            for (int y = 0; y <= endRow; y++) {
                cell = row.getCell(y);
                li.add(this.getCellValue(cell));
            }
            list.add(li);
        }

        return list;
    }

    /**
     * 描述：获取IO流中的数据，组装成List<List<Object>>对象
     * @param in,fileName
     * @param  i 第几个sheet页 从0开始的
     * @param  rowStart 第几行开始
     * @param  columnEnd 第几列结束
     * @return
     * @throws IOException
     */
    public  List<List<Object>> getOmpBankListByExcel(InputStream in,String fileName,int i,int rowStart,int columnEnd) throws MyException, IOException{
        List<List<Object>> list = null;

        //创建Excel工作薄
        Workbook work = this.getWorkbook(in,fileName);
        if(null == work){
            throw new MyException("创建Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;

        list = new ArrayList<List<Object>>();
        int endRow = 0;
        //遍历Excel中所有的sheet
        sheet = work.getSheetAt(i);
        if(sheet==null){return list;}
        //遍历当前sheet中的所有行
        for (int j = rowStart; j <= sheet.getLastRowNum(); j++) {
            row = sheet.getRow(j);
            if(isNull(row,endRow)||sheet.getFirstRowNum()==j){
                if(sheet.getFirstRowNum()==j){
                    endRow = row.getLastCellNum();
                }
                continue;
            }

            //遍历所有的列
            List<Object> li = new ArrayList<Object>();
            for (int y = 0; y <= columnEnd; y++) {
                cell = row.getCell(y);
                li.add(this.getCellValue(cell));
            }
            list.add(li);
        }
        return list;
    }

    public Map<Integer ,List<List<Object>>> getOmpBankListByExcelForEveryDay (InputStream in,String fileName,int i,int rowStart,int columnEnd ) throws MyException, IOException{

        Map<Integer ,List<List<Object>>> ret = new HashedMap();

        List<List<Object>> list = null;

        //创建Excel工作薄
        Workbook work  = this.getWorkbook(in,fileName);
        if(null == work){
            throw new MyException("创建Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;

        list = new ArrayList<List<Object>>();
        int endRow = 0;
        //遍历Excel中所有的sheet
        sheet = work.getSheetAt(i);
//        if(sheet==null){return list;}
        //遍历当前sheet中的所有行
        for (int j = rowStart; j <= sheet.getLastRowNum(); j++) {
            row = sheet.getRow(j);
            if(isNull(row,endRow)||sheet.getFirstRowNum()==j){
                if(sheet.getFirstRowNum()==j){
                    endRow = row.getLastCellNum();
                }
                continue;
            }

            //遍历所有的列
            List<Object> li = new ArrayList<Object>();
            for (int y = 0; y <= columnEnd; y++) {
                cell = row.getCell(y);
                li.add(this.getCellValue(cell));
            }
            list.add(li);
        }

        ret.put(0, list) ;

        ret.put(1, getOmpBankListByExcelForDay( work ,  1,1,13)) ;

        ret.put(2, getOmpBankListByExcelForDay( work ,  3,1,10)) ;

        return ret;
    }

    public  List<List<Object>> getOmpBankListByExcelForDay(Workbook work ,int i,int rowStart,int columnEnd) throws MyException, IOException{
        List<List<Object>> list = null;

        //创建Excel工作薄
        if(null == work){
            throw new MyException("创建Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;

        list = new ArrayList<List<Object>>();
        int endRow = 0;
        //遍历Excel中所有的sheet
        sheet = work.getSheetAt(i);
        if(sheet==null){return list;}
        //遍历当前sheet中的所有行
        for (int j = rowStart; j <= sheet.getLastRowNum(); j++) {
            row = sheet.getRow(j);
            if(isNull(row,endRow)||sheet.getFirstRowNum()==j){
                if(sheet.getFirstRowNum()==j){
                    endRow = row.getLastCellNum();
                }
                continue;
            }

            //遍历所有的列
            List<Object> li = new ArrayList<Object>();
            for (int y = 0; y <= columnEnd; y++) {
                cell = row.getCell(y);
                li.add(this.getCellValue(cell));
            }
            list.add(li);
        }

        return list;
    }

    /**
     * 描述：根据文件后缀，自适应上传文件的版本 
     * @param inStr,fileName
     * @return
     * @throws IOException 
     * @throws Exception
     */
    public  Workbook getWorkbook(InputStream inStr,String fileName) throws MyException, IOException{
        Workbook wb = null;
        String fileType = fileName.substring(fileName.lastIndexOf('.'));
        if(EXCEL2003L.equals(fileType)){
            wb = new HSSFWorkbook(inStr);  //2003-
        }else if(EXCEL2007U.equals(fileType)){
            wb = new XSSFWorkbook(inStr);  //2007+
        }else{
            throw new MyException("解析的文件格式有误！");
        }
        return wb;
    }

    /**
     * 描述：对表格中数值进行格式化
     * @param cell
     * @return
     */
    public  Object getCellValue(Cell cell){
        Object value = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");  //日期格式化
        DecimalFormat df2 = new DecimalFormat("0.0000");  //格式化数字
        if (cell == null)
        {
            return "";
        }
        switch (cell.getCellType()) {
        case Cell.CELL_TYPE_STRING:
            value =cell.getRichStringCellValue().getString();
            break;
        case Cell.CELL_TYPE_NUMERIC:
            if("m/d/yy".equals(cell.getCellStyle().getDataFormatString())){
                value = sdf.format(cell.getDateCellValue());
            }else{
                value = df2.format(cell.getNumericCellValue());
            }
            break;
        case Cell.CELL_TYPE_BOOLEAN:
            value = cell.getBooleanCellValue();
            break;
        case Cell.CELL_TYPE_BLANK:
            value = "";
            break;
        default:
            break;
        }

        return value;
    }
    
    private boolean isNull(Row row,int endRow){
    	int num = 0;
    	boolean flag = false;
    	try {
    		for (int y = 0; y <= endRow; y++) {
                if(!StringUtil.isEmpty(String.valueOf(this.getCellValue(row.getCell(y))))){
                	num++;
                }
            }
        	if (num == 0) {
        		flag = true;
    		}
		} catch (Exception e) {
			flag = true;
		}
    	
    	return flag;
    }

    //zip数据处理
    public List<Map<String,Object>> readZipFile(String file ) throws Exception {
        //ZipFile zf = new ZipFile(file);
        int i=0;
        List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
        URL url = new URL(file);
        URLConnection connection = url.openConnection();
        InputStream in = connection.getInputStream();//new BufferedInputStream(new FileInputStream(file));

        ZipInputStream zin = new ZipInputStream(in);
        ZipEntry ze;
        while ((ze = zin.getNextEntry()) != null) {
            Integer fail=0;
            String msg="";
            if (ze.isDirectory()) {
            } else {
                i++;
                ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
                byte[] byte_s=new byte[1024];
                int num=-1;
                while((num=zin.read(byte_s,0,byte_s.length))>-1){//通过read方法来读取文件内容
                    byteArrayOutputStream.write(byte_s,0,num);
                }
                byte[] byte_s_=byteArrayOutputStream.toByteArray();
                Map<String,Object> m=new HashedMap();
                //可以不要------
                if(ze.getName().substring(ze.getName().indexOf(".")).equals(".png") || ze.getName().substring(ze.getName().indexOf(".")).equals(".jpg") ||
                        ze.getName().substring(ze.getName().indexOf(".")).equals(".gif") || ze.getName().substring(ze.getName().indexOf(".")).equals(".bmp") ||
                        ze.getName().substring(ze.getName().indexOf(".")).equals(".jpeg")){
                    if(ze.getName() != null){

                    }else {
                        fail++;
                        msg += "<br/>错误：行" + i + " :未找到该学生";
                    }
                }else {
                    fail++;
                    msg += "<br/>错误：行" + i + " :只支持 png , jpg , gif , bmp , jpeg格式图片上传";
                }
                //-----可以不要  到这
                m.put("fail",fail);
                m.put("msg",msg);
                m.put("idCode",ze.getName());
                m.put("bytes",byte_s_);//压缩包中的单个byte
                list.add(m);
                //String fileNeirong=new String(byte_s,"UTF-8");//将字节数组转化为字符串，UTF-8格式（容许中文）
                //System.out.println(fileNeirong);
            }
        }
        zin.closeEntry();
        return  list;
    }

    //

    /**
     * 对zip类型的文件进行解压
     */
    public  List<FileModel> unzip(MultipartFile file) {
        // 判断文件是否为zip文件
        String filename = file.getOriginalFilename();
        if (!filename.endsWith("zip")) {
            logger.info("传入文件格式不是zip文件" + filename);
        }
        List<FileModel> fileModelList = new ArrayList<FileModel>();
        String zipFileName = null;
        // 对文件进行解析
        try {
            ZipInputStream zipInputStream = new ZipInputStream(file.getInputStream(), Charset.forName("GBK"));
            BufferedInputStream bs = new BufferedInputStream(zipInputStream);
            ZipEntry zipEntry;
            byte[] bytes = null;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) { // 获取zip包中的每一个zip file entry
                zipFileName = zipEntry.getName();
                Assert.notNull(zipFileName, "压缩文件中子文件的名字格式不正确");
                FileModel fileModel = new FileModel();
                fileModel.setFileName(zipFileName);
                bytes = new byte[(int) zipEntry.getSize()];
                bs.read(bytes, 0, (int) zipEntry.getSize());
                InputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
                fileModel.setFileInputstream(byteArrayInputStream);
                fileModelList.add(fileModel);
            }
        } catch (Exception e) {
            logger.error("读取部署包文件内容失败,请确认部署包格式正确:" + zipFileName, e);
        }
        return fileModelList;
    }

}
