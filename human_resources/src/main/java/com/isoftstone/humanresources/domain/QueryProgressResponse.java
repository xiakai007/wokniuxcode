package com.isoftstone.humanresources.domain;

import java.util.List;

/**
 * 查询备份进度的封装实体对象
 */
public class QueryProgressResponse implements Comparable<QueryProgressResponse> {
    public String name;          //组织名称
    public String value;        //组织数值
    public List<EmployeeBackups> list; //备份列表
    public String getName() {
        return name;
    }

    public List<EmployeeBackups> getList() {
        return list;
    }

    public void setList(List<EmployeeBackups> list) {
        this.list = list;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    @Override
    public int compareTo(QueryProgressResponse ob) {
        return value.compareTo(ob.getValue());

    }
}
