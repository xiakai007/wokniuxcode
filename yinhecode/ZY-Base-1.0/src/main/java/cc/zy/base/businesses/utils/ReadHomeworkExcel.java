package cc.zy.base.businesses.utils;

import cc.zy.base.businesses.entity.ErrorLog;
import cc.zy.base.businesses.entity.Homework;
import cc.zy.base.businesses.entity.TermScore;
import cc.zy.base.businesses.mapper.HomeworkMapper;
import cc.zy.base.common.entity.FebsResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author wangpin
 * @date 2021/02/01
 * 读取Excel文件数据
 *
 */
@Slf4j
public class ReadHomeworkExcel {
    public static String REMARK="作业信息导入";

    public static FebsResponse readData(HomeworkMapper homeworkMapper,MultipartFile multipartFile) throws NoSuchFieldException, IllegalAccessException, IOException {
        File xlsFile = new File("H:/homework.xlsx");
        //将表中数据读到此集合中
        List<Homework> homeworks = new ArrayList<>();
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
                Homework homework = new Homework();


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
                    homework.setBatchName(batchName);
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
                    homework.setIdentity(identity);
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
                    homework.setStudyType(studyType);
                }
                //通过联合主键查询表中所需的关联id
                //查询学生表学生ID，确认学生表是否有此学生信息
                log.info("批次名"+homework.getBatchName());
                log.info("身份证号"+homework.getIdentity());
                log.info("学习形式"+homework.getStudyType());
                Integer studentId = homeworkMapper.getStudentIdByPrimery(homework);
                if (studentId!=null&&!studentId.equals("")){
                    homework.setStudentId(studentId);
                }else {
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("没有此学生信息！");
                    errorLogs.add(errorLog);
                }

                Integer yearNameIndex=(Integer) titleMap.get("学年");
                Cell yearNameCell = row.getCell(yearNameIndex);
                String yearName=null;
                if (yearNameCell==null||yearNameCell.equals("")){
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setErrorColumn(yearNameIndex+1);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("学年信息为空！");
                    errorLogs.add(errorLog);
                }else {
                    yearName = yearNameCell.getStringCellValue();
                    homework.setYearName(yearName);
                }

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
                    homework.setTermName(termName);
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
                    homework.setTel(tel);
                }

                Integer stuNameIndex=(Integer) titleMap.get("姓名");
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
                    homework.setStuName(stuName);
                }


                Integer courseIndex=(Integer) titleMap.get("科目");
                Cell courseCell = row.getCell(courseIndex);
                String course=null;
                if (courseCell==null||("").equals(courseCell)){
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setErrorColumn(courseIndex+1);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("科目信息为空！");
                    errorLogs.add(errorLog);
                }else {
                    course = courseCell.getStringCellValue();
                    homework.setCourseName(course);
                }

                Integer videoShIndex=(Integer) titleMap.get("线上视频总次数");
                Cell videoShCell = row.getCell(videoShIndex);
                String videoSh=null;
                if (videoShCell==null||("").equals(videoShCell)){
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setErrorColumn(videoShIndex+1);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("线上视频总次数为空！");
                    errorLogs.add(errorLog);
                }else {
                    videoSh = videoShCell.getStringCellValue();
                    homework.setVideoSh(Integer.parseInt(videoSh));
                }


                Integer videoAlIndex=(Integer) titleMap.get("线上视频已看次数");
                Cell videoAlCell = row.getCell(videoAlIndex);
                String videoAl=null;
                if (videoAlCell==null||("").equals(videoAlCell)){
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setErrorColumn(videoAlIndex+1);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("线上视频已看次数为空！");
                    errorLogs.add(errorLog);
                }else {
                    videoAl = videoAlCell.getStringCellValue();
                    homework.setVideoAl(Integer.parseInt(videoAl));
                }

                Integer videoScoreIndex=(Integer) titleMap.get("线上视频分数");
                Cell videoScoreCell = row.getCell(videoScoreIndex);
                String videoScore=null;
                if (videoScoreCell==null||("").equals(videoScoreCell)){
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setErrorColumn(videoScoreIndex+1);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("线上视频分数为空！");
                    errorLogs.add(errorLog);
                }else {
                    videoScore = videoScoreCell.getStringCellValue();
                    homework.setVideoScore(Integer.parseInt(videoScore));
                }

                Integer testShIndex=(Integer) titleMap.get("课后答题总次数");
                Cell testShCell = row.getCell(testShIndex);
                String testSh=null;
                if (testShCell==null||("").equals(testShCell)){
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setErrorColumn(testShIndex+1);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("课后答题总次数为空！");
                    errorLogs.add(errorLog);
                }else {
                    testSh = testShCell.getStringCellValue();
                    log.info("课后答题总次数"+testSh);
                    homework.setTestSh(Integer.parseInt(testSh));
                }

                Integer testAlIndex=(Integer) titleMap.get("课后答题已答次数");
                Cell testAlCell = row.getCell(testAlIndex);
                String testAl=null;
                if (testAlCell==null||("").equals(testAlCell)){
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setErrorColumn(testAlIndex+1);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("课后答题已答次数为空！");
                    errorLogs.add(errorLog);
                }else {
                    testAl = testAlCell.getStringCellValue();
                    homework.setTestAl(Integer.parseInt(testAl));
                }

                Integer testScoreIndex=(Integer) titleMap.get("课后答题分数");
                Cell testScoreCell = row.getCell(testScoreIndex);
                String testScore=null;
                if (testScoreCell==null||("").equals(testScoreCell)){
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setErrorColumn(testScoreIndex+1);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("课后答题分数为空！");
                    errorLogs.add(errorLog);
                }else {
                    testScore = testScoreCell.getStringCellValue();
                    homework.setTestScore(Integer.parseInt(testScore));
                }

                Integer wriShIndex=(Integer) titleMap.get("纸质作业总次数");
                Cell wriShCell = row.getCell(wriShIndex);
                String wriSh=null;
                if (wriShCell==null||("").equals(wriShCell)){
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setErrorColumn(wriShIndex+1);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("纸质作业总次数为空！");
                    errorLogs.add(errorLog);
                }else {
                    wriSh = wriShCell.getStringCellValue();
                    homework.setWriSh(Integer.parseInt(wriSh));
                }

                Integer wriAlIndex=(Integer) titleMap.get("纸质作业已完成次数");
                Cell wriAlCell = row.getCell(wriAlIndex);
                String wriAl=null;
                if (wriAlCell==null||("").equals(wriAlCell)){
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setErrorColumn(wriAlIndex+1);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("纸质作业已完成次数为空！");
                    errorLogs.add(errorLog);
                }else {
                    wriAl = wriAlCell.getStringCellValue();
                    homework.setWriAl(Integer.parseInt(wriAl));
                }

                Integer wriScoreIndex=(Integer) titleMap.get("纸质作业分数");
                Cell wriScoreCell = row.getCell(wriScoreIndex);
                String wriScore=null;
                if (wriScoreCell==null||("").equals(wriScoreCell)){
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setErrorColumn(wriScoreIndex+1);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("纸质作业分数为空！");
                    errorLogs.add(errorLog);
                }else {
                    wriScore = wriScoreCell.getStringCellValue();
                    homework.setWriScore(Integer.parseInt(wriScore));
                }

                Integer ispassNameIndex=(Integer) titleMap.get("是否通过（通过/未过）");
                Cell ispassNameCell = row.getCell(ispassNameIndex);
                String ispassName=null;
                if (ispassNameCell==null||("").equals(ispassNameCell)){
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setErrorColumn(ispassNameIndex+1);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("作业状态为空！");
                    errorLogs.add(errorLog);
                }else {
                    ispassName = ispassNameCell.getStringCellValue();
                    log.info(ispassName);
                    homework.setIspassName(ispassName);
                }

                Integer remarkIndex=(Integer) titleMap.get("备注");
                Cell remarkCell = row.getCell(remarkIndex);
                String remark=null;
                if (remarkCell==null||("").equals(remarkCell)){
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setErrorColumn(remarkIndex+1);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("成绩信息为空！");
                    errorLogs.add(errorLog);
                }else {
                    remark = remarkCell.getStringCellValue();
                    homework.setRemark(remark);
                }

                //设置行号
                homework.setRow(rowNum+1);
                homeworks.add(homework);
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
            return new FebsResponse().message("200").data(homeworks);
        }else {
            return new FebsResponse().message("400").data(errorLogs);
        }
    }
}
