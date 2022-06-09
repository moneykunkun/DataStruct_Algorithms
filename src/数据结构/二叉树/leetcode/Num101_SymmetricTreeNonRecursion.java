package 数据结构.二叉树.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断是否是对称二叉树
 * 迭代写法
 */
public class Num101_SymmetricTreeNonRecursion {
    /**
     * 非递归的方式判断是否是对称二叉树
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        //先将根节点的左右子树入队
        queue.offer(root.left);
        queue.offer(root.right);
        while (! queue.isEmpty()){
            //一次取出两个节点，这两个节点就是两颗子树的根节点
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if ( t1 == null && t2 == null){
                //左右两颗子树都是空树，继续后面的判断
                continue;
            }
            //如果有有一颗子树为空，则
            if ( t1 ==null || t2 ==null){
                return false;
            }
            //判断节点的值是否相等
            if (t1.val != t2.val){
                return false;
            }
            //此时，两颗子树都不为空且根节点的值是相等的，继续判断t1.left 和t2.right 以及t1.right和t2.left
            queue.offer(t1.left);
            queue.offer(t2.right);
            //再入队另一组元素
            queue.offer(t1.right);
            queue.offer(t2.left);
        }
        return true;
    }
}
