//package cc.zy.base.businesses.utils;
//
//
//import java.io.*;
//import java.net.URLEncoder;
//import java.text.DecimalFormat;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletResponse;
//
//import cc.zy.base.businesses.entity.EntranceScore;
//import org.apache.poi.hssf.usermodel.*;
//import org.apache.poi.hssf.util.HSSFColor;
//import org.apache.poi.ss.usermodel.*;
//
//
//public class ExcelUtil {
//    /**
//     * 创建excel文档，
//     *  list 数据
//     * @param keys list中map的key数组集合
//     * @param columnNames excel的列名
//     * */
//    public static HSSFWorkbook createWorkBook(List<Map<String, Object>> list, String []keys, String columnNames[]) {
//        // 创建excel工作簿
//        HSSFWorkbook wb = new HSSFWorkbook();
//        // 创建第一个sheet页，并命名
//        HSSFSheet sheet = wb.createSheet(list.get(0).get("sheetName").toString());
//        // 设置列宽
//        for(int i=0;i<keys.length;i++){
//            sheet.setColumnWidth((short) i, (short) (50*60));
//        }
//
//        // 创建第一行，并设置其单元格格式
//        HSSFRow row = sheet.createRow((short) 0);
//        row.setHeight((short)500);
//        // 单元格格式(用于列名)
//        HSSFCellStyle cs = wb.createCellStyle();
//        HSSFFont f = wb.createFont();
//        f.setFontName("宋体");
//        f.setFontHeightInPoints((short) 10);
//        f.setBold(true);
//        cs.setFont(f);
//        cs.setAlignment(HorizontalAlignment.CENTER);// 水平居中
//        cs.setVerticalAlignment(VerticalAlignment.CENTER);// 垂直居中
//        cs.setLocked(true);
//        cs.setWrapText(true);//自动换行
//        //设置列名
//        for(int i=0;i<columnNames.length;i++){
//            HSSFCell cell = row.createCell(i);
//            cell.setCellValue(columnNames[i]);
//            cell.setCellStyle(cs);
//        }
//
//        //设置首行外,每行每列的值(Row和Cell都从0开始)
//        for (short i = 1; i < list.size(); i++) {
//            HSSFRow row1 = sheet.createRow((short) i);
//            String flag = "";
//            //在Row行创建单元格
//            for(short j=0;j<keys.length;j++){
//                HSSFCell cell = row1.createCell(j);
//                cell.setCellValue(list.get(i).get(keys[j]) == null?" ": list.get(i).get(keys[j]).toString());
////                if(list.get(i).get(keys[j])!=null){
////                    if("优".equals(list.get(i).get(keys[j]).toString())){
////                        flag = "优";
////                    }else if("差".equals(list.get(i).get(keys[j]).toString())) {
////                        flag = "差";
////                    }
////                }
//            }
//            //设置该行样式
//            HSSFFont f2 = wb.createFont();
//            f2.setFontName("宋体");
//            f2.setFontHeightInPoints((short) 10);
//
//        }
//        return wb;
//    }
//
//    //生成并下载Excel
//    public static void downloadWorkBook(List<Map<String,Object>> list,
//                                        String keys[],
//                                        String columnNames[],
//                                        String fileName,
//                                        HttpServletResponse response) throws IOException{
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        try {
//            ExcelUtil.createWorkBook(list,keys,columnNames).write(os);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        byte[] content = os.toByteArray();
//        InputStream is = new ByteArrayInputStream(content);
//        // 设置response参数
//        response.reset();
//        response.setContentType("application/vnd.ms-excel;charset=utf-8");
//        response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xls").getBytes(), "iso-8859-1"));
//        ServletOutputStream out = response.getOutputStream();
//        BufferedInputStream bis = null;
//        BufferedOutputStream bos = null;
//        try {
//            bis = new BufferedInputStream(is);
//            bos = new BufferedOutputStream(out);
//            byte[] buff = new byte[2048];
//            int bytesRead;
//            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
//                bos.write(buff, 0, bytesRead);
//            }
//        } catch (final IOException e) {
//            throw e;
//        } finally {
//            if (bis != null)
//                bis.close();
//            if (bos != null)
//                bos.close();
//        }
//
//
//
//    }
//
//
//    /**
//     * 创建Excel表中的记录
//     * @param entranceScores
//     * @return
//     */
//    public static List<Map<String, Object>> createExcelRecord(List<EntranceScore> entranceScores){
//        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
//        try {
//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("sheetName", "sheet1");
//            listmap.add(map);
//
//            for (int j = 0; j < entranceScores.size(); j++) {
//                EntranceScore entranceScore=entranceScores.get(j);
//                Map<String, Object> mapValue = new HashMap<String, Object>();
//                mapValue.put("batchName",entranceScore.getBatchName());
//                mapValue.put("stuName",entranceScore.getStuName());
//                mapValue.put("identity",entranceScore.getIdentity());
//                mapValue.put("collegeName",entranceScore.getCollegeName());
//                mapValue.put("levelName",entranceScore.getLevelName());
//                mapValue.put("fullName",entranceScore.getFullName());
//                mapValue.put("o",entranceScore.getO());
//                mapValue.put("n",entranceScore.getN());
//                mapValue.put("p",entranceScore.getP());
//                mapValue.put("chinese",entranceScore.getChinese());
//                mapValue.put("b",entranceScore.getB());
//                mapValue.put("c",entranceScore.getC());
//                mapValue.put("f",entranceScore.getF());
//                mapValue.put("d",entranceScore.getD());
//                mapValue.put("e",entranceScore.getE());
//                mapValue.put("h",entranceScore.getH());
//                mapValue.put("m",entranceScore.getM());
//                mapValue.put("q",entranceScore.getQ());
//                mapValue.put("g",entranceScore.getG());
//                mapValue.put("j",entranceScore.getJ());
//                mapValue.put("i",entranceScore.getI());
//                mapValue.put("k",entranceScore.getK());
//                mapValue.put("l",entranceScore.getL());
//                listmap.add(mapValue);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return listmap;
//    }
//}
