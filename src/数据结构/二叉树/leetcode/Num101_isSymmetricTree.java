package 数据结构.二叉树.leetcode;

/**
 * 对称二叉树问题
 */
public class Num101_isSymmetricTree {
    /**
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     * @param root
     * 树中节点数目在范围 [1, 1000] 内
     * -100 <= Node.val <= 100
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
    //边界条件
       if (root == null){
           return true;
       }
       return isMrror(root.left,root.right);
    }

    /**
     * 判断左右子树是否是镜像关系
     * @param left
     * @param right
     * @return
     */
    private boolean isMrror(TreeNode left, TreeNode right) {
        if (left == null && right ==null){
            return true;
        }
        if (left ==null || right ==null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        //left的左树要和right的右树相等 && left的右树要和right的左树镜像相等
        return isMrror(left.left,right.right) &&isMrror(left.right,right.left);
    }
}
