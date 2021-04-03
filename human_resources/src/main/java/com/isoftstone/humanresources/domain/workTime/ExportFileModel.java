package com.isoftstone.humanresources.domain.workTime;

import org.apache.poi.ss.formula.functions.T;

import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;

public class ExportFileModel {

    private String excelName;
    private List<Object> list;
    private LinkedHashMap<String, String> fieldMap ;

    public String getExcelName() {
        return excelName;
    }

    public void setExcelName(String excelName) {
        this.excelName = excelName;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public LinkedHashMap<String, String> getFieldMap() {
        return fieldMap;
    }

    public void setFieldMap(LinkedHashMap<String, String> fieldMap) {
        this.fieldMap = fieldMap;
    }
}
