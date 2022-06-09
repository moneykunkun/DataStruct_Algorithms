package 数据结构.二叉树.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qk
 * @date 2022年03月02日 18:02
 */
public class Num145_postOrder {
   /**
    * @author qk
    * @date 2022/3/2 18:03
    * 二叉树的后序遍历:左-右-根
    */
   List<Integer> ret =new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
    //边界条件
        if ( root == null){
            return ret;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        ret.add(root.val);
        return ret;
    }
}
