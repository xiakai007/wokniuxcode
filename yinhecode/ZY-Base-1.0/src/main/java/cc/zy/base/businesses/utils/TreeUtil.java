package cc.zy.base.businesses.utils;


import cc.zy.base.businesses.entity.CType;
import cc.zy.base.businesses.entity.CTypeTree;
import cc.zy.base.common.entity.DeptTree;
import cc.zy.base.common.entity.MenuTree;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MrBird
 */
public abstract class TreeUtil {

    private static final String TOP_NODE_ID = "0";

    public static <T> List<CTypeTree<T>> buildCTypeTree(List<CTypeTree<T>> nodes) {
        if (nodes == null) {
            return null;
        }
        List<CTypeTree<T>> result = new ArrayList<>();
        nodes.forEach(children -> {
            String pid = children.getParentId();
            if (pid == null || TOP_NODE_ID.equals(pid)) {
                result.add(children);
                return;
            }
            for (CTypeTree<T> n : nodes) {
                String id = n.getId();
                if (id != null && id.equals(pid)) {
                    if (n.getChildren() == null) {
                        n.initChildren();
                    }
                    n.getChildren().add(children);
                    children.setHasParent(true);
                    n.setHasChild(true);
                    return;
                }
            }
        });
        return result;
    }
//    public static <T> List<CourseTree<T>> buildCourseTree(List<CourseTree<T>> nodes) {
//        if (nodes == null) {
//            return null;
//        }
//        List<CourseTree<T>> result = new ArrayList<>();
//        nodes.forEach(children -> {
//            String pid = children.getParentId();
//            if (pid == null || TOP_NODE_ID.equals(pid)) {
//                result.add(children);
//                return;
//            }
//            for (CourseTree<T> n : nodes) {
//                String id = n.getId();
//                if (id != null && id.equals(pid)) {
//                    if (n.getChildren() == null) {
//                        n.initChildren();
//                    }
//                    n.getChildren().add(children);
//                    children.setHasParent(true);
//                    n.setHasChild(true);
//                    return;
//                }
//            }
//        });
//
//        return result;
//    }
}