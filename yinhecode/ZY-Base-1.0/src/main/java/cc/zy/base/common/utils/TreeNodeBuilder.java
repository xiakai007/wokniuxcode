package cc.zy.base.common.utils;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 构建树，用于页面树形下拉框组件
 *
 * @author LiuHeng
 */
@Slf4j
public class TreeNodeBuilder {
    /**
     * 传入符合条件的节点递归构建树
     *
     * @param nodeList
     * @param topId
     * @return
     * @author liuheng
     */
    public static List<TreeNode> builder(List<TreeNode> nodeList, Long topId) {
        List<TreeNode> treeNodeList = new ArrayList<>();
        for (TreeNode treeNode : nodeList) {
            if (topId.equals(treeNode.getPid())) {
                treeNodeList.add(treeNode);
                if (treeNode.isParent())
                    treeNode.setChildren(builder(nodeList, treeNode.getId()));
                else
                    treeNode.setChildren(null);
            }
        }
        return treeNodeList;
    }
}
