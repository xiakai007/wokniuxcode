package com.isoftstone.humanresources.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.piccolo.io.FileFormatException;
public class ExcelUtil {
    /***
     * <pre>
     * 读取文件
     *   xls:HSSFWorkbook
     *   xlsx：XSSFWorkbook
     * &#64;param filePath
     * &#64;return
     * &#64;throws IOException
     * </pre>
     */
    public static Workbook getWorkbook(String filePath) throws IOException
    {
        Workbook workbook = null;
        InputStream is = new FileInputStream(filePath);
        if (filePath.endsWith(CommonConstant.EXTENSION_XLS))
        {
            workbook = new HSSFWorkbook(is);
        }
        else if (filePath.endsWith(CommonConstant.EXTENSION_XLSX))
        {
            workbook = new XSSFWorkbook(is);
        }
        return workbook;
    }

    /**
     *
     * @param filePath
     * @throws FileNotFoundException
     * @throws FileFormatException
     */
    public static void preReadCheck(String filePath) throws FileNotFoundException
    {
        // 常规
        File file = new File(filePath);
        if (!file.exists())
        {
            throw new FileNotFoundException("传入的文件不存在?" + filePath);
        }

        if (!(filePath.endsWith(CommonConstant.EXTENSION_XLS) || filePath.endsWith(CommonConstant.EXTENSION_XLSX)))
        {
            throw new FileNotFoundException("传入的文件不是excel");
        }
    }

    /**
     * 取单元格
     *
     * @param cell
     *            单元格对
     * @param treatAsStr
     *            为true时，当做文本来取 (取到的是文本，不会把�?1”取成�??1.0�?)
     * @return
     */
    public static String getCellValue(Cell cell, boolean treatAsStr)
    {
        if (cell == null)
        {
            return "";
        }

        if (treatAsStr)
        {
            // 虽然excel中设置的都是文本，但是数字文本还被读错，如�??1”取成�??1.0�?
            // 加上下面这句，临时把它当做文本来读取
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }

        if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN)
        {
            return String.valueOf(cell.getBooleanCellValue());
        }
        else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
        {
            if (HSSFDateUtil.isCellDateFormatted(cell))
            {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                return sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue())).toString();
            }
            else
            {
                return "";
            }
        }
        else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
        {
            return String.valueOf(cell.getNumericCellValue());
        }
        else if (cell.getCellType() == Cell.CELL_TYPE_STRING)
        {
            return String.valueOf(cell.getStringCellValue());
        }
        else
        {
            return "";
        }
    }
    /**
     * 设置单元格样式
     *
     * @param workbook
     * @return
     */
    public static HSSFCellStyle getHSSFStyle(HSSFWorkbook workbook)
    {
        HSSFCellStyle style = workbook.createCellStyle();
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        return style;
    }

}
