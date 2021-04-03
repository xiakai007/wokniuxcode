package cc.zy.base.businesses.utils;

import cc.zy.base.businesses.entity.EntranceScore;
import cc.zy.base.businesses.entity.ErrorLog;
import cc.zy.base.businesses.entity.TermScore;
import cc.zy.base.businesses.service.IEntranceScoreService;
import cc.zy.base.common.entity.FebsResponse;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author wangpin
 * @date 2021/02/01
 * 读取Excel文件数据
 *
 */
public class ReadTermExcel {
    public static String REMARK="学期成绩导入";
    public static FebsResponse readData(MultipartFile multipartFile) throws NoSuchFieldException, IllegalAccessException, IOException {
        File xlsFile = new File("H:/termScore.xlsx");
        //将表中数据读到此集合中
        List<TermScore> termScores = new ArrayList<>();
        //记录错误日志
        List<ErrorLog> errorLogs = new ArrayList<>();
        //将表头信息和对应列数放入map集合中
        Map<String, Object> titleMap = new HashMap<>();
        InputStream inputStream = multipartFile.getInputStream();
        System.out.println(multipartFile.getName());
        //获取一个UUID作为当次操作日志记录的唯一标记
        String unique = UUID.randomUUID().toString();
        // 工作表
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        // 表个数。
        int numberOfSheets = workbook.getNumberOfSheets();
        // 遍历表。
        for (int i1 = 0; i1 < numberOfSheets; i1++) {

            Sheet sheet = workbook.getSheetAt(i1);
            // Excel第一行。
            Row temp = sheet.getRow(0);
            if (temp == null) {
                continue;
            }
            // 读数据。
            //4、循环读取表格数据
            for (Row row : sheet) {
                int columNos = row.getLastCellNum();// 表头总共的列数
                //目前读取的行数
                int rowNum = row.getRowNum();
                //首行（即表头）不读取
                if (rowNum == 0) {
                    for (int i = 0; i <= columNos; i++) {
                        Cell cell = row.getCell(i);
                        if(cell != null){
                            cell.setCellType(CellType.STRING);
                            titleMap.put(cell.getStringCellValue(),i);
                        }
                    }

                    continue;
                }
                for (Cell cell : row) {
                    cell.setCellType(CellType.STRING);
                }
                TermScore termScore = new TermScore();

                //读取当前行中单元格数据，索引从0开始
                /**
                 * 获取模板中的学生基本信息
                 */
                Integer batchNameIndex=(Integer) titleMap.get("批次");
                String batchName=null;
                Cell batchNameCell = row.getCell(batchNameIndex);
                if (batchNameCell==null||batchNameCell.equals("")){
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setErrorColumn(batchNameIndex+1);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("批次信息为空！");
                    errorLogs.add(errorLog);
                }else {
                    batchName = batchNameCell.getStringCellValue();
//                    System.out.println(batchName);
                    termScore.setBatchName(batchName);
                }
                Integer identityIndex=(Integer) titleMap.get("身份证");
//                System.out.println(identityIndex);
                Cell identityCell = row.getCell(identityIndex);
                String identity=null;
                if (identityCell==null||identityCell.equals("")){
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setErrorColumn(identityIndex+1);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("身份证信息为空！");
                    errorLogs.add(errorLog);
                }else {
                    identity = identityCell.getStringCellValue();
                    termScore.setIdentity(identity);
                }
                Integer studyTypeIndex=(Integer) titleMap.get("学习形式");
                Cell studtyTypeCell = row.getCell(studyTypeIndex);
                String studyType=null;
                if (studtyTypeCell==null||studtyTypeCell.equals("")){
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setErrorColumn(studyTypeIndex+1);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("学习形式为空！");
                    errorLogs.add(errorLog);
                }else {
                    studyType = studtyTypeCell.getStringCellValue();

                    termScore.setStudyType(studyType);
                }
                //通过联合主键查询表中所需的关联id

                Integer termNameIndex=(Integer) titleMap.get("学期");
                Cell termNameCell = row.getCell(termNameIndex);
                String termName=null;
                if (termNameCell==null||termNameCell.equals("")){
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setErrorColumn(termNameIndex+1);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("学期信息为空！");
                    errorLogs.add(errorLog);
                }else {
                    termName = termNameCell.getStringCellValue();
                    termScore.setTermName(termName);
                }

                Integer telIndex=(Integer) titleMap.get("电话");
                Cell telCell = row.getCell(telIndex);
                String tel=null;
                if (telCell==null||telCell.equals("")){
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setErrorColumn(telIndex+1);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("电话信息为空！");
                    errorLogs.add(errorLog);
                }else {
                    tel = telCell.getStringCellValue();
                    termScore.setTel(tel);
                }
                Integer stuNameIndex=(Integer) titleMap.get("学生姓名");
                Cell stuNameCell = row.getCell(stuNameIndex);
                String stuName=null;
                if (stuNameCell==null||("").equals(stuNameCell)){
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setErrorColumn(stuNameIndex+1);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("学生姓名信息为空！");
                    errorLogs.add(errorLog);
                }else {
                    stuName = stuNameCell.getStringCellValue();
                    termScore.setStuName(stuName);
                }

                Integer collegeIndex=(Integer) titleMap.get("院校");
                Cell collegeCell = row.getCell(collegeIndex);
                String collegeName=null;
                if (collegeCell==null||("").equals(collegeCell)){
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setErrorColumn(collegeIndex+1);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("院校信息为空！");
                    errorLogs.add(errorLog);
                }else {
                    collegeName = collegeCell.getStringCellValue();
                    termScore.setCollegeName(collegeName);
                }

                Integer levelIndex=(Integer) titleMap.get("层次");
                Cell levelCell = row.getCell(levelIndex);
                String level=null;
                if (levelCell==null||("").equals(levelCell)){
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setErrorColumn(levelIndex+1);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("层次信息为空！");
                    errorLogs.add(errorLog);
                }else {
                    level = levelCell.getStringCellValue();
                    termScore.setLevelName(level);
                }

                Integer majorIndex=(Integer) titleMap.get("专业");
                Cell majorCell = row.getCell(majorIndex);
                String major=null;
                if (majorCell==null||("").equals(majorCell)){
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setErrorColumn(majorIndex+1);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("层次信息为空！");
                    errorLogs.add(errorLog);
                }else {
                    major = majorCell.getStringCellValue();
                    termScore.setMajorName(major);
                }

                Integer courseIndex=(Integer) titleMap.get("课程");
                Cell courseCell = row.getCell(courseIndex);
                String course=null;
                if (courseCell==null||("").equals(courseCell)){
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setErrorColumn(courseIndex+1);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("课程信息为空！");
                    errorLogs.add(errorLog);
                }else {
                    course = courseCell.getStringCellValue();
                    termScore.setCourseName(course);
                }

                Integer isExamIndex=(Integer) titleMap.get("考察课");
                Cell isExamCell = row.getCell(isExamIndex);
                String isExam=null;
                if (isExamCell==null||("").equals(isExamCell)){
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setErrorColumn(courseIndex+1);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("考察课信息为空！");
                    errorLogs.add(errorLog);
                }else {
                    isExam = isExamCell.getStringCellValue();
                    if (isExam.equals("统考")){
                        isExam="1";
                    }else if (isExam.equals("自助考")){
                        isExam="2";
                    }else {
                        ErrorLog errorLog = new ErrorLog();
                        errorLog.setErrorRow(rowNum+1);
                        errorLog.setErrorColumn(courseIndex+1);
                        errorLog.setRemark(REMARK);
                        errorLog.setUnique(unique);
                        errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                        errorLog.setReason("考察课信息输入有误！（统考/自助考）");
                        errorLogs.add(errorLog);
                    }
                    termScore.setIsexam(isExam);
                }

                Integer scoreIndex=(Integer) titleMap.get("成绩");
                Cell scoreCell = row.getCell(scoreIndex);
                String score=null;
                if (scoreCell==null||("").equals(scoreCell)){
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setErrorColumn(scoreIndex+1);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("成绩信息为空！");
                    errorLogs.add(errorLog);
                }else {
                    score = scoreCell.getStringCellValue();
                    termScore.setScore(Integer.parseInt(score));
                }

                Integer statusIndex=(Integer) titleMap.get("考试状态");
                Cell statusCell = row.getCell(statusIndex);
                String status=null;
                if (statusCell==null||("").equals(statusCell)){
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setErrorColumn(statusIndex+1);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("考试状态信息为空！");
                    errorLogs.add(errorLog);
                }else {
                    status = statusCell.getStringCellValue();
                    if (status.equals("通过")){
                        status="1";
                    }else if (status.equals("未过")){
                        status="2";
                    }else if (status.equals("缺考")){
                        status="3";
                    }else if (status.equals("其他")){
                        status="4";
                    }else {
                        ErrorLog errorLog = new ErrorLog();
                        errorLog.setErrorRow(rowNum+1);
                        errorLog.setErrorColumn(statusIndex+1);
                        errorLog.setRemark(REMARK);
                        errorLog.setUnique(unique);
                        errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                        errorLog.setReason("考察课信息输入有误！（统考/自助考）");
                        errorLogs.add(errorLog);
                    }

                    termScore.setStatus(status);
                }
                //设置行号
                termScore.setRow(rowNum+1);
                termScores.add(termScore);
            }
            //5、关闭流
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //判断是否有错误
        if (errorLogs==null||errorLogs.isEmpty()){
            return new FebsResponse().message("200").data(termScores);
        }else {
            return new FebsResponse().message("400").data(errorLogs);
        }
    }
}
