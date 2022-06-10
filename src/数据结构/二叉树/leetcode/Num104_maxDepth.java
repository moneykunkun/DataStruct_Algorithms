package 数据结构.二叉树.leetcode;

/**
 * @author qk
 * @date 2022年03月02日 18:15
 */
public class Num104_maxDepth {
    /**
     * @author qk
     * @date 2022/3/2 18:16
     * 给定一个二叉树，找出其最大深度
     */
    public int maxDepth(TreeNode root) {
    if ( root == null){
        return 0;
    }
   int  leftDepth = maxDepth(root.left);
    int  rightDepth = maxDepth(root.right);
    int max = Math.max(leftDepth,rightDepth);
    return max+1;
    }
}
