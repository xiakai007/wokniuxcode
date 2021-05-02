package com.woniu.springboot.admin.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 导航菜单
 */
@Data
public class NavNode {
    private Integer id;
    /**
     * 当前菜单的父节点
     */
    private Integer pid;
    private String title;
    private String icon;
    private String href;
    private boolean spread;
    private List<NavNode> children=new ArrayList<>();
}
