package 数据结构.二叉树.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Num144_preOrderNonRecursion {
    //二叉树的前序遍历，迭代写法
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if ( root == null){
            return ret;
        }
        //先访问的节点要后压入栈
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            //先访问根节点
            ret.add(cur.val);
            //再访问右孩子
            if (cur.right != null){
                stack.push(cur.right);
            }
            //最后访问左孩子
            if (cur.left != null){
                stack.push(cur.left);
            }
        }
        return ret;
    }
}
