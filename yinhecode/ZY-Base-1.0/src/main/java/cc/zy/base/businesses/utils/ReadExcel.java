package cc.zy.base.businesses.utils;

import cc.zy.base.businesses.entity.EntranceScore;
import cc.zy.base.businesses.entity.ErrorLog;
import cc.zy.base.businesses.service.IEntranceScoreService;
import cc.zy.base.common.entity.FebsResponse;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.*;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author wangpin
 * @date 2021/02/01
 * 读取Excel文件数据
 *
 */
public class ReadExcel {
    private static String REMARK="入学成绩导入";
    public static FebsResponse readData(IEntranceScoreService iEntranceScoreService,MultipartFile multipartFile) throws NoSuchFieldException, IllegalAccessException, IOException {
        File xlsFile = new File("H:/775.xlsx");
        List<EntranceScore> entranceScores = new ArrayList<>();
        List<ErrorLog> errorLogs = new ArrayList<>();
        List<EntranceScore> dataTable = new ArrayList<>();
        InputStream inputStream = multipartFile.getInputStream();
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
                //目前读取的行数
                int rowNum = row.getRowNum();
                //首行（即表头）不读取
                if (rowNum == 0) {
                    continue;
                }
                for (Cell cell : row) {
                    cell.setCellType(CellType.STRING);
                }
                EntranceScore score = new EntranceScore();
                //读取当前行中单元格数据，索引从0开始

                String levelName = row.getCell(5).getStringCellValue();
                if (levelName==null||levelName.equals("")){
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setErrorColumn(6);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("层次信息为空！");
                    errorLogs.add(errorLog);
                }
                String subtypeName = row.getCell(6).getStringCellValue();
                if (subtypeName==null||subtypeName.equals("")){
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setErrorColumn(7);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("类别信息为空！");
                    errorLogs.add(errorLog);
                }
                //设置课程
                //通过层次和科目类别查询所需要考察的科目别名以及科目所在模板的列号
                    List<EntranceScore> aliasAndNum = iEntranceScoreService.getSubjectsAliasAndNum(levelName, subtypeName);
                    if (aliasAndNum==null||aliasAndNum.isEmpty()){
                        ErrorLog errorLog = new ErrorLog();
                        System.out.println("第"+rowNum+"行层次和类别项目填写有误");
                        errorLog.setErrorRow(rowNum);
                        errorLog.setErrorColumn(5&6);
                        errorLog.setRemark(REMARK);
                        errorLog.setUnique(unique);
                        errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                        errorLog.setReason("层次和类别数据不规范");
                        errorLogs.add(errorLog);
                    }
                    //获取当前对象的Class类
                    Class aClass = score.getClass();
                    //循环遍历科目以及通过反射机制获取对应科目在对象中的属性，并读取对应科目在模板中的值，设置为对应属性的值
                    for (EntranceScore entranceScore : aliasAndNum) {
                        Field field = aClass.getDeclaredField(entranceScore.getAlias());
                        field.setAccessible(true);
                        Integer num = entranceScore.getNum();
                        System.out.println(num);
                        Cell cell = row.getCell(entranceScore.getNum());
                        System.out.println(cell);
                        if (cell==null||cell.equals("")||cell.equals("null")){
                            ErrorLog errorLog = new ErrorLog();
                            errorLog.setErrorRow(rowNum+1);
                            errorLog.setRemark(REMARK);
                            errorLog.setUnique(unique);
                            errorLog.setErrorColumn(entranceScore.getNum()+1);
                            errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                            errorLog.setReason("单科成绩为空或格式不正确");
                            errorLogs.add(errorLog);
                        }else {
                            //设置单元格类型
                            cell.setCellType(CellType.STRING);
                            String value = cell.getStringCellValue();
                            if (value!=null||!value.equals("")){
                                field.set(score, value);
                            }else {
                                ErrorLog errorLog = new ErrorLog();
                                errorLog.setErrorRow(rowNum+1);
                                errorLog.setRemark(REMARK);
                                errorLog.setUnique(unique);
                                errorLog.setErrorColumn(entranceScore.getNum()+1);
                                errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                                errorLog.setReason("成绩为空或格式不正确");
                                errorLogs.add(errorLog);
                            }
                        }

                    }
                /**
                 * 获取模板中的学生基本信息
                 */
                String batchName=null;
                Cell batchNameCell = row.getCell(1);
                if (batchNameCell==null||batchNameCell.equals("")){
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setErrorColumn(2);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("批次信息为空！");
                    errorLogs.add(errorLog);
                }else {
                    batchName = batchNameCell.getStringCellValue();
                    score.setBatchName(batchName);
                }
                Cell stuNameCell = row.getCell(2);
                String stuName=null;
                if (stuNameCell==null||stuNameCell.equals("")){
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setErrorColumn(3);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("学生姓名为空！");
                    errorLogs.add(errorLog);
                }else {
                    stuName = stuNameCell.getStringCellValue();
                    score.setStuName(stuName);
                }
                Cell identityCell = row.getCell(3);
                String identity=null;
                if (identityCell==null||identityCell.equals("")){
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setErrorColumn(4);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("身份证号为空！");
                    errorLogs.add(errorLog);
                }else {
                    identity = identityCell.getStringCellValue();
                    score.setIdentity(identity);
                }
                Cell collegeNameCell = row.getCell(4);
                String collegeName=null;
                if (collegeNameCell==null||collegeNameCell.equals("")){
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setErrorColumn(5);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("院校名称为空！");
                    errorLogs.add(errorLog);
                }else {
                    collegeName = collegeNameCell.getStringCellValue();
                    score.setCollegeName(collegeName);
                }
                Cell addscoreitemCell = row.getCell(9);
                String addscoreitem=null;
                if (addscoreitemCell!=null||!addscoreitemCell.equals("")){
                    addscoreitem=addscoreitemCell.getStringCellValue();
                    score.setAddscoreitem(addscoreitem);
                }
                Cell totalscoreCell = row.getCell(7);
                String totalscore=null;
                if (totalscoreCell!=null||!totalscoreCell.equals("")){
                    totalscore=totalscoreCell.getStringCellValue();
                    System.out.println("总成绩totalsore"+totalscore);
                    score.setTotalscore(totalscore);
                }
                Cell finalscoreCell = row.getCell(8);
                String finalscore=null;
                if (finalscoreCell!=null||!finalscoreCell.equals("")){
                    finalscore=finalscoreCell.getStringCellValue();
                    System.out.println("总成绩FINALScore"+totalscore);
                    score.setFinalscore(finalscore);
                }
                score.setLevelName(levelName);
                score.setFullName(subtypeName);
                score.setFullName(subtypeName);
                //通过获取到的数据，转换为其ID值，准备插入entranceScore表中

                List<EntranceScore> entranceIds = iEntranceScoreService.getEntranceIds(levelName, subtypeName, batchName);

                List<EntranceScore> list = iEntranceScoreService.checkUnique(identity, batchName);

                //插入数据
                if (list==null||list.isEmpty()){
                    for (EntranceScore entranceId : entranceIds) {
                        entranceId.setIdentity(identity);
                        //获取当前别名的属性
                        Field field = aClass.getDeclaredField(entranceId.getAlias());
                        field.setAccessible(true);
                        //获取当前属性的值(当前科目的成绩)
                        String sc =String.valueOf(field.get(score));

                        //先判断数据库是否有同批次的同一个人
                        EntranceScore entranceScore = new EntranceScore();
                        entranceScore.setBatchId(entranceId.getBatchId());
                        entranceScore.setIdentity(identity);
                        if (sc.equals("null")){
                            System.out.println("sc为null");
                            entranceScore.setScore(null);
                        }else {
                            entranceScore.setScore(Integer.parseInt(sc));
                        }
                        entranceScore.setSubtypeId(entranceId.getSubtypeId());
                        entranceScore.setSubjectId(entranceId.getSubjectId());
                        entranceScore.setLevelId(entranceId.getLevelId());
//                        int i = iEntranceScoreService.insertEntrance(entranceId, sc);
                        entranceScore.setAddscoreitem(addscoreitem);
                        entranceScore.setFinalscore(finalscore);
                        entranceScore.setTotalscore(totalscore);
                        dataTable.add(entranceScore);
                    }
                    System.out.println("添加成功");
                }else {
                    ErrorLog errorLog = new ErrorLog();
                    errorLog.setErrorRow(rowNum+1);
                    errorLog.setRemark(REMARK);
                    errorLog.setUnique(unique);
                    errorLog.setCreateTime(new Date(System.currentTimeMillis()));
                    errorLog.setReason("该学生信息已存在");
                    errorLogs.add(errorLog);
                    System.out.println("添加失败");
                }

                entranceScores.add(score);
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
            return new FebsResponse().message("200").data(dataTable);
        }else {
            return new FebsResponse().message("400").data(errorLogs);
        }
    }
}
