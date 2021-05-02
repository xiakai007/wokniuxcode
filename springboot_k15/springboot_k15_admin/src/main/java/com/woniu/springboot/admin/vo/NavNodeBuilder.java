package com.woniu.springboot.admin.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 构造菜单的层级管理
 */
public class NavNodeBuilder {
    public static List<NavNode> build(List<NavNode> navNodeList,Integer topId){
        List<NavNode> navNodes=new ArrayList<>();
        if (navNodeList != null) {
            for (NavNode node1 : navNodeList) {
                //将一级节点放入集合navNodes中
                if (node1.getPid() == topId) {
                    navNodes.add(node1);
                }
                for (NavNode node2 : navNodeList) {
                    //将二级节点放入一级节点中
                    if (node1.getId() == node2.getPid()) {
                        node1.getChildren().add(node2);
                    }
                }
            }
        }
        return navNodes;
    }
}
