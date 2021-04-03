package cc.zy.base.common.utils;


import cc.zy.base.system.entity.Dept;
import cc.zy.base.system.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 节点结构
 *
 * @author LiuHeng
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {
    //节点id
    public Long id;
    //节点名称
    public String name;
    //是否展开
    public boolean open = false;
    //父节点id
    private Long pid;
    //是否是非叶子节点
    public boolean parent = true;
    //设置为null即为根节点
    public List<TreeNode> children = new ArrayList<TreeNode>();

    /**
     * 部门节点
     *
     * @param dept
     * @author liuheng
     */
    public TreeNode(Dept dept){
        this.id =  dept.getDeptId();
        this.pid = dept.getParentId();
        this.name = dept.getDeptName();
        this.open = true;
        this.parent = true;
    }

    /**
     * 用户节点
     *
     * @param user
     * @author liuheng
     */
    public TreeNode(User user){
        this.id =  user.getUserId();
        this.pid = user.getDeptId();
        this.name = user.getUsername();
        this.open = false;
        this.parent = false;
    }
}

