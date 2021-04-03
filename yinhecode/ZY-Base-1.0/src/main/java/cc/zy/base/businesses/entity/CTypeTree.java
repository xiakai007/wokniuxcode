package cc.zy.base.businesses.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 *  tree
 *
 * @author quxiaolong
 * @date 2021-01-26 11:45:08
 */
@Data
public class CTypeTree<T>implements Serializable {
    private static final long serialVersionUID = 7681873362531265829L;
    private String id;
    private String icon;
    private String href;
    private String name;
    private Map<String, Object> state;
    private boolean checked = false;
    private Map<String, Object> attributes;
    private List<CTypeTree<T>> children;
    private String parentId;
    private boolean hasParent = false;
    private boolean hasChild = false;

    private CType data;

    public void initChildren(){
        this.children = new ArrayList<>();
    }
}
