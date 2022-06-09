package 数据结构.二叉树.leetcode;

/**
 * 平衡二叉树问题
 */
public class Num110_isBalancedTree {
    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     *
     * 本题中，一棵高度平衡二叉树定义为：
     * 递归一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
    //边界条件
        if (root == null){
        return true;
    }
        //判断当前以root为根节点的树是否满足平衡条件
        int left = height(root.left);
        int right =height(root.right);
        int abs = Math.abs(left-right);
        //平衡树的左右子树高度差不能大于1
        if (abs >1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    //计算树高的方法
    private int height(TreeNode root) {
        if ( root ==null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        int max = Math.max(left,right);
        return 1+max;
    }
}
