package 数据结构.二叉树.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的完全性检验
 */
public class Num958_isCompleteTree {
    /**
     * 解题思路：引入标记位区分二叉树的状态
     * 状态切换:    状态一：切换条件：1.当碰到第一个只有左树没有右树的节点；2.碰到第一个叶子节点
     *                    状态二:  位于状态二的节点全是叶子节点
     * @param root
     * @return
     */
    public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isSecondStep = false;
         //循环条件
        while (! queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (!isSecondStep){    //状态一
                if (cur.left != null && cur.right != null){
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }else if(cur.left != null) {
                    //只有左树时，切换状态
                    isSecondStep = true;
                    queue.offer(cur.left);
                }else if (cur.right != null){
                    //只有右树
                    return false;
                }else {
                    //第一个叶子节点的情况
                    isSecondStep = true;
                }
            }else {
                //此时为状态2，所有的节点都必须时叶子节点，否则返回false
                if (cur.left != null || cur.right != null){
                    return false;
                }
            }
        }
        return true;
    }
}
