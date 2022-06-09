package 数据结构.二叉树.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归遍历二叉树的前序遍历
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class Num144_preOrder {
    //此时的前序遍历是将遍历的结果存入list集合中
    List<Integer> ret =new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
    //边界条件
        if (root == null){
        return ret;
    }
        ret.add(root.val);      //将根节点的值存入list集合中
        preorderTraversal(root.left);   //递归遍历左子树
        preorderTraversal(root.right);  //递归遍历右子树
    return ret;
    }
}
