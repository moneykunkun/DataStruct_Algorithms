package 数据结构.二叉树.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qk
 * @date 2022年03月02日 17:53
 */

public class Num94_inOrder {
    /**
     * @author qk
     * @date 2022/3/2 17:53
     * 二叉树的中序遍历:左-根-右
     */
    List<Integer> ret = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
    //边界条件
        if(root == null){
            return ret;
        }
        inorderTraversal(root.left);
        ret.add(root.val);
        inorderTraversal(root.right);
        return ret;
    }
}
